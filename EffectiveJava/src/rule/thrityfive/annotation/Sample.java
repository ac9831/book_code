package rule.thrityfive.annotation;

/**
 * Created by gunjunLee on 2017-01-31.
 */
public class Sample {
    @Test2
    public static void m1() { }
    public static void m2() { }
    @Test2 public static void m3() {
        throw new RuntimeException("Boom");
    }
    public static void m4() {}
    @Test2 // 잘못된 사용 : static 메서드가 아님
    public void m5() { }
    public static void m6() { }
    @Test2
    public static void m7() {
        throw new RuntimeException("Crash");
    }
    public static void m8() { }
}
