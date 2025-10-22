package racingcar.controller;

import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;
import racingcar.service.RacingService;
import racingcar.view.InputView;

public class RacingController {
    private final RacingService racingService;

    public RacingController() {
        this.racingService = new RacingService();
    }

    public void race() {
        String carNames = InputView.readCarNames();
        Integer attempt = InputView.readAttempt();

        RacingRequest racingRequest = new RacingRequest(carNames, attempt);

        RacingResponse racingResponse = racingService.race(racingRequest);
    }

}
