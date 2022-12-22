package com.didichuxing.mas.sdk.quality.report.record;

import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import com.didichuxing.mas.sdk.quality.report.utils.JsonUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
    protected Map<String, Object> datamap = new HashMap();
    protected List<String> extraFiles = new ArrayList();

    public void fromJson(String str) {
    }

    public void put(String str, Object obj) {
        this.datamap.put(str, obj);
    }

    public void putAll(Map<String, Object> map) {
        if (map != null) {
            this.datamap.putAll(map);
        }
    }

    public Record add(String str, Object obj) {
        this.datamap.put(str, obj);
        return this;
    }

    public Record addIfNotEmpty(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            this.datamap.put(str, str2);
        }
        return this;
    }

    public Record addIfNotEmpty(String str, int i) {
        if (i != 0) {
            this.datamap.put(str, Integer.valueOf(i));
        }
        return this;
    }

    public Record addIfNotEmpty(String str, Object obj) {
        if (obj != null) {
            this.datamap.put(str, obj);
        }
        return this;
    }

    public Object get(String str) {
        return this.datamap.get(str);
    }

    public Long getSeq() {
        return Long.valueOf(CommonUtil.parseLong(get("seq")));
    }

    public String getRecordId() {
        return (String) get("rid");
    }

    public String toJson() {
        Object remove = this.datamap.remove("rid");
        String map2Json = JsonUtil.map2Json(this.datamap);
        if (remove != null) {
            this.datamap.put("rid", remove);
        }
        return map2Json;
    }

    public List<String> getExtraFiles() {
        return this.extraFiles;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.datamap);
        return hashMap;
    }

    public void fromMap(Map<String, Object> map) {
        this.datamap.putAll(map);
    }

    public void fromRecord(Record record) {
        this.datamap.putAll(record.toMap());
    }

    public String toString() {
        return toJson();
    }
}
