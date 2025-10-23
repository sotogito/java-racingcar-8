package racingcar.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.number.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {
    private final static int MIN = 0;
    private final static int MAX = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }

}
