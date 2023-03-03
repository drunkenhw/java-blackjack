package blackjack.domain;

import blackjack.domain.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantsTest {

    @Test
    @DisplayName("이름들을 받아 딜러를 포함하여 players를 생성한다")
    void createPlayersTest() {
        List<String> names = List.of("jamie", "boxster");

        Participants participants = Participants.from(names);

        assertThat(participants.toList()).hasSize(3);
    }

    @Test
    @DisplayName("중복인 이름이 있는 경우 예외를 반환한다")
    void duplicateNamesTest() {
        List<String> names = List.of("jamie", "jamie");

        assertThatThrownBy(() -> Participants.from(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복인 이름은 입력하실 수 없습니다.");
    }
}
