package com.didi.unifylogin.api;

import android.content.Context;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.utils.phone.PhoneUtils;

public class LoginTextAdapter {
    private FragmentMessenger messenger;

    public DialogText getResPwdWarnDialog(Context context) {
        return null;
    }

    public String getSetPwdSubTitle(Context context) {
        return null;
    }

    public String getInputPhoneSubTitle(Context context) {
        return LoginThirdApi.m31713b();
    }

    public String getThirdPartyTitlebar(Context context) {
        return LoginThirdApi.m31714c();
    }

    public String getInputNewPhoneTitle(Context context) {
        return LoginThirdApi.m31715d();
    }

    public String getInputNewPhoneSubTitle(Context context) {
        return LoginThirdApi.m31716e();
    }

    public String getInputCodeTitle(Context context) {
        return LoginThirdApi.m31717f();
    }

    public String getInputNewPhoneTel(Context context) {
        return LoginThirdApi.m31711a();
    }

    public static class DialogText {
        public String msg;
        public String negativeBtnTxt;
        public String positiveBtnTxt;
        public String title;

        public DialogText(String str, String str2, String str3, String str4) {
            this.title = str;
            this.msg = str2;
            this.positiveBtnTxt = str3;
            this.negativeBtnTxt = str4;
        }
    }

    public final void setMessage(FragmentMessenger fragmentMessenger) {
        this.messenger = fragmentMessenger;
    }

    /* access modifiers changed from: protected */
    public final String getCell() {
        return this.messenger.getCell();
    }

    /* access modifiers changed from: protected */
    public final String getHideCell() {
        return PhoneUtils.hideMiddleDigital(this.messenger.getCell());
    }
}
