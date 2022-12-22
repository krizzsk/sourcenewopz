package p242io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.didi.sdk.apm.SystemUtils;
import p242io.flutter.app.FlutterActivityDelegate;
import p242io.flutter.plugin.common.PluginRegistry;
import p242io.flutter.view.FlutterNativeView;
import p242io.flutter.view.FlutterView;

@Deprecated
/* renamed from: io.flutter.app.FlutterActivity */
public class FlutterActivity extends Activity implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider {

    /* renamed from: a */
    private static final String f57308a = "FlutterActivity";

    /* renamed from: b */
    private final FlutterActivityDelegate f57309b;

    /* renamed from: c */
    private final FlutterActivityEvents f57310c;

    /* renamed from: d */
    private final FlutterView.Provider f57311d;

    /* renamed from: e */
    private final PluginRegistry f57312e;

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    public FlutterActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.f57309b = flutterActivityDelegate;
        this.f57310c = flutterActivityDelegate;
        this.f57311d = flutterActivityDelegate;
        this.f57312e = flutterActivityDelegate;
    }

    public FlutterView getFlutterView() {
        return this.f57311d.getFlutterView();
    }

    public final boolean hasPlugin(String str) {
        return this.f57312e.hasPlugin(str);
    }

    public final <T> T valuePublishedByPlugin(String str) {
        return this.f57312e.valuePublishedByPlugin(str);
    }

    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.f57312e.registrarFor(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f57310c.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f57310c.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f57310c.onResume();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f57310c.onDestroy();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.f57310c.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f57310c.onStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f57310c.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.f57310c.onPostResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f57310c.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f57310c.onActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        this.f57310c.onNewIntent(intent);
    }

    public void onUserLeaveHint() {
        this.f57310c.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        this.f57310c.onTrimMemory(i);
    }

    public void onLowMemory() {
        this.f57310c.onLowMemory();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f57310c.onConfigurationChanged(configuration);
    }
}
