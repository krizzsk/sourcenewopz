package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzra implements Application.ActivityLifecycleCallbacks {
    private final Application zzyi;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzyj;
    private boolean zzyk = false;

    public zzra(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzyj = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyi = application;
    }

    private final void zza(zzri zzri) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzyj.get();
            if (activityLifecycleCallbacks != null) {
                zzri.zza(activityLifecycleCallbacks);
            } else if (!this.zzyk) {
                this.zzyi.unregisterActivityLifecycleCallbacks(this);
                this.zzyk = true;
            }
        } catch (Exception e) {
            zzd.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzrd(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzrc(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzrf(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzre(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzrh(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzrg(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzrj(this, activity));
    }
}
