package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzrs implements Runnable {
    private ValueCallback<String> zzbud = new zzrv(this);
    final /* synthetic */ zzrk zzbue;
    final /* synthetic */ WebView zzbuf;
    final /* synthetic */ boolean zzbug;
    final /* synthetic */ zzrq zzbuh;

    zzrs(zzrq zzrq, zzrk zzrk, WebView webView, boolean z) {
        this.zzbuh = zzrq;
        this.zzbue = zzrk;
        this.zzbuf = webView;
        this.zzbug = z;
    }

    public final void run() {
        if (this.zzbuf.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbuf.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbud);
            } catch (Throwable unused) {
                this.zzbud.onReceiveValue("");
            }
        }
    }
}
