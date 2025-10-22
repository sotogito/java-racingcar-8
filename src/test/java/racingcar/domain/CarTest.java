package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @Test
    void 자동차_전진() {
        Car car1 = new Car("수키피");
        Car car2 = new Car("파블로");
        List<Car> cars = List.of(car1, car2);

        car1.move();

        assertThat(Collections.max(cars)).isEqualTo(car1);
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
                assertThatThrownBy(() -> new Car(name))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
