package com.didi.hawaii.log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogConstant {
    public static final String LOG_ENCRYPT_SUFFIX = "_encrypt";
    public static final String LOG_ROOT = (File.separator + "hawaii_log");
    public static final String LOG_ROOT_BAMAI = (File.separator + ".WL");

    private LogConstant() {
    }

    public static String getFileName() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date(System.currentTimeMillis()));
    }
}
