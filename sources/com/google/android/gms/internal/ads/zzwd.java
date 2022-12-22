package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.onehybrid.Constants;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class zzwd {
    /* access modifiers changed from: private */
    public final zzvo zzcje;
    /* access modifiers changed from: private */
    public final zzvl zzcjf;
    /* access modifiers changed from: private */
    public final zzaaa zzcjg;
    /* access modifiers changed from: private */
    public final zzagw zzcjh;
    /* access modifiers changed from: private */
    public final zzavr zzcji;
    private final zzawv zzcjj;
    /* access modifiers changed from: private */
    public final zzasf zzcjk;
    /* access modifiers changed from: private */
    public final zzagz zzcjl;

    public zzwd(zzvo zzvo, zzvl zzvl, zzaaa zzaaa, zzagw zzagw, zzavr zzavr, zzawv zzawv, zzasf zzasf, zzagz zzagz) {
        this.zzcje = zzvo;
        this.zzcjf = zzvl;
        this.zzcjg = zzaaa;
        this.zzcjh = zzagw;
        this.zzcji = zzavr;
        this.zzcjj = zzawv;
        this.zzcjk = zzasf;
        this.zzcjl = zzagz;
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString(Constants.OFFLINE_FLOW, str);
        zzww.zzqw().zza(context, zzww.zzrc().zzbrz, "gmob-apps", bundle, true);
    }

    public final zzxq zza(Context context, zzvt zzvt, String str, zzann zzann) {
        return (zzxq) new zzwl(this, context, zzvt, str, zzann).zzd(context, false);
    }

    public final zzxq zzb(Context context, zzvt zzvt, String str, zzann zzann) {
        return (zzxq) new zzwn(this, context, zzvt, str, zzann).zzd(context, false);
    }

    public final zzxj zzb(Context context, String str, zzann zzann) {
        return (zzxj) new zzwq(this, context, str, zzann).zzd(context, false);
    }

    public final zzaew zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzaew) new zzws(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzafd zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzafd) new zzwr(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzawf zzc(Context context, String str, zzann zzann) {
        return (zzawf) new zzwf(this, context, str, zzann).zzd(context, false);
    }

    public final zzash zzb(Activity activity) {
        zzwi zzwi = new zzwi(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbao.zzex("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzash) zzwi.zzd(activity, z);
    }

    public final zzazc zza(Context context, zzann zzann) {
        return (zzazc) new zzwh(this, context, zzann).zzd(context, false);
    }

    public final zzaru zzb(Context context, zzann zzann) {
        return (zzaru) new zzwj(this, context, zzann).zzd(context, false);
    }
}
