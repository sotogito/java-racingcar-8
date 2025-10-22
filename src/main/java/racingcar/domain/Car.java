package racingcar.domain;

public class Car {
    private String name;
    private Integer distance;

    public Car(String name, Integer distance) {
        name = name.trim();
        validateName(name);

        this.name = name;
        this.distance = distance;
    }

    public void move() {
        this.distance++;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
