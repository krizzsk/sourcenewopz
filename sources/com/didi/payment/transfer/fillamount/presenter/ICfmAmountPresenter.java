package com.didi.payment.transfer.fillamount.presenter;

import android.content.Context;
import com.didi.payment.transfer.common.AbsTransBasePresenter;
import com.didi.payment.transfer.fillamount.ICfmAmountPageView;

public abstract class ICfmAmountPresenter extends AbsTransBasePresenter<ICfmAmountPageView> {

    public interface VerifyNumberlCallback {
        void onError();
    }

    public abstract String constructBizontent();

    public abstract String constructMetadata();

    public abstract void createOrder(int i, int i2, String str, boolean z);

    public abstract void loadNightlyLimitConfig(int i);

    public abstract void loadServiceFeeData(int i, int i2, String str);

    public boolean needSecondConfirmData() {
        return false;
    }

    public abstract void onPaySuccess(String str);

    public abstract void verifyInputAmount(float f, VerifyNumberlCallback verifyNumberlCallback);

    public ICfmAmountPresenter(Context context, ICfmAmountPageView iCfmAmountPageView) {
        super(context, iCfmAmountPageView);
    }
}
