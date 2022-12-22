package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzasg;
import com.google.android.gms.internal.ads.zzww;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzu extends zzasg {
    private Activity zzaax;
    private boolean zzdth = false;
    private AdOverlayInfoParcel zzdus;
    private boolean zzdut = false;

    public zzu(Activity activity, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdus = adOverlayInfoParcel;
        this.zzaax = activity;
    }

    public final void onActivityResult(int i, int i2, Intent intent) throws RemoteException {
    }

    public final void onBackPressed() throws RemoteException {
    }

    public final void onRestart() throws RemoteException {
    }

    public final void onStart() throws RemoteException {
    }

    public final void zzae(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzdq() throws RemoteException {
    }

    public final boolean zzwh() throws RemoteException {
        return false;
    }

    public final void onCreate(Bundle bundle) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzdbq)).booleanValue()) {
            this.zzaax.requestWindowFeature(1);
        }
        boolean z = false;
        if (bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false)) {
            z = true;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdus;
        if (adOverlayInfoParcel == null) {
            this.zzaax.finish();
        } else if (z) {
            this.zzaax.finish();
        } else {
            if (bundle == null) {
                if (adOverlayInfoParcel.zzchr != null) {
                    this.zzdus.zzchr.onAdClicked();
                }
                if (!(this.zzaax.getIntent() == null || !this.zzaax.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true) || this.zzdus.zzduf == null)) {
                    this.zzdus.zzduf.zzvz();
                }
            }
            zzr.zzkt();
            if (!zza.zza((Context) this.zzaax, this.zzdus.zzdue, this.zzdus.zzduj, this.zzdus.zzdue.zzdjj)) {
                this.zzaax.finish();
            }
        }
    }

    public final void onResume() throws RemoteException {
        if (this.zzdth) {
            this.zzaax.finish();
            return;
        }
        this.zzdth = true;
        if (this.zzdus.zzduf != null) {
            this.zzdus.zzduf.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) throws RemoteException {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdth);
    }

    public final void onPause() throws RemoteException {
        if (this.zzdus.zzduf != null) {
            this.zzdus.zzduf.onPause();
        }
        if (this.zzaax.isFinishing()) {
            zzwr();
        }
    }

    public final void onUserLeaveHint() throws RemoteException {
        if (this.zzdus.zzduf != null) {
            this.zzdus.zzduf.onUserLeaveHint();
        }
    }

    public final void onStop() throws RemoteException {
        if (this.zzaax.isFinishing()) {
            zzwr();
        }
    }

    public final void onDestroy() throws RemoteException {
        if (this.zzaax.isFinishing()) {
            zzwr();
        }
    }

    private final synchronized void zzwr() {
        if (!this.zzdut) {
            if (this.zzdus.zzduf != null) {
                this.zzdus.zzduf.zza(zzl.OTHER);
            }
            this.zzdut = true;
        }
    }
}
