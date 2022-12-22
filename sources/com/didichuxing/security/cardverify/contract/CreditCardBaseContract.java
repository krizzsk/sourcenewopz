package com.didichuxing.security.cardverify.contract;

import android.app.Activity;
import android.content.Context;

public interface CreditCardBaseContract {

    public interface IView {
        void dismissLoadingDialog();

        Activity getActivity();

        Context getContext();

        void showLoadingDialog(String str);

        void showMaskLoadingDialog(String str);

        void showToast(String str);

        void showToastCompleted(String str);
    }
}
