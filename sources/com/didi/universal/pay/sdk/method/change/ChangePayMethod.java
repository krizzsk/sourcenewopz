package com.didi.universal.pay.sdk.method.change;

import android.content.Context;
import com.didi.universal.pay.sdk.method.internal.PayMethod;
import com.didi.universal.pay.sdk.method.model.PrepayInfo;

public class ChangePayMethod extends PayMethod {
    private void openPasswdDialog() {
    }

    public <T> boolean checkDataValid(T t) {
        return true;
    }

    public <T> boolean checkPaySupport(T t) {
        return true;
    }

    public int getChannelID() {
        return 180;
    }

    public int getRequestCodeForSign() {
        return 0;
    }

    public ChangePayMethod(Context context) {
        super(context);
    }

    public void dopay(PrepayInfo prepayInfo) {
        if (prepayInfo.resultType == -1) {
            openPasswdDialog();
        } else if (this.mCallBack != null) {
            this.mCallBack.onComplete();
        }
    }
}
