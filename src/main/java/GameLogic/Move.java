package main.java.GameLogic;

import main.java.Pieces.Piece;
import main.java.Players.Player;

public class Move {
    private final Player player;
    private final Location start;
    private final Location end;

    //TODO is it better stored here?
    private Piece pieceMoved;
    private Piece pieceKilled;

    public Move(Player player, Location start, Location end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    public Player getPlayer() {
        return player;
    }
}
