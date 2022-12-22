package com.didi.flutter.nacho;

import com.didi.flutter.nacho.p114ui.UIUpdateListener;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.osgi.framework.AdminPermission;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.embedding.engine.plugins.activity.ActivityAware;
import p242io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodChannel;

public class NachoPlugin implements FlutterPlugin, ActivityAware, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private MethodChannel f21098a;

    /* renamed from: b */
    private UIUpdateListener f21099b;

    /* renamed from: c */
    private NachoPluginListener f21100c = new NachoPluginListener();

    /* renamed from: d */
    private boolean f21101d = false;

    /* renamed from: e */
    private boolean f21102e = false;

    /* renamed from: f */
    private List<CallMessage> f21103f = new ArrayList();

    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void registerUiUpdateListener(UIUpdateListener uIUpdateListener) {
        this.f21099b = uIUpdateListener;
    }

    public void registerNachoPluginListener(NachoPluginListener nachoPluginListener) {
        if (nachoPluginListener != null) {
            this.f21100c = nachoPluginListener;
        }
    }

    public boolean isNativeProcessGesture() {
        return this.f21101d;
    }

    public void setNativeProcessGesture(boolean z) {
        this.f21101d = z;
    }

    public void sendLifecycleEvent(String str, String str2, String str3, Map<String, String> map, Map<String, String> map2) {
        HashMap hashMap = new HashMap();
        hashMap.put("pageId", str);
        hashMap.put(AdminPermission.LIFECYCLE, str2);
        hashMap.put("engineId", str3);
        if (map != null) {
            hashMap.putAll(map);
        }
        if (NachoLifecycleManager.LIFECYCLE_ON_CREATE.equals(str2)) {
            this.f21101d = false;
        }
        hashMap.put("params", map2);
        m15531a(new CallMessage(NachoLifecycleManager.LIFECYCLE_CHANNEL_METHOD, hashMap));
    }

    public void envChanged() {
        m15531a(new CallMessage("envChanged", (Map<String, Object>) null));
    }

    /* renamed from: a */
    private void m15531a(CallMessage callMessage) {
        if (this.f21102e) {
            this.f21098a.invokeMethod(callMessage.method, callMessage.parameter);
        } else {
            this.f21103f.add(callMessage);
        }
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        SystemUtils.log(3, "nightmare", "onAttachedToEngine被调用", (Throwable) null, "com.didi.flutter.nacho.NachoPlugin", 98);
        m15532a(flutterPluginBinding.getBinaryMessenger());
    }

    /* renamed from: a */
    private void m15532a(BinaryMessenger binaryMessenger) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, BuildConfig.LIBRARY_PACKAGE_NAME);
        this.f21098a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r9, p242io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            java.lang.String r0 = r9.method
            int r1 = r0.hashCode()
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            switch(r1) {
                case -1804675497: goto L_0x0048;
                case -1191099035: goto L_0x003e;
                case -999672879: goto L_0x0034;
                case -678538513: goto L_0x0029;
                case 3417674: goto L_0x001e;
                case 108386723: goto L_0x0013;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0053
        L_0x0013:
            java.lang.String r1 = "ready"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = 4
            goto L_0x0054
        L_0x001e:
            java.lang.String r1 = "open"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = 0
            goto L_0x0054
        L_0x0029:
            java.lang.String r1 = "updateNativeDialogHeight"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = 2
            goto L_0x0054
        L_0x0034:
            java.lang.String r1 = "nativeProcessGesture"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = 1
            goto L_0x0054
        L_0x003e:
            java.lang.String r1 = "nativeInfo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = 3
            goto L_0x0054
        L_0x0048:
            java.lang.String r1 = "popSystemNavigator"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0053
            r0 = 5
            goto L_0x0054
        L_0x0053:
            r0 = -1
        L_0x0054:
            if (r0 == 0) goto L_0x00b3
            if (r0 == r6) goto L_0x00a8
            if (r0 == r5) goto L_0x0098
            if (r0 == r4) goto L_0x0084
            if (r0 == r3) goto L_0x007b
            if (r0 == r2) goto L_0x0064
            r10.notImplemented()
            goto L_0x00c0
        L_0x0064:
            com.didi.flutter.nacho.Nacho r9 = com.didi.flutter.nacho.Nacho.getInstance()
            com.didi.flutter.nacho.INachoApp r9 = r9.getTopContainer()
            boolean r0 = r9 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0077
            com.didi.flutter.nacho.NachoPluginListener r0 = r8.f21100c
            android.app.Activity r9 = (android.app.Activity) r9
            r0.popSystemNavigator(r9)
        L_0x0077:
            r10.success(r7)
            goto L_0x00c0
        L_0x007b:
            r8.f21102e = r6
            r10.success(r7)
            r8.m15530a()
            goto L_0x00c0
        L_0x0084:
            com.didi.flutter.nacho.Nacho r9 = com.didi.flutter.nacho.Nacho.getInstance()
            com.didi.flutter.nacho.NativeInfoFetcher r0 = r9.nativeInfoFetcher()
            android.content.Context r9 = r9.getContext()
            java.util.Map r9 = r0.getInfo(r9)
            r10.success(r9)
            goto L_0x00c0
        L_0x0098:
            com.didi.flutter.nacho.ui.UIUpdateListener r10 = r8.f21099b
            if (r10 == 0) goto L_0x00c0
            java.lang.Object r9 = r9.arguments
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            r10.updateNativeDialogHeight(r9)
            goto L_0x00c0
        L_0x00a8:
            java.lang.Object r9 = r9.arguments
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            r8.f21101d = r9
            goto L_0x00c0
        L_0x00b3:
            com.didi.flutter.nacho.NachoPluginListener r0 = r8.f21100c
            com.didi.flutter.nacho.Nacho r1 = com.didi.flutter.nacho.Nacho.getInstance()
            android.app.Activity r1 = r1.getTopActivity()
            r0.open(r1, r9, r10)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.flutter.nacho.NachoPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    /* renamed from: a */
    private void m15530a() {
        for (int i = 0; i < this.f21103f.size(); i++) {
            CallMessage callMessage = this.f21103f.get(i);
            this.f21098a.invokeMethod(callMessage.method, callMessage.parameter);
        }
        this.f21103f.clear();
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }

    public void onPluginRegistered(FlutterEngine flutterEngine) {
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), "com.didi.flutter.nacho.register").invokeMethod("onPluginRegistered", true);
    }

    static class CallMessage {
        String method;
        Map<String, Object> parameter;

        public CallMessage(String str, Map<String, Object> map) {
            this.method = str;
            this.parameter = map;
        }
    }
}
