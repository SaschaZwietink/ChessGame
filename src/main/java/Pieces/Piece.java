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

    public abstract boolean getSpecial();

    /**
     * this method checks if the location is empty, occupied by own color or opposite color
     * @return 0 if empty, 1 if own color or 2 if opposite color
     */
    public int locationEmpty(Location end){
        if(end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return 1;
            }else{
                return 2;
            }
        }
        return 0;
    }


}
