package com.didiglobal.flutter_xengine_plugin;

import android.os.Handler;
import android.os.Looper;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.xengine.flutter.FlutterBizParamCallback;
import com.didi.xengine.flutter.FlutterEngineRegister;
import com.didi.xengine.flutter.FlutterRegisterModel;
import com.didi.xengine.flutter.model.FlutterResponseModel;
import com.didichuxing.omega.sdk.common.record.Event;
import com.didiglobal.enginecore.callback.EngineAsyncCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.LogFactory;
import p242io.flutter.Log;
import p242io.flutter.embedding.engine.plugins.FlutterPlugin;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

public class FlutterXenginePlugin implements XEResponseCallback, FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: b */
    private static final String f50212b = "flutter::android";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MethodChannel f50213a;

    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "flutter_xengine_plugin");
        this.f50213a = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMethodCall(p242io.flutter.plugin.common.MethodCall r6, p242io.flutter.plugin.common.MethodChannel.Result r7) {
        /*
            r5 = this;
            java.lang.String r7 = "flutter::android"
            java.lang.String r0 = "FlutterXenginePlugin: onMethodCall"
            p242io.flutter.Log.m41134d(r7, r0)
            java.lang.String r0 = r6.method
            int r1 = r0.hashCode()
            r2 = -690213213(0xffffffffd6dc2ea3, float:-1.21046431E14)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x0034
            r2 = 155971253(0x94beeb5, float:2.4547476E-33)
            if (r1 == r2) goto L_0x002a
            r2 = 836015164(0x31d4943c, float:6.1868644E-9)
            if (r1 == r2) goto L_0x001f
            goto L_0x003e
        L_0x001f:
            java.lang.String r1 = "unregister"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x002a:
            java.lang.String r1 = "post_action"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 2
            goto L_0x003f
        L_0x0034:
            java.lang.String r1 = "register"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x003e:
            r0 = -1
        L_0x003f:
            if (r0 == 0) goto L_0x0069
            if (r0 == r4) goto L_0x0065
            if (r0 == r3) goto L_0x0061
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "FlutterXenginePlugin:onMethodCal"
            r0.append(r1)
            java.lang.String r6 = r6.method
            r0.append(r6)
            java.lang.String r6 = "l::result.notImplemented"
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            p242io.flutter.Log.m41134d(r7, r6)
            goto L_0x006c
        L_0x0061:
            r5.m36202c(r6)
            goto L_0x006c
        L_0x0065:
            r5.m36201b(r6)
            goto L_0x006c
        L_0x0069:
            r5.m36198a((p242io.flutter.plugin.common.MethodCall) r6)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.flutter_xengine_plugin.FlutterXenginePlugin.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }

    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f50213a.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    /* renamed from: a */
    private void m36198a(MethodCall methodCall) {
        Log.m41134d("flutter", "XengineMethodHandler: registerFlutterModel");
        FlutterRegisterModel flutterRegisterModel = new FlutterRegisterModel();
        flutterRegisterModel.identifier = (String) methodCall.argument("id");
        flutterRegisterModel.priority = ((Integer) methodCall.argument(LogFactory.PRIORITY_KEY)).intValue();
        flutterRegisterModel.scenes = (List) methodCall.argument("scenes");
        flutterRegisterModel.callback = new FlutterBizParamCallback() {
            public void getBizParams(String str, String str2, EngineAsyncCallback engineAsyncCallback) {
                Log.m41134d("flutter", "XengineMethodHandler:FlutterBizParamCallbackImpl: getBizParams");
                FlutterXenginePlugin.this.m36200a(str, str2, engineAsyncCallback);
            }
        };
        Log.m41134d("flutter", "FlutterRegisterModel: " + flutterRegisterModel.toString());
        FlutterEngineRegister.registerFlutterModel(flutterRegisterModel, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36200a(String str, String str2, EngineAsyncCallback engineAsyncCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        Log.m41134d(f50212b, "FlutterXenginePlugin: getParams");
        final HashMap hashMap = new HashMap();
        hashMap.put("scene", str);
        hashMap.put("id", str2);
        final EngineAsyncCallback engineAsyncCallback2 = engineAsyncCallback;
        final String str3 = str2;
        final String str4 = str;
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new Runnable() {
            public void run() {
                FlutterXenginePlugin.this.f50213a.invokeMethod("get_params", hashMap, new MethodChannel.Result() {
                    public void notImplemented() {
                    }

                    public void success(Object obj) {
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        try {
                            Log.m41134d(FlutterXenginePlugin.f50212b, "FlutterXenginePlugin: getParams :: success :: result:" + obj.toString());
                            for (Map map : (List) ((Map) obj).get("element_list")) {
                                engineAsyncCallback2.getBizParamsMap((Map) map.get("biz_params"));
                            }
                        } catch (Exception e) {
                            Log.m41134d(FlutterXenginePlugin.f50212b, "FlutterXenginePlugin: getParams :: cast error :: result:" + obj.toString());
                            e.printStackTrace();
                        } catch (Throwable th) {
                            FlutterXenginePlugin.this.m36199a(str3, str4, currentTimeMillis, true);
                            throw th;
                        }
                        FlutterXenginePlugin.this.m36199a(str3, str4, currentTimeMillis, true);
                    }

                    public void error(String str, String str2, Object obj) {
                        FlutterXenginePlugin.this.m36199a(str3, str4, System.currentTimeMillis() - currentTimeMillis, false);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36199a(String str, String str2, long j, boolean z) {
        HashMap hashMap = new HashMap();
        Event event = new Event("tech_xengine_getparams_timecost");
        hashMap.put("scene", str2);
        hashMap.put("identifier", str);
        hashMap.put("time_cost_per_millsecond", Long.valueOf(j));
        hashMap.put("success", Boolean.valueOf(z));
        event.putAllAttrs(hashMap);
        OmegaSDKAdapter.trackEvent(event);
    }

    /* renamed from: b */
    private void m36201b(MethodCall methodCall) {
        Log.m41134d("flutter", "XengineMethodHandler: unregisterFlutterModel");
        Log.m41134d("flutter", "id: " + methodCall.argument("id"));
        FlutterRegisterModel flutterRegisterModel = new FlutterRegisterModel();
        flutterRegisterModel.identifier = (String) methodCall.argument("id");
        FlutterEngineRegister.unregisterFlutterModel(flutterRegisterModel);
    }

    public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
        m36195a(new FlutterResponseModel(0, "success", str, xEngineData));
    }

    public void onFailed(String str, EngineErrorException engineErrorException) {
        m36195a(new FlutterResponseModel(engineErrorException.getErrNo(), "failed", str));
    }

    /* renamed from: a */
    private void m36195a(FlutterResponseModel flutterResponseModel) {
        Log.m41134d(f50212b, "FlutterXenginePlugin: dispatchData: responseModel:" + flutterResponseModel.toString());
        if (flutterResponseModel.requestKey == null) {
            Log.m41134d(f50212b, "FlutterXenginePlugin responseModel dispatchData: missing requestKey");
            return;
        }
        final HashMap hashMap = new HashMap();
        hashMap.put("error_no", Integer.valueOf(flutterResponseModel.errNo));
        hashMap.put("error_msg", flutterResponseModel.errMsg);
        Log.m41134d(f50212b, "FlutterXenginePlugin: dispatchData :: args " + hashMap.toString());
        final Gson gson = new Gson();
        hashMap.put(flutterResponseModel.requestKey, flutterResponseModel.jsonObject.toString());
        UIThreadHandler.post(new Runnable() {
            public void run() {
                FlutterXenginePlugin.this.f50213a.invokeMethod("dispatch_data", gson.toJson((Object) hashMap));
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0101  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m36202c(p242io.flutter.plugin.common.MethodCall r10) {
        /*
            r9 = this;
            java.lang.String r0 = "action"
            java.lang.Object r0 = r10.argument(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "params"
            java.lang.Object r10 = r10.argument(r1)
            java.util.HashMap r10 = (java.util.HashMap) r10
            com.didi.xengine.request.XEngineReqUtil r1 = new com.didi.xengine.request.XEngineReqUtil
            java.lang.String r2 = "engine_type"
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.<init>(r2)
            int r2 = r0.hashCode()
            r3 = -1817366468(0xffffffff93ad303c, float:-4.3718902E-27)
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == r3) goto L_0x0049
            r3 = -368743306(0xffffffffea056c76, float:-4.032483E25)
            if (r2 == r3) goto L_0x003e
            r3 = 1303145023(0x4dac6a3f, float:3.61580512E8)
            if (r2 == r3) goto L_0x0034
            goto L_0x0054
        L_0x0034:
            java.lang.String r2 = "request_page"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0054
            r0 = 0
            goto L_0x0055
        L_0x003e:
            java.lang.String r2 = "xEngine_refresh"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0054
            r0 = 1
            goto L_0x0055
        L_0x0049:
            java.lang.String r2 = "xEngine_commit"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0054
            r0 = 2
            goto L_0x0055
        L_0x0054:
            r0 = -1
        L_0x0055:
            java.lang.String r2 = "identifier"
            java.lang.String r3 = "identifier_list"
            java.lang.String r7 = "flutter"
            java.lang.String r8 = "scene"
            if (r0 == 0) goto L_0x0101
            if (r0 == r5) goto L_0x00bc
            if (r0 == r4) goto L_0x0066
            goto L_0x0145
        L_0x0066:
            java.lang.String r0 = "XengineMethodHandler: xEngine_commit"
            p242io.flutter.Log.m41134d(r7, r0)
            com.didi.xengine.request.XECommitBizParams r0 = new com.didi.xengine.request.XECommitBizParams
            r0.<init>()
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r0.identifier = r2
            java.lang.String r2 = "action_id"
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r0.actionID = r2
            java.lang.Object r2 = r10.get(r8)
            java.lang.String r2 = (java.lang.String) r2
            r0.scene = r2
            java.lang.String r2 = "submit_url"
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            r0.submitUrl = r2
            java.lang.String r2 = "extra_params"
            java.lang.Object r10 = r10.get(r2)
            java.util.Map r10 = (java.util.Map) r10
            r0.extraParams = r10
            r1.engineCommit(r0)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "XengineMethodHandler: xEngine_refresh \n xeCommitBizParams:"
            r10.append(r1)
            java.lang.String r0 = r0.toString()
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            p242io.flutter.Log.m41134d(r7, r10)
            goto L_0x0145
        L_0x00bc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "XengineMethodHandler: xEngine_refresh \n scene:"
            r0.append(r2)
            java.lang.Object r2 = r10.get(r8)
            r0.append(r2)
            java.lang.String r2 = "   identifier_list"
            r0.append(r2)
            java.lang.Object r2 = r10.get(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            p242io.flutter.Log.m41134d(r7, r0)
            com.didi.xengine.request.XEBizParamsImpl r0 = new com.didi.xengine.request.XEBizParamsImpl
            r0.<init>()
            java.lang.Object r2 = r10.get(r3)
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.String[] r3 = new java.lang.String[r6]
            java.lang.Object[] r2 = r2.toArray(r3)
            java.lang.String[] r2 = (java.lang.String[]) r2
            r0.requestKeys = r2
            java.lang.Object r10 = r10.get(r8)
            java.lang.String r10 = (java.lang.String) r10
            r0.scene = r10
            r1.simpleRequest(r0)
            goto L_0x0145
        L_0x0101:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "XengineMethodHandler: request_page \n scene:"
            r0.append(r4)
            java.lang.Object r4 = r10.get(r8)
            r0.append(r4)
            java.lang.String r4 = "   identifier"
            r0.append(r4)
            java.lang.Object r2 = r10.get(r2)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            p242io.flutter.Log.m41134d(r7, r0)
            com.didi.xengine.request.XEBizParamsImpl r0 = new com.didi.xengine.request.XEBizParamsImpl
            r0.<init>()
            java.lang.Object r2 = r10.get(r8)
            java.lang.String r2 = (java.lang.String) r2
            r0.scene = r2
            java.lang.Object r10 = r10.get(r3)
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.Object[] r10 = r10.toArray(r2)
            java.lang.String[] r10 = (java.lang.String[]) r10
            r0.requestKeys = r10
            r1.pageRequest((com.didi.xengine.request.XEBizParamsImpl) r0)
        L_0x0145:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.flutter_xengine_plugin.FlutterXenginePlugin.m36202c(io.flutter.plugin.common.MethodCall):void");
    }
}
