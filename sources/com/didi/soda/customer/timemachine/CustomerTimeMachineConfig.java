package com.didi.soda.customer.timemachine;

import com.didi.soda.customer.app.CustomerPageManager;
import java.util.ArrayList;
import java.util.List;

public class CustomerTimeMachineConfig implements TimeMachineConfig {
    public List<String> traceDomainList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("https://c.didi-food.com");
        return arrayList;
    }

    public String getCurrentPage() {
        return CustomerPageManager.getInstance().getCurrentPageName();
    }
}
