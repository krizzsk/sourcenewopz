package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import android.os.Process;
import android.util.SparseArray;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.C4230a;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.b */
/* compiled from: AbstractQueryData */
abstract class C4231b<T, Q extends C4230a<T>> {
    final AbstractDao<T, ?> dao;
    final String[] initialValues;
    final SparseArray<WeakReference<Q>> queriesForThreads = new SparseArray<>();
    final String sql;

    /* access modifiers changed from: protected */
    public abstract Q createQuery();

    C4231b(AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        this.dao = abstractDao;
        this.sql = str;
        this.initialValues = strArr;
    }

    /* access modifiers changed from: package-private */
    public Q forCurrentThread(Q q) {
        if (Thread.currentThread() != q.ownerThread) {
            return forCurrentThread();
        }
        System.arraycopy(this.initialValues, 0, q.parameters, 0, this.initialValues.length);
        return q;
    }

    /* access modifiers changed from: package-private */
    public Q forCurrentThread() {
        Q q;
        int myTid = Process.myTid();
        if (myTid == 0) {
            long id = Thread.currentThread().getId();
            if (id < 0 || id > 2147483647L) {
                throw new RuntimeException("Cannot handle thread ID: " + id);
            }
            myTid = (int) id;
        }
        synchronized (this.queriesForThreads) {
            WeakReference weakReference = this.queriesForThreads.get(myTid);
            q = weakReference != null ? (C4230a) weakReference.get() : null;
            if (q == null) {
                mo43801gc();
                q = createQuery();
                this.queriesForThreads.put(myTid, new WeakReference(q));
            } else {
                System.arraycopy(this.initialValues, 0, q.parameters, 0, this.initialValues.length);
            }
        }
        return q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gc */
    public void mo43801gc() {
        synchronized (this.queriesForThreads) {
            for (int size = this.queriesForThreads.size() - 1; size >= 0; size--) {
                if (this.queriesForThreads.valueAt(size).get() == null) {
                    this.queriesForThreads.remove(this.queriesForThreads.keyAt(size));
                }
            }
        }
    }
}
