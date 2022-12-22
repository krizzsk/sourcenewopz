package com.didi.sdk.util;

import com.didi.sdk.push.fcm.IOrderStatusParamsService;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Iterator;

public class OrderStatusParamsUtil {
    public static String getLocalOrderId() {
        IOrderStatusParamsService businessParamsService = getBusinessParamsService();
        return businessParamsService != null ? businessParamsService.getLocalOrderId() : "";
    }

    public static int getLocalStatus() {
        IOrderStatusParamsService businessParamsService = getBusinessParamsService();
        if (businessParamsService != null) {
            return businessParamsService.getLocalStatus();
        }
        return 0;
    }

    public static int getLocalSubStatus() {
        IOrderStatusParamsService businessParamsService = getBusinessParamsService();
        if (businessParamsService != null) {
            return businessParamsService.getLocalSubStatus();
        }
        return 0;
    }

    public static IOrderStatusParamsService getBusinessParamsService() {
        try {
            Iterator<S> it = ServiceLoader.load(IOrderStatusParamsService.class).iterator();
            while (it.hasNext()) {
                IOrderStatusParamsService iOrderStatusParamsService = (IOrderStatusParamsService) it.next();
                if (((ServiceProvider) iOrderStatusParamsService.getClass().getAnnotation(ServiceProvider.class)) != null) {
                    return iOrderStatusParamsService;
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
