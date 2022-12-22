package com.didi.unifylogin.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.entrance.CancelActivity;
import com.didi.unifylogin.entrance.DeleteAccountActivity;
import com.didi.unifylogin.entrance.OneLoginActivity;
import com.didi.unifylogin.entrance.SetEmailActivity;
import com.didi.unifylogin.entrance.SetPhoneActivity;
import com.didi.unifylogin.entrance.SetPwdActivity;
import com.didi.unifylogin.entrance.ThirdPartySetActivity;
import com.didi.unifylogin.entrance.VerifyCodeActivity;
import com.didi.unifylogin.externalfunction.LogoutManager;
import com.didi.unifylogin.interceptor.LoginActionInterceptor;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.third.LoginTypeManager;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Map;

@ServiceProvider({ILoginActionApi.class})
public class LoginActionApi implements ILoginActionApi {
    public static String loginReason = "mainProgressBlock";

    /* renamed from: a */
    private LoginActionInterceptor f44620a = new LoginActionInterceptor();

    public void loginOut(Context context) {
        new LogoutManager(context, "").activeLogout();
    }

    public void loginOut(Context context, String str) {
        new LogoutManager(context, str).activeLogout();
    }

    public void activeLogout(Context context, String str) {
        new LogoutManager(context, str).activeLogout();
    }

    public void passiveLogout(Context context, String str, String str2, String str3) {
        new LogoutManager(context, str).passiveLogout(str2, str3);
    }

    public void go2Login(Context context) {
        LoginTypeManager.INSTANCE.refreshLoginType(context.getApplicationContext());
        if (!this.f44620a.go2Login(context)) {
            m31702a(context, OneLoginActivity.class);
        }
    }

    public void go2LoginForResult(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, OneLoginActivity.class), i);
    }

    public void go2LoginForResult(Fragment fragment, int i) {
        fragment.startActivityForResult(new Intent(fragment.getActivity(), OneLoginActivity.class), i);
    }

    public void go2ModifyPassword(Context context, LoginListeners.ModifyPasswordListener modifyPasswordListener) {
        m31702a(context, SetPwdActivity.class);
        ListenerManager.setModifyPasswordListener(modifyPasswordListener);
    }

    @Deprecated
    public void go2CancellationAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        m31702a(context, CancelActivity.class);
        ListenerManager.setCAFinishListener(cancelAccFinishListener);
    }

    public void go2ChangePhoneByID(Context context, String str, String str2, LoginListeners.SetCellListener setCellListener) {
        Intent intent = new Intent(context, SetPhoneActivity.class);
        intent.putExtra(AbsLoginBaseActivity.EXTRA_PARAM_ID_NUM, str2);
        intent.putExtra(AbsLoginBaseActivity.EXTRA_PARAM_SESSION_ID, str);
        intent.putExtra(AbsLoginBaseActivity.EXTRA_PARAM_IS_CHANGE_PHONE_BY_ID, true);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void go2DeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        m31702a(context, DeleteAccountActivity.class);
        ListenerManager.setCAFinishListener(cancelAccFinishListener);
    }

    public void go2CancelOrDeleteAccount(Context context, LoginListeners.CancelAccFinishListener cancelAccFinishListener) {
        go2DeleteAccount(context, cancelAccFinishListener);
    }

    public void go2ChangePhone(Context context, LoginListeners.SetCellListener setCellListener) {
        m31702a(context, SetPhoneActivity.class);
        ListenerManager.setSetCellListener(setCellListener);
    }

    public void go2SetThirdParty(Context context) {
        m31702a(context, ThirdPartySetActivity.class);
    }

    /* renamed from: a */
    private void m31702a(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void go2ModifyEmail(Context context, LoginListeners.ModifyEmailListener modifyEmailListener) {
        Intent intent = new Intent(context, SetEmailActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        if (modifyEmailListener != null) {
            ListenerManager.setModifyEmailListener(modifyEmailListener);
        }
    }

    public void go2VerifyCode(Context context, String str, Map<String, Object> map, LoginListeners.VerifyCodeListener verifyCodeListener) {
        ListenerManager.setVerifyCodeListener(verifyCodeListener);
        LoginThirdApi.m31712a(str);
        Intent intent = new Intent(context, VerifyCodeActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        LoginOmegaUtil.setOmegaMap(map);
        context.startActivity(intent);
    }

    public void setInterceptor(LoginActionInterceptor loginActionInterceptor) {
        this.f44620a = loginActionInterceptor;
    }

    public void go2LoginByKey(Context context, String str) {
        Intent intent = new Intent(context, OneLoginActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra(OneLoginActivity.REG_BY_KEY, str);
        context.startActivity(intent);
    }
}
