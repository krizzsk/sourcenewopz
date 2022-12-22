package com.didi.global.pax_delivery;

import com.didi.app.GeneralPageRouter;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.component.core.event.BaseEventPublisher;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

public class PaxDeliveryPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static final String CHANEL_NAME = "com.didi.global.pax_delivery";

    /* renamed from: a */
    private MethodChannel f22895a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.global.pax_delivery");
        this.f22895a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "com.didi.global.pax_delivery").setMethodCallHandler(new PaxDeliveryPlugin());
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals(XPanelScene.SCENE_CONFIRM)) {
            JSONObject jSONObject = new JSONObject();
            if (methodCall.arguments instanceof JSONObject) {
                FormStore.getInstance().setDeliveryInfo((JSONObject) methodCall.arguments);
            } else if (methodCall.arguments instanceof Map) {
                Map map = (Map) methodCall.arguments;
                int i = 0;
                try {
                    i = Integer.parseInt((String) map.get("source"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (Object next : map.keySet()) {
                    try {
                        jSONObject.put("" + next, map.get(next));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                FormStore.getInstance().setDeliveryInfo(jSONObject);
                if (i == 1) {
                    BaseEventPublisher.getPublisher().publish(GeneralPageRouter.EVENT_KEY_DELIVERY_CALLBACK, jSONObject.toString());
                } else {
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_ACTION_SEND_ORDER, (Object) null);
                }
            }
        } else {
            result.notImplemented();
        }
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f22895a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }
}
