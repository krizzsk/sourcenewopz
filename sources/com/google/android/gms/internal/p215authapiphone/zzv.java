package com.google.android.gms.internal.p215authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsCodeBrowserClient;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzv */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.5.1 */
public final class zzv extends GoogleApi<Api.ApiOptions.NoOptions> implements SmsCodeBrowserClient {
    private static final Api.ClientKey<zzw> zza = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzw, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;

    static {
        zzt zzt = new zzt();
        zzb = zzt;
        zzc = new Api<>("SmsCodeBrowser.API", zzt, zza);
    }

    public zzv(Activity activity) {
        super(activity, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<Void> startSmsCodeRetriever() {
        return doWrite(TaskApiCall.builder().setFeatures(zzac.zzb).run(new zzs(this)).setMethodKey(1566).build());
    }

    public zzv(Context context) {
        super(context, zzc, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
