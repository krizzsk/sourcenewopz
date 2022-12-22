package global.didi.pay.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.didi.unifiedPay.UnifiedPaySystem;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.model.PayParam;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import global.didi.pay.IGlobalPayView;
import org.greenrobot.eventbus.EventBus;

public abstract class GlobalNonTripPaymentPresenter extends GlobalAbsPaymentPresenter {
    public static final String PAY_PARAM = "pay_param";

    /* access modifiers changed from: protected */
    public int getBid() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public String getVerifyScene() {
        return "CHECK_OUT_WALLET";
    }

    public GlobalNonTripPaymentPresenter(Context context, FragmentManager fragmentManager, String str, IViewCallback iViewCallback) {
        super(context, fragmentManager, str, iViewCallback);
    }

    public void onAdd(Bundle bundle) {
        this.mPayParam = (PayParam) bundle.getSerializable("pay_param");
        if (this.mPayParam != null) {
            this.mPayParam.bid = getBid();
            this.mUnifiedPaySystem = UnifiedPaySystem.createUnifiedPay(this.mContext, getPayBillType());
            this.mUnifiedPaySystem.setPayParam(this.mPayParam);
            this.mUnifiedPaySystem.init(this.mPayParam.bid, getOrderId(), this.mFragmentManager);
            prepareData();
            this.mAdyen3DS.registerListener(this);
            ((IGlobalPayView) this.mView).setPixViewListener(this);
            if (!EventBus.getDefault().isRegistered(this)) {
                EventBus.getDefault().register(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getOrderId() {
        return !TextUtils.isEmpty(this.mPayParam.oid) ? this.mPayParam.oid : "NoneTripOidPlaceHolder";
    }

    /* access modifiers changed from: protected */
    public PayConstant.PayBillType getPayBillType() {
        if (TextUtils.isEmpty(this.mPayParam.oid)) {
            return PayConstant.PayBillType.NoneTrip;
        }
        return PayConstant.PayBillType.Trip;
    }
}
