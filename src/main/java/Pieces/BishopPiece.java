package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;

public class BishopPiece extends Piece{
    public BishopPiece(boolean isWhite) {
        super(isWhite);
    }

    //TODO check for diagonal movement
    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {
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

        if(x == 1){
            return x/y == 1;
        }

        int xe = end.getX()-(end.getX()-start.getX())/x;
        int ye = end.getY()-(end.getY()-start.getY())/y;

        Location tempEnd = new Location(xe,ye,null);
        return canMove(gameBoard,start,tempEnd);
    }

    @Override
    public String getName() {
        return "B";
    }
}
