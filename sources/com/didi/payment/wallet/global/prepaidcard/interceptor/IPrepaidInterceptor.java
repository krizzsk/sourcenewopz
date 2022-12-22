package com.didi.payment.wallet.global.prepaidcard.interceptor;

import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.model.WalletPageModel;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0011JH\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor;", "", "onInterceptor", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "netModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "chain", "Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor$Chain;", "params", "", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "Chain", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IPrepaidInterceptor.kt */
public interface IPrepaidInterceptor {

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor$Chain;", "", "proceed", "", "params", "", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: IPrepaidInterceptor.kt */
    public interface Chain {
        void proceed(Map<String, String> map);
    }

    void onInterceptor(FragmentActivity fragmentActivity, WalletPageModel walletPageModel, Chain chain, Map<String, String> map, Request request, Result result);
}
