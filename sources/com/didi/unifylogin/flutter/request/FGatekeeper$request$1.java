package com.didi.unifylogin.flutter.request;

import android.text.TextUtils;
import com.didi.unifylogin.api.ILoginStoreApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.GateKeeperResponse;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¨\u0006\u0013"}, mo175978d2 = {"com/didi/unifylogin/flutter/request/FGatekeeper$request$1", "Lcom/didi/unifylogin/base/net/LoginRpcCallbackV2;", "Lcom/didi/unifylogin/base/net/pojo/response/GateKeeperResponse;", "addCustomTrackParams", "", "event", "Lcom/didi/unifylogin/utils/LoginOmegaUtil;", "onFailure", "request", "Lcom/didichuxing/foundation/rpc/RpcRequest;", "exception", "Ljava/io/IOException;", "onSuccess", "proxy", "Lcom/didichuxing/foundation/rpc/RpcResponseProxy;", "saveActionOfSeven", "actions", "", "Lcom/didi/unifylogin/base/net/pojo/response/GateKeeperResponse$Action;", "OneLogin_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: FGatekeeper.kt */
public final class FGatekeeper$request$1 extends LoginRpcCallbackV2<GateKeeperResponse> {
    final /* synthetic */ FGatekeeper this$0;

    FGatekeeper$request$1(FGatekeeper fGatekeeper) {
        this.this$0 = fGatekeeper;
    }

    public void onSuccess(RpcResponseProxy<GateKeeperResponse> rpcResponseProxy) {
        GateKeeperResponse content = rpcResponseProxy != null ? rpcResponseProxy.getContent() : null;
        if (content == null) {
            FGatekeeper fGatekeeper = this.this$0;
            fGatekeeper.resultSuccess(Result.error(fGatekeeper.getContext().getResources().getString(R.string.login_unify_net_error)));
            return;
        }
        if (content.errno != 0) {
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_PHONE_CHECK).add("errno", Integer.valueOf(content.errno)).send();
            this.this$0.resultSuccess(Result.error(!TextUtils.isEmpty(content.error) ? content.error : this.this$0.getContext().getResources().getString(R.string.login_unify_net_error)));
        } else {
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_USERENTER).send();
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_CONFM_USERTYPE_CK).send();
            if (content.roles == null) {
                this.this$0.resultSuccess(Result.error(!TextUtils.isEmpty(content.error) ? content.error : this.this$0.getContext().getResources().getString(R.string.login_unify_net_error)));
                return;
            }
            LoginStore instance = LoginStore.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "LoginStore.getInstance()");
            instance.setUserType(content.usertype);
            this.this$0.f44788b = content.usertype;
            this.this$0.getMessenger().setHideEmail(content.email);
            this.this$0.getMessenger().setCredential(content.credential);
            this.this$0.getMessenger().setFaceDes(content.faceDes);
            saveActionOfSeven(content.actions);
            ILoginStoreApi store = OneLoginFacade.getStore();
            Intrinsics.checkExpressionValueIsNotNull(store, "OneLoginFacade.getStore()");
            if (store.isNewUser()) {
                new LoginOmegaUtil(LoginOmegaUtil.CONFM_NEWUSER_CK).send();
            }
            if (content.roles.size() > 1) {
                LoginStore.getInstance().setAndSaveDoubleId(true);
            } else {
                LoginStore.getInstance().setAndSaveDoubleId(false);
                LoginStore.getInstance().setAndSaveRole(content.roles.get(0).f44704id);
                this.this$0.goLogin(content.roles.get(0).login_type);
                this.this$0.f44787a = content.roles.get(0).login_type;
            }
            this.this$0.resultSuccess(Result.from(content));
        }
        super.onSuccess(rpcResponseProxy);
    }

    public void onFailure(RpcRequest rpcRequest, IOException iOException) {
        super.onFailure(rpcRequest, iOException);
        FGatekeeper fGatekeeper = this.this$0;
        fGatekeeper.resultSuccess(Result.error(fGatekeeper.getContext().getResources().getString(R.string.login_unify_net_error)));
    }

    public final void saveActionOfSeven(List<? extends GateKeeperResponse.Action> list) {
        if (list != null && (!list.isEmpty())) {
            for (GateKeeperResponse.Action action : list) {
                if (action.action == 7) {
                    LoginStore instance = LoginStore.getInstance();
                    Intrinsics.checkExpressionValueIsNotNull(instance, "LoginStore.getInstance()");
                    instance.setFinishInputInfo(false);
                    LoginLog.write("saveActionOfSeven: need");
                    return;
                }
            }
        }
        LoginStore instance2 = LoginStore.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "LoginStore.getInstance()");
        instance2.setFinishInputInfo(true);
    }

    /* access modifiers changed from: protected */
    public void addCustomTrackParams(LoginOmegaUtil loginOmegaUtil) {
        Intrinsics.checkParameterIsNotNull(loginOmegaUtil, "event");
        loginOmegaUtil.add("login_type", Integer.valueOf(this.this$0.f44787a));
        loginOmegaUtil.add("usertype", Integer.valueOf(this.this$0.f44788b));
    }
}
