package p242io.flutter.embedding.engine.systemchannels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p242io.flutter.FlutterInjector;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.dart.DartExecutor;
import p242io.flutter.embedding.engine.deferredcomponents.DeferredComponentManager;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.StandardMethodCodec;

/* renamed from: io.flutter.embedding.engine.systemchannels.DeferredComponentChannel */
public class DeferredComponentChannel {

    /* renamed from: b */
    private static final String f57704b = "DeferredComponentChannel";

    /* renamed from: a */
    final MethodChannel.MethodCallHandler f57705a = new MethodChannel.MethodCallHandler() {
        public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
            if (DeferredComponentChannel.this.f57707d != null) {
                String str = methodCall.method;
                Map map = (Map) methodCall.arguments();
                Log.m41140v(DeferredComponentChannel.f57704b, "Received '" + str + "' message.");
                int intValue = ((Integer) map.get("loadingUnitId")).intValue();
                String str2 = (String) map.get("componentName");
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1004447972) {
                    if (hashCode != 399701758) {
                        if (hashCode == 520962947 && str.equals("installDeferredComponent")) {
                            c = 0;
                        }
                    } else if (str.equals("getDeferredComponentInstallState")) {
                        c = 1;
                    }
                } else if (str.equals("uninstallDeferredComponent")) {
                    c = 2;
                }
                if (c == 0) {
                    DeferredComponentChannel.this.f57707d.installDeferredComponent(intValue, str2);
                    if (!DeferredComponentChannel.this.f57708e.containsKey(str2)) {
                        DeferredComponentChannel.this.f57708e.put(str2, new ArrayList());
                    }
                    ((List) DeferredComponentChannel.this.f57708e.get(str2)).add(result);
                } else if (c == 1) {
                    result.success(DeferredComponentChannel.this.f57707d.getDeferredComponentInstallState(intValue, str2));
                } else if (c != 2) {
                    result.notImplemented();
                } else {
                    DeferredComponentChannel.this.f57707d.uninstallDeferredComponent(intValue, str2);
                    result.success((Object) null);
                }
            }
        }
    };

    /* renamed from: c */
    private final MethodChannel f57706c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DeferredComponentManager f57707d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Map<String, List<MethodChannel.Result>> f57708e;

    public DeferredComponentChannel(DartExecutor dartExecutor) {
        MethodChannel methodChannel = new MethodChannel(dartExecutor, "flutter/deferredcomponent", StandardMethodCodec.INSTANCE);
        this.f57706c = methodChannel;
        methodChannel.setMethodCallHandler(this.f57705a);
        this.f57707d = FlutterInjector.instance().deferredComponentManager();
        this.f57708e = new HashMap();
    }

    public void setDeferredComponentManager(DeferredComponentManager deferredComponentManager) {
        this.f57707d = deferredComponentManager;
    }

    public void completeInstallSuccess(String str) {
        if (this.f57708e.containsKey(str)) {
            for (MethodChannel.Result success : this.f57708e.get(str)) {
                success.success((Object) null);
            }
            this.f57708e.get(str).clear();
        }
    }

    public void completeInstallError(String str, String str2) {
        if (this.f57708e.containsKey(str)) {
            for (MethodChannel.Result error : this.f57708e.get(str)) {
                error.error("DeferredComponent Install failure", str2, (Object) null);
            }
            this.f57708e.get(str).clear();
        }
    }
}
