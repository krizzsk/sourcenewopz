package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzuh;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcbx implements zzbsy, zzbza {
    private final Context context;
    private final View view;
    private final zzayd zzbrf;
    private final zzaya zzfyl;
    private final zzuh.zza.C22026zza zzgdw;
    private String zzgdy;

    public zzcbx(zzaya zzaya, Context context2, zzayd zzayd, View view2, zzuh.zza.C22026zza zza) {
        this.zzfyl = zzaya;
        this.context = context2;
        this.zzbrf = zzayd;
        this.view = view2;
        this.zzgdw = zza;
    }

    public final void onAdLeftApplication() {
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final void zzalx() {
    }

    public final void onAdOpened() {
        View view2 = this.view;
        if (!(view2 == null || this.zzgdy == null)) {
            this.zzbrf.zzf(view2.getContext(), this.zzgdy);
        }
        this.zzfyl.zzaq(true);
    }

    public final void onAdClosed() {
        this.zzfyl.zzaq(false);
    }

    public final void zzalz() {
        String zzac = this.zzbrf.zzac(this.context);
        this.zzgdy = zzac;
        String valueOf = String.valueOf(zzac);
        String str = this.zzgdw == zzuh.zza.C22026zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zzgdy = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzavd zzavd, String str, String str2) {
        if (this.zzbrf.zzaa(this.context)) {
            try {
                this.zzbrf.zza(this.context, this.zzbrf.zzaf(this.context), this.zzfyl.getAdUnitId(), zzavd.getType(), zzavd.getAmount());
            } catch (RemoteException e) {
                zzd.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
