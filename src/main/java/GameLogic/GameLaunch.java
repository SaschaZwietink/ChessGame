package main.java.GameLogic;

import main.java.Pieces.Piece;
import main.java.Players.Human;
import main.java.Players.Player;

public class GameLaunch {
    private Game game;
    private GameBoard gameBoard;
    //TODO Simulate method

    public void launch(){
        gameBoard = new GameBoard();
        Human p1 = new Human(true,"player1");
        Human p2 = new Human(false,"player2");

        game = new Game(p1,p2,gameBoard);


        System.out.println("Start of game");
        gameBoard.initializeBoard();
        gameBoard.printBoard();

//        simulateTurn(7,2,2,7,p1);
//        simulateTurn(1,2,2,2,p2);
//        simulateTurn(7,0,5,0,p1);
//        simulateTurn(0,1,2,2,p2);

        GameBoardUI gameBoardUI = new GameBoardUI(gameBoard,game);
        gameBoardUI.setBoardPieces(gameBoard.getLocations());
    }

    public static void main(String[] args){
        new GameLaunch().launch();
    }

    private Move createMove(int x1, int y1, int x2, int y2, GameBoard gameBoard, Player player){
        Piece selectedPiece = gameBoard.getLocations()[x1][y1].getPiece();
        Piece targetPiece = gameBoard.getLocations()[x2][y2].getPiece();
        Location start = new Location(x1,y1,selectedPiece);
        Location end = new Location(x2,y2,targetPiece);
        return new Move(player,start,end);
    }

    private void simulateTurn(int x1, int y1, int x2, int y2, Player player){
        System.out.println("\n\n----------------------------------------------------\n");
        System.out.println(game.getCurrentTurn().getName() + "'s turn");
        game.playMove(createMove(x1,y1,x2,y2,gameBoard,player));
        gameBoard.printBoard();
    }

}
