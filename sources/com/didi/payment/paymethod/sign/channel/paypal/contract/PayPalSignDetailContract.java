package com.didi.payment.paymethod.sign.channel.paypal.contract;

import android.app.Activity;

public interface PayPalSignDetailContract {

    public interface Presenter {
        void requestCancelSign();
    }

    public interface View {
        void dismissLoadingDialog();

        Activity getActivity();

        void onCancelSignFailure(String str);

        void onCancelSignSuccess(String str);

        void showLoadingDialog();
    }
}
