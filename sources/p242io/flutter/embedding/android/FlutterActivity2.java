package p242io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.didi.flutter.nacho2.p115v2.NachoConstants;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.FlutterActivityAndFragmentDelegate2;
import p242io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.FlutterShellArgs;
import p242io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import p242io.flutter.plugin.platform.PlatformPlugin;
import p242io.flutter.util.ViewUtils;

/* renamed from: io.flutter.embedding.android.FlutterActivity2 */
public class FlutterActivity2 extends Activity implements LifecycleOwner, FlutterActivityAndFragmentDelegate2.Host {
    public static final int FLUTTER_VIEW_ID = ViewUtils.generateViewId(61938);

    /* renamed from: b */
    private static final String f57359b = "FlutterActivity";

    /* renamed from: a */
    private Logger f57360a = LoggerFactory.getLogger("FlutterActivity2");

    /* renamed from: c */
    private LifecycleRegistry f57361c = new LifecycleRegistry(this);
    protected FlutterActivityAndFragmentDelegate2 delegate;

    public void cleanUpFlutterEngine(FlutterEngine flutterEngine) {
    }

    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
    }

    public void onFlutterUiNoLongerDisplayed() {
    }

    public boolean popSystemNavigator() {
        return false;
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return null;
    }

    public boolean shouldAttachEngineToActivity() {
        return true;
    }

    public static Intent createDefaultIntent(Context context) {
        return withNewEngine().build(context);
    }

    public static NewEngineIntentBuilder withNewEngine() {
        return new NewEngineIntentBuilder(FlutterActivity2.class);
    }

    /* renamed from: io.flutter.embedding.android.FlutterActivity2$NewEngineIntentBuilder */
    public static class NewEngineIntentBuilder {
        private final Class<? extends FlutterActivity2> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f57414m;
        private String initialRoute = "/";

        public NewEngineIntentBuilder(Class<? extends FlutterActivity2> cls) {
            this.activityClass = cls;
        }

        public NewEngineIntentBuilder initialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public NewEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            return new Intent(context, this.activityClass).putExtra("route", this.initialRoute).putExtra("background_mode", this.backgroundMode).putExtra("destroy_engine_with_activity", true);
        }
    }

    public static CachedEngineIntentBuilder withCachedEngine(String str) {
        return new CachedEngineIntentBuilder(FlutterActivity.class, str);
    }

    /* renamed from: io.flutter.embedding.android.FlutterActivity2$CachedEngineIntentBuilder */
    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterActivity> activityClass;
        private String backgroundMode = FlutterActivityLaunchConfigs.f57414m;
        private final String cachedEngineId;
        private boolean destroyEngineWithActivity = false;

        public CachedEngineIntentBuilder(Class<? extends FlutterActivity> cls, String str) {
            this.activityClass = cls;
            this.cachedEngineId = str;
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z) {
            this.destroyEngineWithActivity = z;
            return this;
        }

        public CachedEngineIntentBuilder backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode backgroundMode2) {
            this.backgroundMode = backgroundMode2.name();
            return this;
        }

        public Intent build(Context context) {
            return new Intent(context, this.activityClass).putExtra("cached_engine_id", this.cachedEngineId).putExtra("destroy_engine_with_activity", this.destroyEngineWithActivity).putExtra("background_mode", this.backgroundMode);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171919a(FlutterActivityAndFragmentDelegate2 flutterActivityAndFragmentDelegate2) {
        this.delegate = flutterActivityAndFragmentDelegate2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m41181a();
        super.onCreate(bundle);
        FlutterActivityAndFragmentDelegate2 flutterActivityAndFragmentDelegate2 = new FlutterActivityAndFragmentDelegate2(this);
        this.delegate = flutterActivityAndFragmentDelegate2;
        flutterActivityAndFragmentDelegate2.mo171982a((Context) this);
        this.delegate.mo171984a(bundle);
        this.f57361c.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        m41184c();
        setContentView(m41185d());
        m41186e();
    }

    /* renamed from: a */
    private void m41181a() {
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                int i = metaData.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i != -1) {
                    setTheme(i);
                    return;
                }
                return;
            }
            Log.m41140v(f57359b, "Using the launch theme as normal theme.");
        } catch (PackageManager.NameNotFoundException unused) {
            Log.m41136e(f57359b, "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    public SplashScreen provideSplashScreen() {
        Drawable b = m41183b();
        if (b != null) {
            return new DrawableSplashScreen(b);
        }
        return null;
    }

    /* renamed from: b */
    private Drawable m41183b() {
        try {
            Bundle metaData = getMetaData();
            int i = metaData != null ? metaData.getInt("io.flutter.embedding.android.SplashScreenDrawable") : 0;
            if (i != 0) {
                return ResourcesCompat.getDrawable(getResources(), i, getTheme());
            }
            return null;
        } catch (Resources.NotFoundException e) {
            Log.m41136e(f57359b, "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw e;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: c */
    private void m41184c() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    /* renamed from: d */
    private View m41185d() {
        return this.delegate.mo171977a((LayoutInflater) null, (ViewGroup) null, (Bundle) null, FLUTTER_VIEW_ID, getRenderMode() == RenderMode.surface);
    }

    /* renamed from: e */
    private void m41186e() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(1073741824);
            window.getDecorView().setSystemUiVisibility(1280);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f57361c.handleLifecycleEvent(Lifecycle.Event.ON_START);
        if (m41182a("onStart")) {
            this.delegate.mo171991g();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f57361c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        if (m41182a("onResume")) {
            this.delegate.mo171992h();
        }
    }

    public void onPostResume() {
        super.onPostResume();
        if (m41182a("onPostResume")) {
            this.delegate.mo171993i();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (m41182a("onPause")) {
            this.delegate.mo171995k();
        }
        this.f57361c.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (m41182a("onStop")) {
            this.delegate.mo171996l();
        }
        this.f57361c.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (m41182a("onSaveInstanceState")) {
            this.delegate.mo171986b(bundle);
        }
    }

    /* renamed from: f */
    private void m41187f() {
        FlutterActivityAndFragmentDelegate2 flutterActivityAndFragmentDelegate2 = this.delegate;
        if (flutterActivityAndFragmentDelegate2 != null) {
            flutterActivityAndFragmentDelegate2.mo171978a();
            this.delegate = null;
        }
    }

    public void detachFromFlutterEngine() {
        Log.m41142w(f57359b, "FlutterActivity " + this + " connection to the engine " + getFlutterEngine() + " evicted by another attaching activity");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (m41182a(NachoLifecycleManager.LIFECYCLE_ON_DESTROY)) {
            this.delegate.mo171997m();
            this.delegate.mo171998n();
        }
        m41187f();
        this.f57361c.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (m41182a("onActivityResult")) {
            this.delegate.mo171980a(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (m41182a("onNewIntent")) {
            this.delegate.mo171983a(intent);
        }
    }

    public void onBackPressed() {
        if (m41182a("onBackPressed")) {
            this.delegate.mo171999o();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (m41182a("onRequestPermissionsResult")) {
            this.delegate.mo171981a(i, strArr, iArr);
        }
    }

    public void onUserLeaveHint() {
        if (m41182a("onUserLeaveHint")) {
            this.delegate.mo172000p();
        }
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (m41182a("onTrimMemory")) {
            this.delegate.mo171979a(i);
        }
    }

    public Lifecycle getLifecycle() {
        return this.f57361c;
    }

    public FlutterShellArgs getFlutterShellArgs() {
        return FlutterShellArgs.fromIntent(getIntent());
    }

    public String getCachedEngineId() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    public boolean shouldDestroyEngineWithHost() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (getCachedEngineId() != null || this.delegate.mo171987c()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    public String getDartEntrypointFunctionName() {
        try {
            Bundle metaData = getMetaData();
            String string = metaData != null ? metaData.getString("io.flutter.Entrypoint") : null;
            if (string != null) {
                return string;
            }
            return NachoConstants.NACHO_ENTRYPOINT_NAME;
        } catch (PackageManager.NameNotFoundException unused) {
            return NachoConstants.NACHO_ENTRYPOINT_NAME;
        }
    }

    public String getInitialRoute() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                return metaData.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String getAppBundlePath() {
        String dataString;
        if (!m41188g() || !"android.intent.action.RUN".equals(getIntent().getAction()) || (dataString = getIntent().getDataString()) == null) {
            return null;
        }
        return dataString;
    }

    /* renamed from: g */
    private boolean m41188g() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    public RenderMode getRenderMode() {
        return getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque ? RenderMode.surface : RenderMode.texture;
    }

    public TransparencyMode getTransparencyMode() {
        if (getBackgroundMode() == FlutterActivityLaunchConfigs.BackgroundMode.opaque) {
            return TransparencyMode.opaque;
        }
        return TransparencyMode.transparent;
    }

    /* access modifiers changed from: protected */
    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        if (getIntent().hasExtra("background_mode")) {
            return FlutterActivityLaunchConfigs.BackgroundMode.valueOf(getIntent().getStringExtra("background_mode"));
        }
        return FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    /* access modifiers changed from: protected */
    public FlutterEngine getFlutterEngine() {
        FlutterActivityAndFragmentDelegate2 flutterActivityAndFragmentDelegate2 = this.delegate;
        if (flutterActivityAndFragmentDelegate2 != null) {
            return flutterActivityAndFragmentDelegate2.mo171985b();
        }
        this.f57360a.debug("getFlutterEngine failed, because delegate is no longer available", new Object[0]);
        return null;
    }

    /* access modifiers changed from: protected */
    public Bundle getMetaData() throws PackageManager.NameNotFoundException {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return new PlatformPlugin(getActivity(), flutterEngine.getPlatformChannel(), this);
    }

    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        if (!this.delegate.mo171987c()) {
            GeneratedPluginRegister.registerGeneratedPlugins(flutterEngine);
        }
    }

    public boolean shouldHandleDeeplinking() {
        try {
            Bundle metaData = getMetaData();
            if (metaData != null) {
                return metaData.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public void onFlutterUiDisplayed() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                reportFullyDrawn();
            } catch (Exception unused) {
            }
        }
    }

    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra("enable_state_restoration")) {
            return getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        if (getCachedEngineId() != null) {
            return false;
        }
        return true;
    }

    public void updateSystemUiOverlays() {
        FlutterActivityAndFragmentDelegate2 flutterActivityAndFragmentDelegate2 = this.delegate;
        if (flutterActivityAndFragmentDelegate2 != null) {
            flutterActivityAndFragmentDelegate2.mo171994j();
        }
    }

    /* renamed from: a */
    private boolean m41182a(String str) {
        FlutterActivityAndFragmentDelegate2 flutterActivityAndFragmentDelegate2 = this.delegate;
        if (flutterActivityAndFragmentDelegate2 == null) {
            Log.m41142w(f57359b, "FlutterActivity " + hashCode() + " " + str + " called after release.");
            return false;
        } else if (flutterActivityAndFragmentDelegate2.mo171988d()) {
            return true;
        } else {
            Log.m41142w(f57359b, "FlutterActivity " + hashCode() + " " + str + " called after detach.");
            return false;
        }
    }
}
