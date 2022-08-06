package main.java.Players;

import main.java.GameLogic.Location;

public abstract class Player{
    private Location kingLocation = new Location(-1,-1,null);
    private boolean whiteSide;
    private boolean human;
    private String name;

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public boolean isWhiteSide() {
        return whiteSide;
    }

    public void setWhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }

    public String getName(){
        return name;
    }

    public Location getKingLocation(){return kingLocation;};

    public void setKingLocation(Location kingLocation) {
        this.kingLocation = kingLocation;
    }
}
