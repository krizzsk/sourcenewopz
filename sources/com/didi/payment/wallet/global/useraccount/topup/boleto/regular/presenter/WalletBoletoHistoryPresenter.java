package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoHistoryContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoHistoryModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoHistoryResp;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoHistoryPresenter implements WalletBoletoHistoryContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f31946a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoHistoryContract.View f31947b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f31948c;

    /* renamed from: d */
    private WalletBoletoHistoryModel f31949d;

    public WalletBoletoHistoryPresenter(FragmentActivity fragmentActivity, WalletBoletoHistoryContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f31946a = fragmentActivity;
        this.f31947b = view;
        this.f31948c = walletLoadingContract;
        this.f31949d = new WalletBoletoHistoryModel(fragmentActivity);
    }

    public void requestData() {
        this.f31948c.showLoadingDialog();
        this.f31949d.requestBoletoHistory(new RpcService.Callback<WalletBoletoHistoryResp>() {
            public void onSuccess(WalletBoletoHistoryResp walletBoletoHistoryResp) {
                WalletBoletoHistoryPresenter.this.f31948c.dismissLoadingDialog();
                if (walletBoletoHistoryResp == null) {
                    WalletToast.showFailedMsg(WalletBoletoHistoryPresenter.this.f31946a, WalletBoletoHistoryPresenter.this.f31946a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoHistoryPresenter.this.f31947b.onNetworkError();
                } else if (walletBoletoHistoryResp.errno == 0) {
                    WalletBoletoHistoryPresenter.this.f31947b.displayBoletoHistory(walletBoletoHistoryResp.data);
                } else {
                    WalletToast.showFailedMsg(WalletBoletoHistoryPresenter.this.f31946a, walletBoletoHistoryResp.errmsg);
                    WalletBoletoHistoryPresenter.this.f31947b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoHistoryPresenter.this.f31948c.dismissLoadingDialog();
                WalletToast.showFailedMsg(WalletBoletoHistoryPresenter.this.f31946a, WalletBoletoHistoryPresenter.this.f31946a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoHistoryPresenter.this.f31947b.onNetworkError();
            }
        });
    }
}
