package com.didi.soda.customer.p165h5.hybird;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import org.json.JSONObject;

/* renamed from: com.didi.soda.customer.h5.hybird.WebViewModelCallback */
public interface WebViewModelCallback {
    void bindCard(JSONObject jSONObject, CallbackFunction callbackFunction);

    void finishedLoadHtml();

    ScopeContext proviedScopeContext();

    void queryPayStatus(JSONObject jSONObject, CallbackFunction callbackFunction);

    JSONObject registerTrigger(JSONObject jSONObject);

    void selectCoupon(String str, String str2, int i, String str3);

    void setRiskAuthResult(JSONObject jSONObject);

    void unregisterTrigger(JSONObject jSONObject);
}
