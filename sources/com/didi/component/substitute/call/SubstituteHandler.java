package com.didi.component.substitute.call;

import android.net.Uri;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.raven.config.RavenKey;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/component/substitute/call/SubstituteHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "comp-substitute-call_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SubstituteHandler.kt */
public final class SubstituteHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Uri uri = request.getUri();
        Intrinsics.checkNotNullExpressionValue(uri, "request.uri");
        String queryParameter = uri.getQueryParameter("detail_data");
        if (queryParameter != null) {
            JSONObject jSONObject = new JSONObject(queryParameter);
            if (jSONObject.has("form_operation_type") && jSONObject.optInt("form_operation_type") == 1) {
                Map hashMap = new HashMap();
                hashMap.put("k", "click");
                hashMap.put(RavenKey.VERSION, "select_passenger");
                hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "estimate_page");
                GlobalOmegaUtils.trackEvent("ibt_gp_estimate_select_passenger_ck", (Map<String, Object>) hashMap);
                BaseEventPublisher publisher = BaseEventPublisher.getPublisher();
                SubstituteCallModel substituteCallModel = FormStore.getInstance().getSubstituteCallModel();
                publisher.publish(BaseEventKeys.Estimate.EVENT_OPEN_SUBSTITUTE_CALL, substituteCallModel == null ? null : Integer.valueOf(substituteCallModel.getStyle()));
            }
        }
    }
}
