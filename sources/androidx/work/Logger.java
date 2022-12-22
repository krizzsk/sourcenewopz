package androidx.work;

import com.didi.sdk.apm.SystemUtils;

public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static Logger sLogger;

    public abstract void debug(String str, String str2, Throwable... thArr);

    public abstract void error(String str, String str2, Throwable... thArr);

    public abstract void info(String str, String str2, Throwable... thArr);

    public abstract void verbose(String str, String str2, Throwable... thArr);

    public abstract void warning(String str, String str2, Throwable... thArr);

    public static synchronized void setLogger(Logger logger) {
        synchronized (Logger.class) {
            sLogger = logger;
        }
    }

    public static String tagWithPrefix(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append(TAG_PREFIX);
        int i = MAX_PREFIXED_TAG_LENGTH;
        if (length >= i) {
            sb.append(str.substring(0, i));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public static synchronized Logger get() {
        Logger logger;
        synchronized (Logger.class) {
            if (sLogger == null) {
                sLogger = new LogcatLogger(3);
            }
            logger = sLogger;
        }
        return logger;
    }

    public Logger(int i) {
    }

    public static class LogcatLogger extends Logger {
        private int mLoggingLevel;

        public LogcatLogger(int i) {
            super(i);
            this.mLoggingLevel = i;
        }

        public void verbose(String str, String str2, Throwable... thArr) {
            Throwable[] thArr2 = thArr;
            if (this.mLoggingLevel > 2) {
                return;
            }
            if (thArr2 == null || thArr2.length < 1) {
                SystemUtils.log(2, str, str2, (Throwable) null, "androidx.work.Logger$LogcatLogger", 129);
                return;
            }
            SystemUtils.log(2, str, str2, thArr2[0], "androidx.work.Logger$LogcatLogger", 127);
        }

        public void debug(String str, String str2, Throwable... thArr) {
            Throwable[] thArr2 = thArr;
            if (this.mLoggingLevel > 3) {
                return;
            }
            if (thArr2 == null || thArr2.length < 1) {
                SystemUtils.log(3, str, str2, (Throwable) null, "androidx.work.Logger$LogcatLogger", 140);
                return;
            }
            SystemUtils.log(3, str, str2, thArr2[0], "androidx.work.Logger$LogcatLogger", 138);
        }

        public void info(String str, String str2, Throwable... thArr) {
            Throwable[] thArr2 = thArr;
            if (this.mLoggingLevel > 4) {
                return;
            }
            if (thArr2 == null || thArr2.length < 1) {
                SystemUtils.log(4, str, str2, (Throwable) null, "androidx.work.Logger$LogcatLogger", 151);
                return;
            }
            SystemUtils.log(4, str, str2, thArr2[0], "androidx.work.Logger$LogcatLogger", 149);
        }

        public void warning(String str, String str2, Throwable... thArr) {
            Throwable[] thArr2 = thArr;
            if (this.mLoggingLevel > 5) {
                return;
            }
            if (thArr2 == null || thArr2.length < 1) {
                SystemUtils.log(5, str, str2, (Throwable) null, "androidx.work.Logger$LogcatLogger", 162);
                return;
            }
            SystemUtils.log(5, str, str2, thArr2[0], "androidx.work.Logger$LogcatLogger", 160);
        }

        public void error(String str, String str2, Throwable... thArr) {
            Throwable[] thArr2 = thArr;
            if (this.mLoggingLevel > 6) {
                return;
            }
            if (thArr2 == null || thArr2.length < 1) {
                SystemUtils.log(6, str, str2, (Throwable) null, "androidx.work.Logger$LogcatLogger", 173);
                return;
            }
            SystemUtils.log(6, str, str2, thArr2[0], "androidx.work.Logger$LogcatLogger", 171);
        }
    }
}
