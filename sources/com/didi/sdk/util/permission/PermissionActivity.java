package com.didi.sdk.util.permission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;

public class PermissionActivity extends Activity {
    public static final String KEY_PERMISSIONS = "permissions";

    /* renamed from: a */
    private static final int f37740a = 100;

    /* renamed from: b */
    private static PermissionCallback f37741b;

    public static void request(Context context, String[] strArr, PermissionCallback permissionCallback) {
        f37741b = permissionCallback;
        Intent intent = new Intent(context, PermissionActivity.class);
        intent.putExtra("permissions", strArr);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (getIntent().hasExtra("permissions")) {
            String[] stringArrayExtra = getIntent().getStringArrayExtra("permissions");
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(stringArrayExtra, 100);
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 100) {
            int length = strArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] != 0) {
                    f37741b.onPermissionReject(strArr[i2]);
                } else {
                    f37741b.onPermissionGranted();
                }
            }
            finish();
        }
    }
}
