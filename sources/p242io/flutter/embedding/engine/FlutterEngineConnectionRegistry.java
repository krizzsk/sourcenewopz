package p242io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import p242io.flutter.Log;
import p242io.flutter.embedding.android.ExclusiveAppComponent;
import p242io.flutter.embedding.engine.loader.FlutterLoader;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.PluginRegistry;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import p242io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import p242io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverPluginBinding;
import p242io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import p242io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import p242io.flutter.embedding.engine.plugins.contentprovider.ContentProviderPluginBinding;
import p242io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import p242io.flutter.embedding.engine.plugins.service.ServiceAware;
import p242io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import p242io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import p242io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry */
class FlutterEngineConnectionRegistry implements PluginRegistry, ActivityControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface, ServiceControlSurface {

    /* renamed from: a */
    private static final String f57581a = "FlutterEngineCxnRegstry";

    /* renamed from: b */
    private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> f57582b = new HashMap();

    /* renamed from: c */
    private final FlutterEngine f57583c;

    /* renamed from: d */
    private final FlutterPlugin.FlutterPluginBinding f57584d;

    /* renamed from: e */
    private final Map<Class<? extends FlutterPlugin>, ActivityAware> f57585e = new HashMap();

    /* renamed from: f */
    private ExclusiveAppComponent<Activity> f57586f;

    /* renamed from: g */
    private FlutterEngineActivityPluginBinding f57587g;

    /* renamed from: h */
    private boolean f57588h = false;

    /* renamed from: i */
    private final Map<Class<? extends FlutterPlugin>, ServiceAware> f57589i = new HashMap();

    /* renamed from: j */
    private Service f57590j;

    /* renamed from: k */
    private FlutterEngineServicePluginBinding f57591k;

    /* renamed from: l */
    private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> f57592l = new HashMap();

    /* renamed from: m */
    private BroadcastReceiver f57593m;

    /* renamed from: n */
    private FlutterEngineBroadcastReceiverPluginBinding f57594n;

    /* renamed from: o */
    private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> f57595o = new HashMap();

    /* renamed from: p */
    private ContentProvider f57596p;

    /* renamed from: q */
    private FlutterEngineContentProviderPluginBinding f57597q;

    FlutterEngineConnectionRegistry(Context context, FlutterEngine flutterEngine, FlutterLoader flutterLoader) {
        this.f57583c = flutterEngine;
        this.f57584d = new FlutterPlugin.FlutterPluginBinding(context, flutterEngine, flutterEngine.getDartExecutor(), flutterEngine.getRenderer(), flutterEngine.getPlatformViewsController().getRegistry(), new DefaultFlutterAssets(flutterLoader));
    }

    /* renamed from: a */
    public void mo172344a() {
        Log.m41140v(f57581a, "Destroying.");
        m41419b();
        removeAll();
    }

    public void add(FlutterPlugin flutterPlugin) {
        Trace.beginSection("FlutterEngineConnectionRegistry#add " + flutterPlugin.getClass().getSimpleName());
        try {
            if (has(flutterPlugin.getClass())) {
                Log.m41142w(f57581a, "Attempted to register plugin (" + flutterPlugin + ") but it was already registered with this FlutterEngine (" + this.f57583c + ").");
                return;
            }
            Log.m41140v(f57581a, "Adding plugin: " + flutterPlugin);
            this.f57582b.put(flutterPlugin.getClass(), flutterPlugin);
            flutterPlugin.onAttachedToEngine(this.f57584d);
            if (flutterPlugin instanceof ActivityAware) {
                ActivityAware activityAware = (ActivityAware) flutterPlugin;
                this.f57585e.put(flutterPlugin.getClass(), activityAware);
                if (m41420c()) {
                    activityAware.onAttachedToActivity(this.f57587g);
                }
            }
            if (flutterPlugin instanceof ServiceAware) {
                ServiceAware serviceAware = (ServiceAware) flutterPlugin;
                this.f57589i.put(flutterPlugin.getClass(), serviceAware);
                if (m41423f()) {
                    serviceAware.onAttachedToService(this.f57591k);
                }
            }
            if (flutterPlugin instanceof BroadcastReceiverAware) {
                BroadcastReceiverAware broadcastReceiverAware = (BroadcastReceiverAware) flutterPlugin;
                this.f57592l.put(flutterPlugin.getClass(), broadcastReceiverAware);
                if (m41424g()) {
                    broadcastReceiverAware.onAttachedToBroadcastReceiver(this.f57594n);
                }
            }
            if (flutterPlugin instanceof ContentProviderAware) {
                ContentProviderAware contentProviderAware = (ContentProviderAware) flutterPlugin;
                this.f57595o.put(flutterPlugin.getClass(), contentProviderAware);
                if (m41425h()) {
                    contentProviderAware.onAttachedToContentProvider(this.f57597q);
                }
            }
            Trace.endSection();
        } finally {
            Trace.endSection();
        }
    }

    public void add(Set<FlutterPlugin> set) {
        for (FlutterPlugin add : set) {
            add(add);
        }
    }

    public boolean has(Class<? extends FlutterPlugin> cls) {
        return this.f57582b.containsKey(cls);
    }

    public FlutterPlugin get(Class<? extends FlutterPlugin> cls) {
        return this.f57582b.get(cls);
    }

    public void remove(Class<? extends FlutterPlugin> cls) {
        FlutterPlugin flutterPlugin = this.f57582b.get(cls);
        if (flutterPlugin != null) {
            Trace.beginSection("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
            try {
                Log.m41140v(f57581a, "Removing plugin: " + flutterPlugin);
                if (flutterPlugin instanceof ActivityAware) {
                    if (m41420c()) {
                        ((ActivityAware) flutterPlugin).onDetachedFromActivity();
                    }
                    this.f57585e.remove(cls);
                }
                if (flutterPlugin instanceof ServiceAware) {
                    if (m41423f()) {
                        ((ServiceAware) flutterPlugin).onDetachedFromService();
                    }
                    this.f57589i.remove(cls);
                }
                if (flutterPlugin instanceof BroadcastReceiverAware) {
                    if (m41424g()) {
                        ((BroadcastReceiverAware) flutterPlugin).onDetachedFromBroadcastReceiver();
                    }
                    this.f57592l.remove(cls);
                }
                if (flutterPlugin instanceof ContentProviderAware) {
                    if (m41425h()) {
                        ((ContentProviderAware) flutterPlugin).onDetachedFromContentProvider();
                    }
                    this.f57595o.remove(cls);
                }
                flutterPlugin.onDetachedFromEngine(this.f57584d);
                this.f57582b.remove(cls);
            } finally {
                Trace.endSection();
            }
        }
    }

    public void remove(Set<Class<? extends FlutterPlugin>> set) {
        for (Class<? extends FlutterPlugin> remove : set) {
            remove(remove);
        }
    }

    public void removeAll() {
        remove((Set<Class<? extends FlutterPlugin>>) new HashSet(this.f57582b.keySet()));
        this.f57582b.clear();
    }

    /* renamed from: b */
    private void m41419b() {
        if (m41420c()) {
            detachFromActivity();
        } else if (m41423f()) {
            detachFromService();
        } else if (m41424g()) {
            detachFromBroadcastReceiver();
        } else if (m41425h()) {
            detachFromContentProvider();
        }
    }

    /* renamed from: c */
    private boolean m41420c() {
        return this.f57586f != null;
    }

    /* renamed from: d */
    private Activity m41421d() {
        ExclusiveAppComponent<Activity> exclusiveAppComponent = this.f57586f;
        if (exclusiveAppComponent != null) {
            return exclusiveAppComponent.getAppComponent();
        }
        return null;
    }

    public void attachToActivity(ExclusiveAppComponent<Activity> exclusiveAppComponent, Lifecycle lifecycle) {
        String str;
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Attaching to an exclusive Activity: ");
            sb.append(exclusiveAppComponent.getAppComponent());
            String str2 = "";
            if (m41420c()) {
                str = " evicting previous activity " + m41421d();
            } else {
                str = str2;
            }
            sb.append(str);
            sb.append(".");
            if (this.f57588h) {
                str2 = " This is after a config change.";
            }
            sb.append(str2);
            Log.m41140v(f57581a, sb.toString());
            if (this.f57586f != null) {
                this.f57586f.detachFromFlutterEngine();
            }
            m41419b();
            this.f57586f = exclusiveAppComponent;
            m41418a(exclusiveAppComponent.getAppComponent(), lifecycle);
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: a */
    private void m41418a(Activity activity, Lifecycle lifecycle) {
        this.f57587g = new FlutterEngineActivityPluginBinding(activity, lifecycle);
        this.f57583c.getPlatformViewsController().attach(activity, this.f57583c.getRenderer(), this.f57583c.getDartExecutor());
        for (ActivityAware next : this.f57585e.values()) {
            if (this.f57588h) {
                next.onReattachedToActivityForConfigChanges(this.f57587g);
            } else {
                next.onAttachedToActivity(this.f57587g);
            }
        }
        this.f57588h = false;
    }

    public void detachFromActivityForConfigChanges() {
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
            Log.m41140v(f57581a, "Detaching from an Activity for config changes: " + m41421d());
            try {
                this.f57588h = true;
                for (ActivityAware onDetachedFromActivityForConfigChanges : this.f57585e.values()) {
                    onDetachedFromActivityForConfigChanges.onDetachedFromActivityForConfigChanges();
                }
                m41422e();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    public void detachFromActivity() {
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromActivity");
            try {
                Log.m41140v(f57581a, "Detaching from an Activity: " + m41421d());
                for (ActivityAware onDetachedFromActivity : this.f57585e.values()) {
                    onDetachedFromActivity.onDetachedFromActivity();
                }
                m41422e();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to detach plugins from an Activity when no Activity was attached.");
        }
    }

    /* renamed from: e */
    private void m41422e() {
        this.f57583c.getPlatformViewsController().detach();
        this.f57586f = null;
        this.f57587g = null;
    }

    public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.m41140v(f57581a, "Forwarding onRequestPermissionsResult() to plugins.");
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
            try {
                return this.f57587g.onRequestPermissionsResult(i, strArr, iArr);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        Log.m41140v(f57581a, "Forwarding onActivityResult() to plugins.");
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onActivityResult");
            try {
                return this.f57587g.onActivityResult(i, i2, intent);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
    }

    public void onNewIntent(Intent intent) {
        Log.m41140v(f57581a, "Forwarding onNewIntent() to plugins.");
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onNewIntent");
            try {
                this.f57587g.onNewIntent(intent);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    public void onUserLeaveHint() {
        Log.m41140v(f57581a, "Forwarding onUserLeaveHint() to plugins.");
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onUserLeaveHint");
            try {
                this.f57587g.onUserLeaveHint();
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        Log.m41140v(f57581a, "Forwarding onSaveInstanceState() to plugins.");
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onSaveInstanceState");
            try {
                this.f57587g.onSaveInstanceState(bundle);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        Log.m41140v(f57581a, "Forwarding onRestoreInstanceState() to plugins.");
        if (m41420c()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onRestoreInstanceState");
            try {
                this.f57587g.onRestoreInstanceState(bundle);
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    /* renamed from: f */
    private boolean m41423f() {
        return this.f57590j != null;
    }

    public void attachToService(Service service, Lifecycle lifecycle, boolean z) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToService");
        Log.m41140v(f57581a, "Attaching to a Service: " + service);
        try {
            m41419b();
            this.f57590j = service;
            this.f57591k = new FlutterEngineServicePluginBinding(service, lifecycle);
            for (ServiceAware onAttachedToService : this.f57589i.values()) {
                onAttachedToService.onAttachedToService(this.f57591k);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void detachFromService() {
        if (m41423f()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromService");
            Log.m41140v(f57581a, "Detaching from a Service: " + this.f57590j);
            try {
                for (ServiceAware onDetachedFromService : this.f57589i.values()) {
                    onDetachedFromService.onDetachedFromService();
                }
                this.f57590j = null;
                this.f57591k = null;
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to detach plugins from a Service when no Service was attached.");
        }
    }

    public void onMoveToForeground() {
        if (m41423f()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onMoveToForeground");
            try {
                Log.m41140v(f57581a, "Attached Service moved to foreground.");
                this.f57591k.onMoveToForeground();
            } finally {
                Trace.endSection();
            }
        }
    }

    public void onMoveToBackground() {
        if (m41423f()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#onMoveToBackground");
            Log.m41140v(f57581a, "Attached Service moved to background.");
            try {
                this.f57591k.onMoveToBackground();
            } finally {
                Trace.endSection();
            }
        }
    }

    /* renamed from: g */
    private boolean m41424g() {
        return this.f57593m != null;
    }

    public void attachToBroadcastReceiver(BroadcastReceiver broadcastReceiver, Lifecycle lifecycle) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToBroadcastReceiver");
        Log.m41140v(f57581a, "Attaching to BroadcastReceiver: " + broadcastReceiver);
        try {
            m41419b();
            this.f57593m = broadcastReceiver;
            this.f57594n = new FlutterEngineBroadcastReceiverPluginBinding(broadcastReceiver);
            for (BroadcastReceiverAware onAttachedToBroadcastReceiver : this.f57592l.values()) {
                onAttachedToBroadcastReceiver.onAttachedToBroadcastReceiver(this.f57594n);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void detachFromBroadcastReceiver() {
        if (m41424g()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
            Log.m41140v(f57581a, "Detaching from BroadcastReceiver: " + this.f57593m);
            try {
                for (BroadcastReceiverAware onDetachedFromBroadcastReceiver : this.f57592l.values()) {
                    onDetachedFromBroadcastReceiver.onDetachedFromBroadcastReceiver();
                }
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
        }
    }

    /* renamed from: h */
    private boolean m41425h() {
        return this.f57596p != null;
    }

    public void attachToContentProvider(ContentProvider contentProvider, Lifecycle lifecycle) {
        Trace.beginSection("FlutterEngineConnectionRegistry#attachToContentProvider");
        Log.m41140v(f57581a, "Attaching to ContentProvider: " + contentProvider);
        try {
            m41419b();
            this.f57596p = contentProvider;
            this.f57597q = new FlutterEngineContentProviderPluginBinding(contentProvider);
            for (ContentProviderAware onAttachedToContentProvider : this.f57595o.values()) {
                onAttachedToContentProvider.onAttachedToContentProvider(this.f57597q);
            }
        } finally {
            Trace.endSection();
        }
    }

    public void detachFromContentProvider() {
        if (m41425h()) {
            Trace.beginSection("FlutterEngineConnectionRegistry#detachFromContentProvider");
            Log.m41140v(f57581a, "Detaching from ContentProvider: " + this.f57596p);
            try {
                for (ContentProviderAware onDetachedFromContentProvider : this.f57595o.values()) {
                    onDetachedFromContentProvider.onDetachedFromContentProvider();
                }
            } finally {
                Trace.endSection();
            }
        } else {
            Log.m41136e(f57581a, "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$DefaultFlutterAssets */
    private static class DefaultFlutterAssets implements FlutterPlugin.FlutterAssets {
        final FlutterLoader flutterLoader;

        private DefaultFlutterAssets(FlutterLoader flutterLoader2) {
            this.flutterLoader = flutterLoader2;
        }

        public String getAssetFilePathByName(String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        public String getAssetFilePathByName(String str, String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }

        public String getAssetFilePathBySubpath(String str) {
            return this.flutterLoader.getLookupKeyForAsset(str);
        }

        public String getAssetFilePathBySubpath(String str, String str2) {
            return this.flutterLoader.getLookupKeyForAsset(str, str2);
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineActivityPluginBinding */
    private static class FlutterEngineActivityPluginBinding implements ActivityPluginBinding {
        private final Activity activity;
        private final HiddenLifecycleReference hiddenLifecycleReference;
        private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
        private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
        private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
        private final Set<ActivityPluginBinding.OnSaveInstanceStateListener> onSaveInstanceStateListeners = new HashSet();
        private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();

        public FlutterEngineActivityPluginBinding(Activity activity2, Lifecycle lifecycle) {
            this.activity = activity2;
            this.hiddenLifecycleReference = new HiddenLifecycleReference(lifecycle);
        }

        public Activity getActivity() {
            return this.activity;
        }

        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public void addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.add(requestPermissionsResultListener);
        }

        public void removeRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener requestPermissionsResultListener) {
            this.onRequestPermissionsResultListeners.remove(requestPermissionsResultListener);
        }

        /* access modifiers changed from: package-private */
        public boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            Iterator<PluginRegistry.RequestPermissionsResultListener> it = this.onRequestPermissionsResultListeners.iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z;
                    }
                    if (it.next().onRequestPermissionsResult(i, strArr, iArr) || z) {
                        z = true;
                    }
                }
            }
        }

        public void addActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.add(activityResultListener);
        }

        public void removeActivityResultListener(PluginRegistry.ActivityResultListener activityResultListener) {
            this.onActivityResultListeners.remove(activityResultListener);
        }

        /* access modifiers changed from: package-private */
        public boolean onActivityResult(int i, int i2, Intent intent) {
            Iterator it = new HashSet(this.onActivityResultListeners).iterator();
            while (true) {
                boolean z = false;
                while (true) {
                    if (!it.hasNext()) {
                        return z;
                    }
                    if (((PluginRegistry.ActivityResultListener) it.next()).onActivityResult(i, i2, intent) || z) {
                        z = true;
                    }
                }
            }
        }

        public void addOnNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.add(newIntentListener);
        }

        public void removeOnNewIntentListener(PluginRegistry.NewIntentListener newIntentListener) {
            this.onNewIntentListeners.remove(newIntentListener);
        }

        /* access modifiers changed from: package-private */
        public void onNewIntent(Intent intent) {
            for (PluginRegistry.NewIntentListener onNewIntent : this.onNewIntentListeners) {
                onNewIntent.onNewIntent(intent);
            }
        }

        public void addOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.add(userLeaveHintListener);
        }

        public void removeOnUserLeaveHintListener(PluginRegistry.UserLeaveHintListener userLeaveHintListener) {
            this.onUserLeaveHintListeners.remove(userLeaveHintListener);
        }

        public void addOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.add(onSaveInstanceStateListener);
        }

        public void removeOnSaveStateListener(ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceStateListener) {
            this.onSaveInstanceStateListeners.remove(onSaveInstanceStateListener);
        }

        /* access modifiers changed from: package-private */
        public void onUserLeaveHint() {
            for (PluginRegistry.UserLeaveHintListener onUserLeaveHint : this.onUserLeaveHintListeners) {
                onUserLeaveHint.onUserLeaveHint();
            }
        }

        /* access modifiers changed from: package-private */
        public void onSaveInstanceState(Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onSaveInstanceState : this.onSaveInstanceStateListeners) {
                onSaveInstanceState.onSaveInstanceState(bundle);
            }
        }

        /* access modifiers changed from: package-private */
        public void onRestoreInstanceState(Bundle bundle) {
            for (ActivityPluginBinding.OnSaveInstanceStateListener onRestoreInstanceState : this.onSaveInstanceStateListeners) {
                onRestoreInstanceState.onRestoreInstanceState(bundle);
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineServicePluginBinding */
    private static class FlutterEngineServicePluginBinding implements ServicePluginBinding {
        private final HiddenLifecycleReference hiddenLifecycleReference;
        private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
        private final Service service;

        FlutterEngineServicePluginBinding(Service service2, Lifecycle lifecycle) {
            this.service = service2;
            this.hiddenLifecycleReference = lifecycle != null ? new HiddenLifecycleReference(lifecycle) : null;
        }

        public Service getService() {
            return this.service;
        }

        public Object getLifecycle() {
            return this.hiddenLifecycleReference;
        }

        public void addOnModeChangeListener(ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.add(onModeChangeListener);
        }

        public void removeOnModeChangeListener(ServiceAware.OnModeChangeListener onModeChangeListener) {
            this.onModeChangeListeners.remove(onModeChangeListener);
        }

        /* access modifiers changed from: package-private */
        public void onMoveToForeground() {
            for (ServiceAware.OnModeChangeListener onMoveToForeground : this.onModeChangeListeners) {
                onMoveToForeground.onMoveToForeground();
            }
        }

        /* access modifiers changed from: package-private */
        public void onMoveToBackground() {
            for (ServiceAware.OnModeChangeListener onMoveToBackground : this.onModeChangeListeners) {
                onMoveToBackground.onMoveToBackground();
            }
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineBroadcastReceiverPluginBinding */
    private static class FlutterEngineBroadcastReceiverPluginBinding implements BroadcastReceiverPluginBinding {
        private final BroadcastReceiver broadcastReceiver;

        FlutterEngineBroadcastReceiverPluginBinding(BroadcastReceiver broadcastReceiver2) {
            this.broadcastReceiver = broadcastReceiver2;
        }

        public BroadcastReceiver getBroadcastReceiver() {
            return this.broadcastReceiver;
        }
    }

    /* renamed from: io.flutter.embedding.engine.FlutterEngineConnectionRegistry$FlutterEngineContentProviderPluginBinding */
    private static class FlutterEngineContentProviderPluginBinding implements ContentProviderPluginBinding {
        private final ContentProvider contentProvider;

        FlutterEngineContentProviderPluginBinding(ContentProvider contentProvider2) {
            this.contentProvider = contentProvider2;
        }

        public ContentProvider getContentProvider() {
            return this.contentProvider;
        }
    }
}
