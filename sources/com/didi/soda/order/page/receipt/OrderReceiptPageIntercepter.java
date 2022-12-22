package com.didi.soda.order.page.receipt;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.rpc.entity.OrderReceiptInfoEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.router.IInterceptor;
import com.didi.soda.router.Request;
import com.didi.soda.router.Response;
import com.taxis99.R;
import java.io.Serializable;

public class OrderReceiptPageIntercepter implements IInterceptor {
    public boolean intercept(Request request, Response response) {
        Bundle extras = request.getExtras();
        boolean z = true;
        if (extras != null) {
            String string = extras.getString("orderid");
            Serializable serializable = extras.getSerializable(Const.PageParams.RECEIPT_ENTITIES);
            boolean isEmpty = TextUtils.isEmpty(string);
            if ((serializable instanceof OrderReceiptInfoEntity) && !TextUtils.isEmpty(((OrderReceiptInfoEntity) serializable).email)) {
                z = isEmpty;
            }
        }
        if (z) {
            ToastUtil.showCustomerErrorToast((ScopeContext) null, ResourceHelper.getString(R.string.customer_order_intercept_error));
        }
        return z;
    }
}
