package p242io.flutter.plugins.sharedpreferences;

import android.content.Context;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin */
public class SharedPreferencesPlugin implements FlutterPlugin {

    /* renamed from: a */
    private static final String f57899a = "plugins.flutter.io/shared_preferences_android";

    /* renamed from: b */
    private MethodChannel f57900b;

    /* renamed from: c */
    private C21162a f57901c;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new SharedPreferencesPlugin().m41685a(registrar.messenger(), registrar.context());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m41685a(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m41684a();
    }

    /* renamed from: a */
    private void m41685a(BinaryMessenger binaryMessenger, Context context) {
        this.f57900b = new MethodChannel(binaryMessenger, f57899a);
        C21162a aVar = new C21162a(context);
        this.f57901c = aVar;
        this.f57900b.setMethodCallHandler(aVar);
    }

    /* renamed from: a */
    private void m41684a() {
        this.f57901c.mo172912a();
        this.f57901c = null;
        this.f57900b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f57900b = null;
    }
}
