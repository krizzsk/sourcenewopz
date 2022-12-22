package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzccy implements zzesa<zzqt> {
    private final zzesn<zzbar> zzfvj;
    private final zzesn<String> zzfvk;

    public zzccy(zzesn<zzbar> zzesn, zzesn<String> zzesn2) {
        this.zzfvj = zzesn;
        this.zzfvk = zzesn2;
    }

    public final /* synthetic */ Object get() {
        zzr.zzkv();
        return (zzqt) zzesg.zzbd(new zzqt(zzj.zzzr(), this.zzfvj.get(), this.zzfvk.get(), new JSONObject(), false, true));
    }
}
