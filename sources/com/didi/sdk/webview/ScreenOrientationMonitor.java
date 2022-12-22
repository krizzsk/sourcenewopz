package com.didi.sdk.webview;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.Method;

public class ScreenOrientationMonitor {

    /* renamed from: a */
    private static final int f38392a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public BaseWebActivity f38393b;

    /* renamed from: c */
    private RotationObserver f38394c;

    /* renamed from: d */
    private boolean f38395d = false;

    public ScreenOrientationMonitor(BaseWebActivity baseWebActivity) {
        this.f38393b = baseWebActivity;
        this.f38394c = new RotationObserver(new Handler());
    }

    public void setH5ScreenOrientationSetting(boolean z) {
        this.f38395d = z;
        updateActivityOrientation(false);
    }

    public void onCreate() {
        this.f38394c.startObserver();
    }

    public void onDestroy() {
        this.f38394c.stopObserver();
    }

    private class RotationObserver extends ContentObserver {
        ContentResolver mResolver;

        public RotationObserver(Handler handler) {
            super(handler);
            this.mResolver = ScreenOrientationMonitor.this.f38393b.getContentResolver();
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
        if (Build.VERSION.SDK_INT == 26 && m27165a((Activity) this.f38393b)) {
            return;
        }
        if (z) {
            SystemUtils.hookSetRequestedOrientation(this.f38393b, 1);
        } else if (!this.f38395d || m27163a((Context) this.f38393b) == 0) {
            SystemUtils.hookSetRequestedOrientation(this.f38393b, 1);
        } else {
            SystemUtils.hookSetRequestedOrientation(this.f38393b, 10);
        }
    }

    /* renamed from: a */
    private boolean m27165a(Activity activity) {
        boolean z = true;
        try {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get((Object) null));
            Method method = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[]{TypedArray.class});
            method.setAccessible(true);
            z = ((Boolean) method.invoke((Object) null, new Object[]{obtainStyledAttributes})).booleanValue();
            method.setAccessible(false);
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z;
        }
    }

    /* renamed from: a */
    private int m27163a(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
