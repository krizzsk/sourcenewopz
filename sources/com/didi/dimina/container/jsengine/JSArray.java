package com.didi.dimina.container.jsengine;

import org.json.JSONArray;

public interface JSArray {
    Object get(int i);

    JSArray getArray(int i);

    Boolean getBoolean(int i);

    Double getDouble(int i);

    Integer getInteger(int i);

    JSObject getObject(int i);

    String getString(int i);

    int length();

    void release();

    JSONArray toJSONArray();

    String toJSONString();
}
