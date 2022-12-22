package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzatf {
    @Nonnull
    private final View zzaay;
    private final Map<String, WeakReference<View>> zzdva;
    private final zzazc zzdvb;

    public zzatf(zzatg zzatg) {
        Map<String, WeakReference<View>> map;
        this.zzaay = zzatg.zzaay;
        this.zzdva = zzatg.zzdva;
        zzazc zzp = zzatd.zzp(zzatg.zzaay.getContext());
        this.zzdvb = zzp;
        if (zzp != null && (map = this.zzdva) != null && !map.isEmpty()) {
            try {
                this.zzdvb.zza(new zzatj(ObjectWrapper.wrap(this.zzaay).asBinder(), ObjectWrapper.wrap(this.zzdva).asBinder()));
            } catch (RemoteException unused) {
                zzbao.zzex("Failed to call remote method.");
            }
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdvb == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdvb.zza(list, ObjectWrapper.wrap(this.zzaay), (zzasy) new zzate(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdvb == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdvb.zzb(new ArrayList(Arrays.asList(new Uri[]{uri})), ObjectWrapper.wrap(this.zzaay), new zzath(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzazc zzazc = this.zzdvb;
        if (zzazc == null) {
            zzbao.zzdz("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzazc.zzao(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzbao.zzex("Failed to call remote method.");
        }
    }
}
