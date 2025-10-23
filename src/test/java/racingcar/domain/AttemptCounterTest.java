package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCounterTest {

    @Test
    void 시도횟수_종료_조건_및_감소_확인() {
        AttemptCounter attemptCounter = new AttemptCounter(1);

        attemptCounter.decreaseAttempt();
        boolean actual = attemptCounter.isOver();

        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 10000000})
    void 시도횟수_범위_예외처리(int attempt) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new AttemptCounter(attempt))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
