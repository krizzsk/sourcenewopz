package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzx;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzcic implements zzp, zzx, zzahn, zzahp, zzve {
    private zzve zzchr;
    private zzahn zzdic;
    private zzahp zzdie;
    private zzp zzduf;
    private zzx zzduj;

    private zzcic() {
    }

    public final synchronized void onAdClicked() {
        if (this.zzchr != null) {
            this.zzchr.onAdClicked();
        }
    }

    public final synchronized void zza(zzl zzl) {
        if (this.zzduf != null) {
            this.zzduf.zza(zzl);
        }
    }

    public final synchronized void onUserLeaveHint() {
        if (this.zzduf != null) {
            this.zzduf.onUserLeaveHint();
        }
    }

    public final synchronized void onPause() {
        if (this.zzduf != null) {
            this.zzduf.onPause();
        }
    }

    public final synchronized void onResume() {
        if (this.zzduf != null) {
            this.zzduf.onResume();
        }
    }

    public final synchronized void zzvz() {
        if (this.zzduf != null) {
            this.zzduf.zzvz();
        }
    }

    public final synchronized void zzws() {
        if (this.zzduj != null) {
            this.zzduj.zzws();
        }
    }

    public final synchronized void zza(String str, Bundle bundle) {
        if (this.zzdic != null) {
            this.zzdic.zza(str, bundle);
        }
    }

    public final synchronized void onAppEvent(String str, String str2) {
        if (this.zzdie != null) {
            this.zzdie.onAppEvent(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zza(zzve zzve, zzahn zzahn, zzp zzp, zzahp zzahp, zzx zzx) {
        this.zzchr = zzve;
        this.zzdic = zzahn;
        this.zzduf = zzp;
        this.zzdie = zzahp;
        this.zzduj = zzx;
    }

    /* synthetic */ zzcic(zzchz zzchz) {
        this();
    }
}
