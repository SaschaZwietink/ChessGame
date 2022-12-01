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

        if(end.getPiece() != null) {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }//TODO kill a piece
        }

        int x = Math.abs(end.getX()-start.getX());
        int y = Math.abs(end.getY()-start.getY());


        if((x/y!=1)||(y==0 && x!=0)||(x==0)){
            return false;
        }
        if(x == 1){
            return x/y == 1;
        }

        int xe = end.getX()-(end.getX()-start.getX())/x;
        int ye = end.getY()-(end.getY()-start.getY())/y;

//        if(xe==0){return true;};
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
