package com.koushikdutta.async.util;

import java.util.Hashtable;

public class UntypedHashtable {

    /* renamed from: a */
    private Hashtable<String, Object> f55475a = new Hashtable<>();

    public void put(String str, Object obj) {
        this.f55475a.put(str, obj);
    }

    public void remove(String str) {
        this.f55475a.remove(str);
    }

    public <T> T get(String str, T t) {
        T t2 = get(str);
        return t2 == null ? t : t2;
    }

    public <T> T get(String str) {
        return this.f55475a.get(str);
    }
}
