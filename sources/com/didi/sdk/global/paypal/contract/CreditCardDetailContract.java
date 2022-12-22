package com.didi.sdk.global.paypal.contract;

import com.didi.sdk.global.paypal.contract.CreditCardBaseContract;

public interface CreditCardDetailContract {

    public interface IPresenter {
        void removeCard(int i, String str);
    }

    public interface IView extends CreditCardBaseContract.IView {
        void onCancelSignSuccess();
    }
}
