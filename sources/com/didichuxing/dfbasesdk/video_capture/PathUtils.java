package com.didichuxing.dfbasesdk.video_capture;

import android.content.Context;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

public class PathUtils {

    /* renamed from: a */
    private static final SimpleDateFormat f46848a = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.US);

    /* renamed from: b */
    private static final String f46849b = "video";

    public static final File getCaptureFile(Context context, String str) {
        if (context == null) {
            return null;
        }
        File file = new File(context.getCacheDir(), "video");
        file.mkdirs();
        if (!file.canWrite()) {
            return null;
        }
        return new File(file, System.currentTimeMillis() + str);
    }

    public static final File getCaptureFile(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        File file = new File(getUnitedTempDir(context), str2);
        file.mkdirs();
        if (!file.canWrite()) {
            return null;
        }
        return new File(file, System.currentTimeMillis() + str);
    }

    /* renamed from: a */
    private static final String m33620a() {
        return f46848a.format(new GregorianCalendar().getTime());
    }

    public static File getCaptureDir(Context context) {
        if (context != null) {
            return new File(context.getCacheDir(), "video");
        }
        return null;
    }

    public static File getCaptureDir(Context context, String str) {
        if (context == null) {
            return null;
        }
        File file = new File(new File(context.getCacheDir(), "AccessSecurityTempDir"), str);
        file.mkdirs();
        return file;
    }

    public static File getUnitedTempDir(Context context) {
        if (context == null) {
            return null;
        }
        File file = new File(context.getCacheDir(), "AccessSecurityTempDir");
        file.mkdirs();
        return file;
    }
}
