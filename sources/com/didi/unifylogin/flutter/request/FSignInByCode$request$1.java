package com.didi.unifylogin.flutter.request;

import android.text.TextUtils;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginNetErrNo;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.SignInByCodeResponse;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.NetworkUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eH\u0016¨\u0006\u000f"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FSignInByCode$request$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/SignInByCodeResponse;", "addCustomTrackParams", "", "event", "Lcom/didi/unifylogin/utils/LoginOmegaUtil;", "onFailure", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FSignInByCode.kt */
public final class FSignInByCode$request$1 extends LoginRpcCallbackV2<SignInByCodeResponse> {
    final /* synthetic */ FSignInByCode this$0;

    FSignInByCode$request$1(FSignInByCode fSignInByCode) {
        this.this$0 = fSignInByCode;
    }

    public void onSuccess(RpcResponseProxy<SignInByCodeResponse> rpcResponseProxy) {
        Intrinsics.checkParameterIsNotNull(rpcResponseProxy, "response");
        if (rpcResponseProxy.getContent() == null) {
            FSignInByCode fSignInByCode = this.this$0;
            fSignInByCode.resultSuccess(Result.error(fSignInByCode.getContext().getString(R.string.login_unify_net_error)));
            return;
        }
        SignInByCodeResponse content = rpcResponseProxy.getContent();
        LoginOmegaUtil loginOmegaUtil = new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_CODE_CHECK);
        if (content == null) {
            Intrinsics.throwNpe();
        }
        LoginOmegaUtil add = loginOmegaUtil.add("errno", Integer.valueOf(content.errno));
        if (content.uid > 0) {
            add.add("uid", Long.valueOf(content.uid));
        }
        add.send();
        int i = content.errno;
        if (i == 0) {
            this.this$0.getMessenger().setLoginMethod("sms");
            FSignInByCode fSignInByCode2 = this.this$0;
            fSignInByCode2.handToken(content, fSignInByCode2.getResult());
        } else if (i != 41012) {
            if (i != 41015) {
                switch (i) {
                    case LoginNetErrNo.ERRNO_MORE_CHECK_VERIFY:
                        break;
                    case 41072:
                        this.this$0.resultSuccess(Result.from(content));
                        String header = NetworkUtil.getHeader(rpcResponseProxy.getHeaders(), "didi-header-rid");
                        Intrinsics.checkExpressionValueIsNotNull(header, "NetworkUtil.getHeader(re…aders, \"didi-header-rid\")");
                        LoginOmegaUtil.trackLoginErrorEvent(2, content.error, content.errno == -1 ? rpcResponseProxy.getStatus() : content.errno, header, "signInByCode", (String) null);
                        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(content.errno)).send();
                        break;
                    case LoginNetErrNo.ERRNO_MFA_VERIFY_FAIL:
                        this.this$0.resultSuccess(Result.from(content));
                        break;
                    default:
                        this.this$0.resultSuccess(Result.error(!TextUtils.isEmpty(content.error) ? content.error : this.this$0.getContext().getResources().getString(R.string.login_unify_net_error)));
                        String header2 = NetworkUtil.getHeader(rpcResponseProxy.getHeaders(), "didi-header-rid");
                        Intrinsics.checkExpressionValueIsNotNull(header2, "NetworkUtil.getHeader(re…aders, \"didi-header-rid\")");
                        LoginOmegaUtil.trackLoginErrorEvent(2, content.error, content.errno == -1 ? rpcResponseProxy.getStatus() : content.errno, header2, "signInByCode", (String) null);
                        new LoginOmegaUtil(LoginOmegaUtil.LOGIN_FAIL_SW).add("errno", Integer.valueOf(content.errno)).send();
                        break;
                }
            }
            this.this$0.resultSuccess(Result.from(content));
        } else {
            this.this$0.getMessenger().setTempData(content.verifyEmailTexts == null ? null : content.verifyEmailTexts.toString());
            this.this$0.updateOmegaScene(FragmentMessenger.getNowScene());
            this.this$0.transform(LoginState.STATE_VERIFY_EMAIL);
            this.this$0.resultSuccess(Result.m31807ok());
        }
        super.onSuccess(rpcResponseProxy);
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signInByCode", (String) null);
        FSignInByCode fSignInByCode = this.this$0;
        fSignInByCode.resultSuccess(Result.error(fSignInByCode.getContext().getString(R.string.login_unify_net_error)));
    }

    /* access modifiers changed from: protected */
    public void addCustomTrackParams(LoginOmegaUtil loginOmegaUtil) {
        Intrinsics.checkParameterIsNotNull(loginOmegaUtil, "event");
        loginOmegaUtil.add("duration_since_input", Integer.valueOf((int) (this.this$0.f44789a / ((long) 1000))));
    }
}
