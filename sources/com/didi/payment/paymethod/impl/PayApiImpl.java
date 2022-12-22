package com.didi.payment.paymethod.impl;

import android.app.Activity;
import com.didi.payment.paymethod.open.IPayApi;
import com.didi.payment.paymethod.open.callback.PayCallback;
import java.util.HashMap;

public class PayApiImpl implements IPayApi {
    public void payAli(Activity activity, String str, PayCallback payCallback) {
    }

    public void payQQ(HashMap<String, Object> hashMap, PayCallback payCallback) {
    }

    public void payWX(HashMap<String, Object> hashMap, PayCallback payCallback) {
    }
}
