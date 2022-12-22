package com.didi.payment.paymethod.sign.channel;

import androidx.fragment.app.Fragment;
import com.didi.payment.paymethod.open.callback.Callback;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;

public interface ISignChannel {
    void cancelSign(int i, Callback callback);

    void onActivityResult(int i);

    void onActivityResume();

    void querySignStatus(int i, Callback callback);

    void release();

    void sign(Fragment fragment, SignParam signParam, SignCallback signCallback);
}
