package com.didi.flutter.nacho;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.logging.Logger;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.embedding.android.FlutterFragment2;
import p242io.flutter.embedding.android.FlutterSurfaceView;
import p242io.flutter.embedding.android.FlutterTextureView;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.renderer.RenderSurface;
import p242io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p242io.flutter.plugin.platform.PlatformPlugin;

public class NachoFlutterFragment extends FlutterFragment2 implements INachoApp {

    /* renamed from: a */
    private String f21095a;

    /* renamed from: b */
    private RenderSurface f21096b;

    /* renamed from: c */
    private PlatformChannel.PlatformMessageHandler f21097c;

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        Logger logger = Nacho.logger();
        logger.debug("onCreate:" + this, new Object[0]);
        super.onCreate(bundle);
        this.f21095a = SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("initial_route", getInitialRoute());
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f21095a, NachoLifecycleManager.LIFECYCLE_ON_CREATE, getCachedEngineId(), hashMap, getParams());
    }

    public Map getParams() {
        return (Map) getArguments().getSerializable(NachoFlutterActivity.PARAMS);
    }

    public void onStart() {
        Logger logger = Nacho.logger();
        logger.debug("onStart:" + this, new Object[0]);
        super.onStart();
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        PlatformPlugin providePlatformPlugin = super.providePlatformPlugin(activity, flutterEngine);
        try {
            PlatformChannel platformChannel = flutterEngine.getPlatformChannel();
            Field declaredField = platformChannel.getClass().getDeclaredField("platformMessageHandler");
            declaredField.setAccessible(true);
            this.f21097c = (PlatformChannel.PlatformMessageHandler) declaredField.get(platformChannel);
            PrintStream printStream = System.out;
            printStream.println("======providePlatformPlugin======:" + this.f21097c);
        } catch (Exception e) {
            Nacho.logger().error("get platformMessageHandler error", (Throwable) e);
        }
        return providePlatformPlugin;
    }

    public void onResume() {
        Logger logger = Nacho.logger();
        logger.debug("onResume:" + this, new Object[0]);
        super.onResume();
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f21095a, "onResume", getCachedEngineId(), (Map<String, String>) null, (Map<String, String>) null);
        NachoFlutterActivity.f21090a = new WeakReference<>(this.f21097c);
        m15528a(getFlutterEngine());
    }

    public void onStop() {
        Logger logger = Nacho.logger();
        logger.debug("onStop:" + this, new Object[0]);
        if (NachoFlutterActivity.f21090a.get() == this.f21097c) {
            NachoFlutterActivity.f21090a.clear();
        }
        super.onStop();
        m15529c();
    }

    public void fixRenderer() {
        FlutterEngine flutterEngine = getFlutterEngine();
        if (flutterEngine == null) {
            Nacho.logger().debug("fixRenderer:: Flutter Engine is no longer available, fixRenderer can't be execute", new Object[0]);
            return;
        }
        Logger logger = Nacho.logger();
        logger.debug("fixRenderer:" + this + ",renderSurface:" + this.f21096b + ",render:" + flutterEngine.getRenderer(), new Object[0]);
        RenderSurface renderSurface = this.f21096b;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f21096b.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f21096b.attachToRenderer(flutterEngine.getRenderer());
        }
        flutterEngine.getLifecycleChannel().appIsResumed();
    }

    /* renamed from: a */
    private void m15528a(FlutterEngine flutterEngine) {
        PlatformChannel.PlatformMessageHandler platformMessageHandler = (PlatformChannel.PlatformMessageHandler) NachoFlutterActivity.f21090a.get();
        if (platformMessageHandler != null && flutterEngine != null) {
            try {
                flutterEngine.getPlatformChannel().setPlatformMessageHandler(platformMessageHandler);
                Logger logger = Nacho.logger();
                logger.debug("fixPlatformMessageHandler:" + platformMessageHandler, new Object[0]);
            } catch (Exception e) {
                Nacho.logger().error("get platformMessageHandler error", (Throwable) e);
            }
        }
    }

    public void onPause() {
        Logger logger = Nacho.logger();
        logger.debug("onPause:" + this, new Object[0]);
        super.onPause();
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView);
        this.f21096b = flutterSurfaceView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterSurfaceViewCreated:" + this + ",renderSurface:" + this.f21096b, new Object[0]);
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.f21096b = flutterTextureView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterTextureViewCreated:" + this + ",renderSurface:" + this.f21096b, new Object[0]);
    }

    public void onDestroy() {
        Logger logger = Nacho.logger();
        logger.debug("onDestroy:" + this, new Object[0]);
        ((NachoPlugin) Nacho.getInstance().getPlugin(getFlutterEngine(), (Class<? extends FlutterPlugin>) NachoPlugin.class)).sendLifecycleEvent(this.f21095a, NachoLifecycleManager.LIFECYCLE_ON_DESTROY, getCachedEngineId(), (Map<String, String>) null, (Map<String, String>) null);
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        m15528a(flutterEngine);
        m15529c();
    }

    /* renamed from: c */
    private void m15529c() {
        INachoApp topContainer = Nacho.getInstance().getTopContainer();
        if (topContainer != null && !(topContainer instanceof NachoFlutterFragment)) {
            topContainer.fixRenderer();
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        RenderSurface renderSurface = this.f21096b;
        if (renderSurface instanceof FlutterSurfaceView) {
            ((FlutterSurfaceView) renderSurface).setVisibility(z ? 8 : 0);
        }
    }

    public String toString() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(Page.TAG_ROUTER_NAME) : "";
        return super.toString() + " [pageId=" + this.f21095a + ",routerName=" + string + Const.jaRight;
    }

    public static CachedEngineFragmentBuilder2 withCachedEngine(Class<? extends FlutterFragment2> cls) {
        return new CachedEngineFragmentBuilder2(cls);
    }

    public static class CachedEngineFragmentBuilder2 extends FlutterFragment2.NewEngineFragmentBuilder {
        private String engineId = (SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode()));
        private final Class<? extends FlutterFragment2> fragmentClass;
        private HashMap params;
        private int theme;

        protected CachedEngineFragmentBuilder2(Class<? extends FlutterFragment2> cls) {
            super(cls);
            this.fragmentClass = cls;
        }

        public CachedEngineFragmentBuilder2 engineId(String str) {
            this.engineId = str;
            return this;
        }

        public CachedEngineFragmentBuilder2 params(HashMap hashMap) {
            this.params = hashMap;
            return this;
        }

        public CachedEngineFragmentBuilder2 theme(int i) {
            this.theme = i;
            return this;
        }

        public <T extends FlutterFragment2> T build() {
            try {
                T t = (FlutterFragment2) this.fragmentClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                if (t != null) {
                    Bundle createArgs = createArgs();
                    createArgs.putString("cached_engine_id", this.engineId);
                    t.setArguments(createArgs);
                    Nacho.getInstance().addFlutterFragment(t);
                    return t;
                }
                throw new RuntimeException("The FlutterFragment2 subclass sent in the constructor (" + NachoFlutterFragment.class.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate FlutterFragment2 subclass (" + NachoFlutterFragment.class.getName() + ")", e);
            }
        }
    }
}
