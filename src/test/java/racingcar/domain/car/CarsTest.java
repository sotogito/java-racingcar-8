package racingcar.domain.car;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void 랜덤숫자에_따른_자동차등_전진() {
        Car car1 = new Car("가");
        Car car2 = new Car("나");
        Cars cars = new Cars(List.of(car1, car2));
        List<Integer> randomNumbers = List.of(1, 8);

        cars.updateCarsDistance(randomNumbers);

        String actual = car2.toString();
        String expected = "나 : -";

        assertThat(actual).isEqualTo(expected);
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

    @Test
    void 랜덤숫자_리스트_요소에_null_포함_예외처리() {
        Car car1 = new Car("가");
        Car car2 = new Car("나");
        Cars cars = new Cars(List.of(car1, car2));
        List<Integer> randomNumbers = new ArrayList<>();
        randomNumbers.add(null);
        randomNumbers.add(1);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> cars.updateCarsDistance(randomNumbers))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}
