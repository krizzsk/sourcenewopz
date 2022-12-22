package com.didi.unifylogin.api;

import com.didi.unifylogin.listener.LoginListeners;
import java.util.List;
import java.util.Map;

public interface ILoginConfigApi {
    void addOmegaMap(Map<String, Object> map);

    void isUnifyPwd(boolean z);

    void setActivityDelegate(LoginListeners.LoginBaseActivityDelegate loginBaseActivityDelegate);

    void setAutoFullCode(boolean z);

    @Deprecated
    void setButtonStyle(int i);

    void setCanSwitchCountry(boolean z);

    void setCancelDescribes(List<String> list);

    void setCloseRetrieve(boolean z);

    void setCodeReducedTime(int i);

    void setDefCountryByOldId(int i);

    void setDefLawSelected(boolean z);

    void setDeleteAccountPageUseTextStyle(boolean z);

    void setExchangeNamePosition(boolean z);

    void setGuidePermissions(LoginListeners.GuidePermissionsDelegate guidePermissionsDelegate);

    void setHomeCanBack(boolean z);

    void setIsLawCbUseCache(boolean z);

    void setIsPasswordEncrypt(boolean z);

    void setIsShowChangePhoneEntrance(boolean z);

    void setLawHint(String str);

    void setLawUrl(String str);

    void setNeedPrePage(boolean z);

    void setNewUserCpfIntercept(boolean z);

    void setOptLoginByCode(boolean z);

    void setOptionalEmail(boolean z);

    void setShowEmailLoginEntrance(boolean z);

    void setSupportJump(boolean z);

    void setTheme(int i);

    void setUsePassengerUIStyle(boolean z);

    void setUseWeakPwd(boolean z);
}
