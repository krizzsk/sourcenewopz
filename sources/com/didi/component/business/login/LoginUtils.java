package com.didi.component.business.login;

import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.login.ILoginInterface;

@ServiceProvider({ILoginInterface.class})
public class LoginUtils implements ILoginInterface {
    public void trackEvent(String str) {
        GlobalOmegaUtils.trackEvent(str);
    }

    public int getPosition() {
        return "ja-JP".equals(MultiLocaleStore.getInstance().getLocaleCode()) ? 1 : 0;
    }
}
