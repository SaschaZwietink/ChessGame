package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;

public class PawnPiece extends Piece{
    private boolean firstMove = true;

    public PawnPiece(boolean isWhite) {
        super(isWhite);
    }

    //TODO check for one step forward movement or for diagonal attack
    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {
        //TODO this part is same for every piece
        boolean canBeAKill = false;
        if(end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
                //TODO kill a piece
            }else{
                canBeAKill = true;
            }
        }

        int x = Math.abs(end.getX()-start.getX());
        int y = Math.abs(end.getY()-start.getY());

        if(y != 0) {
            if (canBeAKill && x / y == 1) {
                firstMove = false;
                end.getPiece().setAlive(false);
                return true;
            }
        }

        if(firstMove){
            firstMove = false;
            return (x == 1 && y == 0) || (x == 2 && y == 0);
        }else{
            return x == 1 && y == 0;
        }
    }

    @Override
    public String getName() {
        return "P";
    }
}
