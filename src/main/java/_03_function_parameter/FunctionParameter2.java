package _03_function_parameter;

import java.util.function.Supplier;

public class FunctionParameter2 {

    // TODO 무언가를 "반드시"실행한 후에 생성자로 객체를 생성하는 로직이 있다고 해보자.
    public static Hamberger constructHamberger(String bun, Meat patty, String lettuce) {
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");

        return new Hamberger(bun, patty, lettuce);
    }

    // TODO 중복 오짐..! 객체가 만약 ... 100개가 넘는다면 너무 어질어질하다!
    public static Meat constructMeat(Species species, int weight) {
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");

        return new Meat(species, weight);
    }

    // TODO Supplier<T> 로 생성자를 사용하는 이유?
    public static <T> T construct(Supplier<T> supplier) {
        System.out.println("여기서");
        System.out.println("많은 무언가를 실행하는데");
        System.out.println("이게 객체를 생성할 때 마다 반복되는 메서드임");
        System.out.println("객체가 100개가 모두 반드시 많은 무언가를 실행하고 나서 생성이 이뤄져야 하는데");
        System.out.println("Suppler가 없다면 끔찍한 일이 벌어졌을 것..!");

        return supplier.get();  // 많은 무언가를 수행한 후에 메서드를 수행할 수 있도록 해준다.
    }

    public static void main(String[] args) {
        // 동작 예제!
        Supplier<Meat> meatSupplier = () -> new Meat(Species.COW, 100);
        Meat meat = construct(meatSupplier);

        Supplier<Hamberger> hambergerSupplier = () -> new Hamberger("고오급 번", meat,
                "양상추");

        Hamberger hamberger = construct(hambergerSupplier);
    }
}
