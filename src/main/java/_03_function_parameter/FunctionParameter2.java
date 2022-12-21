package _03_function_parameter;

import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionParameter2 {

    // TODO 무언가를 "반드시"실행한 후에 생성자로 객체를 생성하는 로직이 있다고 해보자.
    public static Hamburger constructHamburger(String bun, Meat patty, String lettuce) {
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");

        return new Hamburger(bun, patty, lettuce);
    }

    // TODO 중복 오짐..! 객체가 만약 ... 100개가 넘는다면 너무 어질어질하다!
    public static Meat constructMeat(Species species, int weight) {
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");
        System.out.println("중복중복");  // 반드시 실행해야 되는 메서드가 있는 경우

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

    // TODO 번외 Function<T, R> 도 쓸 수 있음. T형태의 값을 받아서 R을 반환하는 함수형 인터페이스.
    public static <T, R> R construct(Function<T, R> function, T t) {
        System.out.println("대충 많은 일");
        return function.apply(t);
    }

    public static void main(String[] args) {
        // 동작 예제!
        Supplier<Meat> meatSupplier = () -> new Meat(Species.COW, 100);
        Meat meat = construct(meatSupplier);

        Supplier<Hamburger> hamburgerSupplier = () -> new Hamburger("고오급 번", meat,
                "양상추");

        Hamburger hamburger = construct(hamburgerSupplier);

        Function<Integer, Apple> function = Apple::new;
        Apple apple = construct(function, 100);
        System.out.println(apple.weight);
    }

    static class Apple {
        private final int weight;

        public Apple(int weight) {
            this.weight = weight;
        }

        public int weight() {
            return weight;
        }
    }
}
