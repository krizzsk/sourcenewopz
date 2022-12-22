package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzbg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.taxis99.R;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbft extends FrameLayout implements zzbfi {
    /* access modifiers changed from: private */
    public final zzbfi zzeul;
    private final zzbch zzeum;
    private final AtomicBoolean zzeun = new AtomicBoolean();

    public zzbft(zzbfi zzbfi) {
        super(zzbfi.getContext());
        this.zzeul = zzbfi;
        this.zzeum = new zzbch(zzbfi.zzaea(), this, this);
        addView(this.zzeul.getView());
    }

    public final View getView() {
        return this;
    }

    public final zzbch zzabu() {
        return this.zzeum;
    }

    public final void onPause() {
        this.zzeum.onPause();
        this.zzeul.onPause();
    }

    public final void zzael() {
        this.zzeum.onDestroy();
        this.zzeul.zzael();
    }

    public final void zzaer() {
        setBackgroundColor(0);
        this.zzeul.setBackgroundColor(0);
    }

    public final int zzacd() {
        return getMeasuredHeight();
    }

    public final int zzace() {
        return getMeasuredWidth();
    }

    public final void zzacf() {
        this.zzeul.zzacf();
    }

    public final void zzdw(int i) {
        this.zzeul.zzdw(i);
    }

    public final void zzdx(int i) {
        this.zzeul.zzdx(i);
    }

    public final int zzacg() {
        return this.zzeul.zzacg();
    }

    public final int zzach() {
        return this.zzeul.zzach();
    }

    public final WebView getWebView() {
        return this.zzeul.getWebView();
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzeul.zza(str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzeul.zza(str, jSONObject);
    }

    public final void zza(String str, zzaig<? super zzbfi> zzaig) {
        this.zzeul.zza(str, zzaig);
    }

    public final void zzb(String str, zzaig<? super zzbfi> zzaig) {
        this.zzeul.zzb(str, zzaig);
    }

    public final void zza(String str, Predicate<zzaig<? super zzbfi>> predicate) {
        this.zzeul.zza(str, predicate);
    }

    public final void zzady() {
        this.zzeul.zzady();
    }

    public final void zzec(int i) {
        this.zzeul.zzec(i);
    }

    public final void zzwm() {
        this.zzeul.zzwm();
    }

    public final void zzadz() {
        this.zzeul.zzadz();
    }

    public final void zza(boolean z, long j) {
        this.zzeul.zza(z, j);
    }

    public final void zzcv(String str) {
        this.zzeul.zzcv(str);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.zzeul.zzb(str, jSONObject);
    }

    public final Activity zzabx() {
        return this.zzeul.zzabx();
    }

    public final Context zzaea() {
        return this.zzeul.zzaea();
    }

    public final zzb zzaby() {
        return this.zzeul.zzaby();
    }

    public final zze zzaeb() {
        return this.zzeul.zzaeb();
    }

    public final IObjectWrapper zzaej() {
        return this.zzeul.zzaej();
    }

    public final zze zzaec() {
        return this.zzeul.zzaec();
    }

    public final zzbgx zzaed() {
        return this.zzeul.zzaed();
    }

    public final String zzaee() {
        return this.zzeul.zzaee();
    }

    public final zzbgu zzaef() {
        return this.zzeul.zzaef();
    }

    public final WebViewClient zzaeg() {
        return this.zzeul.zzaeg();
    }

    public final boolean zzaeh() {
        return this.zzeul.zzaeh();
    }

    public final zzei zzaei() {
        return this.zzeul.zzaei();
    }

    public final zzbar zzacc() {
        return this.zzeul.zzacc();
    }

    public final boolean zzaek() {
        return this.zzeul.zzaek();
    }

    public final boolean isDestroyed() {
        return this.zzeul.isDestroyed();
    }

    public final boolean zzaem() {
        return this.zzeul.zzaem();
    }

    public final void zzks() {
        this.zzeul.zzks();
    }

    public final void zzkr() {
        this.zzeul.zzkr();
    }

    public final String getRequestId() {
        return this.zzeul.getRequestId();
    }

    public final String zzabz() {
        return this.zzeul.zzabz();
    }

    public final void zzdv(int i) {
        this.zzeul.zzdv(i);
    }

    public final int zzaca() {
        return this.zzeul.zzaca();
    }

    public final zzacf zzabw() {
        return this.zzeul.zzabw();
    }

    public final zzace zzacb() {
        return this.zzeul.zzacb();
    }

    public final zzbgc zzabv() {
        return this.zzeul.zzabv();
    }

    public final void zza(zze zze) {
        this.zzeul.zza(zze);
    }

    public final void zzar(IObjectWrapper iObjectWrapper) {
        this.zzeul.zzar(iObjectWrapper);
    }

    public final void zza(zzbgx zzbgx) {
        this.zzeul.zza(zzbgx);
    }

    public final void zzbe(boolean z) {
        this.zzeul.zzbe(z);
    }

    public final void zzaeo() {
        this.zzeul.zzaeo();
    }

    public final void zzby(Context context) {
        this.zzeul.zzby(context);
    }

    public final void zzap(boolean z) {
        this.zzeul.zzap(z);
    }

    public final void zzac(boolean z) {
        this.zzeul.zzac(z);
    }

    public final void setRequestedOrientation(int i) {
        this.zzeul.setRequestedOrientation(i);
    }

    public final void zzb(zze zze) {
        this.zzeul.zzb(zze);
    }

    public final void zzbf(boolean z) {
        this.zzeul.zzbf(z);
    }

    public final void zza(String str, zzbek zzbek) {
        this.zzeul.zza(str, zzbek);
    }

    public final zzbek zzfe(String str) {
        return this.zzeul.zzfe(str);
    }

    public final void zzaep() {
        this.zzeul.zzaep();
    }

    public final void destroy() {
        IObjectWrapper zzaej = zzaej();
        if (zzaej != null) {
            zzj.zzegq.post(new zzbfw(zzaej));
            zzj.zzegq.postDelayed(new zzbfv(this), (long) ((Integer) zzww.zzra().zzd(zzabq.zzcwi)).intValue());
            return;
        }
        this.zzeul.destroy();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zzeul.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzeul.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.zzeul.loadUrl(str);
    }

    public final void zzb(String str, String str2, String str3) {
        this.zzeul.zzb(str, str2, str3);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeul.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzeul.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzeul.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzeul.setWebViewClient(webViewClient);
    }

    public final void onResume() {
        this.zzeul.onResume();
    }

    public final void zzaes() {
        TextView textView = new TextView(getContext());
        Resources resources = zzr.zzkz().getResources();
        textView.setText(resources != null ? resources.getString(R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzbb(boolean z) {
        this.zzeul.zzbb(z);
    }

    public final void zza(zzaef zzaef) {
        this.zzeul.zza(zzaef);
    }

    public final void zza(zzsi zzsi) {
        this.zzeul.zza(zzsi);
    }

    public final zzsi zzaet() {
        return this.zzeul.zzaet();
    }

    public final void zza(zzqx zzqx) {
        this.zzeul.zza(zzqx);
    }

    public final void zza(zzaeg zzaeg) {
        this.zzeul.zza(zzaeg);
    }

    public final zzaeg zzaeq() {
        return this.zzeul.zzaeq();
    }

    public final void zza(zzbgc zzbgc) {
        this.zzeul.zza(zzbgc);
    }

    public final boolean zzaen() {
        return this.zzeul.zzaen();
    }

    public final void zzbg(boolean z) {
        this.zzeul.zzbg(z);
    }

    public final void zzaz(boolean z) {
        this.zzeul.zzaz(z);
    }

    public final void zzwn() {
        this.zzeul.zzwn();
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzb) {
        this.zzeul.zza(zzb);
    }

    public final void zzb(boolean z, int i) {
        this.zzeul.zzb(z, i);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzeul.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzeul.zza(z, i, str, str2);
    }

    public final void zza(zzbg zzbg, zzcsh zzcsh, zzcmb zzcmb, zzdtw zzdtw, String str, String str2, int i) {
        this.zzeul.zza(zzbg, zzcsh, zzcmb, zzdtw, str, str2, i);
    }

    public final boolean zzc(boolean z, int i) {
        if (!this.zzeun.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcpq)).booleanValue()) {
            return false;
        }
        if (this.zzeul.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zzeul.getParent()).removeView(this.zzeul.getView());
        }
        return this.zzeul.zzc(z, i);
    }

    public final boolean zzaeu() {
        return this.zzeun.get();
    }

    public final zzdot zzadk() {
        return this.zzeul.zzadk();
    }

    public final zzdoy zzaev() {
        return this.zzeul.zzaev();
    }

    public final void onAdClicked() {
        zzbfi zzbfi = this.zzeul;
        if (zzbfi != null) {
            zzbfi.onAdClicked();
        }
    }

    public final void zza(zzdot zzdot, zzdoy zzdoy) {
        this.zzeul.zza(zzdot, zzdoy);
    }
}
