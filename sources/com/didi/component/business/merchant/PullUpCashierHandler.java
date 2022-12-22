package com.didi.component.business.merchant;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.global.fintech.cashier.user.model.CashierParam;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.unifylogin.api.OneLoginFacade;
import global.didi.pay.merchant.processor.GlobalMerchantUnifiedPayProcessor;
import global.didi.pay.merchant.processor.model.MerchantWebRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/component/business/merchant/PullUpCashierHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PullUpCashierHandler.kt */
public final class PullUpCashierHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        boolean isLoginNow = OneLoginFacade.getStore().isLoginNow();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = request.getContext();
        Uri uri = request.getUri();
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("out_trade_id");
            String str = "";
            if (queryParameter == null) {
                queryParameter = str;
            }
            String queryParameter2 = uri.getQueryParameter(CashierParam.PARAM_FROM_TYPE);
            if (queryParameter2 == null) {
                queryParameter2 = str;
            }
            MerchantWebRequest newIns = MerchantWebRequest.Companion.newIns(queryParameter, queryParameter2);
            String queryParameter3 = uri.getQueryParameter(CashierParam.PARAM_MERCHANT_WSG_ENV);
            if (queryParameter3 != null) {
                str = queryParameter3;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("wsgenv", str);
            Unit unit = Unit.INSTANCE;
            newIns.setExtraParam(jSONObject);
            if (!(objectRef.element instanceof Activity)) {
                objectRef.element = ActivityLifecycleManager.getInstance().getCurrentActivity();
            }
            if (isLoginNow) {
                GlobalMerchantUnifiedPayProcessor globalMerchantUnifiedPayProcessor = GlobalMerchantUnifiedPayProcessor.INS;
                T t = objectRef.element;
                if (t != null) {
                    globalMerchantUnifiedPayProcessor.onHandleMerchantRequest((Activity) t, newIns);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            }
            OneLoginFacade.getFunction().addLoginListener(new PullUpCashierHandler$handle$2(objectRef, newIns));
            OneLoginFacade.getAction().go2Login((Context) objectRef.element);
        }
    }
}
