package com.didi.unifylogin.api;

import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.taxis99.R;
import java.util.List;
import java.util.Map;

@ServiceProvider({ILoginConfigApi.class})
public class LoginConfigApi implements ILoginConfigApi {
    public static final int GRAY_BUTTON = 0;
    public static final int ORANGE_BUTTON = 1;
    public static final int ORANGE_GRADUAL_BUTTON = 2;

    public void setLawUrl(String str) {
        if (!TextUtil.isEmpty(str)) {
            LoginPreferredConfig.setLawUrl(str);
        }
    }

    public void setLawHint(String str) {
        LoginPreferredConfig.setLawHint(str);
    }

    public void setCanSwitchCountry(boolean z) {
        LoginPreferredConfig.setCanSwitchCountry(z);
    }

    public void setButtonStyle(int i) {
        if (i <= -1) {
            return;
        }
        if (i == 1) {
            setTheme(R.style.LoginStyleOrange);
        } else if (i != 2) {
            setTheme(R.style.OneLoginStyle);
        } else {
            setTheme(R.style.LoginStyleGeradualOrange);
        }
    }

    public void setHomeCanBack(boolean z) {
        LoginPreferredConfig.setHomeCanBacke(z);
    }

    public void setSupportJump(boolean z) {
        LoginPreferredConfig.setSupportJump(z);
    }

    public void setNeedPrePage(boolean z) {
        LoginPreferredConfig.setNeedPrePage(z);
    }

    public void setDefLawSelected(boolean z) {
        LoginPreferredConfig.setDefLawSelected(z);
    }

    public void setIsLawCbUseCache(boolean z) {
        LoginPreferredConfig.setIsLawCbUseCache(z);
    }

    public void setIsShowChangePhoneEntrance(boolean z) {
        LoginPreferredConfig.setIsShowChangePhoneByIDEntrance(z);
    }

    public void setAutoFullCode(boolean z) {
        LoginPreferredConfig.setAutoFullCode(z);
    }

    public void setActivityDelegate(LoginListeners.LoginBaseActivityDelegate loginBaseActivityDelegate) {
        ListenerManager.setActivityDelegate(loginBaseActivityDelegate);
    }

    public void setGuidePermissions(LoginListeners.GuidePermissionsDelegate guidePermissionsDelegate) {
        ListenerManager.setGuidePermissionsDelegate(guidePermissionsDelegate);
    }

    public void setTheme(int i) {
        LoginPreferredConfig.setThemeResInt(i);
    }

    public void isUnifyPwd(boolean z) {
        LoginPreferredConfig.setUnifyPwd(z);
    }

    public void setCancelDescribes(List<String> list) {
        LoginPreferredConfig.setCancelDescribes(list);
    }

    public void setOptLoginByCode(boolean z) {
        LoginPreferredConfig.setAllowOptLoginByCode(z);
    }

    public void setCloseRetrieve(boolean z) {
        LoginPreferredConfig.setCloseRetrieve(z);
    }

    public void addOmegaMap(Map<String, Object> map) {
        if (map != null) {
            LoginOmegaUtil.addOmegaMap(map);
        }
    }

    public void setExchangeNamePosition(boolean z) {
        LoginPreferredConfig.setExchangeNamePosition(z);
    }

    public void setUseWeakPwd(boolean z) {
        LoginPreferredConfig.setUseWeakPwd(z);
    }

    public void setCodeReducedTime(int i) {
        LoginPreferredConfig.setCodeReducedTime(i);
    }

    public void setDeleteAccountPageUseTextStyle(boolean z) {
        LoginPreferredConfig.setDeleteAccountPageUseTextStyle(z);
    }

    public void setUsePassengerUIStyle(boolean z) {
        LoginPreferredConfig.setUsePassengerUIStyle(z);
    }

    public void setShowEmailLoginEntrance(boolean z) {
        LoginPreferredConfig.setShowEmailLoginEntrance(z);
    }

    public void setOptionalEmail(boolean z) {
        LoginPreferredConfig.setOptionalEmail(z);
    }

    public void setNewUserCpfIntercept(boolean z) {
        LoginPreferredConfig.setNewUserCpfIntercept(z);
    }

    public void setDefCountryByOldId(int i) {
        LoginPreferredConfig.setDefCountryByOldId(i);
    }

    public static void setTextAdapter(LoginTextAdapter loginTextAdapter) {
        LoginPreferredConfig.setTextAdapter(loginTextAdapter);
    }

    public void setIsPasswordEncrypt(boolean z) {
        LoginPreferredConfig.setIsPasswordEncrypt(z);
    }
}
