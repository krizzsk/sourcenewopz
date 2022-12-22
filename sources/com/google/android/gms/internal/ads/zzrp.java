package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
final class zzrp implements Application.ActivityLifecycleCallbacks {
    private Context context;
    /* access modifiers changed from: private */
    public boolean foreground = true;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private Activity zzaax;
    /* access modifiers changed from: private */
    public boolean zzbtm = false;
    /* access modifiers changed from: private */
    public final List<zzrr> zzbtn = new ArrayList();
    private final List<zzsc> zzbto = new ArrayList();
    private Runnable zzbtp;
    private long zzbtq;
    private boolean zzzq = false;

    zzrp() {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context2) {
        if (!this.zzzq) {
            application.registerActivityLifecycleCallbacks(this);
            if (context2 instanceof Activity) {
                setActivity((Activity) context2);
            }
            this.context = application;
            this.zzbtq = ((Long) zzww.zzra().zzd(zzabq.zzcqa)).longValue();
            this.zzzq = true;
        }
    }

    public final void zza(zzrr zzrr) {
        synchronized (this.lock) {
            this.zzbtn.add(zzrr);
        }
    }

    public final void zzb(zzrr zzrr) {
        synchronized (this.lock) {
            this.zzbtn.remove(zzrr);
        }
    }

    public final Activity getActivity() {
        return this.zzaax;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbtm = false;
        boolean z = !this.foreground;
        this.foreground = true;
        if (this.zzbtp != null) {
            zzj.zzegq.removeCallbacks(this.zzbtp);
        }
        synchronized (this.lock) {
            for (zzsc onActivityResumed : this.zzbto) {
                try {
                    onActivityResumed.onActivityResumed(activity);
                } catch (Exception e) {
                    zzr.zzkz().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbao.zzc("", e);
                }
            }
            if (z) {
                for (zzrr zzq : this.zzbtn) {
                    try {
                        zzq.zzq(true);
                    } catch (Exception e2) {
                        zzbao.zzc("", e2);
                    }
                }
            } else {
                zzd.zzdz("App is still foreground.");
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzsc onActivityPaused : this.zzbto) {
                try {
                    onActivityPaused.onActivityPaused(activity);
                } catch (Exception e) {
                    zzr.zzkz().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbao.zzc("", e);
                }
            }
        }
        this.zzbtm = true;
        if (this.zzbtp != null) {
            zzj.zzegq.removeCallbacks(this.zzbtp);
        }
        zzdxi zzdxi = zzj.zzegq;
        zzro zzro = new zzro(this);
        this.zzbtp = zzro;
        zzdxi.postDelayed(zzro, this.zzbtq);
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzaax != null) {
                if (this.zzaax.equals(activity)) {
                    this.zzaax = null;
                }
                Iterator<zzsc> it = this.zzbto.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().zza(activity)) {
                            it.remove();
                        }
                    } catch (Exception e) {
                        zzr.zzkz().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbao.zzc("", e);
                    }
                }
            }
        }
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith(MobileAds.ERROR_DOMAIN)) {
                this.zzaax = activity;
            }
        }
    }
}
