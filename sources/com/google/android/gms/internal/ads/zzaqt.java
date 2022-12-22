package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzaqt implements MediationInterstitialAdapter {
    private Uri uri;
    /* access modifiers changed from: private */
    public Activity zzdqj;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzdqk;

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdqk = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzbao.zzez("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzbao.zzez("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdqk.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacq.zzj(context))) {
                zzbao.zzez("Default browser does not support custom tabs. Bailing out.");
                this.zzdqk.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzbao.zzez("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzdqk.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            this.zzdqj = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdqk.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.uri);
        zzj.zzegq.post(new zzaqv(this, new AdOverlayInfoParcel(new zzb(build.intent, (zzv) null), (zzve) null, new zzaqs(this), (zzx) null, new zzbar(0, 0, false), (zzbfi) null)));
        zzr.zzkz().zzyh();
    }

    public final void onDestroy() {
        zzbao.zzdz("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzbao.zzdz("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzbao.zzdz("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
