package racingcar.domain.car;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.domain.number.MoveStrategy;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarCount(cars);
        validateDuplicatedName(cars);

        this.cars = cars;
    }


    public void moveAllCars(final MoveStrategy moveStrategy) {
        cars.stream()
                .filter(car -> moveStrategy.canMove())
                .forEach(Car::move);
    }

    public List<String> getWinningCarNames() {
        final Car winningCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.isWinningCar(winningCar))
                .map(Car::getName)
                .toList();
    }


    private void validateCarCount(final List<Car> cars) {
        int count = cars.size();
        if (count < 1 || count > 1000) {
            throw new IllegalArgumentException("자동차는 1~1,000대까지 등록 가능합니다.");
        }
    }

    private void validateDuplicatedName(final List<Car> cars) {
        Set<Car> duplicatedCars = new HashSet<>(cars);
        if (cars.size() != duplicatedCars.size()) {
            throw new IllegalArgumentException("이름이 중복인 자동차가 존재합니다.");
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

}
