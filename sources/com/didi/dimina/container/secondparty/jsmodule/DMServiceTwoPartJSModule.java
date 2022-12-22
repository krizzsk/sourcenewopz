package com.didi.dimina.container.secondparty.jsmodule;

import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.bridge.plugin.GlobalJSModuleManager;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.messager.jsmodule.JSModuleWrapper;
import com.didi.dimina.container.secondparty.trace.DiminaTraceService;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.UIHandlerUtil;
import org.json.JSONObject;

@DMServiceSubBridgeModule(level = 0)
public class DMServiceTwoPartJSModule extends BaseServiceModule {
    public static final String EXPORT_NAME = "DMServiceBridgeModule";
    private final FragmentActivity mActivity;
    private final DMServiceTwoPartJSModuleLazyParameter parameter;

    public DMServiceTwoPartJSModule(DMMina dMMina) {
        super(dMMina);
        LogUtil.m13411i("DiminaServiceJSModule init start");
        this.parameter = new DMServiceTwoPartJSModuleLazyParameter(dMMina);
        this.mActivity = dMMina.getActivity();
        doSubModulePreOperate(dMMina);
        LogUtil.m13411i("DiminaServiceJSModule init end  ");
    }

    @JsInterface({"getJSModuleLazyParameter"})
    public DMServiceTwoPartJSModuleLazyParameter getJSModuleLazyParameter() {
        return this.parameter;
    }

    private void doSubModulePreOperate(DMMina dMMina) {
        for (JSModuleWrapper next : GlobalJSModuleManager.getDMServiceSubJSModuleWrapper(dMMina)) {
            if (((DMServiceSubBridgeModule) next.getJSModuleClass().getAnnotation(DMServiceSubBridgeModule.class)).preCreateInstance()) {
                next.getServiceModuleInstance(dMMina);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @JsInterface({"scanCode"})
    public void scanCode(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getScan().scanCode(jSONObject, callbackFunction, this.mActivity);
    }

    @JsInterface({"navigateToMiniProgram"})
    public void navigateToMiniProgram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getMiniProgramNavigator().navigateToMiniProgram(jSONObject, callbackFunction);
    }

    @JsInterface({"navigateToDimina"})
    public void navigateToDimina(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getMiniProgramNavigator().navigateToDimina(jSONObject, callbackFunction);
    }

    @JsInterface({"traceRaven"})
    public void traceRaven(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getRavenSubJSBridge().traceRaven(jSONObject, callbackFunction);
    }

    @JsInterface({"enableApollo"})
    public void enableApollo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getApollo().enableApollo(jSONObject, callbackFunction);
    }

    @JsInterface({"dataFromApollo"})
    public void dataFromApollo(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getApollo().dataFromApollo(jSONObject, callbackFunction);
    }

    @JsInterface({"trace"})
    public void trace(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getOmega().trace(jSONObject, callbackFunction);
    }

    @JsInterface({"reportAnalytics"})
    public void reportAnalytics(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getOmega().trace(jSONObject.optString("eventName"), jSONObject.optJSONObject("data"), callbackFunction);
    }

    @JsInterface({"getSdkReportPoint"})
    public void getSdkReportPoint(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject.has("event")) {
            String optString = jSONObject.optString("event");
            JSONObject jSONObject2 = new JSONObject();
            if (DiminaTraceService.MAS_MONITOR_EVENT.LAUNCH_APP.equals(optString)) {
                JSONUtil.put(jSONObject2, "app_launch_time", (Object) String.valueOf(this.mDimina.getPerformance().getLaunchTime()));
            }
            callbackFunction.onCallBack(jSONObject2);
        }
    }

    @JsInterface({"chooseImage"})
    public void chooseImage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getImage().chooseImage(jSONObject, callbackFunction, this.mActivity);
    }

    @JsInterface({"getLocation"})
    public void getLocation(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLocation().getLocation(jSONObject, callbackFunction);
    }

    @JsInterface({"openLocation"})
    public void openLocation(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CallBackUtil.onFail("打开定位失败", callbackFunction);
    }

    @JsInterface({"startLocationUpdate"})
    public void startLocationUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLocation().startLocationUpdate(jSONObject, callbackFunction);
    }

    @JsInterface({"onLocationChange"})
    public void onLocationChange(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLocation().onLocationChange(jSONObject, callbackFunction);
    }

    @JsInterface({"offLocationChange"})
    public void offLocationChange(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLocation().offLocationChange(jSONObject, callbackFunction);
    }

    @JsInterface({"stopLocationUpdate"})
    public void stopLocationUpdate(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getLocation().stopLocationUpdate(jSONObject, callbackFunction);
    }

    @JsInterface({"createSocketTask"})
    public void createSocketTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getWebSocketSubJSBridge().createSocketTask(jSONObject, callbackFunction);
    }

    @JsInterface({"operateSocketTask"})
    public void operateSocketTask(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getWebSocketSubJSBridge().operateSocketTask(jSONObject, callbackFunction);
    }

    @JsInterface({"businessAuthorize"})
    public void businessAuthorize(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceTwoPartJSModule.this.lambda$businessAuthorize$0$DMServiceTwoPartJSModule(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$businessAuthorize$0$DMServiceTwoPartJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getSettingSubJSBridge().businessAuthorize(jSONObject, callbackFunction);
    }

    public /* synthetic */ void lambda$reportMiniProgram$1$DMServiceTwoPartJSModule(JSONObject jSONObject, CallbackFunction callbackFunction) {
        this.parameter.getReportMiniProgramSubJSBridge().report(jSONObject, callbackFunction);
    }

    @JsInterface({"reportMiniProgram"})
    public void reportMiniProgram(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                DMServiceTwoPartJSModule.this.lambda$reportMiniProgram$1$DMServiceTwoPartJSModule(this.f$1, this.f$2);
            }
        });
    }
}
