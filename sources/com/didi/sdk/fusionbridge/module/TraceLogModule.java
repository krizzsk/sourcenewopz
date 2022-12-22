package com.didi.sdk.fusionbridge.module;

import android.app.Activity;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import java.util.Iterator;
import org.json.JSONObject;

public class TraceLogModule extends BaseHybridModule {

    /* renamed from: a */
    private Activity f36006a;

    public TraceLogModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f36006a = hybridableContainer.getActivity();
    }

    @JsInterface({"traceLog"})
    public void traceLog(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            jSONObject.optString("eventId");
            JSONObject optJSONObject = jSONObject.optJSONObject("extraInfo");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                String str = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    String obj = optJSONObject.opt(next).toString();
                    str = str + String.format("[%s=%s]", new Object[]{next, obj});
                }
            }
            callbackFunction.onCallBack(new JSONObject());
        }
    }

    @JsInterface({"upload_user_log", "uploadUserLog"})
    public void uploadUserLog(CallbackFunction callbackFunction) {
        this.f36006a.finish();
        callbackFunction.onCallBack(new JSONObject());
    }
}
