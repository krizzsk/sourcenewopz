package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzcxb extends zzcyd {
    private zzbzv zzgyl;

    public zzcxb(zzbst zzbst, zzbtl zzbtl, zzbty zzbty, zzbui zzbui, zzbtb zzbtb, zzbxe zzbxe, zzcaa zzcaa, zzbur zzbur, zzbzv zzbzv, zzbwx zzbwx) {
        super(zzbst, zzbtl, zzbty, zzbui, zzbxe, zzbur, zzcaa, zzbwx, zzbtb);
        this.zzgyl = zzbzv;
    }

    public final void zzvp() {
        this.zzgyl.zzul();
    }

    public final void zzvq() throws RemoteException {
        this.zzgyl.zzum();
    }

    public final void zza(zzawa zzawa) throws RemoteException {
        super.zza(zzawa);
        this.zzgyl.zza(new zzavy(zzawa.getType(), zzawa.getAmount()));
    }

    public final void zzb(zzavy zzavy) {
        super.zzb(zzavy);
        this.zzgyl.zza(zzavy);
    }

    public final void onVideoEnd() {
        this.zzgyl.zzum();
    }
}
