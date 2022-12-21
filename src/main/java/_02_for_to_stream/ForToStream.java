package _02_for_to_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForToStream {

    static class Member {
        private String name;
        private int age;

        public Member(String name) {
            this.name = name;
            this.age = 100;
        }

        public String name() {
            return name;
        }

        public int age() {
            return age;
        }
    }

    public static void main(String[] args) {
        List<String> names = List.of("연", "석", "풍", "불", "노말", "방장");

        // TODO 1. 향상된 for문
        // TODO 반환 값이 없을 때
        for (String name : names) {
            System.out.println("향상된 for문 : " + name);  //
        }

        // TODO forEach(Consumer<? super T> action)
        // TODO 반환 값이 없는 경우, 아래와 같이 Collection에 기본 구현된 foreach를 사용할 수 있다.
        // TODO 이는 사실 위의 for문과 동일하다. (내부 구조 동일)
        // TODO stream에도 forEach()가 있으나, 성능 상 문제로 사용하지 말것을 권고한다. (자세한 이유는 찾아보겠음)
        names.forEach(member -> System.out.println("Collection의 forEach : " + member));  // 람다 표현식
//        names.stream().forEach(member -> System.out.println("Collection의 forEach : " + member));

        // TODO 반환 값이 있을 때 (예를 들어, 값을 특정 객체에 담고 새로운 리스트를 만들 때)
        List<Member> members1 = new ArrayList<>();
        for (String name : names) {
            members1.add(new Member(name));
        }


        System.out.println("여기를 보세요 ");
        List<Member> members2 = names.stream()  // TODO "연", "석", "풍", "불", "노말", "방장"이 하나씩 돌아간다.
                .peek(System.out::println)
                .map(name -> new Member(name))  // TODO String이 Member로 매핑된다. map은 반환 값이 있을 때 사용한다.
                .peek(System.out::println)
                .collect(Collectors.toList());  // TODO 반환된 Member 값들을 List로 모아준다.


        // TODO 조건문이 있을 때
        List<Member> membersNotHaveLeader1 = new ArrayList<>();
        for (String name : names) {
            if (!name.equals("방장")) {
                membersNotHaveLeader1.add(new Member(name));
            }
        }

        // 지연 연산 (lazy evaluation)
        List<Member> membersNotHaveLeader2 = names.stream()
                .filter(name -> !name.equals("방장"))  // TODO 방장이 아닌 사람들은 true. true면 해당 필터를 통과한다.
                .map(name -> new Member(name))
                .collect(Collectors.toList());  // 종단연산

        List<Member> members = List.of(
                new Member("방"),
                new Member("풍"),
                new Member("석"),
                new Member("연"),
                new Member("노말")
        );

        Comparator<Member> before = Comparator.comparingInt(Member::age);  // 나이대로 정렬.

        List<Member> collect = members.stream()
                .sorted(
                        before.thenComparing(Member::name, Comparator.naturalOrder())  // 자연적인 순서로 정렬하겠다.
                )
                .collect(Collectors.toList());

        // TODO 2. index를 이용하는 for문
        for (int i = 0; i < names.size(); i++) {
            System.out.println("index를 이용하는 for문 : " + names.get(i));
        }

        // TODO stream으로도 index에 접근할 수 있다.
        IntStream.range(0, names.size())  // IntStream
                .forEach(i -> System.out.println("index를 이용하는 스트림 : " + names.get(i)));

        // TODO Map으로도 바꿀 수 있다.
        // TODO 이름의 순서 대로 key를 순번으로 하고, value를 이름으로 하는 Map으로 바꿔보자!

        // TODO 기존 접근 방식
        Map<Integer, String> map1 = new HashMap<>();
        for (int i = 1; i < names.size(); i++) {
            map1.put(i, names.get(i));
        }

        map1.getOrDefault(Integer.MAX_VALUE, "아주 큰 수");

        // TODO 스트림
        Map<Integer, String> map2 = IntStream.range(1, names.size())  // 기본형 int
                .boxed() // IntStream은 기본형 int에 대한 스트림이기 때문에, boxing을 해줘야 Stream<Integer>로 변환 됨.  // Integer
                .collect(Collectors.toUnmodifiableMap(
                        i -> i,  // key는 숫자를 그대로 쓴다.  자매품 : Function.identity()
                        i -> names.get(i))
                );

        System.out.println("여기를 보세요");
        HashMap<Integer, List<String>> map3 = new HashMap<>(); // 리스트가 초기화가 안 된 상태
        int maxValue = Integer.MAX_VALUE;
        map3.computeIfAbsent(maxValue, integer -> new ArrayList<>()).add("아주 큰 수");
    }
}
