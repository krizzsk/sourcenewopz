package didihttp;

import didihttp.RealCall;
import didihttp.internal.C20747Util;
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

public final class Dispatcher {

    /* renamed from: a */
    private int f56425a = 64;

    /* renamed from: b */
    private int f56426b = 5;

    /* renamed from: c */
    private Runnable f56427c;

    /* renamed from: d */
    private ExecutorService f56428d;

    /* renamed from: e */
    private final Deque<RealCall.AsyncCall> f56429e = new ArrayDeque();

    /* renamed from: f */
    private final Deque<RealCall.AsyncCall> f56430f = new ArrayDeque();

    /* renamed from: g */
    private final Deque<RealCall> f56431g = new ArrayDeque();

    public Dispatcher(ExecutorService executorService) {
        this.f56428d = executorService;
    }

    public Dispatcher() {
    }

    public synchronized ExecutorService executorService() {
        if (this.f56428d == null) {
            this.f56428d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C20747Util.threadFactory("didiHttp Dispatcher#", false));
        }
        return this.f56428d;
    }

    public synchronized void setMaxRequests(int i) {
        if (i >= 1) {
            this.f56425a = i;
            m40603a();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    public synchronized int getMaxRequests() {
        return this.f56425a;
    }

    public synchronized void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            this.f56426b = i;
            m40603a();
        } else {
            throw new IllegalArgumentException("max < 1: " + i);
        }
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.f56426b;
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.f56427c = runnable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo169585a(RealCall.AsyncCall asyncCall) {
        if (this.f56430f.size() >= this.f56425a || m40605c(asyncCall) >= this.f56426b) {
            this.f56429e.add(asyncCall);
        } else {
            this.f56430f.add(asyncCall);
            executorService().execute(asyncCall);
        }
    }

    public synchronized void cancelAll() {
        for (RealCall.AsyncCall asyncCall : this.f56429e) {
            asyncCall.get().cancel();
        }
        for (RealCall.AsyncCall asyncCall2 : this.f56430f) {
            asyncCall2.get().cancel();
        }
        for (RealCall cancel : this.f56431g) {
            cancel.cancel();
        }
    }

    /* renamed from: a */
    private void m40603a() {
        if (this.f56430f.size() < this.f56425a && !this.f56429e.isEmpty()) {
            Iterator<RealCall.AsyncCall> it = this.f56429e.iterator();
            while (it.hasNext()) {
                RealCall.AsyncCall next = it.next();
                if (m40605c(next) < this.f56426b) {
                    it.remove();
                    this.f56430f.add(next);
                    executorService().execute(next);
                }
                if (this.f56430f.size() >= this.f56425a) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    private int m40605c(RealCall.AsyncCall asyncCall) {
        int i = 0;
        for (RealCall.AsyncCall host : this.f56430f) {
            if (host.host().equals(asyncCall.host())) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo169586a(RealCall realCall) {
        this.f56431g.add(realCall);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo169587b(RealCall.AsyncCall asyncCall) {
        m40604a(this.f56430f, asyncCall, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo169588b(RealCall realCall) {
        m40604a(this.f56431g, realCall, false);
    }

    /* renamed from: a */
    private <T> void m40604a(Deque<T> deque, T t, boolean z) {
        int runningCallsCount;
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                if (z) {
                    m40603a();
                }
                runningCallsCount = runningCallsCount();
                runnable = this.f56427c;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (runningCallsCount == 0 && runnable != null) {
            runnable.run();
        }
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (RealCall.AsyncCall asyncCall : this.f56429e) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f56431g);
        for (RealCall.AsyncCall asyncCall : this.f56430f) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.f56429e.size();
    }

    public synchronized int runningCallsCount() {
        return this.f56430f.size() + this.f56431g.size();
    }
}
