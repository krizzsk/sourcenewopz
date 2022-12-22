package com.didi.payment.wallet.global.prepaidcard.interceptor;

import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import com.didi.payment.wallet.global.prepaidcard.IPwdVerify;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didi/payment/wallet/global/prepaidcard/interceptor/IVerifyPwdInterceptor$onInterceptor$1", "Lcom/didi/payment/wallet/global/prepaidcard/IPwdVerify;", "onFail", "", "onSuccess", "res", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IVerifyPwdInterceptor.kt */
public final class IVerifyPwdInterceptor$onInterceptor$1 implements IPwdVerify {
    final /* synthetic */ Request $request;
    final /* synthetic */ Result $result;

    IVerifyPwdInterceptor$onInterceptor$1(Result result, Request request) {
        this.$result = result;
        this.$request = request;
    }

    public void onSuccess(int i) {
        this.$result.putExtra("result", 1);
        RouterHelper.release(this.$request);
    }

    public void onFail() {
        this.$result.putExtra("result", 0);
        RouterHelper.release(this.$request);
    }
}
