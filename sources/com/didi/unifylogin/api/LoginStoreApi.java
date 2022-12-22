package com.didi.unifylogin.api;

import android.text.TextUtils;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.store.LoginStore;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider({ILoginStoreApi.class})
public class LoginStoreApi implements ILoginStoreApi {
    public boolean isLoginNow() {
        return !TextUtils.isEmpty(LoginStore.getInstance().getToken()) && LoginStore.getInstance().getUid() > 0;
    }

    public String getPhone() {
        if (isLoginNow()) {
            return LoginStore.getInstance().getPhone();
        }
        return null;
    }

    public String getGlobalPhone() {
        if (!isLoginNow()) {
            return null;
        }
        return getCountryCode() + getPhone();
    }

    public void setPhone(String str) {
        LoginStore.getInstance().setAndSavePhone(str);
    }

    public String getCountryCode() {
        if (isLoginNow()) {
            return CountryManager.getIns().getCurrentCountryCode();
        }
        return null;
    }

    public String getAreaCode() {
        if (isLoginNow()) {
            return CountryManager.getIns().getAreaCode();
        }
        return null;
    }

    public String getToken() {
        return LoginStore.getInstance().getToken();
    }

    public String getTemporaryToken() {
        return LoginStore.getInstance().getTemporaryToken();
    }

    public String getUid() {
        return String.valueOf(LoginStore.getInstance().getUid());
    }

    public long getLongUid() {
        return LoginStore.getInstance().getUid();
    }

    public boolean isNewUser() {
        return LoginStore.getInstance().getUserType() == 1;
    }

    public int getRole() {
        return LoginStore.getInstance().getRole();
    }

    public boolean isDoubleIdentity() {
        return LoginStore.getInstance().isDoubleId();
    }

    public String getHideEmail() {
        return LoginStore.getInstance().getHideEmail();
    }

    public void dataMigration(String str, String str2, long j, int i) {
        LoginStore.getInstance().dataMigration(str, str2, j, i);
    }

    public String getPlaintTextEmail() {
        return LoginStore.getInstance().getPlainTextEmail();
    }
}
