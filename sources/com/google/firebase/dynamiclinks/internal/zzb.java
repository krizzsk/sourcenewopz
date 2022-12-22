package com.google.firebase.dynamiclinks.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.0.0 */
final class zzb extends Api.AbstractClientBuilder<zzd, Api.ApiOptions.NoOptions> {
    zzb() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzd(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }
}
