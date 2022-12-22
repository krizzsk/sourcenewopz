package com.didi.universal.pay.sdk.method.internal;

import android.content.Context;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;

public class InnerPayMethod extends PayMethod {
    public <T> boolean checkDataValid(T t) {
        return true;
    }

    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public int getChannelID() {
        return 0;
    }

    public int getRequestCodeForSign() {
        return 0;
    }

    public InnerPayMethod(Context context) {
        super(context);
    }

    public void dopay(PrepayInfo prepayInfo) {
        if (this.mCallBack != null) {
            this.mCallBack.onComplete();
        }
    }
}
