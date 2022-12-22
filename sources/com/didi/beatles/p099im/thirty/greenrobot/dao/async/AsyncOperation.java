package com.didi.beatles.p099im.thirty.greenrobot.dao.async;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation */
public class AsyncOperation {
    public static final int FLAG_MERGE_TX = 1;
    public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
    public static final int FLAG_TRACK_CREATOR_STACKTRACE = 4;

    /* renamed from: a */
    final OperationType f9661a;

    /* renamed from: b */
    final AbstractDao<Object, Object> f9662b;

    /* renamed from: c */
    final Object f9663c;

    /* renamed from: d */
    final int f9664d;

    /* renamed from: e */
    volatile long f9665e;

    /* renamed from: f */
    volatile long f9666f;

    /* renamed from: g */
    volatile Throwable f9667g;

    /* renamed from: h */
    final Exception f9668h;

    /* renamed from: i */
    volatile Object f9669i;

    /* renamed from: j */
    volatile int f9670j;

    /* renamed from: k */
    int f9671k;

    /* renamed from: l */
    private final Database f9672l;

    /* renamed from: m */
    private volatile boolean f9673m;

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncOperation$OperationType */
    public enum OperationType {
        Insert,
        InsertInTxIterable,
        InsertInTxArray,
        InsertOrReplace,
        InsertOrReplaceInTxIterable,
        InsertOrReplaceInTxArray,
        Update,
        UpdateInTxIterable,
        UpdateInTxArray,
        Delete,
        DeleteInTxIterable,
        DeleteInTxArray,
        DeleteByKey,
        DeleteAll,
        TransactionRunnable,
        TransactionCallable,
        QueryList,
        QueryUnique,
        Load,
        LoadAll,
        Count,
        Refresh
    }

    AsyncOperation(OperationType operationType, AbstractDao<?, ?> abstractDao, Database database, Object obj, int i) {
        this.f9661a = operationType;
        this.f9664d = i;
        this.f9662b = abstractDao;
        this.f9672l = database;
        this.f9663c = obj;
        this.f9668h = (i & 4) != 0 ? new Exception("AsyncOperation was created here") : null;
    }

    public Throwable getThrowable() {
        return this.f9667g;
    }

    public void setThrowable(Throwable th) {
        this.f9667g = th;
    }

    public OperationType getType() {
        return this.f9661a;
    }

    public Object getParameter() {
        return this.f9663c;
    }

    public synchronized Object getResult() {
        if (!this.f9673m) {
            waitForCompletion();
        }
        if (this.f9667g == null) {
        } else {
            throw new AsyncDaoException(this, this.f9667g);
        }
        return this.f9669i;
    }

    public boolean isMergeTx() {
        return (this.f9664d & 1) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Database mo43494a() {
        Database database = this.f9672l;
        return database != null ? database : this.f9662b.getDatabase();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo43495a(AsyncOperation asyncOperation) {
        return asyncOperation != null && isMergeTx() && asyncOperation.isMergeTx() && mo43494a() == asyncOperation.mo43494a();
    }

    public long getTimeStarted() {
        return this.f9665e;
    }

    public long getTimeCompleted() {
        return this.f9666f;
    }

    public long getDuration() {
        if (this.f9666f != 0) {
            return this.f9666f - this.f9665e;
        }
        throw new DaoException("This operation did not yet complete");
    }

    public boolean isFailed() {
        return this.f9667g != null;
    }

    public boolean isCompleted() {
        return this.f9673m;
    }

    public synchronized Object waitForCompletion() {
        while (!this.f9673m) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for operation to complete", e);
            }
        }
        return this.f9669i;
    }

    public synchronized boolean waitForCompletion(int i) {
        if (!this.f9673m) {
            try {
                wait((long) i);
            } catch (InterruptedException e) {
                throw new DaoException("Interrupted while waiting for operation to complete", e);
            }
        }
        return this.f9673m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo43496b() {
        this.f9673m = true;
        notifyAll();
    }

    public boolean isCompletedSucessfully() {
        return this.f9673m && this.f9667g == null;
    }

    public int getMergedOperationsCount() {
        return this.f9670j;
    }

    public int getSequenceNumber() {
        return this.f9671k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo43497c() {
        this.f9665e = 0;
        this.f9666f = 0;
        this.f9673m = false;
        this.f9667g = null;
        this.f9669i = null;
        this.f9670j = 0;
    }

    public Exception getCreatorStacktrace() {
        return this.f9668h;
    }
}
