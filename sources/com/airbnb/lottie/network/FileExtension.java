package com.airbnb.lottie.network;

import com.airbnb.lottie.utils.Logger;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;

public enum FileExtension {
    JSON(".json"),
    ZIP(PmFileConstant.ZIP_SUFFIX);
    
    public final String extension;

    private FileExtension(String str) {
        this.extension = str;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    public String toString() {
        return this.extension;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        Logger.warning("Unable to find correct extension for " + str);
        return JSON;
    }
}
