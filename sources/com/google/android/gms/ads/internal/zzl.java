package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaaz;
import com.google.android.gms.internal.ads.zzacm;
import com.google.android.gms.internal.ads.zzadc;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzasx;
import com.google.android.gms.internal.ads.zzavn;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbat;
import com.google.android.gms.internal.ads.zzeh;
import com.google.android.gms.internal.ads.zzei;
import com.google.android.gms.internal.ads.zzsq;
import com.google.android.gms.internal.ads.zzvq;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzwx;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxd;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxt;
import com.google.android.gms.internal.ads.zzxy;
import com.google.android.gms.internal.ads.zzye;
import com.google.android.gms.internal.ads.zzyg;
import com.google.android.gms.internal.ads.zzyx;
import com.google.android.gms.internal.ads.zzzc;
import com.google.android.gms.internal.ads.zzzd;
import com.google.android.gms.internal.ads.zzzj;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;
import rui.config.RConfigConstants;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzl extends zzxp {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final zzbar zzbpx;
    private final zzvt zzbpy;
    /* access modifiers changed from: private */
    public final Future<zzei> zzbpz = zzbat.zzeke.zze(new zzq(this));
    private final zzs zzbqa;
    /* access modifiers changed from: private */
    public WebView zzbqb = new WebView(this.context);
    /* access modifiers changed from: private */
    public zzxc zzbqc;
    /* access modifiers changed from: private */
    public zzei zzbqd;
    private AsyncTask<Void, Void, String> zzbqe;

    public zzl(Context context2, zzvt zzvt, String str, zzbar zzbar) {
        this.context = context2;
        this.zzbpx = zzbar;
        this.zzbpy = zzvt;
        this.zzbqa = new zzs(context2, str);
        zzbt(0);
        this.zzbqb.setVerticalScrollBarEnabled(false);
        this.zzbqb.getSettings().setJavaScriptEnabled(true);
        this.zzbqb.setWebViewClient(new zzo(this));
        this.zzbqb.setOnTouchListener(new zzn(this));
    }

    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    public final zzzd getVideoController() {
        return null;
    }

    public final boolean isLoading() throws RemoteException {
        return false;
    }

    public final boolean isReady() throws RemoteException {
        return false;
    }

    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    public final void stopLoading() throws RemoteException {
    }

    public final void zza(zzvq zzvq, zzxd zzxd) {
    }

    public final void zza(zzyg zzyg) {
    }

    public final void zza(zzyx zzyx) {
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
    }

    public final String zzkl() throws RemoteException {
        return null;
    }

    public final zzzc zzkm() {
        return null;
    }

    public final IObjectWrapper zzki() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbqb);
    }

    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbqe.cancel(true);
        this.zzbpz.cancel(true);
        this.zzbqb.destroy();
        this.zzbqb = null;
    }

    public final boolean zza(zzvq zzvq) throws RemoteException {
        Preconditions.checkNotNull(this.zzbqb, "This Search Ad has already been torn down");
        this.zzbqa.zza(zzvq, this.zzbpx);
        this.zzbqe = new zzp(this, (zzo) null).execute(new Void[0]);
        return true;
    }

    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zza(zzxc zzxc) throws RemoteException {
        this.zzbqc = zzxc;
    }

    public final void zza(zzxy zzxy) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzxt zzxt) {
        throw new IllegalStateException("Unused method");
    }

    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzkj() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final zzvt zzkk() throws RemoteException {
        return this.zzbpy;
    }

    public final void zza(zzvt zzvt) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zza(zzasr zzasr) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzasx zzasx, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final zzxy zzkn() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzxc zzko() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final void zza(zzacm zzacm) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzwx zzwx) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzye zzye) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzavn zzavn) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzbl(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzaaz zzaaz) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzzj zzzj) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzwc zzwc) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzsq zzsq) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    public final int zzbm(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzww.zzqw();
            return zzbae.zze(this.context, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbt(int i) {
        if (this.zzbqb != null) {
            this.zzbqb.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzkp() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzadc.zzddu.get());
        builder.appendQueryParameter("query", this.zzbqa.getQuery());
        builder.appendQueryParameter("pubId", this.zzbqa.zzlv());
        Map<String, String> zzlw = this.zzbqa.zzlw();
        for (String next : zzlw.keySet()) {
            builder.appendQueryParameter(next, zzlw.get(next));
        }
        Uri build = builder.build();
        zzei zzei = this.zzbqd;
        if (zzei != null) {
            try {
                build = zzei.zza(build, this.context);
            } catch (zzeh e) {
                zzd.zzd("Unable to process ad data", e);
            }
        }
        String zzkq = zzkq();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzkq).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzkq);
        sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zzkq() {
        String zzlu = this.zzbqa.zzlu();
        if (TextUtils.isEmpty(zzlu)) {
            zzlu = "www.google.com";
        }
        String str = zzadc.zzddu.get();
        StringBuilder sb = new StringBuilder(String.valueOf(zzlu).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzlu);
        sb.append(str);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public final String zzbn(String str) {
        if (this.zzbqd == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzbqd.zza(parse, this.context, (View) null, (Activity) null);
        } catch (zzeh e) {
            zzd.zzd("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzbo(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.context.startActivity(intent);
    }
}
