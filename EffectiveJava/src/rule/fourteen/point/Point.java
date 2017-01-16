package rule.fourteen.point;

/**
 * Created by gunjunLee on 2017-01-13.
 */
public class Point {
    private double x;
    private double y;

    // 정말 이래도 되나 싶다.
    public final int hour = 1;
    public final int minute = 50;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
