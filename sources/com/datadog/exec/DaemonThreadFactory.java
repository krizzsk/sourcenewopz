package com.datadog.exec;

import java.util.concurrent.ThreadFactory;

public final class DaemonThreadFactory implements ThreadFactory {
    public static final DaemonThreadFactory TASK_SCHEDULER = new DaemonThreadFactory("dd-task-scheduler");
    public static final DaemonThreadFactory TRACE_PROCESSOR = new DaemonThreadFactory("dd-trace-processor");
    public static final DaemonThreadFactory TRACE_WRITER = new DaemonThreadFactory("dd-trace-writer");

    /* renamed from: a */
    private final String f4079a;

    public DaemonThreadFactory(String str) {
        this.f4079a = str;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f4079a);
        thread.setDaemon(true);
        thread.setContextClassLoader((ClassLoader) null);
        return thread;
    }
}
