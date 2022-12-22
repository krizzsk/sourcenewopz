package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.didi.sdk.apm.SystemUtils;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzbf extends WebViewClient {
    private final /* synthetic */ zzbe zza;

    private zzbf(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final void onLoadResource(WebView webView, String str) {
        if (zzbe.zza(str)) {
            this.zza.zzb.zza(str);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String uri = webResourceRequest.getUrl().toString();
        if (!zzbe.zza(uri)) {
            return false;
        }
        this.zza.zzb.zza(uri);
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!zzbe.zza(str)) {
            return false;
        }
        this.zza.zzb.zza(str);
        return true;
    }

    public final void onPageFinished(WebView webView, String str) {
        if (!this.zza.zzc) {
            zzbj unused = this.zza.zzb;
            SystemUtils.log(3, "UserMessagingPlatform", "Wall html loaded.", (Throwable) null, "com.google.android.gms.internal.consent_sdk.zzbf", 17);
            boolean unused2 = this.zza.zzc = true;
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zza.zzb.zza(i, str, str2);
    }
}
