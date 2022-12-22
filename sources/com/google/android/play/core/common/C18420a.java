package com.google.android.play.core.common;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.common.a */
public final class C18420a {

    /* renamed from: a */
    private final Map<String, Object> f53118a = new HashMap();

    /* renamed from: a */
    public final synchronized void mo149064a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && this.f53118a.get(str) == null) {
                this.f53118a.put(str, obj);
            }
        }
    }

    /* renamed from: a */
    public final synchronized boolean mo149065a() {
        Object obj = this.f53118a.get("usingExtractorStream");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
