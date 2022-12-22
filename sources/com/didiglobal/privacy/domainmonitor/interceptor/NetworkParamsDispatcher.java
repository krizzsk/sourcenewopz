package com.didiglobal.privacy.domainmonitor.interceptor;

import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.privacy.domainmonitor.model.NetworkParam;
import java.util.Iterator;

public class NetworkParamsDispatcher {

    /* renamed from: a */
    private static final ServiceLoader<INetworkParamsInterceptor> f50519a = ServiceLoader.load(INetworkParamsInterceptor.class);

    public static void onRequestFinished(NetworkParam networkParam) {
        if (!networkParam.isInvalid() && f50519a.get() != null) {
            Iterator<INetworkParamsInterceptor> it = f50519a.iterator();
            while (it.hasNext()) {
                INetworkParamsInterceptor next = it.next();
                if (next != null) {
                    next.onRequestFinished(networkParam);
                }
            }
        }
    }
}
