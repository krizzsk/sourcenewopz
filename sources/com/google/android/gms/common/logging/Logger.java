package com.google.android.gms.common.logging;

import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;
import org.osgi.framework.VersionRange;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    public Logger(String str, String... strArr) {
        String str2;
        if (r0 == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(VersionRange.LEFT_CLOSED);
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append("] ");
            str2 = sb.toString();
        }
        this.zzb = str2;
        this.zza = str;
        this.zzc = new GmsLogger(str);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.zza, i)) {
            i++;
        }
        this.zzd = i;
    }

    /* renamed from: d */
    public void mo136175d(String str, Object... objArr) {
        if (isLoggable(3)) {
            SystemUtils.log(3, this.zza, format(str, objArr), (Throwable) null, "com.google.android.gms.common.logging.Logger", 2);
        }
    }

    /* renamed from: e */
    public void mo136176e(String str, Throwable th, Object... objArr) {
        SystemUtils.log(6, this.zza, format(str, objArr), th, "com.google.android.gms.common.logging.Logger", 1);
    }

    /* access modifiers changed from: protected */
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzb.concat(str);
    }

    public String getTag() {
        return this.zza;
    }

    /* renamed from: i */
    public void mo136180i(String str, Object... objArr) {
        SystemUtils.log(4, this.zza, format(str, objArr), (Throwable) null, "com.google.android.gms.common.logging.Logger", 1);
    }

    public boolean isLoggable(int i) {
        return this.zzd <= i;
    }

    /* renamed from: v */
    public void mo136182v(String str, Throwable th, Object... objArr) {
        if (isLoggable(2)) {
            SystemUtils.log(2, this.zza, format(str, objArr), th, "com.google.android.gms.common.logging.Logger", 2);
        }
    }

    /* renamed from: w */
    public void mo136184w(String str, Object... objArr) {
        SystemUtils.log(5, this.zza, format(str, objArr), (Throwable) null, "com.google.android.gms.common.logging.Logger", 1);
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        Log.wtf(this.zza, format(str, objArr), th);
    }

    /* renamed from: e */
    public void mo136177e(String str, Object... objArr) {
        SystemUtils.log(6, this.zza, format(str, objArr), (Throwable) null, "com.google.android.gms.common.logging.Logger", 2);
    }

    public void wtf(Throwable th) {
        Log.wtf(this.zza, th);
    }

    /* renamed from: v */
    public void mo136183v(String str, Object... objArr) {
        if (isLoggable(2)) {
            SystemUtils.log(2, this.zza, format(str, objArr), (Throwable) null, "com.google.android.gms.common.logging.Logger", 4);
        }
    }
}
