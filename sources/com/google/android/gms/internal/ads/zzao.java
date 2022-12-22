package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzao {
    private static final String CLASS_NAME = zzao.class.getName();
    public static boolean DEBUG = Log.isLoggable("Volley", 2);
    private static String TAG = "Volley";

    /* renamed from: v */
    public static void m37367v(String str, Object... objArr) {
        if (DEBUG) {
            SystemUtils.log(2, TAG, zza(str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzao", 3);
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    static class zza {
        public static final boolean zzbv = zzao.DEBUG;
        private boolean mFinished = false;
        private final List<zzaq> zzbw = new ArrayList();

        zza() {
        }

        public final synchronized void zza(String str, long j) {
            if (!this.mFinished) {
                this.zzbw.add(new zzaq(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public final synchronized void zzd(String str) {
            long j;
            this.mFinished = true;
            if (this.zzbw.size() == 0) {
                j = 0;
            } else {
                j = this.zzbw.get(this.zzbw.size() - 1).time - this.zzbw.get(0).time;
            }
            if (j > 0) {
                long j2 = this.zzbw.get(0).time;
                zzao.m37365d("(%-4d ms) %s", Long.valueOf(j), str);
                for (zzaq next : this.zzbw) {
                    long j3 = next.time;
                    zzao.m37365d("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(next.zzbu), next.name);
                    j2 = j3;
                }
            }
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            if (!this.mFinished) {
                zzd("Request on the loose");
                zzao.m37366e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    /* renamed from: d */
    public static void m37365d(String str, Object... objArr) {
        SystemUtils.log(3, TAG, zza(str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzao", 5);
    }

    /* renamed from: e */
    public static void m37366e(String str, Object... objArr) {
        SystemUtils.log(6, TAG, zza(str, objArr), (Throwable) null, "com.google.android.gms.internal.ads.zzao", 7);
    }

    public static void zza(Throwable th, String str, Object... objArr) {
        SystemUtils.log(6, TAG, zza(str, objArr), th, "com.google.android.gms.internal.ads.zzao", 9);
    }

    private static String zza(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(CLASS_NAME)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
