package com.didi.soda.jadux;

import java.util.HashMap;
import java.util.List;

public class ConbineReducers {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Reducer<HashMap<Integer, Object>> mo108290a(final List<Reducer> list) {
        return new Reducer<HashMap<Integer, Object>>() {
            public HashMap<Integer, Object> reduce(HashMap<Integer, Object> hashMap, Action action) {
                HashMap<Integer, Object> hashMap2 = new HashMap<>();
                for (Reducer reducer : list) {
                    int hashCode = reducer.hashCode();
                    hashMap2.put(Integer.valueOf(hashCode), reducer.reduce(hashMap.get(Integer.valueOf(hashCode)), action));
                }
                return hashMap2;
            }
        };
    }
}
