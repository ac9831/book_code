package rule.eleven.stack;

/**
 * Created by gunjunLee on 2017-01-13.
 */
public class Stack {

    private Object[] elements;

//    clone을 재귀적으로 호출
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch ( CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
