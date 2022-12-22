package com.didi.sdk.logging;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLogger implements Logger {
    protected Class<?> mClass;
    protected String mName;

    public AbstractLogger(String str) {
        this((Class<?>) null, str);
    }

    public AbstractLogger(Class<?> cls) {
        this(cls, cls.getName());
    }

    public AbstractLogger(Class<?> cls, String str) {
        this.mName = str;
        this.mClass = cls;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        if (str != null && str.length() != 0) {
            this.mName = str;
        }
    }

    protected static Map<?, ?> toMap(Object... objArr) {
        if (objArr == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < objArr.length - 1; i += 2) {
            hashMap.put(objArr[i], objArr[i + 1]);
        }
        return hashMap;
    }

    protected static Map<?, ?> mapCopy(Map<?, ?> map) {
        if (map == null) {
            return null;
        }
        return new HashMap(map);
    }
}
