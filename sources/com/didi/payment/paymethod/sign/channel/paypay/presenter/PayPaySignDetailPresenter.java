package com.didi.payment.paymethod.sign.channel.paypay.presenter;

import android.text.TextUtils;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.IGlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignCancelReq;
import com.didi.payment.paymethod.server.global.response.SignCancelResp;
import com.didi.payment.paymethod.sign.channel.paypay.contract.PayPaySignDetailContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class PayPaySignDetailPresenter implements PayPaySignDetailContract.Presenter {

    /* renamed from: a */
    private static final int f31008a = 182;

    /* renamed from: b */
    private IGlobalPayMethodModel f31009b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public PayPaySignDetailContract.View f31010c;

    public PayPaySignDetailPresenter(PayPaySignDetailContract.View view) {
        this.f31010c = view;
        this.f31009b = new GlobalPayMethodModel(view.getActivity());
    }

    public void requestCancelSign() {
        this.f31010c.showLoadingDialog();
        SignCancelReq signCancelReq = new SignCancelReq();
        signCancelReq.channelId = 182;
        this.f31009b.cancelSign(signCancelReq, new RpcService.Callback<SignCancelResp>() {
            public void onSuccess(SignCancelResp signCancelResp) {
                PayPaySignDetailPresenter.this.f31010c.dismissLoadingDialog();
                if (signCancelResp != null) {
                    if (signCancelResp.errNo == 0) {
                        PayPaySignDetailPresenter.this.f31010c.onCancelSignSuccess(TextUtils.isEmpty(signCancelResp.hingMsg) ? signCancelResp.errMsg : signCancelResp.hingMsg);
                    } else {
                        PayPaySignDetailPresenter.this.f31010c.onCancelSignFailure(signCancelResp.errMsg);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                PayPaySignDetailPresenter.this.f31010c.dismissLoadingDialog();
                PayPaySignDetailPresenter.this.f31010c.onCancelSignFailure(PayPaySignDetailPresenter.this.f31010c.getActivity().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }
}
