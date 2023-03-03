package blackjack.domain;

import blackjack.domain.Card;
import blackjack.domain.CardNumber;
import blackjack.domain.CardSuit;
import blackjack.domain.PlayerCards;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerCardsTest {

    @Test
    @DisplayName("카드를 받을 수 있다")
    void addCardTest() {
        PlayerCards playerCards = new PlayerCards();
        Card card = new Card(CardSuit.SPADE, CardNumber.ACE);

        playerCards.add(card);

        assertThat(playerCards.toList()).contains(card);
    }

    @Test
    @DisplayName("카드의 점수를 계산한다")
    void calculateScoreTest() {
        PlayerCards playerCards = new PlayerCards();
        Card one = new Card(CardSuit.SPADE, CardNumber.ACE);
        Card two = new Card(CardSuit.SPADE, CardNumber.THREE);

        playerCards.add(one);
        playerCards.add(two);

        assertThat(playerCards.getScore()).isEqualTo(14);
    }

    @Test
    @DisplayName("에이스가 있을 때의 점수를 계산한다")
    void calculateAceScoreTest() {
        PlayerCards playerCards = new PlayerCards();
        Card one = new Card(CardSuit.SPADE, CardNumber.ACE);
        Card two = new Card(CardSuit.HEART, CardNumber.ACE);
        Card three = new Card(CardSuit.HEART, CardNumber.TEN);

        playerCards.add(one);
        playerCards.add(two);
        playerCards.add(three);

        assertThat(playerCards.getScore()).isEqualTo(12);
    }
}
