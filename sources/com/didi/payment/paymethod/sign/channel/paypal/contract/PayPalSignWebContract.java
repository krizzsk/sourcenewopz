package com.didi.payment.paymethod.sign.channel.paypal.contract;

import android.app.Activity;

public interface PayPalSignWebContract {

    public interface Presenter {
        void pollSignResult(int i, int i2);
    }

    public interface View {
        void dismissLoadingDialog();

        Activity getActivity();

        void onSignFailure(String str);

        void onSignSuccess(String str);

        void showLoadingDialog();
    }
}
