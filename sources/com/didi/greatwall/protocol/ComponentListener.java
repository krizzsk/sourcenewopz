package com.didi.greatwall.protocol;

import org.json.JSONObject;

public interface ComponentListener {
    public static final int FAIL = 1;
    public static final int NEUTRAL = 3;
    public static final int REQUEST_ERROR = 4;
    public static final int STOP = 2;
    public static final int SUCCESS = 0;

    void onFinish(int i, JSONObject jSONObject);
}
