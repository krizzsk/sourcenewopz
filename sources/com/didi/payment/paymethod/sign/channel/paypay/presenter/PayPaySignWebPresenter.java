package com.didi.payment.paymethod.sign.channel.paypay.presenter;

import android.os.CountDownTimer;
import com.didi.payment.paymethod.server.global.GlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.IGlobalPayMethodModel;
import com.didi.payment.paymethod.server.global.request.SignPollingQueryReq;
import com.didi.payment.paymethod.server.global.response.SignPollingQueryResp;
import com.didi.payment.paymethod.sign.channel.paypay.contract.PayPaySignWebContract;
import com.didi.sdk.fastframe.model.ResultCallback;
import java.io.IOException;

public class PayPaySignWebPresenter implements PayPaySignWebContract.Presenter {

    /* renamed from: a */
    private static final int f31011a = 182;

    /* renamed from: b */
    private IGlobalPayMethodModel f31012b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CountDownTimer f31013c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayPaySignWebContract.View f31014d;

    public PayPaySignWebPresenter(PayPaySignWebContract.View view) {
        this.f31014d = view;
        this.f31012b = new GlobalPayMethodModel(view.getActivity());
    }

    public void pollSignResult(int i, int i2) {
        if (i > 0 && i2 > 0) {
            CountDownTimer countDownTimer = this.f31013c;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f31014d.showLoadingDialog();
            final int i3 = i2 * 1000;
            final int i4 = i;
            this.f31013c = new CountDownTimer((long) (i * i3), (long) i3) {
                public void onTick(long j) {
                    PayPaySignWebPresenter.this.m21807a(i4 - ((int) (j / ((long) i3))));
                }

                public void onFinish() {
                    PayPaySignWebPresenter.this.f31014d.dismissLoadingDialog();
                    PayPaySignWebPresenter.this.m21807a(i4);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21807a(int i) {
        SignPollingQueryReq signPollingQueryReq = new SignPollingQueryReq();
        signPollingQueryReq.channelId = 182;
        signPollingQueryReq.pollingTimes = i;
        this.f31012b.pollSignStatus(signPollingQueryReq, new ResultCallback<SignPollingQueryResp>() {
            public void failure(IOException iOException) {
            }

            public void success(SignPollingQueryResp signPollingQueryResp) {
                if (signPollingQueryResp != null && signPollingQueryResp.errNo == 0) {
                    int i = signPollingQueryResp.status;
                    if (i == 1) {
                        PayPaySignWebPresenter.this.f31014d.dismissLoadingDialog();
                        PayPaySignWebPresenter.this.f31014d.onSignSuccess(signPollingQueryResp.hintMsg);
                        PayPaySignWebPresenter.this.f31013c.cancel();
                    } else if (i == 2) {
                        PayPaySignWebPresenter.this.f31014d.dismissLoadingDialog();
                        PayPaySignWebPresenter.this.f31014d.onSignFailure(signPollingQueryResp.hintMsg);
                        PayPaySignWebPresenter.this.f31013c.cancel();
                    }
                }
            }
        });
    }
}
