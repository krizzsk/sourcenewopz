package com.didi.payment.wallet.global.wallet.contract;

import com.didi.payment.wallet.global.model.resp.model.WalletOperationItem;

public interface WalletOperationBannerContract {

    public interface Listener {
        void onOperationItemClicked(WalletOperationItem walletOperationItem);

        void onOperationItemShown(WalletOperationItem walletOperationItem);
    }
}
