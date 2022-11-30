package _03_function_parameter;

import static _03_function_parameter.Meat.Species.CHICKEN;
import static _03_function_parameter.Meat.Species.COW;
import static _03_function_parameter.Meat.Species.PIG;
import static _03_function_parameter.Meat.Species.SHEEP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FunctionParameter {

    // TODO 함수형 파라미터를 안쓰면, 아래와 같이 조건 별로 다만들어야된다. -> 에바임 조건 막 20개 추가되면 이제 큰일남;
    public static List<Meat> meatsLessThan600g(List<Meat> meats) {
        List<Meat> results = new ArrayList<>();

        for (Meat meat : meats) {
            if (meat.weight() <= 600) {
                results.add(meat);
            }
        }

        return results;
    }

    public static List<Meat> meatsOfPig(List<Meat> meats) {
        List<Meat> results = new ArrayList<>();

        for (Meat meat : meats) {
            if (meat.species() == PIG) {
                results.add(meat);
            }
        }

        return results;
    }

    // TODO 아래와 같이 구성하면 유동적으로 구성할 수 있음
    public static List<Meat> meatsSortedByAnyConditions(List<Meat> meats, Predicate<Meat> predicate) {
        List<Meat> results = new ArrayList<>();

        for (Meat meat : meats) {
            if (predicate.test(meat)) {
                results.add(meat);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        // 동작 예제!
        List<Meat> meats = List.of(new Meat(PIG, 600), new Meat(PIG, 750),
                new Meat(COW, 200), new Meat(CHICKEN, 1000),
                new Meat(SHEEP, 300));

        Predicate<Meat> byWeight = meat -> meat.weight() > 600;
        Predicate<Meat> bySpecies = meat -> meat.species() == PIG;

        List<Meat> sortedByWeight = meatsSortedByAnyConditions(meats, byWeight);
        List<Meat> sortedBySpecies = meatsSortedByAnyConditions(meats, bySpecies);

        System.out.println("sortedByWeight = " + sortedByWeight);
        System.out.println("sortedBySpecies = " + sortedBySpecies);
    }
}
