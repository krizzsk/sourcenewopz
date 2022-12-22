package com.didi.payment.base.utils;

import java.util.Map;

public class MapParamWrapper {

    /* renamed from: a */
    private Map f30009a;

    public MapParamWrapper(Map map) {
        this.f30009a = map;
    }

    public void setParam(Map map) {
        this.f30009a = map;
    }

    public Map getParam() {
        return this.f30009a;
    }

    public double getDouble(String str, double d) {
        Object object = getObject(str);
        if (object == null) {
            return d;
        }
        if (object instanceof Number) {
            return ((Number) object).doubleValue();
        }
        if (!(object instanceof String)) {
            return d;
        }
        try {
            return Double.parseDouble((String) object);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public long getLong(String str, long j) {
        Object object = getObject(str);
        if (object == null) {
            return j;
        }
        if (object instanceof Number) {
            return ((Number) object).longValue();
        }
        if (!(object instanceof String)) {
            return j;
        }
        try {
            return (long) Double.parseDouble((String) object);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public int getInt(String str, int i) {
        return (int) getLong(str, (long) i);
    }

    public String getString(String str, String str2) {
        Object object = getObject(str);
        if (object == null) {
            return str2;
        }
        return object.toString();
    }

    public Map getMap(String str) {
        Object object = getObject(str);
        if (!(object instanceof Map)) {
            return null;
        }
        return (Map) object;
    }

    public boolean contains(String str) {
        Map map = this.f30009a;
        return (map == null || map.get(str) == null) ? false : true;
    }

    public Object getObject(String str) {
        Map map = this.f30009a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }
}
