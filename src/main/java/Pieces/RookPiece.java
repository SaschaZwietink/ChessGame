package main.java.Pieces;

import main.java.GameLogic.Location;
import main.java.GameLogic.GameBoard;

public class RookPiece extends Piece{
    public RookPiece(boolean isWhite) {
        super(isWhite);
    }

    //TODO Kill a piece
    //TODO castling
    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {
        if(end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }//TODO kill a piece
        }

        int x = Math.abs(end.getX()-start.getX());
        int y = Math.abs(end.getY()-start.getY());

        if(x == 1){
            return y == 0;
        }

        int xe = end.getX()-(end.getX()-start.getX())/x;

        Location tempEnd = new Location(xe,end.getY(),null);
        return canMove(gameBoard,start,tempEnd);
    }

    @Override
    public String getName() {
        return "R";
    }

    @Override
    public boolean getSpecial() {
        return false;
    }
}
