package com.google.android.gms.common.util;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class CrashUtils {
    private static final String[] zza = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean addDynamiteErrorToDropBox(Context context, Throwable th) {
        try {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(th);
            return false;
        } catch (Exception e) {
            SystemUtils.log(6, "CrashUtils", "Error adding exception to DropBox!", e, "com.google.android.gms.common.util.CrashUtils", 3);
            return false;
        }
    }
}
