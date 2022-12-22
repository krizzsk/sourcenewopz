package com.didichuxing.util;

import java.io.File;

public final class SystemUtil {
    public static final long getLastModified() {
        return new File("/system/build.prop").lastModified();
    }

    private SystemUtil() {
    }
}
