package rule.twentyone.comparator;

import java.io.Serializable;

/**
 * Created by gunjunLee on 2017-01-16.
 */
public class Host {
    private static class StrLenCmp implements Comparator<String>, Serializable {
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }

    // 이 비교자는 직렬화가 가능
    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
}
