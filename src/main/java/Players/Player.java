package main.java.Players;

public abstract class Player{
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

}
