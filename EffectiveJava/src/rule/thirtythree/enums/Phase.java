package rule.thirtythree.enums;

import java.util.EnumMap;
import java.util.Map;

/**
 * Created by gunjunLee on 2017-01-29.
 */
public enum Phase {

    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLITME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase src;
        private final Phase dst;

        Transition(Phase src, Phase dst) {
            this.src = src;
            this.dst = dst;
        }

        // 상전이 맵 초기화
        private static final Map<Phase, Map<Phase, Transition>> m = new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);
        static {
            for(Phase p : Phase.values()) {
                m.put(p, new EnumMap<Phase, Transition>(Phase.class));
            }
            for(Transition trans : Transition.values()) {
                m.get(trans.src).put(trans.dst, trans);
            }
        }

        public static Transition from(Phase src, Phase dst) {
            return m.get(src).get(dst);
        }
    }
}
