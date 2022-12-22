package com.didi.payment.kycservice.interceptor;

import android.content.Context;
import android.os.Bundle;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterInterceptor;
import com.didi.drouter.router.Request;
import com.didi.payment.base.anti.AccessBlockManager;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.kycservice.constant.KycConstants;
import com.didi.payment.kycservice.net.PixNetModel;
import com.didi.payment.kycservice.utils.KycStore;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/interceptor/SignUpInterceptor;", "Lcom/didi/drouter/router/IRouterInterceptor;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SignUpInterceptor.kt */
public final class SignUpInterceptor implements IRouterInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public void handle(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        request.getInterceptor().onInterrupt();
        Companion.goNewRouterPage(request);
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/interceptor/SignUpInterceptor$Companion;", "", "()V", "checkKycDone", "", "request", "Lcom/didi/drouter/router/Request;", "source", "", "goNewRouterPage", "goSignPage", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SignUpInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void goNewRouterPage(Request request) {
            String str;
            Intrinsics.checkNotNullParameter(request, "request");
            SystemUtils.log(3, "kyc_test", Intrinsics.stringPlus("req url=", request.getUri()), (Throwable) null, "com.didi.payment.kycservice.interceptor.SignUpInterceptor$Companion", 40);
            CharSequence string = request.extra.getString("source");
            boolean z = false;
            Object obj = null;
            if (string == null || string.length() == 0) {
                String uri = request.getUri().toString();
                Intrinsics.checkNotNullExpressionValue(uri, "request.uri.toString()");
                if (StringsKt.contains$default((CharSequence) uri, (CharSequence) "one/register", false, 2, (Object) null)) {
                    str = "1";
                } else {
                    String uri2 = request.getUri().toString();
                    Intrinsics.checkNotNullExpressionValue(uri2, "request.uri.toString()");
                    str = StringsKt.contains$default((CharSequence) uri2, (CharSequence) "one/pix_register", false, 2, (Object) null) ? "3" : "2";
                }
            } else {
                str = String.valueOf(request.extra.get("source"));
            }
            Bundle bundle = request.extra;
            if (bundle != null) {
                z = Intrinsics.areEqual(bundle.get(AccessBlockManager.PARAM_ACCESS_BLOCK), (Object) true);
            }
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append("block = ");
                Bundle bundle2 = request.extra;
                sb.append(bundle2 == null ? null : bundle2.get(AccessBlockManager.PARAM_ACCESS_BLOCK));
                sb.append(", error={");
                Bundle bundle3 = request.extra;
                if (bundle3 != null) {
                    obj = bundle3.get(AccessBlockManager.PARAM_ACCESS_BLOCK_CODE);
                }
                sb.append(obj);
                sb.append('}');
                SystemUtils.log(3, "kyc_test", sb.toString(), (Throwable) null, "com.didi.payment.kycservice.interceptor.SignUpInterceptor$Companion", 65);
            }
            SystemUtils.log(3, "kyc_test", "sourceType = " + str + " ,router = " + request.getUri(), (Throwable) null, "com.didi.payment.kycservice.interceptor.SignUpInterceptor$Companion", 72);
            checkKycDone(request, str);
        }

        public final void goSignPage(Request request, String str) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(str, "source");
            Request build = DRouter.build(KycConstants.Router.KYC_REGISTER_ROUTER);
            build.extra = request.extra;
            build.putExtra("source", str);
            Context context = request.getContext();
            if (context == null) {
                context = ApplicationContextProvider.Companion.getContext();
            }
            build.start(context);
        }

        private final void checkKycDone(Request request, String str) {
            if (!WalletCommonParamsUtil.is99PayClient() || KycStore.INSTANCE.getLatourKycStatus() == 1 || Intrinsics.areEqual((Object) str, (Object) "4") || Intrinsics.areEqual((Object) str, (Object) "6")) {
                goSignPage(request, str);
                return;
            }
            Context context = request.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "request.context");
            new PixNetModel(context).getGuidesInfo(new SignUpInterceptor$Companion$checkKycDone$1(request, str), "2");
        }
    }
}
