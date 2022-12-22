package p093switch;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: switch.catch */
/* compiled from: ThreadUtils */
public class C3108catch {

    /* renamed from: switch.catch$do */
    /* compiled from: ThreadUtils */
    static /* synthetic */ class C3109do {

        /* renamed from: do */
        static final /* synthetic */ int[] f6934do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                switch.catch$new[] r0 = p093switch.C3108catch.C3112new.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6934do = r0
                switch.catch$new r1 = p093switch.C3108catch.C3112new.RUN_TASK_ONLY_IF_IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6934do     // Catch:{ NoSuchFieldError -> 0x001d }
                switch.catch$new r1 = p093switch.C3108catch.C3112new.QUEUE_MAX_ONE_TASK_REPLACING_IF_BUSY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6934do     // Catch:{ NoSuchFieldError -> 0x0028 }
                switch.catch$new r1 = p093switch.C3108catch.C3112new.QUEUE_TASKS_FIFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p093switch.C3108catch.C3109do.<clinit>():void");
        }
    }

    /* renamed from: switch.catch$for */
    /* compiled from: ThreadUtils */
    public enum C3110for {
        LOW(1),
        MEDIUM(5),
        HIGH(10);
        

        /* renamed from: do */
        private int f6936do;

        private C3110for(int i) {
            this.f6936do = i;
        }

        /* renamed from: do */
        public int mo38615do() {
            return this.f6936do;
        }
    }

    /* renamed from: switch.catch$if */
    /* compiled from: ThreadUtils */
    private static final class C3111if implements ThreadFactory {

        /* renamed from: do */
        private String f6937do;

        /* renamed from: if */
        private int f6938if;

        C3111if(String str, int i) {
            this.f6937do = str;
            this.f6938if = i;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f6937do);
            thread.setPriority(this.f6938if);
            return thread;
        }
    }

    /* renamed from: switch.catch$new */
    /* compiled from: ThreadUtils */
    public enum C3112new {
        RUN_TASK_ONLY_IF_IDLE,
        QUEUE_MAX_ONE_TASK_REPLACING_IF_BUSY,
        QUEUE_TASKS_FIFO
    }

    /* renamed from: do */
    public static ExecutorService m4015do(String str, C3110for forR, C3112new newR) {
        int i = C3109do.f6934do[newR.ordinal()];
        if (i == 1) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
            threadPoolExecutor.setThreadFactory(new C3111if(str, forR.mo38615do()));
            return threadPoolExecutor;
        } else if (i != 2) {
            return Executors.newSingleThreadExecutor(new C3111if(str, forR.mo38615do()));
        } else {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(1), new ThreadPoolExecutor.DiscardOldestPolicy());
            threadPoolExecutor2.setThreadFactory(new C3111if(str, forR.mo38615do()));
            return threadPoolExecutor2;
        }
    }

    /* renamed from: do */
    public static Thread m4014do(String str, C3110for forR, Runnable runnable) {
        return new C3111if(str, forR.mo38615do()).newThread(runnable);
    }
}
