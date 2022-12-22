package com.didichuxing.mas.sdk.quality.report.record;

import com.didichuxing.mas.sdk.quality.report.collector.LogcatCollector;
import com.didichuxing.mas.sdk.quality.report.utils.FileType;

public class ANRRecord extends ChanceRecord {
    public ANRRecord() {
        put("lag", 1);
        setFileType(FileType.ANR);
    }

    public void setTraceFilename(String str) {
        addFile(str);
    }

    public void setAllThreadStack(String str) {
        put("at", str);
    }

    public void takeLogCatWithAnrReason() {
        putLogcat(LogcatCollector.getLogcatWithAnrReason(2500).getBytes());
    }
}
