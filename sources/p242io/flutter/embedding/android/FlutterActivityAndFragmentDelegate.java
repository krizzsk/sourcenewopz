package p242io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.lifecycle.Lifecycle;
import java.util.Arrays;
import p242io.flutter.FlutterInjector;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.FlutterEngineCache;
import p242io.flutter.embedding.engine.FlutterShellArgs;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import p242io.flutter.plugin.platform.PlatformPlugin;
import p242io.flutter.util.ViewUtils;
import rui.config.RConfigConstants;

/* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate */
class FlutterActivityAndFragmentDelegate implements ExclusiveAppComponent<Activity> {

    /* renamed from: b */
    private static final String f57362b = "FlutterActivityAndFragmentDelegate";

    /* renamed from: c */
    private static final String f57363c = "framework";

    /* renamed from: d */
    private static final String f57364d = "plugins";

    /* renamed from: e */
    private static final int f57365e = 486947586;

    /* renamed from: a */
    ViewTreeObserver.OnPreDrawListener f57366a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Host f57367f;

    /* renamed from: g */
    private FlutterEngine f57368g;

    /* renamed from: h */
    private FlutterView f57369h;

    /* renamed from: i */
    private PlatformPlugin f57370i;

    /* renamed from: j */
    private boolean f57371j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f57372k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f57373l;

    /* renamed from: m */
    private boolean f57374m;

    /* renamed from: n */
    private final FlutterUiDisplayListener f57375n = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegate.this.f57367f.onFlutterUiDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate.this.f57372k = true;
            boolean unused2 = FlutterActivityAndFragmentDelegate.this.f57373l = true;
        }

        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegate.this.f57367f.onFlutterUiNoLongerDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate.this.f57372k = false;
        }
    };

    /* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate$Host */
    interface Host extends FlutterEngineConfigurator, FlutterEngineProvider, SplashScreenProvider, PlatformPlugin.PlatformPluginDelegate {
        void cleanUpFlutterEngine(FlutterEngine flutterEngine);

        void configureFlutterEngine(FlutterEngine flutterEngine);

        void detachFromFlutterEngine();

        Activity getActivity();

        String getAppBundlePath();

        String getCachedEngineId();

        Context getContext();

        String getDartEntrypointFunctionName();

        FlutterShellArgs getFlutterShellArgs();

        String getInitialRoute();

        Lifecycle getLifecycle();

        RenderMode getRenderMode();

        TransparencyMode getTransparencyMode();

        void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView);

        void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView);

        void onFlutterUiDisplayed();

        void onFlutterUiNoLongerDisplayed();

        FlutterEngine provideFlutterEngine(Context context);

        PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine);

        SplashScreen provideSplashScreen();

        boolean shouldAttachEngineToActivity();

        boolean shouldDestroyEngineWithHost();

        boolean shouldHandleDeeplinking();

        boolean shouldRestoreAndSaveState();

        void updateSystemUiOverlays();
    }

    FlutterActivityAndFragmentDelegate(Host host) {
        this.f57367f = host;
        this.f57373l = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171952a() {
        this.f57367f = null;
        this.f57368g = null;
        this.f57369h = null;
        this.f57370i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public FlutterEngine mo171959b() {
        return this.f57368g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo171961c() {
        return this.f57371j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo171962d() {
        return this.f57374m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171956a(Context context) {
        m41197s();
        if (this.f57368g == null) {
            mo171964f();
        }
        if (this.f57367f.shouldAttachEngineToActivity()) {
            Log.m41140v(f57362b, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f57368g.getActivityControlSurface().attachToActivity(this, this.f57367f.getLifecycle());
        }
        Host host = this.f57367f;
        this.f57370i = host.providePlatformPlugin(host.getActivity(), this.f57368g);
        this.f57367f.configureFlutterEngine(this.f57368g);
        this.f57374m = true;
    }

    /* renamed from: e */
    public Activity getAppComponent() {
        Activity activity = this.f57367f.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo171964f() {
        Log.m41140v(f57362b, "Setting up FlutterEngine.");
        String cachedEngineId = this.f57367f.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.f57368g = flutterEngine;
            this.f57371j = true;
            if (flutterEngine == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host = this.f57367f;
        FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
        this.f57368g = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.f57371j = true;
            return;
        }
        Log.m41140v(f57362b, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f57368g = new FlutterEngine(this.f57367f.getContext(), this.f57367f.getFlutterShellArgs().toArray(), false, this.f57367f.shouldRestoreAndSaveState());
        this.f57371j = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo171951a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        Log.m41140v(f57362b, "Creating FlutterView.");
        m41197s();
        boolean z2 = true;
        if (this.f57367f.getRenderMode() == RenderMode.surface) {
            Context context = this.f57367f.getContext();
            if (this.f57367f.getTransparencyMode() != TransparencyMode.transparent) {
                z2 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z2);
            this.f57367f.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.f57369h = new FlutterView(this.f57367f.getContext(), flutterSurfaceView);
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.f57367f.getContext());
            if (this.f57367f.getTransparencyMode() != TransparencyMode.opaque) {
                z2 = false;
            }
            flutterTextureView.setOpaque(z2);
            this.f57367f.onFlutterTextureViewCreated(flutterTextureView);
            this.f57369h = new FlutterView(this.f57367f.getContext(), flutterTextureView);
        }
        this.f57369h.addOnFirstFrameRenderedListener(this.f57375n);
        Log.m41140v(f57362b, "Attaching FlutterEngine to FlutterView.");
        this.f57369h.attachToFlutterEngine(this.f57368g);
        this.f57369h.setId(i);
        SplashScreen provideSplashScreen = this.f57367f.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.m41142w(f57362b, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashView flutterSplashView = new FlutterSplashView(this.f57367f.getContext());
            flutterSplashView.setId(ViewUtils.generateViewId(f57365e));
            flutterSplashView.mo172152a(this.f57369h, provideSplashScreen);
            return flutterSplashView;
        }
        if (z) {
            m41191a(this.f57369h);
        }
        return this.f57369h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171958a(Bundle bundle) {
        Bundle bundle2;
        Log.m41140v(f57362b, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        m41197s();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(f57364d);
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f57367f.shouldRestoreAndSaveState()) {
            this.f57368g.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.f57367f.shouldAttachEngineToActivity()) {
            this.f57368g.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo171965g() {
        Log.m41140v(f57362b, "onStart()");
        m41197s();
        m41196r();
    }

    /* renamed from: r */
    private void m41196r() {
        if (this.f57367f.getCachedEngineId() == null && !this.f57368g.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.f57367f.getInitialRoute();
            if (initialRoute == null && (initialRoute = m41193b(this.f57367f.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.m41140v(f57362b, "Executing Dart entrypoint: " + this.f57367f.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.f57368g.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.f57367f.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.f57368g.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.f57367f.getDartEntrypointFunctionName()));
        }
    }

    /* renamed from: b */
    private String m41193b(Intent intent) {
        Uri data;
        String path;
        if (!this.f57367f.shouldHandleDeeplinking() || (data = intent.getData()) == null || (path = data.getPath()) == null || path.isEmpty()) {
            return null;
        }
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + RConfigConstants.KEYWORD_COLOR_SIGN + data.getFragment();
    }

    /* renamed from: a */
    private void m41191a(final FlutterView flutterView) {
        if (this.f57367f.getRenderMode() == RenderMode.surface) {
            if (this.f57366a != null) {
                flutterView.getViewTreeObserver().removeOnPreDrawListener(this.f57366a);
            }
            this.f57366a = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegate.this.f57372k && FlutterActivityAndFragmentDelegate.this.f57366a != null) {
                        flutterView.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegate.this.f57366a = null;
                    }
                    return FlutterActivityAndFragmentDelegate.this.f57372k;
                }
            };
            flutterView.getViewTreeObserver().addOnPreDrawListener(this.f57366a);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo171966h() {
        Log.m41140v(f57362b, "onResume()");
        m41197s();
        this.f57368g.getLifecycleChannel().appIsResumed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo171967i() {
        Log.m41140v(f57362b, "onPostResume()");
        m41197s();
        if (this.f57368g != null) {
            mo171968j();
        } else {
            Log.m41142w(f57362b, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo171968j() {
        PlatformPlugin platformPlugin = this.f57370i;
        if (platformPlugin != null) {
            platformPlugin.updateSystemUiOverlays();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo171969k() {
        Log.m41140v(f57362b, "onPause()");
        m41197s();
        this.f57368g.getLifecycleChannel().appIsInactive();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo171970l() {
        Log.m41140v(f57362b, "onStop()");
        m41197s();
        this.f57368g.getLifecycleChannel().appIsPaused();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo171971m() {
        Log.m41140v(f57362b, "onDestroyView()");
        m41197s();
        if (this.f57366a != null) {
            this.f57369h.getViewTreeObserver().removeOnPreDrawListener(this.f57366a);
            this.f57366a = null;
        }
        this.f57369h.detachFromFlutterEngine();
        this.f57369h.removeOnFirstFrameRenderedListener(this.f57375n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo171960b(Bundle bundle) {
        Log.m41140v(f57362b, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        m41197s();
        if (this.f57367f.shouldRestoreAndSaveState()) {
            bundle.putByteArray("framework", this.f57368g.getRestorationChannel().getRestorationData());
        }
        if (this.f57367f.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.f57368g.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(f57364d, bundle2);
        }
    }

    public void detachFromFlutterEngine() {
        if (!this.f57367f.shouldDestroyEngineWithHost()) {
            this.f57367f.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f57367f + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo171972n() {
        Log.m41140v(f57362b, "onDetach()");
        m41197s();
        this.f57367f.cleanUpFlutterEngine(this.f57368g);
        if (this.f57367f.shouldAttachEngineToActivity()) {
            Log.m41140v(f57362b, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f57367f.getActivity().isChangingConfigurations()) {
                this.f57368g.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.f57368g.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin = this.f57370i;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.f57370i = null;
        }
        this.f57368g.getLifecycleChannel().appIsDetached();
        if (this.f57367f.shouldDestroyEngineWithHost()) {
            this.f57368g.destroy();
            if (this.f57367f.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.f57367f.getCachedEngineId());
            }
            this.f57368g = null;
        }
        this.f57374m = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo171973o() {
        m41197s();
        if (this.f57368g != null) {
            Log.m41140v(f57362b, "Forwarding onBackPressed() to FlutterEngine.");
            this.f57368g.getNavigationChannel().popRoute();
            return;
        }
        Log.m41142w(f57362b, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171955a(int i, String[] strArr, int[] iArr) {
        m41197s();
        if (this.f57368g != null) {
            Log.m41140v(f57362b, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.f57368g.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.m41142w(f57362b, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171957a(Intent intent) {
        m41197s();
        if (this.f57368g != null) {
            Log.m41140v(f57362b, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.f57368g.getActivityControlSurface().onNewIntent(intent);
            String b = m41193b(intent);
            if (b != null && !b.isEmpty()) {
                this.f57368g.getNavigationChannel().pushRoute(b);
                return;
            }
            return;
        }
        Log.m41142w(f57362b, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171954a(int i, int i2, Intent intent) {
        m41197s();
        if (this.f57368g != null) {
            Log.m41140v(f57362b, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.f57368g.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.m41142w(f57362b, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo171974p() {
        m41197s();
        if (this.f57368g != null) {
            Log.m41140v(f57362b, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f57368g.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.m41142w(f57362b, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171953a(int i) {
        m41197s();
        if (this.f57368g != null) {
            if (this.f57373l && i >= 10) {
                this.f57368g.getDartExecutor().notifyLowMemoryWarning();
                this.f57368g.getSystemChannel().sendMemoryPressureWarning();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo171975q() {
        Log.m41140v(f57362b, "Forwarding onLowMemory() to FlutterEngine.");
        m41197s();
        this.f57368g.getDartExecutor().notifyLowMemoryWarning();
        this.f57368g.getSystemChannel().sendMemoryPressureWarning();
    }

    /* renamed from: s */
    private void m41197s() {
        if (this.f57367f == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }
}
