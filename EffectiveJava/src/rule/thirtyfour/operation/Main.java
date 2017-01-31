package rule.thirtyfour.operation;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by gunjunLee on 2017-01-31.
 */
public class Main {

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        test(BasicOperation.class, x, y);
        testCollection(Arrays.asList(BasicOperation.values()), x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (Operation op : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static <T extends Enum<T> & Operation> void testCollection(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
