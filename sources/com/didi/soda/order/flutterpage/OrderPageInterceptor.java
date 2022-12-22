package com.didi.soda.order.flutterpage;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.router.IInterceptor;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;
import com.taxis99.R;

public class OrderPageInterceptor implements IInterceptor {

    /* renamed from: a */
    private static final String f43503a = "OrderPageInterceptor";

    public boolean intercept(Request request, Response response) {
        Bundle extras = request.getExtras();
        boolean z = true;
        if (extras == null) {
            LogUtil.m29104i(f43503a, "intercept args ==null");
        } else if (TextUtils.isEmpty(extras.getString("orderid"))) {
            LogUtil.m29104i(f43503a, "intercept orderId ==null");
        } else {
            z = false;
        }
        if (z) {
            ToastUtil.showCustomerErrorToast((ScopeContext) null, ResourceHelper.getString(R.string.customer_order_intercept_error));
            ErrorTracker.create(ErrorConst.ErrorName.SALING_C_ORDER_PAGE_INTERCEPTOR_ERROR).addModuleName("order").build().trackError();
        }
        return z;
    }
}
