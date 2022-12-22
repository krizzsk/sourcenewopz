package com.yanzhenjie.permission.overlay.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.yanzhenjie.permission.source.Source;

public class MSettingPage {

    /* renamed from: a */
    private static final String f56224a = Build.MANUFACTURER.toLowerCase();

    /* renamed from: b */
    private Source f56225b;

    public MSettingPage(Source source) {
        this.f56225b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f56224a.contains("meizu")) {
            intent = m40493c(this.f56225b.getContext());
        } else {
            intent = m40492b(this.f56225b.getContext());
        }
        try {
            this.f56225b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f56225b.startActivityForResult(m40490a(this.f56225b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m40490a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m40492b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        if (m40491a(context, intent)) {
            return intent;
        }
        return m40490a(context);
    }

    /* renamed from: c */
    private static Intent m40493c(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m40491a(context, intent)) {
            return intent;
        }
        return m40492b(context);
    }

    /* renamed from: a */
    private static boolean m40491a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
