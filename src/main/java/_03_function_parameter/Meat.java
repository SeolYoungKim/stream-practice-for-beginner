package _03_function_parameter;

public record Meat(Species species, int weight) {

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Meat meat = (Meat) o;
        return weight == meat.weight && species == meat.species;
    }

}
