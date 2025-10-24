package racingcar.domain.car;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        validateCarCount(cars);
        validateDuplicatedName(cars);

        this.cars = cars;
    }


    public int getCarsCount() {
        return cars.size();
    }

    public void updateCarsDistance(final List<Integer> randomNumbers) {
        validateRandomNumbers(randomNumbers);

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            Integer randomNumber = randomNumbers.get(i);
            validateRandomNumber(randomNumber);

            if (canMove(randomNumber)) {
                car.move();
            }
        }
    }

    public List<String> getWinningCarNames() {
        final Car winningCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.isWinningCar(winningCar))
                .map(Car::getName)
                .toList();
    }


    private boolean canMove(final int randomNumber) {
        return randomNumber >= 4;
    }

    private void validateCarCount(final List<Car> cars) {
        final int count = cars.size();
        if (count < 1 || count > 1000) {
            throw new IllegalArgumentException("자동차는 1~1,000대까지 등록 가능합니다.");
        }
    }

    private void validateDuplicatedName(final List<Car> cars) {
        final Set<Car> duplicatedCars = new HashSet<>(cars);
        if (cars.size() != duplicatedCars.size()) {
            throw new IllegalArgumentException("이름이 중복인 자동차가 존재합니다.");
        }
    }

    private void validateRandomNumbers(final List<Integer> randomNumbers) {
        if (randomNumbers == null || cars.size() != randomNumbers.size()) {
            throw new IllegalArgumentException("예기치 못한 오류가 발생했습니다.");
        }
    }

    private void validateRandomNumber(final Integer randomNumber) {
        if (randomNumber == null) {
            throw new IllegalArgumentException("예기치 못한 오류가 발생했습니다.");
        }
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"));
    }

}
