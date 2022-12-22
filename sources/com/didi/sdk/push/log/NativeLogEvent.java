package com.didi.sdk.push.log;

import java.util.HashMap;
import java.util.Map;

public class NativeLogEvent extends LogEvent {
    private int level;
    private String msg;

    public void setLevel(int i) {
        this.level = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMsg() {
        return this.msg;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("level", Integer.valueOf(this.level));
        hashMap.put("msg", this.msg);
        return null;
    }
}
