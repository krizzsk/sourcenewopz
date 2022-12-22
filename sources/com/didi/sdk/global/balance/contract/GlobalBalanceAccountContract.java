package com.didi.sdk.global.balance.contract;

import android.app.Activity;
import android.content.Context;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;

@Deprecated
public interface GlobalBalanceAccountContract {

    public interface Presenter {
        void jumpToBalanceTransDetailsActivity(String str, String str2);

        void jumpToLegalTermsActivity(String str, int i);

        void jumpToTopUpPage(String str, int i, int i2);

        void loadBalanceAccounts();
    }

    public interface View {
        void dismissLoadingDialog();

        Activity getActivity();

        Context getContext();

        void refreshView(BalancePageResponse balancePageResponse);

        void showLoadingDialog(String str);
    }
}
