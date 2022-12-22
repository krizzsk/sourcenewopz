package com.didi.payment.paymethod.open;

import android.app.Activity;
import com.didi.payment.paymethod.open.callback.PayCallback;
import java.util.HashMap;

public interface IPayApi {
    void payAli(Activity activity, String str, PayCallback payCallback);

    void payQQ(HashMap<String, Object> hashMap, PayCallback payCallback);

    void payWX(HashMap<String, Object> hashMap, PayCallback payCallback);
}
