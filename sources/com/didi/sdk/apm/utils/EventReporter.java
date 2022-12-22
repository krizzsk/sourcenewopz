package com.didi.sdk.apm.utils;

import android.os.AsyncTask;
import android.util.Log;
import com.didichuxing.omega.sdk.Omega;
import java.util.Map;

public class EventReporter {
    public static final String TAG = "EventReporter";

    /* renamed from: a */
    private static final String f35060a = "apm";

    public static void trackError(final Throwable th) {
        if (th != null) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    try {
                        Omega.trackError(EventReporter.f35060a, th);
                    } catch (Exception e) {
                        Log.e(EventReporter.TAG, "trackError: ", e);
                    }
                }
            });
        }
    }

    public static void trackError(final String str, final String str2, final String str3) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                try {
                    Omega.trackError(EventReporter.f35060a, str, str2, str3, (Map<String, Object>) null);
                } catch (Exception e) {
                    Log.e(EventReporter.TAG, "trackError: ", e);
                }
            }
        });
    }

    public static void trackError(final String str, final String str2, final String str3, final Map<String, Object> map) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                try {
                    Omega.trackError(EventReporter.f35060a, str, str2, str3, map);
                } catch (Exception e) {
                    Log.e(EventReporter.TAG, "trackError: ", e);
                }
            }
        });
    }
}
