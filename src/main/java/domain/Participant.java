package domain;

import java.util.List;

abstract class Participant {

    protected final PlayerCards playerCards;

    Participant() {
        this.playerCards = new PlayerCards();
    }

    void addCard(Card card) {
        playerCards.add(card);
    }

    void addCards(List<Card> cards) {
        playerCards.addAll(cards);
    }

    ScoreState getState() {
        return ScoreState.of(playerCards.getScore());
    }

    public List<Card> getCards() {
        return playerCards.toList();
    }
}
