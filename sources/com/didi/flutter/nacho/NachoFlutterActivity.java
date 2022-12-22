package com.didi.flutter.nacho;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.embedding.android.FlutterActivity2;
import p242io.flutter.embedding.android.FlutterSurfaceView;
import p242io.flutter.embedding.android.FlutterTextureView;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.renderer.RenderSurface;
import p242io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p242io.flutter.plugin.platform.PlatformPlugin;

public class NachoFlutterActivity extends FlutterActivity2 implements INachoApp {
    public static final String ENGINE_ID = "_engine_id";
    public static final String PARAMS = "_params";
    public static final String THEME = "_theme";

    /* renamed from: a */
    static WeakReference<PlatformChannel.PlatformMessageHandler> f21090a;

    /* renamed from: b */
    private String f21091b;

    /* renamed from: c */
    private String f21092c;

    /* renamed from: d */
    private RenderSurface f21093d;

    /* renamed from: e */
    private PlatformChannel.PlatformMessageHandler f21094e;

    public String getCachedEngineId() {
        return null;
    }

    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        Logger logger = Nacho.logger();
        logger.debug("onCreate:" + this, new Object[0]);
        int intExtra = getIntent().getIntExtra(THEME, 0);
        if (intExtra != 0) {
            setTheme(intExtra);
        }
        String stringExtra = getIntent().getStringExtra(ENGINE_ID);
        this.f21092c = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.f21092c = Nacho.getInstance().cachedEngineId();
        }
        super.onCreate(bundle);
        this.f21091b = SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("initial_route", getInitialRoute());
        ((NachoPlugin) Nacho.getInstance().getPlugin(NachoPlugin.class)).sendLifecycleEvent(this.f21091b, NachoLifecycleManager.LIFECYCLE_ON_CREATE, this.f21092c, hashMap, getNachoParams());
    }

    public static CachedEngineIntentBuilder2 withCachedEngine(Class<? extends FlutterActivity2> cls) {
        return new CachedEngineIntentBuilder2(cls);
    }

    static class CachedEngineIntentBuilder2 extends FlutterActivity2.NewEngineIntentBuilder {
        private String engineId;
        private HashMap<String, String> params;
        private int theme;

        protected CachedEngineIntentBuilder2(Class<? extends FlutterActivity2> cls) {
            super(cls);
        }

        public CachedEngineIntentBuilder2 engineId(String str) {
            this.engineId = str;
            return this;
        }

        public CachedEngineIntentBuilder2 params(HashMap<String, String> hashMap) {
            this.params = hashMap;
            return this;
        }

        public Intent build(Context context) {
            Intent build = super.build(context);
            build.putExtra("destroy_engine_with_activity", false);
            build.putExtra(NachoFlutterActivity.PARAMS, this.params);
            build.putExtra(NachoFlutterActivity.THEME, this.theme);
            build.putExtra(NachoFlutterActivity.ENGINE_ID, this.engineId);
            return build;
        }

        public CachedEngineIntentBuilder2 theme(int i) {
            this.theme = i;
            return this;
        }
    }

    public HashMap<String, String> getNachoParams() {
        return (HashMap) getIntent().getSerializableExtra(PARAMS);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        Logger logger = Nacho.logger();
        logger.debug("onStart:" + this, new Object[0]);
        super.onStart();
    }

    public FlutterEngine provideFlutterEngine(Context context) {
        return Nacho.getInstance().getEngine(this.f21092c);
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        PlatformPlugin providePlatformPlugin = super.providePlatformPlugin(activity, flutterEngine);
        try {
            PlatformChannel platformChannel = flutterEngine.getPlatformChannel();
            Field declaredField = platformChannel.getClass().getDeclaredField("platformMessageHandler");
            declaredField.setAccessible(true);
            this.f21094e = (PlatformChannel.PlatformMessageHandler) declaredField.get(platformChannel);
            PrintStream printStream = System.out;
            printStream.println("======providePlatformPlugin======:" + this.f21094e);
        } catch (Exception e) {
            Nacho.logger().error("get platformMessageHandler error", (Throwable) e);
        }
        return providePlatformPlugin;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Logger logger = Nacho.logger();
        logger.debug("onResume:" + this, new Object[0]);
        super.onResume();
        ((NachoPlugin) Nacho.getInstance().getPlugin(NachoPlugin.class)).sendLifecycleEvent(this.f21091b, "onResume", this.f21092c, (Map<String, String>) null, (Map<String, String>) null);
        f21090a = new WeakReference<>(this.f21094e);
        m15527a(getFlutterEngine());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        Logger logger = Nacho.logger();
        logger.debug("onStop:" + this, new Object[0]);
        if (f21090a.get() == this.f21094e) {
            f21090a.clear();
        }
        super.onStop();
        m15526a();
    }

    public void fixRenderer() {
        FlutterEngine flutterEngine = getFlutterEngine();
        if (flutterEngine == null) {
            Nacho.logger().debug("fixRenderer:: Flutter Engine is no longer available, fixRenderer can't be execute", new Object[0]);
            return;
        }
        Logger logger = Nacho.logger();
        logger.debug("fixRenderer:" + this + ",renderSurface:" + this.f21093d + ",render:" + flutterEngine.getRenderer(), new Object[0]);
        RenderSurface renderSurface = this.f21093d;
        if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f21093d.getAttachedRenderer().isDisplayingFlutterUi()) {
            this.f21093d.attachToRenderer(flutterEngine.getRenderer());
        }
        flutterEngine.getLifecycleChannel().appIsResumed();
    }

    /* renamed from: a */
    private void m15527a(FlutterEngine flutterEngine) {
        PlatformChannel.PlatformMessageHandler platformMessageHandler = (PlatformChannel.PlatformMessageHandler) f21090a.get();
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

    /* access modifiers changed from: protected */
    public void onPause() {
        Logger logger = Nacho.logger();
        logger.debug("onPause:" + this, new Object[0]);
        super.onPause();
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView);
        this.f21093d = flutterSurfaceView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterSurfaceViewCreated:" + this + ",renderSurface:" + this.f21093d, new Object[0]);
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.f21093d = flutterTextureView;
        Logger logger = Nacho.logger();
        logger.debug("onFlutterTextureViewCreated:" + this + ",renderSurface:" + this.f21093d, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Logger logger = Nacho.logger();
        logger.debug("onDestroy:" + this, new Object[0]);
        ((NachoPlugin) Nacho.getInstance().getPlugin(NachoPlugin.class)).sendLifecycleEvent(this.f21091b, NachoLifecycleManager.LIFECYCLE_ON_DESTROY, this.f21092c, (Map<String, String>) null, (Map<String, String>) null);
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        m15527a(flutterEngine);
        m15526a();
    }

    /* renamed from: a */
    private void m15526a() {
        INachoApp topContainer = Nacho.getInstance().getTopContainer();
        if (topContainer != null) {
            topContainer.fixRenderer();
        }
    }

    public String toString() {
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(Page.TAG_ROUTER_NAME) : "";
        return super.toString() + " [pageId=" + this.f21091b + ",routerName=" + stringExtra + Const.jaRight;
    }
}
