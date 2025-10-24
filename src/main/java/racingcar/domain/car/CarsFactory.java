package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;

public class CarsFactory {
    private final static String SCAR_NAME_DELIMITER = ",";
    private final static int CAR_NAME_SPLIT_LIMIT = -1;

    public static Cars create(final String inputCarNames) {
        final List<String> carNames = parseCarNames(inputCarNames);

        return new Cars(
                carNames.stream()
                        .map(CarsFactory::createCar)
                        .toList()
        );
    }


    private static Car createCar(final String carName) {
        return new Car(carName.trim());
    }

    private static List<String> parseCarNames(final String carNames) {
        return Arrays.stream(carNames.split(SCAR_NAME_DELIMITER, CAR_NAME_SPLIT_LIMIT))
                .toList();
    }

}
