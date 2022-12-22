package com.didi.soda.customer.p165h5.invokejs;

import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/h5/invokejs/TrackTriggerCallback;", "Lcom/didi/soda/customer/h5/invokejs/TriggerCallback;", "()V", "onCallback", "", "moduleName", "", "jsMethodName", "data", "Lorg/json/JSONObject;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.h5.invokejs.TrackTriggerCallback */
/* compiled from: TrackTriggerCallback.kt */
public final class TrackTriggerCallback implements TriggerCallback {
    public void onCallback(String str, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "moduleName");
        Intrinsics.checkNotNullParameter(str2, "jsMethodName");
        int i = -1;
        String str3 = "";
        if (jSONObject != null) {
            try {
                i = jSONObject.optInt("errno");
                str3 = jSONObject.optString("errmsg");
                Intrinsics.checkNotNullExpressionValue(str3, "data.optString(WebConsta…JsResponse.ERROR_MSG_KEY)");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i != 0) {
            ErrorTracker.Builder addErrorType = ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_H5_BRIDGE_ERROR).addModuleName("hybrid").addErrorMsg(str3).addErrorType(String.valueOf(i));
            addErrorType.addParam("bridge", str + '.' + str2 + "()").build().trackError();
        }
    }
}
