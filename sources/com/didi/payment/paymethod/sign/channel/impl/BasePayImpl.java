package com.didi.payment.paymethod.sign.channel.impl;

import android.content.Context;
import com.didi.payment.paymethod.open.callback.Callback;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.sign.channel.ISignChannel;

public abstract class BasePayImpl implements ISignChannel {
    protected static int CHANNEL_ID;
    protected Context context;
    protected SignCallback signCallback;

    public void cancelSign(int i, Callback callback) {
    }

    public void querySignStatus(int i, Callback callback) {
    }

    public void release() {
    }

    public BasePayImpl(Context context2) {
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void onSignResult(int i, String str) {
        onSignResult(i, str, (String) null);
    }

    /* access modifiers changed from: protected */
    public void onSignResult(int i, String str, String str2) {
        SignCallback signCallback2 = this.signCallback;
        if (signCallback2 != null) {
            signCallback2.onResult(i, str, str2);
        }
    }
}
