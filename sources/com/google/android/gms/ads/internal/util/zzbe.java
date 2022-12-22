package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzab;
import com.google.android.gms.internal.ads.zzag;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbbe;
import com.google.android.gms.internal.ads.zzbc;
import com.google.android.gms.internal.ads.zzz;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbe extends zzab<zzz> {
    private final Map<String, String> zzaj;
    private final zzbbe<zzz> zzein;
    private final zzbai zzeio;

    public zzbe(String str, zzbbe<zzz> zzbbe) {
        this(str, (Map<String, String>) null, zzbbe);
    }

    private zzbe(String str, Map<String, String> map, zzbbe<zzz> zzbbe) {
        super(0, str, new zzbd(zzbbe));
        this.zzaj = null;
        this.zzein = zzbbe;
        zzbai zzbai = new zzbai();
        this.zzeio = zzbai;
        zzbai.zza(str, "GET", (Map<String, ?>) null, (byte[]) null);
    }

    /* access modifiers changed from: protected */
    public final zzag<zzz> zza(zzz zzz) {
        return zzag.zza(zzz, zzbc.zzb(zzz));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zzz zzz = (zzz) obj;
        this.zzeio.zza((Map<String, ?>) zzz.zzaj, zzz.statusCode);
        zzbai zzbai = this.zzeio;
        byte[] bArr = zzz.data;
        if (zzbai.isEnabled() && bArr != null) {
            zzbai.zzi(bArr);
        }
        this.zzein.set(zzz);
    }
}
