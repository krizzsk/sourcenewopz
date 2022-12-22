package com.google.android.gms.internal.consent_sdk;

import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
public class zzch {
    private static Boolean zza;

    private zzch() {
    }

    private static boolean zza(WebView webView) {
        boolean booleanValue;
        synchronized (zzch.class) {
            if (zza == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", (ValueCallback) null);
                    zza = true;
                } catch (IllegalStateException unused) {
                    zza = false;
                }
            }
            booleanValue = zza.booleanValue();
        }
        return booleanValue;
    }

    public static void zza(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 19 || !zza(webView)) {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        webView.evaluateJavascript(str, (ValueCallback) null);
    }
}
