package com.didi.payment.paymethod.open;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.payment.paymethod.open.callback.Callback;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.CancelSignParam;
import com.didi.payment.paymethod.open.param.QuerySignStatusParam;
import com.didi.payment.paymethod.open.param.SignParam;

public interface ISignApi {
    void cancelSign(Context context, CancelSignParam cancelSignParam, Callback callback);

    void querySignStatus(Context context, QuerySignStatusParam querySignStatusParam, Callback callback);

    void sign(Activity activity, SignParam signParam, SignCallback signCallback);

    void sign(Fragment fragment, SignParam signParam, SignCallback signCallback);
}
