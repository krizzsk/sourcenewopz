package com.yanzhenjie.permission.bridge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import com.didi.sdk.apm.SystemUtils;
import com.yanzhenjie.permission.overlay.setting.LSettingPage;
import com.yanzhenjie.permission.overlay.setting.MSettingPage;
import com.yanzhenjie.permission.source.ActivitySource;
import com.yanzhenjie.permission.source.Source;

public final class BridgeActivity extends Activity {

    /* renamed from: a */
    private static final String f56158a = "KEY_TYPE";

    /* renamed from: b */
    private static final String f56159b = "KEY_PERMISSIONS";

    /* renamed from: a */
    static void m40416a(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 1);
        source.startActivity(intent);
    }

    /* renamed from: a */
    static void m40417a(Source source, String[] strArr) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 2);
        intent.putExtra(f56159b, strArr);
        source.startActivity(intent);
    }

    /* renamed from: b */
    static void m40418b(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 3);
        source.startActivity(intent);
    }

    /* renamed from: c */
    static void m40419c(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 4);
        source.startActivity(intent);
    }

    /* renamed from: d */
    static void m40420d(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 5);
        source.startActivity(intent);
    }

    /* renamed from: e */
    static void m40421e(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 6);
        source.startActivity(intent);
    }

    /* renamed from: f */
    static void m40422f(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 7);
        source.startActivity(intent);
    }

    /* renamed from: g */
    static void m40423g(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 8);
        source.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle == null) {
            Intent intent = getIntent();
            switch (intent.getIntExtra("KEY_TYPE", -1)) {
                case 1:
                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts("package", getPackageName(), (String) null));
                    startActivityForResult(intent2, 1);
                    return;
                case 2:
                    requestPermissions(intent.getStringArrayExtra(f56159b), 2);
                    return;
                case 3:
                    Intent intent3 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    intent3.setData(Uri.fromParts("package", getPackageName(), (String) null));
                    startActivityForResult(intent3, 3);
                    return;
                case 4:
                    new MSettingPage(new ActivitySource(this)).start(4);
                    return;
                case 5:
                    new LSettingPage(new ActivitySource(this)).start(5);
                    return;
                case 6:
                    Intent intent4 = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent4.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                    startActivityForResult(intent4, 6);
                    return;
                case 7:
                    startActivityForResult(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"), 7);
                    return;
                case 8:
                    Intent intent5 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                    intent5.setData(Uri.fromParts("package", getPackageName(), (String) null));
                    startActivityForResult(intent5, 8);
                    return;
                default:
                    return;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Messenger.m40424a(this);
        finish();
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Messenger.m40424a(this);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
