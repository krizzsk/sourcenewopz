package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zztz;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzx extends zzy {
    public final int zzzy() {
        return 16974374;
    }

    public final CookieManager zzbi(Context context) {
        if (zzzx()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzd.zzc("Failed to obtain CookieManager.", th);
            zzr.zzkz().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final zzbfh zza(zzbfi zzbfi, zztz zztz, boolean z) {
        return new zzbgl(zzbfi, zztz, z);
    }

    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
