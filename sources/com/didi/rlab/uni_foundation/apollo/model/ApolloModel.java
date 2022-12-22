package com.didi.rlab.uni_foundation.apollo.model;

import com.didi.rlab.uni_foundation.uniapi.UniModel;
import java.util.HashMap;
import java.util.Map;

public class ApolloModel extends UniModel {

    /* renamed from: a */
    private boolean f34016a;

    /* renamed from: b */
    private Map<String, Object> f34017b;

    public boolean getEnable() {
        return this.f34016a;
    }

    public void setEnable(boolean z) {
        this.f34016a = z;
    }

    public Map<String, Object> getData() {
        return this.f34017b;
    }

    public void setData(Map<String, Object> map) {
        this.f34017b = map;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("enable", Boolean.valueOf(this.f34016a));
        hashMap.put("data", this.f34017b);
        return hashMap;
    }

    public static ApolloModel fromMap(Map<String, Object> map) {
        ApolloModel apolloModel = new ApolloModel();
        apolloModel.f34016a = (!map.containsKey("enable") || map.get("enable") == null) ? false : ((Boolean) map.get("enable")).booleanValue();
        apolloModel.f34017b = (!map.containsKey("data") || map.get("data") == null) ? new HashMap<>() : (Map) map.get("data");
        return apolloModel;
    }
}
