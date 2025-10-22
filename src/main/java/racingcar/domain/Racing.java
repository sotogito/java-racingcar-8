package racingcar.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Racing {
    private final List<Car> cars;
    private int attempt;

    public Racing(List<Car> cars, int attempt) {
        validateCarCount(cars);
        validateDuplicatedName(cars);
        validateAttemptCount(attempt);

        this.cars = cars;
        this.attempt = attempt;
    }


    public boolean isEndAttempt() {
        return attempt <= 0;
    }

    public int getCarsCount() {
        return cars.size();
    }

    public List<Car> updateCarsDistance(List<Integer> randomNumbers) {
        if (cars.size() != randomNumbers.size()) {
            throw new IllegalArgumentException("오류가 발생했습니다.");
        }

        Map<Car, Integer> carDistanceMap = new HashMap<>();
        for (int i = 0; i < cars.size(); i++) {
            carDistanceMap.put(cars.get(i), randomNumbers.get(i));
        }

        for (Entry<Car, Integer> entry : carDistanceMap.entrySet()) {
            Car car = entry.getKey();
            Integer randomNumber = entry.getValue();

            if (randomNumber > 4) {
                car.move();
            }
        }
        return cars;
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

    private void validateAttemptCount(int attempt) {
        if (attempt < 1 || attempt > 10000) {
            throw new IllegalArgumentException("시도 횟수는 1~10,000번까지 입력 가능합니다.");
        }
    }

}
