package com.google.android.gms.internal.ads;

import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzerp extends zzers {
    private String name;

    public zzerp(String str) {
        this.name = str;
    }

    public final void zzip(String str) {
        String str2 = this.name;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        SystemUtils.log(3, "isoparser", sb.toString(), (Throwable) null, "com.google.android.gms.internal.ads.zzerp", 4);
    }
}
