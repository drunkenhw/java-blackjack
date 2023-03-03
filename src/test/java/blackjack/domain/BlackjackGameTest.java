package blackjack.domain;

import blackjack.domain.BlackjackGame;
import blackjack.domain.Card;
import blackjack.domain.CardDeck;
import blackjack.domain.CardNumber;
import blackjack.domain.CardSuit;
import blackjack.domain.GameResult;
import blackjack.domain.Participant;
import blackjack.domain.Participants;
import blackjack.domain.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BlackjackGameTest {

    @Test
    @DisplayName("플레이어는 두 장씩 카드를 받는다")
    void addTwoCardsTest() {
        List<String> names = List.of("jamie", "boxster");

        Participants participants = Participants.from(names);

        BlackjackGame blackjackGame = new BlackjackGame(participants);
        blackjackGame.dealOutCard();

        Participant participant = participants.toList()
                                              .get(0);
        assertThat(participant.getCards()).hasSize(2);
    }

    @Test
    @DisplayName("게임 승패를 반환한다")
    void getGameResultTest() {
        List<String> names = List.of("jamie", "boxster");

        Participants participants = Participants.from(names);
        List<Card> cards = new ArrayList<>(List.of(
                new Card(CardSuit.HEART, CardNumber.TWO), new Card(CardSuit.HEART, CardNumber.SEVEN),
                new Card(CardSuit.HEART, CardNumber.JACK), new Card(CardSuit.SPADE, CardNumber.KING),
                new Card(CardSuit.SPADE, CardNumber.KING), new Card(CardSuit.HEART, CardNumber.THREE)));
        BlackjackGame blackjackGame = new BlackjackGame(participants, new CardDeck(cards));
        blackjackGame.dealOutCard();

        assertThat(blackjackGame.getResult()).containsEntry(new Player("jamie"), GameResult.LOSE);
    }
}
