package com.didi.sdk.app;

import java.io.File;
import java.io.FileFilter;

class OmegaServiceImpl$1 implements FileFilter {
    final /* synthetic */ C12016h this$0;

    OmegaServiceImpl$1(C12016h hVar) {
        this.this$0 = hVar;
    }

    public boolean accept(File file) {
        return file.isFile() && file.exists() && file.getName().matches("^logback\\-\\d{4}\\-\\d{2}\\-\\d{3,5}\\.log$") && file.length() > 0;
    }
}
