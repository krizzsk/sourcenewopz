package com.didi.component.framework.delegate;

import com.didi.app.delegate.IBusinessParamsService;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.util.AddressUtil;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "bus", value = {IBusinessParamsService.class})
public class BusBusinessParamService implements IBusinessParamsService {
    public int getProductId() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.productid <= 0) {
            return FormStore.getInstance().Bid;
        }
        return order.productid;
    }

    public String getTripCityId() {
        return AddressUtil.getTripCityId(NationTypeUtil.getNationComponentData());
    }

    public String getTripCountry() {
        return AddressUtil.getTripCountry(NationTypeUtil.getNationComponentData());
    }
}
