package com.didi.consume.phone.view.contract;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.consume.phone.model.CsAmountListResp;
import com.didi.consume.phone.model.CsCouponOrderBody;
import com.didi.consume.phone.model.CsCreateOrderBody;
import com.didi.consume.phone.model.CsCreateOrderResp;
import com.didi.consume.phone.model.CsVoucherResponse;

public interface CsPhoneAmountContract {

    public interface Presenter {
        public static final int OMEGA_SCENE_CONFIRM = 0;

        void createPhoneRefillOrder(int i, String str, CsCreateOrderBody csCreateOrderBody, CsCouponOrderBody csCouponOrderBody);

        void getAmountList(int i, String str, String str2, String str3, String str4);

        void getVoucherDiscount(int i, String str);

        void trackOmega(int i);
    }

    public interface View {
        Context getContext();

        void goToUniPay(FragmentActivity fragmentActivity, CsCreateOrderResp.DataBean dataBean);

        void onNetworkError();

        void showAmountList(CsAmountListResp.DataBean dataBean);

        void showVoucherAmount(CsVoucherResponse.DataBean dataBean);

        void showVoucherLoading();
    }
}
