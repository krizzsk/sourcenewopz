package com.didi.sdk.global.paypal.contract;

import android.app.Activity;
import android.content.Context;

public interface PayPalDetailContract {

    public interface Presenter {
        void removeCard(int i);
    }

    public interface View {
        void dismissLoadingDialog();

        Activity getActivity();

        Context getContext();

        void onCancelSignSuccess();

        void showLoadingDialog(String str);

        void showToast(String str);
    }
}
