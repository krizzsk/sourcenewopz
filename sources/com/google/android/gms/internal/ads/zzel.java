package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzel implements Application.ActivityLifecycleCallbacks {
    private final Application zzyi;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzyj;
    private boolean zzyk = false;

    public zzel(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzyj = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyi = application;
    }

    private final void zza(zzet zzet) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzyj.get();
            if (activityLifecycleCallbacks != null) {
                zzet.zza(activityLifecycleCallbacks);
            } else if (!this.zzyk) {
                this.zzyi.unregisterActivityLifecycleCallbacks(this);
                this.zzyk = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzeo(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzen(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzeq(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzep(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzes(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzer(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzeu(this, activity));
    }
}
