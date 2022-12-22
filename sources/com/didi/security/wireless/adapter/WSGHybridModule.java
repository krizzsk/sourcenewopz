package com.didi.security.wireless.adapter;

import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class WSGHybridModule extends BaseHybridModule {

    /* renamed from: a */
    private final String f38621a = WSGHybridModule.class.getSimpleName();

    public WSGHybridModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
    }

    @JsInterface({"collect"})
    public void collect(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        String str2 = this.f38621a;
        C13358a.m27349a(str2, "params: " + jSONObject.toString());
        try {
            str = (String) jSONObject.get("url");
        } catch (JSONException e) {
            e.printStackTrace();
            str = null;
        }
        String doCollect = SecurityWrapper.doCollect(str);
        JSONObject jSONObject2 = new JSONObject();
        if (doCollect == null) {
            doCollect = "";
        }
        try {
            jSONObject2.put("wsgenv", doCollect);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String str3 = this.f38621a;
        C13358a.m27349a(str3, "wsgenv: " + jSONObject2.toString());
        callbackFunction.onCallBack(jSONObject2);
    }
}
