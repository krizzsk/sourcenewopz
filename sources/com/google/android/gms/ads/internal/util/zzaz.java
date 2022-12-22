package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzl;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaz extends zzbk {
    private final /* synthetic */ byte[] zzeih;
    private final /* synthetic */ Map zzeii;
    private final /* synthetic */ zzbai zzeij;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaz(zzay zzay, int i, String str, zzai zzai, zzaj zzaj, byte[] bArr, Map map, zzbai zzbai) {
        super(i, str, zzai, zzaj);
        this.zzeih = bArr;
        this.zzeii = map;
        this.zzeij = zzbai;
    }

    public final byte[] zzg() throws zzl {
        byte[] bArr = this.zzeih;
        return bArr == null ? super.zzg() : bArr;
    }

    public final Map<String, String> getHeaders() throws zzl {
        Map<String, String> map = this.zzeii;
        return map == null ? super.getHeaders() : map;
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        this.zzeij.zzeu(str);
        super.zza(str);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zza((String) obj);
    }
}
