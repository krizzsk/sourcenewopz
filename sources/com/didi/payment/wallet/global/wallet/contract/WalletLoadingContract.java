package com.didi.payment.wallet.global.wallet.contract;

import android.content.Context;

public interface WalletLoadingContract {
    void dismissLoadingDialog();

    Context getContext();

    void showLoadingDialog();
}
