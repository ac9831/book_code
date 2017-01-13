package rule.eleven.hashtable;

/**
 * Created by gunjunLee on 2017-01-13.
 */
public class HashTable implements Cloneable{
    private Entry[] buckrts = new Entry[0];

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // 이 Entry 객체가 첫 원소인 연결 리스트를 재귀적으로 복사 -> 이방식은 리스트가 길면 스택 오버플로가 난다.
//        Entry deeCopy()  {
//            return new Entry(key, value, next == null ? null : next.deepopy());
//        }

        // 이 Entry 객체가 첫 원소인 연결 리스트를 순환문으로 복사
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);
            for(Entry p = result;p.next != null; p = p.next) {
                p.next = new Entry(p.next.key, p.next.value, p.next.next);
            }
            return result;
        }
    }

    @Override
    public HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckrts = new Entry[buckrts.length];
            for(int i=0;i<buckrts.length;i++) {
                if(buckrts[i] != null) {
                    result.buckrts[i] = buckrts[i].deepCopy();
                }
            }
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
