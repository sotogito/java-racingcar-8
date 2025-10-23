package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.attempt.AttemptCounter;
import racingcar.domain.car.Cars;
import racingcar.domain.car.CarsFactory;
import racingcar.domain.number.NumberGenerator;
import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;
import racingcar.infrastructure.RandomNumberGenerator;

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

        return processUpdateCarsDistance(cars, attemptCounter); //todo try-catch 예기치못함 오류?
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
