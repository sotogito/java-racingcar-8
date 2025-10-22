package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 최종 우슨자 선발,
 */
public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarCount(cars);
        validateDuplicatedName(cars);

        this.cars = cars;
    }

    private void validateCarCount(List<Car> cars) {
        int count = cars.size();
        if (count < 1 || count > 10000) {
            throw new IllegalArgumentException("자동차는 1~10,000대까지 등록 가능합니다.");
        }
    }

    private void validateDuplicatedName(List<Car> cars) {
        Set<Car> duplicatedCars = new HashSet<>(cars);
        if (cars.size() != duplicatedCars.size()) {
            throw new IllegalArgumentException("이름이 중복인 자동차가 존재합니다.");
        }
    }

}
