package p242io.flutter.plugins.deviceinfo;

import android.content.Context;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

/* renamed from: io.flutter.plugins.deviceinfo.DeviceInfoPlugin */
public class DeviceInfoPlugin implements FlutterPlugin {

    /* renamed from: a */
    MethodChannel f57889a;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new DeviceInfoPlugin().m41658a(registrar.messenger(), registrar.context());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m41658a(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        m41657a();
    }

    /* renamed from: a */
    private void m41658a(BinaryMessenger binaryMessenger, Context context) {
        this.f57889a = new MethodChannel(binaryMessenger, "plugins.flutter.io/device_info");
        this.f57889a.setMethodCallHandler(new C21126a(context.getContentResolver(), context.getPackageManager()));
    }

    /* renamed from: a */
    private void m41657a() {
        this.f57889a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.f57889a = null;
    }
}
