package com.didi.consume.history.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.consume.orderdetail.view.CsTopupOrderDetailActivity;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.event.PagePopupStack;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.wallet.contract.WalletTopupHistoryContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopupHistoryPresenter;
import com.didi.sdk.apm.SystemUtils;
import org.greenrobot.eventbus.EventBus;

public class CsTopupHistoryListPresenter extends WalletTopupHistoryPresenter {
    public CsTopupHistoryListPresenter(FragmentActivity fragmentActivity, WalletTopupHistoryContract.View view) {
        super(fragmentActivity, view);
    }

    public void handleBackClick() {
        if (this.mProductLine == 605) {
            this.mContext.finish();
            return;
        }
        EventBus.getDefault().post(new PagePopupStack());
        this.mContext.finish();
    }

    public void handleItemClick(CsHistoryItem csHistoryItem) {
        SystemUtils.log(3, "hgl_tag", "history item click", (Throwable) null, "com.didi.consume.history.presenter.CsTopupHistoryListPresenter", 47);
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", this.mProductLine);
        bundle.putString("order_id", csHistoryItem.orderIdLong);
        bundle.putInt("order_type", this.orderType);
        bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 256);
        CsTopupOrderDetailActivity.launch(this.mContext, 12, bundle);
    }
}
