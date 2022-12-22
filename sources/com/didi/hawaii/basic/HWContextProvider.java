package com.didi.hawaii.basic;

import android.content.Context;

public final class HWContextProvider {

    /* renamed from: a */
    private static Context f23440a;

    private HWContextProvider() {
    }

    public static synchronized void setContextIfNecessary(Context context) {
        synchronized (HWContextProvider.class) {
            if (context != null) {
                if (f23440a == null) {
                    f23440a = context.getApplicationContext();
                }
            }
        }
    }

    public static synchronized Context getContext() {
        Context context;
        synchronized (HWContextProvider.class) {
            context = f23440a;
        }
        return context;
    }
}
