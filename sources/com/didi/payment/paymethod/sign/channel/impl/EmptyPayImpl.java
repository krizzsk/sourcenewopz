package com.didi.payment.paymethod.sign.channel.impl;

import androidx.fragment.app.Fragment;
import com.didi.payment.paymethod.open.callback.Callback;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.paymethod.sign.channel.ISignChannel;

public class EmptyPayImpl implements ISignChannel {
    public void cancelSign(int i, Callback callback) {
    }

    public void onActivityResult(int i) {
    }

    public void onActivityResume() {
    }

    public void querySignStatus(int i, Callback callback) {
    }

    public void release() {
    }

    public void sign(Fragment fragment, SignParam signParam, SignCallback signCallback) {
    }
}
