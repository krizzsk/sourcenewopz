package p242io.reactivex.plugins;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import org.reactivestreams.Subscriber;
import p242io.reactivex.Completable;
import p242io.reactivex.CompletableObserver;
import p242io.reactivex.Flowable;
import p242io.reactivex.Maybe;
import p242io.reactivex.MaybeObserver;
import p242io.reactivex.Observable;
import p242io.reactivex.Observer;
import p242io.reactivex.Scheduler;
import p242io.reactivex.Single;
import p242io.reactivex.SingleObserver;
import p242io.reactivex.exceptions.CompositeException;
import p242io.reactivex.exceptions.MissingBackpressureException;
import p242io.reactivex.exceptions.OnErrorNotImplementedException;
import p242io.reactivex.exceptions.UndeliverableException;
import p242io.reactivex.flowables.ConnectableFlowable;
import p242io.reactivex.functions.BiFunction;
import p242io.reactivex.functions.BooleanSupplier;
import p242io.reactivex.functions.Consumer;
import p242io.reactivex.functions.Function;
import p242io.reactivex.internal.functions.ObjectHelper;
import p242io.reactivex.internal.schedulers.ComputationScheduler;
import p242io.reactivex.internal.schedulers.IoScheduler;
import p242io.reactivex.internal.schedulers.NewThreadScheduler;
import p242io.reactivex.internal.schedulers.SingleScheduler;
import p242io.reactivex.internal.util.ExceptionHelper;
import p242io.reactivex.observables.ConnectableObservable;
import p242io.reactivex.parallel.ParallelFlowable;

/* renamed from: io.reactivex.plugins.RxJavaPlugins */
public final class RxJavaPlugins {

    /* renamed from: a */
    static volatile Consumer<? super Throwable> f59326a;

    /* renamed from: b */
    static volatile Function<? super Runnable, ? extends Runnable> f59327b;

    /* renamed from: c */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f59328c;

    /* renamed from: d */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f59329d;

    /* renamed from: e */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f59330e;

    /* renamed from: f */
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f59331f;

    /* renamed from: g */
    static volatile Function<? super Scheduler, ? extends Scheduler> f59332g;

    /* renamed from: h */
    static volatile Function<? super Scheduler, ? extends Scheduler> f59333h;

    /* renamed from: i */
    static volatile Function<? super Scheduler, ? extends Scheduler> f59334i;

    /* renamed from: j */
    static volatile Function<? super Scheduler, ? extends Scheduler> f59335j;

    /* renamed from: k */
    static volatile Function<? super Flowable, ? extends Flowable> f59336k;

    /* renamed from: l */
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> f59337l;

    /* renamed from: m */
    static volatile Function<? super Observable, ? extends Observable> f59338m;

    /* renamed from: n */
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> f59339n;

    /* renamed from: o */
    static volatile Function<? super Maybe, ? extends Maybe> f59340o;

    /* renamed from: p */
    static volatile Function<? super Single, ? extends Single> f59341p;

    /* renamed from: q */
    static volatile Function<? super Completable, ? extends Completable> f59342q;

    /* renamed from: r */
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> f59343r;

    /* renamed from: s */
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f59344s;

    /* renamed from: t */
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> f59345t;

    /* renamed from: u */
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> f59346u;

    /* renamed from: v */
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f59347v;

    /* renamed from: w */
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f59348w;

    /* renamed from: x */
    static volatile BooleanSupplier f59349x;

    /* renamed from: y */
    static volatile boolean f59350y;

    /* renamed from: z */
    static volatile boolean f59351z;

    public static void lockdown() {
        f59350y = true;
    }

    public static boolean isLockdown() {
        return f59350y;
    }

    public static void setFailOnNonBlockingScheduler(boolean z) {
        if (!f59350y) {
            f59351z = z;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return f59351z;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return f59332g;
    }

    public static Consumer<? super Throwable> getErrorHandler() {
        return f59326a;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return f59328c;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return f59330e;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return f59331f;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return f59329d;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return f59334i;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return f59335j;
    }

    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return f59327b;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return f59333h;
    }

    public static Scheduler initComputationScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f59328c;
        if (function == null) {
            return m41882a(callable);
        }
        return m41881a(function, callable);
    }

    public static Scheduler initIoScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f59330e;
        if (function == null) {
            return m41882a(callable);
        }
        return m41881a(function, callable);
    }

    public static Scheduler initNewThreadScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f59331f;
        if (function == null) {
            return m41882a(callable);
        }
        return m41881a(function, callable);
    }

    public static Scheduler initSingleScheduler(Callable<Scheduler> callable) {
        ObjectHelper.requireNonNull(callable, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> function = f59329d;
        if (function == null) {
            return m41882a(callable);
        }
        return m41881a(function, callable);
    }

    public static Scheduler onComputationScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f59332g;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m41884a(function, scheduler);
    }

    public static void onError(Throwable th) {
        Consumer<? super Throwable> consumer = f59326a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!m41886a(th)) {
            th = new UndeliverableException(th);
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m41887b(th2);
            }
        }
        th.printStackTrace();
        m41887b(th);
    }

    /* renamed from: a */
    static boolean m41886a(Throwable th) {
        if (!(th instanceof OnErrorNotImplementedException) && !(th instanceof MissingBackpressureException) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof CompositeException)) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    static void m41887b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Scheduler onIoScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f59334i;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m41884a(function, scheduler);
    }

    public static Scheduler onNewThreadScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f59335j;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m41884a(function, scheduler);
    }

    public static Runnable onSchedule(Runnable runnable) {
        ObjectHelper.requireNonNull(runnable, "run is null");
        Function<? super Runnable, ? extends Runnable> function = f59327b;
        if (function == null) {
            return runnable;
        }
        return (Runnable) m41884a(function, runnable);
    }

    public static Scheduler onSingleScheduler(Scheduler scheduler) {
        Function<? super Scheduler, ? extends Scheduler> function = f59333h;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m41884a(function, scheduler);
    }

    public static void reset() {
        setErrorHandler((Consumer<? super Throwable>) null);
        setScheduleHandler((Function<? super Runnable, ? extends Runnable>) null);
        setComputationSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitComputationSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setIoSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitIoSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setSingleSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitSingleSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setNewThreadSchedulerHandler((Function<? super Scheduler, ? extends Scheduler>) null);
        setInitNewThreadSchedulerHandler((Function<? super Callable<Scheduler>, ? extends Scheduler>) null);
        setOnFlowableAssembly((Function<? super Flowable, ? extends Flowable>) null);
        setOnFlowableSubscribe((BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber>) null);
        setOnObservableAssembly((Function<? super Observable, ? extends Observable>) null);
        setOnObservableSubscribe((BiFunction<? super Observable, ? super Observer, ? extends Observer>) null);
        setOnSingleAssembly((Function<? super Single, ? extends Single>) null);
        setOnSingleSubscribe((BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver>) null);
        setOnCompletableAssembly((Function<? super Completable, ? extends Completable>) null);
        setOnCompletableSubscribe((BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver>) null);
        setOnConnectableFlowableAssembly((Function<? super ConnectableFlowable, ? extends ConnectableFlowable>) null);
        setOnConnectableObservableAssembly((Function<? super ConnectableObservable, ? extends ConnectableObservable>) null);
        setOnMaybeAssembly((Function<? super Maybe, ? extends Maybe>) null);
        setOnMaybeSubscribe((BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver>) null);
        setOnParallelAssembly((Function<? super ParallelFlowable, ? extends ParallelFlowable>) null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking((BooleanSupplier) null);
    }

    public static void setComputationSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f59350y) {
            f59332g = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setErrorHandler(Consumer<? super Throwable> consumer) {
        if (!f59350y) {
            f59326a = consumer;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitComputationSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f59350y) {
            f59328c = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitIoSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f59350y) {
            f59330e = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitNewThreadSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f59350y) {
            f59331f = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitSingleSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> function) {
        if (!f59350y) {
            f59329d = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setIoSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f59350y) {
            f59334i = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setNewThreadSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f59350y) {
            f59335j = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setScheduleHandler(Function<? super Runnable, ? extends Runnable> function) {
        if (!f59350y) {
            f59327b = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setSingleSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> function) {
        if (!f59350y) {
            f59333h = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    /* renamed from: a */
    static void m41885a() {
        f59350y = false;
    }

    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return f59342q;
    }

    public static BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> getOnCompletableSubscribe() {
        return f59348w;
    }

    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return f59336k;
    }

    public static Function<? super ConnectableFlowable, ? extends ConnectableFlowable> getOnConnectableFlowableAssembly() {
        return f59337l;
    }

    public static BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> getOnFlowableSubscribe() {
        return f59344s;
    }

    public static BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> getOnMaybeSubscribe() {
        return f59345t;
    }

    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return f59340o;
    }

    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return f59341p;
    }

    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return f59347v;
    }

    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return f59338m;
    }

    public static Function<? super ConnectableObservable, ? extends ConnectableObservable> getOnConnectableObservableAssembly() {
        return f59339n;
    }

    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return f59346u;
    }

    public static void setOnCompletableAssembly(Function<? super Completable, ? extends Completable> function) {
        if (!f59350y) {
            f59342q = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableSubscribe(BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction) {
        if (!f59350y) {
            f59348w = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableAssembly(Function<? super Flowable, ? extends Flowable> function) {
        if (!f59350y) {
            f59336k = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeAssembly(Function<? super Maybe, ? extends Maybe> function) {
        if (!f59350y) {
            f59340o = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableFlowableAssembly(Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function) {
        if (!f59350y) {
            f59337l = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableSubscribe(BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction) {
        if (!f59350y) {
            f59344s = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeSubscribe(BiFunction<? super Maybe, MaybeObserver, ? extends MaybeObserver> biFunction) {
        if (!f59350y) {
            f59345t = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableAssembly(Function<? super Observable, ? extends Observable> function) {
        if (!f59350y) {
            f59338m = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableObservableAssembly(Function<? super ConnectableObservable, ? extends ConnectableObservable> function) {
        if (!f59350y) {
            f59339n = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableSubscribe(BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction) {
        if (!f59350y) {
            f59346u = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleAssembly(Function<? super Single, ? extends Single> function) {
        if (!f59350y) {
            f59341p = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleSubscribe(BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction) {
        if (!f59350y) {
            f59347v = biFunction;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static <T> Subscriber<? super T> onSubscribe(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> biFunction = f59344s;
        return biFunction != null ? (Subscriber) m41883a(biFunction, flowable, subscriber) : subscriber;
    }

    public static <T> Observer<? super T> onSubscribe(Observable<T> observable, Observer<? super T> observer) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> biFunction = f59346u;
        return biFunction != null ? (Observer) m41883a(biFunction, observable, observer) : observer;
    }

    public static <T> SingleObserver<? super T> onSubscribe(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> biFunction = f59347v;
        return biFunction != null ? (SingleObserver) m41883a(biFunction, single, singleObserver) : singleObserver;
    }

    public static CompletableObserver onSubscribe(Completable completable, CompletableObserver completableObserver) {
        BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> biFunction = f59348w;
        return biFunction != null ? (CompletableObserver) m41883a(biFunction, completable, completableObserver) : completableObserver;
    }

    public static <T> MaybeObserver<? super T> onSubscribe(Maybe<T> maybe, MaybeObserver<? super T> maybeObserver) {
        BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> biFunction = f59345t;
        return biFunction != null ? (MaybeObserver) m41883a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    public static <T> Maybe<T> onAssembly(Maybe<T> maybe) {
        Function<? super Maybe, ? extends Maybe> function = f59340o;
        return function != null ? (Maybe) m41884a(function, maybe) : maybe;
    }

    public static <T> Flowable<T> onAssembly(Flowable<T> flowable) {
        Function<? super Flowable, ? extends Flowable> function = f59336k;
        return function != null ? (Flowable) m41884a(function, flowable) : flowable;
    }

    public static <T> ConnectableFlowable<T> onAssembly(ConnectableFlowable<T> connectableFlowable) {
        Function<? super ConnectableFlowable, ? extends ConnectableFlowable> function = f59337l;
        return function != null ? (ConnectableFlowable) m41884a(function, connectableFlowable) : connectableFlowable;
    }

    public static <T> Observable<T> onAssembly(Observable<T> observable) {
        Function<? super Observable, ? extends Observable> function = f59338m;
        return function != null ? (Observable) m41884a(function, observable) : observable;
    }

    public static <T> ConnectableObservable<T> onAssembly(ConnectableObservable<T> connectableObservable) {
        Function<? super ConnectableObservable, ? extends ConnectableObservable> function = f59339n;
        return function != null ? (ConnectableObservable) m41884a(function, connectableObservable) : connectableObservable;
    }

    public static <T> Single<T> onAssembly(Single<T> single) {
        Function<? super Single, ? extends Single> function = f59341p;
        return function != null ? (Single) m41884a(function, single) : single;
    }

    public static Completable onAssembly(Completable completable) {
        Function<? super Completable, ? extends Completable> function = f59342q;
        return function != null ? (Completable) m41884a(function, completable) : completable;
    }

    public static void setOnParallelAssembly(Function<? super ParallelFlowable, ? extends ParallelFlowable> function) {
        if (!f59350y) {
            f59343r = function;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static Function<? super ParallelFlowable, ? extends ParallelFlowable> getOnParallelAssembly() {
        return f59343r;
    }

    public static <T> ParallelFlowable<T> onAssembly(ParallelFlowable<T> parallelFlowable) {
        Function<? super ParallelFlowable, ? extends ParallelFlowable> function = f59343r;
        return function != null ? (ParallelFlowable) m41884a(function, parallelFlowable) : parallelFlowable;
    }

    public static boolean onBeforeBlocking() {
        BooleanSupplier booleanSupplier = f59349x;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.getAsBoolean();
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    public static void setOnBeforeBlocking(BooleanSupplier booleanSupplier) {
        if (!f59350y) {
            f59349x = booleanSupplier;
            return;
        }
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static BooleanSupplier getOnBeforeBlocking() {
        return f59349x;
    }

    public static Scheduler createComputationScheduler(ThreadFactory threadFactory) {
        return new ComputationScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    public static Scheduler createIoScheduler(ThreadFactory threadFactory) {
        return new IoScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    public static Scheduler createNewThreadScheduler(ThreadFactory threadFactory) {
        return new NewThreadScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    public static Scheduler createSingleScheduler(ThreadFactory threadFactory) {
        return new SingleScheduler((ThreadFactory) ObjectHelper.requireNonNull(threadFactory, "threadFactory is null"));
    }

    /* renamed from: a */
    static <T, R> R m41884a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: a */
    static <T, U, R> R m41883a(BiFunction<T, U, R> biFunction, T t, U u) {
        try {
            return biFunction.apply(t, u);
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: a */
    static Scheduler m41882a(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.requireNonNull(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw ExceptionHelper.wrapOrThrow(th);
        }
    }

    /* renamed from: a */
    static Scheduler m41881a(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.requireNonNull(m41884a(function, callable), "Scheduler Callable result can't be null");
    }

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }
}
