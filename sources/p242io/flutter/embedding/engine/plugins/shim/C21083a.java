package p242io.flutter.embedding.engine.plugins.shim;

import android.app.Activity;
import android.content.Context;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p242io.flutter.FlutterInjector;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.PluginRegistry;
import p242io.flutter.plugin.platform.PlatformViewRegistry;
import p242io.flutter.view.FlutterNativeView;
import p242io.flutter.view.FlutterView;
import p242io.flutter.view.TextureRegistry;

/* renamed from: io.flutter.embedding.engine.plugins.shim.a */
/* compiled from: ShimRegistrar */
class C21083a implements FlutterPlugin, ActivityAware, PluginRegistry.Registrar {

    /* renamed from: a */
    private static final String f57681a = "ShimRegistrar";

    /* renamed from: b */
    private final Map<String, Object> f57682b;

    /* renamed from: c */
    private final String f57683c;

    /* renamed from: d */
    private final Set<PluginRegistry.ViewDestroyListener> f57684d = new HashSet();

    /* renamed from: e */
    private final Set<PluginRegistry.RequestPermissionsResultListener> f57685e = new HashSet();

    /* renamed from: f */
    private final Set<PluginRegistry.ActivityResultListener> f57686f = new HashSet();

    /* renamed from: g */
    private final Set<PluginRegistry.NewIntentListener> f57687g = new HashSet();

    /* renamed from: h */
    private final Set<PluginRegistry.UserLeaveHintListener> f57688h = new HashSet();

    /* renamed from: i */
    private FlutterPlugin.FlutterPluginBinding f57689i;

    /* renamed from: j */
    private ActivityPluginBinding f57690j;

    public C21083a(String str, Map<String, Object> map) {
        this.f57683c = str;
        this.f57682b = map;
    }

    public Activity activity() {
        ActivityPluginBinding activityPluginBinding = this.f57690j;
        if (activityPluginBinding != null) {
            return activityPluginBinding.getActivity();
        }
        return null;
    }

    public Context context() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f57689i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getApplicationContext();
        }
        return null;
    }

    public Context activeContext() {
        return this.f57690j == null ? context() : activity();
    }

    public BinaryMessenger messenger() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f57689i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getBinaryMessenger();
        }
        return null;
    }

    public TextureRegistry textures() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f57689i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getTextureRegistry();
        }
        return null;
    }

    public PlatformViewRegistry platformViewRegistry() {
        FlutterPlugin.FlutterPluginBinding flutterPluginBinding = this.f57689i;
        if (flutterPluginBinding != null) {
            return flutterPluginBinding.getPlatformViewRegistry();
        }
        return null;
    }

    public FlutterView view() {
        throw new UnsupportedOperationException("The new embedding does not support the old FlutterView.");
    }

    public String lookupKeyForAsset(String str) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str);
    }

    public String lookupKeyForAsset(String str, String str2) {
        return FlutterInjector.instance().flutterLoader().getLookupKeyForAsset(str, str2);
    }

    public PluginRegistry.Registrar publish(Object obj) {
        this.f57682b.put(this.f57683c, obj);
        return this;
    }

    public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
        this.f57685e.add(requestPermissionsResultListener);
        ActivityPluginBinding activityPluginBinding = this.f57690j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addRequestPermissionsResultListener(requestPermissionsResultListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
        this.f57686f.add(activityResultListener);
        ActivityPluginBinding activityPluginBinding = this.f57690j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(activityResultListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
        this.f57687g.add(newIntentListener);
        ActivityPluginBinding activityPluginBinding = this.f57690j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addOnNewIntentListener(newIntentListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
        this.f57688h.add(userLeaveHintListener);
        ActivityPluginBinding activityPluginBinding = this.f57690j;
        if (activityPluginBinding != null) {
            activityPluginBinding.addOnUserLeaveHintListener(userLeaveHintListener);
        }
        return this;
    }

    public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener viewDestroyListener) {
        this.f57684d.add(viewDestroyListener);
        return this;
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.m41140v(f57681a, "Attached to FlutterEngine.");
        this.f57689i = flutterPluginBinding;
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Log.m41140v(f57681a, "Detached from FlutterEngine.");
        for (PluginRegistry.ViewDestroyListener onViewDestroy : this.f57684d) {
            onViewDestroy.onViewDestroy((FlutterNativeView) null);
        }
        this.f57689i = null;
        this.f57690j = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        Log.m41140v(f57681a, "Attached to an Activity.");
        this.f57690j = activityPluginBinding;
        m41473a();
    }

    public void onDetachedFromActivityForConfigChanges() {
        Log.m41140v(f57681a, "Detached from an Activity for config changes.");
        this.f57690j = null;
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        Log.m41140v(f57681a, "Reconnected to an Activity after config changes.");
        this.f57690j = activityPluginBinding;
        m41473a();
    }

    public void onDetachedFromActivity() {
        Log.m41140v(f57681a, "Detached from an Activity.");
        this.f57690j = null;
    }

    /* renamed from: a */
    private void m41473a() {
        for (PluginRegistry.RequestPermissionsResultListener addRequestPermissionsResultListener : this.f57685e) {
            this.f57690j.addRequestPermissionsResultListener(addRequestPermissionsResultListener);
        }
        for (PluginRegistry.ActivityResultListener addActivityResultListener : this.f57686f) {
            this.f57690j.addActivityResultListener(addActivityResultListener);
        }
        for (PluginRegistry.NewIntentListener addOnNewIntentListener : this.f57687g) {
            this.f57690j.addOnNewIntentListener(addOnNewIntentListener);
        }
        for (PluginRegistry.UserLeaveHintListener addOnUserLeaveHintListener : this.f57688h) {
            this.f57690j.addOnUserLeaveHintListener(addOnUserLeaveHintListener);
        }
    }
}
