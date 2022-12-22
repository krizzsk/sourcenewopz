package com.didi.quicksilver.util;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class QueuedWork {

    /* renamed from: a */
    private static ExecutorService f33081a;

    /* renamed from: b */
    private static final ArrayDeque<QueuedTask> f33082b = new ArrayDeque<>();

    /* renamed from: c */
    private static QueuedTask f33083c;

    public static ExecutorService singleThreadExecutor() {
        ExecutorService executorService;
        synchronized (QueuedWork.class) {
            if (f33081a == null) {
                f33081a = Executors.newSingleThreadExecutor(new ThreadFactory() {
                    public Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "qsp-QueuedWork");
                    }
                });
            }
            executorService = f33081a;
        }
        return executorService;
    }

    public static synchronized void queueTask(QueuedTask queuedTask) {
        synchronized (QueuedWork.class) {
            f33082b.offer(queuedTask);
            if (f33083c == null) {
                m23270b();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized void m23270b() {
        synchronized (QueuedWork.class) {
            QueuedTask poll = f33082b.poll();
            if (poll == null) {
                f33083c = null;
                return;
            }
            Iterator<QueuedTask> it = f33082b.iterator();
            while (it.hasNext()) {
                QueuedTask next = it.next();
                if (next.name.equals(poll.name)) {
                    it.remove();
                    poll = next;
                }
            }
            f33083c = poll;
            singleThreadExecutor().execute(f33083c);
        }
    }

    public static class QueuedTask implements Runnable {
        String name;
        Runnable task;

        public QueuedTask(String str, Runnable runnable) {
            this.name = str;
            this.task = runnable;
        }

        public void run() {
            try {
                this.task.run();
            } finally {
                QueuedWork.m23270b();
            }
        }
    }
}
