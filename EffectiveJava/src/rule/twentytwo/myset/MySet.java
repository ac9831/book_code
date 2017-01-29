package rule.twentytwo.myset;

import java.util.AbstractSet;
import java.util.Iterator;

// 비-정적 멤버 클래스의 전형적 용례
public class MySet<E> extends AbstractSet<E> {

    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public int size() {
        return 0;
    }

    private class MyIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
}
