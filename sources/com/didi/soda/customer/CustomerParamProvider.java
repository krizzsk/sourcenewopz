package com.didi.soda.customer;

import com.didi.sdk.app.IParamProvider;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import java.util.HashMap;
import java.util.Map;

@ServiceProvider({IParamProvider.class})
public class CustomerParamProvider implements IParamProvider {
    public Map<String, String> getApolloParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("rlab_location_country", NationTypeUtil.getNationComponentData().getLocCountry());
        hashMap.put("rlab_county_id", String.valueOf(LocationUtil.getCountyId()));
        hashMap.put("rlab_county_group_id", String.valueOf(LocationUtil.getCountyGroupId()));
        hashMap.put("rlab_business_id", AppConst.BUSINESS_ID);
        return hashMap;
    }
}
