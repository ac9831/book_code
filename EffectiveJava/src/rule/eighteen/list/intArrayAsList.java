package rule.eighteen.list;

import java.util.AbstractList;
import java.util.List;

/**
 * Created by gunjunLee on 2017-01-13.
 */
public class intArrayAsList {
    static List<Integer> intArrayAsList(final int[] a) {
        if(a == null) {
            throw new NullPointerException();
        }

        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                return a[index];
            }

            @Override
            public int size() {
                return a.length;
            }

            @Override
            public Integer set(int index, Integer element) {
                int oldVal = a[index];
                a[index] = element; // 자동 비객체화
                return oldVal;      // 자동 객체화
            }
        };
    }
}
