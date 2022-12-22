package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class BoltsExecutors {

    /* renamed from: a */
    private static final BoltsExecutors f398a = new BoltsExecutors();

    /* renamed from: b */
    private final ExecutorService f399b;

    /* renamed from: c */
    private final ScheduledExecutorService f400c;

    /* renamed from: d */
    private final Executor f401d;

    /* renamed from: d */
    private static boolean m922d() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    private BoltsExecutors() {
        this.f399b = !m922d() ? Executors.newCachedThreadPool() : AndroidExecutors.m915a();
        this.f400c = Executors.newSingleThreadScheduledExecutor();
        this.f401d = new ImmediateExecutor();
    }

    /* renamed from: a */
    public static ExecutorService m919a() {
        return f398a.f399b;
    }

    /* renamed from: b */
    static ScheduledExecutorService m920b() {
        return f398a.f400c;
    }

    /* renamed from: c */
    static Executor m921c() {
        return f398a.f401d;
    }

    private static class ImmediateExecutor implements Executor {
        private static final int MAX_DEPTH = 15;
        private ThreadLocal<Integer> executionDepth;

        private ImmediateExecutor() {
            this.executionDepth = new ThreadLocal<>();
        }

        private int incrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int decrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (incrementDepth() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    decrementDepth();
                    throw th;
                }
            } else {
                BoltsExecutors.m919a().execute(runnable);
            }
            decrementDepth();
        }
    }
}
