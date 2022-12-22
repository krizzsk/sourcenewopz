package com.didi.dimina.starbox.module;

import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.BridgeModule;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.debug.uncaught.error.UncaughtErrorManager;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.DebugKitStoreUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.StarBox;
import com.didi.dimina.starbox.module.jsbridge.JSBridgeManager;
import com.didi.dimina.starbox.module.jsbridge.performance.PerfFloatPage;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@BridgeModule(name = "DMStarBoxBridgeModule")
public class DMStarBoxBridgeModule extends BaseServiceModule {
    private final JSBridgeManager mJsBridgeManager;

    public DMStarBoxBridgeModule(DMMina dMMina) {
        super(dMMina);
        this.mJsBridgeManager = new JSBridgeManager(dMMina);
    }

    @JsInterface({"showInputModal"})
    public void showInputModel(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getInputModalSubJSBridge().showInputModal(jSONObject, callbackFunction);
    }

    @JsInterface({"openDiminaDemo"})
    public void openDiminaDemo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getDiminaDemoSubJSBridge().openDiminaDemo();
    }

    @JsInterface({"readExtendConfiguration"})
    public void readExtendConfiguration(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getExtendSubJSBridge().readExtendConfiguration(callbackFunction);
    }

    @JsInterface({"executeExtendMethod"})
    public void executeExtendMethod(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getExtendSubJSBridge().executeExtendMethod(jSONObject);
    }

    @JsInterface({"getNativeInfo"})
    public void getNativeInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "isDebug", Dimina.getConfig().isDebug());
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"enableFloatEntry"})
    public void enableFloatEntry(JSONObject jSONObject, CallbackFunction callbackFunction) {
        StarBox.INSTANCE.setFloatIconNeedShow(jSONObject.optBoolean("enable", false));
        CallBackUtil.onSuccess(callbackFunction);
    }

    @JsInterface({"isShowFloatEntry"})
    public void isShowFloatEntry(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "enable", StarBox.INSTANCE.getFloatIconNeedShow());
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"enableBundleUpdate"})
    public void enableBundleUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DebugKitStoreUtil.setDloadLimit(jSONObject.optString("appId"), jSONObject.optBoolean("enable", false));
        CallBackUtil.onSuccess(callbackFunction);
    }

    @JsInterface({"isBundleUpdate"})
    public void isBundleUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        boolean equals = TextUtils.equals(DebugKitStoreUtil.getDloadLimit(jSONObject.optString("appId")), "debugkit_dload_limittrue");
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "enable", equals);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"enableWebViewDebug"})
    public void enableWebViewDebug(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DebugKitStoreUtil.setWebContentsDebuggingEnabled(jSONObject.optBoolean("enable", false));
        CallBackUtil.onSuccess(callbackFunction);
    }

    @JsInterface({"isWebViewDebug"})
    public void isWebViewDebug(JSONObject jSONObject, CallbackFunction callbackFunction) {
        boolean webContentsDebuggingEnabled = DebugKitStoreUtil.getWebContentsDebuggingEnabled();
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "isDebug", webContentsDebuggingEnabled);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"getRegisterMinaList"})
    public void getRegisterMinaList(JSONObject jSONObject, CallbackFunction callbackFunction) {
        List<StarBox.StarBoxDMMinaConfig> starBoxRegisterDMMinaList = StarBox.INSTANCE.getStarBoxRegisterDMMinaList();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        for (StarBox.StarBoxDMMinaConfig next : starBoxRegisterDMMinaList) {
            JSONObject jSONObject3 = new JSONObject();
            JSONUtil.put(jSONObject3, "appId", (Object) next.getAppId());
            JSONUtil.put(jSONObject3, "icon", (Object) next.getIcon());
            JSONUtil.put(jSONObject3, "name", (Object) next.getName());
            JSONUtil.put(jSONArray, jSONObject3);
        }
        JSONUtil.put(jSONObject2, "apps", (Object) jSONArray);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"getRunningMinaList"})
    public void getRunningMinaList(JSONObject jSONObject, CallbackFunction callbackFunction) {
        List<DMMina> all = DMMinaPool.getAll();
        JSONArray jSONArray = new JSONArray();
        for (DMMina next : all) {
            if (next.getPreloadStatus() == 3) {
                JSONUtil.put(jSONArray, next.getConfig().getLaunchConfig().getAppId());
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "appIds", (Object) jSONArray);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"getDMMinaInfo"})
    public void getVersionInfo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getDMMinaInfoSubJSBridge().getDMMinaInfo(jSONObject, callbackFunction);
    }

    @JsInterface({"GC"})
    /* renamed from: GC */
    public void mo57028GC(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getGCSubJSBridge().mo57080gc(jSONObject, callbackFunction);
    }

    @JsInterface({"getBundleUrl"})
    public void getBundleUrl(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getBundleUrlSubJSBridge().getBundleUrl(jSONObject, callbackFunction);
    }

    @JsInterface({"setBundleUrl"})
    public void setBundleUrl(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getBundleUrlSubJSBridge().setBundleUrl(jSONObject, callbackFunction);
    }

    @JsInterface({"scanQRCode"})
    public void scanQrCode(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getScanSubJSBridge().scan(jSONObject, callbackFunction);
    }

    @JsInterface({"getDevModeList"})
    public void getDevModeList(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getDevModeSubJSBridge().getDevModeList(jSONObject, callbackFunction);
    }

    @JsInterface({"setLaunchInterceptDevMode"})
    public void setLaunchInterceptDevMode(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getDevModeSubJSBridge().setLaunchInterceptDevMode(jSONObject, callbackFunction);
    }

    @JsInterface({"setVConsole"})
    public void setVConsole(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getVConsoleJSBridge().setVConsole(jSONObject, callbackFunction);
    }

    @JsInterface({"getVConsole"})
    public void getVConsole(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getVConsoleJSBridge().getVConsole(jSONObject, callbackFunction);
    }

    @JsInterface({"launchToDidiMiniProgram"})
    public void launchToDidiMiniProgram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getDevModeSubJSBridge().launchToDidiMiniProgram(jSONObject, callbackFunction);
    }

    @JsInterface({"downloadGiftBundle"})
    public void downloadGiftBundle(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getDevModeSubJSBridge().downloadGiftBundle(jSONObject, callbackFunction);
    }

    @JsInterface({"debugger"})
    public void debugger(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.mJsBridgeManager.getDevModeSubJSBridge().debugger(jSONObject, callbackFunction);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    @com.didi.dimina.container.bridge.base.JsInterface({"jumpToNativePage"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void jumpToNativePage(org.json.JSONObject r4, com.didi.dimina.container.bridge.base.CallbackFunction r5) {
        /*
            r3 = this;
            com.didi.dimina.container.DMMina r5 = r3.mDimina
            androidx.fragment.app.FragmentActivity r5 = r5.getActivity()
            java.lang.String r0 = "pageName"
            java.lang.String r4 = r4.optString(r0)
            int r0 = r4.hashCode()
            r1 = 1734733563(0x6765eefb, float:1.08583034E24)
            r2 = 1
            if (r0 == r1) goto L_0x0028
            r1 = 1865400007(0x6f2fbec7, float:5.4390512E28)
            if (r0 == r1) goto L_0x001d
            goto L_0x0032
        L_0x001d:
            java.lang.String r0 = "sandbox"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = 0
            goto L_0x0033
        L_0x0028:
            java.lang.String r0 = "bridgeLog"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0032
            r4 = 1
            goto L_0x0033
        L_0x0032:
            r4 = -1
        L_0x0033:
            java.lang.String r0 = "fragment_index"
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            if (r4 == 0) goto L_0x004f
            if (r4 == r2) goto L_0x003c
            goto L_0x0060
        L_0x003c:
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<com.didi.dimina.starbox.module.UniversalActivity> r2 = com.didi.dimina.starbox.module.UniversalActivity.class
            r4.<init>(r5, r2)
            r4.setFlags(r1)
            r1 = 25
            r4.putExtra(r0, r1)
            r5.startActivity(r4)
            goto L_0x0060
        L_0x004f:
            android.content.Intent r4 = new android.content.Intent
            java.lang.Class<com.didi.dimina.starbox.module.UniversalActivity> r2 = com.didi.dimina.starbox.module.UniversalActivity.class
            r4.<init>(r5, r2)
            r4.setFlags(r1)
            r1 = 2
            r4.putExtra(r0, r1)
            r5.startActivity(r4)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.starbox.module.DMStarBoxBridgeModule.jumpToNativePage(org.json.JSONObject, com.didi.dimina.container.bridge.base.CallbackFunction):void");
    }

    @JsInterface({"enableMonitorUpdate"})
    public void enableMonitorUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        PerfFloatPage.trigger(jSONObject.optBoolean("enable"), jSONObject.optString("appId"));
    }

    @JsInterface({"isWebViewJSEngine"})
    public void isWebViewJSEngine(JSONObject jSONObject, CallbackFunction callbackFunction) {
        boolean webViewJSEngineEnabled = DebugKitStoreUtil.getWebViewJSEngineEnabled();
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "useWebViewJSEngine", webViewJSEngineEnabled);
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"enableWebViewJSEngine"})
    public void enableWebViewJSEngine(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DebugKitStoreUtil.setWebViewJSEngineEnabled(jSONObject.optBoolean("enable", false));
        CallBackUtil.onSuccess(callbackFunction);
    }

    @JsInterface({"setReminderBoard"})
    public void setUncaughtErrorBoard(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DebugKitStoreUtil.setUnCaughtErrorBoardSwitch(jSONObject.optBoolean("enable", false));
        CallBackUtil.onSuccess(callbackFunction);
    }

    @JsInterface({"getReminderBoard"})
    public void getUncaughtErrorBorad(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        JSONUtil.put(jSONObject2, "enable", DebugKitStoreUtil.getUncaughtErrorBoardOpen());
        CallBackUtil.onSuccess(jSONObject2, callbackFunction);
    }

    @JsInterface({"getReminderHistroyList"})
    public void getUncaughtErrorHistoryList(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            String optString = jSONObject.optString("appId");
            LinkedList<String> errorList = UncaughtErrorManager.INSTANCE.getErrorList(optString);
            LogUtil.iRelease("getUncaughtErrorHistoryList", "appid:" + optString + "\t list : " + errorList);
            JSONObject jSONObject2 = new JSONObject();
            if (errorList != null && errorList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < errorList.size(); i++) {
                    jSONArray.put(JSONUtil.toJSONObject(errorList.get(i)));
                }
                JSONUtil.put(jSONObject2, "data", (Object) jSONArray);
            }
            LogUtil.iRelease("getUncaughtErrorHistoryList", "转化后的json内容 : " + jSONObject2);
            CallBackUtil.onSuccess(jSONObject2, callbackFunction);
        } catch (Exception e) {
            LogUtil.eRelease("getUncaughtErrorHistoryList", " 发生异常 : " + e.toString());
            e.printStackTrace();
            CallBackUtil.onFail("数据转化过程中发生异常", callbackFunction);
        }
    }

    public void onDestroy() {
        this.mJsBridgeManager.getDevModeSubJSBridge().onDestroy();
    }
}
