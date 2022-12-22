package p242io.flutter.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.didi.flutter.nacho2.p115v2.NachoConstants;
import java.util.ArrayList;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterShellArgs;
import p242io.flutter.plugin.common.PluginRegistry;
import p242io.flutter.util.Preconditions;
import p242io.flutter.view.FlutterMain;
import p242io.flutter.view.FlutterNativeView;
import p242io.flutter.view.FlutterRunArguments;
import p242io.flutter.view.FlutterView;

@Deprecated
/* renamed from: io.flutter.app.FlutterActivityDelegate */
public final class FlutterActivityDelegate implements FlutterActivityEvents, PluginRegistry, FlutterView.Provider {

    /* renamed from: a */
    private static final String f57313a = "io.flutter.app.android.SplashScreenUntilFirstFrame";

    /* renamed from: b */
    private static final String f57314b = "FlutterActivityDelegate";

    /* renamed from: c */
    private static final WindowManager.LayoutParams f57315c = new WindowManager.LayoutParams(-1, -1);

    /* renamed from: d */
    private final Activity f57316d;

    /* renamed from: e */
    private final ViewFactory f57317e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public FlutterView f57318f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public View f57319g;

    /* renamed from: io.flutter.app.FlutterActivityDelegate$ViewFactory */
    public interface ViewFactory {
        FlutterNativeView createFlutterNativeView();

        FlutterView createFlutterView(Context context);

        boolean retainFlutterNativeView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public FlutterActivityDelegate(Activity activity, ViewFactory viewFactory) {
        this.f57316d = (Activity) Preconditions.checkNotNull(activity);
        this.f57317e = (ViewFactory) Preconditions.checkNotNull(viewFactory);
    }

    public FlutterView getFlutterView() {
        return this.f57318f;
    }

    public boolean hasPlugin(String str) {
        return this.f57318f.getPluginRegistry().hasPlugin(str);
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.f57318f.getPluginRegistry().valuePublishedByPlugin(str);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        return this.f57318f.getPluginRegistry().registrarFor(str);
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        return this.f57318f.getPluginRegistry().onRequestPermissionsResult(i, strArr, iArr);
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        return this.f57318f.getPluginRegistry().onActivityResult(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        String findAppBundlePath;
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.f57316d.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
        FlutterMain.ensureInitializationComplete(this.f57316d.getApplicationContext(), m41148a(this.f57316d.getIntent()));
        FlutterView createFlutterView = this.f57317e.createFlutterView(this.f57316d);
        this.f57318f = createFlutterView;
        if (createFlutterView == null) {
            FlutterView flutterView = new FlutterView(this.f57316d, (AttributeSet) null, this.f57317e.createFlutterNativeView());
            this.f57318f = flutterView;
            flutterView.setLayoutParams(f57315c);
            this.f57316d.setContentView(this.f57318f);
            View b = m41149b();
            this.f57319g = b;
            if (b != null) {
                m41154e();
            }
        }
        if (!m41151b(this.f57316d.getIntent()) && (findAppBundlePath = FlutterMain.findAppBundlePath()) != null) {
            m41146a(findAppBundlePath);
        }
    }

    public void onNewIntent(Intent intent) {
        if (!m41147a() || !m41151b(intent)) {
            this.f57318f.getPluginRegistry().onNewIntent(intent);
        }
    }

    /* renamed from: a */
    private boolean m41147a() {
        return (this.f57316d.getApplicationInfo().flags & 2) != 0;
    }

    public void onPause() {
        Application application = (Application) this.f57316d.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.f57316d.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity((Activity) null);
            }
        }
        FlutterView flutterView = this.f57318f;
        if (flutterView != null) {
            flutterView.onPause();
        }
    }

    public void onStart() {
        FlutterView flutterView = this.f57318f;
        if (flutterView != null) {
            flutterView.onStart();
        }
    }

    public void onResume() {
        Application application = (Application) this.f57316d.getApplicationContext();
        if (application instanceof FlutterApplication) {
            ((FlutterApplication) application).setCurrentActivity(this.f57316d);
        }
    }

    public void onStop() {
        this.f57318f.onStop();
    }

    public void onPostResume() {
        FlutterView flutterView = this.f57318f;
        if (flutterView != null) {
            flutterView.onPostResume();
        }
    }

    public void onDestroy() {
        Application application = (Application) this.f57316d.getApplicationContext();
        if (application instanceof FlutterApplication) {
            FlutterApplication flutterApplication = (FlutterApplication) application;
            if (this.f57316d.equals(flutterApplication.getCurrentActivity())) {
                flutterApplication.setCurrentActivity((Activity) null);
            }
        }
        FlutterView flutterView = this.f57318f;
        if (flutterView == null) {
            return;
        }
        if (flutterView.getPluginRegistry().onViewDestroy(this.f57318f.getFlutterNativeView()) || this.f57317e.retainFlutterNativeView()) {
            this.f57318f.detach();
        } else {
            this.f57318f.destroy();
        }
    }

    public boolean onBackPressed() {
        FlutterView flutterView = this.f57318f;
        if (flutterView == null) {
            return false;
        }
        flutterView.popRoute();
        return true;
    }

    public void onUserLeaveHint() {
        this.f57318f.getPluginRegistry().onUserLeaveHint();
    }

    public void onTrimMemory(int i) {
        if (i == 10) {
            this.f57318f.onMemoryPressure();
        }
    }

    public void onLowMemory() {
        this.f57318f.onMemoryPressure();
    }

    /* renamed from: a */
    private static String[] m41148a(Intent intent) {
        ArrayList arrayList = new ArrayList();
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_STARTUP, false)) {
            arrayList.add(FlutterShellArgs.ARG_TRACE_STARTUP);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_START_PAUSED, false)) {
            arrayList.add(FlutterShellArgs.ARG_START_PAUSED);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_DISABLE_SERVICE_AUTH_CODES, false)) {
            arrayList.add(FlutterShellArgs.ARG_DISABLE_SERVICE_AUTH_CODES);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_USE_TEST_FONTS, false)) {
            arrayList.add(FlutterShellArgs.ARG_USE_TEST_FONTS);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENABLE_DART_PROFILING, false)) {
            arrayList.add(FlutterShellArgs.ARG_ENABLE_DART_PROFILING);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENABLE_SOFTWARE_RENDERING, false)) {
            arrayList.add(FlutterShellArgs.ARG_ENABLE_SOFTWARE_RENDERING);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_SKIA_DETERMINISTIC_RENDERING, false)) {
            arrayList.add(FlutterShellArgs.ARG_SKIA_DETERMINISTIC_RENDERING);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_SKIA, false)) {
            arrayList.add(FlutterShellArgs.ARG_TRACE_SKIA);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_TRACE_SYSTRACE, false)) {
            arrayList.add(FlutterShellArgs.ARG_TRACE_SYSTRACE);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_DUMP_SHADER_SKP_ON_SHADER_COMPILATION, false)) {
            arrayList.add(FlutterShellArgs.ARG_DUMP_SHADER_SKP_ON_SHADER_COMPILATION);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_CACHE_SKSL, false)) {
            arrayList.add(FlutterShellArgs.ARG_CACHE_SKSL);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_PURGE_PERSISTENT_CACHE, false)) {
            arrayList.add(FlutterShellArgs.ARG_PURGE_PERSISTENT_CACHE);
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_VERBOSE_LOGGING, false)) {
            arrayList.add(FlutterShellArgs.ARG_VERBOSE_LOGGING);
        }
        int intExtra = intent.getIntExtra(FlutterShellArgs.ARG_KEY_OBSERVATORY_PORT, 0);
        if (intExtra > 0) {
            arrayList.add(FlutterShellArgs.ARG_OBSERVATORY_PORT + Integer.toString(intExtra));
        }
        if (intent.getBooleanExtra(FlutterShellArgs.ARG_KEY_ENDLESS_TRACE_BUFFER, false)) {
            arrayList.add(FlutterShellArgs.ARG_ENDLESS_TRACE_BUFFER);
        }
        if (intent.hasExtra(FlutterShellArgs.ARG_KEY_DART_FLAGS)) {
            arrayList.add("--dart-flags=" + intent.getStringExtra(FlutterShellArgs.ARG_KEY_DART_FLAGS));
        }
        if (!arrayList.isEmpty()) {
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return null;
    }

    /* renamed from: b */
    private boolean m41151b(Intent intent) {
        if (!"android.intent.action.RUN".equals(intent.getAction())) {
            return false;
        }
        String stringExtra = intent.getStringExtra("route");
        String dataString = intent.getDataString();
        if (dataString == null) {
            dataString = FlutterMain.findAppBundlePath();
        }
        if (stringExtra != null) {
            this.f57318f.setInitialRoute(stringExtra);
        }
        m41146a(dataString);
        return true;
    }

    /* renamed from: a */
    private void m41146a(String str) {
        if (!this.f57318f.getFlutterNativeView().isApplicationRunning()) {
            FlutterRunArguments flutterRunArguments = new FlutterRunArguments();
            flutterRunArguments.bundlePath = str;
            flutterRunArguments.entrypoint = NachoConstants.NACHO_ENTRYPOINT_NAME;
            this.f57318f.runFromBundle(flutterRunArguments);
        }
    }

    /* renamed from: b */
    private View m41149b() {
        Drawable c;
        if (!m41153d().booleanValue() || (c = m41152c()) == null) {
            return null;
        }
        View view = new View(this.f57316d);
        view.setLayoutParams(f57315c);
        view.setBackground(c);
        return view;
    }

    /* renamed from: c */
    private Drawable m41152c() {
        TypedValue typedValue = new TypedValue();
        if (!this.f57316d.getTheme().resolveAttribute(16842836, typedValue, true) || typedValue.resourceId == 0) {
            return null;
        }
        try {
            return this.f57316d.getResources().getDrawable(typedValue.resourceId);
        } catch (Resources.NotFoundException unused) {
            Log.m41136e(f57314b, "Referenced launch screen windowBackground resource does not exist");
            return null;
        }
    }

    /* renamed from: d */
    private Boolean m41153d() {
        try {
            Bundle bundle = this.f57316d.getPackageManager().getActivityInfo(this.f57316d.getComponentName(), 128).metaData;
            return Boolean.valueOf(bundle != null && bundle.getBoolean(f57313a));
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: e */
    private void m41154e() {
        View view = this.f57319g;
        if (view != null) {
            this.f57316d.addContentView(view, f57315c);
            this.f57318f.addFirstFrameListener(new FlutterView.FirstFrameListener() {
                public void onFirstFrame() {
                    FlutterActivityDelegate.this.f57319g.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            ((ViewGroup) FlutterActivityDelegate.this.f57319g.getParent()).removeView(FlutterActivityDelegate.this.f57319g);
                            View unused = FlutterActivityDelegate.this.f57319g = null;
                        }
                    });
                    FlutterActivityDelegate.this.f57318f.removeFirstFrameListener(this);
                }
            });
            this.f57316d.setTheme(16973833);
        }
    }
}
