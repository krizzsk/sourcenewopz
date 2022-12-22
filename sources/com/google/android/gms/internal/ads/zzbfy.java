package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzuh;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbfy extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbfi {
    private int maxHeight = -1;
    private int maxWidth = -1;
    private String zzadd;
    private final zzbar zzbpx;
    private final WindowManager zzbro;
    private int zzbwf;
    private int zzdrr = -1;
    private int zzdrs = -1;
    private boolean zzduh;
    private String zzdvx = "";
    private Boolean zzeej;
    private zzacf zzeos;
    private final zztz zzesy;
    private final zzbgy zzeur;
    private final zzei zzeus;
    private final zzacv zzeut;
    private final zzm zzeuu;
    private final zzb zzeuv;
    private final float zzeuw;
    private zzdot zzeux;
    private zzdoy zzeuy;
    private boolean zzeuz = false;
    private boolean zzeva = false;
    private zzbfh zzevb;
    private zze zzevc;
    private IObjectWrapper zzevd;
    private zzbgx zzeve;
    private boolean zzevf;
    private boolean zzevg;
    private boolean zzevh;
    private int zzevi;
    private boolean zzevj = true;
    private boolean zzevk = false;
    private zzbgc zzevl;
    private boolean zzevm;
    private boolean zzevn;
    private zzaeg zzevo;
    private zzaef zzevp;
    private zzsi zzevq;
    private int zzevr;
    /* access modifiers changed from: private */
    public int zzevs;
    private zzacf zzevt;
    private zzacf zzevu;
    private zzace zzevv;
    private WeakReference<View.OnClickListener> zzevw;
    private int zzevx;
    private int zzevy;
    private zze zzevz;
    private boolean zzewa;
    private zzbz zzewb;
    private Map<String, zzbek> zzewc;
    private final DisplayMetrics zzxe;

    static zzbfy zzc(Context context, zzbgx zzbgx, String str, boolean z, boolean z2, zzei zzei, zzacv zzacv, zzbar zzbar, zzach zzach, zzm zzm, zzb zzb, zztz zztz, zzdot zzdot, zzdoy zzdoy) {
        return new zzbfy(new zzbgy(context), zzbgx, str, z, z2, zzei, zzacv, zzbar, zzach, zzm, zzb, zztz, zzdot, zzdoy);
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final zzbch zzabu() {
        return null;
    }

    public final boolean zzaeu() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzbfy(zzbgy zzbgy, zzbgx zzbgx, String str, boolean z, boolean z2, zzei zzei, zzacv zzacv, zzbar zzbar, zzach zzach, zzm zzm, zzb zzb, zztz zztz, zzdot zzdot, zzdoy zzdoy) {
        super(zzbgy);
        zzdoy zzdoy2;
        zzbar zzbar2 = zzbar;
        this.zzeur = zzbgy;
        this.zzeve = zzbgx;
        this.zzadd = str;
        this.zzevg = z;
        this.zzevi = -1;
        this.zzeus = zzei;
        this.zzeut = zzacv;
        this.zzbpx = zzbar2;
        this.zzeuu = zzm;
        this.zzeuv = zzb;
        this.zzbro = (WindowManager) getContext().getSystemService("window");
        zzr.zzkv();
        DisplayMetrics zza = zzj.zza(this.zzbro);
        this.zzxe = zza;
        this.zzeuw = zza.density;
        this.zzesy = zztz;
        this.zzeux = zzdot;
        this.zzeuy = zzdoy;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzd.zzc("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(zzr.zzkv().zzq(zzbgy, zzbar2.zzbrz));
        zzr.zzkx().zza(getContext(), settings);
        setDownloadListener(this);
        zzaez();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(new zzbgg(this, new zzbgf(this)), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzewb = new zzbz(this.zzeur.zzabx(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zzafd();
        zzace zzace = new zzace(new zzach(true, "make_wv", this.zzadd));
        this.zzevv = zzace;
        zzace.zzsr().zzc(zzach);
        if (!(!((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() || (zzdoy2 = this.zzeuy) == null || zzdoy2.zzbwe == null)) {
            this.zzevv.zzsr().zzg("gqi", this.zzeuy.zzbwe);
        }
        zzacf zzb2 = zzaby.zzb(this.zzevv.zzsr());
        this.zzeos = zzb2;
        this.zzevv.zza("native:view_create", zzb2);
        this.zzevu = null;
        this.zzevt = null;
        zzr.zzkx().zzbh(zzbgy);
        zzr.zzkz().zzyi();
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbfh) {
            this.zzevb = (zzbfh) webViewClient;
        }
    }

    public final zzb zzaby() {
        return this.zzeuv;
    }

    private final boolean zzaew() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzevb.zzadm() && !this.zzevb.zzadn()) {
            return false;
        }
        zzww.zzqw();
        DisplayMetrics displayMetrics = this.zzxe;
        int zzb = zzbae.zzb(displayMetrics, displayMetrics.widthPixels);
        zzww.zzqw();
        DisplayMetrics displayMetrics2 = this.zzxe;
        int zzb2 = zzbae.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzabx = this.zzeur.zzabx();
        if (zzabx == null || zzabx.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzr.zzkv();
            int[] zzf = zzj.zzf(zzabx);
            zzww.zzqw();
            int zzb3 = zzbae.zzb(this.zzxe, zzf[0]);
            zzww.zzqw();
            i = zzbae.zzb(this.zzxe, zzf[1]);
            i2 = zzb3;
        }
        if (this.zzdrr == zzb && this.zzdrs == zzb2 && this.maxWidth == i2 && this.maxHeight == i) {
            return false;
        }
        if (!(this.zzdrr == zzb && this.zzdrs == zzb2)) {
            z = true;
        }
        this.zzdrr = zzb;
        this.zzdrs = zzb2;
        this.maxWidth = i2;
        this.maxHeight = i;
        new zzarj(this).zza(zzb, zzb2, i2, i, this.zzxe.density, this.zzbro.getDefaultDisplay().getRotation());
        return z;
    }

    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, zzr.zzkv().zzj(map));
        } catch (JSONException unused) {
            zzd.zzez("Could not convert parameters to JSON.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.ads.internal.util.zzd.zzfb(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfy.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    private final synchronized void zzfl(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzr.zzkz().zza(e, "AdWebViewImpl.loadUrl");
                zzd.zzd("Could not call loadUrl. ", e);
            }
        } else {
            zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zzfm(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzr.zzkz().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzd.zzd("Could not call loadUrl. ", e);
        }
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        if (!isDestroyed()) {
            String str4 = str;
            super.loadDataWithBaseURL(str4, zzbgn.zzf(str2, zzbgn.zzaff()), "text/html", "UTF-8", str3);
            return;
        }
        zzd.zzez("#004 The webview is destroyed. Ignoring action.");
    }

    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, (ValueCallback<String>) null);
        } else {
            zzd.zzez("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final void zzfn(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzyg() == null) {
                zzaex();
            }
            if (zzyg().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfl(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    public final void zzcv(String str) {
        zzfn(str);
    }

    private final synchronized void zzaex() {
        Boolean zzyg = zzr.zzkz().zzyg();
        this.zzeej = zzyg;
        if (zzyg == null) {
            try {
                evaluateJavascript("(function(){})()", (ValueCallback<String>) null);
                zza((Boolean) true);
            } catch (IllegalStateException unused) {
                zza((Boolean) false);
            }
        }
    }

    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzeej = bool;
        }
        zzr.zzkz().zza(bool);
    }

    private final synchronized Boolean zzyg() {
        return this.zzeej;
    }

    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzfn(sb.toString());
    }

    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzd.zzdz(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzfn(sb.toString());
    }

    public final void zzady() {
        zzaey();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpx.zzbrz);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final void zzec(int i) {
        if (i == 0) {
            zzaby.zza(this.zzevv.zzsr(), this.zzeos, "aebb2");
        }
        zzaey();
        if (this.zzevv.zzsr() != null) {
            this.zzevv.zzsr().zzg(ParamConst.CLOSE_TYPE, String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbpx.zzbrz);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    private final void zzaey() {
        zzaby.zza(this.zzevv.zzsr(), this.zzeos, "aeh2");
    }

    public final void zzwm() {
        if (this.zzevt == null) {
            zzaby.zza(this.zzevv.zzsr(), this.zzeos, "aes2");
            zzacf zzb = zzaby.zzb(this.zzevv.zzsr());
            this.zzevt = zzb;
            this.zzevv.zza("native:view_show", zzb);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpx.zzbrz);
        zza("onshow", (Map<String, ?>) hashMap);
    }

    public final void zzadz() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzr.zzla().zzrh()));
        hashMap.put("app_volume", String.valueOf(zzr.zzla().zzrg()));
        hashMap.put("device_volume", String.valueOf(zzae.zzbj(getContext())));
        zza("volume", (Map<String, ?>) hashMap);
    }

    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", (Map<String, ?>) hashMap);
    }

    public final synchronized zze zzaeb() {
        return this.zzevc;
    }

    public final synchronized IObjectWrapper zzaej() {
        return this.zzevd;
    }

    public final synchronized zze zzaec() {
        return this.zzevz;
    }

    public final synchronized zzbgx zzaed() {
        return this.zzeve;
    }

    public final synchronized String zzaee() {
        return this.zzadd;
    }

    public final WebViewClient zzaeg() {
        return this.zzevb;
    }

    public final synchronized boolean zzaeh() {
        return this.zzduh;
    }

    public final zzei zzaei() {
        return this.zzeus;
    }

    public final zzbar zzacc() {
        return this.zzbpx;
    }

    public final synchronized boolean zzaek() {
        return this.zzevg;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzr.zzkv();
            zzj.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzd.zzdz(sb.toString());
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzevb.zzadn() || this.zzevb.zzado()) {
            zzei zzei = this.zzeus;
            if (zzei != null) {
                zzei.zza(motionEvent);
            }
            zzacv zzacv = this.zzeut;
            if (zzacv != null) {
                zzacv.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                if (this.zzevo != null) {
                    this.zzevo.zzc(motionEvent);
                }
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01f8, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01d6 A[SYNTHETIC, Splitter:B:111:0x01d6] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0141  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:121:0x01f9=Splitter:B:121:0x01f9, B:64:0x00de=Splitter:B:64:0x00de} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x01fe }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()     // Catch:{ all -> 0x01fe }
            if (r0 != 0) goto L_0x01f9
            boolean r0 = r7.zzevg     // Catch:{ all -> 0x01fe }
            if (r0 != 0) goto L_0x01f9
            com.google.android.gms.internal.ads.zzbgx r0 = r7.zzeve     // Catch:{ all -> 0x01fe }
            boolean r0 = r0.zzafk()     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x0021
            goto L_0x01f9
        L_0x0021:
            com.google.android.gms.internal.ads.zzbgx r0 = r7.zzeve     // Catch:{ all -> 0x01fe }
            boolean r0 = r0.zzafm()     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbgx r0 = r7.zzeve     // Catch:{ all -> 0x01fe }
            boolean r0 = r0.zzafl()     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcub     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x01fe }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01fe }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01fe }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbgc r0 = r7.zzabv()     // Catch:{ all -> 0x01fe }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()     // Catch:{ all -> 0x01fe }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x0063:
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01fe }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01fe }
            float r1 = (float) r9     // Catch:{ all -> 0x01fe }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01fe }
            float r2 = (float) r8     // Catch:{ all -> 0x01fe }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01fe }
            if (r9 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r9 = (float) r2     // Catch:{ all -> 0x01fe }
            float r9 = r9 * r0
            int r1 = (int) r9     // Catch:{ all -> 0x01fe }
            r9 = r2
            goto L_0x0084
        L_0x007c:
            if (r8 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r8 = (float) r1     // Catch:{ all -> 0x01fe }
            float r8 = r8 / r0
            int r2 = (int) r8     // Catch:{ all -> 0x01fe }
            r8 = r1
        L_0x0084:
            int r8 = java.lang.Math.min(r1, r8)     // Catch:{ all -> 0x01fe }
            int r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x01fe }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbgx r0 = r7.zzeve     // Catch:{ all -> 0x01fe }
            boolean r0 = r0.isFluid()     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcue     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x01fe }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01fe }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01fe }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01fe }
            if (r0 != 0) goto L_0x00de
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01fe }
            if (r0 != 0) goto L_0x00b2
            goto L_0x00de
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.zzbga r1 = new com.google.android.gms.internal.ads.zzbga     // Catch:{ all -> 0x01fe }
            r1.<init>(r7)     // Catch:{ all -> 0x01fe }
            r7.zza((java.lang.String) r0, (com.google.android.gms.internal.ads.zzaig<? super com.google.android.gms.internal.ads.zzbfi>) r1)     // Catch:{ all -> 0x01fe }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.zzfn(r0)     // Catch:{ all -> 0x01fe }
            android.util.DisplayMetrics r0 = r7.zzxe     // Catch:{ all -> 0x01fe }
            float r0 = r0.density     // Catch:{ all -> 0x01fe }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01fe }
            int r1 = r7.zzevs     // Catch:{ all -> 0x01fe }
            r2 = -1
            if (r1 == r2) goto L_0x00d5
            int r9 = r7.zzevs     // Catch:{ all -> 0x01fe }
            float r9 = (float) r9     // Catch:{ all -> 0x01fe }
            float r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ all -> 0x01fe }
            goto L_0x00d9
        L_0x00d5:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01fe }
        L_0x00d9:
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x00de:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x00e3:
            com.google.android.gms.internal.ads.zzbgx r0 = r7.zzeve     // Catch:{ all -> 0x01fe }
            boolean r0 = r0.zzafj()     // Catch:{ all -> 0x01fe }
            if (r0 == 0) goto L_0x00f8
            android.util.DisplayMetrics r8 = r7.zzxe     // Catch:{ all -> 0x01fe }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01fe }
            android.util.DisplayMetrics r9 = r7.zzxe     // Catch:{ all -> 0x01fe }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01fe }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x00f8:
            int r0 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ all -> 0x01fe }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01fe }
            int r2 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01fe }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01fe }
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x0118
            if (r0 != r3) goto L_0x0114
            goto L_0x0118
        L_0x0114:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0119
        L_0x0118:
            r0 = r8
        L_0x0119:
            if (r2 == r4) goto L_0x011d
            if (r2 != r3) goto L_0x011e
        L_0x011d:
            r5 = r9
        L_0x011e:
            com.google.android.gms.internal.ads.zzbgx r2 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01fe }
            r3 = 1
            if (r2 > r0) goto L_0x012e
            com.google.android.gms.internal.ads.zzbgx r2 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01fe }
            if (r2 <= r5) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r2 = 0
            goto L_0x012f
        L_0x012e:
            r2 = 1
        L_0x012f:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzabq.zzcxb     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.ads.zzabm r6 = com.google.android.gms.internal.ads.zzww.zzra()     // Catch:{ all -> 0x01fe }
            java.lang.Object r4 = r6.zzd(r4)     // Catch:{ all -> 0x01fe }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01fe }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01fe }
            if (r4 == 0) goto L_0x0167
            com.google.android.gms.internal.ads.zzbgx r4 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r4 = r4.widthPixels     // Catch:{ all -> 0x01fe }
            float r4 = (float) r4     // Catch:{ all -> 0x01fe }
            float r6 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r4 = r4 / r6
            float r0 = (float) r0     // Catch:{ all -> 0x01fe }
            float r6 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzbgx r0 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x01fe }
            float r0 = (float) r0     // Catch:{ all -> 0x01fe }
            float r4 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r0 = r0 / r4
            float r4 = (float) r5     // Catch:{ all -> 0x01fe }
            float r5 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            r0 = 1
            goto L_0x0164
        L_0x0163:
            r0 = 0
        L_0x0164:
            if (r2 == 0) goto L_0x0167
            r2 = r0
        L_0x0167:
            r0 = 8
            if (r2 == 0) goto L_0x01d6
            com.google.android.gms.internal.ads.zzbgx r2 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01fe }
            float r2 = (float) r2     // Catch:{ all -> 0x01fe }
            float r4 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r2 = r2 / r4
            int r2 = (int) r2     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.ads.zzbgx r4 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r4 = r4.heightPixels     // Catch:{ all -> 0x01fe }
            float r4 = (float) r4     // Catch:{ all -> 0x01fe }
            float r5 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r4 = r4 / r5
            int r4 = (int) r4     // Catch:{ all -> 0x01fe }
            float r8 = (float) r8     // Catch:{ all -> 0x01fe }
            float r5 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r8 = r8 / r5
            int r8 = (int) r8     // Catch:{ all -> 0x01fe }
            float r9 = (float) r9     // Catch:{ all -> 0x01fe }
            float r5 = r7.zzeuw     // Catch:{ all -> 0x01fe }
            float r9 = r9 / r5
            int r9 = (int) r9     // Catch:{ all -> 0x01fe }
            r5 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01fe }
            r6.<init>(r5)     // Catch:{ all -> 0x01fe }
            java.lang.String r5 = "Not enough space to show ad. Needs "
            r6.append(r5)     // Catch:{ all -> 0x01fe }
            r6.append(r2)     // Catch:{ all -> 0x01fe }
            java.lang.String r2 = "x"
            r6.append(r2)     // Catch:{ all -> 0x01fe }
            r6.append(r4)     // Catch:{ all -> 0x01fe }
            java.lang.String r2 = " dp, but only has "
            r6.append(r2)     // Catch:{ all -> 0x01fe }
            r6.append(r8)     // Catch:{ all -> 0x01fe }
            java.lang.String r8 = "x"
            r6.append(r8)     // Catch:{ all -> 0x01fe }
            r6.append(r9)     // Catch:{ all -> 0x01fe }
            java.lang.String r8 = " dp."
            r6.append(r8)     // Catch:{ all -> 0x01fe }
            java.lang.String r8 = r6.toString()     // Catch:{ all -> 0x01fe }
            com.google.android.gms.ads.internal.util.zzd.zzez(r8)     // Catch:{ all -> 0x01fe }
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01fe }
            if (r8 == r0) goto L_0x01c4
            r8 = 4
            r7.setVisibility(r8)     // Catch:{ all -> 0x01fe }
        L_0x01c4:
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01fe }
            boolean r8 = r7.zzeuz     // Catch:{ all -> 0x01fe }
            if (r8 != 0) goto L_0x01f7
            com.google.android.gms.internal.ads.zztz r8 = r7.zzesy     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.ads.zzub$zza$zzb r9 = com.google.android.gms.internal.ads.zzub.zza.zzb.BANNER_SIZE_INVALID     // Catch:{ all -> 0x01fe }
            r8.zza((com.google.android.gms.internal.ads.zzub.zza.zzb) r9)     // Catch:{ all -> 0x01fe }
            r7.zzeuz = r3     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x01d6:
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01fe }
            if (r8 == r0) goto L_0x01df
            r7.setVisibility(r1)     // Catch:{ all -> 0x01fe }
        L_0x01df:
            boolean r8 = r7.zzeva     // Catch:{ all -> 0x01fe }
            if (r8 != 0) goto L_0x01ec
            com.google.android.gms.internal.ads.zztz r8 = r7.zzesy     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.ads.zzub$zza$zzb r9 = com.google.android.gms.internal.ads.zzub.zza.zzb.BANNER_SIZE_VALID     // Catch:{ all -> 0x01fe }
            r8.zza((com.google.android.gms.internal.ads.zzub.zza.zzb) r9)     // Catch:{ all -> 0x01fe }
            r7.zzeva = r3     // Catch:{ all -> 0x01fe }
        L_0x01ec:
            com.google.android.gms.internal.ads.zzbgx r8 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.ads.zzbgx r9 = r7.zzeve     // Catch:{ all -> 0x01fe }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01fe }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01fe }
        L_0x01f7:
            monitor-exit(r7)
            return
        L_0x01f9:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01fe }
            monitor-exit(r7)
            return
        L_0x01fe:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfy.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean zzaew = zzaew();
        zze zzaeb = zzaeb();
        if (zzaeb != null && zzaew) {
            zzaeb.zzwl();
        }
    }

    public final synchronized void zza(zze zze) {
        this.zzevc = zze;
    }

    public final synchronized void zzar(IObjectWrapper iObjectWrapper) {
        this.zzevd = iObjectWrapper;
    }

    public final synchronized void zzb(zze zze) {
        this.zzevz = zze;
    }

    public final synchronized void zza(zzbgx zzbgx) {
        this.zzeve = zzbgx;
        requestLayout();
    }

    public final synchronized void zzbe(boolean z) {
        boolean z2 = z != this.zzevg;
        this.zzevg = z;
        zzaez();
        if (z2) {
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcoe)).booleanValue() || !this.zzeve.zzafj()) {
                new zzarj(this).zzdv(z ? "expanded" : "default");
            }
        }
    }

    public final void zzaeo() {
        this.zzewb.zzaal();
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzewb.onAttachedToWindow();
        }
        boolean z = this.zzevm;
        if (this.zzevb != null && this.zzevb.zzadn()) {
            if (!this.zzevn) {
                this.zzevb.zzadp();
                this.zzevb.zzadq();
                this.zzevn = true;
            }
            zzaew();
            z = true;
        }
        zzbh(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzewb.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzevn && this.zzevb != null && this.zzevb.zzadn() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzevb.zzadp();
                this.zzevb.zzadq();
                this.zzevn = false;
            }
        }
        zzbh(false);
    }

    public final void zzby(Context context) {
        this.zzeur.setBaseContext(context);
        this.zzewb.zzj(this.zzeur.zzabx());
    }

    public final synchronized void zzap(boolean z) {
        if (this.zzevc != null) {
            this.zzevc.zza(this.zzevb.zzadm(), z);
        } else {
            this.zzduh = z;
        }
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.zzevi = i;
        if (this.zzevc != null) {
            this.zzevc.setRequestedOrientation(i);
        }
    }

    public final Activity zzabx() {
        return this.zzeur.zzabx();
    }

    public final Context zzaea() {
        return this.zzeur.zzaea();
    }

    private final synchronized void zzaez() {
        if (!this.zzevg) {
            if (!this.zzeve.zzafj()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzd.zzdz("Disabling hardware acceleration on an AdView.");
                    zzafa();
                    return;
                }
                zzd.zzdz("Enabling hardware acceleration on an AdView.");
                zzafb();
                return;
            }
        }
        zzd.zzdz("Enabling hardware acceleration on an overlay.");
        zzafb();
    }

    private final synchronized void zzafa() {
        if (!this.zzevh) {
            setLayerType(1, (Paint) null);
        }
        this.zzevh = true;
    }

    private final synchronized void zzafb() {
        if (this.zzevh) {
            setLayerType(0, (Paint) null);
        }
        this.zzevh = false;
    }

    public final synchronized void destroy() {
        zzafd();
        this.zzewb.zzaam();
        if (this.zzevc != null) {
            this.zzevc.close();
            this.zzevc.onDestroy();
            this.zzevc = null;
        }
        this.zzevd = null;
        this.zzevb.reset();
        if (!this.zzevf) {
            zzr.zzlr();
            zzbeh.zzc(this);
            zzafc();
            this.zzevf = true;
            zzd.zzed("Initiating WebView self destruct sequence in 3...");
            zzd.zzed("Loading blank page in WebView, 2...");
            zzfm("about:blank");
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzevf) {
                    this.zzevb.reset();
                    zzr.zzlr();
                    zzbeh.zzc(this);
                    zzafc();
                    zzyj();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized void zzael() {
        zzd.zzed("Destroying WebView!");
        zzyj();
        zzj.zzegq.post(new zzbfz(this));
    }

    private final synchronized void zzyj() {
        if (!this.zzewa) {
            this.zzewa = true;
            zzr.zzkz().zzyj();
        }
    }

    public final synchronized boolean isDestroyed() {
        return this.zzevf;
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public final void zzaep() {
        if (this.zzevu == null) {
            zzacf zzb = zzaby.zzb(this.zzevv.zzsr());
            this.zzevu = zzb;
            this.zzevv.zza("native:view_load", zzb);
        }
    }

    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzd.zzc("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzd.zzc("Could not resume webview.", e);
            }
        }
    }

    public final void zzaes() {
        zzd.zzed("Cannot add text view to inner AdWebView");
    }

    public final void zzbb(boolean z) {
        this.zzevb.zzbb(z);
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzd.zzc("Could not stop loading webview.", e);
            }
        }
    }

    public final synchronized void zzbf(boolean z) {
        this.zzevj = z;
    }

    public final synchronized boolean zzaem() {
        return this.zzevj;
    }

    public final synchronized void zzkr() {
        this.zzevk = true;
        if (this.zzeuu != null) {
            this.zzeuu.zzkr();
        }
    }

    public final synchronized void zzks() {
        this.zzevk = false;
        if (this.zzeuu != null) {
            this.zzeuu.zzks();
        }
    }

    private final synchronized void zzafc() {
        if (this.zzewc != null) {
            for (zzbek release : this.zzewc.values()) {
                release.release();
            }
        }
        this.zzewc = null;
    }

    public final synchronized void zza(String str, zzbek zzbek) {
        if (this.zzewc == null) {
            this.zzewc = new HashMap();
        }
        this.zzewc.put(str, zzbek);
    }

    public final synchronized zzbek zzfe(String str) {
        if (this.zzewc == null) {
            return null;
        }
        return this.zzewc.get(str);
    }

    public final synchronized String getRequestId() {
        return this.zzdvx;
    }

    public final synchronized String zzabz() {
        if (this.zzeuy == null) {
            return null;
        }
        return this.zzeuy.zzbwe;
    }

    public final synchronized void zzdv(int i) {
        this.zzbwf = i;
    }

    public final synchronized int zzaca() {
        return this.zzbwf;
    }

    public final synchronized void zzacf() {
        if (this.zzevp != null) {
            this.zzevp.zzto();
        }
    }

    public final synchronized void zza(zzaef zzaef) {
        this.zzevp = zzaef;
    }

    public final synchronized void zza(zzsi zzsi) {
        this.zzevq = zzsi;
    }

    public final synchronized zzsi zzaet() {
        return this.zzevq;
    }

    public final zzacf zzabw() {
        return this.zzeos;
    }

    public final zzace zzacb() {
        return this.zzevv;
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzevw = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void zza(zzaeg zzaeg) {
        this.zzevo = zzaeg;
    }

    public final synchronized zzaeg zzaeq() {
        return this.zzevo;
    }

    public final synchronized zzbgc zzabv() {
        return this.zzevl;
    }

    public final synchronized void zza(zzbgc zzbgc) {
        if (this.zzevl != null) {
            zzd.zzex("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzevl = zzbgc;
        }
    }

    public final synchronized boolean zzaen() {
        return this.zzevr > 0;
    }

    public final synchronized void zzbg(boolean z) {
        int i = this.zzevr + (z ? 1 : -1);
        this.zzevr = i;
        if (i <= 0 && this.zzevc != null) {
            this.zzevc.zzwo();
        }
    }

    private final void zzafd() {
        zzach zzsr;
        zzace zzace = this.zzevv;
        if (zzace != null && (zzsr = zzace.zzsr()) != null && zzr.zzkz().zzyf() != null) {
            zzr.zzkz().zzyf().zza(zzsr);
        }
    }

    public final void zzaer() {
        setBackgroundColor(0);
    }

    public final void zzaz(boolean z) {
        this.zzevb.zzaz(z);
    }

    public final void zzwn() {
        zze zzaeb = zzaeb();
        if (zzaeb != null) {
            zzaeb.zzwn();
        }
    }

    public final int zzacd() {
        return getMeasuredHeight();
    }

    public final int zzace() {
        return getMeasuredWidth();
    }

    public final void zzdw(int i) {
        this.zzevx = i;
    }

    public final void zzdx(int i) {
        this.zzevy = i;
    }

    public final int zzacg() {
        return this.zzevx;
    }

    public final int zzach() {
        return this.zzevy;
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzb) {
        this.zzevb.zza(zzb);
    }

    public final void zzb(boolean z, int i) {
        this.zzevb.zzb(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzevb.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzevb.zza(z, i, str, str2);
    }

    public final void zza(zzbg zzbg, zzcsh zzcsh, zzcmb zzcmb, zzdtw zzdtw, String str, String str2, int i) {
        this.zzevb.zza(zzbg, zzcsh, zzcmb, zzdtw, str, str2, i);
    }

    public final void zza(zzqx zzqx) {
        synchronized (this) {
            this.zzevm = zzqx.zzbrt;
        }
        zzbh(zzqx.zzbrt);
    }

    private final void zzbh(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }

    public final void zza(String str, zzaig<? super zzbfi> zzaig) {
        zzbfh zzbfh = this.zzevb;
        if (zzbfh != null) {
            zzbfh.zza(str, zzaig);
        }
    }

    public final void zzb(String str, zzaig<? super zzbfi> zzaig) {
        zzbfh zzbfh = this.zzevb;
        if (zzbfh != null) {
            zzbfh.zzb(str, zzaig);
        }
    }

    public final void zza(String str, Predicate<zzaig<? super zzbfi>> predicate) {
        zzbfh zzbfh = this.zzevb;
        if (zzbfh != null) {
            zzbfh.zza(str, predicate);
        }
    }

    public final boolean zzc(boolean z, int i) {
        destroy();
        this.zzesy.zza((zzty) new zzbfx(z, i));
        this.zzesy.zza(zzub.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final zzdot zzadk() {
        return this.zzeux;
    }

    public final zzdoy zzaev() {
        return this.zzeuy;
    }

    public final void onAdClicked() {
        zzbfh zzbfh = this.zzevb;
        if (zzbfh != null) {
            zzbfh.onAdClicked();
        }
    }

    public final void zza(zzdot zzdot, zzdoy zzdoy) {
        this.zzeux = zzdot;
        this.zzeuy = zzdoy;
    }

    public final synchronized void zzac(boolean z) {
        if (z) {
            setBackgroundColor(0);
        }
        if (this.zzevc != null) {
            this.zzevc.zzac(z);
        }
    }

    public final /* synthetic */ zzbgu zzaef() {
        return this.zzevb;
    }

    static final /* synthetic */ void zza(boolean z, int i, zzuh.zzi.zza zza) {
        zzuh.zzae.zza zzqf = zzuh.zzae.zzqf();
        if (zzqf.zzqe() != z) {
            zzqf.zzy(z);
        }
        zza.zza((zzuh.zzae) ((zzena) zzqf.zzcy(i).zzbjv()));
    }
}
