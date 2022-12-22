package com.didi.consume.phone.view.contract;

import android.content.Context;
import com.didi.consume.phone.model.CsOperatorListResp;

public interface CsPhoneOperatorContract {

    public interface Presenter {
        public static final int OMEGA_SCENE_SELECT_OPERATOR = 0;

        void getOperatorList(int i, String str, String str2);

        void trackOmega(int i);
    }

    public interface View {
        Context getContext();

        void onNetworkError();

        void showHomelandCityErrorPage();

        void showOperators(CsOperatorListResp csOperatorListResp);
    }
}
