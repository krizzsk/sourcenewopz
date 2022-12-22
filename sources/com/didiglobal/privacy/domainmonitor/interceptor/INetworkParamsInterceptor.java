package com.didiglobal.privacy.domainmonitor.interceptor;

import com.didichuxing.foundation.spi.annotation.ServiceProviderInterface;
import com.didiglobal.privacy.domainmonitor.model.NetworkParam;

@ServiceProviderInterface
public interface INetworkParamsInterceptor {
    void onRequestFinished(NetworkParam networkParam);
}
