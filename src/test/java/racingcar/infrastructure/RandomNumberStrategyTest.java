package racingcar.infrastructure;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.number.MoveStrategy;

class RandomNumberStrategyTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final MoveStrategy moveStrategy = new RandomNumberStrategy();

    @Test
    void 전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean actual = moveStrategy.canMove();

                    assertThat(actual).isTrue();
                },
                MOVING_FORWARD
        );
    }

    @Test
    void 전진하지_않음() {
        assertRandomNumberInRangeTest(
                () -> {
                    boolean actual = moveStrategy.canMove();

                    assertThat(actual).isFalse();
                },
                STOP
        );
    }

}
