package rule.eighteen.list;

import java.util.Map;

/**
 * Created by gunjunLee on 2017-01-13.
 */
public abstract class AbstractMapEntry<K,V> implements Map.Entry<K, V>{
    // 기본 메서드
    public abstract K getKey();
    public abstract V getValue();

    // 변경 가능 맵에 들어갈 Entry는 이 메서드를 재정의해야 한다.
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    // Map.Entry.equals의 일반 규약 구현

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> arg =  (Map.Entry) obj;
        return equals(getKey(), arg.getKey()) && equals(getValue(), arg.getValue());
    }

    private static boolean equals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    @Override
    public int hashCode() {
        return hashCode(getKey()) ^ hashCode(getValue());
    }
    private static int hashCode(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }
}
