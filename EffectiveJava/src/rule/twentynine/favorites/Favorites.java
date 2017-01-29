package rule.twentynine.favorites;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gunjunLee on 2017-01-29.
 */
// 형 안전 다형성 컨테이너 패턴 - API
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if(type == null) {
            throw new NullPointerException("Type is null");
        }
        // 동적 형변환으로 실행시간 형 안전성 확보
        favorites.put(type, type.cast(instance));
    }

    // 동적 형변환을 해야 한다.
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    // 형 안전 다형성 컨테이너 패턴 - 클라이언트
    public static void main(String[] main) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }


    // 한정적 자료형 토큰으로 안전하게 형변환하기 위해 asSubclass를 이용한 사례
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

}
