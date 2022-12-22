package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;

public interface WalletTopUpPayResultContract {

    public interface Presenter {
        public static final int OMEGA_TRACK_CONFIRM_CLICK = 1;
        public static final int OMEGA_TRACK_CONFIRM_SW = 0;
        public static final int OMEGA_TRACK_ONTRIP_CONFIRM_CK = 5;
        public static final int OMEGA_TRACK_ONTRIP_SW = 4;
        public static final int OMEGA_TRACK_PENDING_CANCEL_CK = 3;
        public static final int OMEGA_TRACK_PENDING_SW = 2;

        void executeTask();

        void handleBackClick();

        void handleConfirmClick();

        void handleEnterHistory();

        boolean isCancelableOrder();

        boolean isSupportCountdonw();

        boolean isTopupByDriver();

        void onCancelBtnClick();

        void onOperationItemClicked(WalletOperationItem walletOperationItem);

        void onOperationItemShown(WalletOperationItem walletOperationItem);

        void startPollingStatus();

        void trackOmega(int i);
    }

    public interface View extends WalletLoadingContract {
        void onNetworkError();

        void showCountdownLoading(int i, int i2);

        void showLoadingFinish(WalletPayResultResp.PayResultData payResultData);

        void showLoadingStart();
    }
}
