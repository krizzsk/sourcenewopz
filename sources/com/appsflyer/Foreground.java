package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Foreground {
    public static long CHECK_DELAY = 500;
    public static Listener listener;

    public interface Listener {
        void onBecameBackground(Context context);

        void onBecameForeground(Activity activity);
    }

    /* renamed from: ɩ */
    static void m1604(Context context, final Listener listener2) {
        listener = listener2;
        C16634 r0 = new Application.ActivityLifecycleCallbacks() {

            /* renamed from: ɩ */
            boolean f1861 = true;

            /* renamed from: Ι */
            boolean f1862;

            /* renamed from: ι */
            private Executor f1863 = Executors.newSingleThreadExecutor();

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }

            public final void onActivityResumed(final Activity activity) {
                this.f1863.execute(new Runnable() {
                    public final void run() {
                        if (!C16634.this.f1862) {
                            try {
                                listener2.onBecameForeground(activity);
                            } catch (Exception e) {
                                AFLogger.afErrorLog("Listener thrown an exception: ", e);
                            }
                        }
                        C16634.this.f1861 = false;
                        C16634.this.f1862 = true;
                    }
                });
            }

            public final void onActivityPaused(final Activity activity) {
                this.f1863.execute(new Runnable() {
                    public final void run() {
                        C16634.this.f1861 = true;
                        final Context applicationContext = activity.getApplicationContext();
                        try {
                            new Timer().schedule(new TimerTask() {
                                public final void run() {
                                    if (C16634.this.f1862 && C16634.this.f1861) {
                                        C16634.this.f1862 = false;
                                        try {
                                            listener2.onBecameBackground(applicationContext);
                                        } catch (Exception e) {
                                            AFLogger.afErrorLog("Listener threw exception! ", e);
                                        }
                                    }
                                }
                            }, Foreground.CHECK_DELAY);
                        } catch (Throwable th) {
                            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
                        }
                    }
                });
            }

            public final void onActivityCreated(final Activity activity, Bundle bundle) {
                this.f1863.execute(new Runnable() {
                    public final void run() {
                        AFDeepLinkManager.getInstance().collectIntentsFromActivities(activity.getIntent());
                    }
                });
            }
        };
        if (context instanceof Activity) {
            r0.onActivityResumed((Activity) context);
        }
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(r0);
    }
}
