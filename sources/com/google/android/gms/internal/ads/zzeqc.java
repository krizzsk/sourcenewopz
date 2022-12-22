package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzeqc extends zzeqa<zzeqd, zzeqd> {
    zzeqc() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzepc zzepc) {
        return false;
    }

    private static void zza(Object obj, zzeqd zzeqd) {
        ((zzena) obj).zzitn = zzeqd;
    }

    /* access modifiers changed from: package-private */
    public final void zzak(Object obj) {
        ((zzena) obj).zzitn.zzbhe();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzau(Object obj) {
        return ((zzeqd) obj).zzbjj();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzba(Object obj) {
        return ((zzeqd) obj).zzbma();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzk(Object obj, Object obj2) {
        zzeqd zzeqd = (zzeqd) obj;
        zzeqd zzeqd2 = (zzeqd) obj2;
        if (zzeqd2.equals(zzeqd.zzbly())) {
            return zzeqd;
        }
        return zzeqd.zza(zzeqd, zzeqd2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzeqx zzeqx) throws IOException {
        ((zzeqd) obj).zza(zzeqx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzeqx zzeqx) throws IOException {
        ((zzeqd) obj).zzb(zzeqx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Object obj, Object obj2) {
        zza(obj, (zzeqd) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaz(Object obj) {
        zzeqd zzeqd = ((zzena) obj).zzitn;
        if (zzeqd != zzeqd.zzbly()) {
            return zzeqd;
        }
        zzeqd zzblz = zzeqd.zzblz();
        zza(obj, zzblz);
        return zzblz;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzay(Object obj) {
        return ((zzena) obj).zzitn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(Object obj, Object obj2) {
        zza(obj, (zzeqd) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaq(Object obj) {
        zzeqd zzeqd = (zzeqd) obj;
        zzeqd.zzbhe();
        return zzeqd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzblx() {
        return zzeqd.zzblz();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzeqd) obj).zzd((i << 3) | 3, (zzeqd) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzelq zzelq) {
        ((zzeqd) obj).zzd((i << 3) | 2, zzelq);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzeqd) obj).zzd((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzeqd) obj).zzd((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzeqd) obj).zzd(i << 3, Long.valueOf(j));
    }
}
