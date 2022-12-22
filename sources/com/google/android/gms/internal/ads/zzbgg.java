package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbgp;
import com.google.android.gms.internal.ads.zzbgr;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzbgg<WebViewT extends zzbgk & zzbgp & zzbgr> {
    private final zzbgh zzewo;
    private final WebViewT zzewp;

    public zzbgg(WebViewT webviewt, zzbgh zzbgh) {
        this.zzewo = zzbgh;
        this.zzewp = webviewt;
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzd.zzez("URL is empty, ignoring message");
        } else {
            zzj.zzegq.post(new zzbgi(this, str));
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzd.zzed("Click string is empty, not proceeding.");
            return "";
        }
        zzei zzaei = ((zzbgp) this.zzewp).zzaei();
        if (zzaei == null) {
            zzd.zzed("Signal utils is empty, ignoring.");
            return "";
        }
        zzdy zzcb = zzaei.zzcb();
        if (zzcb == null) {
            zzd.zzed("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzewp.getContext() != null) {
            return zzcb.zza(this.zzewp.getContext(), str, ((zzbgr) this.zzewp).getView(), this.zzewp.zzabx());
        } else {
            zzd.zzed("Context is null, ignoring.");
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzfo(String str) {
        this.zzewo.zzj(Uri.parse(str));
    }
}
