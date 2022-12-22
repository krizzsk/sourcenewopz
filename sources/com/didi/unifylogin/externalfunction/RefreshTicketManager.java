package com.didi.unifylogin.externalfunction;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.RefreshTicketParam;
import com.didi.unifylogin.base.net.pojo.response.RefreshTicketResponse;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginLog;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import java.io.IOException;
import java.util.Iterator;

public class RefreshTicketManager {
    public static final long TOKEN_EXPIRE_TIME = 259200000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f44772a = "RefreshTicketManager";

    public void refreshTicket(Context context) {
        if (m31796b()) {
            LoginLog.write(f44772a + " refreshTicket() ");
            LoginModel.getNet(context).refreshTicket(new RefreshTicketParam(context, LoginScene.SCENE_UNDEFINED.getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginRpcCallbackV2<RefreshTicketResponse>() {
                public void onSuccess(RpcResponseProxy<RefreshTicketResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    RefreshTicketResponse content = rpcResponseProxy.getContent();
                    if (content != null && content.errno == 0 && !TextUtil.isEmpty(content.ticket)) {
                        LoginLog.write(RefreshTicketManager.f44772a + " refreshTicket() success");
                        LoginStore.getInstance().setAndsaveToken(content.ticket);
                        if (ListenerManager.getTokenListeners() != null) {
                            Iterator<LoginListeners.TokenListener> it = ListenerManager.getTokenListeners().iterator();
                            while (it.hasNext()) {
                                it.next().onSuccess(LoginStore.getInstance().getToken());
                            }
                        }
                    }
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    LoginLog.write(RefreshTicketManager.f44772a + " refreshTicket() onFailure");
                    iOException.printStackTrace();
                }
            });
        }
    }

    /* renamed from: b */
    private boolean m31796b() {
        return System.currentTimeMillis() - LoginStore.getInstance().getTokenRefreshTime().longValue() > TOKEN_EXPIRE_TIME;
    }
}
