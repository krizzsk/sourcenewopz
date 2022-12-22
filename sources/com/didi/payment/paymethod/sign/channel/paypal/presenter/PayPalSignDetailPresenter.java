package com.didi.payment.paymethod.sign.channel.paypal.presenter;

import android.text.TextUtils;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.IGlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignCancelReq;
import com.didi.payment.paymethod.server.global.response.SignCancelResp;
import com.didi.payment.paymethod.sign.channel.paypal.contract.PayPalSignDetailContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class PayPalSignDetailPresenter implements PayPalSignDetailContract.Presenter {

    /* renamed from: a */
    private static final int f30985a = 183;

    /* renamed from: b */
    private IGlobalPayMethodModel f30986b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PayPalSignDetailContract.View f30987c;

    public PayPalSignDetailPresenter(PayPalSignDetailContract.View view) {
        this.f30987c = view;
        this.f30986b = new GlobalPayMethodModel(view.getActivity());
    }

    public void requestCancelSign() {
        this.f30987c.showLoadingDialog();
        SignCancelReq signCancelReq = new SignCancelReq();
        signCancelReq.channelId = 183;
        this.f30986b.cancelSign(signCancelReq, new RpcService.Callback<SignCancelResp>() {
            public void onSuccess(SignCancelResp signCancelResp) {
                PayPalSignDetailPresenter.this.f30987c.dismissLoadingDialog();
                if (signCancelResp != null) {
                    if (signCancelResp.errNo == 0) {
                        PayPalSignDetailPresenter.this.f30987c.onCancelSignSuccess(TextUtils.isEmpty(signCancelResp.hingMsg) ? signCancelResp.errMsg : signCancelResp.hingMsg);
                    } else {
                        PayPalSignDetailPresenter.this.f30987c.onCancelSignFailure(signCancelResp.errMsg);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                PayPalSignDetailPresenter.this.f30987c.dismissLoadingDialog();
                PayPalSignDetailPresenter.this.f30987c.onCancelSignFailure(PayPalSignDetailPresenter.this.f30987c.getActivity().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }
}
