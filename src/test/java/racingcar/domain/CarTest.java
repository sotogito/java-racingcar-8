package racingcar.domain;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    void 자동차_전진() {
        Car car = new Car("수키피", 0);

        car.move();
        Integer actual = car.getDistance();
        Integer expected = 1;

        assertThat(actual).isEqualTo(expected);
    }


    @ParameterizedTest
    @ValueSource(strings = {
            "가나다라마바사",
            "",
            "  "
    })
    @DisplayName("자동차 이름은 5자 이하")
    void 자동차_이름_길이_예외처리(String name) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Car(name, 0))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
