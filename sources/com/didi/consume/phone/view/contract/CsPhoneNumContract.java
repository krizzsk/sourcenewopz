package com.didi.consume.phone.view.contract;

import android.content.Context;
import com.didi.consume.phone.model.CsDefaultPhoneNumberResp;

public interface CsPhoneNumContract {

    public interface Presenter {
        void getDefaultPhoneNum(int i);

        void init();

        void jumpToActivityPage();
    }

    public interface View {
        Context getContext();

        void onNetworkError();

        void showActivity(String str);

        void showPhoneNumber(CsDefaultPhoneNumberResp.DataBean dataBean);
    }
}
