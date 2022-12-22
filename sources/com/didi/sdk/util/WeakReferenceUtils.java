package com.didi.sdk.util;

import java.lang.ref.WeakReference;

public class WeakReferenceUtils {
    public static <T> T getObj(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
