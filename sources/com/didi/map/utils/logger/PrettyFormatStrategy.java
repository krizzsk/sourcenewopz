package com.didi.map.utils.logger;

public class PrettyFormatStrategy implements FormatStrategy {

    /* renamed from: a */
    private static final int f29046a = 4000;

    /* renamed from: b */
    private static final int f29047b = 5;

    /* renamed from: c */
    private static final char f29048c = '┌';

    /* renamed from: d */
    private static final char f29049d = '└';

    /* renamed from: e */
    private static final char f29050e = '├';

    /* renamed from: f */
    private static final char f29051f = '│';

    /* renamed from: g */
    private static final String f29052g = "────────────────────────────────────────────────────────";

    /* renamed from: h */
    private static final String f29053h = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: i */
    private static final String f29054i = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: j */
    private static final String f29055j = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* renamed from: k */
    private static final String f29056k = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* renamed from: l */
    private final int f29057l;

    /* renamed from: m */
    private final int f29058m;

    /* renamed from: n */
    private final boolean f29059n;

    /* renamed from: o */
    private final LogStrategy f29060o;

    /* renamed from: p */
    private final String f29061p;

    private PrettyFormatStrategy(Builder builder) {
        C10238b.m20477b(builder);
        this.f29057l = builder.methodCount;
        this.f29058m = builder.methodOffset;
        this.f29059n = builder.showThreadInfo;
        this.f29060o = builder.logStrategy;
        this.f29061p = builder.tag;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void log(int i, String str, String str2) {
        C10238b.m20477b(str2);
        String b = m20449b(str);
        m20446a(i, b);
        m20447a(i, b, this.f29057l);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f29057l > 0) {
                m20452c(i, b);
            }
            m20448a(i, b, str2);
            m20450b(i, b);
            return;
        }
        if (this.f29057l > 0) {
            m20452c(i, b);
        }
        for (int i2 = 0; i2 < length; i2 += 4000) {
            m20448a(i, b, new String(bytes, i2, Math.min(length - i2, 4000)));
        }
        m20450b(i, b);
    }

    /* renamed from: a */
    private void m20446a(int i, String str) {
        m20451b(i, str, f29054i);
    }

    /* renamed from: a */
    private void m20447a(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f29059n) {
            m20451b(i, str, "│ Thread: " + Thread.currentThread().getName());
            m20452c(i, str);
        }
        int a = m20444a(stackTrace) + this.f29058m;
        if (i2 + a > stackTrace.length) {
            i2 = (stackTrace.length - a) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + a;
            if (i3 < stackTrace.length) {
                str2 = str2 + "   ";
                m20451b(i, str, f29051f + ' ' + str2 + m20445a(stackTrace[i3].getClassName()) + "." + stackTrace[i3].getMethodName() + " " + " (" + stackTrace[i3].getFileName() + ":" + stackTrace[i3].getLineNumber() + ")");
            }
            i2--;
        }
    }

    /* renamed from: b */
    private void m20450b(int i, String str) {
        m20451b(i, str, f29055j);
    }

    /* renamed from: c */
    private void m20452c(int i, String str) {
        m20451b(i, str, f29056k);
    }

    /* renamed from: a */
    private void m20448a(int i, String str, String str2) {
        C10238b.m20477b(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            m20451b(i, str, "│ " + str3);
        }
    }

    /* renamed from: b */
    private void m20451b(int i, String str, String str2) {
        C10238b.m20477b(str2);
        this.f29060o.log(i, str, str2);
    }

    /* renamed from: a */
    private String m20445a(String str) {
        C10238b.m20477b(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: a */
    private int m20444a(StackTraceElement[] stackTraceElementArr) {
        C10238b.m20477b(stackTraceElementArr);
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(C10237a.class.getName()) && !className.equals(Logger.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    /* renamed from: b */
    private String m20449b(String str) {
        if (C10238b.m20475a((CharSequence) str) || C10238b.m20476a(this.f29061p, str)) {
            return this.f29061p;
        }
        return this.f29061p + "-" + str;
    }

    public static class Builder {
        LogStrategy logStrategy;
        int methodCount;
        int methodOffset;
        boolean showThreadInfo;
        String tag;

        private Builder() {
            this.methodCount = 2;
            this.methodOffset = 0;
            this.showThreadInfo = true;
            this.tag = "PRETTY_LOGGER";
        }

        public Builder methodCount(int i) {
            this.methodCount = i;
            return this;
        }

        public Builder methodOffset(int i) {
            this.methodOffset = i;
            return this;
        }

        public Builder showThreadInfo(boolean z) {
            this.showThreadInfo = z;
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

        public PrettyFormatStrategy build() {
            if (this.logStrategy == null) {
                this.logStrategy = new LogcatLogStrategy();
            }
            return new PrettyFormatStrategy(this);
        }
    }
}
