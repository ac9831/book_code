package rule.thritynine.period;

import java.util.Date;

/**
 * Created by gunjunLee on 2017-02-15.
 */
public class Period {
    private final Date start;
    private final Date end;

    /*public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }*/

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + " after " + this.end);
        }
    }

    /*public Date start() {
        return start;
    }

    public Date end() {
        return end;
    }*/

    // 수정된 접근자 - 내부 필드의 방어적 복사본 생성
    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public static void main(String[] args) {
        // Period 객체의 내부 구조를 공격
        Date start = new Date();
        Date end = new Date();
        Period p = new Period(start, end);
        end.setYear(78); // p의 내부를 변경!

        // 두 번째 공격 형태
        p.end().setYear(78); // p의 내부를 변경!

    }
}
