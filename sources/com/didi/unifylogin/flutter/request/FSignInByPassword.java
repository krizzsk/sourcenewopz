package com.didi.unifylogin.flutter.request;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.SignInByPasswordParam;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/FSignInByPassword;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "request", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FSignInByPassword.kt */
public final class FSignInByPassword extends BaseFlutterRequest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FSignInByPassword(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    public void request() {
        String str = (String) getCall().argument("verify_session_id");
        Long l = (Long) getCall().argument("uid");
        setScene(LoginScene.SCENE_PWD_LOGIN);
        getMessenger().setPassword((String) getCall().argument(CashierAction.ACTION_PASSWORD));
        String str2 = null;
        if (ListenerManager.getFirstInstallListener() != null) {
            str2 = ListenerManager.getFirstInstallListener().reasonOfFirstInstall();
        }
        SignInByPasswordParam cell = new SignInByPasswordParam(getContext(), getMessenger().getSceneNum()).setUid(l != null ? l.longValue() : 0).setVerifySessionId(str).setCell(getMessenger().getCell());
        if (TextUtils.isEmpty(str2)) {
            str2 = LoginActionApi.loginReason;
        }
        SignInByPasswordParam signReason = cell.setSignReason(str2);
        Integer num = (Integer) getCall().argument("mfa_version");
        SignInByPasswordParam mfaVersion = signReason.setMfaVersion(num != null ? num.intValue() : 0);
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            SignInByPasswordParam passwordEncrypt = mfaVersion.setPasswordEncrypt(1);
            Intrinsics.checkExpressionValueIsNotNull(passwordEncrypt, "param.setPasswordEncrypt(1)");
            passwordEncrypt.setPassword(RsaEncryptUtil.getRSAData(getContext(), getMessenger().getPassword()));
        } else {
            Intrinsics.checkExpressionValueIsNotNull(mfaVersion, "param");
            mfaVersion.setPassword(getMessenger().getPassword());
        }
        LoginModel.getFlutterNet(getContext()).signInByPassword(mfaVersion, new FSignInByPassword$request$1(this));
    }
}
