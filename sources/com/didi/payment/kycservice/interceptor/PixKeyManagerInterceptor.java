package com.didi.payment.kycservice.interceptor;

import android.content.Context;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.router.Request;
import com.didi.payment.base.exts.ApplicationContextProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/kycservice/interceptor/PixKeyManagerInterceptor;", "Lcom/didi/drouter/router/IRouterInterceptor;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyManagerInterceptor.kt */
public final class PixKeyManagerInterceptor implements IRouterInterceptor {
    public void handle(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.getInterceptor().onInterrupt();
        Request build = DRouter.build("99pay://one/new_pix_key_manager");
        Context context = request.getContext();
        if (context == null) {
            context = ApplicationContextProvider.Companion.getContext();
        }
        build.start(context);
    }
}
