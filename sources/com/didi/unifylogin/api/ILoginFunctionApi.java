package com.didi.unifylogin.api;

import android.content.Context;
import com.didi.unifylogin.externalfunction.IExternalFunction;
import com.didi.unifylogin.listener.LoginListeners;
import org.json.JSONObject;

public interface ILoginFunctionApi extends IExternalFunction {
    void addLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener);

    void addLoginListener(LoginListeners.LoginListener loginListener);

    void addLoginOutListener(LoginListeners.LoginOutListener loginOutListener);

    void addTokenListener(LoginListeners.TokenListener tokenListener);

    void refreshCountryList();

    void removeLoginJumpListener(LoginListeners.LoginJumpListener loginJumpListener);

    void removeLoginListener(LoginListeners.LoginListener loginListener);

    void removeLoginOutListener(LoginListeners.LoginOutListener loginOutListener);

    void removeTokenListener(LoginListeners.TokenListener tokenListener);

    void requestPageAbTest(Context context, JSONObject jSONObject);

    void setCPFVerifyListener(LoginListeners.InputCPFListener inputCPFListener);

    void setCustomStateFragment(LoginListeners.CustomStateFragment customStateFragment);

    void setEmailSuffixListener(LoginListeners.ShowEmailSuffixListener showEmailSuffixListener);

    void setGetParamsListener(LoginListeners.GetParamsListener getParamsListener);

    void setInfoAutoFillListener(LoginListeners.InfoAutoFillListener infoAutoFillListener);

    void setIsFirstInstalledListener(LoginListeners.FirstInstallListener firstInstallListener);

    void setLoadingViewListener(LoginListeners.LoadingViewListener loadingViewListener);

    void setLoginInterceptor(LoginListeners.LoginInterceptor loginInterceptor);

    void setShowSkipListener(LoginListeners.ShowSkipListener showSkipListener);

    void setWhatsAppListener(LoginListeners.WhatsAppListener whatsAppListener);
}
