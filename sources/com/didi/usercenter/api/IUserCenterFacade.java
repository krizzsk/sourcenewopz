package com.didi.usercenter.api;

import android.content.Context;
import com.didi.usercenter.entity.UserInfo;
import com.didi.usercenter.listener.UserInfoListener;
import com.didichuxing.foundation.rpc.RpcService;

public interface IUserCenterFacade {
    void addInfoListener(UserInfoListener.InfoListener infoListener);

    void clearUserInfo(Context context);

    void fetchUserInfo(Context context, String str, String str2, RpcService.Callback<UserInfo> callback);

    com.didi.one.login.model.UserInfo getOldUserInfo(Context context);

    UserInfo getUserInfo(Context context);

    void removeListener(UserInfoListener.InfoListener infoListener);

    void setOnlineUrl(String str);

    void setTest(boolean z);

    void setTestUrl(String str);

    void setUserInfo(Context context, UserInfo userInfo);
}
