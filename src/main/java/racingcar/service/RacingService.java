package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.AttemptCounter;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;

public class RacingService {
    private final NumberGenerator numberGenerator;

    public RacingService() {
        numberGenerator = new RandomNumberGenerator();
    }


    public RacingResponse race(RacingRequest racingRequest) {
        List<String> carNames = parseCarNames(racingRequest.carNames());
        Integer attempt = racingRequest.attempt();

        Cars cars = createRacing(carNames);
        AttemptCounter attemptCounter = new AttemptCounter(attempt);

        return processUpdateCarsDistance(cars, attemptCounter);
    }


    private RacingResponse processUpdateCarsDistance(Cars cars, AttemptCounter attemptCounter) {
        List<String> carDistancePrintout = new ArrayList<>();
        int carsCount = cars.getCarsCount();

        while (!attemptCounter.isOver()) {
            List<Integer> randomNumbers = getRandomNumbersByCarsCount(carsCount);
            cars.updateCarsDistance(randomNumbers);

            carDistancePrintout.add(cars.toString());
            attemptCounter.decreaseAttempt();
        }
        return new RacingResponse(carDistancePrintout, cars.getWinningCarNames());
    }

    private List<Integer> getRandomNumbersByCarsCount(int carsCount) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < carsCount; i++) {
            numbers.add(numberGenerator.generate());
        }
        return numbers;
    }

    private Cars createRacing(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new Cars(cars);
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(",", -1)).toList();
    }

}
