package p242io.reactivex.android.plugins;

import java.util.concurrent.Callable;
import p242io.reactivex.Scheduler;
import p242io.reactivex.exceptions.Exceptions;
import p242io.reactivex.functions.Function;

/* renamed from: io.reactivex.android.plugins.RxAndroidPlugins */
public final class RxAndroidPlugins {

    /* renamed from: a */
    private static volatile Function<Callable<Scheduler>, Scheduler> f58026a;

    /* renamed from: b */
    private static volatile Function<Scheduler, Scheduler> f58027b;

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        f58026a = function;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        if (callable != null) {
            Function<Callable<Scheduler>, Scheduler> function = f58026a;
            if (function == null) {
                return m41800a(callable);
            }
            return m41799a(function, callable);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        f58027b = function;
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler != null) {
            Function function = f58027b;
            if (function == null) {
                return scheduler;
            }
            return (Scheduler) m41801a(function, scheduler);
        }
        throw new NullPointerException("scheduler == null");
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return f58026a;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return f58027b;
    }

    public static void reset() {
        setInitMainThreadSchedulerHandler((Function<Callable<Scheduler>, Scheduler>) null);
        setMainThreadSchedulerHandler((Function<Scheduler, Scheduler>) null);
    }

    /* renamed from: a */
    static Scheduler m41800a(Callable<Scheduler> callable) {
        try {
            Scheduler call = callable.call();
            if (call != null) {
                return call;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [io.reactivex.functions.Function, io.reactivex.functions.Function<java.util.concurrent.Callable<io.reactivex.Scheduler>, io.reactivex.Scheduler>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static p242io.reactivex.Scheduler m41799a(p242io.reactivex.functions.Function<java.util.concurrent.Callable<p242io.reactivex.Scheduler>, p242io.reactivex.Scheduler> r0, java.util.concurrent.Callable<p242io.reactivex.Scheduler> r1) {
        /*
            java.lang.Object r0 = m41801a(r0, r1)
            io.reactivex.Scheduler r0 = (p242io.reactivex.Scheduler) r0
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "Scheduler Callable returned null"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p242io.reactivex.android.plugins.RxAndroidPlugins.m41799a(io.reactivex.functions.Function, java.util.concurrent.Callable):io.reactivex.Scheduler");
    }

    /* renamed from: a */
    static <T, R> R m41801a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw Exceptions.propagate(th);
        }
    }

    private RxAndroidPlugins() {
        throw new AssertionError("No instances.");
    }
}
