package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.nonagon.transaction.omid.OmidMediaType;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzuh;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbt implements zzp, zzbuj {
    private final Context context;
    private final zzbar zzbpx;
    private final zzbfi zzdkm;
    private final zzdot zzeux;
    private IObjectWrapper zzfya;
    private final zzuh.zza.C22026zza zzgdw;

    public zzcbt(Context context2, zzbfi zzbfi, zzdot zzdot, zzbar zzbar, zzuh.zza.C22026zza zza) {
        this.context = context2;
        this.zzdkm = zzbfi;
        this.zzeux = zzdot;
        this.zzbpx = zzbar;
        this.zzgdw = zza;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void onUserLeaveHint() {
    }

    public final void onAdLoaded() {
        zzasc zzasc;
        zzase zzase;
        zzase zzase2;
        if ((this.zzgdw == zzuh.zza.C22026zza.REWARD_BASED_VIDEO_AD || this.zzgdw == zzuh.zza.C22026zza.INTERSTITIAL || this.zzgdw == zzuh.zza.C22026zza.APP_OPEN) && this.zzeux.zzdyg && this.zzdkm != null && zzr.zzlk().zzm(this.context)) {
            int i = this.zzbpx.zzeka;
            int i2 = this.zzbpx.zzekb;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            String sb2 = sb.toString();
            String videoEventsOwner = this.zzeux.zzhms.getVideoEventsOwner();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcwk)).booleanValue()) {
                if (this.zzeux.zzhms.getMediaType() == OmidMediaType.VIDEO) {
                    zzasc = zzasc.zzdsm;
                    zzase = zzase.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.zzeux.zzhmt == 2) {
                        zzase2 = zzase.UNSPECIFIED;
                    } else {
                        zzase2 = zzase.BEGIN_TO_RENDER;
                    }
                    zzase = zzase2;
                    zzasc = zzasc.HTML_DISPLAY;
                }
                this.zzfya = zzr.zzlk().zza(sb2, this.zzdkm.getWebView(), "", "javascript", videoEventsOwner, zzase, zzasc, this.zzeux.zzcig);
            } else {
                this.zzfya = zzr.zzlk().zza(sb2, this.zzdkm.getWebView(), "", "javascript", videoEventsOwner);
            }
            if (this.zzfya != null && this.zzdkm.getView() != null) {
                zzr.zzlk().zza(this.zzfya, this.zzdkm.getView());
                this.zzdkm.zzar(this.zzfya);
                zzr.zzlk().zzac(this.zzfya);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcwn)).booleanValue()) {
                    this.zzdkm.zza("onSdkLoaded", (Map<String, ?>) new ArrayMap());
                }
            }
        }
    }

    public final void zza(zzl zzl) {
        this.zzfya = null;
    }

    public final void zzvz() {
        zzbfi zzbfi;
        if (this.zzfya != null && (zzbfi = this.zzdkm) != null) {
            zzbfi.zza("onSdkImpression", (Map<String, ?>) new ArrayMap());
        }
    }
}
