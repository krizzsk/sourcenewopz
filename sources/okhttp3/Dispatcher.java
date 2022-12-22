package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.RealCall;
import okhttp3.internal.C2434Util;

public final class Dispatcher {

    /* renamed from: a */
    static final /* synthetic */ boolean f5143a = (!Dispatcher.class.desiredAssertionStatus());

    /* renamed from: b */
    private int f5144b = 64;

    /* renamed from: c */
    private int f5145c = 5;
    @Nullable

    /* renamed from: d */
    private Runnable f5146d;
    @Nullable

    /* renamed from: e */
    private ExecutorService f5147e;

    /* renamed from: f */
    private final Deque<RealCall.AsyncCall> f5148f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<RealCall.AsyncCall> f5149g = new ArrayDeque();

    /* renamed from: h */
    private final Deque<RealCall> f5150h = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.f5147e = executorService;
    }

    public Dispatcher() {
    }

    public synchronized ExecutorService executorService() {
        if (this.f5147e == null) {
            this.f5147e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C2434Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.f5147e;
    }

    public void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f5144b = i;
            }
            m3344a();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public synchronized int getMaxRequests() {
        return this.f5144b;
    }

    public void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.f5145c = i;
            }
            m3344a();
            return;
        }
        throw new IllegalArgumentException("max < 1: " + i);
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.f5145c;
    }

    public synchronized void setIdleCallback(@Nullable Runnable runnable) {
        this.f5146d = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo24752a(RealCall.AsyncCall asyncCall) {
        synchronized (this) {
            this.f5148f.add(asyncCall);
        }
        m3344a();
    }

    public synchronized void cancelAll() {
        for (RealCall.AsyncCall asyncCall : this.f5148f) {
            asyncCall.get().cancel();
        }
        for (RealCall.AsyncCall asyncCall2 : this.f5149g) {
            asyncCall2.get().cancel();
        }
        for (RealCall cancel : this.f5150h) {
            cancel.cancel();
        }
    }

    /* renamed from: a */
    private boolean m3344a() {
        int i;
        boolean z;
        if (f5143a || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> it = this.f5148f.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RealCall.AsyncCall next = it.next();
                    if (this.f5149g.size() >= this.f5144b) {
                        break;
                    } else if (m3345c(next) < this.f5145c) {
                        it.remove();
                        arrayList.add(next);
                        this.f5149g.add(next);
                    }
                }
                z = runningCallsCount() > 0;
            }
            int size = arrayList.size();
            for (i = 0; i < size; i++) {
                ((RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
            }
            return z;
        }
        throw new AssertionError();
    }

    /* renamed from: c */
    private int m3345c(RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (RealCall.AsyncCall next : this.f5149g) {
            if (!next.get().f5230e && next.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo24753a(RealCall realCall) {
        this.f5150h.add(realCall);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo24754b(RealCall.AsyncCall asyncCall) {
        m3343a(this.f5149g, asyncCall);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo24755b(RealCall realCall) {
        m3343a(this.f5150h, realCall);
    }

    /* renamed from: a */
    private <T> void m3343a(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.f5146d;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!m3344a() && runnable != null) {
            runnable.run();
        }
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (RealCall.AsyncCall asyncCall : this.f5148f) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f5150h);
        for (RealCall.AsyncCall asyncCall : this.f5149g) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.f5148f.size();
    }

    public synchronized int runningCallsCount() {
        return this.f5149g.size() + this.f5150h.size();
    }
}
