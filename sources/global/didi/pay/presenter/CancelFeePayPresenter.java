package global.didi.pay.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.trackupload.sdk.Constants;
import com.didi.unifiedPay.component.AbsUnifiedPaymentPresenter;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.util.HighlightUtil;
import com.didi.unifiedPay.util.LogUtil;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import global.didi.pay.model.CancelFeePayParam;

public class CancelFeePayPresenter extends AbsUnifiedPaymentPresenter {
    private static final String TAG = "CancelFeePayPresenter";
    /* access modifiers changed from: private */
    public Activity mActivity;
    private CancelFeePayParam mPayParam;

    public CancelFeePayPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
        this.mActivity = (Activity) context;
    }

    /* access modifiers changed from: protected */
    public void onPaySuccessed(int i, String str) {
        super.onPaySuccessed(i, str);
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("code", 1);
                bundle.putString("message", CancelFeePayPresenter.this.mContext.getString(R.string.oc_pay_success_string));
                intent.putExtras(bundle);
                CancelFeePayPresenter.this.mActivity.setResult(-1, intent);
                CancelFeePayPresenter.this.mActivity.finish();
                LogUtil.m31685fi(CancelFeePayPresenter.TAG, "payment success");
            }
        }, ((IPayView) this.mView).isShowSuccessOnBtn() ? 1000 : Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
    }

    /* access modifiers changed from: protected */
    public void bindVisa(int i) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 4;
        addCardParam.orderId = getOrderId();
        addCardParam.productLine = "" + getBid();
        addCardParam.isSignAfterOrder = true;
        if (this.mFragment != null) {
            DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(this.mFragment, transRequestCode(i), addCardParam);
            return;
        }
        DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity((Activity) this.mContext, i, addCardParam);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 100) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            refreshOrderBillAndAutoPay(150);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePayTypeInfo(PayInfo payInfo) {
        ((IPayView) this.mView).setPayTypeInfo(!TextUtil.isEmpty(payInfo.statusMsg) ? HighlightUtil.highlight(UnipayTextUtil.handleString(payInfo.statusMsg), this.mContext.getResources().getColor(R.color.black), this.mContext.getResources().getColor(R.color.black), 0, true) : null);
    }

    /* access modifiers changed from: protected */
    public void setupView(PayInfo payInfo) {
        super.setupView(payInfo);
        ((IPayView) this.mView).setCancelableForThirdPay(false);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    public void setPayParam(CancelFeePayParam cancelFeePayParam) {
        this.mPayParam = cancelFeePayParam;
    }

    /* access modifiers changed from: protected */
    public int getBid() {
        return this.mPayParam.bid;
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        return this.mPayParam.oid;
    }
}
