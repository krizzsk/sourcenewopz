package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.didi.sdk.push.fcm.Constact;
import com.google.android.gms.ads.internal.util.zzbn;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzcfd {
    private final zzchu zzgio;
    private final zzcja zzgix;
    private ViewTreeObserver.OnScrollChangedListener zzgjc = null;

    public zzcfd(zzcja zzcja, zzchu zzchu) {
        this.zzgix = zzcja;
        this.zzgio = zzchu;
    }

    public final View zza(View view, WindowManager windowManager) throws zzbfu {
        zzbfi zza = this.zzgix.zza(zzvt.zzqk(), (zzdot) null, (zzdoy) null);
        zza.getView().setVisibility(4);
        zza.getView().setContentDescription("policy_validator");
        zza.zza("/sendMessageToSdk", (zzaig<? super zzbfi>) new zzcfc(this));
        zza.zza("/hideValidatorOverlay", (zzaig<? super zzbfi>) new zzcff(this, windowManager, view));
        zza.zza("/open", (zzaig<? super zzbfi>) new zzaio((zza) null, (zzaqz) null, (zzcsh) null, (zzcmb) null, (zzdtw) null));
        this.zzgio.zza(new WeakReference(zza), "/loadNativeAdPolicyViolations", new zzcfe(this, view, windowManager));
        this.zzgio.zza(new WeakReference(zza), "/showValidatorOverlay", zzcfh.zzdif);
        return zza.getView();
    }

    private static int zza(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzww.zzqw();
        return zzbae.zze(context, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(View view, WindowManager windowManager, zzbfi zzbfi, Map map) {
        int i;
        zzbfi.zzaef().zza((zzbgt) new zzcfj(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zza = zza(context, (String) map.get("validator_width"), ((Integer) zzww.zzra().zzd(zzabq.zzdao)).intValue());
            int zza2 = zza(context, (String) map.get("validator_height"), ((Integer) zzww.zzra().zzd(zzabq.zzdap)).intValue());
            int zza3 = zza(context, (String) map.get("validator_x"), 0);
            int zza4 = zza(context, (String) map.get("validator_y"), 0);
            zzbfi.zza(zzbgx.zzs(zza, zza2));
            try {
                zzbfi.getWebView().getSettings().setUseWideViewPort(((Boolean) zzww.zzra().zzd(zzabq.zzdaq)).booleanValue());
                zzbfi.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzww.zzra().zzd(zzabq.zzdar)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzaaj = zzbn.zzaaj();
            zzaaj.x = zza3;
            zzaaj.y = zza4;
            windowManager.updateViewLayout(zzbfi.getView(), zzaaj);
            String str = (String) map.get(OptionsBridge.ORIENTATION_KEY);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || "2".equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.zzgjc = new zzcfg(view, zzbfi, str, zzaaj, i - zza4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzgjc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzbfi.loadUrl(str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put(Constact.KEY_LINK_MESSAGETYPE, "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzgio.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(WindowManager windowManager, View view, zzbfi zzbfi, Map map) {
        zzd.zzdz("Hide native ad policy validator overlay.");
        zzbfi.getView().setVisibility(8);
        if (zzbfi.getView().getWindowToken() != null) {
            windowManager.removeView(zzbfi.getView());
        }
        zzbfi.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzgjc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzgjc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbfi zzbfi, Map map) {
        this.zzgio.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
