package com.didi.unifylogin.base.api;

import com.didi.unifylogin.base.log.TraceLogBiz;
import com.didi.unifylogin.base.net.LoginUrlProvider;

public class LoginBaseFacade {
    private LoginBaseFacade() {
    }

    private static class ApiFacadeHolder {
        /* access modifiers changed from: private */
        public static final LoginBaseFacade singleton = new LoginBaseFacade();

        private ApiFacadeHolder() {
        }
    }

    public static LoginBaseFacade getInstance() {
        return ApiFacadeHolder.singleton;
    }

    public void initBaseSdk(LoginBaseParam loginBaseParam) {
        BaseListenerContainer.setNetParamListener(loginBaseParam.netParamListener);
        BaseListenerContainer.setLogListener(loginBaseParam.logListener);
        BaseListenerContainer.setNetModeListener(loginBaseParam.netModeListener);
        LoginUrlProvider.setIsGlobal(loginBaseParam.isGlobal);
        LoginUrlProvider.setIsRussia(loginBaseParam.isRussia);
        LoginUrlProvider.setUseCustomBaseUrl(loginBaseParam.useCustomBaseUrl);
        LoginUrlProvider.setCustomBaseUrl(loginBaseParam.customBaseUrl);
    }

    public void writeLog(String str) {
        TraceLogBiz.getInstance().addLogWithTab(str);
    }
}
