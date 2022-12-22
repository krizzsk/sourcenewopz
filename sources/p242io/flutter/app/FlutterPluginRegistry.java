package p242io.flutter.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.PluginRegistry;
import p242io.flutter.plugin.platform.PlatformViewRegistry;
import p242io.flutter.plugin.platform.PlatformViewsController;
import p242io.flutter.view.FlutterMain;
import p242io.flutter.view.FlutterNativeView;
import p242io.flutter.view.FlutterView;
import p242io.flutter.view.TextureRegistry;

@Deprecated
/* renamed from: io.flutter.app.FlutterPluginRegistry */
public class FlutterPluginRegistry implements PluginRegistry, PluginRegistry.ActivityResultListener, PluginRegistry.NewIntentListener, PluginRegistry.RequestPermissionsResultListener, PluginRegistry.UserLeaveHintListener, PluginRegistry.ViewDestroyListener {

    /* renamed from: a */
    private static final String f57325a = "FlutterPluginRegistry";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Activity f57326b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f57327c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FlutterNativeView f57328d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterView f57329e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final PlatformViewsController f57330f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Map<String, Object> f57331g = new LinkedHashMap(0);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final List<PluginRegistry.RequestPermissionsResultListener> f57332h = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final List<PluginRegistry.ActivityResultListener> f57333i = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final List<PluginRegistry.NewIntentListener> f57334j = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final List<PluginRegistry.UserLeaveHintListener> f57335k = new ArrayList(0);
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final List<PluginRegistry.ViewDestroyListener> f57336l = new ArrayList(0);

    public FlutterPluginRegistry(FlutterNativeView flutterNativeView, Context context) {
        this.f57328d = flutterNativeView;
        this.f57327c = context;
        this.f57330f = new PlatformViewsController();
    }

    public FlutterPluginRegistry(FlutterEngine flutterEngine, Context context) {
        this.f57327c = context;
        this.f57330f = new PlatformViewsController();
    }

    public boolean hasPlugin(String str) {
        return this.f57331g.containsKey(str);
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.f57331g.get(str);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        if (!this.f57331g.containsKey(str)) {
            this.f57331g.put(str, (Object) null);
            return new FlutterRegistrar(str);
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    public void attach(FlutterView flutterView, Activity activity) {
        this.f57329e = flutterView;
        this.f57326b = activity;
        this.f57330f.attach(activity, flutterView, flutterView.getDartExecutor());
    }

    public void detach() {
        this.f57330f.detach();
        this.f57330f.onDetachedFromJNI();
        this.f57329e = null;
        this.f57326b = null;
    }

    public void onPreEngineRestart() {
        this.f57330f.onPreEngineRestart();
    }

    public PlatformViewsController getPlatformViewsController() {
        return this.f57330f;
    }

    /* renamed from: io.flutter.app.FlutterPluginRegistry$FlutterRegistrar */
    private class FlutterRegistrar implements PluginRegistry.Registrar {
        private final String pluginKey;

        FlutterRegistrar(String str) {
            this.pluginKey = str;
        }

        public Activity activity() {
            return FlutterPluginRegistry.this.f57326b;
        }

        public Context context() {
            return FlutterPluginRegistry.this.f57327c;
        }

        public Context activeContext() {
            return FlutterPluginRegistry.this.f57326b != null ? FlutterPluginRegistry.this.f57326b : FlutterPluginRegistry.this.f57327c;
        }

        public BinaryMessenger messenger() {
            return FlutterPluginRegistry.this.f57328d;
        }

        public TextureRegistry textures() {
            return FlutterPluginRegistry.this.f57329e;
        }

        public PlatformViewRegistry platformViewRegistry() {
            return FlutterPluginRegistry.this.f57330f.getRegistry();
        }

        public FlutterView view() {
            return FlutterPluginRegistry.this.f57329e;
        }

        public String lookupKeyForAsset(String str) {
            return FlutterMain.getLookupKeyForAsset(str);
        }

        public String lookupKeyForAsset(String str, String str2) {
            return FlutterMain.getLookupKeyForAsset(str, str2);
        }

        public PluginRegistry.Registrar publish(Object obj) {
            FlutterPluginRegistry.this.f57331g.put(this.pluginKey, obj);
            return this;
        }

        public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            FlutterPluginRegistry.this.f57332h.add(requestPermissionsResultListener);
            return this;
        }

        public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            FlutterPluginRegistry.this.f57333i.add(activityResultListener);
            return this;
        }

        public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            FlutterPluginRegistry.this.f57334j.add(newIntentListener);
            return this;
        }

        public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            FlutterPluginRegistry.this.f57335k.add(userLeaveHintListener);
            return this;
        }

        public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
            FlutterPluginRegistry.this.f57336l.add(viewDestroyListener);
            return this;
        }
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        for (PluginRegistry.RequestPermissionsResultListener onRequestPermissionsResult : this.f57332h) {
            if (onRequestPermissionsResult.onRequestPermissionsResult(i, strArr, iArr)) {
                return true;
            }
        }
        return false;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        for (PluginRegistry.ActivityResultListener onActivityResult : this.f57333i) {
            if (onActivityResult.onActivityResult(i, i2, intent)) {
                return true;
            }
        }
        return false;
    }

    public boolean onNewIntent(Intent intent) {
        for (PluginRegistry.NewIntentListener onNewIntent : this.f57334j) {
            if (onNewIntent.onNewIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    public void onUserLeaveHint() {
        for (PluginRegistry.UserLeaveHintListener onUserLeaveHint : this.f57335k) {
            onUserLeaveHint.onUserLeaveHint();
        }
    }

    public boolean onViewDestroy(FlutterNativeView flutterNativeView) {
        boolean z = false;
        for (PluginRegistry.ViewDestroyListener onViewDestroy : this.f57336l) {
            if (onViewDestroy.onViewDestroy(flutterNativeView)) {
                z = true;
            }
        }
        return z;
    }

    public void destroy() {
        this.f57330f.onDetachedFromJNI();
    }
}
