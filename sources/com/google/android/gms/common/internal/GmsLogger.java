package com.google.android.gms.common.internal;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    public GmsLogger(String str) {
        this(str, (String) null);
    }

    private final String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }

    private final String zzb(String str, Object... objArr) {
        String format = String.format(str, objArr);
        String str2 = this.zzb;
        if (str2 == null) {
            return format;
        }
        return str2.concat(format);
    }

    public boolean canLog(int i) {
        return Log.isLoggable(this.zza, i);
    }

    public boolean canLogPii() {
        return false;
    }

    /* renamed from: d */
    public void mo136010d(String str, String str2) {
        if (canLog(3)) {
            SystemUtils.log(3, str, zza(str2), (Throwable) null, "com.google.android.gms.common.internal.GmsLogger", 2);
        }
    }

    /* renamed from: e */
    public void mo136012e(String str, String str2) {
        if (canLog(6)) {
            SystemUtils.log(6, str, zza(str2), (Throwable) null, "com.google.android.gms.common.internal.GmsLogger", 2);
        }
    }

    public void efmt(String str, String str2, Object... objArr) {
        if (canLog(6)) {
            SystemUtils.log(6, str, zzb(str2, objArr), (Throwable) null, "com.google.android.gms.common.internal.GmsLogger", 2);
        }
    }

    /* renamed from: i */
    public void mo136015i(String str, String str2) {
        if (canLog(4)) {
            SystemUtils.log(4, str, zza(str2), (Throwable) null, "com.google.android.gms.common.internal.GmsLogger", 2);
        }
    }

    public void pii(String str, String str2) {
    }

    public void pii(String str, String str2, Throwable th) {
    }

    /* renamed from: v */
    public void mo136019v(String str, String str2) {
        if (canLog(2)) {
            SystemUtils.log(2, str, zza(str2), (Throwable) null, "com.google.android.gms.common.internal.GmsLogger", 2);
        }
    }

    /* renamed from: w */
    public void mo136021w(String str, String str2) {
        if (canLog(5)) {
            SystemUtils.log(5, str, zza(str2), (Throwable) null, "com.google.android.gms.common.internal.GmsLogger", 2);
        }
    }

    public void wfmt(String str, String str2, Object... objArr) {
        if (canLog(5)) {
            SystemUtils.log(5, this.zza, zzb(str2, objArr), (Throwable) null, "com.google.android.gms.common.internal.GmsLogger", 2);
        }
    }

    public void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            SystemUtils.log(6, str, zza(str2), th, "com.google.android.gms.common.internal.GmsLogger", 2);
            Log.wtf(str, zza(str2), th);
        }
    }

    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        if (str2 == null || str2.length() <= 0) {
            this.zzb = null;
        } else {
            this.zzb = str2;
        }
    }

    /* renamed from: d */
    public void mo136011d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            SystemUtils.log(3, str, zza(str2), th, "com.google.android.gms.common.internal.GmsLogger", 4);
        }
    }

    /* renamed from: e */
    public void mo136013e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            SystemUtils.log(6, str, zza(str2), th, "com.google.android.gms.common.internal.GmsLogger", 4);
        }
    }

    /* renamed from: i */
    public void mo136016i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            SystemUtils.log(4, str, zza(str2), th, "com.google.android.gms.common.internal.GmsLogger", 4);
        }
    }

    /* renamed from: v */
    public void mo136020v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            SystemUtils.log(2, str, zza(str2), th, "com.google.android.gms.common.internal.GmsLogger", 4);
        }
    }

    /* renamed from: w */
    public void mo136022w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            SystemUtils.log(5, str, zza(str2), th, "com.google.android.gms.common.internal.GmsLogger", 4);
        }
    }
}
