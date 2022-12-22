package com.didi.unifylogin.flutter.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.ForgetPasswordParam;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/FForgetPassword;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "request", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FForgetPassword.kt */
public final class FForgetPassword extends BaseFlutterRequest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FForgetPassword(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    public void request() {
        String str = (String) getCall().argument("cell");
        String str2 = (String) getCall().argument("code");
        String str3 = (String) getCall().argument(CashierAction.ACTION_PASSWORD);
        Object argument = getCall().argument("codeType");
        if (argument == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(argument, "call.argument<Int>(\"codeType\")!!");
        int intValue = ((Number) argument).intValue();
        getMessenger().setScene(LoginScene.SCENE_FORGETPWD);
        updateOmegaScene(LoginScene.SCENE_FORGETPWD);
        getMessenger().setCode(str2);
        ForgetPasswordParam codeType = new ForgetPasswordParam(getContext(), getMessenger().getSceneNum()).setCell(str).setCode(getMessenger().getCode()).setCodeType(intValue);
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            ForgetPasswordParam passwordEncrypt = codeType.setPasswordEncrypt(1);
            Intrinsics.checkExpressionValueIsNotNull(passwordEncrypt, "param.setPasswordEncrypt(1)");
            passwordEncrypt.setNewPassword(RsaEncryptUtil.getRSAData(getContext(), str3));
        } else {
            Intrinsics.checkExpressionValueIsNotNull(codeType, "param");
            codeType.setNewPassword(str3);
        }
        LoginModel.getFlutterNet(getContext()).forgetPassword(codeType, new FForgetPassword$request$1(this));
    }
}
