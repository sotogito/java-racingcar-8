package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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
        return IntStream.range(0, carsCount)
                .mapToObj(i -> numberGenerator.generate())
                .toList();
    }

    private Cars createRacing(List<String> carNames) {
        return new Cars(
                carNames.stream()
                        .map(Car::new)
                        .toList()
        );
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(",", -1)).toList();
    }

}
