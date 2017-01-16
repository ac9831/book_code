package rule.twenty.figure;

/**
 * Created by gunjunLee on 2017-01-16.
 */
public class Figure_Tag {
    enum Shape {
        RECTANGLE, CIRCLE
    };

    // 어떤 모양인지 나타내는 태그 필드
    final Shape shape;

    // 태그가 RECTANGLE일 때만 사용되는 필드들
    double length;
    double width;

    // 태그가 CIRCLE일 때만 사용되는 필드들
    double radius;

    // 원일 만드는 생성자
    Figure_Tag(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // 사각형을 만드는 생성자
    Figure_Tag(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError();
        }
    }
}
