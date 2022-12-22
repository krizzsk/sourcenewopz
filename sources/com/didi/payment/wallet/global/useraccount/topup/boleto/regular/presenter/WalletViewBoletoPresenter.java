package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletViewBoletoContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoSendEmailResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletViewBoletoModel;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletViewBoletoPresenter implements WalletViewBoletoContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f31950a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletViewBoletoContract.View f31951b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f31952c;

    /* renamed from: d */
    private WalletViewBoletoModel f31953d;

    public WalletViewBoletoPresenter(FragmentActivity fragmentActivity, WalletViewBoletoContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f31950a = fragmentActivity;
        this.f31951b = view;
        this.f31952c = walletLoadingContract;
        this.f31953d = new WalletViewBoletoModel(fragmentActivity);
    }

    public void sendEmail(WalletBoletoResp walletBoletoResp) {
        this.f31952c.showLoadingDialog();
        this.f31953d.sendEmail(walletBoletoResp, new RpcService.Callback<WalletBoletoSendEmailResp>() {
            public void onSuccess(WalletBoletoSendEmailResp walletBoletoSendEmailResp) {
                WalletViewBoletoPresenter.this.f31952c.dismissLoadingDialog();
                if (walletBoletoSendEmailResp == null) {
                    WalletToast.showFailedMsg(WalletViewBoletoPresenter.this.f31950a, WalletViewBoletoPresenter.this.f31950a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                } else if (walletBoletoSendEmailResp.errno == 0) {
                    WalletViewBoletoPresenter.this.f31951b.onEmailSentSuccess();
                } else {
                    WalletToast.showFailedMsg(WalletViewBoletoPresenter.this.f31950a, walletBoletoSendEmailResp.errmsg);
                }
            }

            public void onFailure(IOException iOException) {
                WalletViewBoletoPresenter.this.f31952c.dismissLoadingDialog();
                WalletToast.showFailedMsg(WalletViewBoletoPresenter.this.f31950a, WalletViewBoletoPresenter.this.f31950a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                WalletViewBoletoPresenter.this.f31951b.onNetworkError();
            }
        });
    }
}
