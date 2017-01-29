package rule.thirty.planet;

/**
 * Created by gunjunLee on 2017-01-29.
 */
// 데이터와 연산을 구비한 enum 자료형
public enum Planet {
    MERCURY (3.302e+23, 2.439e6),
    VENUS   (4.869e+24, 6.052e6),
    EARTH   (5.975e+24, 6.378e6),
    MARS    (6.419e+23, 3.393e6),
    JUPITER (1.899e+27, 7.149e7),
    SATURN  (5.685e+26, 6.027e7),
    URANUS  (8.683e+25, 2.556e7),
    NEPTUNE (1.024e+26, 2.477e7);

    private final double mass;              // 킬로그램 단위
    private final double radius;            // 미터 단위
    private final double surfaceGravity;    // m / s^2

    // 중력 상수(m^3 /kg s^2)
    private static final double G = 6.67300E-11;

    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double main()                {return mass;}
    public double getRadius()           {return radius;}
    public double surfaceGravity()      {return surfaceGravity;}

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }

}
