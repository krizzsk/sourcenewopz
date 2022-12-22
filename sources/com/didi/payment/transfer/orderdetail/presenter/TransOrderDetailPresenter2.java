package com.didi.payment.transfer.orderdetail.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import com.didi.payment.transfer.common.AbsTransRpcSvrCallback;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.net.TransferBizModel;
import com.didi.payment.transfer.orderdetail.ITransOrderDetailView;
import com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter;
import com.didi.payment.transfer.orderdetail.presenter.TransPayResultResp;
import com.didi.payment.transfer.records.TransOrderRecordsActivity;
import java.io.IOException;

public class TransOrderDetailPresenter2 extends IOrderDetailPresenter {

    /* renamed from: c */
    private static final long f31473c = 1000;

    /* renamed from: d */
    private static final int f31474d = 10;

    /* renamed from: e */
    private CountDownTimer f31475e;

    /* renamed from: f */
    private Activity f31476f;
    protected String mOrderId;
    protected int mOrderType = -1;
    protected int mPageFrom = -1;
    protected TransPayResultResp.PayResultData mPayResultData;
    protected int mProductLine;
    protected TransferBizModel mTransferBizModel;

    public void handleEnterHistory() {
    }

    public boolean isSupportCountdonw() {
        return false;
    }

    public void trackOmega(int i) {
    }

    public TransOrderDetailPresenter2(Context context, ITransOrderDetailView iTransOrderDetailView) {
        super(context, iTransOrderDetailView);
        this.f31476f = (Activity) context;
        this.mTransferBizModel = TransferBizModel.getInstance(getContext());
        Intent intent = this.f31476f.getIntent();
        if (intent != null) {
            this.mProductLine = intent.getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, 0);
            this.mOrderId = intent.getStringExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_ID);
            this.mOrderType = intent.getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, -1);
            this.mPageFrom = intent.getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_FROM_PAGE, -1);
        }
    }

    /* renamed from: com.didi.payment.transfer.orderdetail.presenter.TransOrderDetailPresenter2$4 */
    static /* synthetic */ class C109924 {

        /* renamed from: $SwitchMap$com$didi$payment$transfer$orderdetail$presenter$IOrderDetailPresenter$OperationType */
        static final /* synthetic */ int[] f31477x495c344a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter$OperationType[] r0 = com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter.OperationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31477x495c344a = r0
                com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter$OperationType r1 = com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter.OperationType.CANCEL_TRANSFER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31477x495c344a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter$OperationType r1 = com.didi.payment.transfer.orderdetail.presenter.IOrderDetailPresenter.OperationType.REMIND_RECIEVER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.orderdetail.presenter.TransOrderDetailPresenter2.C109924.<clinit>():void");
        }
    }

    public void onOperationButtonClick(IOrderDetailPresenter.OperationType operationType) {
        int i = C109924.f31477x495c344a[operationType.ordinal()];
        if (i == 1) {
            ((ITransOrderDetailView) this.mPageView).onShowPageLoadding();
            this.mTransferBizModel.cancelTransferOrder(this.mOrderId, new AbsTransRpcSvrCallback<TransRemindMsgResp>(getContext()) {
                public void onHandleSuccess(TransRemindMsgResp transRemindMsgResp) {
                    ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onDismissPageLoadding();
                    if (transRemindMsgResp == null || transRemindMsgResp.data == null) {
                        showDefaultErrorToast();
                    } else if (transRemindMsgResp.data.f31479ok) {
                        showSuccessToast(transRemindMsgResp.data.getTipMsg());
                        ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onPageFinish();
                        TransOrderDetailPresenter2.this.toHistoryPage();
                    } else {
                        showErrorToast(transRemindMsgResp.errmsg);
                    }
                }

                public void onHandleFailure(IOException iOException) {
                    ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onDismissPageLoadding();
                }
            });
        } else if (i == 2) {
            ((ITransOrderDetailView) this.mPageView).onShowPageLoadding();
            this.mTransferBizModel.requestRemindReceiveMsg(this.mOrderId, new AbsTransRpcSvrCallback<TransRemindMsgResp>(getContext()) {
                public void onHandleSuccess(TransRemindMsgResp transRemindMsgResp) {
                    ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onDismissPageLoadding();
                    TransOrderDetailPresenter2.this.m22237a((transRemindMsgResp == null || transRemindMsgResp.data == null) ? "Easy transfer money with 99pay!" : transRemindMsgResp.data.msg);
                }

                public void onHandleFailure(IOException iOException) {
                    ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onDismissPageLoadding();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22237a(String str) {
        ((ITransOrderDetailView) this.mPageView).showShareWindow(str);
    }

    public void executeTask() {
        ((ITransOrderDetailView) this.mPageView).onShowPageLoadding();
        m22235a();
    }

    /* renamed from: a */
    private void m22235a() {
        this.mTransferBizModel.getOrderDetailInfo(this.mProductLine, this.mOrderId, new AbsTransRpcSvrCallback<TransPayResultResp>(getContext(), true) {
            public void onHandleSuccess(TransPayResultResp transPayResultResp) {
                ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onDismissPageLoadding();
                if (transPayResultResp == null || transPayResultResp.data == null || transPayResultResp.errno != 0) {
                    ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onGotOrderStatus((TransPayResultResp.PayResultData) null);
                    return;
                }
                TransOrderDetailPresenter2.this.mPayResultData = transPayResultResp.data;
                ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onGotOrderStatus(transPayResultResp.data);
            }

            public void onHandleFailure(IOException iOException) {
                ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onDismissPageLoadding();
                ((ITransOrderDetailView) TransOrderDetailPresenter2.this.mPageView).onGotOrderStatus((TransPayResultResp.PayResultData) null);
            }
        });
    }

    public void handleBackClick() {
        ((ITransOrderDetailView) this.mPageView).onPageFinish();
    }

    /* access modifiers changed from: protected */
    public void toHistoryPage() {
        Bundle bundle = new Bundle();
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, this.mProductLine);
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_ORDER_TYPE, this.mOrderType);
        TransOrderRecordsActivity.startActivity(this.mContext, bundle);
        ((ITransOrderDetailView) this.mPageView).onPageFinish();
    }
}
