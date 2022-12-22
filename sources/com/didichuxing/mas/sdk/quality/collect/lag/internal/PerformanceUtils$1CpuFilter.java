package com.didichuxing.mas.sdk.quality.collect.lag.internal;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class PerformanceUtils$1CpuFilter implements FileFilter {
    PerformanceUtils$1CpuFilter() {
    }

    public boolean accept(File file) {
        return Pattern.matches("cpu[0-9]", file.getName());
    }
}
