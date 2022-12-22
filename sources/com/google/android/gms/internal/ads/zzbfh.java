package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzub;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbfh extends WebViewClient implements zzbgu {
    private final Object lock;
    private boolean zzbsa;
    private zzve zzchr;
    private zzahn zzdic;
    private zzahp zzdie;
    private zza zzdjd;
    private zzaqz zzdjh;
    private zzp zzduf;
    private zzx zzduj;
    private boolean zzdyj;
    protected zzbfi zzesx;
    private final zztz zzesy;
    private final HashMap<String, List<zzaig<? super zzbfi>>> zzesz;
    private zzbgt zzeta;
    private zzbgw zzetb;
    private zzbgv zzetc;
    private boolean zzetd;
    private boolean zzete;
    private boolean zzetf;
    private boolean zzetg;
    private final zzarg zzeth;
    protected zzaxo zzeti;
    private boolean zzetj;
    private boolean zzetk;
    private int zzetl;
    private final HashSet<String> zzetm;
    private View.OnAttachStateChangeListener zzetn;

    public zzbfh(zzbfi zzbfi, zztz zztz, boolean z) {
        this(zzbfi, zztz, z, new zzarg(zzbfi, zzbfi.zzaea(), new zzabb(zzbfi.getContext())), (zzaqz) null);
    }

    private zzbfh(zzbfi zzbfi, zztz zztz, boolean z, zzarg zzarg, zzaqz zzaqz) {
        this.zzesz = new HashMap<>();
        this.lock = new Object();
        this.zzetd = false;
        this.zzesy = zztz;
        this.zzesx = zzbfi;
        this.zzbsa = z;
        this.zzeth = zzarg;
        this.zzdjh = null;
        this.zzetm = new HashSet<>(Arrays.asList(((String) zzww.zzra().zzd(zzabq.zzcxn)).split(",")));
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzeth.zzl(i, i2);
        zzaqz zzaqz = this.zzdjh;
        if (zzaqz != null) {
            zzaqz.zza(i, i2, false);
        }
    }

    public final void zza(zzve zzve, zzahn zzahn, zzp zzp, zzahp zzahp, zzx zzx, boolean z, zzaii zzaii, zza zza, zzari zzari, zzaxo zzaxo, zzcsh zzcsh, zzdup zzdup, zzcmb zzcmb, zzdtw zzdtw) {
        zzahn zzahn2 = zzahn;
        zzahp zzahp2 = zzahp;
        zzaii zzaii2 = zzaii;
        zzari zzari2 = zzari;
        zzaxo zzaxo2 = zzaxo;
        zza zza2 = zza == null ? new zza(this.zzesx.getContext(), zzaxo2, (zzatu) null) : zza;
        this.zzdjh = new zzaqz(this.zzesx, zzari2);
        this.zzeti = zzaxo2;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpy)).booleanValue()) {
            zza("/adMetadata", (zzaig<? super zzbfi>) new zzahk(zzahn2));
        }
        zza("/appEvent", (zzaig<? super zzbfi>) new zzahm(zzahp2));
        zza("/backButton", (zzaig<? super zzbfi>) zzahr.zzdiq);
        zza("/refresh", (zzaig<? super zzbfi>) zzahr.zzdir);
        zza("/canOpenApp", (zzaig<? super zzbfi>) zzahr.zzdih);
        zza("/canOpenURLs", (zzaig<? super zzbfi>) zzahr.zzdig);
        zza("/canOpenIntents", (zzaig<? super zzbfi>) zzahr.zzdii);
        zza("/close", (zzaig<? super zzbfi>) zzahr.zzdik);
        zza("/customClose", (zzaig<? super zzbfi>) zzahr.zzdil);
        zza("/instrument", (zzaig<? super zzbfi>) zzahr.zzdiu);
        zza("/delayPageLoaded", (zzaig<? super zzbfi>) zzahr.zzdiw);
        zza("/delayPageClosed", (zzaig<? super zzbfi>) zzahr.zzdix);
        zza("/getLocationInfo", (zzaig<? super zzbfi>) zzahr.zzdiy);
        zza("/log", (zzaig<? super zzbfi>) zzahr.zzdin);
        zza("/mraid", (zzaig<? super zzbfi>) new zzaip(zza2, this.zzdjh, zzari2));
        zza("/mraidLoaded", (zzaig<? super zzbfi>) this.zzeth);
        zza("/open", (zzaig<? super zzbfi>) new zzaio(zza2, this.zzdjh, zzcsh, zzcmb, zzdtw));
        zza("/precache", (zzaig<? super zzbfi>) new zzbep());
        zza("/touch", (zzaig<? super zzbfi>) zzahr.zzdip);
        zza("/video", (zzaig<? super zzbfi>) zzahr.zzdis);
        zza("/videoMeta", (zzaig<? super zzbfi>) zzahr.zzdit);
        if (zzcsh == null || zzdup == null) {
            zza("/click", (zzaig<? super zzbfi>) zzahr.zzdij);
            zza("/httpTrack", (zzaig<? super zzbfi>) zzahr.zzdim);
        } else {
            zza("/click", (zzaig<? super zzbfi>) zzdpt.zza(zzcsh, zzdup));
            zza("/httpTrack", (zzaig<? super zzbfi>) zzdpt.zzb(zzcsh, zzdup));
        }
        if (zzr.zzlt().zzaa(this.zzesx.getContext())) {
            zza("/logScionEvent", (zzaig<? super zzbfi>) new zzaim(this.zzesx.getContext()));
        }
        if (zzaii2 != null) {
            zza("/setInterstitialProperties", (zzaig<? super zzbfi>) new zzaij(zzaii2));
        }
        this.zzchr = zzve;
        this.zzduf = zzp;
        this.zzdic = zzahn2;
        this.zzdie = zzahp2;
        this.zzduj = zzx;
        this.zzdjd = zza2;
        this.zzetd = z;
    }

    public void onAdClicked() {
        zzve zzve = this.zzchr;
        if (zzve != null) {
            zzve.onAdClicked();
        }
    }

    public final zza zzadl() {
        return this.zzdjd;
    }

    public final boolean zzadm() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbsa;
        }
        return z;
    }

    public final boolean zzadn() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzete;
        }
        return z;
    }

    public final boolean zzado() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzetf;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzadp() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzadq() {
        synchronized (this.lock) {
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zzuv();
        r0.zzetb = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzadw();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzetj = true;
        r1 = r0.zzetb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbfi r2 = r0.zzesx     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zzd.zzed(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzbfi r2 = r0.zzesx     // Catch:{ all -> 0x0029 }
            r2.zzael()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzetj = r1
            com.google.android.gms.internal.ads.zzbgw r1 = r0.zzetb
            if (r1 == 0) goto L_0x0025
            r1.zzuv()
            r1 = 0
            r0.zzetb = r1
        L_0x0025:
            r0.zzadw()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfh.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzaxo zzaxo, int i) {
        if (zzaxo.zzxh() && i > 0) {
            zzaxo.zzl(view);
            if (zzaxo.zzxh()) {
                zzj.zzegq.postDelayed(new zzbfm(this, view, zzaxo, i), 100);
            }
        }
    }

    private final void zzadr() {
        if (this.zzetn != null) {
            this.zzesx.getView().removeOnAttachStateChangeListener(this.zzetn);
        }
    }

    public final void zzads() {
        zzaxo zzaxo = this.zzeti;
        if (zzaxo != null) {
            WebView webView = this.zzesx.getWebView();
            if (ViewCompat.isAttachedToWindow(webView)) {
                zza((View) webView, zzaxo, 10);
                return;
            }
            zzadr();
            this.zzetn = new zzbfl(this, zzaxo);
            this.zzesx.getView().addOnAttachStateChangeListener(this.zzetn);
        }
    }

    public final void zzadt() {
        synchronized (this.lock) {
            this.zzetg = true;
        }
        this.zzetl++;
        zzadw();
    }

    public final void zzadu() {
        this.zzetl--;
        zzadw();
    }

    public final void zzadv() {
        zztz zztz = this.zzesy;
        if (zztz != null) {
            zztz.zza(zzub.zza.zzb.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzetk = true;
        zzadw();
        this.zzesx.destroy();
    }

    private final void zzadw() {
        if (this.zzeta != null && ((this.zzetj && this.zzetl <= 0) || this.zzetk)) {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && this.zzesx.zzacb() != null) {
                zzaby.zza(this.zzesx.zzacb().zzsr(), this.zzesx.zzabw(), "awfllc");
            }
            this.zzeta.zzam(!this.zzetk);
            this.zzeta = null;
        }
        this.zzesx.zzaep();
    }

    public final void zza(zzb zzb) {
        zzp zzp;
        boolean zzaek = this.zzesx.zzaek();
        zzve zzve = (!zzaek || this.zzesx.zzaed().zzafj()) ? this.zzchr : null;
        if (zzaek) {
            zzp = null;
        } else {
            zzp = this.zzduf;
        }
        zza(new AdOverlayInfoParcel(zzb, zzve, zzp, this.zzduj, this.zzesx.zzacc(), this.zzesx));
    }

    public final void zza(zzbg zzbg, zzcsh zzcsh, zzcmb zzcmb, zzdtw zzdtw, String str, String str2, int i) {
        zzbfi zzbfi = this.zzesx;
        zza(new AdOverlayInfoParcel(zzbfi, zzbfi.zzacc(), zzbg, zzcsh, zzcmb, zzdtw, str, str2, i));
    }

    public final void zzb(boolean z, int i) {
        zzve zzve = (!this.zzesx.zzaek() || this.zzesx.zzaed().zzafj()) ? this.zzchr : null;
        zzp zzp = this.zzduf;
        zzx zzx = this.zzduj;
        zzbfi zzbfi = this.zzesx;
        zza(new AdOverlayInfoParcel(zzve, zzp, zzx, zzbfi, z, i, zzbfi.zzacc()));
    }

    public final void zza(boolean z, int i, String str) {
        zzbfn zzbfn;
        boolean zzaek = this.zzesx.zzaek();
        zzve zzve = (!zzaek || this.zzesx.zzaed().zzafj()) ? this.zzchr : null;
        if (zzaek) {
            zzbfn = null;
        } else {
            zzbfn = new zzbfn(this.zzesx, this.zzduf);
        }
        zzahn zzahn = this.zzdic;
        zzahp zzahp = this.zzdie;
        zzx zzx = this.zzduj;
        zzbfi zzbfi = this.zzesx;
        zza(new AdOverlayInfoParcel(zzve, zzbfn, zzahn, zzahp, zzx, zzbfi, z, i, str, zzbfi.zzacc()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbfn zzbfn;
        boolean zzaek = this.zzesx.zzaek();
        zzve zzve = (!zzaek || this.zzesx.zzaed().zzafj()) ? this.zzchr : null;
        if (zzaek) {
            zzbfn = null;
        } else {
            zzbfn = new zzbfn(this.zzesx, this.zzduf);
        }
        zzahn zzahn = this.zzdic;
        zzahp zzahp = this.zzdie;
        zzx zzx = this.zzduj;
        zzbfi zzbfi = this.zzesx;
        zza(new AdOverlayInfoParcel(zzve, (zzp) zzbfn, zzahn, zzahp, zzx, zzbfi, z, i, str, str2, zzbfi.zzacc()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzaqz zzaqz = this.zzdjh;
        boolean zzwa = zzaqz != null ? zzaqz.zzwa() : false;
        zzr.zzku();
        zzo.zza(this.zzesx.getContext(), adOverlayInfoParcel, !zzwa);
        if (this.zzeti != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdue != null) {
                str = adOverlayInfoParcel.zzdue.url;
            }
            this.zzeti.zzdw(str);
        }
    }

    public final void zza(String str, zzaig<? super zzbfi> zzaig) {
        synchronized (this.lock) {
            List list = this.zzesz.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzesz.put(str, list);
            }
            list.add(zzaig);
        }
    }

    public final void zzb(String str, zzaig<? super zzbfi> zzaig) {
        synchronized (this.lock) {
            List list = this.zzesz.get(str);
            if (list != null) {
                list.remove(zzaig);
            }
        }
    }

    public final void zza(String str, Predicate<zzaig<? super zzbfi>> predicate) {
        synchronized (this.lock) {
            List<zzaig> list = this.zzesz.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzaig zzaig : list) {
                    if (predicate.apply(zzaig)) {
                        arrayList.add(zzaig);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void reset() {
        zzaxo zzaxo = this.zzeti;
        if (zzaxo != null) {
            zzaxo.zzxj();
            this.zzeti = null;
        }
        zzadr();
        synchronized (this.lock) {
            this.zzesz.clear();
            this.zzchr = null;
            this.zzduf = null;
            this.zzeta = null;
            this.zzetb = null;
            this.zzdic = null;
            this.zzdie = null;
            this.zzetd = false;
            this.zzbsa = false;
            this.zzete = false;
            this.zzetg = false;
            this.zzduj = null;
            this.zzetc = null;
            if (this.zzdjh != null) {
                this.zzdjh.zzag(true);
                this.zzdjh = null;
            }
        }
    }

    public final void zza(zzbgt zzbgt) {
        this.zzeta = zzbgt;
    }

    public final void zza(zzbgw zzbgw) {
        this.zzetb = zzbgw;
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.zzed(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.zzed(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzetd && webView == this.zzesx.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzve zzve = this.zzchr;
                    if (zzve != null) {
                        zzve.onAdClicked();
                        zzaxo zzaxo = this.zzeti;
                        if (zzaxo != null) {
                            zzaxo.zzdw(str);
                        }
                        this.zzchr = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzesx.getWebView().willNotDraw()) {
                try {
                    zzei zzaei = this.zzesx.zzaei();
                    if (zzaei != null && zzaei.zzb(parse)) {
                        parse = zzaei.zza(parse, this.zzesx.getContext(), this.zzesx.getView(), this.zzesx.zzabx());
                    }
                } catch (zzeh unused) {
                    String valueOf2 = String.valueOf(str);
                    zzd.zzez(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zza zza = this.zzdjd;
                if (zza == null || zza.zzkc()) {
                    zza(new zzb("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (zzv) null));
                } else {
                    this.zzdjd.zzbk(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzd.zzez(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzj(parse);
        }
        return true;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzc(String str, Map<String, String> map) {
        zzth zza;
        try {
            String zzc = zzayv.zzc(str, this.zzesx.getContext(), this.zzdyj);
            if (!zzc.equals(str)) {
                return zzd(zzc, map);
            }
            zzti zzbs = zzti.zzbs(str);
            if (zzbs != null && (zza = zzr.zzlb().zza(zzbs)) != null && zza.zznc()) {
                return new WebResourceResponse("", "", zza.zznd());
            }
            if (!zzbai.isEnabled() || !zzadi.zzdel.get().booleanValue()) {
                return null;
            }
            return zzd(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            zzr.zzkz().zza(e, "AdWebViewClient.interceptRequest");
            return zzadx();
        }
    }

    private static WebResourceResponse zzadx() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpn)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzd(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry next : map.entrySet()) {
                        openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzr.zzkv().zza(this.zzesx.getContext(), this.zzesx.zzacc().zzbrz, false, httpURLConnection, false, 60000);
                        zzbai zzbai = new zzbai();
                        zzbai.zza(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzbai.zza(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzr.zzkv();
                            WebResourceResponse zzd = zzj.zzd(httpURLConnection);
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField == null) {
                                throw new IOException("Missing Location header in redirect");
                            } else if (headerField.startsWith("tel:")) {
                                TrafficStats.clearThreadStatsTag();
                                return null;
                            } else {
                                URL url2 = new URL(url, headerField);
                                String protocol = url2.getProtocol();
                                if (protocol == null) {
                                    zzd.zzez("Protocol is null");
                                    WebResourceResponse zzadx = zzadx();
                                    TrafficStats.clearThreadStatsTag();
                                    return zzadx;
                                } else if (protocol.equals("http") || protocol.equals("https")) {
                                    String valueOf = String.valueOf(headerField);
                                    zzd.zzdz(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                                    httpURLConnection.disconnect();
                                    url = url2;
                                } else {
                                    String valueOf2 = String.valueOf(protocol);
                                    zzd.zzez(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                                    return zzadx();
                                }
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Too many redirects (20)");
                    throw new IOException(sb.toString());
                }
            }
            zzr.zzkv();
            WebResourceResponse zzd2 = zzj.zzd(httpURLConnection);
            TrafficStats.clearThreadStatsTag();
            return zzd2;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    public final void zzaz(boolean z) {
        this.zzetd = z;
    }

    public final void zzwi() {
        synchronized (this.lock) {
            this.zzetd = false;
            this.zzbsa = true;
            zzbat.zzeki.execute(new zzbfk(this));
        }
    }

    public final void zzbb(boolean z) {
        this.zzdyj = z;
    }

    public final void zzk(int i, int i2) {
        zzaqz zzaqz = this.zzdjh;
        if (zzaqz != null) {
            zzaqz.zzk(i, i2);
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final void zzj(Uri uri) {
        String path = uri.getPath();
        List list = this.zzesz.get(path);
        if (path == null || list == null) {
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
            sb.append("No GMSG handler found for GMSG: ");
            sb.append(valueOf);
            zzd.zzed(sb.toString());
            if (((Boolean) zzww.zzra().zzd(zzabq.zzczs)).booleanValue() && zzr.zzkz().zzyf() != null) {
                zzbat.zzeke.execute(new zzbfj(path));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcxm)).booleanValue() && this.zzetm.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzww.zzra().zzd(zzabq.zzcxo)).intValue()) {
                String valueOf2 = String.valueOf(path);
                zzd.zzed(valueOf2.length() != 0 ? "Parsing gmsg query params on BG thread: ".concat(valueOf2) : new String("Parsing gmsg query params on BG thread: "));
                zzebh.zza(zzr.zzkv().zzh(uri), new zzbfo(this, list, path, uri), zzbat.zzeki);
                return;
            }
        }
        zzr.zzkv();
        zza(zzj.zzg(uri), (List<zzaig<? super zzbfi>>) list, path);
    }

    /* access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzaig<? super zzbfi>> list, String str) {
        if (zzd.zzyz()) {
            String valueOf = String.valueOf(str);
            zzd.zzed(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String next : map.keySet()) {
                String str2 = map.get(next);
                StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str2).length());
                sb.append("  ");
                sb.append(next);
                sb.append(": ");
                sb.append(str2);
                zzd.zzed(sb.toString());
            }
        }
        for (zzaig<? super zzbfi> zza : list) {
            zza.zza(this.zzesx, map);
        }
    }

    public final void zzbc(boolean z) {
        synchronized (this.lock) {
            this.zzete = true;
        }
    }

    public final void zzbd(boolean z) {
        synchronized (this.lock) {
            this.zzetf = z;
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzesx.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }
}
