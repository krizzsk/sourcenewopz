package com.didi.payment.base.push;

import android.content.Context;

public interface IPayPush {
    void register(Context context, String str, PushListener pushListener);

    void unregister(PushListener pushListener);
}
