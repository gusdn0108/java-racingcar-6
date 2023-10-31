package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import racingcar.Utils.ErrorMessage;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        isValidateCar(name);
        this.name = name;
    }

    public void move(int moveNumber) {
        if (moveNumber >= 4) {
            position++;
        }
    }

    public void isValidateCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_ONLY_FIVE_BELOW.getMessage());
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_BLANK.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name;
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
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
