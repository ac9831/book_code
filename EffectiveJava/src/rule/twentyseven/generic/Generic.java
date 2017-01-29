package rule.twentyseven.generic;

import java.util.*;

/**
 * Created by gunjunLee on 2017-01-18.
 */
public class Generic {
    // 무인자 자료형 사용 - 권할 수 없는 방법
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    // 제네릭 메서드
    public static <E> Set<E> unionG(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }


    public static void main(String[] args) {
        // 제너릭 메서드 사용 예시
        Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick", "Harry"));
        Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe", "Curly"));
        Set<String> aflCio = unionG(guys, stooges);
        System.out.print(aflCio);


//        ==============================================================
//      제네릭 싱글턴 사용 예제
        String[] strings = {"jute", "hemp", "nylon" };
        UnaryFunction<String> sameString = identityFunction();
        for(String s: strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1,2.0,3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for(Number n : numbers) {
            System.out.println(sameNumber.apply(n));
        }
    }



    public interface UnaryFunction<T> {
        T apply(T arg);
    }

//    제너릭 싱글턴 팩터리 패턴
    private static UnaryFunction<Object> IDENTITY_FUNCTION =
        new UnaryFunction<Object>() {
            public Object apply(Object arg) {
                return arg;
            }
        };

    // IDENTITY_FUNCTION은 무상태 객체고 형인자는 비한정 인자이므로(unbounded) 모든 자료형이 같은 객체를 공유해도 안전하다.
    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction) IDENTITY_FUNCTION;
    }



    // 리스트의 최대 값 반환 - 재귀적 자료형 한정 사용
    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> i = list.iterator();
        T result = i.next();
        while(i.hasNext()) {
            T t = i.next();
            if(t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }
}
