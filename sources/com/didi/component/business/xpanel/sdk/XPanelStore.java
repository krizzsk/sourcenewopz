package com.didi.component.business.xpanel.sdk;

import android.os.Bundle;
import java.util.Hashtable;
import java.util.Map;

public class XPanelStore {
    public static final String EXTRA_MAP_PADDING_BOTTOM = "extra_map_padding_bottom";
    public static final String EXTRA_MAP_PADDING_TOP = "extra_map_padding_top";

    /* renamed from: a */
    private static XPanelStore f11416a;

    /* renamed from: b */
    private Map<Integer, Bundle> f11417b = new Hashtable();

    private XPanelStore() {
    }

    public static XPanelStore getInstance() {
        if (f11416a == null) {
            f11416a = new XPanelStore();
        }
        return f11416a;
    }

    public void addCache(int i, Bundle bundle) {
        if (bundle != null) {
            Bundle cache = getCache(i);
            if (cache != null) {
                cache.putAll(bundle);
                bundle = cache;
            }
            this.f11417b.put(Integer.valueOf(i), bundle);
        }
    }

    public Bundle getCache(int i) {
        return this.f11417b.get(Integer.valueOf(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.get(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T getCacheData(int r1, java.lang.String r2, T r3) {
        /*
            r0 = this;
            android.os.Bundle r1 = r0.getCache(r1)
            if (r1 == 0) goto L_0x000d
            java.lang.Object r1 = r1.get(r2)
            if (r1 == 0) goto L_0x000d
            return r1
        L_0x000d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.xpanel.sdk.XPanelStore.getCacheData(int, java.lang.String, java.lang.Object):java.lang.Object");
    }
}
