package racingcar.view;

import java.util.List;
import racingcar.dto.RacingResponse;

public class OutputView {

    public static void writeRacingResult(RacingResponse racingResponse) {
        List<String> carDistancePrintout = racingResponse.carDistancePrintout();
        List<String> winningCarNames = racingResponse.winningCarNames();

        System.out.println();
        System.out.println("살행 결과");
        for (String carName : carDistancePrintout) {
            System.out.println(carName);
            System.out.println();
        }

        System.out.printf("최종 우승자 : %s", String.join(", ", winningCarNames));

    }
}
