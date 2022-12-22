package p242io.flutter.plugin.platform;

import java.util.HashMap;
import java.util.Map;

/* renamed from: io.flutter.plugin.platform.b */
/* compiled from: PlatformViewRegistryImpl */
class C21119b implements PlatformViewRegistry {

    /* renamed from: a */
    private final Map<String, PlatformViewFactory> f57888a = new HashMap();

    C21119b() {
    }

    public boolean registerViewFactory(String str, PlatformViewFactory platformViewFactory) {
        if (this.f57888a.containsKey(str)) {
            return false;
        }
        this.f57888a.put(str, platformViewFactory);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PlatformViewFactory mo172889a(String str) {
        return this.f57888a.get(str);
    }
}
