package com.didi.consume.orderdetail.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.consume.base.CsRouter;
import com.didi.consume.history.view.CsTopupHistoryActivity;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpPayResultContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpOrderDetailPresenter;

public class CsTopupOrderDetailPresenter extends WalletTopUpOrderDetailPresenter {
    public CsTopupOrderDetailPresenter(FragmentActivity fragmentActivity, WalletTopUpPayResultContract.View view) {
        super(fragmentActivity, view);
    }

    public void handleBackClick() {
        if (!WalletApolloUtil.getTopUpIsNew() && this.mProductLine != 99999) {
            CsRouter.startTopupChannelActivity(this.mContext);
        }
        this.mContext.finish();
    }

    public void trackOmega(int i) {
        if (i == 0) {
            FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_by_drv_confirmation_sw");
        } else if (i == 1) {
            FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_by_drv_confirmation_ck");
        }
    }

    /* access modifiers changed from: protected */
    public void toHistoryPage() {
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", this.mProductLine);
        bundle.putInt("params_topup_confirm_flag", 1);
        CsTopupHistoryActivity.startActivity(this.mContext, bundle);
        this.mContext.finish();
    }
}
