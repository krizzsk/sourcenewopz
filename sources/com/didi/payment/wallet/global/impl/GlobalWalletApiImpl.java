package com.didi.payment.wallet.global.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.drouter.api.DRouter;
import com.didi.payment.wallet.global.useraccount.balance.view.WalletBalanceActivity;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.open.IGlobalWalletApi;
import com.didi.payment.wallet.open.param.GlobalTopUpParam;
import com.didi.payment.wallet.open.param.GlobalWalletParam;

public class GlobalWalletApiImpl implements IGlobalWalletApi {
    public void openCreateAccountPage(Context context, String str) {
    }

    public void openWallet(Context context, GlobalWalletParam globalWalletParam) {
        String str;
        if (!TextUtils.isEmpty(globalWalletParam.extOmegaAttrs)) {
            str = String.format("99pay://one/nativeWallet?ext=%s", new Object[]{globalWalletParam.extOmegaAttrs});
        } else {
            str = "99pay://one/nativeWallet";
        }
        DRouter.build(str).start(context);
    }

    public void openTopUpPage(Context context, GlobalTopUpParam globalTopUpParam, boolean z) {
        if (globalTopUpParam != null && globalTopUpParam.page == 0) {
            WalletRouter.gotoTopUpChannelActivity(context, z);
        }
    }

    public void openWalletBalanceActivities(Context context, int i) {
        Intent intent = new Intent();
        intent.setClass(context, WalletBalanceActivity.class);
        context.startActivity(intent);
    }

    public void openWalletTopUpChannelPage(Context context) {
        WalletRouter.gotoTopUpChannelActivity(context, false);
    }

    public void openWalletTopUpChannelPage(Context context, int i) {
        WalletRouter.gotoTopUpChannelActivity(context, i);
    }
}
