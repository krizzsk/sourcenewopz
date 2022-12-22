package com.didi.safety.god.fusion;

import android.app.Activity;
import android.content.Context;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.safety.god.manager.SafetyGod;
import com.didi.safety.god.manager.SafetyGodActivityDelegate;
import com.didi.safety.god.manager.SafetyGodConfig;
import com.didi.safety.god.manager.SafetyGodResult;
import com.didi.safety.god.manager.callback.SafetyGodCallBack;
import com.didi.safety.god.util.Constant;
import com.didi.safety.god.util.LogUtils;
import com.didi.safety.god2020.p145ui.GlobalCardDetectionAct2;
import com.didichuxing.dfbasesdk.utils.GsonUtils;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

public class GlobalDoorGodSafetyGodModule extends BaseHybridModule implements Serializable {
    private Activity mActivity;

    public static void open(JSONObject jSONObject, CallbackFunction callbackFunction, Activity activity) {
    }

    public GlobalDoorGodSafetyGodModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.mActivity = hybridableContainer.getActivity();
    }

    @JsInterface({"openCardOcr"})
    public void openCardOcr(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtils.m24584i("H5 openCardOcr called, params===" + jSONObject + ", sdkVer=" + "7.0.0.7");
        open(jSONObject, callbackFunction, this.mActivity);
    }

    @Deprecated
    @JsInterface({"openCardOcr2"})
    public void openCardOcr2(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtils.m24584i("H5 openCardOcr2 called, params===" + jSONObject + ", sdkVer=" + "7.0.0.7");
        openInner(jSONObject, callbackFunction, this.mActivity, GlobalCardDetectionAct2.class);
    }

    @JsInterface({"openCardOcr3"})
    public void openCardOcr3(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtils.m24584i("H5 openCardOcr2 called, params===" + jSONObject + ", sdkVer=" + "7.0.0.7");
        openInner(jSONObject, callbackFunction, this.mActivity, GlobalCardDetectionAct2.class);
    }

    private static void openInner(JSONObject jSONObject, final CallbackFunction callbackFunction, Activity activity, Class<?> cls) {
        String optString = jSONObject.optString("cardArray");
        String optString2 = jSONObject.optString("keeperId");
        int optInt = jSONObject.optInt("bizCode");
        String optString3 = jSONObject.optString("token");
        String optString4 = jSONObject.optString("nation");
        String optString5 = jSONObject.optString("lang");
        boolean optBoolean = jSONObject.has("isDebug") ? jSONObject.optBoolean("isDebug") : false;
        String str = null;
        if (jSONObject.has("offLineEnv")) {
            str = jSONObject.optString("offLineEnv");
        }
        LogUtils.m24579d(Constant.TAG, "nation is " + optString4);
        SafetyGod.launch(activity, new SafetyGodConfig.Builder().setBizCode(optInt).setToken(optString3).setKeeperId(optString2).setCardArray(optString).setNation(optString4).setLanguage(optString5).setDebug(optBoolean).setOffLineEnv(str).setActivityDelegate(new SafetyGodActivityDelegate() {
            public Context getAttachBaseContext(Context context) {
                return null;
            }
        }).builder(), new SafetyGodCallBack() {
            public void onCallBack(SafetyGodResult safetyGodResult) {
                HashMap hashMap = new HashMap();
                hashMap.put("code", Integer.valueOf(safetyGodResult.getCode()));
                hashMap.put("message", safetyGodResult.getMessage());
                hashMap.put("result", safetyGodResult.getLastConfig());
                String jsonStr = GsonUtils.toJsonStr(hashMap);
                callbackFunction.onCallBack(jsonStr);
            }
        });
    }
}
