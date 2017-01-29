package rule.thirty.planet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gunjunLee on 2017-01-29.
 */

// 상수별로 클래스 몸체와 별도 데이터를 갖는 enum 자료형
public enum Operation {
    PLUS("+") {
        double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        double apply(double x, double y) { return x / y; }
    };

    private final String symbol;
    Operation(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    // enum 자료형에 대한 fromString 메서드 구현
    private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();

    static {
        for(Operation op : values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    // 기존 enum 자료형에 없는 메서드를 switch문을 사용해 구현한 사례
    public static Operation inverse(Operation op) {
        switch (op) {
            case PLUS :
                return Operation.MINUS;
            case MINUS :
                return Operation.PLUS;
            case TIMES :
                return Operation.DIVIDE;
            case DIVIDE :
                return Operation.TIMES;
            default :
                throw new AssertionError("Unknown op : " + op);
        }
    }
}
