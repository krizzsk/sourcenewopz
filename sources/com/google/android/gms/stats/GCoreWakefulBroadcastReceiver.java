package com.google.android.gms.stats;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.stats.WakeLockTracker;

public abstract class GCoreWakefulBroadcastReceiver extends WakefulBroadcastReceiver {
    private static String TAG = "GCoreWakefulBroadcastReceiver";

    public static boolean completeWakefulIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context != null) {
            WakeLockTracker.getInstance().registerReleaseEvent(context, intent);
        } else {
            String str = TAG;
            String valueOf = String.valueOf(intent.toUri(0));
            SystemUtils.log(5, str, valueOf.length() != 0 ? "context shouldn't be null. intent: ".concat(valueOf) : new String("context shouldn't be null. intent: "), (Throwable) null, "com.google.android.gms.stats.GCoreWakefulBroadcastReceiver", 6);
        }
        return WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
