package com.didi.flutter.nacho;

import android.app.Activity;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class NachoPluginListener {
    public void popSystemNavigator(Activity activity) {
        if (!Nacho.getInstance().dismissFlutterDialog() && activity != null) {
            activity.finish();
        }
    }

    public void open(Activity activity, MethodCall methodCall, MethodChannel.Result result) {
        String str = (String) methodCall.argument("_nacho_url");
        if (TextUtils.isEmpty(str) || activity == null) {
            result.success(false);
            return;
        }
        HashMap hashMap = new HashMap();
        if (methodCall.arguments instanceof HashMap) {
            hashMap.putAll((Map) methodCall.arguments);
        }
        Nacho.Router().open(activity, str, hashMap);
        result.success(true);
    }
}
