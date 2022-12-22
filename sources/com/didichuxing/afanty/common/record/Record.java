package com.didichuxing.afanty.common.record;

import com.didichuxing.afanty.common.utils.JsonUtil;
import java.util.HashMap;
import java.util.Map;

public class Record {

    /* renamed from: a */
    final Map<String, Object> f45567a = new HashMap();

    public void put(String str, Object obj) {
        this.f45567a.put(str, obj);
    }

    public Object get(String str) {
        return this.f45567a.get(str);
    }

    public String getRecordId() {
        return (String) get("rid");
    }

    /* access modifiers changed from: package-private */
    public String toJson() {
        return JsonUtil.map2Json(this.f45567a);
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.f45567a);
        return hashMap;
    }

    public void fromRecord(Record record) {
        this.f45567a.putAll(record.toMap());
    }

    public String toString() {
        return toJson();
    }
}
