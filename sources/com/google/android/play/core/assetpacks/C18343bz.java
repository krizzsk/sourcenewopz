package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bz */
final class C18343bz {

    /* renamed from: a */
    private final Map<String, Double> f52905a = new HashMap();

    C18343bz() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized double mo148970a(String str, C18362cr crVar) {
        double d;
        d = (((double) ((C18336bs) crVar).f52864e) + 1.0d) / ((double) ((C18336bs) crVar).f52865f);
        this.f52905a.put(str, Double.valueOf(d));
        return d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo148971a(String str) {
        this.f52905a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized double mo148972b(String str) {
        Double d = this.f52905a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }
}
