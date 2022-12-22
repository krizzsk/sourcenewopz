package com.didichuxing.afanty.common.utils;

import android.content.Context;
import java.io.File;

public class CacheFileUtil {

    /* renamed from: a */
    private static File f45568a;

    public static void init(Context context) {
        if (context != null) {
            File file = new File(context.getCacheDir(), "feedback");
            f45568a = file;
            createDir(file);
        }
    }

    public static File getCacheFile() {
        return f45568a;
    }

    public static void createDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
