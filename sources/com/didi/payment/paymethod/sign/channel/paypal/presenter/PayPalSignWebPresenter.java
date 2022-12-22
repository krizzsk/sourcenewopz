package com.didi.payment.paymethod.sign.channel.paypal.presenter;

import android.os.CountDownTimer;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.IGlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.sign.channel.paypal.contract.PayPalSignWebContract;
import com.didi.sdk.fastframe.model.ResultCallback;
import java.io.IOException;

public class PayPalSignWebPresenter implements PayPalSignWebContract.Presenter {

    /* renamed from: a */
    private static final int f30988a = 183;

    /* renamed from: b */
    private IGlobalPayMethodModel f30989b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CountDownTimer f30990c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayPalSignWebContract.View f30991d;

    public PayPalSignWebPresenter(PayPalSignWebContract.View view) {
        this.f30991d = view;
        this.f30989b = new GlobalPayMethodModel(view.getActivity());
    }

    public void pollSignResult(int i, int i2) {
        if (i > 0 && i2 > 0) {
            CountDownTimer countDownTimer = this.f30990c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            final int i3 = i2 * 1000;
            this.f30991d.showLoadingDialog();
            final int i4 = i;
            this.f30990c = new CountDownTimer((long) (i * i3), (long) i3) {
                public void onTick(long j) {
                    PayPalSignWebPresenter.this.m21788a(i4 - ((int) (j / ((long) i3))));
                }

                public void onFinish() {
                    PayPalSignWebPresenter.this.f30991d.dismissLoadingDialog();
                    PayPalSignWebPresenter.this.m21788a(i4);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21788a(int i) {
        SignPollingQueryReq signPollingQueryReq = new SignPollingQueryReq();
        signPollingQueryReq.channelId = 183;
        signPollingQueryReq.pollingTimes = i;
        this.f30989b.pollSignStatus(signPollingQueryReq, new ResultCallback<SignPollingQueryResp>() {
            public void failure(IOException iOException) {
            }

            public void success(SignPollingQueryResp signPollingQueryResp) {
                if (signPollingQueryResp != null && signPollingQueryResp.errNo == 0) {
                    int i = signPollingQueryResp.status;
                    if (i == 1) {
                        PayPalSignWebPresenter.this.f30991d.dismissLoadingDialog();
                        PayPalSignWebPresenter.this.f30991d.onSignSuccess(signPollingQueryResp.hintMsg);
                        PayPalSignWebPresenter.this.f30990c.cancel();
                    } else if (i == 2) {
                        PayPalSignWebPresenter.this.f30991d.dismissLoadingDialog();
                        PayPalSignWebPresenter.this.f30991d.onSignFailure(signPollingQueryResp.hintMsg);
                        PayPalSignWebPresenter.this.f30990c.cancel();
                    }
                }
            }
        });
    }
}
