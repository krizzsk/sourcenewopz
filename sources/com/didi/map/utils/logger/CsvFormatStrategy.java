package com.didi.map.utils.logger;

import android.os.HandlerThread;
import com.didi.map.utils.logger.DiskLogStrategy;
import com.didi.sdk.apm.SystemUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CsvFormatStrategy implements FormatStrategy {

    /* renamed from: a */
    private static final String f29035a = System.getProperty("line.separator");

    /* renamed from: b */
    private static final String f29036b = " <br> ";

    /* renamed from: c */
    private static final String f29037c = ",";

    /* renamed from: d */
    private final Date f29038d;

    /* renamed from: e */
    private final SimpleDateFormat f29039e;

    /* renamed from: f */
    private final LogStrategy f29040f;

    /* renamed from: g */
    private final String f29041g;

    private CsvFormatStrategy(Builder builder) {
        C10238b.m20477b(builder);
        this.f29038d = builder.date;
        this.f29039e = builder.dateFormat;
        this.f29040f = builder.logStrategy;
        this.f29041g = builder.tag;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void log(int i, String str, String str2) {
        C10238b.m20477b(str2);
        String a = m20435a(str);
        this.f29038d.setTime(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toString(this.f29038d.getTime()));
        sb.append(",");
        sb.append(this.f29039e.format(this.f29038d));
        sb.append(",");
        sb.append(C10238b.m20472a(i));
        sb.append(",");
        sb.append(a);
        if (str2.contains(f29035a)) {
            str2 = str2.replaceAll(f29035a, f29036b);
        }
        sb.append(",");
        sb.append(str2);
        sb.append(f29035a);
        this.f29040f.log(i, a, sb.toString());
    }

    /* renamed from: a */
    private String m20435a(String str) {
        if (C10238b.m20475a((CharSequence) str) || C10238b.m20476a(this.f29041g, str)) {
            return this.f29041g;
        }
        return this.f29041g + "-" + str;
    }

    public static final class Builder {
        private static final int MAX_BYTES = 512000;
        Date date;
        SimpleDateFormat dateFormat;
        LogStrategy logStrategy;
        String tag;

        private Builder() {
            this.tag = "PRETTY_LOGGER";
        }

        public Builder date(Date date2) {
            this.date = date2;
            return this;
        }

        public Builder dateFormat(SimpleDateFormat simpleDateFormat) {
            this.dateFormat = simpleDateFormat;
            return this;
        }

        public Builder logStrategy(LogStrategy logStrategy2) {
            this.logStrategy = logStrategy2;
            return this;
        }

        public Builder tag(String str) {
            this.tag = str;
            return this;
        }

        public CsvFormatStrategy build() {
            if (this.date == null) {
                this.date = new Date();
            }
            if (this.dateFormat == null) {
                this.dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.UK);
            }
            if (this.logStrategy == null) {
                String str = SystemUtils.getExternalStorageDirectory().getAbsolutePath() + File.separatorChar + "logger";
                HandlerThread handlerThread = new HandlerThread("AndroidFileLogger." + str);
                handlerThread.start();
                this.logStrategy = new DiskLogStrategy(new DiskLogStrategy.WriteHandler(handlerThread.getLooper(), str, 512000));
            }
            return new CsvFormatStrategy(this);
        }
    }
}
