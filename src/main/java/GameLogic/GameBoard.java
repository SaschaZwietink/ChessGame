package main.java.GameLogic;

import main.java.Pieces.*;

public class GameBoard {

    private Location[][] locations;
    private final int maxFieldsLength;
    private final int maxFieldsWidth;


    public GameBoard(){
        maxFieldsLength = 8;
        maxFieldsWidth = 8;
        locations = new Location[maxFieldsWidth][maxFieldsLength];
    }

    public void initializeBoard(){
        //Black special Pieces
        locations[0][0] = new Location(0,0,new RookPiece(false));
        locations[0][1] = new Location(1,0,new KnightPiece(false));
        locations[0][2] = new Location(2,0,new BishopPiece(false));
        locations[0][3] = new Location(3,0,new QueenPiece(false));
        locations[0][4] = new Location(4,0,new KingPiece(false));
        locations[0][5] = new Location(5,0,new BishopPiece(false));
        locations[0][6] = new Location(6,0,new KnightPiece(false));
        locations[0][7] = new Location(7,0,new RookPiece(false));

        //Black pawn Pieces
        locations[1][0] = new Location(0,1,new PawnPiece(false));
        locations[1][1] = new Location(1,1,new PawnPiece(false));
        locations[1][2] = new Location(2,1,new PawnPiece(false));
        locations[1][3] = new Location(3,1,new PawnPiece(false));
        locations[1][4] = new Location(4,1,new PawnPiece(false));
        locations[1][5] = new Location(5,1,new PawnPiece(false));
        locations[1][6] = new Location(6,1,new PawnPiece(false));
        locations[1][7] = new Location(7,1,new PawnPiece(false));

        //White special Pieces
        locations[7][0] = new Location(0,7,new RookPiece(true));
        locations[7][1] = new Location(1,7,new KnightPiece(true));
        locations[7][2] = new Location(2,7,new BishopPiece(true));
        locations[7][3] = new Location(3,7,new QueenPiece(true));
        locations[7][4] = new Location(4,7,new KingPiece(true));
        locations[7][5] = new Location(5,7,new BishopPiece(true));
        locations[7][6] = new Location(6,7,new KnightPiece(true));
        locations[7][7] = new Location(7,7,new RookPiece(true));

        //White pawn Pieces
        locations[6][0] = new Location(0,6,new PawnPiece(true));
        locations[6][1] = new Location(1,6,new PawnPiece(true));
        locations[6][2] = new Location(2,6,new PawnPiece(true));
        locations[6][3] = new Location(3,6,new PawnPiece(true));
        locations[6][4] = new Location(4,6,new PawnPiece(true));
        locations[6][5] = new Location(5,6,new PawnPiece(true));
        locations[6][6] = new Location(6,6,new PawnPiece(true));
        locations[6][7] = new Location(7,6,new PawnPiece(true));

        for(int vertical = 2; vertical< maxFieldsLength-2; vertical++){
            for (int horizontal = 0; horizontal< maxFieldsWidth; horizontal++){
                //?
                locations[vertical][horizontal] = new Location(horizontal,vertical,null);
            }
        }


    }

    public Location getLocation(int x, int y){
        assert x < 0 || x > maxFieldsLength || y < 0 || y < maxFieldsWidth;
        return locations[x][y];
    }


    public void printBoard(){
        for (Location[] locations : locations) {
            System.out.print("\n| ");
            for (Location location : locations) {
                if(location.getPiece()!=null){
                    System.out.print(location.getPiece().getName() + " | ");
                }else{
                    System.out.print("- | ");
                }
            }
        }
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] newLocations){
        this.locations = newLocations;
    }

}
