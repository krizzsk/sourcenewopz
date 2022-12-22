package com.didi.foundation.sdk.application.ability;

import android.app.Application;
import android.content.Context;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.foundation.sdk.utils.LogUtils;
import com.didi.security.wireless.adapter.ISecurityInfo;
import com.didi.security.wireless.adapter.SecurityWrapper;

public final class NetSecurityAbility {
    private NetSecurityAbility() {
    }

    public static void init(Application application) {
        try {
            SecurityWrapper.doInit((Context) application, (ISecurityInfo) new ISecurityInfo() {
                public String getPhone() {
                    return AccountService.getInstance().getPhone();
                }

                public String getUid() {
                    return AccountService.getInstance().getUid();
                }

                public String getTicket() {
                    return AccountService.getInstance().getToken();
                }

                public void onInit(int i) {
                    LogUtils logUtils = LogUtils.INSTANCE;
                    logUtils.mo63518d("Security SDK init code " + i);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
