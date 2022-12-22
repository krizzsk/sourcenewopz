package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract;

import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressFromZipCodeResp;

public interface WalletBoletoZipCodeContract {

    public interface Presenter {
        void requestData(String str);
    }

    public interface View {
        void onNetworkError();

        void sendAddress(AddressFromZipCodeResp.DataBean dataBean);
    }
}
