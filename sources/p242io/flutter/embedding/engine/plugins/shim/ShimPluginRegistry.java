package p242io.flutter.embedding.engine.plugins.shim;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry */
public class ShimPluginRegistry implements PluginRegistry {

    /* renamed from: a */
    private static final String f57677a = "ShimPluginRegistry";

    /* renamed from: b */
    private final FlutterEngine f57678b;

    /* renamed from: c */
    private final Map<String, Object> f57679c = new HashMap();

    /* renamed from: d */
    private final ShimRegistrarAggregate f57680d;

    public ShimPluginRegistry(FlutterEngine flutterEngine) {
        this.f57678b = flutterEngine;
        this.f57680d = new ShimRegistrarAggregate();
        this.f57678b.getPlugins().add((FlutterPlugin) this.f57680d);
    }

    public PluginRegistry.Registrar registrarFor(String str) {
        Log.m41140v(f57677a, "Creating plugin Registrar for '" + str + "'");
        if (!this.f57679c.containsKey(str)) {
            this.f57679c.put(str, (Object) null);
            C21083a aVar = new C21083a(str, this.f57679c);
            this.f57680d.addPlugin(aVar);
            return aVar;
        }
        throw new IllegalStateException("Plugin key " + str + " is already in use");
    }

    public boolean hasPlugin(String str) {
        return this.f57679c.containsKey(str);
    }

    public <T> T valuePublishedByPlugin(String str) {
        return this.f57679c.get(str);
    }

    /* renamed from: io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry$ShimRegistrarAggregate */
    private static class ShimRegistrarAggregate implements FlutterPlugin, ActivityAware {
        private ActivityPluginBinding activityPluginBinding;
        private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
        private final Set<C21083a> shimRegistrars;

        private ShimRegistrarAggregate() {
            this.shimRegistrars = new HashSet();
        }

        public void addPlugin(C21083a aVar) {
            this.shimRegistrars.add(aVar);
            FlutterPlugin.FlutterPluginBinding flutterPluginBinding2 = this.flutterPluginBinding;
            if (flutterPluginBinding2 != null) {
                aVar.onAttachedToEngine(flutterPluginBinding2);
            }
            ActivityPluginBinding activityPluginBinding2 = this.activityPluginBinding;
            if (activityPluginBinding2 != null) {
                aVar.onAttachedToActivity(activityPluginBinding2);
            }
        }

        public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            this.flutterPluginBinding = flutterPluginBinding2;
            for (C21083a onAttachedToEngine : this.shimRegistrars) {
                onAttachedToEngine.onAttachedToEngine(flutterPluginBinding2);
            }
        }

        public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding2) {
            for (C21083a onDetachedFromEngine : this.shimRegistrars) {
                onDetachedFromEngine.onDetachedFromEngine(flutterPluginBinding2);
            }
            this.flutterPluginBinding = null;
            this.activityPluginBinding = null;
        }

        public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (C21083a onAttachedToActivity : this.shimRegistrars) {
                onAttachedToActivity.onAttachedToActivity(activityPluginBinding2);
            }
        }

        public void onDetachedFromActivityForConfigChanges() {
            for (C21083a onDetachedFromActivity : this.shimRegistrars) {
                onDetachedFromActivity.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }

        public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding2) {
            this.activityPluginBinding = activityPluginBinding2;
            for (C21083a onReattachedToActivityForConfigChanges : this.shimRegistrars) {
                onReattachedToActivityForConfigChanges.onReattachedToActivityForConfigChanges(activityPluginBinding2);
            }
        }

        public void onDetachedFromActivity() {
            for (C21083a onDetachedFromActivity : this.shimRegistrars) {
                onDetachedFromActivity.onDetachedFromActivity();
            }
            this.activityPluginBinding = null;
        }
    }
}
