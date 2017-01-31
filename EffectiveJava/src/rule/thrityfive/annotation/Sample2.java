package rule.thrityfive.annotation;

/**
 * Created by gunjunLee on 2017-01-31.
 */
public class Sample2 {
    @Test(ArithmeticException.class)
    public static void m1() {
        int i = 0;
        i = i / i;
    }
    @Test(ArithmeticException.class)
    public static void m2() {
        int[] a = new int[0];
        int i = a[1];
    }

    @Test(ArithmeticException.class)
    public static void m3() { }
}
