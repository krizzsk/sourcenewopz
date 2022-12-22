package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
final class zzay implements Application.ActivityLifecycleCallbacks {
    private final Activity zza;
    private final /* synthetic */ zzat zzb;

    public zzay(zzat zzat, Activity activity) {
        this.zzb = zzat;
        this.zza = activity;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.zza) {
            this.zzb.zzb(new zzk(3, "Activity is destroyed."));
        }
    }

    /* access modifiers changed from: private */
    public final void zza() {
        this.zzb.zza.unregisterActivityLifecycleCallbacks(this);
    }
}
