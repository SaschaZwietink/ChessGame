package main.java.GameLogic;

import main.java.Pieces.*;
import main.java.Players.Player;

import java.util.LinkedList;
import java.util.List;

/**
 * Main game class that handles move's and turns
 */
public class Game {
    private final List<Player> players;
    private final GameBoard gameBoard;
    private Player currentTurn;
    private final List<Move> movesPlayed;
    private Piece finalPromPiece = null;

    public Game(Player p1, Player p2, GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        movesPlayed = new LinkedList<>();
        players = new LinkedList<>();
        players.add(p1);
        players.add(p2);

        if(players.get(0).isWhiteSide()){
            currentTurn = players.get(0);
        }else{
            currentTurn = players.get(1);
        }
    }

    /**
     * this method plays a move
     * @param newMove a move with start location, end location and a player
     */
    public void playMove(Move newMove){
        if(movePossible(newMove)) {
            Piece pieceMoving = newMove.getStart().getPiece();
            int startX = newMove.getStart().getX();
            int startY = newMove.getStart().getY();
            int endX = newMove.getEnd().getX();
            int endY = newMove.getEnd().getY();

            System.out.println(pieceMoving.getName() + ": (" + startX + "," + startY + ") -> (" + endX + "," + endY + ")");
            newMove.getStart().setPiece(null);
            newMove.getEnd().setPiece(pieceMoving);

            //TODO can this part be better?
            Location[][] tempLocations = gameBoard.getLocations();
            tempLocations[startX][startY] = new Location(startX, startY, null);
            tempLocations[endX][endY] = new Location(startX, startY, pieceMoving);
            gameBoard.setLocations(tempLocations);


            //TODO game needs to wait for choose to be made
            if(pieceMoving.getName().equals("P")&&pieceMoving.getSpecial()){
                Thread pawnPromotionThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Hello");
                        PawnPromotion pawnPromotion = new PawnPromotion();
                        Piece promPiece = null;
                        switch (pawnPromotion.getFinalChoose()){
                            case 0 -> promPiece = new QueenPiece(pieceMoving.isWhite());
                            case 1 -> promPiece = new BishopPiece(pieceMoving.isWhite());
                            case 2 -> promPiece = new RookPiece(pieceMoving.isWhite());
                            case 3 -> promPiece = new KnightPiece(pieceMoving.isWhite());
                        }
                        setFinalPromPiece(promPiece);
                        Thread.currentThread().interrupt();
                    }
                });

                pawnPromotionThread.start();
                try {
                    Thread.currentThread().join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println(pieceMoving.getName());
                gameBoard.getLocation(endX,endY).setPiece(finalPromPiece);
            }
            movesPlayed.add(newMove);
            nextTurn();
        }else{
            System.out.println("Can not do this move");
        }

    }

    /**
     * this method checks if it's possible to move this move
     * @param newMove a move with start location, end location and a player
     * @return false if movement is not possible or true if movement is possible
     */
    //TODO maybe separate isTurn and allowed movement?
    private boolean movePossible(Move newMove){
        if(newMove.getPlayer() != currentTurn){
            System.out.println("Its not your turn");
            return false;
        }
        Piece pieceMoving = newMove.getStart().getPiece();
        return pieceMoving.canMove(gameBoard, newMove.getStart(), newMove.getEnd());
    }

    /**
     * this method sets the next turn to the other player
     */
    public void nextTurn(){
        currentTurn = players.get((players.indexOf(currentTurn)+1)% players.size());
    }

    /**
     * a getter method for the current turn
     * @return the current turn
     */
    public Player getCurrentTurn() {
        return currentTurn;
    }

    private void setFinalPromPiece(Piece promPiece){
        this.finalPromPiece = promPiece;
    }



}
