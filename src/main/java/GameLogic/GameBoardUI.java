package main.java.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GameBoardUI implements ActionListener {
    private final JFrame gameFrame;
    private final JButton[][] chessBoardSquares = new JButton[8][8];
    private final GameImages images;
    private final JLabel playersTurnLabel, messagesLabel;
    private final JPanel playersTurnPanel, messagesPanel, gamePanel, topLayerPanel;

    private boolean pieceSelected = false;
    private JButton selected = null;
    private Location start, end;
    private final GameBoard gameBoard;
    private final Game game;

    public GameBoardUI(GameLaunch gameLaunch){
        this.gameBoard = gameLaunch.getGameBoard();
        this.game = gameLaunch.getGame();


        images = new GameImages();
        images.initializeImages();

        playersTurnLabel = new JLabel("Its " + game.getCurrentTurn().getName() + " turn");
        messagesLabel = new JLabel("Click to start");

        playersTurnPanel = new JPanel();
        playersTurnPanel.add(playersTurnLabel);

        messagesPanel = new JPanel();
        messagesPanel.add(messagesLabel);

        gamePanel = new JPanel(new GridLayout(0,9));

        gameFrame = new JFrame("Chess Game");
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setSize(800,800);

        topLayerPanel = new JPanel(new GridLayout(0,2));
        topLayerPanel.add(playersTurnPanel);
        topLayerPanel.add(messagesPanel);

        gameFrame.add(topLayerPanel,BorderLayout.NORTH);


        initializeBoardUI();
    }

    public void initializeBoardUI(){
        Insets buttonMargin = new Insets(0,0,0,0);

        //Making the chessBoard
        for (int buttonRow = 0; buttonRow < chessBoardSquares.length; buttonRow++) {
            //Adding the number on the left side
            gamePanel.add(new JLabel("" + (chessBoardSquares.length-buttonRow),SwingConstants.CENTER));
            //adding a row of squares
            for (int buttonColumn = 0; buttonColumn < chessBoardSquares[buttonRow].length; buttonColumn++) {

                ImageIcon icon = new ImageIcon(new BufferedImage(60, 60, BufferedImage.TYPE_INT_ARGB));
                JButton tempButton = new JButton(icon);

                tempButton.setMargin(buttonMargin);

                setColor(buttonRow,buttonColumn,tempButton);

                tempButton.setFocusable(false);
                tempButton.addActionListener(this);

                chessBoardSquares[buttonRow][buttonColumn] = tempButton;
                gamePanel.add(chessBoardSquares[buttonRow][buttonColumn]);
            }
        }

        for(int lastRow = 0; lastRow < chessBoardSquares.length+1; lastRow++){
            String letter = "";
            switch (lastRow) {
                case 0 -> letter = "";
                case 1 -> letter = "A";
                case 2 -> letter = "B";
                case 3 -> letter = "C";
                case 4 -> letter = "D";
                case 5 -> letter = "E";
                case 6 -> letter = "F";
                case 7 -> letter = "G";
                case 8 -> letter = "H";
            }
            gamePanel.add(new JLabel(letter,SwingConstants.CENTER));
        }
        gameFrame.add(gamePanel,BorderLayout.CENTER);

        gameFrame.setVisible(true);
    }

    public void setBoardPieces(Location[][] allLocations){
        for(int x = 0; x<allLocations.length;x++){
            for(int y = 0; y<allLocations[x].length;y++){
                if(allLocations[x][y].getPiece()!=null){
                    chessBoardSquares[x][y].setIcon(images.loadImages(allLocations[x][y].getPiece()));
                }else{
                    chessBoardSquares[x][y].setIcon(null);
                }
            }
        }
    }

    public void setColor(int x, int y, JButton button){
        if ((y % 2 == 1 && x % 2 == 1) || (y % 2 == 0 && x % 2 == 0)) {
            button.setBackground(Color.WHITE);
        } else {
            button.setBackground(new Color(222, 184, 135));
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(game.getCurrentModes()!=2) {
            Location tempLocation = null;

            for (int x = 0; x < chessBoardSquares.length; x++) {
                for (int y = 0; y < chessBoardSquares[x].length; y++) {
                    if (e.getSource() == chessBoardSquares[x][y]) {
                        if (!pieceSelected) {
                            selected = chessBoardSquares[x][y];
                        }
                        tempLocation = new Location(x, y, gameBoard.getLocation(x, y).getPiece());
                    }
                }
            }

            if (tempLocation != null) {
                if (!pieceSelected) {
                    if (tempLocation.getPiece() != null) {
                        if (tempLocation.getPiece().isWhite() == game.getCurrentTurn().isWhiteSide()) {
                            pieceSelected = true;
                            start = tempLocation;
                            selected.setBackground(Color.GREEN);
                        }
                    }
                } else {
                    pieceSelected = false;
                    end = tempLocation;
                    setColor(start.getX(), start.getY(), selected);

                    //TODO selecting same piece twice
                    game.playMove(new Move(game.getCurrentTurn(), start, end));
                    //TODO not most efficient
                    playersTurnLabel.setText("Its " + game.getCurrentTurn().getName() + "'s turn");
                    setBoardPieces(gameBoard.getLocations());
                }
            }
        }

    }
}
