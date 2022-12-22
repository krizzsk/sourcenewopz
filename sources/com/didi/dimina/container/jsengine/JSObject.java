package com.didi.dimina.container.jsengine;

import org.json.JSONObject;

public interface JSObject {
    Object get(String str);

    JSArray getArray(String str);

    Boolean getBoolean(String str);

    Double getDouble(String str);

    Integer getInteger(String str);

    String[] getKeys();

    JSObject getObject(String str);

    String getString(String str);

    void release();

    JSONObject toJSONObject();

    String toJSONString();
}
