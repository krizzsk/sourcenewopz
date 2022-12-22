package p242io.flutter.util;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* renamed from: io.flutter.util.PathUtils */
public final class PathUtils {
    public static String getFilesDir(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(m41704a(context), "files");
        }
        return filesDir.getPath();
    }

    public static String getDataDirectory(Context context) {
        File dir = context.getDir("flutter", 0);
        if (dir == null) {
            dir = new File(m41704a(context), "app_flutter");
        }
        return dir.getPath();
    }

    public static String getCacheDirectory(Context context) {
        File file;
        if (Build.VERSION.SDK_INT >= 21) {
            file = context.getCodeCacheDir();
            if (file == null) {
                file = context.getCacheDir();
            }
        } else {
            file = context.getCacheDir();
        }
        if (file == null) {
            file = new File(m41704a(context), "cache");
        }
        return file.getPath();
    }

    /* renamed from: a */
    private static String m41704a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.getDataDir().getPath();
        }
        return context.getApplicationInfo().dataDir;
    }
}
