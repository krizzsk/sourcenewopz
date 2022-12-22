package com.didi.sdk.apm.utils;

import android.content.Context;
import android.os.Debug;
import android.util.Log;

public class DebugUtils {
    public static boolean isDebuggableApp(Context context) {
        try {
            boolean z = (context.getApplicationInfo().flags & 2) != 0;
            return !z ? Log.isLoggable("didi", 3) : z;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebuggerConnected() {
        return Debug.isDebuggerConnected();
    }
}
