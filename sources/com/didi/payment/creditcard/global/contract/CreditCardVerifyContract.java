package com.didi.payment.creditcard.global.contract;

import com.didi.payment.creditcard.global.contract.CreditCardBaseContract;

public interface CreditCardVerifyContract {

    public interface IPresenter {
        void removeCard(String str);

        void verifyCard(String str, String str2, String str3);
    }

    public interface IView extends CreditCardBaseContract.IView {
        void onCancelSignSuccess();

        void onVerifyFailure();

        void onVerifyMultiFailure(String str, String str2);

        void onVerifySuccess();
    }
}
