package main.java.GameLogic;

import main.java.Pieces.*;
import main.java.Players.Player;

import java.util.LinkedList;
import java.util.List;

/**
 * Main game class that handles move's and turns
 */
public class Game {
    private int currentModes;

    private final int MENU = 0, PLAYING = 1, PROMOTION = 2;
    private final List<Player> players;
    private final GameBoard gameBoard;
    private GameBoardUI gameBoardUI;
    private Player currentTurn;
    private final List<Move> movesPlayed;
    private Location finalPromLocation = null;
    private PawnPromotion pawnPromotion;

    private final GameLaunch gameLaunch;

    public Game(Player p1, Player p2, GameLaunch gameLaunch) {
        this.gameLaunch = gameLaunch;
        this.gameBoard = gameLaunch.getGameBoard();
        this.gameBoardUI = gameLaunch.getGameBoardUI();
        movesPlayed = new LinkedList<>();
        players = new LinkedList<>();
        players.add(p1);
        players.add(p2);

        currentTurn = players.get(0);
        //players.get(0).setKingLocation(new Location(4,7,new KingPiece(true)));
        //players.get(1).setKingLocation(gameBoard.getLocation(4,0));
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


            //TODO game needs to wait for choice to be made
            //TODO make boolean to stop change board, make method for setting final piece, remove while-loop
            if(pieceMoving.getName().equals("P")&&pieceMoving.getSpecial()){
                currentModes = PROMOTION;
                System.out.println("PROMOTION Modes " + currentModes);
                pawnPromotion = new PawnPromotion(this);
                finalPromLocation = new Location(endX,endY,null);
                System.out.println(pieceMoving.getName());
            }


            movesPlayed.add(newMove);
            System.out.println("(" + newMove.getEnd().getX()+", " + newMove.getEnd().getY() + ") -> " + newMove.getEnd().getPiece().getName());
            System.out.println(isChecked(newMove.getEnd()) + " Check!!!!!");

            System.out.println(gameBoard.getLocation(newMove.getEnd().getX(),newMove.getEnd().getY()).getPiece().getName());
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

    public boolean isChecked(Location newLocationPiece){
        Location kingLocation = new Location(0,4,new KingPiece(false));//players.get((players.indexOf(currentTurn)+1)% players.size()).getKingLocation();
        System.out.println("(" + kingLocation.getX()+", " + kingLocation.getY() + ") -> " + kingLocation.getPiece().getName());
        System.out.println("(" + newLocationPiece.getX()+", " + newLocationPiece.getY() + ") -> " + newLocationPiece.getPiece().getName());
        return newLocationPiece.getPiece().canMove(gameBoard, newLocationPiece, kingLocation);
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

    public void setFinalPromPiece(int promPieceNewID,boolean isWhite){
        if(promPieceNewID!=-1){
            Piece promPiece = null;
            switch (promPieceNewID){
                case 0 -> promPiece = new QueenPiece(isWhite);
                case 1 -> promPiece = new BishopPiece(isWhite);
                case 2 -> promPiece = new RookPiece(isWhite);
                case 3 -> promPiece = new KnightPiece(isWhite);
            }
            currentModes = PLAYING;
            finalPromLocation.setPiece(promPiece);
            System.out.println("final piece is: " + finalPromLocation.getPiece().getName());
        }
        gameBoard.getLocation(finalPromLocation.getX(), finalPromLocation.getY()).setPiece(finalPromLocation.getPiece());
        System.out.println(gameBoard.getLocation(finalPromLocation.getX(), finalPromLocation.getY()).getPiece().getName());
    }

    public int getCurrentModes() {
        return currentModes;
    }

    public void setGameBoardUI(){
        this.gameBoardUI = gameLaunch.getGameBoardUI();
    }

}
