package _01_functional_interface;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterface {
    public static void main(String[] args) {
        // void accept(T t)
        // 소비자
        Consumer<String> c = (str) -> System.out.println(str);  // T to void

        // 공급자
        Supplier<String> s = () -> "하이용";  // 무에서 유를 창조

        // 조건식
        Predicate<String> p = str -> str.equals("방장");  // T to boolean  ->  stream.filter(Predicate)

        Function<String, Integer> f = str -> Integer.parseInt(str);  // T to R

        BiFunction<Integer, Integer, Integer> biF = (a, b) -> a + b;  // (T, U) to
        BinaryOperator<Integer> bi = (a, b) -> a + b;
        UnaryOperator<Integer> un = a -> a;

        // https://mkyong.com/java8/is-comparator-a-function-interface-but-it-has-two-abstract-methods/
        Comparator<Fake> co1 = (f1, f2) -> f2.forComparing() - f1.forComparing();  // reverse
        Comparator<Fake> co2 = Comparator.comparingInt((fake) -> fake.forComparing());
        Comparator<Fake> co3 = Comparator.comparingInt(Fake::forComparing);

        Runnable r1 = () -> {
        };
        Runnable r2 = () -> System.out.println("하잉");  // void to void

        // Supplier<String> s = () -> "하이용";  // 무에서 유를 창조
        Callable<String> ca = () -> "하이용";  // 무에서 유를 창조
    }
}
