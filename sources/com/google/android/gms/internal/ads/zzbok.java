package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbok extends zzbne {
    private final Executor zzfur;
    private final zzagm zzfxu;
    private final Runnable zzfxv;

    public zzbok(zzbpf zzbpf, zzagm zzagm, Runnable runnable, Executor executor) {
        super(zzbpf);
        this.zzfxu = zzagm;
        this.zzfxv = runnable;
        this.zzfur = executor;
    }

    public final zzzd getVideoController() {
        return null;
    }

    public final void zza(ViewGroup viewGroup, zzvt zzvt) {
    }

    public final zzdow zzakk() {
        return null;
    }

    public final View zzakl() {
        return null;
    }

    public final zzdow zzakt() {
        return null;
    }

    public final int zzaku() {
        return 0;
    }

    public final void zzkj() {
    }

    public final void zzakv() {
        this.zzfur.execute(new zzbom(this, new zzbon(new AtomicReference(this.zzfxv))));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Runnable runnable) {
        try {
            if (!this.zzfxu.zzm(ObjectWrapper.wrap(runnable))) {
                runnable.run();
            }
        } catch (RemoteException unused) {
            runnable.run();
        }
    }
}
