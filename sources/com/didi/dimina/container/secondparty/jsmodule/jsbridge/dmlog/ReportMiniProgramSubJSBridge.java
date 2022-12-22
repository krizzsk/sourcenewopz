package com.didi.dimina.container.secondparty.jsmodule.jsbridge.dmlog;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.TraceUtil;
import org.json.JSONObject;

public class ReportMiniProgramSubJSBridge {

    /* renamed from: a */
    private final DMMina f17193a;

    public ReportMiniProgramSubJSBridge(DMMina dMMina) {
        this.f17193a = dMMina;
    }

    public void report(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject == null) {
            CallBackUtil.onSuccess(callbackFunction);
            return;
        }
        TraceUtil.trackReportMiniProgramEvent(this.f17193a.getMinaIndex(), jSONObject);
        CallBackUtil.onSuccess(callbackFunction);
    }
}
