package racingcar.domain.attempt;

public class AttemptCounter {
    private int attempt;

    public AttemptCounter(Integer attempt) {
        validateAttemptRange(attempt);

        this.attempt = attempt;
    }


    public boolean isOver() {
        return attempt <= 0;
    }

    public void decreaseAttempt() {
        attempt--;
    }


    private void validateAttemptRange(Integer attempt) {
        if (attempt == null || attempt < 1 || attempt > 1000) {
            throw new IllegalArgumentException("시도 횟수는 1~1,000까지 입력 가능합니다.");
        }
    }

}
