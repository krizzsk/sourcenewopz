package com.didi.unifylogin.externalfunction;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.SignOffParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import java.io.IOException;
import java.util.Iterator;

public class LogoutManager {

    /* renamed from: a */
    private final Context f44768a;

    /* renamed from: b */
    private final String f44769b;

    /* renamed from: c */
    private String f44770c;

    /* renamed from: d */
    private String f44771d;

    public LogoutManager(Context context, String str) {
        this.f44768a = context;
        this.f44769b = str;
    }

    public void activeLogout() {
        m31794a(false, true);
    }

    public void passiveLogout(String str, String str2) {
        this.f44770c = str;
        this.f44771d = str2;
        m31794a(false, false);
    }

    public void silenceLogout() {
        m31794a(true, true);
    }

    /* renamed from: a */
    private void m31794a(boolean z, final boolean z2) {
        if (OneLoginFacade.getStore().isLoginNow()) {
            SignOffParam ticket = new SignOffParam(this.f44768a, LoginScene.SCENE_LOGINOUT.getSceneNum()).setTicket(LoginStore.getInstance().getToken());
            if (!TextUtils.isEmpty(this.f44769b)) {
                ticket.setSignReason(this.f44769b);
            }
            LoginModel.getNet(this.f44768a).signOff(ticket, new LoginRpcCallbackV2<BaseResponse>() {
                public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    LogoutManager.this.m31792a(rpcResponseProxy.getContent().errno, z2);
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    LogoutManager.this.m31792a(-1, z2);
                }
            });
            LoginStore.getInstance().loginOutClean();
            if (!z) {
                Iterator<LoginListeners.LoginOutListener> it = ListenerManager.getLoginOutListeners().iterator();
                while (it.hasNext()) {
                    it.next().onSuccess();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31792a(int i, boolean z) {
        LoginOmegaUtil loginOmegaUtil;
        if (z) {
            loginOmegaUtil = new LoginOmegaUtil(LoginOmegaUtil.TECH_PASSPORT_LOGOUT_POSITIVE);
        } else {
            loginOmegaUtil = new LoginOmegaUtil(LoginOmegaUtil.TECH_PASSPORT_LOGOUT_KICK);
            loginOmegaUtil.add("url", this.f44770c);
            loginOmegaUtil.add("trace", this.f44771d);
        }
        loginOmegaUtil.add("errno", Integer.valueOf(i));
        loginOmegaUtil.add("reason", this.f44769b);
        loginOmegaUtil.send();
    }
}
