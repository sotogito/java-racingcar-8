package racingcar.domain;

public class AttemptCounter {
    private int attempt;

    public AttemptCounter(int attempt) {
        validateAttemptRange(attempt);

        this.attempt = attempt;
    }


    public boolean isOver() {
        return attempt <= 0;
    }

    public void decreaseAttempt() {
        attempt--;
    }


    private void validateAttemptRange(int attempt) {
        if (attempt < 1 || attempt > 1000) {
            throw new IllegalArgumentException("시도 횟수는 1~1000까지 입력 가능합니다.");
        }
    }

}
