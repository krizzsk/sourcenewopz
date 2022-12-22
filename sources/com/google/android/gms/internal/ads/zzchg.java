package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzchg extends zzakd implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzaef {
    private boolean zzevf = false;
    private zzzd zzggt;
    private View zzggy;
    private zzcdf zzghx;
    private boolean zzglb = false;

    public zzchg(zzcdf zzcdf, zzcdr zzcdr) {
        this.zzggy = zzcdr.zzaos();
        this.zzggt = zzcdr.getVideoController();
        this.zzghx = zzcdf;
        if (zzcdr.zzaot() != null) {
            zzcdr.zzaot().zza((zzaef) this);
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzakf zzakf) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzevf) {
            zzd.zzex("Instream ad can not be shown after destroy().");
            zza(zzakf, 2);
        } else if (this.zzggy == null || this.zzggt == null) {
            String str = this.zzggy == null ? "can not get video view." : "can not get video controller.";
            zzd.zzex(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zza(zzakf, 0);
        } else if (this.zzglb) {
            zzd.zzex("Instream ad should not be used again.");
            zza(zzakf, 1);
        } else {
            this.zzglb = true;
            zzaqe();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzggy, new ViewGroup.LayoutParams(-1, -1));
            zzr.zzls();
            zzbbm.zza(this.zzggy, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzr.zzls();
            zzbbm.zza(this.zzggy, (ViewTreeObserver.OnScrollChangedListener) this);
            zzaqf();
            try {
                zzakf.zzuo();
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, (zzakf) new zzchi(this));
    }

    public final zzzd getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzevf) {
            return this.zzggt;
        }
        zzd.zzex("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzaer zzue() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzevf) {
            zzd.zzex("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzcdf zzcdf = this.zzghx;
        if (zzcdf == null || zzcdf.zzaol() == null) {
            return null;
        }
        return this.zzghx.zzaol().zzue();
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzaqe();
        zzcdf zzcdf = this.zzghx;
        if (zzcdf != null) {
            zzcdf.destroy();
        }
        this.zzghx = null;
        this.zzggy = null;
        this.zzggt = null;
        this.zzevf = true;
    }

    private final void zzaqe() {
        View view = this.zzggy;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzggy);
            }
        }
    }

    public final void onGlobalLayout() {
        zzaqf();
    }

    public final void onScrollChanged() {
        zzaqf();
    }

    public final void zzto() {
        zzj.zzegq.post(new zzchj(this));
    }

    private final void zzaqf() {
        View view;
        zzcdf zzcdf = this.zzghx;
        if (zzcdf != null && (view = this.zzggy) != null) {
            zzcdf.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzcdf.zzz(this.zzggy));
        }
    }

    private static void zza(zzakf zzakf, int i) {
        try {
            zzakf.zzdd(i);
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqg() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }
}
