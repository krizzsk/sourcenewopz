package com.didi.unifylogin.externalfunction;

import android.content.Context;
import android.text.TextUtils;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.BaseParam;
import com.didi.unifylogin.base.net.pojo.request.SimpleParam;
import com.didi.unifylogin.base.net.pojo.request.VerifyPasswordParam;
import com.didi.unifylogin.base.net.pojo.response.BaseResponse;
import com.didi.unifylogin.base.net.pojo.response.GetEmailInfoResponse;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.RsaEncryptUtil;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class ExternalFunction implements IExternalFunction {
    public void passwordVerify(final Context context, String str, final LoginListeners.PasswordVerifyListener passwordVerifyListener) {
        VerifyPasswordParam ticket = new VerifyPasswordParam(context, LoginScene.SCENE_UNDEFINED.getSceneNum()).setCell(LoginStore.getInstance().getPhone()).setTicket(LoginStore.getInstance().getToken());
        if (LoginPreferredConfig.isPasswordEncrypt()) {
            ticket.setPasswordEncrypt(1).setPassword(RsaEncryptUtil.getRSAData(context, str));
        } else {
            ticket.setPassword(str);
        }
        LoginModel.getNet(context).verifyPassword(ticket, new LoginRpcCallbackV2<BaseResponse>() {
            public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                BaseResponse content = rpcResponseProxy.getContent();
                if (content.errno != 0) {
                    LoginListeners.PasswordVerifyListener passwordVerifyListener = passwordVerifyListener;
                    if (passwordVerifyListener != null) {
                        passwordVerifyListener.onFail(content.errno, content.error);
                        return;
                    }
                    return;
                }
                LoginListeners.PasswordVerifyListener passwordVerifyListener2 = passwordVerifyListener;
                if (passwordVerifyListener2 != null) {
                    passwordVerifyListener2.onSucess();
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                LoginListeners.PasswordVerifyListener passwordVerifyListener = passwordVerifyListener;
                if (passwordVerifyListener != null) {
                    passwordVerifyListener.onFail(-1, context.getString(R.string.login_unify_net_error));
                }
            }
        });
    }

    public void validate(Context context, final LoginListeners.ValidateTicketListener validateTicketListener) {
        if (TextUtils.isEmpty(LoginStore.getInstance().getToken())) {
            validateTicketListener.onFail("user is not logged");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ticket", LoginStore.getInstance().getToken());
        LoginModel.getNet(context).validate(hashMap, new LoginRpcCallbackV2<BaseResponse>() {
            public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                BaseResponse content = rpcResponseProxy.getContent();
                LoginListeners.ValidateTicketListener validateTicketListener = validateTicketListener;
                if (validateTicketListener != null) {
                    if (content == null) {
                        validateTicketListener.onFail("response is null");
                    } else if (content.errno != 0) {
                        validateTicketListener.onFail(content.error);
                    } else {
                        validateTicketListener.onSucc();
                    }
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                validateTicketListener.onFail(iOException.toString());
            }
        });
    }

    public void refreshToken(Context context) {
        if (OneLoginFacade.getStore().isLoginNow()) {
            new RefreshTicketManager().refreshTicket(context);
        }
    }

    public void uploadLocation(Context context, Map<String, Object> map, final LoginListeners.PassportServerCallback passportServerCallback) {
        if (context != null) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.putAll(new BaseParam(context, LoginScene.SCENE_UNDEFINED.getSceneNum()).getBaseObjectMap());
            map.put("ticket", LoginStore.getInstance().getToken());
            LoginModel.getNet(context).uploadLocation(map, new LoginRpcCallbackV2<BaseResponse>() {
                public void onSuccess(RpcResponseProxy<BaseResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    BaseResponse content = rpcResponseProxy.getContent();
                    if (content == null) {
                        LoginListeners.PassportServerCallback passportServerCallback = passportServerCallback;
                        if (passportServerCallback != null) {
                            passportServerCallback.onSucc(-1, (JSONObject) null);
                            return;
                        }
                        return;
                    }
                    LoginListeners.PassportServerCallback passportServerCallback2 = passportServerCallback;
                    if (passportServerCallback2 != null) {
                        passportServerCallback2.onSucc(content.errno, (JSONObject) null);
                    }
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    LoginListeners.PassportServerCallback passportServerCallback = passportServerCallback;
                    if (passportServerCallback != null) {
                        passportServerCallback.onFail(iOException);
                    }
                }
            });
        }
    }

    public void getEmailStatus(Context context, final LoginListeners.EmailStatusListener emailStatusListener) {
        if (context != null) {
            LoginModel.getNet(context).getEmailInfo(new SimpleParam(context, LoginScene.SCENE_UNDEFINED.getSceneNum()).setTicket(LoginStore.getInstance().getToken()), new LoginRpcCallbackV2<GetEmailInfoResponse>() {
                public void onSuccess(RpcResponseProxy<GetEmailInfoResponse> rpcResponseProxy) {
                    super.onSuccess(rpcResponseProxy);
                    GetEmailInfoResponse content = rpcResponseProxy.getContent();
                    if (emailStatusListener != null && content.errno == 0) {
                        emailStatusListener.onSucc(content.emailStatus, content.email);
                    }
                }

                public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                    super.onFailure(rpcRequest, iOException);
                    LoginListeners.EmailStatusListener emailStatusListener = emailStatusListener;
                    if (emailStatusListener != null) {
                        emailStatusListener.onFail(iOException);
                    }
                }
            });
        }
    }
}
