package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcwk {
    /* access modifiers changed from: private */
    public final Clock zzbqq;
    /* access modifiers changed from: private */
    public final zzctc zzfzp;
    /* access modifiers changed from: private */
    public final zzcwm zzgxy;
    private final List<String> zzgxz = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public final boolean zzgya;

    public zzcwk(Clock clock, zzcwm zzcwm, zzctc zzctc) {
        this.zzbqq = clock;
        this.zzgxy = zzcwm;
        this.zzgya = ((Boolean) zzww.zzra().zzd(zzabq.zzczv)).booleanValue();
        this.zzfzp = zzctc;
    }

    /* access modifiers changed from: package-private */
    public final <T> zzebt<T> zza(zzdoy zzdoy, zzdot zzdot, zzebt<T> zzebt) {
        long elapsedRealtime = this.zzbqq.elapsedRealtime();
        String str = zzdot.zzdnw;
        if (str != null) {
            zzebh.zza(zzebt, new zzcwn(this, elapsedRealtime, str, zzdot, zzdoy), zzbat.zzekj);
        }
        return zzebt;
    }

    /* access modifiers changed from: private */
    public final void zza(String str, int i, long j, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
        sb.append(str);
        sb.append(".");
        sb.append(i);
        sb.append(".");
        sb.append(j);
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 1 + String.valueOf(str2).length());
            sb3.append(sb2);
            sb3.append(".");
            sb3.append(str2);
            sb2 = sb3.toString();
        }
        this.zzgxz.add(sb2);
    }

    public final String zzasy() {
        return TextUtils.join("_", this.zzgxz);
    }
}
