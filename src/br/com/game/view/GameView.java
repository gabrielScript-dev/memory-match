package br.com.game.view;

import br.com.game.board.Card;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serial;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameView extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;

    private final Card[][] cards;
    private final JLabel scoreLabel;

    public GameView(Card[][] cards) {

        setTitle("Memory Match");
        setSize(370, 390);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        this.cards = cards;
        scoreLabel = new JLabel("Score: 0");

        JPanel boardPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        for (Card[] card : cards) {
            for (Card value : card) {
                value.setPreferredSize(new Dimension(80, 80));
                boardPanel.add(value);
            }
        }

        add(scoreLabel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
    }

    public Card[][] getCards() {
        return cards;
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}