package com.yanzhenjie.permission.runtime.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.internal.referrer.Payload;
import com.didi.unifylogin.auth.InnerAuthManager;
import com.yanzhenjie.permission.source.Source;

public class SettingPage {

    /* renamed from: a */
    private static final String f56244a = Build.MANUFACTURER.toLowerCase();

    /* renamed from: b */
    private Source f56245b;

    public SettingPage(Source source) {
        this.f56245b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f56244a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m40517b(this.f56245b.getContext());
        } else if (f56244a.contains("xiaomi")) {
            intent = m40518c(this.f56245b.getContext());
        } else if (f56244a.contains("oppo")) {
            intent = m40520e(this.f56245b.getContext());
        } else if (f56244a.contains("vivo")) {
            intent = m40519d(this.f56245b.getContext());
        } else if (f56244a.contains("meizu")) {
            intent = m40521f(this.f56245b.getContext());
        } else {
            intent = m40515a(this.f56245b.getContext());
        }
        try {
            this.f56245b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f56245b.startActivityForResult(m40515a(this.f56245b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m40515a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m40517b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        return m40515a(context);
    }

    /* renamed from: c */
    private static Intent m40518c(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m40516a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        return m40515a(context);
    }

    /* renamed from: d */
    private static Intent m40519d(Context context) {
        Intent intent = new Intent();
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, context.getPackageName());
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        return m40515a(context);
    }

    /* renamed from: e */
    private static Intent m40520e(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        return m40515a(context);
    }

    /* renamed from: f */
    private static Intent m40521f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m40516a(context, intent)) {
            return intent;
        }
        return m40515a(context);
    }

    /* renamed from: a */
    private static boolean m40516a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
