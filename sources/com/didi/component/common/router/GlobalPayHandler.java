package com.didi.component.common.router;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.component.common.util.GLog;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.wallet.dimina.DiminaLaunchModel;

public class GlobalPayHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Uri uri = request.getUri();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            Context context = request.getContext();
            if ((context instanceof Activity) || (context = ActivityLifecycleManager.getInstance().getCurrentActivity()) != null) {
                char c = 65535;
                int hashCode = path.hashCode();
                if (hashCode != -885536721) {
                    if (hashCode == -133949660 && path.equals(GlobalRouter.PAGE_PAY_ADD_CARD)) {
                        c = 1;
                    }
                } else if (path.equals(GlobalRouter.PAGE_PAY_METHOD_LIST)) {
                    c = 0;
                }
                if (c == 0) {
                    m7935a(uri, context);
                } else if (c == 1) {
                    m7936b(uri, context);
                }
            } else {
                GLog.m7967e("pay handler context is null, return");
            }
        }
    }

    /* renamed from: a */
    private void m7935a(Uri uri, Context context) {
        DidiGlobalPayMethodListData.Entrance entrance;
        int parseInt = GRouterUtil.parseInt(uri.getQueryParameter("from"), 0);
        if (parseInt == 0) {
            entrance = DidiGlobalPayMethodListData.Entrance.FROM_GUIDE;
        } else if (parseInt == 1) {
            entrance = DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR;
        } else if (parseInt != 2) {
            entrance = parseInt != 3 ? null : DidiGlobalPayMethodListData.Entrance.FROM_UNIFIED_PAY;
        } else {
            entrance = DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION;
        }
        DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity((Activity) context, GRouterUtil.parseInt(uri.getQueryParameter(GlobalRouter.PARAM_REQUEST_CODE), -1), new DidiGlobalPayMethodListData.PayMethodListParam(entrance));
    }

    /* renamed from: b */
    private void m7936b(Uri uri, Context context) {
        boolean z = true;
        int parseInt = GRouterUtil.parseInt(uri.getQueryParameter(ParamConst.PARAM_BIND_TYPE), 1);
        int parseInt2 = GRouterUtil.parseInt(uri.getQueryParameter("isShowLoading"), 1);
        String queryParameter = uri.getQueryParameter("orderId");
        String queryParameter2 = uri.getQueryParameter(DiminaLaunchModel.PRODUCT_LINE);
        int parseInt3 = GRouterUtil.parseInt(uri.getQueryParameter("isSignAfterOrder"), 0);
        int parseInt4 = GRouterUtil.parseInt(uri.getQueryParameter(GlobalRouter.PARAM_REQUEST_CODE), -1);
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        String queryParameter3 = uri.getQueryParameter("resource_id");
        addCardParam.bindType = parseInt;
        addCardParam.isShowLoading = parseInt2 == 1;
        addCardParam.orderId = queryParameter;
        addCardParam.resourceId = queryParameter3;
        addCardParam.productLine = queryParameter2;
        if (parseInt3 != 1) {
            z = false;
        }
        addCardParam.isSignAfterOrder = z;
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity((Activity) context, parseInt4, addCardParam);
    }
}
