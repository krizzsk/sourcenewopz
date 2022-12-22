package com.didichuxing.omega.sdk.leak;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class KeyedWeakReference extends WeakReference<Object> {
    public final String key;
    public final String name;

    public KeyedWeakReference(Object obj, ReferenceQueue<Object> referenceQueue, String str, String str2) {
        super(obj, referenceQueue);
        this.key = str;
        this.name = str2;
    }
}
