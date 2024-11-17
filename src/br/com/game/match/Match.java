package br.com.game.match;

import br.com.game.board.Board;
import br.com.game.board.Card;

import java.util.List;

public class Match {

    private Player player;
    private final Board board;

    public Match() {
        board = new Board();
    }

    private boolean checkMatch() {

        List<Card> list = board.getSelectedCards();

        Card card1 = list.get(0);
        Card card2 = list.get(1);

        String valueCard1 = card1.getValue();
        String valueCard2 = card2.getValue();

        boolean match = valueCard1.equals(valueCard2);

        if(!match) {
            card1.setHide(true);
            card2.setHide(true);
        }

        return match;
    }

    public void toPlay(int x, int y) {

        System.out.println("Teste");

        Card card = board.getCard(x, y);
        card.setHide(false);

        board.addSelectedCard(card);

        int size = board.getSelectedCards().size();

        if(size >= 2 && checkMatch()) {
            player.addScore(1);
        }
    }

    public Board getBoard() {
        return board;
    }
}
