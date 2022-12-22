package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbch {
    private final Context zzcmo;
    private final zzbcs zzekz;
    private final ViewGroup zzems;
    private zzbcb zzemt;

    public zzbch(Context context, ViewGroup viewGroup, zzbfi zzbfi) {
        this(context, viewGroup, zzbfi, (zzbcb) null);
    }

    private zzbch(Context context, ViewGroup viewGroup, zzbcs zzbcs, zzbcb zzbcb) {
        this.zzcmo = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzems = viewGroup;
        this.zzekz = zzbcs;
        this.zzemt = null;
    }

    public final void zze(int i, int i2, int i3, int i4) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzbcb zzbcb = this.zzemt;
        if (zzbcb != null) {
            zzbcb.zzd(i, i2, i3, i4);
        }
    }

    public final void zza(int i, int i2, int i3, int i4, int i5, boolean z, zzbcp zzbcp) {
        if (this.zzemt == null) {
            zzaby.zza(this.zzekz.zzacb().zzsr(), this.zzekz.zzabw(), "vpr2");
            Context context = this.zzcmo;
            zzbcs zzbcs = this.zzekz;
            zzbcb zzbcb = new zzbcb(context, zzbcs, i5, z, zzbcs.zzacb().zzsr(), zzbcp);
            this.zzemt = zzbcb;
            this.zzems.addView(zzbcb, 0, new ViewGroup.LayoutParams(-1, -1));
            int i6 = i;
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            this.zzemt.zzd(i, i2, i3, i4);
            this.zzekz.zzaz(false);
        }
    }

    public final zzbcb zzabo() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzemt;
    }

    public final void onPause() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzbcb zzbcb = this.zzemt;
        if (zzbcb != null) {
            zzbcb.pause();
        }
    }

    public final void onDestroy() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzbcb zzbcb = this.zzemt;
        if (zzbcb != null) {
            zzbcb.destroy();
            this.zzems.removeView(this.zzemt);
            this.zzemt = null;
        }
    }
}
