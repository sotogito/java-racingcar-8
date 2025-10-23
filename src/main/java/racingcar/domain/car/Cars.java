package racingcar.domain.car;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarCount(cars);
        validateDuplicatedName(cars);

        this.cars = cars;
    }


    public int getCarsCount() {
        return cars.size();
    }

    public void updateCarsDistance(List<Integer> randomNumbers) {
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
        Car winningCar = Collections.max(cars);

        return cars.stream()
                .filter(car -> car.isWinningCar(winningCar))
                .map(Car::getName)
                .toList();
    }


    private boolean canMove(int randomNumber) {
        return randomNumber >= 4;
    }

    private void validateCarCount(List<Car> cars) {
        int count = cars.size();
        if (count < 1 || count > 1000) {
            throw new IllegalArgumentException("자동차는 1~1,000대까지 등록 가능합니다.");
        }
    }

    private void validateDuplicatedName(List<Car> cars) {
        Set<Car> duplicatedCars = new HashSet<>(cars);
        if (cars.size() != duplicatedCars.size()) {
            throw new IllegalArgumentException("이름이 중복인 자동차가 존재합니다.");
        }
    }

    private void validateRandomNumbers(List<Integer> randomNumbers) {
        if (randomNumbers == null || cars.size() != randomNumbers.size()) {
            throw new IllegalArgumentException("예기치 못한 오류가 발생했습니다.");
        }
    }

    private void validateRandomNumber(Integer randomNumber) {
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
