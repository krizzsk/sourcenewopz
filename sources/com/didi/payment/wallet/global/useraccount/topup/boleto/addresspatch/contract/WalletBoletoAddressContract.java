package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract;

import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;

public interface WalletBoletoAddressContract {

    public interface Presenter {
        void requestData(AddressFromZipCodeResp.DataBean dataBean);
    }

    public interface View {
        void onAddressPatchSuccessful();

        void onNetworkError();
    }
}
