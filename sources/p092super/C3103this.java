package p092super;

import java.util.HashMap;
import java.util.Map;

/* renamed from: super.this */
/* compiled from: LightingValues */
public class C3103this {

    /* renamed from: a */
    private final Map<String, Double> f6891a;

    public C3103this(Map<String, Double> map) {
        this.f6891a = map;
    }

    /* renamed from: do */
    public void mo38598do(String str, Double d) {
        this.f6891a.put(str, d);
    }

    /* renamed from: do */
    public Map<String, Object> mo38597do() {
        return new HashMap(this.f6891a);
    }
}
