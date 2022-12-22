package com.didi.soda.home.topgun.manager;

import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import java.util.HashMap;
import java.util.Map;

public class HomeBusinessPool {

    /* renamed from: a */
    private static HomeBusinessPool f42975a = new HomeBusinessPool();

    /* renamed from: b */
    private Map<String, BusinessInfoEntity> f42976b = new HashMap();

    public static HomeBusinessPool getPool() {
        return f42975a;
    }

    public BusinessInfoEntity getBusiness(String str) {
        return this.f42976b.get(str);
    }

    public BusinessInfoEntity putBusiness(String str, BusinessInfoEntity businessInfoEntity) {
        return this.f42976b.put(str, businessInfoEntity);
    }

    public void clearBusiness() {
        this.f42976b.clear();
    }
}
