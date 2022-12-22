package p242io.flutter.plugins.urllauncher;

import android.app.Activity;
import android.util.Log;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.plugins.urllauncher.UrlLauncherPlugin */
public final class UrlLauncherPlugin implements FlutterPlugin, ActivityAware {

    /* renamed from: a */
    private static final String f57912a = "UrlLauncherPlugin";

    /* renamed from: b */
    private C21172a f57913b;

    /* renamed from: c */
    private UrlLauncher f57914c;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new C21172a(new UrlLauncher(registrar.context(), registrar.activity())).mo172927a(registrar.messenger());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        UrlLauncher urlLauncher = new UrlLauncher(flutterPluginBinding.getApplicationContext(), (Activity) null);
        this.f57914c = urlLauncher;
        C21172a aVar = new C21172a(urlLauncher);
        this.f57913b = aVar;
        aVar.mo172927a(flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        C21172a aVar = this.f57913b;
        if (aVar == null) {
            Log.wtf(f57912a, "Already detached from the engine.");
            return;
        }
        aVar.mo172926a();
        this.f57913b = null;
        this.f57914c = null;
    }

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        if (this.f57913b == null) {
            Log.wtf(f57912a, "urlLauncher was never set.");
        } else {
            this.f57914c.mo172915a(activityPluginBinding.getActivity());
        }
    }

    public void onDetachedFromActivity() {
        if (this.f57913b == null) {
            Log.wtf(f57912a, "urlLauncher was never set.");
        } else {
            this.f57914c.mo172915a((Activity) null);
        }
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }
}
