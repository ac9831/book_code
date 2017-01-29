package rule.twentysix.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Created by gunjunLee on 2017-01-18.
 */
// 제너릭을 사용해 작성한 최초 Stack 클래스 - 컴파일 불가!
public class StackG<E> {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackG() {
        elements = new E[DEFAULT_INITIAL_CAPACITY]; // 오류가 난다.
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }

//        자료형이 E인 원소만 push하므로, 아래의 형변환은 안전하다.
        @SuppressWarnings("uncheck") E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }

    public boolean isEmpty() {
        return  size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

//    제네릭 Stack의 사용 예
    public static void main(String[] args) {
        StackG<String> stack = new StackG<String>();
        for(String arg : args) {
            stack.push(arg);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toUpperCase());
        }
    }
}
