package com.didi.component.openride;

import android.content.Context;
import com.didi.app.router.sidebar.BaseSideBarDRouterHandler;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.PayMethodInfoResult;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/component/openride/OpenRideDRouterHandler;", "Lcom/didi/app/router/sidebar/BaseSideBarDRouterHandler;", "()V", "callRealHandle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "comp-openride_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenRideDRouterHandler.kt */
public final class OpenRideDRouterHandler extends BaseSideBarDRouterHandler {
    public void callRealHandle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) "ride", (Object) ConfProxy.getInstance().getSelectedType())) {
            PayMethodInfoResult payMethodInfoResult = new PayMethodInfoResult();
            payMethodInfoResult.checkResult = request.getUri().getBooleanQueryParameter("pay_method_check_result", false);
            payMethodInfoResult.openRideBrand = request.getUri().getQueryParameter("open_ride_brand");
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.OpenRide.EVENT_SHOW_OPEN_RIDE, payMethodInfoResult);
            return;
        }
        Context context = request.getContext();
        LEGOToastHelper.showToast(context, ResourcesHelper.getString(context, R.string.GRider_fastboardingsidebar1_Invalid_QR_HZXJ));
    }
}
