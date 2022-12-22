package com.p224kt.didichuxing.didi_network_entrega;

import android.content.Context;
import android.os.Handler;
import com.android.didi.bfflib.Bff;
import com.didi.sdk.apm.SystemUtils;
import com.p224kt.didichuxing.didi_network_entrega.net.HttpAdapter;
import com.p224kt.didichuxing.didi_network_entrega.net.NetParam;
import com.p224kt.didichuxing.didi_network_entrega.net.RequestType;
import com.p224kt.didichuxing.didi_network_entrega.net.ResponseListener;
import com.p224kt.didichuxing.didi_network_entrega.net.bff.BffRequests;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

/* renamed from: com.kt.didichuxing.didi_network_entrega.GLEDidiNetworkPlugin */
public class GLEDidiNetworkPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Handler f55487a;

    /* renamed from: b */
    private static MethodChannel f55488b;

    /* renamed from: c */
    private static NetworkParamsCallback f55489c;
    public static Context mContext;

    /* renamed from: com.kt.didichuxing.didi_network_entrega.GLEDidiNetworkPlugin$NetworkParamsCallback */
    public interface NetworkParamsCallback {
        Map<String, String> commonHeaderParams();

        Map<String, Object> commonQueryParams();
    }

    public static void setNetworkParamsCallback(NetworkParamsCallback networkParamsCallback) {
        f55489c = networkParamsCallback;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r6, p242io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r0 = r6.method
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1991790289: goto L_0x002b;
                case -1956039027: goto L_0x0021;
                case -1406268607: goto L_0x0017;
                case 292648379: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0035
        L_0x000d:
            java.lang.String r1 = "send_bff_request"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 2
            goto L_0x0036
        L_0x0017:
            java.lang.String r1 = "add_tag_and_bffIds"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 3
            goto L_0x0036
        L_0x0021:
            java.lang.String r1 = "bff_init"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 1
            goto L_0x0036
        L_0x002b:
            java.lang.String r1 = "send_http_request"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 0
            goto L_0x0036
        L_0x0035:
            r0 = -1
        L_0x0036:
            if (r0 == 0) goto L_0x004b
            if (r0 == r4) goto L_0x0047
            if (r0 == r3) goto L_0x0043
            if (r0 == r2) goto L_0x003f
            goto L_0x004e
        L_0x003f:
            r5.addTagAndBffIds(r6, r7)
            goto L_0x004e
        L_0x0043:
            r5.bffRequest(r6, r7)
            goto L_0x004e
        L_0x0047:
            r5.initBff(r6, r7)
            goto L_0x004e
        L_0x004b:
            r5.sendRequest(r6, r7)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p224kt.didichuxing.didi_network_entrega.GLEDidiNetworkPlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void sendRequest(MethodCall methodCall, final MethodChannel.Result result) {
        Map map = (Map) methodCall.argument("params");
        int intValue = methodCall.argument("request_type") != null ? ((Integer) methodCall.argument("request_type")).intValue() : 2;
        Map map2 = (Map) map.get("query_params");
        Map map3 = (Map) map.get("header_params");
        NetworkParamsCallback networkParamsCallback = f55489c;
        if (networkParamsCallback != null) {
            Map<String, Object> commonQueryParams = networkParamsCallback.commonQueryParams();
            Map<String, String> commonHeaderParams = f55489c.commonHeaderParams();
            if (commonQueryParams != null && !commonQueryParams.isEmpty()) {
                if (map2 == null) {
                    map2 = new HashMap();
                }
                map2.putAll(commonQueryParams);
            }
            if (commonHeaderParams != null && !commonHeaderParams.isEmpty()) {
                if (map3 == null) {
                    map3 = new HashMap();
                }
                map3.putAll(commonHeaderParams);
            }
        }
        HttpAdapter.getInstance().sendRequest(new NetParam.Builder().setUrl(methodCall.argument("url").toString()).setRequestType(RequestType.mapIntToValue(intValue)).setQueryParameter(map2).setPostGetterParameter((Map) map.get("post_getter_params")).setHeadParameter(map3).setRequestType(RequestType.mapIntToValue(intValue)).build(), new ResponseListener<String>() {
            public void onReceiveResponse(final String str) {
                GLEDidiNetworkPlugin.f55487a.post(new Runnable() {
                    public void run() {
                        PrintStream printStream = System.out;
                        printStream.println("success response = " + str);
                        result.success(str);
                    }
                });
            }

            public void onReceiveError(final String str) {
                GLEDidiNetworkPlugin.f55487a.post(new Runnable() {
                    public void run() {
                        PrintStream printStream = System.out;
                        printStream.println(" error = " + str);
                        result.error("UNAVAILABLE", str, (Object) null);
                    }
                });
            }
        });
    }

    public void initBff(final MethodCall methodCall, MethodChannel.Result result) {
        PrintStream printStream = System.out;
        printStream.println("initBff() host = " + methodCall.argument("host").toString());
        SystemUtils.log(6, "FLUTTER", "initBff() host = " + methodCall.argument("host").toString(), (Throwable) null, "com.kt.didichuxing.didi_network_entrega.GLEDidiNetworkPlugin", 139);
        Bff.getBffConfig().setHostAddr(methodCall.argument("host").toString());
        Bff.getBffConfig().setCommonParamsGenerator(new Bff.BffConfig.CommonParamGenerator() {
            public Map<String, Object> generateParams() {
                return (Map) methodCall.argument("params");
            }
        });
    }

    public void bffRequest(MethodCall methodCall, final MethodChannel.Result result) {
        SystemUtils.log(6, "FLUTTER", "bffRequest() bff_id = " + methodCall.argument("bff_id").toString(), (Throwable) null, "com.kt.didichuxing.didi_network_entrega.GLEDidiNetworkPlugin", 153);
        BffRequests.getInstance().send(methodCall.argument("bff_id").toString(), (Map) methodCall.argument("params"), new ResponseListener<String>() {
            public void onReceiveResponse(final String str) {
                GLEDidiNetworkPlugin.f55487a.post(new Runnable() {
                    public void run() {
                        PrintStream printStream = System.out;
                        printStream.println("success response = " + str);
                        result.success(str);
                    }
                });
            }

            public void onReceiveError(final String str) {
                GLEDidiNetworkPlugin.f55487a.post(new Runnable() {
                    public void run() {
                        PrintStream printStream = System.out;
                        printStream.println("error = " + str);
                        result.error("UNAVAILABLE", str, (Object) null);
                    }
                });
            }
        });
    }

    public void addTagAndBffIds(MethodCall methodCall, MethodChannel.Result result) {
        Bff.getBffConfig().add(methodCall.argument("tag").toString(), (List) methodCall.argument("bff_ids"));
    }

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "com.didi.plugin.network_entrega");
        f55488b = methodChannel;
        methodChannel.setMethodCallHandler(this);
        mContext = flutterPluginBinding.getApplicationContext();
        f55487a = new Handler(mContext.getMainLooper());
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        f55488b.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        f55489c = null;
    }
}
