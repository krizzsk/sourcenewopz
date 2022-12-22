package com.didi.foundation.sdk.login;

import android.content.Context;
import android.content.Intent;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface LoginServiceProvider {
    void addLoginListener(LoginCallbacks.LoginListener loginListener);

    void addLogoutListener(LoginCallbacks.LoginOutListener loginOutListener);

    String getCityId();

    String getCountryCode();

    Intent getLoginIntent(Context context);

    String getPhone();

    String getToken();

    String getUid();

    void go2CancelOrDeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener);

    void go2CancellationAccount(Context context, LoginCallbacks.CancelAccFinishListener cancelAccFinishListener);

    void go2Login(Context context);

    void go2ModifyEmail(Context context, LoginCallbacks.ModifyEmailListener modifyEmailListener);

    void go2ModifyPassword(Context context, LoginCallbacks.ModifyPasswordListener modifyPasswordListener);

    void go2ModifyPhone(Context context, LoginCallbacks.SetCellListener setCellListener);

    void go2SetThirdParty(Context context);

    void init(Context context);

    boolean isLogin();

    void logout(Context context);

    void logout(Context context, String str);

    void removeLoginListener(LoginCallbacks.LoginListener loginListener);

    void removeLogoutListener(LoginCallbacks.LoginOutListener loginOutListener);

    void setButtonStyle(LoginButtonStyle loginButtonStyle);

    void setTheme(int i);
}
