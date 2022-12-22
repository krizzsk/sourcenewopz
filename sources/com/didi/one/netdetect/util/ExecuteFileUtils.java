package com.didi.one.netdetect.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class ExecuteFileUtils {
    public static boolean checkCmdFile(Context context, String str) {
        return !TextUtils.isEmpty(getCmdFilePath(context, str));
    }

    public static String getCmdFilePath(Context context, String str) {
        File file = new File(context.getApplicationInfo().nativeLibraryDir, "lib" + str + ".so");
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }
}
