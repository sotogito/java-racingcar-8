package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final String name;
    private Integer distance;

    public Car(String name) {
        name = name.trim();
        validateName(name);

        this.name = name;
        this.distance = 0;
    }


    public String getName() {
        return name;
    }

    public void move() {
        this.distance++;
    }

    public boolean isWinningCar(Car otherCar) {
        return Objects.equals(distance, otherCar.distance);
    }


    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자까지 입력 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Car o) {
        return this.distance.compareTo(o.distance);
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(distance);
    }

}
