package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
final class zzdvi implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzgre = false;
    private boolean zzgrf = false;
    private final zzdwe zzhvz;
    private final zzdvx zzhwa;

    zzdvi(Context context, Looper looper, zzdvx zzdvx) {
        this.zzhwa = zzdvx;
        this.zzhvz = new zzdwe(context, looper, this, this, 12800000);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i) {
    }

    /* access modifiers changed from: package-private */
    public final void zzayu() {
        synchronized (this.lock) {
            if (!this.zzgre) {
                this.zzgre = true;
                this.zzhvz.checkAvailabilityAndConnect();
            }
        }
    }

    private final void zzasm() {
        synchronized (this.lock) {
            if (this.zzhvz.isConnected() || this.zzhvz.isConnecting()) {
                this.zzhvz.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.lock) {
            if (!this.zzgrf) {
                this.zzgrf = true;
                try {
                    this.zzhvz.zzazg().zza(new zzdwc(this.zzhwa.toByteArray()));
                    zzasm();
                } catch (Exception unused) {
                    zzasm();
                } catch (Throwable th) {
                    zzasm();
                    throw th;
                }
            }
        }
    }
}
