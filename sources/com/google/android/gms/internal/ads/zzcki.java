package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzuh;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcki implements zzesa<zztz> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzuh.zza.C22026zza> zzfvk;
    private final zzesn<String> zzgaw;
    private final zzesn<zzbar> zzgbl;
    private final zzesn<String> zzgnd;

    private zzcki(zzesn<Context> zzesn, zzesn<String> zzesn2, zzesn<zzbar> zzesn3, zzesn<zzuh.zza.C22026zza> zzesn4, zzesn<String> zzesn5) {
        this.zzeyq = zzesn;
        this.zzgaw = zzesn2;
        this.zzgbl = zzesn3;
        this.zzfvk = zzesn4;
        this.zzgnd = zzesn5;
    }

    public static zzcki zze(zzesn<Context> zzesn, zzesn<String> zzesn2, zzesn<zzbar> zzesn3, zzesn<zzuh.zza.C22026zza> zzesn4, zzesn<String> zzesn5) {
        return new zzcki(zzesn, zzesn2, zzesn3, zzesn4, zzesn5);
    }

    public final /* synthetic */ Object get() {
        String str = this.zzgaw.get();
        zzbar zzbar = this.zzgbl.get();
        zzuh.zza.C22026zza zza = this.zzfvk.get();
        String str2 = this.zzgnd.get();
        zztz zztz = new zztz(new zzue(this.zzeyq.get()));
        zztz.zza((zzty) new zzckj(zza, str, (zzuh.zzu) ((zzena) zzuh.zzu.zzpt().zzcq(zzbar.zzeka).zzcr(zzbar.zzekb).zzcs(zzbar.zzekc ? 0 : 2).zzbjv()), str2));
        return (zztz) zzesg.zzbd(zztz);
    }
}
