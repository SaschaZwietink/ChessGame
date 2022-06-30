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
        if(end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(end.getX()-start.getX());
        int y = Math.abs(end.getY()-start.getY());

        return true;
    }

    @Override
    public String getName() {
        return "Q";
    }
}
