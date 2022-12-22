package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zztz;
import com.google.android.gms.internal.ads.zzur;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzr {
    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean zza(Activity activity, Configuration configuration) {
        return false;
    }

    public void zzbh(Context context) {
    }

    public void zzi(Activity activity) {
    }

    public int zzzv() {
        return 5;
    }

    public int zzzy() {
        return 1;
    }

    public long zzzz() {
        return -1;
    }

    public boolean zza(Context context, WebSettings webSettings) {
        zzbr.zza(context, new zzu(context, webSettings));
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        return true;
    }

    public zzbfh zza(zzbfi zzbfi, zztz zztz, boolean z) {
        return new zzbgj(zzbfi, zztz, z);
    }

    public ViewGroup.LayoutParams zzzw() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static boolean zzzx() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public CookieManager zzbi(Context context) {
        if (zzzx()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzd.zzc("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzur zza(Context context, TelephonyManager telephonyManager) {
        return zzur.ENUM_UNKNOWN;
    }

    public int zza(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public int zzb(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    private zzr() {
    }

    public static zzr zzdm(int i) {
        if (i >= 28) {
            return new zzac();
        }
        if (i >= 26) {
            return new zzz();
        }
        if (i >= 24) {
            return new zzaa();
        }
        if (i >= 21) {
            return new zzx();
        }
        if (i >= 19) {
            return new zzy();
        }
        if (i >= 18) {
            return new zzv();
        }
        if (i >= 17) {
            return new zzw();
        }
        return new zzr();
    }
}
