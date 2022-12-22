package com.didi.app.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.util.LockScreenUtilKt;
import com.didi.sdk.util.permission.PermissionActivity;
import com.didi.sdk.util.permission.PermissionCallback;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.Objects;

public class SystemSettingsHandler implements IRouterHandler {
    public static final int APP_TYPE = 2;
    public static final int DEFAULT_TYPE = 0;
    public static final int SYSTEM_TYPE = 1;

    /* renamed from: a */
    private static final String f8676a = "record_audio";

    public void handle(Request request, Result result) {
        Context context = request.getContext();
        Uri uri = request.getUri();
        String queryParameter = uri.getQueryParameter("permission");
        if (TextUtils.isEmpty(queryParameter)) {
            m5808a(context);
            return;
        }
        char c = 65535;
        switch (queryParameter.hashCode()) {
            case -2125976984:
                if (queryParameter.equals(f8676a)) {
                    c = 3;
                    break;
                }
                break;
            case -1888586689:
                if (queryParameter.equals(Permission.ACCESS_FINE_LOCATION)) {
                    c = 1;
                    break;
                }
                break;
            case -63024214:
                if (queryParameter.equals(Permission.ACCESS_COARSE_LOCATION)) {
                    c = 2;
                    break;
                }
                break;
            case 604372044:
                if (queryParameter.equals("android.settings.action.MANAGE_OVERLAY_PERMISSION")) {
                    c = 0;
                    break;
                }
                break;
        }
        if (c == 0) {
            LockScreenUtilKt.requestAppSetting(context);
        } else if (c == 1 || c == 2) {
            try {
                int parseInt = Integer.parseInt((String) Objects.requireNonNull(uri.getQueryParameter("type")));
                if (parseInt == 0) {
                    return;
                }
                if (parseInt == 1) {
                    Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                } else if (parseInt == 2) {
                    m5808a(context);
                }
            } catch (Exception unused) {
            }
        } else if (c != 3) {
            m5808a(context);
        } else if (Build.VERSION.SDK_INT < 23) {
        } else {
            if (context instanceof Activity) {
                ActivityCompat.requestPermissions((Activity) context, new String[]{Permission.RECORD_AUDIO}, 1);
            } else {
                PermissionActivity.request(context, new String[]{Permission.RECORD_AUDIO}, (PermissionCallback) null);
            }
        }
    }

    /* renamed from: a */
    private void m5808a(Context context) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.DEFAULT");
        context.startActivity(intent);
    }
}
