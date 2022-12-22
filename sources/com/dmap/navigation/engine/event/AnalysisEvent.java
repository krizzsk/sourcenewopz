package com.dmap.navigation.engine.event;

import com.dmap.navigation.jni.swig.AnalysisLog;
import com.dmap.navigation.jni.swig.AnalysisLogList;
import java.util.HashMap;
import java.util.Map;

public class AnalysisEvent extends NaviEvent {

    /* renamed from: a */
    private final String f51848a;

    /* renamed from: b */
    private final Map<String, Object> f51849b;

    public AnalysisEvent(String str, AnalysisLogList analysisLogList) {
        this.f51848a = str;
        int size = (int) analysisLogList.size();
        if (size > 0) {
            this.f51849b = new HashMap(size);
            for (int i = 0; i < size; i++) {
                AnalysisLog analysisLog = analysisLogList.get(i);
                this.f51849b.put(analysisLog.getKey(), analysisLog.getValue());
            }
            return;
        }
        this.f51849b = null;
    }

    public String toString() {
        return "AnalysisEvent{key='" + this.f51848a + '\'' + ", data=" + this.f51849b + '}';
    }

    public String getKey() {
        return this.f51848a;
    }

    public Map<String, Object> getData() {
        return this.f51849b;
    }
}
