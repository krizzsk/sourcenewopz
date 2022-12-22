package com.didi.dimina.container.secondparty.permission.bridge;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.secondparty.permission.overlay.setting.LSettingPage;
import com.didi.dimina.container.secondparty.permission.overlay.setting.MSettingPage;
import com.didi.dimina.container.secondparty.permission.source.ActivitySource;
import com.didi.dimina.container.secondparty.permission.source.Source;
import com.didi.sdk.apm.SystemUtils;

public final class BridgeActivity extends Activity {

    /* renamed from: a */
    private static final String f17335a = "KEY_TYPE";

    /* renamed from: b */
    private static final String f17336b = "KEY_PERMISSIONS";

    /* renamed from: a */
    static void m12875a(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 1);
        source.startActivity(intent);
    }

    /* renamed from: a */
    static void m12876a(Source source, String[] strArr) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 2);
        intent.putExtra(f17336b, strArr);
        source.startActivity(intent);
    }

    /* renamed from: b */
    static void m12877b(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 3);
        source.startActivity(intent);
    }

    /* renamed from: c */
    static void m12878c(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 4);
        source.startActivity(intent);
    }

    /* renamed from: d */
    static void m12879d(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 5);
        source.startActivity(intent);
    }

    /* renamed from: e */
    static void m12880e(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 6);
        source.startActivity(intent);
    }

    /* renamed from: f */
    static void m12881f(Source source) {
        Intent intent = new Intent(source.getContext(), BridgeActivity.class);
        intent.putExtra("KEY_TYPE", 7);
        source.startActivity(intent);
    }

    /* renamed from: g */
    static void m12882g(Source source) {
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
                    intent2.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(this), (String) null));
                    startActivityForResult(intent2, 1);
                    return;
                case 2:
                    requestPermissions(intent.getStringArrayExtra(f17336b), 2);
                    return;
                case 3:
                    Intent intent3 = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES");
                    intent3.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(this), (String) null));
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
                    intent4.putExtra("android.provider.extra.APP_PACKAGE", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(this));
                    startActivityForResult(intent4, 6);
                    return;
                case 7:
                    startActivityForResult(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"), 7);
                    return;
                case 8:
                    Intent intent5 = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
                    intent5.setData(Uri.fromParts("package", Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(this), (String) null));
                    startActivityForResult(intent5, 8);
                    return;
                default:
                    return;
            }
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Messenger.m12883a(this);
        finish();
    }

    public void startActivityForResult(Intent intent, int i) {
        super.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        Messenger.m12883a(this);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
