package com.didi.payment.wallet.global.prepaidcard;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IKycInterceptor;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IOpenSessionInterceptor;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IPreApplyCardInterceptor;
import com.didi.payment.wallet.global.prepaidcard.interceptor.IVerifyPwdInterceptor;
import com.didi.payment.wallet.global.prepaidcard.interceptor.RealPrepaidChain;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidCommonHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidCommonHandler.kt */
public final class PrepaidCommonHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Map<String, String> parseUrlParams = PrepaidCardManager.Companion.parseUrlParams(request.getUri().toString());
        Context context = request.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        WalletPageModel walletPageModel = new WalletPageModel(request.getContext().getApplicationContext());
        LoadingProxyHolder.ILoadingProxy proxy = LoadingProxyHolder.getProxy();
        if (proxy != null) {
            proxy.showLoading();
        }
        List arrayList = new ArrayList();
        arrayList.add(new IVerifyPwdInterceptor());
        arrayList.add(new IKycInterceptor());
        arrayList.add(new IPreApplyCardInterceptor());
        arrayList.add(new IOpenSessionInterceptor());
        new RealPrepaidChain(arrayList, fragmentActivity, walletPageModel, 0, request, result, 8, (DefaultConstructorMarker) null).proceed(parseUrlParams);
    }
}
