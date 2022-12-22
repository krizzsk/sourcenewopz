package com.didichuxing.dfbasesdk.logupload2;

import java.util.LinkedHashMap;

public class LogHashMap<K, V> {

    /* renamed from: a */
    private final LinkedHashMap<K, V> f46634a;

    /* renamed from: b */
    private int f46635b;

    /* renamed from: c */
    private int f46636c;

    public LogHashMap() {
        this.f46635b = 5;
        this.f46634a = new LinkedHashMap<>();
    }

    public LogHashMap(int i) {
        this.f46635b = 5;
        if (i > 0) {
            this.f46635b = i;
            this.f46634a = new LinkedHashMap<>();
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final void put(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        this.f46634a.put(k, v);
    }

    public int getSize() {
        return this.f46636c;
    }

    public boolean isFull() {
        return this.f46634a.size() >= this.f46635b;
    }
}
