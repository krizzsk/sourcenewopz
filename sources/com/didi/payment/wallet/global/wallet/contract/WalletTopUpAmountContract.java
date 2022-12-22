package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.WalletTopUpAmountItemsResp;
import java.util.Map;

public interface WalletTopUpAmountContract {

    public interface Presenter {
        public static final int OMEGA_SCENE_PAGE_SW = 0;
        public static final int OMEGA_SCENE_TOPUP_CLICK_DISENABLE = 6;
        public static final int OMEGA_SCENE_TOPUP_CONFIRM_CK = 1;
        public static final int OMEGA_SCENE_TOPUP_CUSTOMER_CK = 3;
        public static final int OMEGA_SCENE_TOPUP_CUSTOMER_ERROR = 5;
        public static final int OMEGA_SCENE_TOPUP_CUSTOMER_INPUT = 4;
        public static final int OMEGA_SCENE_TOPUP_LAST_CONFIRM_CK = 2;

        String getOrderId();

        void handleTopUpClick(WalletTopUpAmountItemsResp.TopupItem topupItem);

        boolean isTopupByDriver();

        void onBack();

        void onPaySuccess(String str);

        void onTopupLoadingFinish();

        void requestData();

        void setOrderId(String str);

        void trackOmega(int i);

        void trackOmega(int i, Map<String, Object> map);
    }

    public interface View {
        void onNetworkError();

        void refreshUI(WalletTopUpAmountItemsResp.DataBean dataBean);
    }
}
