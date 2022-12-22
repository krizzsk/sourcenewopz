package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzdcx implements zzdhe<zzdcv> {
    private final zzcna zzfsu;
    private final zzckb zzgph;
    private final zzebs zzhdd;
    private final zzdcz zzhdu;

    public zzdcx(zzebs zzebs, zzckb zzckb, zzcna zzcna, zzdcz zzdcz) {
        this.zzhdd = zzebs;
        this.zzgph = zzckb;
        this.zzfsu = zzcna;
        this.zzhdu = zzdcz;
    }

    public final zzebt<zzdcv> zzatu() {
        if (zzdyq.zzar((String) zzww.zzra().zzd(zzabq.zzcrm)) || this.zzhdu.zzatx() || !this.zzfsu.zzary()) {
            return zzebh.zzag(new zzdcv(new Bundle()));
        }
        this.zzhdu.zzbp(true);
        return this.zzhdd.zze(new zzdda(this));
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001a A[Catch:{ zzdpq -> 0x0023 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.Bundle zzb(com.google.android.gms.internal.ads.zzdqd r3) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            com.google.android.gms.internal.ads.zzaqr r1 = r3.zzvn()     // Catch:{ zzdpq -> 0x0014 }
            if (r1 == 0) goto L_0x0014
            java.lang.String r2 = "sdk_version"
            java.lang.String r1 = r1.toString()     // Catch:{ zzdpq -> 0x0014 }
            r0.putString(r2, r1)     // Catch:{ zzdpq -> 0x0014 }
        L_0x0014:
            com.google.android.gms.internal.ads.zzaqr r3 = r3.zzvm()     // Catch:{ zzdpq -> 0x0023 }
            if (r3 == 0) goto L_0x0023
            java.lang.String r1 = "adapter_version"
            java.lang.String r3 = r3.toString()     // Catch:{ zzdpq -> 0x0023 }
            r0.putString(r1, r3)     // Catch:{ zzdpq -> 0x0023 }
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdcx.zzb(com.google.android.gms.internal.ads.zzdqd):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdcv zzatw() throws Exception {
        List<String> asList = Arrays.asList(((String) zzww.zzra().zzd(zzabq.zzcrm)).split(";"));
        Bundle bundle = new Bundle();
        for (String str : asList) {
            try {
                zzdqd zzd = this.zzgph.zzd(str, new JSONObject());
                zzd.isInitialized();
                bundle.putBundle(str, zzb(zzd));
            } catch (zzdpq unused) {
            }
        }
        return new zzdcv(bundle);
    }
}
