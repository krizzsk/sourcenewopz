package com.didichuxing.dfbasesdk;

import java.util.Map;
import org.json.JSONObject;

public interface ILogReporter {
    public static final String EVENT_ID_SERIOUS_ERROR_LOG = "-911";

    void enter();

    void exit();

    void report(String str);

    void report(String str, Map<String, Object> map);

    void report(String str, Map<String, Object> map, Map<String, Object> map2);

    void report(String str, JSONObject jSONObject, JSONObject jSONObject2);

    void reportEventWithCode(String str, int i);

    void setSessionId(String str);
}
