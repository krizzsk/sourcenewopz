package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract;

import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListStateResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import java.util.List;

public interface WalletBoletoAddressListContract {

    public interface Presenter {
        void requestCities(ListFragmentExtraCity listFragmentExtraCity);

        void requestStates(ListFragmentExtraState listFragmentExtraState);
    }

    public interface View {
        void onCitiesSuccessful(List<String> list);

        void onNetworkError();

        void onStatesSuccessful(List<AddressListStateResp.StateBean> list);
    }
}
