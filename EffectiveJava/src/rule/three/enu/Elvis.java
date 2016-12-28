package rule.three.enu;

/*
    Enum 싱글턴을 선언하면 훨씬 간결하고 직렬화를 하더라도 싱글턴 패턴을 유지할 수 있다. 또한 리플렉션을 통한 공격에도 안전하다.
    Enum에 대한 개념은 아래 코드를 보면 이해 될 것이다.

    class Day {
        public final static Day MONDAY = new Day();
        public final sttaic Day TUESDAY = new DAY();
    }

    위의 클래스와 아래의 Enum의 의미가 같다.

    enum Day {
        MONDAY, TUESDAY;
    }

 */
public enum Elvis {
    INSTANCE;

    public static Elvis getInstance() {
        return INSTANCE;
    }
}
