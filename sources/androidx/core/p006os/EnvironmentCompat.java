package androidx.core.p006os;

import android.os.Build;
import android.os.Environment;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.io.IOException;

/* renamed from: androidx.core.os.EnvironmentCompat */
public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File file) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Environment.getExternalStorageState(file);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return Environment.getStorageState(file);
        }
        try {
            if (file.getCanonicalPath().startsWith(SystemUtils.getExternalStorageDirectory().getCanonicalPath())) {
                return Environment.getExternalStorageState();
            }
            return "unknown";
        } catch (IOException e) {
            SystemUtils.log(5, TAG, "Failed to resolve canonical path: " + e, (Throwable) null, "androidx.core.os.EnvironmentCompat", 75);
            return "unknown";
        }
    }

    private EnvironmentCompat() {
    }
}
