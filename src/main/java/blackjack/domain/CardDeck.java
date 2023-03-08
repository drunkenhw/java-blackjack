package blackjack.domain;

import blackjack.constants.ErrorCode;
import blackjack.domain.exception.NoMoreCardException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    private final List<Card> cards;

    public CardDeck() {
        this.cards = new ArrayList<>(Card.values());
        shuffleCards();
    }

    CardDeck(List<Card> cards) {
        this.cards = cards;
    }

    private void shuffleCards() {
        Collections.shuffle(this.cards);
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }

    public Card pick() {
        if (cards.isEmpty()) {
            throw new NoMoreCardException(ErrorCode.EMPTY_CARD);
        }
        return cards.remove(0);
    }
}
