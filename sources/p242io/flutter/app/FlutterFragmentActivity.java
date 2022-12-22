package p242io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import p242io.flutter.app.FlutterActivityDelegate;
import p242io.flutter.plugin.common.PluginRegistry;
import p242io.flutter.view.FlutterNativeView;
import p242io.flutter.view.FlutterView;

@Deprecated
/* renamed from: io.flutter.app.FlutterFragmentActivity */
public class FlutterFragmentActivity extends FragmentActivity implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider {

    /* renamed from: a */
    private final FlutterActivityDelegate f57321a;

    /* renamed from: b */
    private final FlutterActivityEvents f57322b;

    /* renamed from: c */
    private final FlutterView.Provider f57323c;

    /* renamed from: d */
    private final PluginRegistry f57324d;

    public FlutterNativeView createFlutterNativeView() {
        return null;
    }

    public FlutterView createFlutterView(Context context) {
        return null;
    }

    public boolean retainFlutterNativeView() {
        return false;
    }

    public FlutterFragmentActivity() {
        FlutterActivityDelegate flutterActivityDelegate = new FlutterActivityDelegate(this, this);
        this.f57321a = flutterActivityDelegate;
        this.f57322b = flutterActivityDelegate;
        this.f57323c = flutterActivityDelegate;
        this.f57324d = flutterActivityDelegate;
    }

    public FlutterView getFlutterView() {
        return this.f57323c.getFlutterView();
    }

    public final boolean hasPlugin(String str) {
        return this.f57324d.hasPlugin(str);
    }

    public final <T> T valuePublishedByPlugin(String str) {
        return this.f57324d.valuePublishedByPlugin(str);
    }

    public final PluginRegistry.Registrar registrarFor(String str) {
        return this.f57324d.registrarFor(str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f57322b.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f57322b.onDestroy();
        super.onDestroy();
    }

    public void onBackPressed() {
        if (!this.f57322b.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f57322b.onStart();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.f57322b.onStop();
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f57322b.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        this.f57322b.onPostResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f57322b.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (!this.f57322b.onActivityResult(i, i2, intent)) {
            super.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f57322b.onNewIntent(intent);
    }

    public void onUserLeaveHint() {
        this.f57322b.onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        this.f57322b.onTrimMemory(i);
    }

    public void onLowMemory() {
        this.f57322b.onLowMemory();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f57322b.onConfigurationChanged(configuration);
    }
}
