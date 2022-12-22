package com.didi.unifylogin.api;

import android.content.Context;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.response.LoginPageAbTestResponse;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.externalfunction.ExternalFunction;
import com.didi.unifylogin.externalfunction.IExternalFunction;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.utils.ApolloSwitch;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

@ServiceProvider({ILoginFunctionApi.class})
public class LoginFunctionApi implements ILoginFunctionApi {

    /* renamed from: a */
    private static IExternalFunction f44623a = new ExternalFunction();

    /* renamed from: a */
    private static IExternalFunction m31710a() {
        return f44623a;
    }

    public void addLoginListener(LoginListeners.LoginListener loginListener) {
        ListenerManager.addLoginListener(loginListener);
    }

    public void removeLoginListener(LoginListeners.LoginListener loginListener) {
        ListenerManager.removeLoginListener(loginListener);
    }

    public void setCPFVerifyListener(LoginListeners.InputCPFListener inputCPFListener) {
        ListenerManager.setCpfInputListener(inputCPFListener);
    }

    public void addLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener) {
        ListenerManager.addLoginJumpListener(loginJumpListener);
    }

    public void removeLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener) {
        ListenerManager.removeLoginJumpListener(loginJumpListener);
    }

    public void addLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        ListenerManager.addLoginOutListener(loginOutListener);
    }

    public void removeLoginOutListener(LoginListeners.LoginOutListener loginOutListener) {
        ListenerManager.removeLoginOutListener(loginOutListener);
    }

    public void addTokenListener(LoginListeners.TokenListener tokenListener) {
        ListenerManager.addTokenListener(tokenListener);
    }

    public void removeTokenListener(LoginListeners.TokenListener tokenListener) {
        ListenerManager.removeTokenListener(tokenListener);
    }

    public void refreshCountryList() {
        CountryManager.getIns().getCountriesFromNet((CountryManager.CountriesChangeListener) null);
    }

    public void setLoginInterceptor(LoginListeners.LoginInterceptor loginInterceptor) {
        ListenerManager.setLoginInterceptor(loginInterceptor);
    }

    public void setCustomStateFragment(LoginListeners.CustomStateFragment customStateFragment) {
        ListenerManager.setCustomStateFragmen(customStateFragment);
    }

    public void setLoadingViewListener(LoginListeners.LoadingViewListener loadingViewListener) {
        ListenerManager.setLoadingViewListener(loadingViewListener);
    }

    public void validate(Context context, LoginListeners.ValidateTicketListener validateTicketListener) {
        m31710a().validate(context, validateTicketListener);
    }

    public void passwordVerify(Context context, String str, LoginListeners.PasswordVerifyListener passwordVerifyListener) {
        m31710a().passwordVerify(context, str, passwordVerifyListener);
    }

    public void refreshToken(Context context) {
        m31710a().refreshToken(context);
    }

    public void uploadLocation(Context context, Map<String, Object> map, LoginListeners.PassportServerCallback passportServerCallback) {
        m31710a().uploadLocation(context, map, passportServerCallback);
    }

    public void getEmailStatus(Context context, LoginListeners.EmailStatusListener emailStatusListener) {
        m31710a().getEmailStatus(context, emailStatusListener);
    }

    public void setWhatsAppListener(LoginListeners.WhatsAppListener whatsAppListener) {
        ListenerManager.setWhatsAppListener(whatsAppListener);
    }

    public void setGetParamsListener(LoginListeners.GetParamsListener getParamsListener) {
        ListenerManager.setParamsListener(getParamsListener);
    }

    public void setIsFirstInstalledListener(LoginListeners.FirstInstallListener firstInstallListener) {
        ListenerManager.setFirstInstallListener(firstInstallListener);
    }

    public void setInfoAutoFillListener(LoginListeners.InfoAutoFillListener infoAutoFillListener) {
        ListenerManager.setInfoAutoFillListener(infoAutoFillListener);
    }

    public void setShowSkipListener(LoginListeners.ShowSkipListener showSkipListener) {
        ListenerManager.setShowSkipListener(showSkipListener);
    }

    public void setEmailSuffixListener(LoginListeners.ShowEmailSuffixListener showEmailSuffixListener) {
        ListenerManager.setEmailSuffixListener(showEmailSuffixListener);
    }

    public void requestPageAbTest(Context context, JSONObject jSONObject) {
        LoginModel.getFlutterNet(context).loginPageAbTest(jSONObject.toString(), new LoginRpcCallbackV2<LoginPageAbTestResponse>() {
            public void onSuccess(RpcResponseProxy<LoginPageAbTestResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                LoginPageAbTestResponse content = rpcResponseProxy.getContent();
                if (content != null && content.errno == 0) {
                    ApolloSwitch.getInstance().updatePassportUpdateSDK(content);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
            }
        });
    }
}
