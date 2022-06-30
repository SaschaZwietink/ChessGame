package main.java.GameLogic;

import main.java.Pieces.Piece;

import javax.swing.*;

/**
 * Source for the Images:
 * https://commons.wikimedia.org/wiki/Category:PNG_chess_pieces/Standard_transparent
 *
 */

public class GameImages {
    private ImageIcon imageRookB, imageRookW, imageKnightB, imageKnightW, imageBishopB, imageBishopW,
            imageQueenB, imageQueenW, imageKingB, imageKingW, imagePawnB, imagePawnW;

    public void initializeImages(){
        imageBishopB = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_bdt60.png");
        imageBishopW = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_blt60.png");
        imageKnightB = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_ndt60.png");
        imageKnightW = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_nlt60.png");
        imageRookB = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_rdt60.png");
        imageRookW = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_rlt60.png");
        imageQueenB = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_qdt60.png");
        imageQueenW = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_qlt60.png");
        imageKingB = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_kdt60.png");
        imageKingW = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_klt60.png");
        imagePawnB = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_pdt60.png");
        imagePawnW = new ImageIcon("C:\\Users\\sasch\\OneDrive\\Desktop\\PriveProject2j\\src\\main\\resources\\Chess_plt60.png");
    }

    public ImageIcon loadImages(Piece piece){
        if (piece.getName().equals("R") && piece.isWhite()) {
            return imageRookW;
        } else if (piece.getName().equals("R") && !piece.isWhite()) {
            return imageRookB;
        } else if (piece.getName().equals("B") && piece.isWhite()) {
            return imageBishopW;
        } else if (piece.getName().equals("B") && !piece.isWhite()) {
            return imageBishopB;
        } else if (piece.getName().equals("H") && piece.isWhite()) {
            return imageKnightW;
        } else if (piece.getName().equals("H") && !piece.isWhite()) {
            return imageKnightB;
        } else if (piece.getName().equals("Q") && piece.isWhite()) {
            return imageQueenW;
        } else if (piece.getName().equals("Q") && !piece.isWhite()) {
            return imageQueenB;
        } else if (piece.getName().equals("K") && piece.isWhite()) {
            return imageKingW;
        } else if (piece.getName().equals("K") && !piece.isWhite()) {
            return imageKingB;
        } else if (piece.getName().equals("P") && piece.isWhite()) {
            return imagePawnW;
        } else if (piece.getName().equals("P") && !piece.isWhite()) {
            return imagePawnB;
        } else {
            System.out.println("Piece doesnt exist!");
            return null;
        }
    }
}
