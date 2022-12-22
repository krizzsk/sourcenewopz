package com.didi.entrega.customer.flutter.service;

import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;
import com.didi.entrega.uni_entrega_business.login.GLEUniLoginService;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/customer/flutter/service/LoginServiceImp;", "Lcom/didi/entrega/uni_entrega_business/login/GLEUniLoginService;", "()V", "isLogin", "", "result", "Lcom/didi/entrega/uni_entrega_business/login/GLEUniLoginService$Result;", "", "login", "type", "", "logout", "signReasonByErrorCode", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LoginServiceImp.kt */
public final class LoginServiceImp implements GLEUniLoginService {
    public void isLogin(GLEUniLoginService.Result<Boolean> result) {
        if (result != null) {
            result.success(Boolean.valueOf(LoginUtil.isLogin()));
        }
    }

    public void logout(String str) {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).logOut(GlobalContext.getContext(), str);
    }

    public void login(long j) {
        LoginUtil.loginActivityAndTrack(GlobalContext.getContext(), (int) j);
    }
}
