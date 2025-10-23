package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String READ_CAR_NAME_PRINTOUT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String READ_ATTEMPT_PRINTOUT = "시도할 횟수는 몇 회인가요?";

    public static String readCarNames() {
        try {
            System.out.println(READ_CAR_NAME_PRINTOUT);

            return Console.readLine().trim();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static Integer readAttempt() {
        try {
            System.out.println(READ_ATTEMPT_PRINTOUT);

            return Integer.parseInt(Console.readLine().trim());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

}
