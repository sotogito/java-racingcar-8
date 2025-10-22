package racingcar.domain;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_전진() {
        Car car = new Car("수키피", 0);

        car.move();
        Integer actual = car.getDistance();
        Integer expected = 1;

        assertThat(actual).isEqualTo(expected);
    }

}
