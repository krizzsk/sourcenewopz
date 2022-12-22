package com.didi.payment.kycservice.utils;

import android.content.Context;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.kycservice.constant.KycConstants;
import com.didi.payment.kycservice.kyc.SignUpActivity;
import com.didi.payment.kycservice.kyc.SignUpPageScene;
import com.didi.payment.kycservice.kyc.response.ResultPageData;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ0\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J \u0010\u0012\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/KycRegisterUtils;", "", "()V", "checkEmail", "", "email", "", "go2PixSignUpResultPage", "", "context", "Landroid/content/Context;", "resultData", "Lcom/didi/payment/kycservice/kyc/response/ResultPageData;", "go2SignUpActivity", "sourceType", "fromResultPage", "listener", "Lcom/didi/payment/kycservice/utils/KycRegisterUtils$RouterListener;", "go2TargetPage", "scene", "RouterListener", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KycRegisterUtils.kt */
public final class KycRegisterUtils {
    public static final KycRegisterUtils INSTANCE = new KycRegisterUtils();

    @Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/kycservice/utils/KycRegisterUtils$RouterListener;", "", "callback", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: KycRegisterUtils.kt */
    public interface RouterListener {
        void callback();
    }

    private KycRegisterUtils() {
    }

    public final boolean checkEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "email");
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            return false;
        }
        Pattern compile = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(regex)");
        Matcher matcher = compile.matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher, "pattern.matcher(email)");
        return matcher.matches();
    }

    public final void go2PixSignUpResultPage(Context context, ResultPageData resultPageData) {
        if (resultPageData != null) {
            ((Request) ((Request) DRouter.build(KycConstants.Router.KYC_REGISTER_ROUTER).putExtra("scene", SignUpPageScene.RESULT.getSceneTag())).putExtra(SignUpActivity.PARAM_RESULT_DATA, (Serializable) resultPageData)).start(context);
        }
    }

    public final void go2TargetPage(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "scene");
        Intrinsics.checkNotNullParameter(str2, "sourceType");
        ((Request) ((Request) DRouter.build(KycConstants.Router.KYC_REGISTER_ROUTER).putExtra("scene", str)).putExtra("source", str2)).start(context);
    }

    public static /* synthetic */ void go2SignUpActivity$default(KycRegisterUtils kycRegisterUtils, Context context, String str, boolean z, RouterListener routerListener, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "2";
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            routerListener = null;
        }
        kycRegisterUtils.go2SignUpActivity(context, str, z, routerListener);
    }

    public final void go2SignUpActivity(Context context, String str, boolean z, RouterListener routerListener) {
        Intrinsics.checkNotNullParameter(str, "sourceType");
        ((Request) ((Request) DRouter.build(KycConstants.Router.KYC_REGISTER_ROUTER).putExtra("source", str)).putExtra(SignUpActivity.PARAM_FROM_RESULT_PAGE, z)).start(context, new KycRegisterUtils$go2SignUpActivity$1(routerListener));
    }
}
