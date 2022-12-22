package com.didiglobal.domainprocessor;

import java.util.HashMap;
import java.util.Map;

public class DomainDataContainer {

    /* renamed from: a */
    private Map<String, Object> f50021a = new HashMap();

    private DomainDataContainer() {
    }

    public synchronized void putObj(String str, Object obj) {
        this.f50021a.put(str, obj);
    }

    public synchronized Object getObj(String str) {
        if (!this.f50021a.containsKey(str)) {
            return null;
        }
        return this.f50021a.get(str);
    }

    public synchronized <T> void putData(String str, T t) {
        this.f50021a.put(str, t);
    }

    public synchronized String getStringData(String str) {
        if (this.f50021a.containsKey(str)) {
            Object obj = this.f50021a.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    public synchronized boolean getBooleanData(String str) {
        if (this.f50021a.containsKey(str)) {
            Object obj = this.f50021a.get(str);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        return false;
    }
}
