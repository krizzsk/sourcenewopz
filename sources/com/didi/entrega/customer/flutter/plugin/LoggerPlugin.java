package com.didi.entrega.customer.flutter.plugin;

import com.didi.foundation.sdk.log.LogService;
import com.didi.sdk.logging.Logger;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.JSONMethodCodec;
import p242io.flutter.plugin.common.MethodChannel;

public class LoggerPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: a */
    private Logger f19898a = LogService.getLogger("logger_plugin");

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.rlab/logger_plugin", JSONMethodCodec.INSTANCE).setMethodCallHandler(this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r8, p242io.flutter.plugin.common.MethodChannel.Result r9) {
        /*
            r7 = this;
            java.lang.String r9 = "tag"
            java.lang.Object r9 = r8.argument(r9)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.String r0 = "param"
            java.lang.Object r0 = r8.argument(r0)
            java.lang.String r0 = r0.toString()
            java.lang.String r8 = r8.method
            int r1 = r8.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            switch(r1) {
                case 3237038: goto L_0x0041;
                case 95458899: goto L_0x0037;
                case 96784904: goto L_0x002d;
                case 1124446108: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x004b
        L_0x0022:
            java.lang.String r1 = "warning"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x004b
            r8 = 3
            goto L_0x004c
        L_0x002d:
            java.lang.String r1 = "error"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x004b
            r8 = 2
            goto L_0x004c
        L_0x0037:
            java.lang.String r1 = "debug"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x004b
            r8 = 1
            goto L_0x004c
        L_0x0041:
            java.lang.String r1 = "info"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x004b
            r8 = 0
            goto L_0x004c
        L_0x004b:
            r8 = -1
        L_0x004c:
            java.lang.String r1 = " | "
            java.lang.String r6 = ""
            if (r8 == 0) goto L_0x00b0
            if (r8 == r4) goto L_0x0093
            if (r8 == r3) goto L_0x0076
            if (r8 == r2) goto L_0x0059
            goto L_0x00cc
        L_0x0059:
            com.didi.sdk.logging.Logger r8 = r7.f19898a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r9)
            r2.append(r1)
            r2.append(r0)
            java.lang.String r9 = r2.toString()
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r8.warn((java.lang.String) r9, (java.lang.Object[]) r0)
            goto L_0x00cc
        L_0x0076:
            com.didi.sdk.logging.Logger r8 = r7.f19898a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r9)
            r2.append(r1)
            r2.append(r0)
            java.lang.String r9 = r2.toString()
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r8.error((java.lang.String) r9, (java.lang.Object[]) r0)
            goto L_0x00cc
        L_0x0093:
            com.didi.sdk.logging.Logger r8 = r7.f19898a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r9)
            r2.append(r1)
            r2.append(r0)
            java.lang.String r9 = r2.toString()
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r8.debug((java.lang.String) r9, (java.lang.Object[]) r0)
            goto L_0x00cc
        L_0x00b0:
            com.didi.sdk.logging.Logger r8 = r7.f19898a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r9)
            r2.append(r1)
            r2.append(r0)
            java.lang.String r9 = r2.toString()
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r8.info((java.lang.String) r9, (java.lang.Object[]) r0)
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.flutter.plugin.LoggerPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
