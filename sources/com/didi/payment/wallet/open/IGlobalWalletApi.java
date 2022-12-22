package com.didi.payment.wallet.open;

import android.content.Context;
import com.didi.payment.wallet.open.param.GlobalTopUpParam;
import com.didi.payment.wallet.open.param.GlobalWalletParam;

public interface IGlobalWalletApi {
    void openCreateAccountPage(Context context, String str);

    void openTopUpPage(Context context, GlobalTopUpParam globalTopUpParam, boolean z);

    void openWallet(Context context, GlobalWalletParam globalWalletParam);

    void openWalletBalanceActivities(Context context, int i);

    void openWalletTopUpChannelPage(Context context);

    void openWalletTopUpChannelPage(Context context, int i);
}
