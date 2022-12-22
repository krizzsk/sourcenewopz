package com.didiglobal.common.common.xengine;

import java.util.HashMap;

public class XERequestRecord {

    /* renamed from: a */
    private static final XERequestRecord f49744a = new XERequestRecord();

    /* renamed from: b */
    private HashMap<String, Integer> f49745b = new HashMap<>();

    private XERequestRecord() {
    }

    public static XERequestRecord getInstance() {
        return f49744a;
    }

    public void countIncrease(String str) {
        int i = 1;
        if (this.f49745b.containsKey(str)) {
            i = 1 + this.f49745b.get(str).intValue();
        }
        this.f49745b.put(str, Integer.valueOf(i));
    }

    public boolean hasRecord(String str) {
        return this.f49745b.containsKey(str);
    }

    public int getRecordCount(String str) {
        if (this.f49745b.containsKey(str)) {
            return this.f49745b.get(str).intValue();
        }
        return 0;
    }

    public void clean() {
        this.f49745b.clear();
    }
}
