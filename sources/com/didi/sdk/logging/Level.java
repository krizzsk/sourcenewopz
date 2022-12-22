package com.didi.sdk.logging;

import androidx.exifinterface.media.ExifInterface;

public enum Level {
    TRACE(2, "T"),
    DEBUG(3, "D"),
    INFO(4, "I"),
    WARN(5, ExifInterface.LONGITUDE_WEST),
    ERROR(6, ExifInterface.LONGITUDE_EAST);
    
    public final int level;
    public final String name;

    private Level(int i, String str) {
        this.level = i;
        this.name = str;
    }

    public static Level getLevel(int i) {
        if (i == 3) {
            return DEBUG;
        }
        if (i == 4) {
            return INFO;
        }
        if (i == 5) {
            return WARN;
        }
        if (i != 6) {
            return TRACE;
        }
        return ERROR;
    }
}
