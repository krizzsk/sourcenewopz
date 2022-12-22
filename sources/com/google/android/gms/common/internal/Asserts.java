package com.google.android.gms.common.internal;

import android.os.Looper;
import com.didi.sdk.apm.SystemUtils;
import javax.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class Asserts {
    private Asserts() {
        throw new AssertionError("Uninstantiable");
    }

    public static void checkMainThread(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            SystemUtils.log(6, "Asserts", "checkMainThread: current thread " + valueOf + " IS NOT the main thread " + valueOf2 + "!", (Throwable) null, "com.google.android.gms.common.internal.Asserts", 4);
            throw new IllegalStateException(str);
        }
    }

    public static void checkNotMainThread(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            String valueOf = String.valueOf(Thread.currentThread());
            String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
            SystemUtils.log(6, "Asserts", "checkNotMainThread: current thread " + valueOf + " IS the main thread " + valueOf2 + "!", (Throwable) null, "com.google.android.gms.common.internal.Asserts", 4);
            throw new IllegalStateException(str);
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(@Nullable Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void checkNull(Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException("non-null reference");
        }
    }

    public static void checkState(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @EnsuresNonNull({"#1"})
    public static void checkNotNull(@Nullable Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException(String.valueOf(obj2));
        }
    }

    public static void checkState(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
