package com.didi.unifylogin.flutter.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.SetEmailParam;
import com.didi.unifylogin.store.LoginStore;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/FSetEmail;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "request", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FSetEmail.kt */
public final class FSetEmail extends BaseFlutterRequest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FSetEmail(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    public void request() {
        Integer num = (Integer) getCall().argument("push_app_type");
        Boolean bool = (Boolean) getCall().argument("close_marketing_notify");
        SetEmailParam setEmailParam = new SetEmailParam(getContext(), getMessenger().getSceneNum());
        LoginStore instance = LoginStore.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "LoginStore.getInstance()");
        SetEmailParam promoCode = setEmailParam.setTicket(instance.getTemporaryToken()).setFirstName((String) getCall().argument(ParamConst.PARAM_FIRST_NAME)).setLastName((String) getCall().argument(ParamConst.PARAM_LAST_NAME)).setNewEmail((String) getCall().argument("new_email")).setPromoCode((String) getCall().argument(ShareConstants.PROMO_CODE));
        Intrinsics.checkExpressionValueIsNotNull(promoCode, "param");
        promoCode.setSessionId((String) getCall().argument("session_id"));
        boolean z = false;
        promoCode.setPushAppType(num != null ? num.intValue() : 0);
        if (bool != null) {
            z = bool.booleanValue();
        }
        promoCode.setCloseMarketingNotify(z);
        LoginModel.getFlutterNet(getContext()).setEmail(promoCode, new FSetEmail$request$1(this));
    }
}
