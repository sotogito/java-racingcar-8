package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 최소_자동차_수_예외처리() {
        List<Car> cars = List.of();

        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Cars(cars))
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
                assertThatThrownBy(() -> new Cars(cars))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}