package com.didi.soda.web.tools;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.didi.sdk.apm.SystemUtils;

public class ScreenOrientationMonitor {

    /* renamed from: a */
    private static final int f43927a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f43928b;

    /* renamed from: c */
    private RotationObserver f43929c;

    /* renamed from: d */
    private boolean f43930d = false;

    public ScreenOrientationMonitor(Activity activity) {
        this.f43928b = activity;
        this.f43929c = new RotationObserver(new Handler());
    }

    public void setH5ScreenOrientationSetting(boolean z) {
        this.f43930d = z;
        updateActivityOrientation(false);
    }

    public void onCreate() {
        this.f43929c.startObserver();
    }

    public void onDestroy() {
        this.f43929c.stopObserver();
    }

    private class RotationObserver extends ContentObserver {
        ContentResolver mResolver;

        public RotationObserver(Handler handler) {
            super(handler);
            this.mResolver = ScreenOrientationMonitor.this.f43928b.getContentResolver();
        }

        public void onChange(boolean z) {
            super.onChange(z);
            ScreenOrientationMonitor.this.updateActivityOrientation(false);
        }

        public void startObserver() {
            this.mResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
        }

        public void stopObserver() {
            this.mResolver.unregisterContentObserver(this);
        }
    }

    public void updateActivityOrientation(boolean z) {
        if (z) {
            SystemUtils.hookSetRequestedOrientation(this.f43928b, 1);
        } else if (!this.f43930d || m31264a((Context) this.f43928b) == 0) {
            SystemUtils.hookSetRequestedOrientation(this.f43928b, 1);
        } else {
            SystemUtils.hookSetRequestedOrientation(this.f43928b, 10);
        }
    }

    /* renamed from: a */
    private int m31264a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
