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
import com.didi.flutter.nacho2.p115v2.container.NachoActivityManager;
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

/* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegateV1 */
class FlutterActivityAndFragmentDelegateV1 implements ExclusiveAppComponent<Activity> {

    /* renamed from: b */
    private static final String f57390b = "FlutterActivityAndFragmentDelegate";

    /* renamed from: c */
    private static final String f57391c = "framework";

    /* renamed from: d */
    private static final String f57392d = "plugins";

    /* renamed from: e */
    private static final int f57393e = 486947586;

    /* renamed from: a */
    ViewTreeObserver.OnPreDrawListener f57394a;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Host f57395f;

    /* renamed from: g */
    private FlutterEngine f57396g;

    /* renamed from: h */
    private FlutterViewV1 f57397h;

    /* renamed from: i */
    private PlatformPlugin f57398i;

    /* renamed from: j */
    private boolean f57399j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f57400k;

    /* renamed from: l */
    private final FlutterUiDisplayListener f57401l = new FlutterUiDisplayListener() {
        public void onFlutterUiDisplayed() {
            FlutterActivityAndFragmentDelegateV1.this.f57395f.onFlutterUiDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegateV1.this.f57400k = true;
        }

        public void onFlutterUiNoLongerDisplayed() {
            FlutterActivityAndFragmentDelegateV1.this.f57395f.onFlutterUiNoLongerDisplayed();
            boolean unused = FlutterActivityAndFragmentDelegateV1.this.f57400k = false;
        }
    };

    /* renamed from: io.flutter.embedding.android.FlutterActivityAndFragmentDelegateV1$Host */
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
    }

    FlutterActivityAndFragmentDelegateV1(Host host) {
        this.f57395f = host;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172004a() {
        this.f57395f = null;
        this.f57396g = null;
        this.f57397h = null;
        this.f57398i = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public FlutterEngine mo172011b() {
        return this.f57396g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo172013c() {
        return this.f57399j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172008a(Context context) {
        m41262q();
        if (this.f57396g == null) {
            mo172015e();
        }
        if (this.f57395f.shouldAttachEngineToActivity()) {
            Log.m41140v(f57390b, "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f57396g.getActivityControlSurface().attachToActivity(this, this.f57395f.getLifecycle());
        }
        Host host = this.f57395f;
        this.f57398i = host.providePlatformPlugin(host.getActivity(), this.f57396g);
        this.f57395f.configureFlutterEngine(this.f57396g);
    }

    /* renamed from: d */
    public Activity getAppComponent() {
        Activity activity = this.f57395f.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo172015e() {
        Log.m41140v(f57390b, "Setting up FlutterEngine.");
        String cachedEngineId = this.f57395f.getCachedEngineId();
        if (cachedEngineId != null) {
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get(cachedEngineId);
            this.f57396g = flutterEngine;
            this.f57399j = true;
            if (flutterEngine == null) {
                throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + cachedEngineId + "'");
            }
            return;
        }
        Host host = this.f57395f;
        FlutterEngine provideFlutterEngine = host.provideFlutterEngine(host.getContext());
        this.f57396g = provideFlutterEngine;
        if (provideFlutterEngine != null) {
            this.f57399j = true;
            return;
        }
        Log.m41140v(f57390b, "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
        this.f57396g = new FlutterEngine(this.f57395f.getContext(), this.f57395f.getFlutterShellArgs().toArray(), false, this.f57395f.shouldRestoreAndSaveState());
        this.f57399j = false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo172003a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i, boolean z) {
        Log.m41140v(f57390b, "Creating FlutterView.");
        m41262q();
        boolean z2 = true;
        if (this.f57395f.getRenderMode() == RenderMode.surface) {
            Context context = this.f57395f.getContext();
            if (this.f57395f.getTransparencyMode() != TransparencyMode.transparent) {
                z2 = false;
            }
            FlutterSurfaceView flutterSurfaceView = new FlutterSurfaceView(context, z2);
            this.f57395f.onFlutterSurfaceViewCreated(flutterSurfaceView);
            this.f57397h = new FlutterViewV1(this.f57395f.getContext(), flutterSurfaceView);
        } else {
            FlutterTextureView flutterTextureView = new FlutterTextureView(this.f57395f.getContext());
            if (this.f57395f.getTransparencyMode() != TransparencyMode.opaque) {
                z2 = false;
            }
            flutterTextureView.setOpaque(z2);
            this.f57395f.onFlutterTextureViewCreated(flutterTextureView);
            this.f57397h = new FlutterViewV1(this.f57395f.getContext(), flutterTextureView);
        }
        this.f57397h.addOnFirstFrameRenderedListener(this.f57401l);
        Log.m41140v(f57390b, "Attaching FlutterEngine to FlutterView.");
        this.f57397h.attachToFlutterEngine(this.f57396g);
        this.f57397h.setId(i);
        SplashScreen provideSplashScreen = this.f57395f.provideSplashScreen();
        if (provideSplashScreen != null) {
            Log.m41142w(f57390b, "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            FlutterSplashViewV1 flutterSplashViewV1 = new FlutterSplashViewV1(this.f57395f.getContext());
            flutterSplashViewV1.setId(ViewUtils.generateViewId(f57393e));
            flutterSplashViewV1.mo172168a(this.f57397h, provideSplashScreen);
            return flutterSplashViewV1;
        }
        if (z) {
            m41257a(this.f57397h);
        }
        return this.f57397h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172010a(Bundle bundle) {
        Bundle bundle2;
        Log.m41140v(f57390b, "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        m41262q();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle(f57392d);
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f57395f.shouldRestoreAndSaveState()) {
            this.f57396g.getRestorationChannel().setRestorationData(bArr);
        }
        if (this.f57395f.shouldAttachEngineToActivity()) {
            this.f57396g.getActivityControlSurface().onRestoreInstanceState(bundle2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo172016f() {
        Log.m41140v(f57390b, "onStart()");
        m41262q();
        m41261p();
    }

    /* renamed from: p */
    private void m41261p() {
        if (this.f57395f.getCachedEngineId() == null && !this.f57396g.getDartExecutor().isExecutingDart()) {
            String initialRoute = this.f57395f.getInitialRoute();
            if (initialRoute == null && (initialRoute = m41259b(this.f57395f.getActivity().getIntent())) == null) {
                initialRoute = "/";
            }
            Log.m41140v(f57390b, "Executing Dart entrypoint: " + this.f57395f.getDartEntrypointFunctionName() + ", and sending initial route: " + initialRoute);
            this.f57396g.getNavigationChannel().setInitialRoute(initialRoute);
            String appBundlePath = this.f57395f.getAppBundlePath();
            if (appBundlePath == null || appBundlePath.isEmpty()) {
                appBundlePath = FlutterInjector.instance().flutterLoader().findAppBundlePath();
            }
            this.f57396g.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(appBundlePath, this.f57395f.getDartEntrypointFunctionName()));
        }
    }

    /* renamed from: b */
    private String m41259b(Intent intent) {
        Uri data;
        if (!this.f57395f.shouldHandleDeeplinking() || (data = intent.getData()) == null || data.getPath().isEmpty()) {
            return null;
        }
        String path = data.getPath();
        if (data.getQuery() != null && !data.getQuery().isEmpty()) {
            path = path + "?" + data.getQuery();
        }
        if (data.getFragment() == null || data.getFragment().isEmpty()) {
            return path;
        }
        return path + RConfigConstants.KEYWORD_COLOR_SIGN + data.getFragment();
    }

    /* renamed from: a */
    private void m41257a(final FlutterViewV1 flutterViewV1) {
        if (this.f57395f.getRenderMode() == RenderMode.surface) {
            if (this.f57394a != null) {
                flutterViewV1.getViewTreeObserver().removeOnPreDrawListener(this.f57394a);
            }
            this.f57394a = new ViewTreeObserver.OnPreDrawListener() {
                public boolean onPreDraw() {
                    if (FlutterActivityAndFragmentDelegateV1.this.f57400k && FlutterActivityAndFragmentDelegateV1.this.f57394a != null) {
                        flutterViewV1.getViewTreeObserver().removeOnPreDrawListener(this);
                        FlutterActivityAndFragmentDelegateV1.this.f57394a = null;
                    }
                    return FlutterActivityAndFragmentDelegateV1.this.f57400k;
                }
            };
            flutterViewV1.getViewTreeObserver().addOnPreDrawListener(this.f57394a);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo172017g() {
        Log.m41140v(f57390b, "onResume()");
        m41262q();
        this.f57397h.attachToRenderer();
        this.f57396g.getLifecycleChannel().appIsResumed();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo172018h() {
        Log.m41140v(f57390b, "onPostResume()");
        m41262q();
        if (this.f57396g != null) {
            PlatformPlugin platformPlugin = this.f57398i;
            if (platformPlugin != null) {
                platformPlugin.updateSystemUiOverlays();
                return;
            }
            return;
        }
        Log.m41142w(f57390b, "onPostResume() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo172019i() {
        Log.m41140v(f57390b, "onPause()");
        m41262q();
        if (NachoActivityManager.getInstance().isPaddingOpenContainer()) {
            this.f57397h.detachFromRenderer();
        }
        this.f57396g.getLifecycleChannel().appIsInactive();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo172020j() {
        Log.m41140v(f57390b, "onStop()");
        m41262q();
        this.f57396g.getLifecycleChannel().appIsPaused();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo172021k() {
        Log.m41140v(f57390b, "onDestroyView()");
        m41262q();
        if (this.f57394a != null) {
            this.f57397h.getViewTreeObserver().removeOnPreDrawListener(this.f57394a);
            this.f57394a = null;
        }
        this.f57397h.detachFromFlutterEngine();
        this.f57397h.removeOnFirstFrameRenderedListener(this.f57401l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo172012b(Bundle bundle) {
        Log.m41140v(f57390b, "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        m41262q();
        if (this.f57395f.shouldRestoreAndSaveState()) {
            bundle.putByteArray("framework", this.f57396g.getRestorationChannel().getRestorationData());
        }
        if (this.f57395f.shouldAttachEngineToActivity()) {
            Bundle bundle2 = new Bundle();
            this.f57396g.getActivityControlSurface().onSaveInstanceState(bundle2);
            bundle.putBundle(f57392d, bundle2);
        }
    }

    public void detachFromFlutterEngine() {
        if (!this.f57395f.shouldDestroyEngineWithHost()) {
            this.f57395f.detachFromFlutterEngine();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f57395f + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo172022l() {
        Log.m41140v(f57390b, "onDetach()");
        m41262q();
        this.f57395f.cleanUpFlutterEngine(this.f57396g);
        if (this.f57395f.shouldAttachEngineToActivity()) {
            Log.m41140v(f57390b, "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.f57395f.getActivity().isChangingConfigurations()) {
                this.f57396g.getActivityControlSurface().detachFromActivityForConfigChanges();
            } else {
                this.f57396g.getActivityControlSurface().detachFromActivity();
            }
        }
        PlatformPlugin platformPlugin = this.f57398i;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.f57398i = null;
        }
        this.f57396g.getLifecycleChannel().appIsDetached();
        if (this.f57395f.shouldDestroyEngineWithHost()) {
            this.f57396g.destroy();
            if (this.f57395f.getCachedEngineId() != null) {
                FlutterEngineCache.getInstance().remove(this.f57395f.getCachedEngineId());
            }
            this.f57396g = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo172023m() {
        m41262q();
        if (this.f57396g != null) {
            Log.m41140v(f57390b, "Forwarding onBackPressed() to FlutterEngine.");
            this.f57396g.getNavigationChannel().popRoute();
            return;
        }
        Log.m41142w(f57390b, "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172007a(int i, String[] strArr, int[] iArr) {
        m41262q();
        if (this.f57396g != null) {
            Log.m41140v(f57390b, "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
            this.f57396g.getActivityControlSurface().onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        Log.m41142w(f57390b, "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172009a(Intent intent) {
        m41262q();
        if (this.f57396g != null) {
            Log.m41140v(f57390b, "Forwarding onNewIntent() to FlutterEngine and sending pushRoute message.");
            this.f57396g.getActivityControlSurface().onNewIntent(intent);
            String b = m41259b(intent);
            if (b != null && !b.isEmpty()) {
                this.f57396g.getNavigationChannel().pushRoute(b);
                return;
            }
            return;
        }
        Log.m41142w(f57390b, "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172006a(int i, int i2, Intent intent) {
        m41262q();
        if (this.f57396g != null) {
            Log.m41140v(f57390b, "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i + "\nresultCode: " + i2 + "\ndata: " + intent);
            this.f57396g.getActivityControlSurface().onActivityResult(i, i2, intent);
            return;
        }
        Log.m41142w(f57390b, "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public void mo172024n() {
        m41262q();
        if (this.f57396g != null) {
            Log.m41140v(f57390b, "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.f57396g.getActivityControlSurface().onUserLeaveHint();
            return;
        }
        Log.m41142w(f57390b, "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo172005a(int i) {
        m41262q();
        FlutterEngine flutterEngine = this.f57396g;
        if (flutterEngine != null) {
            flutterEngine.getDartExecutor().notifyLowMemoryWarning();
            if (i == 10) {
                Log.m41140v(f57390b, "Forwarding onTrimMemory() to FlutterEngine. Level: " + i);
                this.f57396g.getSystemChannel().sendMemoryPressureWarning();
                return;
            }
            return;
        }
        Log.m41142w(f57390b, "onTrimMemory() invoked before FlutterFragment was attached to an Activity.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: o */
    public void mo172025o() {
        Log.m41140v(f57390b, "Forwarding onLowMemory() to FlutterEngine.");
        m41262q();
        this.f57396g.getDartExecutor().notifyLowMemoryWarning();
        this.f57396g.getSystemChannel().sendMemoryPressureWarning();
    }

    /* renamed from: q */
    private void m41262q() {
        if (this.f57395f == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }
}
