package com.didi.payment.wallet.global.wallet.contract;

import android.app.Activity;

public interface WalletCommonContract {

    public interface ILoadingView {
        void dismissLoadingDialog();

        void initLoadingDialog(Activity activity);

        void releaseLoadingDialog();

        void showLoadingDialog();
    }

    public interface NullListener {
    }

    public interface Presenter {
        void init();

        void onDestroy();

        void requestData();
    }

    public interface View<Data, Listener> {
        void setListener(Listener listener);

        void updateContent(Data data);
    }
}
