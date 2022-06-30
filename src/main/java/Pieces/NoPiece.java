package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;

public class NoPiece extends Piece{
    public NoPiece(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {
        return false;
    }

    @Override
    public String getName() {
        return "X";
    }
}
