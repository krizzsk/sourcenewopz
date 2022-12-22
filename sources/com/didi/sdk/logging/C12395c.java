package com.didi.sdk.logging;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.logging.model.AbstractLog;
import com.didi.sdk.logging.model.BinaryLog;
import com.didi.sdk.logging.model.LongLog;
import com.didi.sdk.logging.util.Objects;
import com.didi.sdk.logging.util.StringUtils;
import java.util.Date;
import java.util.Map;

/* renamed from: com.didi.sdk.logging.c */
/* compiled from: InternalLogger */
class C12395c extends AbstractLogger {

    /* renamed from: a */
    private final String f36530a;

    /* renamed from: b */
    private final LoggerConfig f36531b;

    /* renamed from: c */
    private boolean f36532c = m25889a();

    C12395c(String str, String str2, LoggerConfig loggerConfig) {
        super(str);
        this.f36531b = loggerConfig;
        this.f36530a = str2;
    }

    public boolean isTraceEnabled() {
        return Level.TRACE.level >= this.f36531b.getFileLogLevel().level || Level.TRACE.level >= this.f36531b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isDebugEnabled() {
        return Level.DEBUG.level >= this.f36531b.getFileLogLevel().level || Level.TRACE.level >= this.f36531b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isInfoEnabled() {
        return Level.INFO.level >= this.f36531b.getFileLogLevel().level || Level.TRACE.level >= this.f36531b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isWarnEnabled() {
        return Level.WARN.level >= this.f36531b.getFileLogLevel().level || Level.TRACE.level >= this.f36531b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public boolean isErrorEnabled() {
        return Level.ERROR.level >= this.f36531b.getFileLogLevel().level || Level.TRACE.level >= this.f36531b.getLogcatLogLevel().level || Level.TRACE.level >= LoggerFactory.getFilterLevel();
    }

    public void write(byte[] bArr) {
        Objects.requireNonNull(bArr);
        if (bArr.length != 0) {
            BinaryExecutor.m25849a(this.f36530a).mo92512a((AbstractLog) new BinaryLog((byte[]) bArr.clone()));
        }
    }

    public void trace(String str, Throwable th) {
        m25887a(Level.TRACE, str, th);
    }

    public void trace(String str, Object... objArr) {
        m25888a(Level.TRACE, str, (Map<?, ?>) null, objArr);
    }

    public void trace(String str, Map<?, ?> map) {
        m25888a(Level.TRACE, str, map, new Object[0]);
    }

    public void debug(String str, Throwable th) {
        m25887a(Level.DEBUG, str, th);
    }

    public void debug(String str, Object... objArr) {
        m25888a(Level.DEBUG, str, (Map<?, ?>) null, objArr);
    }

    public void debug(String str, Map<?, ?> map) {
        m25888a(Level.DEBUG, str, map, new Object[0]);
    }

    public void info(String str, Throwable th) {
        m25887a(Level.INFO, str, th);
    }

    public void info(String str, Object... objArr) {
        m25888a(Level.INFO, str, (Map<?, ?>) null, objArr);
    }

    public void info(String str, Map<?, ?> map) {
        m25888a(Level.INFO, str, map, new Object[0]);
    }

    public void warn(String str, Throwable th) {
        m25887a(Level.WARN, str, th);
    }

    public void warn(String str, Object... objArr) {
        m25888a(Level.WARN, str, (Map<?, ?>) null, objArr);
    }

    public void warn(String str, Map<?, ?> map) {
        m25888a(Level.WARN, str, map, new Object[0]);
    }

    public void error(String str, Throwable th) {
        m25887a(Level.WARN, str, th);
    }

    public void error(String str, Object... objArr) {
        m25888a(Level.ERROR, str, (Map<?, ?>) null, objArr);
    }

    public void error(String str, Map<?, ?> map) {
        m25888a(Level.ERROR, str, map, new Object[0]);
    }

    public void traceEvent(String str, Map<?, ?> map) {
        m25888a(Level.TRACE, str, mapCopy(map), new Object[0]);
    }

    public void debugEvent(String str, Map<?, ?> map) {
        m25888a(Level.DEBUG, str, mapCopy(map), new Object[0]);
    }

    public void infoEvent(String str, Map<?, ?> map) {
        m25888a(Level.INFO, str, mapCopy(map), new Object[0]);
    }

    public void warnEvent(String str, Map<?, ?> map) {
        m25888a(Level.WARN, str, mapCopy(map), new Object[0]);
    }

    public void errorEvent(String str, Map<?, ?> map) {
        m25888a(Level.ERROR, str, mapCopy(map), new Object[0]);
    }

    public void traceEvent(String str, Object... objArr) {
        m25888a(Level.TRACE, str, toMap(objArr), new Object[0]);
    }

    public void debugEvent(String str, Object... objArr) {
        m25888a(Level.DEBUG, str, toMap(objArr), new Object[0]);
    }

    public void infoEvent(String str, Object... objArr) {
        m25888a(Level.INFO, str, toMap(objArr), new Object[0]);
    }

    public void warnEvent(String str, Object... objArr) {
        m25888a(Level.WARN, str, toMap(objArr), new Object[0]);
    }

    public void errorEvent(String str, Object... objArr) {
        m25888a(Level.ERROR, str, toMap(objArr), new Object[0]);
    }

    public void log(int i, String str, Throwable th, String str2, int i2) {
        Level level = Level.getLevel(i);
        if (!LoggerContext.getDefault().isInitial() || TextUtils.isEmpty(str)) {
            return;
        }
        if (i >= this.f36531b.getFileLogLevel().level || i >= this.f36531b.getLogcatLogLevel().level || i >= LoggerFactory.getFilterLevel() || this.f36532c) {
            if (th != null) {
                str = str + "\n" + Log.getStackTraceString(th);
            }
            LogbackExecutor.m25860a(this.f36530a).mo92521a((AbstractLog) new LongLog.Builder().setLogLevel(level).setDate(new Date()).setTag(this.mName).setMsg(str).setTid(Process.myTid()).setTnm(Thread.currentThread().getName()).setClassName(str2).setLine(i2).build());
        }
    }

    /* renamed from: a */
    private void m25888a(Level level, String str, Map<?, ?> map, Object... objArr) {
        if (!LoggerContext.getDefault().isInitial() || TextUtils.isEmpty(str)) {
            return;
        }
        if (level.level >= this.f36531b.getFileLogLevel().level || level.level >= this.f36531b.getLogcatLogLevel().level || level.level >= LoggerFactory.getFilterLevel() || this.f36532c) {
            LongLog.Builder args = new LongLog.Builder().setLogLevel(level).setDate(new Date()).setTag(this.mName).setMsg(str).setTid(Process.myTid()).setTnm(Thread.currentThread().getName()).setUserInfo(map).setArgs(objArr);
            if (this.mClass != null) {
                args.setClassName(this.mClass.getName());
            }
            LogbackExecutor.m25860a(this.f36530a).mo92521a((AbstractLog) args.build());
        }
    }

    /* renamed from: a */
    private void m25887a(Level level, String str, Throwable th) {
        if (!LoggerContext.getDefault().isInitial() || TextUtils.isEmpty(str)) {
            return;
        }
        if (level.level >= this.f36531b.getFileLogLevel().level || level.level >= this.f36531b.getLogcatLogLevel().level || level.level >= LoggerFactory.getFilterLevel() || this.f36532c) {
            if (th != null) {
                str = str + "\n" + Log.getStackTraceString(th);
            }
            LogbackExecutor.m25860a(this.f36530a).mo92521a((AbstractLog) new LongLog.Builder().setLogLevel(level).setDate(new Date()).setTag(this.mName).setMsg(str).setTid(Process.myTid()).setTnm(StringUtils.ellipsize(Thread.currentThread().getName(), 20, 4)).build());
        }
    }

    public void println(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogbackExecutor.m25860a(this.f36530a).mo92521a((AbstractLog) new LongLog.Builder().setLogLevel(Level.INFO).setTag("logging").setMsg(str).setFormat(false).build());
        }
    }

    /* renamed from: a */
    private boolean m25889a() {
        if (TextUtils.isEmpty(LoggerFactory.getFilterTag()) || TextUtils.isEmpty(this.mName)) {
            return false;
        }
        return LoggerFactory.getFilterTag().equals(this.mName);
    }
}
