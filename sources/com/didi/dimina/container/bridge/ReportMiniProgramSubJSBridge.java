package com.didi.dimina.container.bridge;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.TraceUtil;
import org.json.JSONObject;

public class ReportMiniProgramSubJSBridge {

    /* renamed from: a */
    private final DMMina f16654a;

    public ReportMiniProgramSubJSBridge(DMMina dMMina) {
        this.f16654a = dMMina;
    }

    public void report(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject == null) {
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        TraceUtil.trackReportMiniProgramEvent(this.f16654a.getMinaIndex(), jSONObject);
        CallBackUtil.onSuccess(callbackFunction);
    }
}
