package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzblo implements zzesa<zzqt> {
    private final zzesn<JSONObject> zzfli;
    private final zzesn<zzdot> zzfvi;
    private final zzesn<zzbar> zzfvj;
    private final zzesn<String> zzfvk;

    private zzblo(zzesn<zzdot> zzesn, zzesn<zzbar> zzesn2, zzesn<JSONObject> zzesn3, zzesn<String> zzesn4) {
        this.zzfvi = zzesn;
        this.zzfvj = zzesn2;
        this.zzfli = zzesn3;
        this.zzfvk = zzesn4;
    }

    public static zzblo zza(zzesn<zzdot> zzesn, zzesn<zzbar> zzesn2, zzesn<JSONObject> zzesn3, zzesn<String> zzesn4) {
        return new zzblo(zzesn, zzesn2, zzesn3, zzesn4);
    }

    public final /* synthetic */ Object get() {
        zzdot zzdot = this.zzfvi.get();
        String str = this.zzfvk.get();
        boolean equals = "native".equals(str);
        zzr.zzkv();
        return (zzqt) zzesg.zzbd(new zzqt(zzj.zzzr(), this.zzfvj.get(), str, this.zzfli.get(), false, equals));
    }
}
