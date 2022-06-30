package main.java.GameLogic;

import main.java.Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class PawnPromotion implements ActionListener {
    private final JFrame promotionFrame;
    private final JButton queenChoice, bishopChoice, rookChoice, knightChoice;
    private final GameImages images;
    private final int CHOOSE_QUEEN = 0,CHOOSE_BISHOP = 1,CHOOSE_ROOK = 2,CHOOSE_KNIGHT = 3;
    private int finalChoose = -1;

    public PawnPromotion(){
        images = new GameImages();
        images.initializeImages();

        promotionFrame = new JFrame();
        promotionFrame.setSize(600,200);
        promotionFrame.setTitle("Chess Game - Pawn Promotion");
        promotionFrame.setLayout(new GridLayout(0,4));
        promotionFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Insets buttonMargin = new Insets(0,0,0,0);
        ImageIcon icon = new ImageIcon(new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB));

        queenChoice = new JButton(icon);
        queenChoice.setMargin(buttonMargin);
        queenChoice.setBackground(Color.white);
        queenChoice.setIcon(images.loadImages(new QueenPiece(true)));
        queenChoice.setFocusable(false);
        queenChoice.addActionListener(this);

        bishopChoice = new JButton(icon);
        bishopChoice.setMargin(buttonMargin);
        bishopChoice.setBackground(new Color(222, 184, 135));
        bishopChoice.setIcon(images.loadImages(new BishopPiece(false)));
        bishopChoice.setFocusable(false);
        bishopChoice.addActionListener(this);

        rookChoice = new JButton(icon);
        rookChoice.setMargin(buttonMargin);
        rookChoice.setBackground(Color.white);
        rookChoice.setIcon(images.loadImages(new RookPiece(true)));
        rookChoice.setFocusable(false);
        rookChoice.addActionListener(this);

        knightChoice = new JButton(icon);
        knightChoice.setMargin(buttonMargin);
        knightChoice.setBackground(new Color(222, 184, 135));
        knightChoice.setIcon(images.loadImages(new KnightPiece(false)));
        knightChoice.setFocusable(false);
        knightChoice.addActionListener(this);


        promotionFrame.add(queenChoice);
        promotionFrame.add(bishopChoice);
        promotionFrame.add(rookChoice);
        promotionFrame.add(knightChoice);

        promotionFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new PawnPromotion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (queenChoice.equals(source)) {
            finalChoose = CHOOSE_QUEEN;
        } else if (bishopChoice.equals(source)) {
            finalChoose = CHOOSE_BISHOP;
        } else if (rookChoice.equals(source)) {
            finalChoose = CHOOSE_ROOK;
        } else if (knightChoice.equals(source)) {
            finalChoose = CHOOSE_KNIGHT;
        }

        System.out.println(finalChoose);
        promotionFrame.dispose();
    }

    public int getFinalChoose() {
        return finalChoose;
    }
}
