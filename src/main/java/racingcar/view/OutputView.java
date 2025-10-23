package racingcar.view;

import java.util.List;
import racingcar.dto.RacingResponse;

public class OutputView {
    private final static String WRITE_EXECUTION_RESULT_PRINTOUT = "살행 결과";
    private final static String WRITE_WINNER_PRINTOUT = "최종 우승자 : %s";

    public static void writeRacingResult(RacingResponse racingResponse) {
        List<String> carDistancePrintout = racingResponse.carDistancePrintout();
        List<String> winningCarNames = racingResponse.winningCarNames();

        System.out.println();
        writeExecutionResult(carDistancePrintout);
        writeWinnerResult(winningCarNames);
    }


    private static void writeExecutionResult(List<String> carDistancePrintout) {
        System.out.println(WRITE_EXECUTION_RESULT_PRINTOUT);

        for (String carName : carDistancePrintout) {
            System.out.println(carName);
            System.out.println();
        }
    }

    private static void writeWinnerResult(List<String> winningCarNames) {
        System.out.printf(WRITE_WINNER_PRINTOUT,
                String.join(", ", winningCarNames)
        );
    }

}
