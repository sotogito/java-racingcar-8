package racingcar.infrastructure;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.number.MoveStrategy;

public class RandomNumberStrategy implements MoveStrategy {
    private final static int MIN = 0;
    private final static int MAX = 9;
    private final static int MOVE = 4;

    @Override
    public boolean canMove() {
        int randomNumber = Randoms.pickNumberInRange(MIN, MAX);

        return randomNumber >= MOVE;
    }

}
