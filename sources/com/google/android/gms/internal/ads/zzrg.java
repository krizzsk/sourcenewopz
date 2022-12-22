package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzrg implements zzri {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzyn;

    zzrg(zzra zzra, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzyn = bundle;
    }

    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzyn);
    }
}
