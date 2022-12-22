package com.didi.rfusion.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.rfusion.config.RFLogger;
import com.didi.rfusion.config.RFTheme;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import xcrash.TombstoneParser;

public class RFActivityManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f33300a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f33301b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f33302c;

    /* renamed from: d */
    private Application.ActivityLifecycleCallbacks f33303d;

    /* renamed from: a */
    static /* synthetic */ int m23416a(RFActivityManager rFActivityManager) {
        int i = rFActivityManager.f33301b;
        rFActivityManager.f33301b = i + 1;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m23420c(RFActivityManager rFActivityManager) {
        int i = rFActivityManager.f33301b;
        rFActivityManager.f33301b = i - 1;
        return i;
    }

    private RFActivityManager() {
        this.f33303d = new Application.ActivityLifecycleCallbacks() {
            public void onActivityPaused(Activity activity) {
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public void onActivityCreated(Activity activity, Bundle bundle) {
                Activity unused = RFActivityManager.this.f33300a = activity;
                RFTheme.getThemeManager().setDefaultTheme(activity);
            }

            public void onActivityStarted(Activity activity) {
                Activity unused = RFActivityManager.this.f33300a = activity;
                RFActivityManager.m23416a(RFActivityManager.this);
                if (RFActivityManager.this.f33301b == 1) {
                    boolean unused2 = RFActivityManager.this.f33302c = true;
                    RFLogger.getLogger().debug(TombstoneParser.keyForeground);
                }
            }

            public void onActivityResumed(Activity activity) {
                Activity unused = RFActivityManager.this.f33300a = activity;
            }

            public void onActivityStopped(Activity activity) {
                RFActivityManager.m23420c(RFActivityManager.this);
                if (RFActivityManager.this.f33301b == 0) {
                    boolean unused = RFActivityManager.this.f33302c = false;
                    RFLogger.getLogger().debug(Constants.BACKGROUND);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                if (RFActivityManager.this.f33300a == activity) {
                    Activity unused = RFActivityManager.this.f33300a = null;
                }
            }
        };
    }

    private static final class InnerHolder {
        /* access modifiers changed from: private */
        public static final RFActivityManager INSTANCE = new RFActivityManager();

        private InnerHolder() {
        }
    }

    public static RFActivityManager getInstance() {
        return InnerHolder.INSTANCE;
    }

    public void init(Application application) {
        application.unregisterActivityLifecycleCallbacks(this.f33303d);
        application.registerActivityLifecycleCallbacks(this.f33303d);
    }

    public boolean isApplicationForeground() {
        return this.f33302c;
    }

    public Activity getTopActivity() {
        return this.f33300a;
    }
}
