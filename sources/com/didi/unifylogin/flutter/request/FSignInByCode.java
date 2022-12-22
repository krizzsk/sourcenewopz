package com.didi.unifylogin.flutter.request;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.SignInByCodeParam;
import com.didi.unifylogin.listener.ListenerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/FSignInByCode;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "durationSinceInput", "", "request", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FSignInByCode.kt */
public final class FSignInByCode extends BaseFlutterRequest {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f44789a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FSignInByCode(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    public void request() {
        Object argument = getCall().argument("code");
        if (argument == null) {
            Intrinsics.throwNpe();
        }
        String str = (String) argument;
        String str2 = (String) getCall().argument("verify_session_id");
        Long l = (Long) getCall().argument("uid");
        long j = 0;
        if (getMessenger().getLastCodeMTTime() != 0) {
            this.f44789a = SystemClock.uptimeMillis() - getMessenger().getLastCodeMTTime();
        }
        getMessenger().setScene(LoginScene.SCENE_FORGETPWD);
        getMessenger().setCode(str);
        String str3 = null;
        if (ListenerManager.getFirstInstallListener() != null) {
            str3 = ListenerManager.getFirstInstallListener().reasonOfFirstInstall();
        }
        SignInByCodeParam verifySessionId = new SignInByCodeParam(getContext(), getMessenger().getSceneNum()).setVerifySessionId(str2);
        if (l != null) {
            j = l.longValue();
        }
        SignInByCodeParam code = verifySessionId.setUid(j).setCell(getMessenger().getCell()).setCodeType(getMessenger().getCodeType()).setCode(getMessenger().getCode());
        if (TextUtils.isEmpty(str3)) {
            str3 = LoginActionApi.loginReason;
        }
        SignInByCodeParam signReason = code.setSignReason(str3);
        Integer num = (Integer) getCall().argument("mfa_version");
        LoginModel.getFlutterNet(getContext()).signInByCode(signReason.setMfaVersion(num != null ? num.intValue() : 0), new FSignInByCode$request$1(this));
    }
}
