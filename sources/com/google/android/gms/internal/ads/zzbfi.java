package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public interface zzbfi extends zzm, zzakr, zzalf, zzbcs, zzbex, zzbgd, zzbgk, zzbgo, zzbgp, zzbgr, zzbgs, zzqw, zzve {
    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(zze zze);

    void zza(zzaef zzaef);

    void zza(zzaeg zzaeg);

    void zza(zzbgc zzbgc);

    void zza(zzbgx zzbgx);

    void zza(zzdot zzdot, zzdoy zzdoy);

    void zza(zzsi zzsi);

    void zza(String str, Predicate<zzaig<? super zzbfi>> predicate);

    void zza(String str, zzaig<? super zzbfi> zzaig);

    void zza(String str, zzbek zzbek);

    zzbgc zzabv();

    Activity zzabx();

    zzb zzaby();

    void zzac(boolean z);

    zzace zzacb();

    zzbar zzacc();

    zzdot zzadk();

    void zzady();

    void zzadz();

    Context zzaea();

    zze zzaeb();

    zze zzaec();

    zzbgx zzaed();

    String zzaee();

    zzbgu zzaef();

    WebViewClient zzaeg();

    boolean zzaeh();

    zzei zzaei();

    IObjectWrapper zzaej();

    boolean zzaek();

    void zzael();

    boolean zzaem();

    boolean zzaen();

    void zzaeo();

    void zzaep();

    zzaeg zzaeq();

    void zzaer();

    void zzaes();

    zzsi zzaet();

    boolean zzaeu();

    zzdoy zzaev();

    void zzap(boolean z);

    void zzar(IObjectWrapper iObjectWrapper);

    void zzb(zze zze);

    void zzb(String str, zzaig<? super zzbfi> zzaig);

    void zzb(String str, String str2, String str3);

    void zzbb(boolean z);

    void zzbe(boolean z);

    void zzbf(boolean z);

    void zzbg(boolean z);

    void zzby(Context context);

    boolean zzc(boolean z, int i);

    void zzec(int i);

    void zzwm();
}
