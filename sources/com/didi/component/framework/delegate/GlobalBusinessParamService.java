package com.didi.component.framework.delegate;

import com.didi.app.delegate.IBusinessParamsService;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.common.util.AddressUtil;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "ride", value = {IBusinessParamsService.class})
public class GlobalBusinessParamService implements IBusinessParamsService {
    public int getProductId() {
        return Integer.parseInt(BusinessDataUtil.getProductId());
    }

    public String getTripCityId() {
        return AddressUtil.getTripCityId(NationTypeUtil.getNationComponentData());
    }

    public String getTripCountry() {
        return AddressUtil.getTripCountry(NationTypeUtil.getNationComponentData());
    }
}
