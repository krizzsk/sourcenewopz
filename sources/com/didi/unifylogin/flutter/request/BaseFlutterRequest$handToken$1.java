package com.didi.unifylogin.flutter.request;

import com.didi.unifylogin.base.manager.LoginFillerFragmentManager;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.plugin.common.MethodChannel;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u001c\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\n2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0014H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0015"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/BaseFlutterRequest$handToken$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/ActionResponse;", "actionAfterLogin", "", "getActionAfterLogin", "()I", "setActionAfterLogin", "(I)V", "addCustomTrackParams", "", "event", "Lcom/didi/unifylogin/utils/LoginOmegaUtil;", "onFailure", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "response", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: BaseFlutterRequest.kt */
public final class BaseFlutterRequest$handToken$1 extends LoginRpcCallbackV2<ActionResponse> {
    final /* synthetic */ Map $ext;
    final /* synthetic */ MethodChannel.Result $result;
    private int actionAfterLogin;

    BaseFlutterRequest$handToken$1(Map map, MethodChannel.Result result) {
        this.$ext = map;
        this.$result = result;
    }

    public final int getActionAfterLogin() {
        return this.actionAfterLogin;
    }

    public final void setActionAfterLogin(int i) {
        this.actionAfterLogin = i;
    }

    public void onSuccess(RpcResponseProxy<ActionResponse> rpcResponseProxy) {
        ActionResponse content = rpcResponseProxy != null ? rpcResponseProxy.getContent() : null;
        if (content == null || content.errno != 0) {
            this.$result.success(Result.m31807ok());
        } else {
            if (content.actions.size() > 0) {
                this.actionAfterLogin = content.actions.get(0).action;
            }
            LoginFillerFragmentManager.setFillers(content.actions);
            String from = Result.from(content);
            Map map = this.$ext;
            if (map != null && !map.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject(from);
                    for (Object next : this.$ext.entrySet()) {
                        if (next != null) {
                            Map.Entry entry = (Map.Entry) next;
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            jSONObject.put("" + key, value);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Map.Entry<*, *>");
                        }
                    }
                    from = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.$result.success(from);
        }
        super.onSuccess(rpcResponseProxy);
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        this.$result.success(Result.m31807ok());
        if (iOException != null) {
            iOException.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void addCustomTrackParams(LoginOmegaUtil loginOmegaUtil) {
        Intrinsics.checkParameterIsNotNull(loginOmegaUtil, "event");
        loginOmegaUtil.add("action_after_login_0", Integer.valueOf(this.actionAfterLogin));
    }
}
