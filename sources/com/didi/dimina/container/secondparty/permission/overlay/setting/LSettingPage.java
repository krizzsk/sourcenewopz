package com.didi.dimina.container.secondparty.permission.overlay.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appsflyer.internal.referrer.Payload;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.unifylogin.auth.InnerAuthManager;

public class LSettingPage {

    /* renamed from: a */
    private static final String f17383a = Dimina.getConfig().getAdapterConfig().getWsgService().getBrand((Context) null).toLowerCase();

    /* renamed from: b */
    private final Source f17384b;

    public LSettingPage(Source source) {
        this.f17384b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f17383a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m12917b(this.f17384b.getContext());
        } else if (f17383a.contains("xiaomi")) {
            intent = m12918c(this.f17384b.getContext());
        } else if (f17383a.contains("oppo")) {
            intent = m12919d(this.f17384b.getContext());
        } else if (f17383a.contains("vivo")) {
            intent = m12920e(this.f17384b.getContext());
        } else if (f17383a.contains("meizu")) {
            intent = m12921f(this.f17384b.getContext());
        } else {
            intent = m12915a(this.f17384b.getContext());
        }
        try {
            this.f17384b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f17384b.startActivityForResult(m12915a(this.f17384b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m12915a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        return intent;
    }

    /* renamed from: b */
    private Intent m12917b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        return m12915a(context);
    }

    /* renamed from: c */
    private Intent m12918c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        if (m12916a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        return m12915a(context);
    }

    /* renamed from: d */
    private Intent m12919d(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.floatwindow.FloatWindowListActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        return m12915a(context);
    }

    /* renamed from: e */
    private Intent m12920e(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.FloatWindowManager");
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        if (m12916a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m12916a(context, intent)) {
            return intent;
        }
        return m12915a(context);
    }

    /* renamed from: f */
    private Intent m12921f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        if (m12916a(context, intent)) {
            return intent;
        }
        return m12915a(context);
    }

    /* renamed from: a */
    private static boolean m12916a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
