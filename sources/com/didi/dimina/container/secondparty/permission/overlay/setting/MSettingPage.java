package com.didi.dimina.container.secondparty.permission.overlay.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.source.Source;

public class MSettingPage {

    /* renamed from: a */
    private static final String f17385a = Dimina.getConfig().getAdapterConfig().getWsgService().getBrand((Context) null).toLowerCase();

    /* renamed from: b */
    private final Source f17386b;

    public MSettingPage(Source source) {
        this.f17386b = source;
    }

    public void start(int i) {
        Intent intent;
        if (f17385a.contains("meizu")) {
            intent = m12925c(this.f17386b.getContext());
        } else {
            intent = m12924b(this.f17386b.getContext());
        }
        try {
            this.f17386b.startActivityForResult(intent, i);
        } catch (Exception unused) {
            this.f17386b.startActivityForResult(m12922a(this.f17386b.getContext()), i);
        }
    }

    /* renamed from: a */
    private static Intent m12922a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        return intent;
    }

    /* renamed from: b */
    private static Intent m12924b(Context context) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context), (String) null));
        if (m12923a(context, intent)) {
            return intent;
        }
        return m12922a(context);
    }

    /* renamed from: c */
    private static Intent m12925c(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context));
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        if (m12923a(context, intent)) {
            return intent;
        }
        return m12924b(context);
    }

    /* renamed from: a */
    private static boolean m12923a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
