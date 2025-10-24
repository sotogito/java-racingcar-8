package racingcar.application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.dto.RacingRequest;
import racingcar.dto.RacingResponse;

class RacingServiceTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void race_결과_테스트() {
        RacingService racingService = new RacingService();
        RacingRequest racingRequest = new RacingRequest("가,나,다", 2);

        assertRandomNumberInRangeTest(
                () -> {
                    RacingResponse racingResponse = racingService.race(racingRequest);

                    // 첫 번째 시도
                    String firstAttempt = racingResponse.carDistancePrintout().get(0);
                    assertThat(firstAttempt).contains("가 : -", "나 : -", "다 : ");

                    // 두 번째 시도
                    String secondAttempt = racingResponse.carDistancePrintout().get(1);
                    assertThat(secondAttempt).contains("가 : --", "나 : -", "다 : ");

                    // 우승자 검증
                    assertThat(racingResponse.winningCarNames()).contains("가");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, STOP
        );
    }

}
