package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzbfi;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzk {
    public final Context context;
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdtv;

    public zzk(zzbfi zzbfi) throws zzi {
        this.zzdtv = zzbfi.getLayoutParams();
        ViewParent parent2 = zzbfi.getParent();
        this.context = zzbfi.zzaea();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new zzi("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent2;
        this.parent = viewGroup;
        this.index = viewGroup.indexOfChild(zzbfi.getView());
        this.parent.removeView(zzbfi.getView());
        zzbfi.zzbe(true);
    }
}
