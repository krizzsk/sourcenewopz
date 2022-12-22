package com.didi.soda.business.page;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.router.IInterceptor;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;
import com.taxis99.R;

public class BusinessSearchPageInterceptor implements IInterceptor {

    /* renamed from: a */
    private static final String f39739a = "BusinessSearchPageInterceptor";

    public boolean intercept(Request request, Response response) {
        Bundle extras = request.getExtras();
        boolean z = true;
        if (extras == null) {
            LogUtil.m29102e(f39739a, "未传入页面信息");
        } else if (TextUtils.isEmpty(extras.getString(Const.PageParams.SHOP_ID))) {
            LogUtil.m29102e(f39739a, "未传入shopId");
        } else {
            z = false;
        }
        if (z) {
            ToastUtil.showCustomerErrorToast((ScopeContext) null, ResourceHelper.getString(R.string.customer_service_not_connected));
        }
        return z;
    }
}
