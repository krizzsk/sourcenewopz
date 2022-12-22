package com.example.devicelocale;

import android.content.Context;
import android.os.Build;
import androidx.core.p006os.LocaleListCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.BinaryMessenger;
import p242io.flutter.plugin.common.MethodChannel;
import p242io.flutter.plugin.common.PluginRegistry;

public class DevicelocalePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private Context applicationContext;
    private MethodChannel methodChannel;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new DevicelocalePlugin().onAttachedToEngine(registrar.context(), registrar.messenger());
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.applicationContext = null;
        this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.methodChannel = null;
    }

    private void onAttachedToEngine(Context context, BinaryMessenger binaryMessenger) {
        this.applicationContext = context;
        MethodChannel methodChannel2 = new MethodChannel(binaryMessenger, "uk.spiralarm.flutter/devicelocale");
        this.methodChannel = methodChannel2;
        methodChannel2.setMethodCallHandler(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r4, p242io.flutter.plugin.common.MethodChannel.Result r5) {
        /*
            r3 = this;
            java.lang.String r4 = r4.method
            int r0 = r4.hashCode()
            r1 = 1950510234(0x74426c9a, float:6.1615496E31)
            r2 = 1
            if (r0 == r1) goto L_0x001c
            r1 = 2037840179(0x7976f933, float:8.014746E34)
            if (r0 == r1) goto L_0x0012
            goto L_0x0026
        L_0x0012:
            java.lang.String r0 = "currentLocale"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0026
            r4 = 1
            goto L_0x0027
        L_0x001c:
            java.lang.String r0 = "preferredLanguages"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0026
            r4 = 0
            goto L_0x0027
        L_0x0026:
            r4 = -1
        L_0x0027:
            if (r4 == 0) goto L_0x0037
            if (r4 == r2) goto L_0x002f
            r5.notImplemented()
            goto L_0x003e
        L_0x002f:
            java.lang.String r4 = r3.getCurrentLocale()
            r5.success(r4)
            goto L_0x003e
        L_0x0037:
            java.util.List r4 = r3.getPreferredLanguages()
            r5.success(r4)
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.devicelocale.DevicelocalePlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    private String getCurrentLocale() {
        return Locale.getDefault().toString();
    }

    private List<String> getPreferredLanguages() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleListCompat adjustedDefault = LocaleListCompat.getAdjustedDefault();
            for (int i = 0; i < adjustedDefault.size(); i++) {
                arrayList.add(adjustedDefault.get(i).toString());
            }
        } else {
            arrayList.add(getCurrentLocale());
        }
        return arrayList;
    }
}
