package com.didi.component.never.core.proxy;

import com.didi.component.never.core.ComponentProxy;
import java.util.HashMap;

public class ProxyMap {

    /* renamed from: a */
    private static final HashMap<String, Class<? extends ComponentProxy>> f14676a = new HashMap<>();

    public static void addProxy(String str, Class<? extends ComponentProxy> cls) {
        f14676a.put(str, cls);
    }

    public static Class<? extends ComponentProxy> getProxy(String str) {
        return f14676a.get(str);
    }
}
