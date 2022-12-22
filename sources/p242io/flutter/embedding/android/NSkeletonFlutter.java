package p242io.flutter.embedding.android;

import com.didi.sdk.apm.SystemUtils;

/* renamed from: io.flutter.embedding.android.NSkeletonFlutter */
public final class NSkeletonFlutter {

    /* renamed from: a */
    private static Logger f57555a;

    /* renamed from: io.flutter.embedding.android.NSkeletonFlutter$Logger */
    public interface Logger {
        boolean debugLogEnable();

        void log(String str);
    }

    public static void log(Object obj, String str) {
        if (f57555a != null) {
            String str2 = (obj != null ? obj.toString() : "") + " " + str;
            f57555a.log(str2);
            if (f57555a.debugLogEnable()) {
                SystemUtils.log(4, "flutter", str2, (Throwable) null, "io.flutter.embedding.android.NSkeletonFlutter", 23);
            }
        }
    }

    public static void setLogger(Logger logger) {
        f57555a = logger;
    }

    public static Logger getLogger() {
        return f57555a;
    }
}
