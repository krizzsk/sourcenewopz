package com.didi.foundation.sdk.login;

import android.content.Context;
import android.content.Intent;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.foundation.spi.ServiceLoader;

public final class LoginService implements LoginServiceProvider {

    /* renamed from: a */
    private final LoginServiceProvider f21247a;

    private LoginService() {
        this.f21247a = (LoginServiceProvider) ServiceLoader.load(LoginServiceProvider.class).get();
    }

    public static final LoginService getInstance() {
        return Singleton.INSTANCE;
    }

    public final void init(Context context) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.init(context);
        }
    }

    public final void go2Login(Context context) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.go2Login(context);
        }
    }

    public final Intent getLoginIntent(Context context) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            return loginServiceProvider.getLoginIntent(context);
        }
        return null;
    }

    public final void logout(Context context) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.logout(context);
        }
    }

    public final void logout(Context context, String str) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.logout(context, str);
        }
    }

    public final void go2ModifyPassword(Context context, LoginCallbacks.ModifyPasswordListener modifyPasswordListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.go2ModifyPassword(context, modifyPasswordListener);
        }
    }

    public final void go2ModifyPhone(Context context, LoginCallbacks.SetCellListener setCellListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.go2ModifyPhone(context, setCellListener);
        }
    }

    public final void go2SetThirdParty(Context context) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.go2SetThirdParty(context);
        }
    }

    public final void go2ModifyEmail(Context context, LoginCallbacks.ModifyEmailListener modifyEmailListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.go2ModifyEmail(context, modifyEmailListener);
        }
    }

    public final void addLoginListener(LoginCallbacks.LoginListener loginListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.addLoginListener(loginListener);
        }
    }

    public final void removeLoginListener(LoginCallbacks.LoginListener loginListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.removeLoginListener(loginListener);
        }
    }

    public final void addLogoutListener(LoginCallbacks.LoginOutListener loginOutListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.addLogoutListener(loginOutListener);
        }
    }

    public final void removeLogoutListener(LoginCallbacks.LoginOutListener loginOutListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.removeLogoutListener(loginOutListener);
        }
    }

    public final void go2CancellationAccount(Context context, LoginCallbacks.CancelAccFinishListener cancelAccFinishListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.go2CancellationAccount(context, cancelAccFinishListener);
        }
    }

    public final void go2CancelOrDeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.go2CancelOrDeleteAccount(context, cancelAccFinishListener);
        }
    }

    public final void setTheme(int i) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.setTheme(i);
        }
    }

    public final void setButtonStyle(LoginButtonStyle loginButtonStyle) {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            loginServiceProvider.setButtonStyle(loginButtonStyle);
        }
    }

    public final String getPhone() {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            return loginServiceProvider.getPhone();
        }
        return null;
    }

    public final String getToken() {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            return loginServiceProvider.getToken();
        }
        return null;
    }

    public final String getUid() {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            return loginServiceProvider.getUid();
        }
        return null;
    }

    public final String getCityId() {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            return loginServiceProvider.getCityId();
        }
        return null;
    }

    public final boolean isLogin() {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        return loginServiceProvider != null && loginServiceProvider.isLogin();
    }

    public final String getCountryCode() {
        LoginServiceProvider loginServiceProvider = this.f21247a;
        if (loginServiceProvider != null) {
            return loginServiceProvider.getCountryCode();
        }
        return null;
    }

    private static final class Singleton {
        static final LoginService INSTANCE = new LoginService();

        private Singleton() {
        }
    }
}
