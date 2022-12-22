package com.didi.flutter.nacho2.p115v2;

import android.text.TextUtils;
import com.didi.flutter.nacho2.p115v2.callback.NachoRouterCallback;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

/* renamed from: com.didi.flutter.nacho2.v2.NachoChannelManager */
public class NachoChannelManager {
    protected static void registerNachoChannel(NachoAction nachoAction) {
        MethodChannel methodChannel = new MethodChannel(nachoAction.getEngine().getDartExecutor().getBinaryMessenger(), "com.didi.flutter.nacho2");
        methodChannel.setMethodCallHandler(new NachoMethodCallHandler(nachoAction));
        nachoAction.registerChannel("com.didi.flutter.nacho2", methodChannel);
    }

    public static void setPageResult(NachoAction nachoAction, String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("pageId", str);
        nachoAction.getChannel("com.didi.flutter.nacho2").invokeMethod("onPageResult", hashMap);
    }

    /* renamed from: com.didi.flutter.nacho2.v2.NachoChannelManager$NachoMethodCallHandler */
    public static class NachoMethodCallHandler implements MethodChannel.MethodCallHandler {
        NachoAction nachoAction;

        public NachoMethodCallHandler(NachoAction nachoAction2) {
            this.nachoAction = nachoAction2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x004c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onMethodCall(p242io.flutter.plugin.common.MethodCall r6, p242io.flutter.plugin.common.MethodChannel.Result r7) {
            /*
                r5 = this;
                java.lang.String r0 = r6.method
                int r1 = r0.hashCode()
                r2 = -504772615(0xffffffffe1e9c7f9, float:-5.390626E20)
                r3 = 2
                r4 = 1
                if (r1 == r2) goto L_0x002d
                r2 = -482608985(0xffffffffe33bf8a7, float:-3.4674584E21)
                if (r1 == r2) goto L_0x0023
                r2 = 108386723(0x675d9a3, float:4.6239273E-35)
                if (r1 == r2) goto L_0x0018
                goto L_0x0038
            L_0x0018:
                java.lang.String r1 = "ready"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0038
                r0 = 2
                goto L_0x0039
            L_0x0023:
                java.lang.String r1 = "closePage"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0038
                r0 = 1
                goto L_0x0039
            L_0x002d:
                java.lang.String r1 = "openPage"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x0038
                r0 = 0
                goto L_0x0039
            L_0x0038:
                r0 = -1
            L_0x0039:
                if (r0 == 0) goto L_0x004c
                if (r0 == r4) goto L_0x0048
                if (r0 == r3) goto L_0x0040
                goto L_0x004f
            L_0x0040:
                java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
                r7.success(r6)
                goto L_0x004f
            L_0x0048:
                r5.closePage(r6, r7)
                goto L_0x004f
            L_0x004c:
                r5.openPage(r6, r7)
            L_0x004f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.flutter.nacho2.p115v2.NachoChannelManager.NachoMethodCallHandler.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
        }

        private void openPage(MethodCall methodCall, MethodChannel.Result result) {
            String str = (String) methodCall.argument("_nacho_url");
            String str2 = (String) methodCall.argument("pageId");
            if (TextUtils.isEmpty(str)) {
                result.success(false);
                return;
            }
            HashMap hashMap = new HashMap();
            if (methodCall.arguments instanceof HashMap) {
                hashMap.putAll((Map) methodCall.arguments);
            }
            NachoRouterCallback onRouteCallback = this.nachoAction.getOnRouteCallback();
            if (onRouteCallback != null) {
                onRouteCallback.onPageOpen(str2, str, hashMap);
            }
            result.success(true);
        }

        private void closePage(MethodCall methodCall, MethodChannel.Result result) {
            String str = (String) methodCall.argument("pageId");
            HashMap hashMap = (HashMap) methodCall.argument("result");
            NachoRouterCallback onRouteCallback = this.nachoAction.getOnRouteCallback();
            if (onRouteCallback != null) {
                onRouteCallback.onPageClose(str, hashMap);
            }
            result.success(true);
        }
    }
}
