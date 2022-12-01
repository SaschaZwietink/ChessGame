package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;
import main.java.Pieces.Piece;

public class QueenPiece extends Piece {


    public QueenPiece(boolean isWhite) {
        super(isWhite);
    }

    //TODO diagonal movement
    //TODO horizontal movement
    //TODO killing
    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {

        int x = Math.abs(end.getX()-start.getX());
        int y = Math.abs(end.getY()-start.getY());
        if(end.getPiece() != null) {
            //Stops the piece from moving further then a same color piece
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        }



        if(x == 1 || y == 1){
            return x + y == 1 || x / y == 1;
        }

        int xe = end.getX(), ye = end.getY();
        if(x > 0){
            xe = end.getX()-(end.getX()-start.getX())/x;
        }
        if (y > 0) {
            ye = end.getY()-(end.getY()-start.getY())/y;
        }
        Location tempEnd = new Location(xe,ye,gameBoard.getLocation(xe,ye).getPiece());
        return canMove(gameBoard,start,tempEnd);
    }

    @Override
    public String getName() {
        return "Q";
    }

    @Override
    public boolean getSpecial() {
        return false;
    }
}
