package com.didi.universal.pay.sdk.method.paypal;

import android.content.Context;
import com.didi.universal.pay.sdk.method.internal.PayMethod;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;

public class PaypalMethod extends PayMethod {
    private static final String TAG = "PaypalMethod";

    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public int getChannelID() {
        return 152;
    }

    public int getRequestCodeForSign() {
        return 0;
    }

    public boolean supportSign() {
        return true;
    }

    public PaypalMethod(Context context) {
        super(context);
    }

    public <T> boolean checkDataValid(T t) {
        return ((PrepayInfo) t) != null;
    }

    public void dopay(PrepayInfo prepayInfo) {
        int i = prepayInfo.resultType;
        if ((i == 0 || i == 2 || i == 3 || i == 4) && this.mCallBack != null) {
            this.mCallBack.onComplete();
        }
    }
}
