package _04_operation;

import static _03_function_parameter.Species.CHICKEN;
import static _03_function_parameter.Species.COW;
import static _03_function_parameter.Species.PIG;
import static _03_function_parameter.Species.SHEEP;

import _03_function_parameter.Meat;
import java.util.List;
import java.util.stream.Collectors;

public class Operation {

    public static void main(String[] args) {
        List<Meat> meats = List.of(
                new Meat(PIG, 600),
                new Meat(PIG, 750),
                new Meat(COW, 200),
                new Meat(CHICKEN, 1000),
                new Meat(SHEEP, 300),
                new Meat(SHEEP, 300),
                new Meat(SHEEP, 300),
                new Meat(SHEEP, 300)
        );

        // 중복 제거
        List<Meat> nonRepeatedMeats = meats.stream()
                .distinct()  // 중복 제거
                .collect(Collectors.toList());

        // 개수 세기 :
        long count = meats.stream()
                .filter(meat -> meat.species() == SHEEP)
                .count(); // 개수 세어주고요

        System.out.println(nonRepeatedMeats);
        System.out.println("count = " + count);

    }
}