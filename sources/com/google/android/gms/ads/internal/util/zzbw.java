package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.didi.sdk.apm.SystemUtils;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzbw implements Callable<String> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Context zzejd;

    zzbw(zzbu zzbu, Context context, Context context2) {
        this.zzejd = context;
        this.val$context = context2;
    }

    public final /* synthetic */ Object call() throws Exception {
        SharedPreferences sharedPreferences;
        boolean z = false;
        if (this.zzejd != null) {
            zzd.zzed("Attempting to read user agent from Google Play Services.");
            sharedPreferences = SystemUtils.getSharedPreferences(this.zzejd, "admob_user_agent", 0);
        } else {
            zzd.zzed("Attempting to read user agent from local cache.");
            sharedPreferences = SystemUtils.getSharedPreferences(this.val$context, "admob_user_agent", 0);
            z = true;
        }
        String string = sharedPreferences.getString("user_agent", "");
        if (TextUtils.isEmpty(string)) {
            zzd.zzed("Reading user agent from WebSettings");
            string = WebSettings.getDefaultUserAgent(this.val$context);
            if (z) {
                sharedPreferences.edit().putString("user_agent", string).apply();
                zzd.zzed("Persisting user agent.");
            }
        }
        return string;
    }
}
