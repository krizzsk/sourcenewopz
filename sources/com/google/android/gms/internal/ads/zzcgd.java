package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final /* synthetic */ class zzcgd implements Callable {
    private final zzebt zzfyy;
    private final zzebt zzgbc;
    private final zzcgb zzgjx;
    private final zzebt zzgkf;
    private final zzebt zzgkg;
    private final zzebt zzgkh;
    private final JSONObject zzgki;
    private final zzebt zzgkj;
    private final zzebt zzgkk;
    private final zzebt zzgkl;

    zzcgd(zzcgb zzcgb, zzebt zzebt, zzebt zzebt2, zzebt zzebt3, zzebt zzebt4, zzebt zzebt5, JSONObject jSONObject, zzebt zzebt6, zzebt zzebt7, zzebt zzebt8) {
        this.zzgjx = zzcgb;
        this.zzgbc = zzebt;
        this.zzfyy = zzebt2;
        this.zzgkf = zzebt3;
        this.zzgkg = zzebt4;
        this.zzgkh = zzebt5;
        this.zzgki = jSONObject;
        this.zzgkj = zzebt6;
        this.zzgkk = zzebt7;
        this.zzgkl = zzebt8;
    }

    public final Object call() {
        zzebt zzebt = this.zzgbc;
        zzebt zzebt2 = this.zzfyy;
        zzebt zzebt3 = this.zzgkf;
        zzebt zzebt4 = this.zzgkg;
        zzebt zzebt5 = this.zzgkh;
        JSONObject jSONObject = this.zzgki;
        zzebt zzebt6 = this.zzgkj;
        zzebt zzebt7 = this.zzgkk;
        zzebt zzebt8 = this.zzgkl;
        zzcdr zzcdr = (zzcdr) zzebt.get();
        zzcdr.setImages((List) zzebt2.get());
        zzcdr.zza((zzaes) zzebt3.get());
        zzcdr.zzb((zzaes) zzebt4.get());
        zzcdr.zza((zzaek) zzebt5.get());
        zzcdr.zzh(zzcgf.zzk(jSONObject));
        zzcdr.zza(zzcgf.zzl(jSONObject));
        zzbfi zzbfi = (zzbfi) zzebt6.get();
        if (zzbfi != null) {
            zzcdr.zzf(zzbfi);
            zzcdr.zzac(zzbfi.getView());
            zzcdr.zzb((zzzd) zzbfi.zzabv());
        }
        zzbfi zzbfi2 = (zzbfi) zzebt7.get();
        if (zzbfi2 != null) {
            zzcdr.zzg(zzbfi2);
        }
        for (zzcgq zzcgq : (List) zzebt8.get()) {
            int i = zzcgq.type;
            if (i == 1) {
                zzcdr.zzo(zzcgq.zzcm, zzcgq.zzdsn);
            } else if (i == 2) {
                zzcdr.zza(zzcgq.zzcm, zzcgq.zzgkv);
            }
        }
        return zzcdr;
    }
}
