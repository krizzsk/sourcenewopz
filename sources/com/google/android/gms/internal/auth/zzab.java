package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.zzd;
import com.google.android.gms.auth.zze;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzab extends GoogleApi<Api.ApiOptions.NoOptions> implements zzg {
    private static final Api.ClientKey<zzi> zza = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzi, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;
    private static final Logger zzd = zzd.zza("GoogleAuthServiceClient");

    static {
        zzv zzv = new zzv();
        zzb = zzv;
        zzc = new Api<>("GoogleAuthService.API", zzv, zza);
    }

    zzab(Context context) {
        super(context, zzc, Api.ApiOptions.NoOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    static /* synthetic */ void zzf(Status status, Object obj, TaskCompletionSource taskCompletionSource) {
        if (!TaskUtil.trySetResultOrApiException(status, obj, taskCompletionSource)) {
            zzd.mo136184w("The task is already complete.", new Object[0]);
        }
    }

    public final Task<Void> zza(zzbw zzbw) {
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzf).run(new zzt(this, zzbw)).setMethodKey(1513).build());
    }

    public final Task<AccountChangeEventsResponse> zzb(AccountChangeEventsRequest accountChangeEventsRequest) {
        Preconditions.checkNotNull(accountChangeEventsRequest, "request cannot be null.");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzg).run(new zzs(this, accountChangeEventsRequest)).setMethodKey(1515).build());
    }

    public final Task<Bundle> zzc(Account account, String str, Bundle bundle) {
        Preconditions.checkNotNull(account, "Account name cannot be null!");
        Preconditions.checkNotEmpty(str, "Scope cannot be null!");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzf).run(new zzr(this, account, str, bundle)).setMethodKey(1512).build());
    }

    public final Task<Bundle> zzd(Account account) {
        Preconditions.checkNotNull(account, "account cannot be null.");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzg).run(new zzq(this, account)).setMethodKey(1517).build());
    }

    public final Task<Bundle> zze(String str) {
        Preconditions.checkNotNull(str, "Client package name cannot be null!");
        return doWrite(TaskApiCall.builder().setFeatures(zze.zzg).run(new zzu(this, str)).setMethodKey(1514).build());
    }
}
