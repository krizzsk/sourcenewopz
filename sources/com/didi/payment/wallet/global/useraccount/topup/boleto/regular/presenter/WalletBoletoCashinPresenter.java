package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoCashinContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoCashinModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoCashinResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget.BoletoCreateErrorFragment;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoCashinPresenter implements WalletBoletoCashinContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f31942a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoCashinContract.View f31943b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f31944c;

    /* renamed from: d */
    private WalletBoletoCashinModel f31945d;

    public WalletBoletoCashinPresenter(FragmentActivity fragmentActivity, WalletBoletoCashinContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f31942a = fragmentActivity;
        this.f31943b = view;
        this.f31944c = walletLoadingContract;
        this.f31945d = new WalletBoletoCashinModel(fragmentActivity);
    }

    public void submitBoleto(Long l) {
        this.f31944c.showLoadingDialog();
        this.f31945d.submitBoleto(l, new RpcService.Callback<WalletBoletoCashinResp>() {
            public void onSuccess(WalletBoletoCashinResp walletBoletoCashinResp) {
                WalletBoletoCashinPresenter.this.f31944c.dismissLoadingDialog();
                if (walletBoletoCashinResp == null) {
                    WalletToast.showFailedMsg(WalletBoletoCashinPresenter.this.f31942a, WalletBoletoCashinPresenter.this.f31942a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoCashinPresenter.this.f31943b.onNetworkError();
                } else if (walletBoletoCashinResp.errno == 0) {
                    WalletBoletoCashinPresenter.this.f31943b.displayBoleto(walletBoletoCashinResp.data);
                } else {
                    processError(WalletBoletoCashinPresenter.this.f31942a, walletBoletoCashinResp);
                    WalletBoletoCashinPresenter.this.f31943b.onNetworkError();
                }
            }

            private void processError(FragmentActivity fragmentActivity, WalletBoletoCashinResp walletBoletoCashinResp) {
                if (walletBoletoCashinResp.errno == 20100 || walletBoletoCashinResp.errno == 20101) {
                    BoletoCreateErrorFragment boletoCreateErrorFragment = new BoletoCreateErrorFragment();
                    boletoCreateErrorFragment.setData(walletBoletoCashinResp.errmsg);
                    boletoCreateErrorFragment.show(fragmentActivity.getSupportFragmentManager(), "createboletoerror");
                } else if (walletBoletoCashinResp.errno == 500) {
                    WalletToast.showFailedMsg(WalletBoletoCashinPresenter.this.f31942a, WalletBoletoCashinPresenter.this.f31942a.getResources().getString(R.string.wallet_boleto_cashin_error_server_error));
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoCashinPresenter.this.f31944c.dismissLoadingDialog();
                WalletToast.showFailedMsg(WalletBoletoCashinPresenter.this.f31942a, WalletBoletoCashinPresenter.this.f31942a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
            }
        });
    }
}
