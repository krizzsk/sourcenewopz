package com.didi.sdk.util;

import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Iterator;
import java.util.LinkedList;

public class LogTimer {

    /* renamed from: a */
    private static Logger f37635a = LoggerFactory.getLogger("LogTimer");

    /* renamed from: b */
    private long f37636b;

    /* renamed from: c */
    private long f37637c;

    /* renamed from: d */
    private LinkedList<String> f37638d;

    /* renamed from: e */
    private long f37639e;

    public static class ElapsedTime {
        public long fromLast;
        public long fromStart;
    }

    public static LogTimer get() {
        return InstanceHolder.LOG_TIMER;
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final LogTimer LOG_TIMER = new LogTimer();

        private InstanceHolder() {
        }
    }

    private LogTimer() {
        this.f37638d = new LinkedList<>();
    }

    public synchronized long elapsedTime() {
        return elapsedTime((ElapsedTime) null);
    }

    public synchronized long elapsedTime(ElapsedTime elapsedTime) {
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        j = currentTimeMillis - this.f37636b;
        if (elapsedTime != null) {
            elapsedTime.fromLast = currentTimeMillis - this.f37637c;
            elapsedTime.fromStart = j;
        }
        this.f37637c = currentTimeMillis;
        return j;
    }

    public synchronized long reset() {
        return set(System.currentTimeMillis());
    }

    public synchronized long set(long j) {
        this.f37638d.clear();
        this.f37636b = j;
        this.f37637c = j;
        return j;
    }

    public long getMainActivityStartTime() {
        return this.f37639e;
    }

    public void setMainActivityStartTime(long j) {
        this.f37639e = j;
    }

    public synchronized void dump() {
        Iterator it = this.f37638d.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (str != null) {
                f37635a.debug(str, new Object[0]);
            }
        }
        this.f37638d.clear();
    }

    public synchronized long startTime() {
        return this.f37636b;
    }

    public synchronized String methodStart(ElapsedTime elapsedTime, String str) {
        String format;
        if (elapsedTime == null) {
            elapsedTime = new ElapsedTime();
        }
        elapsedTime(elapsedTime);
        format = String.format("[%4dms | +%3dms] %s START...", new Object[]{Long.valueOf(elapsedTime.fromStart), Long.valueOf(elapsedTime.fromLast), str});
        this.f37638d.add(format);
        return format;
    }

    public synchronized String methodEnd(ElapsedTime elapsedTime, String str) {
        String format;
        if (elapsedTime == null) {
            elapsedTime = new ElapsedTime();
        }
        elapsedTime(elapsedTime);
        format = String.format("[%4dms | +%3dms] %s END...", new Object[]{Long.valueOf(elapsedTime.fromStart), Long.valueOf(elapsedTime.fromLast), str});
        this.f37638d.add(format);
        return format;
    }
}
