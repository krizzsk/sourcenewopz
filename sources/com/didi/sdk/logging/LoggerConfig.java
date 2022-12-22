package com.didi.sdk.logging;

import com.didi.sdk.logging.util.Objects;
import com.didi.sdk.logging.util.Supplier;
import com.didiglobal.enginecore.cache.XECacheConfig;
import java.io.File;

public class LoggerConfig {
    public static final String GLOBAL_SERVER_HOST = "https://catchdata.didiglobal.com/";

    /* renamed from: a */
    private final String f36490a;

    /* renamed from: b */
    private final int f36491b;

    /* renamed from: c */
    private final long f36492c;

    /* renamed from: d */
    private final int f36493d;

    /* renamed from: e */
    private final long f36494e;

    /* renamed from: f */
    private final Boolean f36495f;

    /* renamed from: g */
    private final Boolean f36496g;

    /* renamed from: h */
    private final boolean f36497h;

    /* renamed from: i */
    private final boolean f36498i;

    /* renamed from: j */
    private final Level f36499j;

    /* renamed from: k */
    private final Level f36500k;

    /* renamed from: l */
    private final File f36501l;

    /* renamed from: m */
    private final Supplier<String> f36502m;

    @Deprecated
    public enum LogMode {
        MODE_NORMAL,
        MODE_UPLOAD
    }

    public String getServerHost() {
        return this.f36490a;
    }

    public int getFileMaxHistory() {
        return this.f36491b;
    }

    public long getTotalFileSize() {
        return this.f36492c;
    }

    public int getFileSectionLength() {
        return this.f36493d;
    }

    public long getMaxFileSize() {
        return this.f36494e;
    }

    public boolean isDebuggable() {
        return this.f36498i;
    }

    public Boolean isFileLogEnabled() {
        return this.f36495f;
    }

    public Boolean isLogcatLogEnabled() {
        return this.f36496g;
    }

    public Boolean isEncryptEnabled() {
        return Boolean.valueOf(this.f36497h);
    }

    public Level getFileLogLevel() {
        return this.f36499j;
    }

    public Level getLogcatLogLevel() {
        return this.f36500k;
    }

    public File getLogDir() {
        return this.f36501l;
    }

    public Supplier<String> getUidSupplier() {
        return this.f36502m;
    }

    private LoggerConfig(Builder builder) {
        this.f36490a = builder.serverHost;
        this.f36491b = builder.fileMaxHistory;
        this.f36492c = builder.totalFileSize;
        this.f36493d = builder.fileSectionLength;
        this.f36494e = builder.maxFileSize;
        this.f36495f = builder.fileLogEnabled;
        this.f36496g = builder.logcatLogEnabled;
        this.f36497h = builder.encryptEnabled;
        this.f36498i = builder.debuggable;
        this.f36499j = builder.fileLogLevel;
        this.f36500k = builder.logcatLogLevel;
        this.f36501l = builder.logDir;
        this.f36502m = builder.uidSupplier;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean debuggable;
        /* access modifiers changed from: private */
        public boolean encryptEnabled = true;
        /* access modifiers changed from: private */
        public Boolean fileLogEnabled;
        /* access modifiers changed from: private */
        public Level fileLogLevel = Level.INFO;
        /* access modifiers changed from: private */
        public int fileMaxHistory = 7;
        /* access modifiers changed from: private */
        public int fileSectionLength = 2097152;
        /* access modifiers changed from: private */
        public File logDir;
        /* access modifiers changed from: private */
        public Boolean logcatLogEnabled;
        /* access modifiers changed from: private */
        public Level logcatLogLevel = Level.TRACE;
        /* access modifiers changed from: private */
        public long maxFileSize = 5242880;
        /* access modifiers changed from: private */
        public String serverHost = "";
        /* access modifiers changed from: private */
        public long totalFileSize = XECacheConfig.XE_CACHE_DEF_MAX_SIZE;
        /* access modifiers changed from: private */
        public Supplier<String> uidSupplier;

        @Deprecated
        public Builder phoneNumSupplier(Supplier<String> supplier) {
            return this;
        }

        public Builder serverHost(String str) {
            Objects.requireNonNull(str);
            this.serverHost = str;
            return this;
        }

        public Builder fileMaxHistory(int i) {
            this.fileMaxHistory = i;
            return this;
        }

        public Builder totalFileSize(long j) {
            this.totalFileSize = j;
            return this;
        }

        public Builder fileSectionLength(int i) {
            this.fileSectionLength = i;
            return this;
        }

        public Builder maxFileSize(long j) {
            this.maxFileSize = j;
            return this;
        }

        public Builder fileLogEnabled(boolean z) {
            this.fileLogEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder logcatLogEnabled(boolean z) {
            this.logcatLogEnabled = Boolean.valueOf(z);
            return this;
        }

        public Builder encryptEnabled(boolean z) {
            this.encryptEnabled = z;
            return this;
        }

        public Builder debuggable(boolean z) {
            this.debuggable = z;
            return this;
        }

        public Builder fileLogLevel(Level level) {
            Objects.requireNonNull(level);
            this.fileLogLevel = level;
            return this;
        }

        public Builder logcatLogLevel(Level level) {
            Objects.requireNonNull(level);
            this.logcatLogLevel = level;
            return this;
        }

        public Builder logDir(File file) {
            this.logDir = file;
            return this;
        }

        public LoggerConfig build() {
            return new LoggerConfig(this);
        }

        public Builder uid(Supplier<String> supplier) {
            this.uidSupplier = supplier;
            return this;
        }
    }
}
