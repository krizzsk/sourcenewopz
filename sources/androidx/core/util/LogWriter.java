package androidx.core.util;

import com.didi.sdk.apm.SystemUtils;
import java.io.Writer;

@Deprecated
public class LogWriter extends Writer {
    private StringBuilder mBuilder = new StringBuilder(128);
    private final String mTag;

    public LogWriter(String str) {
        this.mTag = str;
    }

    public void close() {
        flushBuilder();
    }

    public void flush() {
        flushBuilder();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == 10) {
                flushBuilder();
            } else {
                this.mBuilder.append(c);
            }
        }
    }

    private void flushBuilder() {
        if (this.mBuilder.length() > 0) {
            SystemUtils.log(3, this.mTag, this.mBuilder.toString(), (Throwable) null, "androidx.core.util.LogWriter", 69);
            StringBuilder sb = this.mBuilder;
            sb.delete(0, sb.length());
        }
    }
}
