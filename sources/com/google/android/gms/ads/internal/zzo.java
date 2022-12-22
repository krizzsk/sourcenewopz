package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.zzd;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzo extends WebViewClient {
    private final /* synthetic */ zzl zzbqf;

    zzo(zzl zzl) {
        this.zzbqf = zzl;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.zzbqf.zzkq())) {
            return false;
        }
        if (str.startsWith("gmsg://noAdLoaded")) {
            if (this.zzbqf.zzbqc != null) {
                try {
                    this.zzbqf.zzbqc.onAdFailedToLoad(3);
                } catch (RemoteException e) {
                    zzd.zze("#007 Could not call remote method.", e);
                }
            }
            this.zzbqf.zzbt(0);
            return true;
        } else if (str.startsWith("gmsg://scriptLoadFailed")) {
            if (this.zzbqf.zzbqc != null) {
                try {
                    this.zzbqf.zzbqc.onAdFailedToLoad(0);
                } catch (RemoteException e2) {
                    zzd.zze("#007 Could not call remote method.", e2);
                }
            }
            this.zzbqf.zzbt(0);
            return true;
        } else if (str.startsWith("gmsg://adResized")) {
            if (this.zzbqf.zzbqc != null) {
                try {
                    this.zzbqf.zzbqc.onAdLoaded();
                } catch (RemoteException e3) {
                    zzd.zze("#007 Could not call remote method.", e3);
                }
            }
            this.zzbqf.zzbt(this.zzbqf.zzbm(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.zzbqf.zzbqc != null) {
                try {
                    this.zzbqf.zzbqc.onAdLeftApplication();
                } catch (RemoteException e4) {
                    zzd.zze("#007 Could not call remote method.", e4);
                }
            }
            this.zzbqf.zzbo(this.zzbqf.zzbn(str));
            return true;
        }
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.zzbqf.zzbqc != null) {
            try {
                this.zzbqf.zzbqc.onAdFailedToLoad(0);
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
