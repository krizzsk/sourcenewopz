package com.didi.component.business.util;

import com.didi.component.business.model.HomeCardModel;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.RpcPoi;

public class SendOrderUtils {
    public static Address getEndAddress(HomeCardModel homeCardModel) {
        RpcPoi rpcPoi = new RpcPoi();
        rpcPoi.base_info = homeCardModel.base_info;
        return ModelConverter.convertToAddress(rpcPoi);
    }
}
