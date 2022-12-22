package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter;

import android.app.Activity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchResp;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoAddressPresenter implements WalletBoletoAddressContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f31867a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoAddressContract.View f31868b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f31869c;

    /* renamed from: d */
    private AddressPatchModel f31870d;

    public WalletBoletoAddressPresenter(Activity activity, WalletBoletoAddressContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f31867a = activity;
        this.f31868b = view;
        this.f31869c = walletLoadingContract;
        this.f31870d = new AddressPatchModel(activity);
    }

    public void requestData(AddressFromZipCodeResp.DataBean dataBean) {
        this.f31869c.showLoadingDialog();
        this.f31870d.submitBoletoAddressPatch(dataBean, new RpcService.Callback<AddressPatchResp>() {
            public void onSuccess(AddressPatchResp addressPatchResp) {
                WalletBoletoAddressPresenter.this.f31869c.dismissLoadingDialog();
                if (addressPatchResp == null) {
                    WalletToast.showFailedMsg(WalletBoletoAddressPresenter.this.f31867a, WalletBoletoAddressPresenter.this.f31867a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoAddressPresenter.this.f31868b.onNetworkError();
                } else if (addressPatchResp.errno == 0) {
                    WalletBoletoAddressPresenter.this.f31868b.onAddressPatchSuccessful();
                } else {
                    WalletToast.showFailedMsg(WalletBoletoAddressPresenter.this.f31867a, addressPatchResp.errmsg);
                    WalletBoletoAddressPresenter.this.f31868b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoAddressPresenter.this.f31869c.dismissLoadingDialog();
                WalletToast.showFailedMsg(WalletBoletoAddressPresenter.this.f31867a, WalletBoletoAddressPresenter.this.f31867a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoAddressPresenter.this.f31868b.onNetworkError();
            }
        });
    }
}
