package racingcar.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.number.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
