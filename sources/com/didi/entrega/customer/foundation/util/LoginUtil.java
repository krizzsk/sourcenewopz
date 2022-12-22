package com.didi.entrega.customer.foundation.util;

import android.app.Activity;
import android.content.Context;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.foundation.login.LoginListener;
import com.didi.entrega.customer.foundation.rpc.entity.LoginModel;
import com.didi.entrega.customer.foundation.tracker.LoginOmegaHelper;
import com.didi.entrega.customer.repo.LoginRepo;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.map.global.component.slideCars.api.ICarNavigatorApi;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.base.net.LoginEnvironment;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;

public final class LoginUtil {
    private LoginUtil() {
    }

    public static String getPhone() {
        return LoginService.getInstance().getPhone();
    }

    public static String getLongConnectPhone() {
        if (GlobalContext.getBrand() != 2) {
            return LoginService.getInstance().getPhone();
        }
        return getCallingCode() + getPhone() + ICarNavigatorApi.PHONE_NUM_SUFFIX;
    }

    public static void go2CancelOrDeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        LoginService.getInstance().go2CancelOrDeleteAccount(context, cancelAccFinishListener);
    }

    public static String getEmail() {
        return OneLoginFacade.getStore().getHideEmail();
    }

    public static String getCallingCode() {
        return LoginService.getInstance().getCountryCode();
    }

    public static int getCountryId() {
        return LoginStore.getInstance().getCountryId();
    }

    public static String getToken() {
        return LoginService.getInstance().getToken();
    }

    public static String getUid() {
        return LoginService.getInstance().getUid();
    }

    public static void loginActivity(Context context) {
        loginActivityAndTrack(context, 0, (LoginListener) null);
    }

    public static void loginActivityAndTrack(Context context, int i) {
        loginActivityAndTrack(context, i, (LoginListener) null);
    }

    public static void loginActivityAndTrack(Context context, final int i, final LoginListener loginListener) {
        if (context != null) {
            LoginOmegaHelper.loginTrack(i);
            registerLoginListener(new LoginCallbacks.LoginListener() {
                public void onSuccess(Activity activity, String str) {
                    LoginOmegaHelper.loginCallbackTrack(i);
                    LoginListener loginListener = loginListener;
                    if (loginListener != null) {
                        loginListener.onSuccess(str);
                    }
                    LoginUtil.unRegisterLoginListener(this);
                }

                public void onCancel() {
                    LoginListener loginListener = loginListener;
                    if (loginListener != null) {
                        loginListener.onCancel();
                    }
                    LoginUtil.unRegisterLoginListener(this);
                }
            });
            if (GlobalContext.isEmbed()) {
                OneLoginFacade.getAction().go2Login(context);
            } else {
                LoginService.getInstance().go2Login(context);
            }
        }
    }

    public static void registerLoginOutListener(LoginCallbacks.LoginOutListener loginOutListener) {
        if (loginOutListener != null) {
            LoginService.getInstance().addLogoutListener(loginOutListener);
        }
    }

    public static void unRegisterLoginOutListener(LoginCallbacks.LoginOutListener loginOutListener) {
        LoginService.getInstance().removeLogoutListener(loginOutListener);
    }

    public static void registerLoginListener(LoginCallbacks.LoginListener loginListener) {
        if (loginListener != null) {
            LoginService.getInstance().addLoginListener(loginListener);
        }
    }

    public static void unRegisterLoginListener(LoginCallbacks.LoginListener loginListener) {
        LoginService.getInstance().removeLoginListener(loginListener);
    }

    public static boolean isLogin() {
        return LoginService.getInstance().isLogin();
    }

    public static void logOut(Context context) {
        LoginService.getInstance().logout(context);
    }

    public static void logOut(Context context, String str) {
        LoginService.getInstance().logout(context, str);
    }

    public static void go2ModifyPassword(Context context) {
        if (context != null) {
            LoginService.getInstance().go2ModifyPassword(context, (LoginCallbacks.ModifyPasswordListener) null);
        }
    }

    public static void go2ChangePhone(Context context, LoginCallbacks.SetCellListener setCellListener) {
        if (context != null) {
            LoginService.getInstance().go2ModifyPhone(context, setCellListener);
        }
    }

    public static void go2SetThirdParty(Context context) {
        if (context != null) {
            LoginService.getInstance().go2SetThirdParty(context);
        }
    }

    public static void go2ModifyEmail(Context context, LoginCallbacks.ModifyEmailListener modifyEmailListener) {
        if (context != null) {
            LoginService.getInstance().go2ModifyEmail(context, modifyEmailListener);
        }
    }

    public static boolean isNewUser() {
        return OneLoginFacade.getStore().isNewUser();
    }

    public static String getGlobalPhone() {
        return OneLoginFacade.getStore().getGlobalPhone();
    }

    public static LoginEnvironment getLoginMode() {
        return CustomerToolBoxUtil.getLoginMode();
    }

    public static boolean isNeedPopToRootStatus() {
        LoginModel value = ((LoginRepo) RepoFactory.getRepo(LoginRepo.class)).getValue();
        if (value == null) {
            return true;
        }
        return value.ismNeedPopToRoot();
    }

    public static void updateLoginPopToRootStatus(boolean z) {
        LoginRepo loginRepo = (LoginRepo) RepoFactory.getRepo(LoginRepo.class);
        LoginModel value = loginRepo.getValue();
        value.setNeedPopToRoot(z);
        loginRepo.setValue(value);
    }
}
