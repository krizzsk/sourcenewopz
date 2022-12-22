package p242io.flutter.embedding.engine.plugins.util;

import p242io.flutter.Log;
import p242io.flutter.embedding.engine.FlutterEngine;

/* renamed from: io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister */
public class GeneratedPluginRegister {

    /* renamed from: a */
    private static final String f57691a = "GeneratedPluginsRegister";

    public static void registerGeneratedPlugins(FlutterEngine flutterEngine) {
        try {
            Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[]{FlutterEngine.class}).invoke((Object) null, new Object[]{flutterEngine});
        } catch (Exception e) {
            Log.m41136e(f57691a, "Tried to automatically register plugins with FlutterEngine (" + flutterEngine + ") but could not find or invoke the GeneratedPluginRegistrant.");
            Log.m41137e(f57691a, "Received exception while registering", e);
        }
    }
}
