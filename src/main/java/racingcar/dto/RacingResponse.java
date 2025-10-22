package racingcar.dto;

import java.util.List;

public record RacingResponse(
        List<String> carDistancePrintout,
        List<String> winningCarNames
) {
}
