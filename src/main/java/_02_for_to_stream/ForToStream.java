package _02_for_to_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForToStream {

    static class Member {
        private String name;

        public Member(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<String> names = List.of("연", "석", "풍", "노말", "방장");

        // TODO 1. 향상된 for문
        // TODO 반환 값이 없을 때
        for (String name : names) {
            System.out.println("향상된 for문 : " + name);
        }

        // TODO forEach(Consumer<? super T> action)
        // TODO 반환 값이 없는 경우, 아래와 같이 Collection에 기본 구현된 foreach를 사용할 수 있다.
        // TODO 이는 사실 위의 for문과 동일하다. (내부 구조 동일)
        // TODO stream에도 forEach()가 있으나, 성능 상 문제로 사용하지 말것을 권고한다. (자세한 이유는 찾아보겠음)
        names.forEach(member -> System.out.println("Collection의 forEach : " + member));  // 람다 표현식


        // TODO 반환 값이 있을 때 (예를 들어, 값을 특정 객체에 담고 새로운 리스트를 만들 때)
        List<Member> members1 = new ArrayList<>();
        for (String name : names) {
            members1.add(new Member(name));
        }

        List<Member> members2 = names.stream()  // TODO "연", "석", "풍", "노말", "방장"이 하나씩 돌아간다.
                .map(name -> new Member(name))  // TODO String이 Member로 매핑된다. map은 반환 값이 있을 때 사용한다.
                .collect(Collectors.toList());  // TODO 반환된 Member 값들을 List로 모아준다.


        // TODO 조건문이 있을 때
        List<Member> membersNotHaveLeader1 = new ArrayList<>();
        for (String name : names) {
            if (!name.equals("방장")) {
                membersNotHaveLeader1.add(new Member(name));
            }
        }

        List<Member> membersNotHaveLeader2 = names.stream()
                .filter(name -> !name.equals("방장"))  // TODO 방장이 아닌 사람들은 true. true면 해당 필터를 통과한다.
                .map(name -> new Member(name))
                .collect(Collectors.toList());



        // TODO 2. index를 이용하는 for문
        for (int i = 0; i < names.size(); i++) {
            System.out.println("index를 이용하는 for문 : " + names.get(i));
        }

        // TODO stream으로도 index에 접근할 수 있다.
        IntStream.range(0, names.size())  // IntStream
                .forEach(i -> System.out.println("index를 이용하는 스트림 : " + names.get(i)));

    }
}
