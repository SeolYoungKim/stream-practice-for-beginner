package _03_function_parameter;

import java.util.Objects;

public class MeatForJava11 {

    private final Species species;
    private final int weight;

    public MeatForJava11(Species species, int weight) {
        this.species = species;
        this.weight = weight;
    }

    public Species species() {
        return species;
    }

    public int weight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MeatForJava11 that = (MeatForJava11) o;
        return weight == that.weight && species == that.species;
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, weight);
    }
}
