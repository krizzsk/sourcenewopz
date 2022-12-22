package com.google.android.play.core.splitinstall;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.splitinstall.g */
public final class C18579g {

    /* renamed from: a */
    private final Map<String, Map<String, String>> f53319a = new HashMap();

    /* renamed from: a */
    public final C18580h mo149296a() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.f53319a.entrySet()) {
            hashMap.put((String) next.getKey(), Collections.unmodifiableMap(new HashMap((Map) next.getValue())));
        }
        return new C18580h(Collections.unmodifiableMap(hashMap));
    }

    /* renamed from: a */
    public final void mo149297a(String str, String str2, String str3) {
        if (!this.f53319a.containsKey(str2)) {
            this.f53319a.put(str2, new HashMap());
        }
        this.f53319a.get(str2).put(str, str3);
    }
}
