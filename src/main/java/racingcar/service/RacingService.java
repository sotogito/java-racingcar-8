package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.AttemptCounter;
import racingcar.domain.Cars;
import racingcar.domain.CarsFactory;
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
        String carNames = racingRequest.carNames();
        Integer attempt = racingRequest.attempt();

        Cars cars = CarsFactory.create(carNames);
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

}
