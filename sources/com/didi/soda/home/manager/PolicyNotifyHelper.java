package com.didi.soda.home.manager;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.taxis99.R;

public class PolicyNotifyHelper {

    public interface VoidCallback {
        void invoke(boolean z);
    }

    public static void submit(final ScopeContext scopeContext, String str, String str2, final boolean z, final VoidCallback voidCallback) {
        if (z) {
            DialogUtil.showLoadingDialog(scopeContext, false);
        }
        CustomerRpcManagerProxy.get().policyNotifyMe(str, str2, new CustomerRpcCallback<Object>() {
            public void onRpcSuccess(Object obj, long j) {
                if (z) {
                    DialogUtil.hideLoadingDialog();
                }
                VoidCallback voidCallback = voidCallback;
                if (voidCallback != null) {
                    voidCallback.invoke(true);
                }
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                if (z) {
                    DialogUtil.hideLoadingDialog();
                }
                if (sFRpcException != null && sFRpcException.getCode() == -1) {
                    ToastUtil.showCustomerErrorToast(scopeContext, ResourceHelper.getString(R.string.customer_get_data_failure));
                }
                VoidCallback voidCallback = voidCallback;
                if (voidCallback != null) {
                    voidCallback.invoke(false);
                }
            }
        });
    }
}
