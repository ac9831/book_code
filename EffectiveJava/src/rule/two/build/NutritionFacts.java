package rule.two.build;

/*
    Builder 패턴은 내부 클래스에서 필수 인자와 선택적 인자를 받아 놓고 마지막에 NutritionFacts 클래스에 정보를 옮긴다.
    이 패턴을 통해 필수 인자와 선택적 인자를 간결하게 받을 수 있고 안전하게 옮길 수 있다.
    아래 코드를 보면 알겠지만 작성하기 쉽고, 무엇보다 읽기 쉽다.
    사용 방법 ex)
    NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
 */
public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        // 필수 인자
        private final int servingSize;
        private final int servings;

        // 선택적 인자
        private int calories = 0;
        private int fat = 0;
        private int carbohydrate = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories (int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

}

