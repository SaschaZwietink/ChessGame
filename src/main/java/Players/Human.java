package main.java.Players;

public class Human extends Player{
    private final boolean whiteSide;
    private final boolean human;
    private final String name;

    public Human(boolean whiteSide, String name) {
        this.whiteSide = whiteSide;
        this.human = true;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public boolean isWhiteSide() {
        return whiteSide;
    }
}
