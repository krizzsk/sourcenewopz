package com.didi.dimina.container.secondparty.permission.source;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.didi.dimina.container.Dimina;
import java.lang.reflect.Method;

public abstract class Source {

    /* renamed from: a */
    private static final int f17416a = 4;

    /* renamed from: b */
    private static final String f17417b = "checkOpNoThrow";

    /* renamed from: c */
    private static final String f17418c = "OP_REQUEST_INSTALL_PACKAGES";

    /* renamed from: d */
    private static final String f17419d = "OP_SYSTEM_ALERT_WINDOW";

    /* renamed from: e */
    private static final String f17420e = "OP_POST_NOTIFICATION";

    /* renamed from: f */
    private static final String f17421f = "OP_ACCESS_NOTIFICATIONS";

    /* renamed from: g */
    private static final String f17422g = "OP_WRITE_SETTINGS";

    /* renamed from: h */
    private int f17423h;

    /* renamed from: i */
    private String f17424i;

    /* renamed from: j */
    private PackageManager f17425j;

    /* renamed from: k */
    private AppOpsManager f17426k;

    /* renamed from: l */
    private NotificationManager f17427l;

    public abstract Context getContext();

    public abstract boolean isShowRationalePermission(String str);

    public abstract void startActivity(Intent intent);

    public abstract void startActivityForResult(Intent intent, int i);

    /* renamed from: a */
    private int m12958a() {
        if (this.f17423h < 14) {
            this.f17423h = getContext().getApplicationInfo().targetSdkVersion;
        }
        return this.f17423h;
    }

    public String getPackageName() {
        if (this.f17424i == null) {
            this.f17424i = Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(getContext().getApplicationContext());
        }
        return this.f17424i;
    }

    /* renamed from: b */
    private PackageManager m12960b() {
        if (this.f17425j == null) {
            this.f17425j = getContext().getPackageManager();
        }
        return this.f17425j;
    }

    /* renamed from: c */
    private AppOpsManager m12961c() {
        if (this.f17426k == null) {
            this.f17426k = (AppOpsManager) getContext().getSystemService("appops");
        }
        return this.f17426k;
    }

    /* renamed from: d */
    private NotificationManager m12962d() {
        if (this.f17427l == null) {
            this.f17427l = (NotificationManager) getContext().getSystemService("notification");
        }
        return this.f17427l;
    }

    public final boolean canRequestPackageInstalls() {
        if (Build.VERSION.SDK_INT < 23 || Build.VERSION.SDK_INT < 26) {
            return true;
        }
        if (m12958a() < 26) {
            return m12959a(f17418c);
        }
        return m12960b().canRequestPackageInstalls();
    }

    public final boolean canDrawOverlays() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m12958a() >= 23) {
            return Settings.canDrawOverlays(context);
        }
        return m12959a(f17419d);
    }

    public final boolean canNotify() {
        if (Build.VERSION.SDK_INT >= 24) {
            return m12962d().areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return m12959a(f17420e);
        }
        return true;
    }

    public final boolean canListenerNotification() {
        if (Build.VERSION.SDK_INT >= 19) {
            return m12959a(f17421f);
        }
        String string = Settings.Secure.getString(getContext().getContentResolver(), "enabled_notification_listeners");
        return string != null && string.contains(getPackageName());
    }

    public final boolean canWriteSetting() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        if (m12958a() >= 23) {
            return Settings.System.canWrite(context);
        }
        return m12959a(f17422g);
    }

    /* renamed from: a */
    private boolean m12959a(String str) {
        int i = getContext().getApplicationInfo().uid;
        Class<AppOpsManager> cls = AppOpsManager.class;
        try {
            Method method = cls.getMethod(f17417b, new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            int intValue = ((Integer) cls.getDeclaredField(str).get(Integer.class)).intValue();
            int intValue2 = ((Integer) method.invoke(m12961c(), new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), getPackageName()})).intValue();
            if (intValue2 == 0 || intValue2 == 4) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }
}
