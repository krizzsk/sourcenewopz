package com.didi.payment.wallet.global.wallet.presenter;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.event.PagePopupStack;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;
import com.didi.payment.wallet.global.wallet.contract.WalletTopupHistoryContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;
import org.greenrobot.eventbus.EventBus;

public class WalletTopupHistoryPresenter implements WalletTopupHistoryContract.Presenter {

    /* renamed from: a */
    private WalletPageModel f32119a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f32120b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f32121c;
    protected Activity mContext;
    protected int mPageFrom;
    protected int mProductLine;
    protected WalletTopupHistoryContract.View mView;
    protected int orderType;

    public WalletTopupHistoryPresenter(FragmentActivity fragmentActivity, WalletTopupHistoryContract.View view) {
        this.mContext = fragmentActivity;
        this.f32119a = new WalletPageModel(fragmentActivity);
        this.mProductLine = fragmentActivity.getIntent().getIntExtra("product_line", 0);
        this.orderType = fragmentActivity.getIntent().getIntExtra("order_type", -1);
        this.mPageFrom = fragmentActivity.getIntent().getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        this.mView = view;
    }

    public void loadHistoryData(final boolean z) {
        if (z) {
            this.f32120b = 0;
            this.mView.clearHistoryItem();
        }
        if (this.f32120b != -1) {
            this.f32121c = true;
            if (z) {
                this.mView.showLoadingDialog();
            }
            this.f32119a.getHistoryList(this.mProductLine, this.f32120b, this.orderType, -1, new RpcService.Callback<CsHistoryListResp>() {
                public void onSuccess(CsHistoryListResp csHistoryListResp) {
                    boolean unused = WalletTopupHistoryPresenter.this.f32121c = false;
                    if (z) {
                        WalletTopupHistoryPresenter.this.mView.dismissLoadingDialog();
                    }
                    if (csHistoryListResp.errno == 0 && csHistoryListResp.data != null && !CollectionUtil.isEmpty((Collection<?>) csHistoryListResp.data.orders)) {
                        int unused2 = WalletTopupHistoryPresenter.this.f32120b = csHistoryListResp.data.nextIndex;
                        WalletTopupHistoryPresenter.this.mView.appendHistoryItem(csHistoryListResp.data);
                    } else if (z) {
                        WalletTopupHistoryPresenter.this.mView.showEmptyView(R.string.cs_history_list_empty_text);
                    }
                }

                public void onFailure(IOException iOException) {
                    boolean unused = WalletTopupHistoryPresenter.this.f32121c = false;
                    if (z) {
                        WalletTopupHistoryPresenter.this.mView.dismissLoadingDialog();
                        WalletTopupHistoryPresenter.this.mView.showEmptyView(R.string.cs_history_list_error_text);
                    }
                }
            });
        }
    }

    public void handleItemClick(CsHistoryItem csHistoryItem) {
        Bundle bundle = new Bundle();
        bundle.putInt("product_line", this.mProductLine);
        bundle.putString("order_id", csHistoryItem.orderIdLong);
        bundle.putInt("order_type", csHistoryItem.orderType);
        bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 256);
        WalletTopUpPayResultActivity.launch(this.mContext, 12, bundle);
    }

    public void handleBackClick() {
        if (this.mProductLine == 650) {
            this.mContext.finish();
            return;
        }
        EventBus.getDefault().post(new PagePopupStack());
        this.mContext.finish();
    }

    public void loadNextPage() {
        if (this.f32120b != -1 && !this.f32121c) {
            loadHistoryData(false);
        }
    }
}
