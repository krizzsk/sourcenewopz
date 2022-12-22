package com.didi.dimina.container.secondparty.permission.runtime.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.internal.referrer.Payload;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.unifylogin.auth.InnerAuthManager;

public class SettingPage {

    /* renamed from: a */
    private static final String f17404a = Dimina.getConfig().getAdapterConfig().getWsgService().getBrand((Context) null).toLowerCase();

    /* renamed from: b */
    private final Source f17405b;

    public SettingPage(Source source) {
        this.f17405b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f17404a.contains(Payload.SOURCE_HUAWEI)) {
            intent = m12950b(this.f17405b.getContext());
        } else if (f17404a.contains("xiaomi")) {
            intent = m12951c(this.f17405b.getContext());
        } else if (f17404a.contains("oppo")) {
            intent = m12953e(this.f17405b.getContext());
        } else if (f17404a.contains("vivo")) {
            intent = m12952d(this.f17405b.getContext());
        } else if (f17404a.contains("meizu")) {
            intent = m12954f(this.f17405b.getContext());
        } else {
            intent = m12947a(this.f17405b.getContext());
        }
        try {
            this.f17405b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f17405b.startActivityForResult(m12947a(this.f17405b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m12947a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m12950b(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        return m12947a(context);
    }

    /* renamed from: c */
    private static Intent m12951c(Context context) {
        if (m12948a()) {
            return m12947a(context);
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        if (m12949a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        return m12947a(context);
    }

    /* renamed from: a */
    private static boolean m12948a() {
        try {
            String[] split = Build.VERSION.INCREMENTAL.substring(1).split("\\.");
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 12) {
                return true;
            }
            return parseInt == 12 && parseInt2 >= 5;
        } catch (Exception unused) {
        }
    }

    /* renamed from: d */
    private static Intent m12952d(Context context) {
        Intent intent = new Intent();
        intent.putExtra(InnerAuthManager.PACKAGE_NAME_QUERY, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        return m12947a(context);
    }

    /* renamed from: e */
    private static Intent m12953e(Context context) {
        Intent intent = new Intent();
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        intent.setClassName("com.oppo.safe", "com.oppo.safe.permission.PermissionAppListActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        return m12947a(context);
    }

    /* renamed from: f */
    private static Intent m12954f(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m12949a(context, intent)) {
            return intent;
        }
        return m12947a(context);
    }

    /* renamed from: a */
    private static boolean m12949a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
