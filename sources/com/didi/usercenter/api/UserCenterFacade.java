package com.didi.usercenter.api;

import android.content.Context;
import com.didi.sdk.util.TextUtil;
import com.didi.usercenter.entity.UserInfo;
import com.didi.usercenter.listener.UserInfoListener;
import com.didi.usercenter.net.UserInfoApi;
import com.didi.usercenter.store.UserCenterStore;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class UserCenterFacade implements IUserCenterFacade {

    /* renamed from: a */
    private static IUserCenterFacade f45132a = new UserCenterFacade();

    public static IUserCenterFacade getIns() {
        return f45132a;
    }

    public UserInfo getUserInfo(Context context) {
        return UserCenterStore.getIns().getUserInfo(context);
    }

    public com.didi.one.login.model.UserInfo getOldUserInfo(Context context) {
        return UserCenterStore.getIns().getOldUserInfo(context);
    }

    public void fetchUserInfo(Context context, String str, String str2, RpcService.Callback<UserInfo> callback) {
        if (context == null || TextUtil.isEmpty(str)) {
            callback.onFailure(new IOException());
        } else {
            UserInfoApi.fetchUserInfo(context, str, str2, callback);
        }
    }

    public void clearUserInfo(Context context) {
        UserCenterStore.getIns().clearUserInfo(context);
    }

    public void setUserInfo(Context context, UserInfo userInfo) {
        if (userInfo != null) {
            UserCenterStore.getIns().setUserInfo(context, userInfo);
        }
    }

    public void addInfoListener(UserInfoListener.InfoListener infoListener) {
        UserInfoListener.addInfoListener(infoListener);
    }

    public void removeListener(UserInfoListener.InfoListener infoListener) {
        UserInfoListener.removeListener(infoListener);
    }

    public void setTest(boolean z) {
        UserInfoApi.ISTEST = z;
    }

    public void setOnlineUrl(String str) {
        UserInfoApi.setOnlineUrl(str);
    }

    public void setTestUrl(String str) {
        UserInfoApi.setTestUrl(str);
    }
}
