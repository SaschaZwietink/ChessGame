package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;

public class PawnPiece extends Piece{
    private boolean firstMove = true;
    private boolean promotion = false;

    public PawnPiece(boolean isWhite) {
        super(isWhite);
    }

    //TODO add promotion to Queen,Rook, Bishop or Knight
    //TODO add En Passant
    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {

        int emptyLocation = super.locationEmpty(end);

        if(emptyLocation == 1){return false;}

        int dx = end.getX()-start.getX();

        int x = Math.abs(dx);
        int y = Math.abs(end.getY()-start.getY());

        //No horizontal movement
        if(x == 0){return false;}

        //No backwards
        if((!(dx/x == -1)&&this.isWhite())||(!(dx/x == 1)&&!this.isWhite())){
            return false;
        }

        //Killing a piece
        if(y != 0) {
            if (emptyLocation == 2 && x / y == 1) {
                firstMove = false;
                end.getPiece().setAlive(false);
                if(end.getX() == 7 || end.getX() == 0){promotion = true;}
                return true;
            }
        }

        if(firstMove){
            firstMove = false;
            return (x == 1 && y == 0) || (x == 2 && y == 0);
        }else{
            if(end.getX() == 7 || end.getX() == 0){promotion = true;}
            return x == 1 && y == 0;
        }
    }

    @Override
    public String getName() {
        return "P";
    }

    @Override
    public boolean getSpecial() {
        return promotion;
    }
}
