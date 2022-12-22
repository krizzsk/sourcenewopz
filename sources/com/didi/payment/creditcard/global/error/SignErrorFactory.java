package com.didi.payment.creditcard.global.error;

import androidx.fragment.app.FragmentActivity;
import com.didi.payment.creditcard.global.model.SignCardParam;
import com.didi.payment.creditcard.global.p130v2.error.DefaultSignErrorHandlerV2;
import com.didi.payment.creditcard.global.p130v2.error.GuideSignErrorHandlerV2;
import com.didi.payment.creditcard.global.p130v2.utils.BindCardApolloUtils;

public class SignErrorFactory {
    public static ISignErrorHandler createErrorHandler(FragmentActivity fragmentActivity, SignCardParam signCardParam) {
        if (signCardParam == null) {
            return new DefaultSignErrorHandler(fragmentActivity);
        }
        if (signCardParam.bindType == 5) {
            return BindCardApolloUtils.useNewVersion() ? new GuideSignErrorHandlerV2(fragmentActivity) : new GuideSignErrorHandler(fragmentActivity);
        }
        if (BindCardApolloUtils.useNewVersion()) {
            return new DefaultSignErrorHandlerV2(fragmentActivity);
        }
        return new DefaultSignErrorHandler(fragmentActivity);
    }
}
