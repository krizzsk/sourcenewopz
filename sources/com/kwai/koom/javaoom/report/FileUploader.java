package com.kwai.koom.javaoom.report;

import java.io.File;

public interface FileUploader {

    /* renamed from: com.kwai.koom.javaoom.report.FileUploader$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$deleteWhenUploaded(FileUploader fileUploader) {
            return true;
        }
    }

    boolean deleteWhenUploaded();

    void upload(File file);
}
