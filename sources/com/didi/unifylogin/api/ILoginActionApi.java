package com.didi.unifylogin.api;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.didi.unifylogin.interceptor.LoginActionInterceptor;
import com.didi.unifylogin.listener.LoginListeners;
import java.util.Map;

public interface ILoginActionApi {
    void activeLogout(Context context, String str);

    void go2CancelOrDeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener);

    @Deprecated
    void go2CancellationAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener);

    void go2ChangePhone(Context context, LoginListeners.SetCellListener setCellListener);

    void go2ChangePhoneByID(Context context, String str, String str2, LoginListeners.SetCellListener setCellListener);

    void go2DeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener);

    void go2Login(Context context);

    void go2LoginByKey(Context context, String str);

    @Deprecated
    void go2LoginForResult(Activity activity, int i);

    @Deprecated
    void go2LoginForResult(Fragment fragment, int i);

    void go2ModifyEmail(Context context, LoginListeners.ModifyEmailListener modifyEmailListener);

    void go2ModifyPassword(Context context, LoginListeners.ModifyPasswordListener modifyPasswordListener);

    void go2SetThirdParty(Context context);

    void go2VerifyCode(Context context, String str, Map<String, Object> map, LoginListeners.VerifyCodeListener verifyCodeListener);

    @Deprecated
    void loginOut(Context context);

    @Deprecated
    void loginOut(Context context, String str);

    void passiveLogout(Context context, String str, String str2, String str3);

    void setInterceptor(LoginActionInterceptor loginActionInterceptor);
}
