package rule.thrityfive.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gunjunLee on 2017-01-31.
 */
public class RunTest3 {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        Class testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Exception>[] excTypes = m.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(exc)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("Test %s failed: %s %n", m, exc);
                    }
                } catch (Exception exc) {
                    System.out.println("INVALID @Test: " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }


    @ExceptionTest({ IndexOutOfBoundsException.class, NullPointerException.class })
    public static void doublyBad() {
        List<String> list = new ArrayList<String>();

        // 자바 명세에는 아래와 같이 addAll을 호출하면 IndexOutOfBoundsException이나 NullPointerException이 발생한다고
        // 명시되어 있다.
        list.addAll(5, null);
    }
}
