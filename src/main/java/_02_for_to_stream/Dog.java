package _02_for_to_stream;

import java.util.Objects;

public class Dog implements Comparable<Dog> {

    private final int height;

    public Dog(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return height == dog.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }

    // List.of("말티즈", "포메", "불독" ...)
    @Override
    public int compareTo(Dog other) {
        return this.height - other.height;  // 양수, 0, 음수
    }
}
