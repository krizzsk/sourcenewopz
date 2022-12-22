package bolts;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class AndroidExecutors {

    /* renamed from: a */
    static final int f392a;

    /* renamed from: b */
    static final int f393b;

    /* renamed from: c */
    static final long f394c = 1;

    /* renamed from: d */
    private static final AndroidExecutors f395d = new AndroidExecutors();

    /* renamed from: f */
    private static final int f396f;

    /* renamed from: e */
    private final Executor f397e = new UIThreadExecutor();

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f396f = availableProcessors;
        f392a = availableProcessors + 1;
        f393b = (availableProcessors * 2) + 1;
    }

    private AndroidExecutors() {
    }

    /* renamed from: a */
    public static ExecutorService m915a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f392a, f393b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        m917a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static ExecutorService m916a(ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f392a, f393b, 1, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        m917a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    /* renamed from: a */
    public static void m917a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }

    /* renamed from: b */
    public static Executor m918b() {
        return f395d.f397e;
    }

    private static class UIThreadExecutor implements Executor {
        private UIThreadExecutor() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
