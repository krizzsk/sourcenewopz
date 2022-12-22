package com.didi.universal.pay.sdk.method.nineninepay;

import android.content.Context;
import com.didi.universal.pay.sdk.method.internal.PayMethod;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;

public class NineNinePayMethod extends PayMethod {
    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public int getChannelID() {
        return 190;
    }

    public int getRequestCodeForSign() {
        return 0;
    }

    public boolean supportSign() {
        return true;
    }

    public NineNinePayMethod(Context context) {
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
