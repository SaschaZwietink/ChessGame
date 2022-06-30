package main.java.Pieces;

import main.java.GameLogic.GameBoard;
import main.java.GameLogic.Location;

public class KingPiece extends Piece {
    private boolean castlingDone = false;

    public KingPiece(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean canMove(GameBoard gameBoard, Location start, Location end) {
        if(end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(end.getX()-start.getX());
        int y = Math.abs(end.getY()-start.getY());

        if(underAttack(x,y)){
            return false;
        }

        //TODO castling movement
        return isValidCastling(gameBoard,start,end);
    }

    @Override
    public String getName() {
        return "K";
    }

    //TODO create underAttack method
    private boolean underAttack(int x, int y) {
        return false;
    }

    //TODO logic for looking if castling is allowed
    private boolean isValidCastling(GameBoard gameBoard, Location start, Location end) {
        return !this.isCastlingDone();
    }

    public boolean isCastlingDone() {
        return castlingDone;
    }

    public void setCastlingDone(boolean castling) {
        this.castlingDone = castling;
    }
}
