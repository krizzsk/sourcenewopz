package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzbbm;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbz {
    private final View view;
    private boolean zzbsf;
    private boolean zzbwt;
    private Activity zzeji;
    private boolean zzejj;
    private ViewTreeObserver.OnGlobalLayoutListener zzejk;
    private ViewTreeObserver.OnScrollChangedListener zzejl = null;

    public zzbz(Activity activity, View view2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzeji = activity;
        this.view = view2;
        this.zzejk = onGlobalLayoutListener;
    }

    public final void zzj(Activity activity) {
        this.zzeji = activity;
    }

    public final void zzaal() {
        this.zzbwt = true;
        if (this.zzbsf) {
            zzaan();
        }
    }

    public final void zzaam() {
        this.zzbwt = false;
        zzaao();
    }

    public final void onAttachedToWindow() {
        this.zzbsf = true;
        if (this.zzbwt) {
            zzaan();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbsf = false;
        zzaao();
    }

    private final void zzaan() {
        ViewTreeObserver zzk;
        if (!this.zzejj) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzejk;
            if (onGlobalLayoutListener != null) {
                Activity activity = this.zzeji;
                if (!(activity == null || (zzk = zzk(activity)) == null)) {
                    zzk.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
                zzr.zzls();
                zzbbm.zza(this.view, this.zzejk);
            }
            this.zzejj = true;
        }
    }

    private final void zzaao() {
        ViewTreeObserver zzk;
        Activity activity = this.zzeji;
        if (activity != null && this.zzejj) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzejk;
            if (!(onGlobalLayoutListener == null || (zzk = zzk(activity)) == null)) {
                zzr.zzkx();
                zzk.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzejj = false;
        }
    }

    private static ViewTreeObserver zzk(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
