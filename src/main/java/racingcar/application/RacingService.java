package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.attempt.AttemptCounter;
import racingcar.domain.car.Cars;
import racingcar.domain.car.CarsFactory;
import racingcar.domain.number.MoveStrategy;
import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;
import racingcar.infrastructure.RandomNumberStrategy;

public class RacingService {
    private final MoveStrategy moveStrategy;

    public RacingService() {
        moveStrategy = new RandomNumberStrategy();
    }


    public RacingResponse race(final RacingRequest racingRequest) {
        final String carNames = racingRequest.carNames();
        final Integer attempt = racingRequest.attempt();

        Cars cars = CarsFactory.create(carNames);
        AttemptCounter attemptCounter = new AttemptCounter(attempt);

        return getRacingResult(cars, attemptCounter);
    }


    private RacingResponse getRacingResult(final Cars cars, final AttemptCounter attemptCounter) {
        List<String> carDistancePrintout = processAllCarsMoving(cars, attemptCounter);
        List<String> winningCarNames = cars.getWinningCarNames();

        return new RacingResponse(carDistancePrintout, winningCarNames);
    }

    private List<String> processAllCarsMoving(final Cars cars, final AttemptCounter attemptCounter) {
        List<String> carDistancePrintout = new ArrayList<>();

        while (!attemptCounter.isOver()) {
            cars.moveAllCars(moveStrategy);

            carDistancePrintout.add(cars.toString());
            attemptCounter.decreaseAttempt();
        }
        return List.copyOf(carDistancePrintout);
    }

}
