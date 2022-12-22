package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzbgm extends zzbfh {
    public zzbgm(zzbfi zzbfi, zztz zztz, boolean z) {
        super(zzbfi, zztz, z);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbfi)) {
            zzd.zzez("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbfi zzbfi = (zzbfi) webView;
        if (this.zzeti != null) {
            this.zzeti.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzbfi.zzaef() != null) {
            zzbfi.zzaef().zzwi();
        }
        if (zzbfi.zzaed().zzafj()) {
            str2 = (String) zzww.zzra().zzd(zzabq.zzcoc);
        } else if (zzbfi.zzaek()) {
            str2 = (String) zzww.zzra().zzd(zzabq.zzcob);
        } else {
            str2 = (String) zzww.zzra().zzd(zzabq.zzcoa);
        }
        zzr.zzkv();
        return zzj.zzd(zzbfi.getContext(), zzbfi.zzacc().zzbrz, str2);
    }
}
