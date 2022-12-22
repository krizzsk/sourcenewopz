package com.didi.beatles.p099im.thirty.greenrobot.dao.async;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoLog;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.Query;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.a */
/* compiled from: AsyncOperationExecutor */
class C4225a implements Handler.Callback, Runnable {

    /* renamed from: a */
    private static ExecutorService f9678a = Executors.newCachedThreadPool();

    /* renamed from: b */
    private final BlockingQueue<AsyncOperation> f9679b = new LinkedBlockingQueue();

    /* renamed from: c */
    private volatile boolean f9680c;

    /* renamed from: d */
    private volatile int f9681d = 50;

    /* renamed from: e */
    private volatile AsyncOperationListener f9682e;

    /* renamed from: f */
    private volatile AsyncOperationListener f9683f;

    /* renamed from: g */
    private volatile int f9684g = 50;

    /* renamed from: h */
    private int f9685h;

    /* renamed from: i */
    private int f9686i;

    /* renamed from: j */
    private Handler f9687j;

    /* renamed from: k */
    private int f9688k;

    C4225a() {
    }

    /* renamed from: a */
    public void mo43575a(AsyncOperation asyncOperation) {
        synchronized (this) {
            int i = this.f9688k + 1;
            this.f9688k = i;
            asyncOperation.f9671k = i;
            this.f9679b.add(asyncOperation);
            this.f9685h++;
            if (!this.f9680c) {
                this.f9680c = true;
                f9678a.execute(this);
            }
        }
    }

    /* renamed from: a */
    public int mo43573a() {
        return this.f9681d;
    }

    /* renamed from: a */
    public void mo43574a(int i) {
        this.f9681d = i;
    }

    /* renamed from: b */
    public int mo43577b() {
        return this.f9684g;
    }

    /* renamed from: b */
    public void mo43578b(int i) {
        this.f9684g = i;
    }

    /* renamed from: c */
    public AsyncOperationListener mo43580c() {
        return this.f9682e;
    }

    /* renamed from: a */
    public void mo43576a(AsyncOperationListener asyncOperationListener) {
        this.f9682e = asyncOperationListener;
    }

    /* renamed from: d */
    public AsyncOperationListener mo43582d() {
        return this.f9683f;
    }

    /* renamed from: b */
    public void mo43579b(AsyncOperationListener asyncOperationListener) {
        this.f9683f = asyncOperationListener;
    }

    /* renamed from: e */
    public synchronized boolean mo43583e() {
        return this.f9685h == this.f9686i;
    }

    /* renamed from: f */
    public synchronized void mo43584f() {
        while (!mo43583e()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
    }

    /* renamed from: c */
    public synchronized boolean mo43581c(int i) {
        if (!mo43583e()) {
            try {
                wait((long) i);
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for all operations to complete", e);
            }
        }
        return mo43583e();
    }

    public void run() {
        AsyncOperation poll;
        while (true) {
            try {
                AsyncOperation poll2 = this.f9679b.poll(1, TimeUnit.SECONDS);
                if (poll2 == null) {
                    synchronized (this) {
                        poll2 = (AsyncOperation) this.f9679b.poll();
                        if (poll2 == null) {
                            this.f9680c = false;
                            this.f9680c = false;
                            return;
                        }
                    }
                }
                if (!poll2.isMergeTx() || (poll = this.f9679b.poll((long) this.f9684g, TimeUnit.MILLISECONDS)) == null) {
                    m6551c(poll2);
                } else if (poll2.mo43495a(poll)) {
                    m6549a(poll2, poll);
                } else {
                    m6551c(poll2);
                    m6551c(poll);
                }
            } catch (InterruptedException e) {
                try {
                    DaoLog.m6533w(Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.f9680c = false;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        r4 = false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6549a(com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation r8, com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation r9) {
        /*
            r7 = this;
            java.lang.String r0 = "Async transaction could not be ended, success so far was: "
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r1.add(r8)
            r1.add(r9)
            com.didi.beatles.im.thirty.greenrobot.dao.database.Database r8 = r8.mo43494a()
            r8.beginTransaction()
            r9 = 0
            r2 = 0
        L_0x0016:
            int r3 = r1.size()     // Catch:{ all -> 0x00b5 }
            r4 = 1
            if (r2 >= r3) goto L_0x0063
            java.lang.Object r3 = r1.get(r2)     // Catch:{ all -> 0x00b5 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r3 = (com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation) r3     // Catch:{ all -> 0x00b5 }
            r7.m6552d(r3)     // Catch:{ all -> 0x00b5 }
            boolean r5 = r3.isFailed()     // Catch:{ all -> 0x00b5 }
            if (r5 == 0) goto L_0x002d
            goto L_0x0063
        L_0x002d:
            int r5 = r1.size()     // Catch:{ all -> 0x00b5 }
            int r5 = r5 - r4
            if (r2 != r5) goto L_0x0060
            java.util.concurrent.BlockingQueue<com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation> r5 = r7.f9679b     // Catch:{ all -> 0x00b5 }
            java.lang.Object r5 = r5.peek()     // Catch:{ all -> 0x00b5 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r5 = (com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation) r5     // Catch:{ all -> 0x00b5 }
            int r6 = r7.f9681d     // Catch:{ all -> 0x00b5 }
            if (r2 >= r6) goto L_0x005c
            boolean r3 = r3.mo43495a(r5)     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x005c
            java.util.concurrent.BlockingQueue<com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation> r3 = r7.f9679b     // Catch:{ all -> 0x00b5 }
            java.lang.Object r3 = r3.remove()     // Catch:{ all -> 0x00b5 }
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r3 = (com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation) r3     // Catch:{ all -> 0x00b5 }
            if (r3 != r5) goto L_0x0054
            r1.add(r3)     // Catch:{ all -> 0x00b5 }
            goto L_0x0060
        L_0x0054:
            com.didi.beatles.im.thirty.greenrobot.dao.DaoException r1 = new com.didi.beatles.im.thirty.greenrobot.dao.DaoException     // Catch:{ all -> 0x00b5 }
            java.lang.String r2 = "Internal error: peeked op did not match removed op"
            r1.<init>((java.lang.String) r2)     // Catch:{ all -> 0x00b5 }
            throw r1     // Catch:{ all -> 0x00b5 }
        L_0x005c:
            r8.setTransactionSuccessful()     // Catch:{ all -> 0x00b5 }
            goto L_0x0064
        L_0x0060:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0063:
            r4 = 0
        L_0x0064:
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x0069 }
            r9 = r4
            goto L_0x007c
        L_0x0069:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
            com.didi.beatles.p099im.thirty.greenrobot.dao.DaoLog.m6529i(r0, r8)
        L_0x007c:
            if (r9 == 0) goto L_0x0098
            int r8 = r1.size()
            java.util.Iterator r9 = r1.iterator()
        L_0x0086:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r9.next()
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r0 = (com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation) r0
            r0.f9670j = r8
            r7.m6550b((com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation) r0)
            goto L_0x0086
        L_0x0098:
            java.lang.String r8 = "Reverted merged transaction because one of the operations failed. Executing operations one by one instead..."
            com.didi.beatles.p099im.thirty.greenrobot.dao.DaoLog.m6528i(r8)
            java.util.Iterator r8 = r1.iterator()
        L_0x00a1:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00b4
            java.lang.Object r9 = r8.next()
            com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation r9 = (com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation) r9
            r9.mo43497c()
            r7.m6551c((com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation) r9)
            goto L_0x00a1
        L_0x00b4:
            return
        L_0x00b5:
            r1 = move-exception
            r8.endTransaction()     // Catch:{ RuntimeException -> 0x00ba }
            goto L_0x00cd
        L_0x00ba:
            r8 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            com.didi.beatles.p099im.thirty.greenrobot.dao.DaoLog.m6529i(r9, r8)
        L_0x00cd:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.thirty.greenrobot.dao.async.C4225a.m6549a(com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation, com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation):void");
    }

    /* renamed from: b */
    private void m6550b(AsyncOperation asyncOperation) {
        asyncOperation.mo43496b();
        AsyncOperationListener asyncOperationListener = this.f9682e;
        if (asyncOperationListener != null) {
            asyncOperationListener.onAsyncOperationCompleted(asyncOperation);
        }
        if (this.f9683f != null) {
            if (this.f9687j == null) {
                this.f9687j = new Handler(Looper.getMainLooper(), this);
            }
            this.f9687j.sendMessage(this.f9687j.obtainMessage(1, asyncOperation));
        }
        synchronized (this) {
            int i = this.f9686i + 1;
            this.f9686i = i;
            if (i == this.f9685h) {
                notifyAll();
            }
        }
    }

    /* renamed from: c */
    private void m6551c(AsyncOperation asyncOperation) {
        m6552d(asyncOperation);
        m6550b(asyncOperation);
    }

    /* renamed from: d */
    private void m6552d(AsyncOperation asyncOperation) {
        asyncOperation.f9665e = System.currentTimeMillis();
        try {
            switch (AsyncOperationExecutor$1.f9674xb6843a26[asyncOperation.f9661a.ordinal()]) {
                case 1:
                    asyncOperation.f9662b.delete(asyncOperation.f9663c);
                    break;
                case 2:
                    asyncOperation.f9662b.deleteInTx((Iterable) asyncOperation.f9663c);
                    break;
                case 3:
                    asyncOperation.f9662b.deleteInTx((T[]) (Object[]) asyncOperation.f9663c);
                    break;
                case 4:
                    asyncOperation.f9662b.insert(asyncOperation.f9663c);
                    break;
                case 5:
                    asyncOperation.f9662b.insertInTx((Iterable) asyncOperation.f9663c);
                    break;
                case 6:
                    asyncOperation.f9662b.insertInTx((T[]) (Object[]) asyncOperation.f9663c);
                    break;
                case 7:
                    asyncOperation.f9662b.insertOrReplace(asyncOperation.f9663c);
                    break;
                case 8:
                    asyncOperation.f9662b.insertOrReplaceInTx((Iterable) asyncOperation.f9663c);
                    break;
                case 9:
                    asyncOperation.f9662b.insertOrReplaceInTx((T[]) (Object[]) asyncOperation.f9663c);
                    break;
                case 10:
                    asyncOperation.f9662b.update(asyncOperation.f9663c);
                    break;
                case 11:
                    asyncOperation.f9662b.updateInTx((Iterable) asyncOperation.f9663c);
                    break;
                case 12:
                    asyncOperation.f9662b.updateInTx((T[]) (Object[]) asyncOperation.f9663c);
                    break;
                case 13:
                    m6553e(asyncOperation);
                    break;
                case 14:
                    m6554f(asyncOperation);
                    break;
                case 15:
                    asyncOperation.f9669i = ((Query) asyncOperation.f9663c).forCurrentThread().list();
                    break;
                case 16:
                    asyncOperation.f9669i = ((Query) asyncOperation.f9663c).forCurrentThread().unique();
                    break;
                case 17:
                    asyncOperation.f9662b.deleteByKey(asyncOperation.f9663c);
                    break;
                case 18:
                    asyncOperation.f9662b.deleteAll();
                    break;
                case 19:
                    asyncOperation.f9669i = asyncOperation.f9662b.load(asyncOperation.f9663c);
                    break;
                case 20:
                    asyncOperation.f9669i = asyncOperation.f9662b.loadAll();
                    break;
                case 21:
                    asyncOperation.f9669i = Long.valueOf(asyncOperation.f9662b.count());
                    break;
                case 22:
                    asyncOperation.f9662b.refresh(asyncOperation.f9663c);
                    break;
                default:
                    throw new DaoException("Unsupported operation: " + asyncOperation.f9661a);
            }
        } catch (Throwable th) {
            asyncOperation.f9667g = th;
        }
        asyncOperation.f9666f = System.currentTimeMillis();
    }

    /* renamed from: e */
    private void m6553e(AsyncOperation asyncOperation) {
        Database a = asyncOperation.mo43494a();
        a.beginTransaction();
        try {
            ((Runnable) asyncOperation.f9663c).run();
            a.setTransactionSuccessful();
        } finally {
            a.endTransaction();
        }
    }

    /* renamed from: f */
    private void m6554f(AsyncOperation asyncOperation) throws Exception {
        Database a = asyncOperation.mo43494a();
        a.beginTransaction();
        try {
            asyncOperation.f9669i = ((Callable) asyncOperation.f9663c).call();
            a.setTransactionSuccessful();
        } finally {
            a.endTransaction();
        }
    }

    public boolean handleMessage(Message message) {
        AsyncOperationListener asyncOperationListener = this.f9683f;
        if (asyncOperationListener == null) {
            return false;
        }
        asyncOperationListener.onAsyncOperationCompleted((AsyncOperation) message.obj);
        return false;
    }
}
