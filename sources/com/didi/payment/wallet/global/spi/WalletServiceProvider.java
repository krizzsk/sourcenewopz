package com.didi.payment.wallet.global.spi;

import android.app.Activity;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({IWalletService.class})
public class WalletServiceProvider implements IWalletService {
    public void gotoAccountPage(Activity activity, int i, IWalletService.AccountInfo accountInfo) {
        if (i == 0) {
            WalletRouter.gotoApplyAccountPage(activity);
        } else if (i != 2) {
            if (i == 3 && accountInfo != null) {
                WalletRouter.gotoFailedReasonPage(activity, accountInfo);
            }
        } else if (accountInfo != null) {
            WalletRouter.gotoSignUpWaitingPage(activity, accountInfo);
        }
    }
}
