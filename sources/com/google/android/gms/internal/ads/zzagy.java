package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public final class zzagy {
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzdho;
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomClickListener zzdhp;
    private NativeCustomTemplateAd zzdhq;

    public zzagy(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzdho = onCustomTemplateAdLoadedListener;
        this.zzdhp = onCustomClickListener;
    }

    public final zzagd zzuf() {
        return new zzahd(this);
    }

    public final zzafy zzug() {
        if (this.zzdhp == null) {
            return null;
        }
        return new zzaha(this);
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzb(zzafo zzafo) {
        if (this.zzdhq != null) {
            return this.zzdhq;
        }
        zzaft zzaft = new zzaft(zzafo);
        this.zzdhq = zzaft;
        return zzaft;
    }
}
