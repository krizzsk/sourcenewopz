package com.didi.entrega.customer.component.error;

import com.didi.entrega.customer.component.error.Contract;
import com.didi.entrega.customer.foundation.util.ToastUtil;

public class ErrorHandleView extends Contract.AbsErrorHandleView {
    public void showErrorTip(String str) {
        ToastUtil.showCustomerToast(getScopeContext(), str);
    }
}
