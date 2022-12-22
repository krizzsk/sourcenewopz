package com.didi.universal.pay.sdk.method.visa;

import android.content.Context;
import com.didi.universal.pay.sdk.method.internal.PayMethod;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;
import com.didi.universal.pay.sdk.method.model.VisaPayModel;
import com.didi.universal.pay.sdk.util.LogUtil;

public class VisaPayMethod<T extends PrepayInfo> extends PayMethod {
    private static final String TAG = VisaPayMethod.class.getSimpleName();
    private int mChannelId;

    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public int getRequestCodeForSign() {
        return 100;
    }

    public boolean supportSign() {
        return true;
    }

    public VisaPayMethod(Context context, int i) {
        super(context);
        this.mChannelId = i;
    }

    public <T> boolean checkDataValid(T t) {
        return ((PrepayInfo) t) != null;
    }

    public void dopay(PrepayInfo prepayInfo) {
        LogUtil.m32410fi("VISAPayMethod", "dopay");
        VisaPayModel visaPayModel = prepayInfo.visaPayModel;
        if (visaPayModel == null || !visaPayModel.isNeedBindCard) {
            int i = prepayInfo.resultType;
            if ((i == 0 || i == 2 || i == 3 || i == 4) && this.mCallBack != null) {
                this.mCallBack.onComplete();
                LogUtil.m32410fi("VISAPayMethod", "onComplete");
                return;
            }
            return;
        }
        startBindCard();
    }

    private void startBindCard() {
        LogUtil.m32408d(TAG, "startBindCard");
        if (this.mCallBack != null) {
            this.mCallBack.doSign();
            LogUtil.m32410fi("VISAPayMethod", "go sign");
        }
    }

    public int getChannelID() {
        return this.mChannelId;
    }
}
