package com.didi.unifylogin.utils;

import android.content.Context;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.taxis99.R;

public class ToastHelper {
    public static void showAgreeLawHint(Context context, ILoginBaseFragment iLoginBaseFragment) {
        String string = context.getString(R.string.login_unify_need_check_law, new Object[]{LoginPreferredConfig.getLawHint()});
        if (string != null) {
            iLoginBaseFragment.showError(string.replace("《", "").replace("》", ""));
        } else {
            iLoginBaseFragment.showError(context.getString(R.string.login_unify_need_check_law, new Object[]{LoginPreferredConfig.getLawHint()}));
        }
        LoginLog.write("LoginPhonePresenter lawCheckbox is not selected");
        new LoginOmegaUtil(LoginOmegaUtil.LAW_CONFM_SW).send();
    }
}
