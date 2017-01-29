package rule.thirtythree.enums;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by gunjunLee on 2017-01-29.
 */
public class Main {

    public static void main(String[] args) {

        Herb[] garden = {};

        Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
        for(Herb.Type t : Herb.Type.values()) {
            herbsByType.put(t, new HashSet<Herb>());
        }
        for(Herb h : garden) {
            herbsByType.get(h.type).add(h);
        }
        System.out.println(herbsByType);
    }
}
