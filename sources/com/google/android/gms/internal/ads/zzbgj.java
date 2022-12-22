package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbgj extends zzbgm {
    public zzbgj(zzbfi zzbfi, zztz zztz, boolean z) {
        super(zzbfi, zztz, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
