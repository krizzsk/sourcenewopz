package com.didi.sdk.util;

import com.didi.app.delegate.IBusinessParamsService;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationComponentData;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.Iterator;

public class BusinessParamsUtil {
    public static String getTripCountry(String str, NationComponentData nationComponentData) {
        IBusinessParamsService businessParamsService = getBusinessParamsService(str);
        if (businessParamsService != null) {
            return businessParamsService.getTripCountry();
        }
        if (nationComponentData == null) {
            return "0";
        }
        return nationComponentData.getLocCountry();
    }

    public static String getTripCityId(String str, NationComponentData nationComponentData) {
        IBusinessParamsService businessParamsService = getBusinessParamsService(str);
        if (businessParamsService != null) {
            return businessParamsService.getTripCityId();
        }
        if (nationComponentData == null) {
            return "0";
        }
        return nationComponentData.getCityId();
    }

    public static int getProductId(String str) {
        IBusinessParamsService businessParamsService = getBusinessParamsService(str);
        return businessParamsService == null ? ConfProxy.getInstance().getSelectedGroupId() : businessParamsService.getProductId();
    }

    public static IBusinessParamsService getBusinessParamsService(String str) {
        try {
            Iterator<S> it = ServiceLoader.load(IBusinessParamsService.class).iterator();
            while (it.hasNext()) {
                IBusinessParamsService iBusinessParamsService = (IBusinessParamsService) it.next();
                ServiceProvider serviceProvider = (ServiceProvider) iBusinessParamsService.getClass().getAnnotation(ServiceProvider.class);
                if (serviceProvider != null && str.equals(serviceProvider.alias())) {
                    return iBusinessParamsService;
                }
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
