package com.didi.unifylogin.flutter.request;

import android.text.TextUtils;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.CodeMtResponse;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0010\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FCodeMT$request$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/CodeMtResponse;", "onFailure", "", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FCodeMT.kt */
public final class FCodeMT$request$1 extends LoginRpcCallbackV2<CodeMtResponse> {
    final /* synthetic */ FCodeMT this$0;

    FCodeMT$request$1(FCodeMT fCodeMT) {
        this.this$0 = fCodeMT;
    }

    public void onSuccess(RpcResponseProxy<CodeMtResponse> rpcResponseProxy) {
        super.onSuccess(rpcResponseProxy);
        CodeMtResponse content = rpcResponseProxy != null ? rpcResponseProxy.getContent() : null;
        if (content == null) {
            FCodeMT fCodeMT = this.this$0;
            fCodeMT.resultSuccess(Result.error(fCodeMT.getContext().getString(R.string.login_unify_net_error)));
            return;
        }
        if (content.pattern != null) {
            this.this$0.getMessenger().setCodeLength(content.pattern.codeLen);
        }
        int i = content.errno;
        if (i == 0) {
            this.this$0.getMessenger().setCodeType(content.code_type);
            this.this$0.getMessenger().setPrompt(content.prompt);
            this.this$0.getMessenger().setVoiceSupport(content.voiceSupport);
            this.this$0.resultSuccess(Result.from(content));
        } else if (i != 41002) {
            String string = TextUtils.isEmpty(content.error) ? this.this$0.getContext().getString(R.string.login_unify_net_error) : content.error;
            this.this$0.resultSuccess(Result.error(string));
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_TOAST_SW).add("err_code", Integer.valueOf(content.errno)).add("err_massage", string).send();
        } else {
            this.this$0.getMessenger().setCaptchaCell(this.this$0.getMessenger().getCell());
            this.this$0.resultSuccess(Result.from(content));
        }
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        if (iOException != null) {
            iOException.printStackTrace();
        }
        FCodeMT fCodeMT = this.this$0;
        fCodeMT.resultSuccess(Result.error(fCodeMT.getContext().getString(R.string.login_unify_net_error)));
    }
}
