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
import com.didi.flutter.nacho.Nacho;
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

/* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate2 */
class FlutterActivityAndFragmentDelegate2 implements ExclusiveAppComponent<Activity> {

    /* renamed from: b */
    private static final String f57376b = "FlutterActivityAndFragmentDelegate";

    /* renamed from: c */
    private static final String f57377c = "framework";

    /* renamed from: d */
    private static final String f57378d = "plugins";

    /* renamed from: e */
    private static final int f57379e = 486947586;

    /* renamed from: a */
    ViewTreeObserver.OnPreDrawListener f57380a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Host f57381f;

    /* renamed from: g */
    private FlutterEngine f57382g;

    /* renamed from: h */
    private FlutterView3 f57383h;

    /* renamed from: i */
    private PlatformPlugin f57384i;

    /* renamed from: j */
    private boolean f57385j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f57386k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f57387l;

    /* renamed from: m */
    private boolean f57388m;

    /* renamed from: n */
    private final FlutterUiDisplayListener f57389n = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegate2.this.f57381f.onFlutterUiDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate2.this.f57386k = true;
            boolean unused2 = FlutterActivityAndFragmentDelegate2.this.f57387l = true;
        }

        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegate2.this.f57381f.onFlutterUiNoLongerDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegate2.this.f57386k = false;
        }
    };

    /* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegate2$Host */
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

    FlutterActivityAndFragmentDelegate2(Host host) {
        this.f57381f = host;
        this.f57387l = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171978a() {
        this.f57381f = null;
        this.f57382g = null;
        this.f57383h = null;
        this.f57384i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public FlutterEngine mo171985b() {
        return this.f57382g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo171987c() {
        return this.f57385j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo171988d() {
        return this.f57388m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171982a(Context context) {
        m41230s();
        if (this.f57382g == null) {
            mo171990f();
        }
        if (this.f57381f.shouldAttachEngineToActivity()) {
            Log.m41140v(f57376b, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f57382g.getActivityControlSurface().attachToActivity(this, this.f57381f.getLifecycle());
        }
        Host host = this.f57381f;
        this.f57384i = host.providePlatformPlugin(host.getActivity(), this.f57382g);
        this.f57381f.configureFlutterEngine(this.f57382g);
        this.f57388m = true;
    }

    /* renamed from: e */
    public Activity getAppComponent() {
        Activity activity = this.f57381f.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo171990f() {
        Log.m41140v(f57376b, "Setting up FlutterEngine.");
        String cachedEngineId = this.f57381f.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.f57382g = flutterEngine;
            this.f57385j = true;
            if (flutterEngine == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host = this.f57381f;
        FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
        this.f57382g = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.f57385j = true;
            return;
        }
        Log.m41140v(f57376b, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f57382g = new FlutterEngine(this.f57381f.getContext(), this.f57381f.getFlutterShellArgs().toArray(), false, this.f57381f.shouldRestoreAndSaveState());
        this.f57385j = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo171977a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        Log.m41140v(f57376b, "Creating FlutterView.");
        m41230s();
        boolean z2 = true;
        if (this.f57381f.getRenderMode() == RenderMode.surface) {
            Context context = this.f57381f.getContext();
            if (this.f57381f.getTransparencyMode() != TransparencyMode.transparent) {
                z2 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z2);
            this.f57381f.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.f57383h = new FlutterView3(this.f57381f.getContext(), flutterSurfaceView);
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.f57381f.getContext());
            if (this.f57381f.getTransparencyMode() != TransparencyMode.opaque) {
                z2 = false;
            }
            flutterTextureView.setOpaque(z2);
            this.f57381f.onFlutterTextureViewCreated(flutterTextureView);
            this.f57383h = new FlutterView3(this.f57381f.getContext(), flutterTextureView);
        }
        this.f57383h.addOnFirstFrameRenderedListener(this.f57389n);
        Log.m41140v(f57376b, "Attaching FlutterEngine to FlutterView.");
        this.f57383h.attachToFlutterEngine(this.f57382g);
        this.f57383h.setId(i);
        SplashScreen provideSplashScreen = this.f57381f.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.m41142w(f57376b, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashView2 flutterSplashView2 = new FlutterSplashView2(this.f57381f.getContext());
            flutterSplashView2.setId(ViewUtils.generateViewId(f57379e));
            flutterSplashView2.mo172161a(this.f57383h, provideSplashScreen);
            return flutterSplashView2;
        }
        if (z) {
            m41224a(this.f57383h);
        }
        return this.f57383h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171984a(Bundle bundle) {
        Bundle bundle2;
        Log.m41140v(f57376b, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        m41230s();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(f57378d);
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f57381f.shouldRestoreAndSaveState()) {
            this.f57382g.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.f57381f.shouldAttachEngineToActivity()) {
            this.f57382g.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo171991g() {
        Log.m41140v(f57376b, "onStart()");
        m41230s();
        m41229r();
    }

    /* renamed from: r */
    private void m41229r() {
        if (this.f57381f.getCachedEngineId() == null && !this.f57382g.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.f57381f.getInitialRoute();
            if (initialRoute == null && (initialRoute = m41226b(this.f57381f.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.m41140v(f57376b, "Executing Dart entrypoint: " + this.f57381f.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.f57382g.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.f57381f.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.f57382g.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.f57381f.getDartEntrypointFunctionName()));
        }
    }

    /* renamed from: b */
    private String m41226b(Intent intent) {
        Uri data;
        String path;
        if (!this.f57381f.shouldHandleDeeplinking() || (data = intent.getData()) == null || (path = data.getPath()) == null || path.isEmpty()) {
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
    private void m41224a(final FlutterView3 flutterView3) {
        if (this.f57381f.getRenderMode() == RenderMode.surface) {
            if (this.f57380a != null) {
                flutterView3.getViewTreeObserver().removeOnPreDrawListener(this.f57380a);
            }
            this.f57380a = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegate2.this.f57386k && FlutterActivityAndFragmentDelegate2.this.f57380a != null) {
                        flutterView3.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegate2.this.f57380a = null;
                    }
                    return FlutterActivityAndFragmentDelegate2.this.f57386k;
                }
            };
            flutterView3.getViewTreeObserver().addOnPreDrawListener(this.f57380a);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo171992h() {
        Log.m41140v(f57376b, "onResume()");
        m41230s();
        this.f57383h.attachToRenderer();
        this.f57383h.fixViewSize();
        this.f57382g.getLifecycleChannel().appIsResumed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo171993i() {
        Log.m41140v(f57376b, "onPostResume()");
        m41230s();
        if (this.f57382g != null) {
            mo171994j();
        } else {
            Log.m41142w(f57376b, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo171994j() {
        PlatformPlugin platformPlugin = this.f57384i;
        if (platformPlugin != null) {
            platformPlugin.updateSystemUiOverlays();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo171995k() {
        Log.m41140v(f57376b, "onPause()");
        m41230s();
        if (Nacho.getInstance().isPaddingOpenContainer()) {
            this.f57383h.detachFromRenderer();
        }
        this.f57382g.getLifecycleChannel().appIsInactive();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo171996l() {
        Log.m41140v(f57376b, "onStop()");
        m41230s();
        this.f57382g.getLifecycleChannel().appIsPaused();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo171997m() {
        Log.m41140v(f57376b, "onDestroyView()");
        m41230s();
        if (this.f57380a != null) {
            this.f57383h.getViewTreeObserver().removeOnPreDrawListener(this.f57380a);
            this.f57380a = null;
        }
        this.f57383h.detachFromFlutterEngine();
        this.f57383h.removeOnFirstFrameRenderedListener(this.f57389n);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo171986b(Bundle bundle) {
        Log.m41140v(f57376b, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        m41230s();
        if (this.f57381f.shouldRestoreAndSaveState()) {
            bundle.putByteArray("framework", this.f57382g.getRestorationChannel().getRestorationData());
        }
        if (this.f57381f.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.f57382g.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(f57378d, bundle2);
        }
    }

    public void detachFromFlutterEngine() {
        if (!this.f57381f.shouldDestroyEngineWithHost()) {
            this.f57381f.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f57381f + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo171998n() {
        Log.m41140v(f57376b, "onDetach()");
        m41230s();
        this.f57381f.cleanUpFlutterEngine(this.f57382g);
        if (this.f57381f.shouldAttachEngineToActivity()) {
            Log.m41140v(f57376b, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f57381f.getActivity().isChangingConfigurations()) {
                this.f57382g.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.f57382g.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin = this.f57384i;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.f57384i = null;
        }
        this.f57382g.getLifecycleChannel().appIsDetached();
        if (this.f57381f.shouldDestroyEngineWithHost()) {
            this.f57382g.destroy();
            if (this.f57381f.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.f57381f.getCachedEngineId());
            }
            this.f57382g = null;
        }
        this.f57388m = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo171999o() {
        m41230s();
        if (this.f57382g != null) {
            Log.m41140v(f57376b, "Forwarding onBackPressed() to FlutterEngine.");
            this.f57382g.getNavigationChannel().popRoute();
            return;
        }
        Log.m41142w(f57376b, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171981a(int i, String[] strArr, int[] iArr) {
        m41230s();
        if (this.f57382g != null) {
            Log.m41140v(f57376b, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.f57382g.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.m41142w(f57376b, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171983a(Intent intent) {
        m41230s();
        if (this.f57382g != null) {
            Log.m41140v(f57376b, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.f57382g.getActivityControlSurface().onNewIntent(intent);
            String b = m41226b(intent);
            if (b != null && !b.isEmpty()) {
                this.f57382g.getNavigationChannel().pushRoute(b);
                return;
            }
            return;
        }
        Log.m41142w(f57376b, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171980a(int i, int i2, Intent intent) {
        m41230s();
        if (this.f57382g != null) {
            Log.m41140v(f57376b, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.f57382g.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.m41142w(f57376b, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public void mo172000p() {
        m41230s();
        if (this.f57382g != null) {
            Log.m41140v(f57376b, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f57382g.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.m41142w(f57376b, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo171979a(int i) {
        m41230s();
        if (this.f57382g != null) {
            if (this.f57387l && i >= 10) {
                this.f57382g.getDartExecutor().notifyLowMemoryWarning();
                this.f57382g.getSystemChannel().sendMemoryPressureWarning();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public void mo172001q() {
        Log.m41140v(f57376b, "Forwarding onLowMemory() to FlutterEngine.");
        m41230s();
        this.f57382g.getDartExecutor().notifyLowMemoryWarning();
        this.f57382g.getSystemChannel().sendMemoryPressureWarning();
    }

    /* renamed from: s */
    private void m41230s() {
        if (this.f57381f == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }
}
