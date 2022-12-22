package com.didichuxing.mas.sdk.quality.report.utils;

public enum FileType {
    JAVA_CRASH(1),
    NATIVE_CRASH(2),
    ANR(3),
    CARTOON(4),
    OOM_CRASH(5),
    DART_EXCEPTION(6);
    
    private int type;

    private FileType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
