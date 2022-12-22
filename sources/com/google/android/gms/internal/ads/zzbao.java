package com.google.android.gms.internal.ads;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class zzbao {
    public static void zzdz(String str) {
        if (isLoggable(3)) {
            SystemUtils.log(3, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzbao", 2);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (isLoggable(3)) {
            SystemUtils.log(3, AdRequest.LOGTAG, str, th, "com.google.android.gms.internal.ads.zzbao", 5);
        }
    }

    public static void zzex(String str) {
        if (isLoggable(6)) {
            SystemUtils.log(6, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzbao", 8);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (isLoggable(6)) {
            SystemUtils.log(6, AdRequest.LOGTAG, str, th, "com.google.android.gms.internal.ads.zzbao", 11);
        }
    }

    public static void zzey(String str) {
        if (isLoggable(4)) {
            SystemUtils.log(4, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzbao", 14);
        }
    }

    public static void zzez(String str) {
        if (isLoggable(5)) {
            SystemUtils.log(5, AdRequest.LOGTAG, str, (Throwable) null, "com.google.android.gms.internal.ads.zzbao", 17);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (isLoggable(5)) {
            SystemUtils.log(5, AdRequest.LOGTAG, str, th, "com.google.android.gms.internal.ads.zzbao", 20);
        }
    }

    private static String zzfa(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void zze(String str, Throwable th) {
        if (!isLoggable(5)) {
            return;
        }
        if (th != null) {
            zzd(zzfa(str), th);
        } else {
            zzez(zzfa(str));
        }
    }

    public static void zzfb(String str) {
        zze(str, (Throwable) null);
    }

    public static boolean isLoggable(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }
}
