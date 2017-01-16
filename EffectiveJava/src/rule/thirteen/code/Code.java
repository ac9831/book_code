package rule.thirteen.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gunjunLee on 2017-01-13.
 */
public class Code {
    // 보안 문제를 초래할 수 있는 코드
    public static final Code[] VALUES = {};

    // 첫 번째 해결 방법
    private static final Code[] FPRIVATE_VALUES = {};
    public static final List<Code> FVALUES = Collections.unmodifiableList(Arrays.asList(FPRIVATE_VALUES));

    // 두 번째 해결방법
    private static final Code[] TPRIVATE_VALUES = {};
    public static final Code[] values() {
        return TPRIVATE_VALUES.clone();
    }

}
