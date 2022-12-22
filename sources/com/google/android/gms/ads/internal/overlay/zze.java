package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzach;
import com.google.android.gms.internal.ads.zzacv;
import com.google.android.gms.internal.ads.zzahn;
import com.google.android.gms.internal.ads.zzahp;
import com.google.android.gms.internal.ads.zzaii;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzasg;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbgu;
import com.google.android.gms.internal.ads.zzcmb;
import com.google.android.gms.internal.ads.zzcsh;
import com.google.android.gms.internal.ads.zzcsr;
import com.google.android.gms.internal.ads.zzdot;
import com.google.android.gms.internal.ads.zzdoy;
import com.google.android.gms.internal.ads.zzdtw;
import com.google.android.gms.internal.ads.zzdup;
import com.google.android.gms.internal.ads.zzei;
import com.google.android.gms.internal.ads.zztz;
import com.google.android.gms.internal.ads.zzve;
import com.google.android.gms.internal.ads.zzww;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zze extends zzasg implements zzab {
    private static final int zzdta = Color.argb(0, 0, 0, 0);
    protected final Activity zzaax;
    private boolean zzbpo = false;
    zzbfi zzdkm;
    AdOverlayInfoParcel zzdtb;
    private zzk zzdtc;
    private zzr zzdtd;
    private boolean zzdte = false;
    private FrameLayout zzdtf;
    private WebChromeClient.CustomViewCallback zzdtg;
    private boolean zzdth = false;
    private zzh zzdti;
    private boolean zzdtj = false;
    zzl zzdtk = zzl.BACK_BUTTON;
    private final Object zzdtl = new Object();
    private Runnable zzdtm;
    private boolean zzdtn;
    private boolean zzdto;
    private boolean zzdtp = false;
    private boolean zzdtq = false;
    private boolean zzdtr = true;

    public zze(Activity activity) {
        this.zzaax = activity;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onRestart() {
    }

    public final void close() {
        this.zzdtk = zzl.CUSTOM_CLOSE;
        this.zzaax.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzduk == 5) {
            this.zzaax.overridePendingTransition(0, 0);
        }
    }

    public final void zzwf() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel != null && this.zzdte) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdtf != null) {
            this.zzaax.setContentView(this.zzdti);
            this.zzdto = true;
            this.zzdtf.removeAllViews();
            this.zzdtf = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdtg;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdtg = null;
        }
        this.zzdte = false;
    }

    public final void zzwg() {
        this.zzdtk = zzl.CLOSE_BUTTON;
        this.zzaax.finish();
    }

    public final void onBackPressed() {
        this.zzdtk = zzl.BACK_BUTTON;
    }

    public final void onUserLeaveHint() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (adOverlayInfoParcel != null && adOverlayInfoParcel.zzduf != null) {
            this.zzdtb.zzduf.onUserLeaveHint();
        }
    }

    public final boolean zzwh() {
        this.zzdtk = zzl.BACK_BUTTON;
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi == null) {
            return true;
        }
        boolean zzaem = zzbfi.zzaem();
        if (!zzaem) {
            this.zzdkm.zza("onbackblocked", (Map<String, ?>) Collections.emptyMap());
        }
        return zzaem;
    }

    public void onCreate(Bundle bundle) {
        this.zzaax.requestWindowFeature(1);
        this.zzdth = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            AdOverlayInfoParcel zzd = AdOverlayInfoParcel.zzd(this.zzaax.getIntent());
            this.zzdtb = zzd;
            if (zzd != null) {
                if (zzd.zzbpx.zzekb > 7500000) {
                    this.zzdtk = zzl.OTHER;
                }
                if (this.zzaax.getIntent() != null) {
                    this.zzdtr = this.zzaax.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdtb.zzdum != null) {
                    this.zzbpo = this.zzdtb.zzdum.zzbpo;
                } else if (this.zzdtb.zzduk == 5) {
                    this.zzbpo = true;
                } else {
                    this.zzbpo = false;
                }
                if (!(!this.zzbpo || this.zzdtb.zzduk == 5 || this.zzdtb.zzdum.zzbpt == -1)) {
                    new zzj(this).zzyx();
                }
                if (bundle == null) {
                    if (this.zzdtb.zzduf != null && this.zzdtr) {
                        this.zzdtb.zzduf.zzvz();
                    }
                    if (!(this.zzdtb.zzduk == 1 || this.zzdtb.zzchr == null)) {
                        this.zzdtb.zzchr.onAdClicked();
                    }
                }
                zzh zzh = new zzh(this.zzaax, this.zzdtb.zzdul, this.zzdtb.zzbpx.zzbrz, this.zzdtb.zzbvf);
                this.zzdti = zzh;
                zzh.setId(1000);
                zzr.zzkx().zzi(this.zzaax);
                int i = this.zzdtb.zzduk;
                if (i == 1) {
                    zzao(false);
                } else if (i == 2) {
                    this.zzdtc = new zzk(this.zzdtb.zzdkm);
                    zzao(false);
                } else if (i == 3) {
                    zzao(true);
                } else if (i == 5) {
                    zzao(false);
                } else {
                    throw new zzi("Could not determine ad overlay type.");
                }
            } else {
                throw new zzi("Could not get info for ad overlay.");
            }
        } catch (zzi e) {
            zzd.zzez(e.getMessage());
            this.zzdtk = zzl.OTHER;
            this.zzaax.finish();
        }
    }

    public final void onStart() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue()) {
            zzbfi zzbfi = this.zzdkm;
            if (zzbfi == null || zzbfi.isDestroyed()) {
                zzd.zzez("The webview does not exist. Ignoring action.");
            } else {
                this.zzdkm.onResume();
            }
        }
    }

    public final void onResume() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (!(adOverlayInfoParcel == null || adOverlayInfoParcel.zzduf == null)) {
            this.zzdtb.zzduf.onResume();
        }
        zza(this.zzaax.getResources().getConfiguration());
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue()) {
            zzbfi zzbfi = this.zzdkm;
            if (zzbfi == null || zzbfi.isDestroyed()) {
                zzd.zzez("The webview does not exist. Ignoring action.");
            } else {
                this.zzdkm.onResume();
            }
        }
    }

    public final void onPause() {
        zzwf();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
        if (!(adOverlayInfoParcel == null || adOverlayInfoParcel.zzduf == null)) {
            this.zzdtb.zzduf.onPause();
        }
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue() && this.zzdkm != null && (!this.zzaax.isFinishing() || this.zzdtc == null)) {
            this.zzdkm.onPause();
        }
        zzwj();
    }

    public final void zzae(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdth);
    }

    public final void onStop() {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcvy)).booleanValue() && this.zzdkm != null && (!this.zzaax.isFinishing() || this.zzdtc == null)) {
            this.zzdkm.onPause();
        }
        zzwj();
    }

    public final void onDestroy() {
        zzbfi zzbfi = this.zzdkm;
        if (zzbfi != null) {
            try {
                this.zzdti.removeView(zzbfi.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzwj();
    }

    private final void zzan(boolean z) {
        int intValue = ((Integer) zzww.zzra().zzd(zzabq.zzcwa)).intValue();
        zzq zzq = new zzq();
        zzq.size = 50;
        zzq.paddingLeft = z ? intValue : 0;
        zzq.paddingRight = z ? 0 : intValue;
        zzq.paddingTop = 0;
        zzq.paddingBottom = intValue;
        this.zzdtd = new zzr(this.zzaax, zzq, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdtb.zzduh);
        this.zzdti.addView(this.zzdtd, layoutParams);
    }

    public final void zzdq() {
        this.zzdto = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r0 = r6.zzdtb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabq.zzcqg
            com.google.android.gms.internal.ads.zzabm r1 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdtb
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.zzk r0 = r0.zzdum
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdtb
            com.google.android.gms.ads.internal.zzk r0 = r0.zzdum
            boolean r0 = r0.zzbpv
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            com.google.android.gms.internal.ads.zzabf<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabq.zzcqh
            com.google.android.gms.internal.ads.zzabm r4 = com.google.android.gms.internal.ads.zzww.zzra()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdtb
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.zzk r3 = r3.zzdum
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdtb
            com.google.android.gms.ads.internal.zzk r3 = r3.zzdum
            boolean r3 = r3.zzbpw
            if (r3 == 0) goto L_0x004b
            r3 = 1
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            if (r7 == 0) goto L_0x0062
            if (r8 == 0) goto L_0x0062
            if (r0 == 0) goto L_0x0062
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzarj r7 = new com.google.android.gms.internal.ads.zzarj
            com.google.android.gms.internal.ads.zzbfi r4 = r6.zzdkm
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzdt(r4)
        L_0x0062:
            com.google.android.gms.ads.internal.overlay.zzr r7 = r6.zzdtd
            if (r7 == 0) goto L_0x0071
            if (r3 != 0) goto L_0x006e
            if (r8 == 0) goto L_0x006d
            if (r0 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            r7.zzap(r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zze.zza(boolean, boolean):void");
    }

    public final void zzac(boolean z) {
        if (z) {
            this.zzdti.setBackgroundColor(0);
        } else {
            this.zzdti.setBackgroundColor(-16777216);
        }
    }

    public final void zzwi() {
        this.zzdti.removeView(this.zzdtd);
        zzan(true);
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaax.getApplicationInfo().targetSdkVersion >= ((Integer) zzww.zzra().zzd(zzabq.zzcyh)).intValue()) {
            if (this.zzaax.getApplicationInfo().targetSdkVersion <= ((Integer) zzww.zzra().zzd(zzabq.zzcyi)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzww.zzra().zzd(zzabq.zzcyj)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzww.zzra().zzd(zzabq.zzcyk)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            SystemUtils.hookSetRequestedOrientation(this.zzaax, i);
        } catch (Throwable th) {
            zzr.zzkz().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout = new FrameLayout(this.zzaax);
        this.zzdtf = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        this.zzdtf.addView(view, -1, -1);
        this.zzaax.setContentView(this.zzdtf);
        this.zzdto = true;
        this.zzdtg = customViewCallback;
        this.zzdte = true;
    }

    private final void zzao(boolean z) throws zzi {
        if (!this.zzdto) {
            this.zzaax.requestWindowFeature(1);
        }
        Window window = this.zzaax.getWindow();
        if (window != null) {
            zza zza = null;
            zzbgu zzaef = this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaef() : null;
            boolean z2 = false;
            boolean z3 = zzaef != null && zzaef.zzadm();
            this.zzdtj = false;
            if (z3) {
                if (this.zzdtb.orientation == 6) {
                    if (this.zzaax.getResources().getConfiguration().orientation == 1) {
                        z2 = true;
                    }
                    this.zzdtj = z2;
                } else if (this.zzdtb.orientation == 7) {
                    if (this.zzaax.getResources().getConfiguration().orientation == 2) {
                        z2 = true;
                    }
                    this.zzdtj = z2;
                }
            }
            boolean z4 = this.zzdtj;
            StringBuilder sb = new StringBuilder(46);
            sb.append("Delay onShow to next orientation change: ");
            sb.append(z4);
            zzd.zzdz(sb.toString());
            setRequestedOrientation(this.zzdtb.orientation);
            window.setFlags(16777216, 16777216);
            zzd.zzdz("Hardware acceleration on the AdActivity window enabled.");
            if (!this.zzbpo) {
                this.zzdti.setBackgroundColor(-16777216);
            } else {
                this.zzdti.setBackgroundColor(zzdta);
            }
            this.zzaax.setContentView(this.zzdti);
            this.zzdto = true;
            if (z) {
                try {
                    zzr.zzkw();
                    zzbfi zza2 = zzbfq.zza(this.zzaax, this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaed() : null, this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaee() : null, true, z3, (zzei) null, (zzacv) null, this.zzdtb.zzbpx, (zzach) null, (zzm) null, this.zzdtb.zzdkm != null ? this.zzdtb.zzdkm.zzaby() : null, zztz.zznl(), (zzdot) null, (zzdoy) null);
                    this.zzdkm = zza2;
                    zzbgu zzaef2 = zza2.zzaef();
                    zzahn zzahn = this.zzdtb.zzdic;
                    zzahp zzahp = this.zzdtb.zzdie;
                    zzx zzx = this.zzdtb.zzduj;
                    if (this.zzdtb.zzdkm != null) {
                        zza = this.zzdtb.zzdkm.zzaef().zzadl();
                    }
                    zzaef2.zza((zzve) null, zzahn, (zzp) null, zzahp, zzx, true, (zzaii) null, zza, (zzari) null, (zzaxo) null, (zzcsh) null, (zzdup) null, (zzcmb) null, (zzdtw) null);
                    this.zzdkm.zzaef().zza((zzbgt) new zzd(this));
                    if (this.zzdtb.url != null) {
                        this.zzdkm.loadUrl(this.zzdtb.url);
                    } else if (this.zzdtb.zzdui != null) {
                        this.zzdkm.loadDataWithBaseURL(this.zzdtb.zzdug, this.zzdtb.zzdui, "text/html", "UTF-8", (String) null);
                    } else {
                        throw new zzi("No URL or HTML to display in ad overlay.");
                    }
                    if (this.zzdtb.zzdkm != null) {
                        this.zzdtb.zzdkm.zzb(this);
                    }
                } catch (Exception e) {
                    zzd.zzc("Error obtaining webview.", e);
                    throw new zzi("Could not obtain webview for the overlay.");
                }
            } else {
                zzbfi zzbfi = this.zzdtb.zzdkm;
                this.zzdkm = zzbfi;
                zzbfi.zzby(this.zzaax);
            }
            this.zzdkm.zza(this);
            if (this.zzdtb.zzdkm != null) {
                zzc(this.zzdtb.zzdkm.zzaej(), this.zzdti);
            }
            if (this.zzdtb.zzduk != 5) {
                ViewParent parent = this.zzdkm.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(this.zzdkm.getView());
                }
                if (this.zzbpo) {
                    this.zzdkm.zzaer();
                }
                this.zzdti.addView(this.zzdkm.getView(), -1, -1);
            }
            if (!z && !this.zzdtj) {
                zzwm();
            }
            if (this.zzdtb.zzduk != 5) {
                zzan(z3);
                if (this.zzdkm.zzaeh()) {
                    zza(z3, true);
                    return;
                }
                return;
            }
            zzcsr.zza(this.zzaax, this, this.zzdtb.zzduo, this.zzdtb.zzdun, this.zzdtb.zzdje, this.zzdtb.zzdjf, this.zzdtb.zzbwe, this.zzdtb.zzdup);
            return;
        }
        throw new zzi("Invalid activity, no window available.");
    }

    private final void zzwj() {
        if (this.zzaax.isFinishing() && !this.zzdtp) {
            this.zzdtp = true;
            if (this.zzdkm != null) {
                this.zzdkm.zzec(this.zzdtk.zzwq());
                synchronized (this.zzdtl) {
                    if (!this.zzdtn && this.zzdkm.zzaen()) {
                        this.zzdtm = new zzg(this);
                        zzj.zzegq.postDelayed(this.zzdtm, ((Long) zzww.zzra().zzd(zzabq.zzcqf)).longValue());
                        return;
                    }
                }
            }
            zzwk();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzwk() {
        if (!this.zzdtq) {
            this.zzdtq = true;
            zzbfi zzbfi = this.zzdkm;
            if (zzbfi != null) {
                this.zzdti.removeView(zzbfi.getView());
                zzk zzk = this.zzdtc;
                if (zzk != null) {
                    this.zzdkm.zzby(zzk.context);
                    this.zzdkm.zzbe(false);
                    this.zzdtc.parent.addView(this.zzdkm.getView(), this.zzdtc.index, this.zzdtc.zzdtv);
                    this.zzdtc = null;
                } else if (this.zzaax.getApplicationContext() != null) {
                    this.zzdkm.zzby(this.zzaax.getApplicationContext());
                }
                this.zzdkm = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdtb;
            if (!(adOverlayInfoParcel == null || adOverlayInfoParcel.zzduf == null)) {
                this.zzdtb.zzduf.zza(this.zzdtk);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdtb;
            if (adOverlayInfoParcel2 != null && adOverlayInfoParcel2.zzdkm != null) {
                zzc(this.zzdtb.zzdkm.zzaej(), this.zzdtb.zzdkm.getView());
            }
        }
    }

    private static void zzc(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper != null && view != null) {
            zzr.zzlk().zza(iObjectWrapper, view);
        }
    }

    public final void zzwl() {
        if (this.zzdtj) {
            this.zzdtj = false;
            zzwm();
        }
    }

    private final void zzwm() {
        this.zzdkm.zzwm();
    }

    public final void zzwn() {
        this.zzdti.zzdtt = true;
    }

    public final void zzwo() {
        synchronized (this.zzdtl) {
            this.zzdtn = true;
            if (this.zzdtm != null) {
                zzj.zzegq.removeCallbacks(this.zzdtm);
                zzj.zzegq.post(this.zzdtm);
            }
        }
    }

    private final void zza(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdtb;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzdum == null || !this.zzdtb.zzdum.zzbpp) ? false : true;
        boolean zza = zzr.zzkx().zza(this.zzaax, configuration);
        if ((this.zzbpo && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && (adOverlayInfoParcel = this.zzdtb) != null && adOverlayInfoParcel.zzdum != null && this.zzdtb.zzdum.zzbpu) {
            z2 = true;
        }
        Window window = this.zzaax.getWindow();
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcqi)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (Build.VERSION.SDK_INT >= 19 && z2) {
                window.getDecorView().setSystemUiVisibility(4098);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }
}
