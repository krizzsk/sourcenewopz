package com.didi.sdk.global.paypal.presenter;

import com.didi.sdk.global.paypal.contract.PayPalDetailContract;
import com.didi.sdk.global.paypal.model.PayPalModel;
import com.didi.sdk.global.paypal.model.bean.PayPalSignCancelResult;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class GlobalRemovePayPalPresenter implements PayPalDetailContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public PayPalDetailContract.View f36206a;

    /* renamed from: b */
    private PayPalModel f36207b;

    public GlobalRemovePayPalPresenter(PayPalDetailContract.View view) {
        this.f36206a = view;
        this.f36207b = new PayPalModel(view.getContext());
    }

    public void removeCard(int i) {
        PayPalDetailContract.View view = this.f36206a;
        view.showLoadingDialog(view.getContext().getString(R.string.one_payment_global_net_toast_loading));
        this.f36207b.cancelSign(i, new RpcService.Callback<PayPalSignCancelResult>() {
            public void onSuccess(PayPalSignCancelResult payPalSignCancelResult) {
                GlobalRemovePayPalPresenter.this.f36206a.dismissLoadingDialog();
                if (payPalSignCancelResult != null) {
                    if (payPalSignCancelResult.errNo == 0) {
                        GlobalRemovePayPalPresenter.this.f36206a.showToast(payPalSignCancelResult.hingMsg);
                        GlobalRemovePayPalPresenter.this.f36206a.onCancelSignSuccess();
                    } else if (payPalSignCancelResult.errNo == 10601 || payPalSignCancelResult.errNo == 1020 || payPalSignCancelResult.errNo == 10403) {
                        GlobalRemovePayPalPresenter.this.f36206a.showToast(payPalSignCancelResult.hingMsg);
                    } else {
                        GlobalRemovePayPalPresenter.this.f36206a.showToast(payPalSignCancelResult.hingMsg);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                GlobalRemovePayPalPresenter.this.f36206a.dismissLoadingDialog();
            }
        });
    }
}
