package com.didichuxing.mas.sdk.quality.report.record;

import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector;

public class DartErrorRecord extends ChanceRecord {
    public void takeLogcatWithErrorCheck(String str) {
        if (str == null) {
            takeLogcat();
        } else {
            putLogcat(LogcatCollector.getLogcat(MASConfig.LOGCAT_TAIL_MAX_COUNT, str).getBuffer().getBytes());
        }
    }
}
