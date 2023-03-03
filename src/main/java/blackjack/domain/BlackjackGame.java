package blackjack.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BlackjackGame {

    private final CardDeck cardDeck;
    private final Participants participants;

    public BlackjackGame(Participants participants, CardDeck cardDeck) {
        this.participants = participants;
        this.cardDeck = cardDeck;
    }

    public BlackjackGame(Participants participants) {
        this(participants, new CardDeck());
    }

    public void dealOutCard() {
        for (Participant participant : participants.toList()) {
            List<Card> cards = cardDeck.pickTwice();
            participant.addCards(cards);
        }
    }

    public Map<Participant, GameResult> getResult() {
        Map<Participant, GameResult> result = new LinkedHashMap<>();
        for (Participant player : participants.getPlayers()) {
            result.put(player, GameResult.of(player, participants.getDealer()));
        }
        return result;
    }

    public void giveCard(Participant participant) {
        participant.addCard(cardDeck.pick());
    }
}
