package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzaqs implements zzp {
    private final /* synthetic */ zzaqt zzdqi;

    zzaqs(zzaqt zzaqt) {
        this.zzdqi = zzaqt;
    }

    public final void onUserLeaveHint() {
    }

    public final void zza(zzl zzl) {
        zzbao.zzdz("AdMobCustomTabsAdapter overlay is closed.");
        this.zzdqi.zzdqk.onAdClosed(this.zzdqi);
    }

    public final void onPause() {
        zzbao.zzdz("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzbao.zzdz("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzvz() {
        zzbao.zzdz("Opening AdMobCustomTabsAdapter overlay.");
        this.zzdqi.zzdqk.onAdOpened(this.zzdqi);
    }
}
