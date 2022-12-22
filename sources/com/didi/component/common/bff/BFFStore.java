package com.didi.component.common.bff;

import android.content.Context;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;

public class BFFStore {
    public static int getCarWanliuUserType(Context context) {
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(context);
        if (userInfo == null) {
            return -1;
        }
        return userInfo.getUserType();
    }
}
