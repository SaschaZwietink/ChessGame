package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;

public abstract class Piece {
    private boolean white;
    private boolean alive = true;

    public Piece(boolean isWhite){
        this.white = isWhite;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isWhite() {
        return white;
    }

    public abstract boolean canMove(GameBoard gameBoard, Location start, Location end);

    public abstract String getName();

}
