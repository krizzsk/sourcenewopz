package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter;

import android.app.Activity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoZipCodeContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchModel;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoZipCodePresenter implements WalletBoletoZipCodeContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f31871a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoZipCodeContract.View f31872b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f31873c;

    /* renamed from: d */
    private AddressPatchModel f31874d;

    public WalletBoletoZipCodePresenter(Activity activity, WalletBoletoZipCodeContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f31871a = activity;
        this.f31872b = view;
        this.f31873c = walletLoadingContract;
        this.f31874d = new AddressPatchModel(activity);
    }

    public void requestData(String str) {
        this.f31873c.showLoadingDialog();
        this.f31874d.requestBoletoAddress(str, new RpcService.Callback<AddressFromZipCodeResp>() {
            public void onSuccess(AddressFromZipCodeResp addressFromZipCodeResp) {
                WalletBoletoZipCodePresenter.this.f31873c.dismissLoadingDialog();
                if (addressFromZipCodeResp == null) {
                    WalletToast.showFailedMsg(WalletBoletoZipCodePresenter.this.f31871a, WalletBoletoZipCodePresenter.this.f31871a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoZipCodePresenter.this.f31872b.onNetworkError();
                } else if (addressFromZipCodeResp.errno == 0) {
                    WalletBoletoZipCodePresenter.this.f31872b.sendAddress(addressFromZipCodeResp.data);
                } else {
                    WalletToast.showFailedMsg(WalletBoletoZipCodePresenter.this.f31871a, addressFromZipCodeResp.errmsg);
                    WalletBoletoZipCodePresenter.this.f31872b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoZipCodePresenter.this.f31873c.dismissLoadingDialog();
                WalletToast.showFailedMsg(WalletBoletoZipCodePresenter.this.f31871a, WalletBoletoZipCodePresenter.this.f31871a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoZipCodePresenter.this.f31872b.onNetworkError();
            }
        });
    }
}
