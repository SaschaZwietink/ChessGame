package main.java.Players;

import main.java.GameLogic.Location;

public abstract class Player{
    private Location kingLocation = new Location(-1,-1,null);
    private boolean whiteSide;
    private String name;
    public boolean isWhiteSide() {
        return whiteSide;
    }
    public String getName(){
        return name;
    }
    public Location getKingLocation(){return kingLocation;}
    public void setKingLocation(Location kingLocation) {
        this.kingLocation = kingLocation;
    }
}
