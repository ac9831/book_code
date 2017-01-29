package rule.thirty.planet;

/**
 * Created by gunjunLee on 2017-01-29.
 */
public class OperationMain {

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for(Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

}
