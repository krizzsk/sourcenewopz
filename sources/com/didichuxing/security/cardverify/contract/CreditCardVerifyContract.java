package com.didichuxing.security.cardverify.contract;

import com.didichuxing.security.cardverify.contract.CreditCardBaseContract;

public interface CreditCardVerifyContract {

    public interface IPresenter {
        void verifyCard(String str, String str2);
    }

    public interface IView extends CreditCardBaseContract.IView {
        void onVerifyException();

        void onVerifyFailure();

        void onVerifyMultiFailure(String str, String str2);

        void onVerifySuccess();
    }
}
