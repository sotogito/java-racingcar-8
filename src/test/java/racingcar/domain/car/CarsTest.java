package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.number.MoveStrategy;
import racingcar.infrastructure.RandomNumberStrategy;

class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final MoveStrategy moveStrategy = new RandomNumberStrategy();

    @Test
    void 자동차등_전진() {
        Car car1 = new Car("가");
        Car car2 = new Car("나");
        Cars cars = new Cars(List.of(car1, car2));

        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveAllCars(moveStrategy);
                    String actual = cars.toString();

                    assertThat(actual).contains("가 : -", "나 : ");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 단일_우승_자동차_이름_반환() {
        Car car1 = new Car("가");
        Car car2 = new Car("나");
        Car car3 = new Car("다");
        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.move();
        List<String> actual = cars.getWinningCarNames();
        List<String> expected = List.of("가");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 공동_우승_자동차_이름_반황() {
        Car car1 = new Car("가");
        Car car2 = new Car("나");
        Car car3 = new Car("다");
        Cars cars = new Cars(List.of(car1, car2, car3));

        car1.move();
        car3.move();
        List<String> actual = cars.getWinningCarNames();
        List<String> expected = List.of("가", "다");

        assertThat(actual).isEqualTo(expected);
    }

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
