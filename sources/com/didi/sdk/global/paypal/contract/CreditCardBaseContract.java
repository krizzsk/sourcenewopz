package com.didi.sdk.global.paypal.contract;

import android.app.Activity;
import android.content.Context;

public interface CreditCardBaseContract {

    public interface IView {
        void dismissLoadingDialog();

        Activity getActivity();

        Context getContext();

        void showLoadingDialog(String str);

        void showToast(String str);
    }
}
