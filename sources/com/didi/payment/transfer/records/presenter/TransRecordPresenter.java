package com.didi.payment.transfer.records.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.transfer.orderdetail.TransOrderDetailActivity;
import com.didi.payment.transfer.records.ITransRecordPageView;
import com.didi.payment.transfer.records.TransHistoryListResp;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;

public class TransRecordPresenter extends ITransRecordPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f31490a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f31491b;

    /* renamed from: c */
    private String f31492c;
    protected int mPageFrom;
    protected int mProductLine;
    protected int orderType;

    public TransRecordPresenter(Context context, ITransRecordPageView iTransRecordPageView) {
        super(context, iTransRecordPageView);
        Activity activity = (Activity) context;
        if (activity.getIntent() != null) {
            this.mProductLine = activity.getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, 0);
            this.orderType = activity.getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, -1);
            this.mPageFrom = activity.getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
            this.f31492c = activity.getIntent().getStringExtra(TransferContants.IntentKey.INTENT_PARAMS_KEY_PRODUCT_LINES);
        }
    }

    public void loadHistoryData(final boolean z) {
        if (this.f31490a != -1) {
            this.f31491b = true;
            if (z) {
                ((ITransRecordPageView) this.mPageView).onShowPageLoadding();
            }
            TransferBizModel.getInstance(getContext()).getHistoryList(this.f31492c, this.mProductLine, this.f31490a, this.orderType, new RpcService.Callback<TransHistoryListResp>() {
                public void onSuccess(TransHistoryListResp transHistoryListResp) {
                    boolean unused = TransRecordPresenter.this.f31491b = false;
                    if (z) {
                        ((ITransRecordPageView) TransRecordPresenter.this.mPageView).onDismissPageLoadding();
                    }
                    if (transHistoryListResp.errno == 0 && transHistoryListResp.data != null && !CollectionUtil.isEmpty((Collection<?>) transHistoryListResp.data.orders)) {
                        int unused2 = TransRecordPresenter.this.f31490a = transHistoryListResp.data.nextIndex;
                        ((ITransRecordPageView) TransRecordPresenter.this.mPageView).appendHistoryItem(transHistoryListResp.data);
                    } else if (z) {
                        ((ITransRecordPageView) TransRecordPresenter.this.mPageView).showEmptyView(R.string.cs_history_list_empty_text);
                    }
                }

                public void onFailure(IOException iOException) {
                    boolean unused = TransRecordPresenter.this.f31491b = false;
                    if (z) {
                        ((ITransRecordPageView) TransRecordPresenter.this.mPageView).onDismissPageLoadding();
                        ((ITransRecordPageView) TransRecordPresenter.this.mPageView).showEmptyView(R.string.cs_history_list_error_text);
                    }
                }
            });
        }
    }

    public void handleItemClick(TransHistoryListResp.HistoryItem historyItem) {
        SystemUtils.log(3, "hgl_tag", "handleItemclick item = " + historyItem, (Throwable) null, "com.didi.payment.transfer.records.presenter.TransRecordPresenter", 96);
        if (historyItem.productLine == 99996) {
            ((Request) DRouter.build("99OneTravel://one/pix_order_detail").putExtra("order_id", historyItem.orderIdLong)).start(getContext());
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, this.mProductLine);
        bundle.putString(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_ID, historyItem.orderIdLong);
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, this.orderType);
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_FROM_PAGE, 1);
        bundle.putInt("confirm_button_dismiss", 1);
        TransOrderDetailActivity.launch(getContext(), 1, bundle);
    }

    public void loadNextPage() {
        if (this.f31490a != -1 && !this.f31491b) {
            loadHistoryData(false);
        }
    }

    public void handleBackClick() {
        if (this.mPageFrom == TransferContants.Pages.PAGE_TRANSFER_CHANNELS) {
            ((ITransRecordPageView) this.mPageView).pageFinish();
        } else {
            ((ITransRecordPageView) this.mPageView).pageFinish();
        }
    }
}
