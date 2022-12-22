package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.presenter;

import android.app.Activity;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.contract.WalletBoletoAddressListContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.AddressPatchModel;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListCityResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.AddressListStateResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraCity;
import com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.model.recyclerview.ListFragmentExtraState;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public class WalletBoletoAddressListPresenter implements WalletBoletoAddressListContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f31863a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletBoletoAddressListContract.View f31864b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f31865c;

    /* renamed from: d */
    private AddressPatchModel f31866d;

    public WalletBoletoAddressListPresenter(Activity activity, WalletBoletoAddressListContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f31863a = activity;
        this.f31864b = view;
        this.f31865c = walletLoadingContract;
        this.f31866d = new AddressPatchModel(activity);
    }

    public void requestStates(ListFragmentExtraState listFragmentExtraState) {
        this.f31865c.showLoadingDialog();
        this.f31866d.requestState(listFragmentExtraState, new RpcService.Callback<AddressListStateResp>() {
            public void onSuccess(AddressListStateResp addressListStateResp) {
                WalletBoletoAddressListPresenter.this.f31865c.dismissLoadingDialog();
                if (addressListStateResp == null) {
                    WalletToast.showFailedMsg(WalletBoletoAddressListPresenter.this.f31863a, WalletBoletoAddressListPresenter.this.f31863a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoAddressListPresenter.this.f31864b.onNetworkError();
                } else if (addressListStateResp.errno == 0) {
                    WalletBoletoAddressListPresenter.this.f31864b.onStatesSuccessful(addressListStateResp.data.stateList);
                } else {
                    WalletToast.showFailedMsg(WalletBoletoAddressListPresenter.this.f31863a, addressListStateResp.errmsg);
                    WalletBoletoAddressListPresenter.this.f31864b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoAddressListPresenter.this.f31865c.dismissLoadingDialog();
                WalletBoletoAddressListPresenter.this.f31864b.onNetworkError();
            }
        });
    }

    public void requestCities(ListFragmentExtraCity listFragmentExtraCity) {
        this.f31865c.showLoadingDialog();
        this.f31866d.requestCities(listFragmentExtraCity, new RpcService.Callback<AddressListCityResp>() {
            public void onSuccess(AddressListCityResp addressListCityResp) {
                WalletBoletoAddressListPresenter.this.f31865c.dismissLoadingDialog();
                if (addressListCityResp == null) {
                    WalletToast.showFailedMsg(WalletBoletoAddressListPresenter.this.f31863a, WalletBoletoAddressListPresenter.this.f31863a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    WalletBoletoAddressListPresenter.this.f31864b.onNetworkError();
                } else if (addressListCityResp.errno == 0) {
                    WalletBoletoAddressListPresenter.this.f31864b.onCitiesSuccessful(addressListCityResp.data.cityList);
                } else {
                    WalletToast.showFailedMsg(WalletBoletoAddressListPresenter.this.f31863a, addressListCityResp.errmsg);
                    WalletBoletoAddressListPresenter.this.f31864b.onNetworkError();
                }
            }

            public void onFailure(IOException iOException) {
                WalletBoletoAddressListPresenter.this.f31865c.dismissLoadingDialog();
                WalletToast.showFailedMsg(WalletBoletoAddressListPresenter.this.f31863a, WalletBoletoAddressListPresenter.this.f31863a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                WalletBoletoAddressListPresenter.this.f31864b.onNetworkError();
            }
        });
    }
}
