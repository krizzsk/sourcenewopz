package com.didi.entrega.customer.widget.xpanel;

import com.didi.entrega.customer.flutter.plugin.CustomerBasePlugin;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodChannel;

public class XPanelPlugin extends CustomerBasePlugin {
    public static final String HIT_FRAMES = "hitFrames";
    public static final String IS_SCROLLING = "isScrolling";
    public static final String OFFSET_HEIGHT = "offsetHeight";
    public static final String SET_HIT_FRAMES = "setHitFrames";
    public static final String SET_XPANEL_CONFIG = "setXPanelConfig";

    /* renamed from: a */
    private static final String f20636a = "com.didi.rlab/xpanel_plugin";

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), f20636a).setMethodCallHandler(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r9, p242io.flutter.plugin.common.MethodChannel.Result r10) {
        /*
            r8 = this;
            java.lang.String r10 = r9.method
            java.lang.String r0 = "pageId"
            java.lang.Object r0 = r9.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.util.ArrayList r1 = r8.getListeners()
            int r2 = r10.hashCode()
            r3 = -1457259561(0xffffffffa923fbd7, float:-3.6411707E-14)
            r4 = 0
            java.lang.String r5 = "setXPanelConfig"
            java.lang.String r6 = "setHitFrames"
            r7 = 1
            if (r2 == r3) goto L_0x002e
            r3 = -992960432(0xffffffffc4d0a050, float:-1669.0098)
            if (r2 == r3) goto L_0x0026
            goto L_0x0036
        L_0x0026:
            boolean r10 = r10.equals(r5)
            if (r10 == 0) goto L_0x0036
            r10 = 0
            goto L_0x0037
        L_0x002e:
            boolean r10 = r10.equals(r6)
            if (r10 == 0) goto L_0x0036
            r10 = 1
            goto L_0x0037
        L_0x0036:
            r10 = -1
        L_0x0037:
            r2 = 0
            if (r10 == 0) goto L_0x0066
            if (r10 == r7) goto L_0x003d
            goto L_0x00a5
        L_0x003d:
            java.lang.String r10 = "hitFrames"
            java.lang.Object r9 = r9.argument(r10)
            java.util.List r9 = (java.util.List) r9
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00a5
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.put(r10, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r6)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.notifyAllObserver(r9, r1, r2)
            goto L_0x00a5
        L_0x0066:
            java.lang.String r10 = "offsetHeight"
            java.lang.Object r3 = r9.argument(r10)
            java.lang.Double r3 = (java.lang.Double) r3
            java.lang.String r6 = "isScrolling"
            java.lang.Object r9 = r9.argument(r6)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x00a5
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r1.put(r10, r3)
            if (r9 != 0) goto L_0x0088
            goto L_0x008c
        L_0x0088:
            boolean r4 = r9.booleanValue()
        L_0x008c:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r4)
            r1.put(r6, r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r5)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.notifyAllObserver(r9, r1, r2)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.widget.xpanel.XPanelPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
