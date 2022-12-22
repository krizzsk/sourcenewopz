package com.didi.unifylogin.third;

import android.content.Context;
import android.text.TextUtils;
import com.didi.thirdpartylogin.base.ThirdPartyLoginListener;
import com.didi.unifylogin.api.LoginActionApi;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.AuthParam;
import com.didi.unifylogin.base.net.pojo.response.AuthResponse;
import com.didi.unifylogin.flutter.LoginLogicManager;
import com.didi.unifylogin.flutter.Result;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.NetworkUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import p242io.flutter.plugin.common.MethodChannel;

public class ThirdPartyLoginHandler implements ThirdPartyLoginListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f44898a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MethodChannel.Result f44899b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final String f44900c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public FragmentMessenger f44901d = LoginLogicManager.getMessenger();

    public ThirdPartyLoginHandler(Context context, String str, MethodChannel.Result result) {
        this.f44898a = context;
        this.f44899b = result;
        this.f44900c = str;
    }

    public void onSucess(final String str, String str2) {
        String reasonOfFirstInstall = ListenerManager.getFirstInstallListener() != null ? ListenerManager.getFirstInstallListener().reasonOfFirstInstall() : null;
        FragmentMessenger messenger = LoginLogicManager.getMessenger();
        this.f44901d = messenger;
        AuthParam idToken = new AuthParam(this.f44898a, messenger.getSceneNum()).setAuthChannel(this.f44900c).setIdToken(str);
        if (TextUtils.isEmpty(reasonOfFirstInstall)) {
            reasonOfFirstInstall = LoginActionApi.loginReason;
        }
        LoginModel.getFlutterNet(this.f44898a).signByAuth(idToken.setSignReason(reasonOfFirstInstall), new LoginRpcCallbackV2<AuthResponse>() {
            public void onSuccess(RpcResponseProxy<AuthResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                if (rpcResponseProxy == null || rpcResponseProxy.getContent() == null) {
                    ThirdPartyLoginHandler.this.m32202a((Object) Result.error());
                    return;
                }
                AuthResponse content = rpcResponseProxy.getContent();
                ThirdPartyLoginHandler.this.f44901d.setChannel(ThirdPartyLoginHandler.this.f44900c);
                ThirdPartyLoginHandler.this.f44901d.setLoginMethod(ThirdPartyLoginHandler.this.f44900c);
                ThirdPartyLoginHandler.this.f44901d.setScene(LoginScene.SCENE_THIRD_LOGIN);
                int i = content.errno;
                if (i == 0) {
                    ThirdPartyLoginHandler.this.f44901d.updateOmegaScene(LoginScene.SCENE_THIRD_LOGIN);
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_USERENTER).send();
                    if (!TextUtils.isEmpty(content.email)) {
                        ThirdPartyLoginHandler.this.f44901d.setHideEmail(content.email);
                    }
                    if (!TextUtils.isEmpty(content.credential)) {
                        ThirdPartyLoginHandler.this.f44901d.setCredential(content.credential);
                    }
                    ThirdPartyLoginHandler.this.f44901d.setCell(content.cell);
                    new LoginLogicManager(ThirdPartyLoginHandler.this.f44898a).handToken(content, ThirdPartyLoginHandler.this.f44899b);
                } else if (i != 41011) {
                    if (TextUtils.isEmpty(content.error)) {
                        content.error = ThirdPartyLoginHandler.this.f44898a.getString(R.string.login_unify_net_error);
                    }
                    LoginOmegaUtil.trackLoginErrorEvent(2, content.error, content.errno == -1 ? rpcResponseProxy.getStatus() : content.errno, NetworkUtil.getHeader(rpcResponseProxy.getHeaders(), "didi-header-rid"), "signByAuth", (String) null);
                    ThirdPartyLoginHandler.this.m32202a((Object) Result.from(content));
                } else {
                    ThirdPartyLoginHandler.this.f44901d.setAuthInfo(content.data);
                    ThirdPartyLoginHandler.this.f44901d.setIdtoken(str);
                    ThirdPartyLoginHandler.this.f44901d.updateOmegaScene(LoginScene.SCENE_THIRD_LOGIN);
                    new LoginLogicManager(ThirdPartyLoginHandler.this.f44898a).transform(LoginState.STATE_BIND_THIRD_PHONE);
                    ThirdPartyLoginHandler.this.m32202a((Object) Result.m31807ok());
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                LoginOmegaUtil.trackLoginErrorEvent(0, (String) null, -1, "", "signByAuth", (String) null);
                ThirdPartyLoginHandler thirdPartyLoginHandler = ThirdPartyLoginHandler.this;
                thirdPartyLoginHandler.m32202a((Object) Result.error(thirdPartyLoginHandler.f44898a.getString(R.string.login_unify_third_party_get_token_error)));
            }
        });
    }

    public void onFailure(Exception exc) {
        m32202a((Object) Result.error(this.f44898a.getString(R.string.login_unify_third_party_get_token_error)));
        new LoginOmegaUtil(LoginOmegaUtil.TECH_PAX_EVENT_THIRD_PARTY_TOKEN_ERROR).add("module", this.f44900c).add("err_type", 6).add("err_msg", exc.getMessage()).send();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32202a(Object obj) {
        try {
            this.f44899b.success(obj);
        } catch (Exception unused) {
        }
    }
}
