package p242io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.embedding.engine.FlutterEngineCache */
public class FlutterEngineCache {

    /* renamed from: a */
    private static FlutterEngineCache f57579a;

    /* renamed from: b */
    private final Map<String, FlutterEngine> f57580b = new HashMap();

    public static FlutterEngineCache getInstance() {
        if (f57579a == null) {
            f57579a = new FlutterEngineCache();
        }
        return f57579a;
    }

    FlutterEngineCache() {
    }

    public boolean contains(String str) {
        return this.f57580b.containsKey(str);
    }

    public FlutterEngine get(String str) {
        return this.f57580b.get(str);
    }

    public void put(String str, FlutterEngine flutterEngine) {
        if (flutterEngine != null) {
            this.f57580b.put(str, flutterEngine);
        } else {
            this.f57580b.remove(str);
        }
    }

    public void remove(String str) {
        put(str, (FlutterEngine) null);
    }

    public void clear() {
        this.f57580b.clear();
    }
}
