package com.didiglobal.p205sa.biz.component.ridecard;

import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo175978d2 = {"com/didiglobal/sa/biz/component/ridecard/RideCardPresenter$reqParams$1", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "getRequestParams", "Lorg/json/JSONObject;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.ridecard.RideCardPresenter$reqParams$1 */
/* compiled from: RideCardPresenter.kt */
public final class RideCardPresenter$reqParams$1 extends XEReqJSONParamsCallbackImpl {
    final /* synthetic */ RideCardPresenter this$0;

    RideCardPresenter$reqParams$1(RideCardPresenter rideCardPresenter) {
        this.this$0 = rideCardPresenter;
    }

    public JSONObject getRequestParams() {
        return new JSONObject(this.this$0.getParams());
    }
}
