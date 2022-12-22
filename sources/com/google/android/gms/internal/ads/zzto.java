package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.zzr;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzto {
    private final Context context;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zztj zzbvm;
    /* access modifiers changed from: private */
    public boolean zzbwg;

    zzto(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: package-private */
    public final Future<zztw> zzd(zzti zzti) {
        zztr zztr = new zztr(this);
        zztq zztq = new zztq(this, zzti, zztr);
        zztu zztu = new zztu(this, zztr);
        synchronized (this.lock) {
            zztj zztj = new zztj(this.context, zzr.zzlj().zzaai(), zztq, zztu);
            this.zzbvm = zztj;
            zztj.checkAvailabilityAndConnect();
        }
        return zztr;
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbvm != null) {
                this.zzbvm.disconnect();
                this.zzbvm = null;
                Binder.flushPendingCommands();
            }
        }
    }
}
