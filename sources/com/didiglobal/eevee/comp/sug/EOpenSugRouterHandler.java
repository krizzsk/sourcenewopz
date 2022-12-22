package com.didiglobal.eevee.comp.sug;

import com.didi.address.model.SugParams;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.common.common.event.BaseEventKeys;
import com.didiglobal.common.common.spi.AddressParamsGetter;
import com.didiglobal.common.common.util.RouterHandleUtil;

public class EOpenSugRouterHandler implements IRouterHandler {

    /* renamed from: a */
    private static final String f50066a = "enable_via_point";

    /* renamed from: b */
    private static final String f50067b = "address_type";

    public void handle(Request request, Result result) {
        boolean z = false;
        int intQueryParam = RouterHandleUtil.getIntQueryParam(request, f50066a, 0);
        int intQueryParam2 = RouterHandleUtil.getIntQueryParam(request, "address_type", 2);
        SugParams createAddressParam = createAddressParam();
        if (createAddressParam != null) {
            if (intQueryParam == 1) {
                z = true;
            }
            createAddressParam.enable_way_point = z;
            if (createAddressParam.addressParam != null) {
                createAddressParam.addressParam.addressType = intQueryParam2;
            }
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Sub.EVENT_EEVEE_OPEN_SUB, createAddressParam);
        }
    }

    /* access modifiers changed from: protected */
    public SugParams createAddressParam() {
        AddressParamsGetter addressParamsGetter = (AddressParamsGetter) ServiceLoader.load(AddressParamsGetter.class).get();
        if (addressParamsGetter != null) {
            return addressParamsGetter.getAddressParams();
        }
        return null;
    }
}
