package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
    }

    public List<String> getWinningCarNames() {
        List<String> winningCarNames = new ArrayList<>();

        Car winningCar = Collections.max(cars); //todo 다른 방법 없나
        for (Car car : cars) {
            if (car.isWinningCar(winningCar)) {
                winningCarNames.add(car.getName());
            }
        }
        return winningCarNames;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(car.toString()).append("/n");
        }
        return sb.toString();
    }

}
