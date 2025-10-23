package racingcar.presentation;

import racingcar.application.RacingService;
import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

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

        OutputView.writeRacingResult(racingResponse);
    }

}
