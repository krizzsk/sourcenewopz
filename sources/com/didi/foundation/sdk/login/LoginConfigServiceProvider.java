package com.didi.foundation.sdk.login;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;

@ServiceProviderInterface
public interface LoginConfigServiceProvider {
    LoginConfig getLoginConfiguration();

    LoginParams getLoginParams();

    ThirdLoginClientIds getThirdLoginClientIds();
}
