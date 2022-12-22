package com.didi.soda.customer.component.error;

import com.didi.soda.customer.component.error.Contract;
import com.didi.soda.customer.foundation.util.ToastUtil;

public class ErrorHandleView extends Contract.AbsErrorHandleView {
    public void showErrorTip(String str) {
        ToastUtil.showCustomerToast(getScopeContext(), str);
    }
}
