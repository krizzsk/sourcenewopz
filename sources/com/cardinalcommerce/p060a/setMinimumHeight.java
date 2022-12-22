package com.cardinalcommerce.p060a;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;

/* renamed from: com.cardinalcommerce.a.setMinimumHeight */
public final class setMinimumHeight {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final ThreadLocal f2889a = new ThreadLocal();

    public static boolean Cardinal(final String str) {
        try {
            String str2 = (String) AccessController.doPrivileged(new PrivilegedAction() {
                public final Object run() {
                    Map map = (Map) setMinimumHeight.f2889a.get();
                    return map != null ? map.get(str) : System.getProperty(str);
                }
            });
            if (str2 != null) {
                return "true".equals(setAnimation.getInstance(str2));
            }
        } catch (AccessControlException unused) {
        }
        return false;
    }
}
