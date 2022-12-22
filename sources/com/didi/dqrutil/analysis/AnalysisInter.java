package com.didi.dqrutil.analysis;

import java.util.Map;

public interface AnalysisInter {
    void report(String str);

    void report(String str, Map<String, Object> map);

    void reportSingle(String str, String str2, String str3);
}
