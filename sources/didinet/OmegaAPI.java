package didinet;

import java.util.Map;

public interface OmegaAPI {
    public static final OmegaAPI NONE = new OmegaAPI() {
        public void trackEvent(String str) {
        }

        public void trackEvent(String str, String str2) {
        }

        public void trackEvent(String str, String str2, Map map) {
        }
    };

    void trackEvent(String str);

    void trackEvent(String str, String str2);

    void trackEvent(String str, String str2, Map map);
}
