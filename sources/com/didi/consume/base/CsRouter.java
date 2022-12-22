package com.didi.consume.base;

import android.app.Activity;
import android.content.Context;
import com.didi.consume.channels.view.CsTopUpChannelActivity;
import com.didi.consume.phone.model.CsCreateOrderResp;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didichuxing.foundation.spi.ServiceLoader;

public class CsRouter {
    public static void startTopupChannelActivity(Context context) {
        CsTopUpChannelActivity.launch(context, 0);
    }

    public static void startPayResultActivity(Activity activity, int i, String str, int i2) {
        WalletTopUpPayResultActivity.launch(activity, 100, i, str, i2);
    }

    @Deprecated
    public static void gotoAccountStatusPage(Activity activity, CsCreateOrderResp.DataBean dataBean) {
        if (dataBean != null && dataBean.extraInfo != null) {
            gotoAccountPage(activity, dataBean.extraInfo.accountStatus, dataBean.extraInfo.accountInfo);
        }
    }

    public static void gotoAccountPage(Activity activity, int i, IWalletService.AccountInfo accountInfo) {
        IWalletService iWalletService = (IWalletService) ServiceLoader.load(IWalletService.class).get();
        if (iWalletService != null) {
            iWalletService.gotoAccountPage(activity, i, accountInfo);
        }
    }
}
