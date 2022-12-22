package com.didi.flutter.nacho2.p115v2.container;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.didi.flutter.nacho2.p115v2.NachoAction;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import p242io.flutter.embedding.android.FlutterActivityV1;
import p242io.flutter.embedding.android.FlutterSurfaceView;
import p242io.flutter.embedding.android.FlutterTextureView;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.renderer.RenderSurface;
import p242io.flutter.embedding.engine.systemchannels.PlatformChannel;
import p242io.flutter.plugin.platform.PlatformPlugin;

/* renamed from: com.didi.flutter.nacho2.v2.container.NachoFlutterActivity */
public abstract class NachoFlutterActivity extends FlutterActivityV1 {

    /* renamed from: a */
    static WeakReference<PlatformChannel.PlatformMessageHandler> f21151a;

    /* renamed from: b */
    private String f21152b;

    /* renamed from: c */
    private PlatformChannel.PlatformMessageHandler f21153c;

    /* renamed from: d */
    private RenderSurface f21154d;

    public abstract HashMap<String, Object> provideExtParams();

    public abstract String provideInitialRoute();

    public abstract NachoAction provideNachoAction();

    public FlutterEngine provideFlutterEngine(Context context) {
        return provideNachoAction().getEngine();
    }

    public String getInitialRoute() {
        return provideInitialRoute();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f21152b = SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode());
        HashMap hashMap = new HashMap();
        hashMap.put("initial_route", getInitialRoute());
        NachoLifecycleManager.sendLifecycleOnCreate(provideNachoAction(), this.f21152b, hashMap, provideExtParams());
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        NachoLifecycleManager.sendLifecycleOnResume(provideNachoAction(), this.f21152b);
        f21151a = new WeakReference<>(this.f21153c);
        m15565a(getFlutterEngine());
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        if (f21151a.get() == this.f21153c) {
            f21151a.clear();
        }
        super.onStop();
        m15564a();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        NachoLifecycleManager.sendLifecycleOnDestroy(provideNachoAction(), this.f21152b);
        FlutterEngine flutterEngine = getFlutterEngine();
        super.onDestroy();
        m15565a(flutterEngine);
        m15564a();
    }

    public void onFlutterSurfaceViewCreated(FlutterSurfaceView flutterSurfaceView) {
        super.onFlutterSurfaceViewCreated(flutterSurfaceView);
        this.f21154d = flutterSurfaceView;
    }

    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.f21154d = flutterTextureView;
    }

    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        PlatformPlugin providePlatformPlugin = super.providePlatformPlugin(activity, flutterEngine);
        try {
            PlatformChannel platformChannel = flutterEngine.getPlatformChannel();
            Field declaredField = platformChannel.getClass().getDeclaredField("platformMessageHandler");
            declaredField.setAccessible(true);
            this.f21153c = (PlatformChannel.PlatformMessageHandler) declaredField.get(platformChannel);
            PrintStream printStream = System.out;
            printStream.println("======providePlatformPlugin======:" + this.f21153c);
        } catch (Exception unused) {
        }
        return providePlatformPlugin;
    }

    /* renamed from: a */
    private void m15565a(FlutterEngine flutterEngine) {
        PlatformChannel.PlatformMessageHandler platformMessageHandler = (PlatformChannel.PlatformMessageHandler) f21151a.get();
        if (platformMessageHandler != null && flutterEngine != null) {
            try {
                flutterEngine.getPlatformChannel().setPlatformMessageHandler(platformMessageHandler);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private void m15564a() {
        NachoFlutterActivity topContainer = NachoActivityManager.getInstance().getTopContainer();
        if (topContainer != null) {
            topContainer.m15566b();
        }
    }

    /* renamed from: b */
    private void m15566b() {
        FlutterEngine flutterEngine = getFlutterEngine();
        if (flutterEngine != null) {
            RenderSurface renderSurface = this.f21154d;
            if ((renderSurface != null && renderSurface.getAttachedRenderer() == null) || !this.f21154d.getAttachedRenderer().isDisplayingFlutterUi()) {
                this.f21154d.attachToRenderer(flutterEngine.getRenderer());
            }
            flutterEngine.getLifecycleChannel().appIsResumed();
        }
    }

    public String getPageId() {
        return this.f21152b;
    }
}
