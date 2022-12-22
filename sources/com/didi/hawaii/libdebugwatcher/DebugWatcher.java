package com.didi.hawaii.libdebugwatcher;

import android.content.Context;

public final class DebugWatcher {

    /* renamed from: a */
    private static volatile DebugWatcher f23442a;

    public void install(Context context) {
    }

    public static DebugWatcher getInstance() {
        if (f23442a == null) {
            synchronized (DebugWatcher.class) {
                if (f23442a == null) {
                    f23442a = new DebugWatcher();
                }
            }
        }
        return f23442a;
    }

    private DebugWatcher() {
    }
}
