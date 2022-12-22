package com.didi.payment.wallet.global.prepaidcard.interceptor;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.VerifyPwdUtil;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IPrepaidInterceptor;
import com.didi.soda.compose.card.BaseCard;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JH\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IVerifyPwdInterceptor;", "Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor;", "()V", "onInterceptor", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "netModel", "Lcom/didi/payment/wallet/global/model/WalletPageModel;", "chain", "Lcom/didi/payment/wallet/global/prepaidcard/interceptor/IPrepaidInterceptor$Chain;", "params", "", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: IVerifyPwdInterceptor.kt */
public final class IVerifyPwdInterceptor implements IPrepaidInterceptor {
    public void onInterceptor(FragmentActivity fragmentActivity, WalletPageModel walletPageModel, IPrepaidInterceptor.Chain chain, Map<String, String> map, Request request, Result result) {
        Map<String, String> map2 = map;
        Request request2 = request;
        Result result2 = result;
        Intrinsics.checkNotNullParameter(walletPageModel, "netModel");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(map2, "params");
        Intrinsics.checkNotNullParameter(request2, "request");
        Intrinsics.checkNotNullParameter(result2, "result");
        if (Intrinsics.areEqual((Object) map2.get("verify_pwd"), (Object) "1")) {
            Bundle bundle = new Bundle();
            bundle.putString(BaseCard.KEY_CARD_ID, map2.get(BaseCard.KEY_CARD_ID));
            bundle.putString("source", map2.get("source"));
            bundle.putString("scene", map2.get("scene"));
            bundle.putString("session_id", map2.get("session_id"));
            bundle.putString("pay_session_id", map2.get("pay_session_id"));
            VerifyPwdUtil.Companion.handlePwdVerify(fragmentActivity, walletPageModel, bundle, map2.get("pwd_type"), new IVerifyPwdInterceptor$onInterceptor$1(result2, request2));
            LoadingProxyHolder.ILoadingProxy proxy = LoadingProxyHolder.getProxy();
            if (proxy != null) {
                proxy.dismissLoading();
                return;
            }
            return;
        }
        chain.proceed(map);
    }
}
