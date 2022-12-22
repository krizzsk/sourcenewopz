package com.yanzhenjie.permission.source;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;

public abstract class Source {

    /* renamed from: a */
    private static final int f56256a = 4;

    /* renamed from: b */
    private static final String f56257b = "checkOpNoThrow";

    /* renamed from: c */
    private static final String f56258c = "OP_REQUEST_INSTALL_PACKAGES";

    /* renamed from: d */
    private static final String f56259d = "OP_SYSTEM_ALERT_WINDOW";

    /* renamed from: e */
    private static final String f56260e = "OP_POST_NOTIFICATION";

    /* renamed from: f */
    private static final String f56261f = "OP_ACCESS_NOTIFICATIONS";

    /* renamed from: g */
    private static final String f56262g = "OP_WRITE_SETTINGS";

    /* renamed from: h */
    private int f56263h;

    /* renamed from: i */
    private String f56264i;

    /* renamed from: j */
    private PackageManager f56265j;

    /* renamed from: k */
    private AppOpsManager f56266k;

    /* renamed from: l */
    private NotificationManager f56267l;

    public abstract Context getContext();

    public abstract boolean isShowRationalePermission(String str);

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i);

    /* renamed from: a */
    private int m40525a() {
        if (this.f56263h < 14) {
            this.f56263h = getContext().getApplicationInfo().targetSdkVersion;
        }
        return this.f56263h;
    }

    public String getPackageName() {
        if (this.f56264i == null) {
            this.f56264i = getContext().getApplicationContext().getPackageName();
        }
        return this.f56264i;
    }

    /* renamed from: b */
    private PackageManager m40527b() {
        if (this.f56265j == null) {
            this.f56265j = getContext().getPackageManager();
        }
        return this.f56265j;
    }

    /* renamed from: c */
    private AppOpsManager m40528c() {
        if (this.f56266k == null) {
            this.f56266k = (AppOpsManager) getContext().getSystemService("appops");
        }
        return this.f56266k;
    }

    /* renamed from: d */
    private NotificationManager m40529d() {
        if (this.f56267l == null) {
            this.f56267l = (NotificationManager) getContext().getSystemService("notification");
        }
        return this.f56267l;
    }

    public final boolean canRequestPackageInstalls() {
        if (Build.VERSION.SDK_INT < 23 || Build.VERSION.SDK_INT < 26) {
            return true;
        }
        if (m40525a() < 26) {
            return m40526a(f56258c);
        }
        return m40527b().canRequestPackageInstalls();
    }

    public final boolean canDrawOverlays() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m40525a() >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return m40526a(f56259d);
    }

    public final boolean canNotify() {
        if (Build.VERSION.SDK_INT >= 24) {
            return m40529d().areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return m40526a(f56260e);
        }
        return true;
    }

    public final boolean canListenerNotification() {
        if (Build.VERSION.SDK_INT >= 19) {
            return m40526a(f56261f);
        }
        String string = Settings.Secure.getString(getContext().getContentResolver(), "enabled_notification_listeners");
        return string != null && string.contains(getPackageName());
    }

    public final boolean canWriteSetting() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m40525a() >= 23) {
            return Settings.System.canWrite(context);
        }
        return m40526a(f56262g);
    }

    /* renamed from: a */
    private boolean m40526a(String str) {
        int i = getContext().getApplicationInfo().uid;
        Class<AppOpsManager> cls = AppOpsManager.class;
        try {
            Method method = cls.getMethod(f56257b, new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            int intValue = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            int intValue2 = ((Integer) method.invoke(m40528c(), new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), getPackageName()})).intValue();
            if (intValue2 == 0 || intValue2 == 4) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
