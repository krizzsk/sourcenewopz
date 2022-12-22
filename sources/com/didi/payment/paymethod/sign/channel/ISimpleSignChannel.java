package com.didi.payment.paymethod.sign.channel;

import com.didi.payment.paymethod.open.callback.Callback;
import java.util.HashMap;

public interface ISimpleSignChannel {
    void cancelSign(HashMap<String, Object> hashMap, Callback callback);

    void querySignStatus(HashMap<String, Object> hashMap, Callback callback);

    void sign(HashMap<String, Object> hashMap, Callback callback);
}
