package com.didi.entrega.customer.timemachine;

import com.didi.entrega.customer.app.CustomerPageManager;
import com.didi.entrega.customer.foundation.rpc.ApiUrlFactory;
import java.util.ArrayList;
import java.util.List;

public class CustomerTimeMachineConfig implements TimeMachineConfig {
    public List<String> traceDomainList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ApiUrlFactory.CUSTOMER_API_HTTPS_ONLINE);
        return arrayList;
    }

    public String getCurrentPage() {
        return CustomerPageManager.getInstance().getCurrentPageName();
    }
}
