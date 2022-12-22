package com.didi.payment.base.logger;

import java.util.HashMap;

public interface IPayLogger {
    void debugEvent(String str, HashMap<String, Object> hashMap);

    void errorEvent(String str, HashMap<String, Object> hashMap);

    void infoEvent(String str, HashMap<String, Object> hashMap);

    void setLogType(int i);

    void traceEvent(String str, HashMap<String, Object> hashMap);

    void warnEvent(String str, HashMap<String, Object> hashMap);
}
