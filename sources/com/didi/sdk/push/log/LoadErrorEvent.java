package com.didi.sdk.push.log;

import java.util.HashMap;
import java.util.Map;

public class LoadErrorEvent extends LogEvent {
    private String error;
    private String soName;

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("pn", this.soName);
        hashMap.put("e", this.error);
        return hashMap;
    }

    public void setSoName(String str) {
        this.soName = str;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String getSoName() {
        return this.soName;
    }

    public String getError() {
        return this.error;
    }
}
