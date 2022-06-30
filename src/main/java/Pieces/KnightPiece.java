package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;

public class KnightPiece extends Piece {

    public KnightPiece(boolean isWhite) {
        super(isWhite);
    }

    //TODO add killing a piece
    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {
        if(end.getPiece() != null) {
            System.out.println("Location is not empty");
            if (end.getPiece().isWhite() == this.isWhite()) {
                System.out.println("Is my own color");
                return false;
            }//TODO kill a piece
        }

        int x = Math.abs(end.getX()-start.getX());
        int y = Math.abs(end.getY()-start.getY());

        return x*y == 2;
    }

    @Override
    public String getName() {
        return "H";
    }
}
