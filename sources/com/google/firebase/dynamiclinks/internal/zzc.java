package com.google.firebase.dynamiclinks.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
public final class zzc extends GoogleApi<Api.ApiOptions.NoOptions> {
    private static final Api<Api.ApiOptions.NoOptions> API;
    private static final Api.ClientKey<zzd> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzd, Api.ApiOptions.NoOptions> zzp;

    public zzc(Context context) {
        super(context, API, null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    static {
        zzb zzb = new zzb();
        zzp = zzb;
        API = new Api<>("DynamicLinks.API", zzb, CLIENT_KEY);
    }
}
