package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            int randomNumber = randomNumbers.get(i);

            if (canMove(randomNumber)) {
                car.move();
            }
        }
    }

    public List<String> getWinningCarNames() {
        List<String> winningCarNames = new ArrayList<>();

        Car winningCar = Collections.max(cars);
        for (Car car : cars) {
            if (car.isWinningCar(winningCar)) {
                winningCarNames.add(car.getName());
            }
        }
        return List.copyOf(winningCarNames);
    }


    private boolean canMove(int randomNumber) {
        return randomNumber >= 4;
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

    private void validateRandomNumbers(List<Integer> randomNumbers) {
        if (cars.size() != randomNumbers.size() || randomNumbers.contains(null)) {
            throw new IllegalArgumentException("예기치 못한 오류가 발생했습니다.");
        }
    }

    @Override
    public String toString() {
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            carNames.add(car.toString());
        }
        return String.join("\n", carNames);
    }

}
