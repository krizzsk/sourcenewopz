package com.didi.component.business.web;

import android.text.TextUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.net.ICommonBusinessParamInterceptor;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;

@ServiceProvider({ICommonBusinessParamInterceptor.class})
public class GlobalWebParamInterceptor implements ICommonBusinessParamInterceptor {

    /* renamed from: a */
    private HashMap<String, Object> f11404a = new HashMap<>(5);

    public HashMap<String, Object> getParams() {
        this.f11404a.clear();
        if (CarOrderHelper.getOrder() == null) {
            return null;
        }
        String str = CarOrderHelper.getOrder().tripCountry;
        if (!TextUtils.isEmpty(str)) {
            this.f11404a.put("trip_country", str);
        }
        Address address = CarOrderHelper.getOrder().startAddress;
        if (address != null && address.cityId > 0) {
            this.f11404a.put("trip_cityid", Integer.valueOf(address.cityId));
        }
        this.f11404a.put("serviceVersion", "V2");
        return this.f11404a;
    }
}
