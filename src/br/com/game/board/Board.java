package br.com.game.board;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Card[][] board;
    private final List<Card> selectedCards;

    public Board() {
        board = new Card[4][4];
        selectedCards = new ArrayList<Card>();

        initializeBoard();
    }

    private void initializeBoard() {
        int count = 0;
        int size = board.length * board.length;

        String[] cards = {"A", "B", "C", "D"};

        while (count < size) {
            for (String card : cards) {
                int x = (int) (Math.random() * board.length);
                int y = (int) (Math.random() * board.length);

                if (board[y][x] == null) {

                    board[y][x] = new Card();
                    board[y][x].setPosX(x);
                    board[y][x].setPosY(y);
                    board[y][x].setValue(card);

                    count++;
                }
            }
        }
    }

    public List<Card> getSelectedCards() {
        return selectedCards;
    }

    public Card getCard(int x, int y) {
        return board[y][x];
    }

    public void addSelectedCard(Card card) {
        selectedCards.add(card);
    }

    public Card[][] getBoard() {
        return board;
    }
}
