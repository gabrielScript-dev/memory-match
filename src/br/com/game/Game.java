package br.com.game;

import br.com.game.board.Board;
import br.com.game.board.Card;
import br.com.game.match.Match;
import br.com.game.view.GameView;

public class Game {
    private Match match;
    private GameView gameView;

    public Game() {
        match = new Match();

        Board board = match.getBoard();
        Card[][] cardsBoard = board.getBoard();

        gameView = new GameView(cardsBoard);

        start();
    }

    public void start() {
        Card[][] cards = gameView.getCards();

        for(int y = 0; y < cards.length; y++) {
            for(int x = 0; x < cards[y].length; x++) {
                final int posX = x;
                final int posY = y;

                cards[y][x].addActionListener(e -> match.toPlay(posX, posY));
            }
        }

        gameView.setVisible(true);
    }
}
