package rule.twentyfive.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gunjunLee on 2017-01-18.
 */
public class Generic {

    private int size = 10;
    private Object[] elements = {};

    // @SuppressWarnings의 적용 범위를 줄이기 위해 지역 변수 사용
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            // 아래의 형변환은 배열의 자료형이 인자로 전달된 자료형인 T[]와 같으므로 정확하다.
            @SuppressWarnings("unchecked") T[] result = (T[]) Arrays.copyOf(elements, size, a.getClass());
            return result;
        }
        System.arraycopy(elements, 0, a, 0, size);
        if(a.length > size) {
            a[size] = null;
        }
        return a;
    }

//    =================================================================================================

    // 제너릭 없이 작성한 reduce 함수. 병행성 문제가 있다.
    static Object reduceF(List list, Function f, Object initVal) {
        synchronized (list) {
            Object result = initVal;
            for(Object o : list) {
                result = f.apply(result, o);
            }
            return result;
        }
    }

    interface Function<T> {
        T apply(T args1, T arg2);
    }

    // 제네릭 없이 작성한 reduce 함수. 병행성 문제는 없다.
    static Object reduceT(List list, Function f, Object initVal) {
        Object[] snapshot = list.toArray();
        Object result = initVal;
        for(Object o : snapshot) {
            result = f.apply(result, o);
        }
        return result;
    }

    // reduce의 제네릭 버전 - 컴파일 불가!
//    static <E> E reduceG(List<E> list, Function<E> f, E initVal) {
//        E[] snapshot = list.toArray(); // 리스트에 락을 건다.
//        E result = initVal;
//        for(E e : snapshot) {
//            result = f.apply(result, e);
//        }
//        return result;
//    }

    static <E> E reduceGT(List<E> list, Function<E> f, E initVal) {
        List<E> snapshot;
        synchronized (list) {
            snapshot = new ArrayList<E>(list);
        }
        E result = initVal;
        for(E e : snapshot) {
            result = f.apply(result, e);
        }
        return result;
    }
}
