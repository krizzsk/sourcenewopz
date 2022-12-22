package p242io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p242io.flutter.FlutterInjector;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import p242io.flutter.embedding.engine.loader.FlutterLoader;
import p242io.flutter.embedding.engine.plugins.PluginRegistry;
import p242io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import p242io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import p242io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import p242io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import p242io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister;
import p242io.flutter.embedding.engine.renderer.FlutterRenderer;
import p242io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import p242io.flutter.embedding.engine.systemchannels.DeferredComponentChannel;
import p242io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import p242io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import p242io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import p242io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import p242io.flutter.embedding.engine.systemchannels.NavigationChannel;
import p242io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p242io.flutter.embedding.engine.systemchannels.RestorationChannel;
import p242io.flutter.embedding.engine.systemchannels.SettingsChannel;
import p242io.flutter.embedding.engine.systemchannels.SystemChannel;
import p242io.flutter.embedding.engine.systemchannels.TextInputChannel;
import p242io.flutter.plugin.localization.LocalizationPlugin;
import p242io.flutter.plugin.platform.PlatformViewsController;

/* renamed from: io.flutter.embedding.engine.FlutterEngine */
public class FlutterEngine {

    /* renamed from: a */
    private static final String f57558a = "FlutterEngine";

    /* renamed from: b */
    private final FlutterJNI f57559b;

    /* renamed from: c */
    private final FlutterRenderer f57560c;

    /* renamed from: d */
    private final DartExecutor f57561d;

    /* renamed from: e */
    private final FlutterEngineConnectionRegistry f57562e;

    /* renamed from: f */
    private final LocalizationPlugin f57563f;

    /* renamed from: g */
    private final AccessibilityChannel f57564g;

    /* renamed from: h */
    private final DeferredComponentChannel f57565h;

    /* renamed from: i */
    private final KeyEventChannel f57566i;

    /* renamed from: j */
    private final LifecycleChannel f57567j;

    /* renamed from: k */
    private final LocalizationChannel f57568k;

    /* renamed from: l */
    private final MouseCursorChannel f57569l;

    /* renamed from: m */
    private final NavigationChannel f57570m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final RestorationChannel f57571n;

    /* renamed from: o */
    private final PlatformChannel f57572o;

    /* renamed from: p */
    private final SettingsChannel f57573p;

    /* renamed from: q */
    private final SystemChannel f57574q;

    /* renamed from: r */
    private final TextInputChannel f57575r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public final PlatformViewsController f57576s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public final Set<EngineLifecycleListener> f57577t;

    /* renamed from: u */
    private final EngineLifecycleListener f57578u;

    /* renamed from: io.flutter.embedding.engine.FlutterEngine$EngineLifecycleListener */
    public interface EngineLifecycleListener {
        void onEngineWillDestroy();

        void onPreEngineRestart();
    }

    public FlutterEngine(Context context) {
        this(context, (String[]) null);
    }

    public FlutterEngine(Context context, String[] strArr) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, true);
    }

    public FlutterEngine(Context context, String[] strArr, boolean z) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, strArr, z);
    }

    public FlutterEngine(Context context, String[] strArr, boolean z, boolean z2) {
        this(context, (FlutterLoader) null, (FlutterJNI) null, new PlatformViewsController(), strArr, z, z2);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI) {
        this(context, flutterLoader, flutterJNI, (String[]) null, true);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, new PlatformViewsController(), strArr, z);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] strArr, boolean z) {
        this(context, flutterLoader, flutterJNI, platformViewsController, strArr, z, false);
    }

    public FlutterEngine(Context context, FlutterLoader flutterLoader, FlutterJNI flutterJNI, PlatformViewsController platformViewsController, String[] strArr, boolean z, boolean z2) {
        AssetManager assetManager;
        this.f57577t = new HashSet();
        this.f57578u = new EngineLifecycleListener() {
            public void onEngineWillDestroy() {
            }

            public void onPreEngineRestart() {
                Log.m41140v(FlutterEngine.f57558a, "onPreEngineRestart()");
                for (EngineLifecycleListener onPreEngineRestart : FlutterEngine.this.f57577t) {
                    onPreEngineRestart.onPreEngineRestart();
                }
                FlutterEngine.this.f57576s.onPreEngineRestart();
                FlutterEngine.this.f57571n.clearData();
            }
        };
        try {
            assetManager = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assetManager = context.getAssets();
        }
        FlutterInjector instance = FlutterInjector.instance();
        flutterJNI = flutterJNI == null ? instance.getFlutterJNIFactory().provideFlutterJNI() : flutterJNI;
        this.f57559b = flutterJNI;
        DartExecutor dartExecutor = new DartExecutor(flutterJNI, assetManager);
        this.f57561d = dartExecutor;
        dartExecutor.onAttachedToJNI();
        DeferredComponentManager deferredComponentManager = FlutterInjector.instance().deferredComponentManager();
        this.f57564g = new AccessibilityChannel(this.f57561d, flutterJNI);
        this.f57565h = new DeferredComponentChannel(this.f57561d);
        this.f57566i = new KeyEventChannel(this.f57561d);
        this.f57567j = new LifecycleChannel(this.f57561d);
        this.f57568k = new LocalizationChannel(this.f57561d);
        this.f57569l = new MouseCursorChannel(this.f57561d);
        this.f57570m = new NavigationChannel(this.f57561d);
        this.f57572o = new PlatformChannel(this.f57561d);
        this.f57571n = new RestorationChannel(this.f57561d, z2);
        this.f57573p = new SettingsChannel(this.f57561d);
        this.f57574q = new SystemChannel(this.f57561d);
        this.f57575r = new TextInputChannel(this.f57561d);
        if (deferredComponentManager != null) {
            deferredComponentManager.setDeferredComponentChannel(this.f57565h);
        }
        this.f57563f = new LocalizationPlugin(context, this.f57568k);
        flutterLoader = flutterLoader == null ? instance.flutterLoader() : flutterLoader;
        if (!flutterJNI.isAttached()) {
            flutterLoader.startInitialization(context.getApplicationContext());
            flutterLoader.ensureInitializationComplete(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.f57578u);
        flutterJNI.setPlatformViewsController(platformViewsController);
        flutterJNI.setLocalizationPlugin(this.f57563f);
        flutterJNI.setDeferredComponentManager(instance.deferredComponentManager());
        if (!flutterJNI.isAttached()) {
            m41413a();
        }
        this.f57560c = new FlutterRenderer(flutterJNI);
        this.f57576s = platformViewsController;
        platformViewsController.onAttachedToJNI();
        this.f57562e = new FlutterEngineConnectionRegistry(context.getApplicationContext(), this, flutterLoader);
        if (z && flutterLoader.automaticallyRegisterPlugins()) {
            GeneratedPluginRegister.registerGeneratedPlugins(this);
        }
    }

    /* renamed from: a */
    private void m41413a() {
        Log.m41140v(f57558a, "Attaching to JNI.");
        this.f57559b.attachToNative();
        if (!m41415b()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    /* renamed from: b */
    private boolean m41415b() {
        return this.f57559b.isAttached();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public FlutterEngine mo172312a(Context context, DartExecutor.DartEntrypoint dartEntrypoint, String str, List<String> list) {
        if (m41415b()) {
            return new FlutterEngine(context, (FlutterLoader) null, this.f57559b.spawn(dartEntrypoint.dartEntrypointFunctionName, dartEntrypoint.dartEntrypointLibrary, str, list));
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    public void destroy() {
        Log.m41140v(f57558a, "Destroying.");
        for (EngineLifecycleListener onEngineWillDestroy : this.f57577t) {
            onEngineWillDestroy.onEngineWillDestroy();
        }
        this.f57562e.mo172344a();
        this.f57576s.onDetachedFromJNI();
        this.f57561d.onDetachedFromJNI();
        this.f57559b.removeEngineLifecycleListener(this.f57578u);
        this.f57559b.setDeferredComponentManager((DeferredComponentManager) null);
        this.f57559b.detachFromNativeAndReleaseResources();
        if (FlutterInjector.instance().deferredComponentManager() != null) {
            FlutterInjector.instance().deferredComponentManager().destroy();
            this.f57565h.setDeferredComponentManager((DeferredComponentManager) null);
        }
    }

    public void addEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener) {
        this.f57577t.add(engineLifecycleListener);
    }

    public void removeEngineLifecycleListener(EngineLifecycleListener engineLifecycleListener) {
        this.f57577t.remove(engineLifecycleListener);
    }

    public DartExecutor getDartExecutor() {
        return this.f57561d;
    }

    public FlutterRenderer getRenderer() {
        return this.f57560c;
    }

    public AccessibilityChannel getAccessibilityChannel() {
        return this.f57564g;
    }

    public KeyEventChannel getKeyEventChannel() {
        return this.f57566i;
    }

    public LifecycleChannel getLifecycleChannel() {
        return this.f57567j;
    }

    public LocalizationChannel getLocalizationChannel() {
        return this.f57568k;
    }

    public NavigationChannel getNavigationChannel() {
        return this.f57570m;
    }

    public PlatformChannel getPlatformChannel() {
        return this.f57572o;
    }

    public RestorationChannel getRestorationChannel() {
        return this.f57571n;
    }

    public SettingsChannel getSettingsChannel() {
        return this.f57573p;
    }

    public DeferredComponentChannel getDeferredComponentChannel() {
        return this.f57565h;
    }

    public SystemChannel getSystemChannel() {
        return this.f57574q;
    }

    public MouseCursorChannel getMouseCursorChannel() {
        return this.f57569l;
    }

    public TextInputChannel getTextInputChannel() {
        return this.f57575r;
    }

    public PluginRegistry getPlugins() {
        return this.f57562e;
    }

    public LocalizationPlugin getLocalizationPlugin() {
        return this.f57563f;
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.f57576s;
    }

    public ActivityControlSurface getActivityControlSurface() {
        return this.f57562e;
    }

    public ServiceControlSurface getServiceControlSurface() {
        return this.f57562e;
    }

    public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface() {
        return this.f57562e;
    }

    public ContentProviderControlSurface getContentProviderControlSurface() {
        return this.f57562e;
    }
}
