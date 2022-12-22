package com.didi.unifylogin.flutter.request;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.pojo.request.VerifyBankAccountParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p242io.flutter.plugin.common.MethodCall;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/unifylogin/flutter/request/FVerifyBankAccount;", "Lcom/didi/unifylogin/flutter/request/BaseFlutterRequest;", "context", "Landroid/content/Context;", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "(Landroid/content/Context;Lio/flutter/plugin/common/MethodCall;Lio/flutter/plugin/common/MethodChannel$Result;)V", "request", "", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FVerifyBankAccount.kt */
public final class FVerifyBankAccount extends BaseFlutterRequest {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FVerifyBankAccount(Context context, MethodCall methodCall, MethodChannel.Result result) {
        super(context, methodCall, result);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(result, "result");
    }

    public void request() {
        Long l = (Long) getCall().argument("uid");
        String str = (String) getCall().argument("verify_session_id");
        Integer num = (Integer) getCall().argument("data_len");
        String str2 = (String) getCall().argument("verify_data");
        Integer num2 = (Integer) getCall().argument("mfa_version");
        VerifyBankAccountParam verifyBankAccountParam = new VerifyBankAccountParam(getContext(), getMessenger().getSceneNum());
        int i = 0;
        VerifyBankAccountParam verifySessionId = verifyBankAccountParam.setDataLen(num != null ? num.intValue() : 0).setUid(l != null ? l.longValue() : 0).setVerifyData(str2).setVerifySessionId(str);
        if (num2 != null) {
            i = num2.intValue();
        }
        verifySessionId.setMfaVersion(i);
        LoginModel.getFlutterNet(getContext()).verifyBankAccount(verifyBankAccountParam, new FVerifyBankAccount$request$1(this));
    }
}
