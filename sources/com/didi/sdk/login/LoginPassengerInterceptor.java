package com.didi.sdk.login;

import android.app.Activity;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class LoginPassengerInterceptor implements LoginListeners.LoginInterceptor {
    public void onInterceptor(String str, Activity activity, LoginListeners.InterceptorCallback interceptorCallback) {
        updateUserInfo(str, activity, interceptorCallback);
    }

    private void updateUserInfo(String str, Activity activity, final LoginListeners.InterceptorCallback interceptorCallback) {
        UserCenterFacade.getIns().fetchUserInfo(activity.getApplicationContext(), str, NationTypeUtil.getNationComponentData().getGLang(), new RpcService.Callback<UserInfo>() {
            public void onSuccess(UserInfo userInfo) {
                interceptorCallback.onSuccess();
            }

            public void onFailure(IOException iOException) {
                interceptorCallback.onSuccess();
            }
        });
    }
}
