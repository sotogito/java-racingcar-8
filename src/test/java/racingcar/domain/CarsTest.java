package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @Test
    void 최소_자동차_수_예외처리() {
        List<Car> cars = List.of();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Race(cars, 1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름_중복_예외처리() {
        Car car1 = new Car("가");
        Car car2 = new Car("가");
        Car car3 = new Car("나");

        List<Car> cars = List.of(car1, car2, car3);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Race(cars, 1))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1000000})
    void 시도횟수_범위_예외처리(int attempt) {
        List<Car> cars = List.of(new Car("기"));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Race(cars, attempt))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}