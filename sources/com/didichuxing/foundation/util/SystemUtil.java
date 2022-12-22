package com.didichuxing.foundation.util;

import android.content.Context;
import android.provider.Settings;
import java.io.File;

public abstract class SystemUtil {
    public static final long getLastModified() {
        return new File("/system/build.prop").lastModified();
    }

    public static final String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    private SystemUtil() {
    }
}
