package p242io.socket.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

/* renamed from: io.socket.thread.EventThread */
public class EventThread extends Thread {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f59555a = Logger.getLogger(EventThread.class.getName());

    /* renamed from: b */
    private static final ThreadFactory f59556b = new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            EventThread unused = EventThread.f59557c = new EventThread(runnable);
            EventThread.f59557c.setName("EventThread");
            EventThread.f59557c.setDaemon(Thread.currentThread().isDaemon());
            return EventThread.f59557c;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static EventThread f59557c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static ExecutorService f59558d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f59559e = 0;

    /* renamed from: c */
    static /* synthetic */ int m42073c() {
        int i = f59559e;
        f59559e = i - 1;
        return i;
    }

    private EventThread(Runnable runnable) {
        super(runnable);
    }

    public static boolean isCurrent() {
        return currentThread() == f59557c;
    }

    public static void exec(Runnable runnable) {
        if (isCurrent()) {
            runnable.run();
        } else {
            nextTick(runnable);
        }
    }

    public static void nextTick(final Runnable runnable) {
        ExecutorService executorService;
        synchronized (EventThread.class) {
            f59559e++;
            if (f59558d == null) {
                f59558d = Executors.newSingleThreadExecutor(f59556b);
            }
            executorService = f59558d;
        }
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    runnable.run();
                    synchronized (EventThread.class) {
                        EventThread.m42073c();
                        if (EventThread.f59559e == 0) {
                            EventThread.f59558d.shutdown();
                            ExecutorService unused = EventThread.f59558d = null;
                            EventThread unused2 = EventThread.f59557c = null;
                        }
                    }
                } catch (Throwable th) {
                    synchronized (EventThread.class) {
                        EventThread.m42073c();
                        if (EventThread.f59559e == 0) {
                            EventThread.f59558d.shutdown();
                            ExecutorService unused3 = EventThread.f59558d = null;
                            EventThread unused4 = EventThread.f59557c = null;
                        }
                        throw th;
                    }
                }
            }
        });
    }
}
