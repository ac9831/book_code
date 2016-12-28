package rule.one.service;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 서비스 제공자 인터페이스의 대략적인 모습
/*
    Map에 인스턴스 생성해서 넣어 두고 서비스에 접근 할 때 Map에서 찾아 사용하는 방식
    이 방법의 좋은 점은 내부적으로 어떤 클래스가 이용되는지 알 수가 없다는 점이다. 그렇기 때문에 클라이언트는 팩터리 메서드가 반환하는 객체의 실제 클래스를 알 수도 없고 알 필요도 없다.

 */
public class Services {

    private Services() { }

    private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    // 제공자 등록 API
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providers.put(name, p);
    }

    // 서비스 접근 API
    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        Provider p = providers.get(name);
        if (p == null) {
            throw new IllegalArgumentException("No provider registered with name: " + name);
        }
        return p.newService();
    }

}
