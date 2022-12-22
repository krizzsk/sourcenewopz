package com.yanzhenjie.permission.overlay.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.internal.referrer.Payload;
import com.didi.unifylogin.auth.InnerAuthManager;
import com.yanzhenjie.permission.source.Source;

public class LSettingPage {

    /* renamed from: a */
    private static final String f56222a = Build.MANUFACTURER.toLowerCase();

    /* renamed from: b */
    private Source f56223b;

    public LSettingPage(Source source) {
        this.f56223b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f56222a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m40485b(this.f56223b.getContext());
        } else if (f56222a.contains("xiaomi")) {
            intent = m40486c(this.f56223b.getContext());
        } else if (f56222a.contains("oppo")) {
            intent = m40487d(this.f56223b.getContext());
        } else if (f56222a.contains("vivo")) {
            intent = m40488e(this.f56223b.getContext());
        } else if (f56222a.contains("meizu")) {
            intent = m40489f(this.f56223b.getContext());
        } else {
            intent = m40483a(this.f56223b.getContext());
        }
        try {
            this.f56223b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f56223b.startActivityForResult(m40483a(this.f56223b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m40483a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    /* renamed from: b */
    private Intent m40485b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        return m40483a(context);
    }

    /* renamed from: c */
    private Intent m40486c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m40484a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        return m40483a(context);
    }

    /* renamed from: d */
    private Intent m40487d(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        return m40483a(context);
    }

    /* renamed from: e */
    private Intent m40488e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, context.getPackageName());
        if (m40484a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m40484a(context, intent)) {
            return intent;
        }
        return m40483a(context);
    }

    /* renamed from: f */
    private Intent m40489f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        if (m40484a(context, intent)) {
            return intent;
        }
        return m40483a(context);
    }

    /* renamed from: a */
    private static boolean m40484a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
