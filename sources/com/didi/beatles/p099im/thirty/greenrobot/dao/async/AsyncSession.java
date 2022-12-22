package com.didi.beatles.p099im.thirty.greenrobot.dao.async;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDaoSession;
import com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncOperation;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.Query;
import java.util.concurrent.Callable;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.async.AsyncSession */
public class AsyncSession {

    /* renamed from: a */
    private final AbstractDaoSession f9675a;

    /* renamed from: b */
    private final C4225a f9676b = new C4225a();

    /* renamed from: c */
    private int f9677c;

    public AsyncSession(AbstractDaoSession abstractDaoSession) {
        this.f9675a = abstractDaoSession;
    }

    public int getMaxOperationCountToMerge() {
        return this.f9676b.mo43573a();
    }

    public void setMaxOperationCountToMerge(int i) {
        this.f9676b.mo43574a(i);
    }

    public int getWaitForMergeMillis() {
        return this.f9676b.mo43577b();
    }

    public void setWaitForMergeMillis(int i) {
        this.f9676b.mo43578b(i);
    }

    public AsyncOperationListener getListener() {
        return this.f9676b.mo43580c();
    }

    public void setListener(AsyncOperationListener asyncOperationListener) {
        this.f9676b.mo43576a(asyncOperationListener);
    }

    public AsyncOperationListener getListenerMainThread() {
        return this.f9676b.mo43582d();
    }

    public void setListenerMainThread(AsyncOperationListener asyncOperationListener) {
        this.f9676b.mo43579b(asyncOperationListener);
    }

    public boolean isCompleted() {
        return this.f9676b.mo43583e();
    }

    public void waitForCompletion() {
        this.f9676b.mo43584f();
    }

    public boolean waitForCompletion(int i) {
        return this.f9676b.mo43581c(i);
    }

    public AsyncOperation insert(Object obj) {
        return insert(obj, 0);
    }

    public AsyncOperation insert(Object obj, int i) {
        return m6548b(AsyncOperation.OperationType.Insert, obj, i);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, E... eArr) {
        return insertInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, int i, E... eArr) {
        return m6546a(AsyncOperation.OperationType.InsertInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, Iterable<E> iterable) {
        return insertInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation insertInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m6546a(AsyncOperation.OperationType.InsertInTxIterable, cls, iterable, i);
    }

    public AsyncOperation insertOrReplace(Object obj) {
        return insertOrReplace(obj, 0);
    }

    public AsyncOperation insertOrReplace(Object obj, int i) {
        return m6548b(AsyncOperation.OperationType.InsertOrReplace, obj, i);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, E... eArr) {
        return insertOrReplaceInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, int i, E... eArr) {
        return m6546a(AsyncOperation.OperationType.InsertOrReplaceInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, Iterable<E> iterable) {
        return insertOrReplaceInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation insertOrReplaceInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m6546a(AsyncOperation.OperationType.InsertOrReplaceInTxIterable, cls, iterable, i);
    }

    public AsyncOperation update(Object obj) {
        return update(obj, 0);
    }

    public AsyncOperation update(Object obj, int i) {
        return m6548b(AsyncOperation.OperationType.Update, obj, i);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, E... eArr) {
        return updateInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, int i, E... eArr) {
        return m6546a(AsyncOperation.OperationType.UpdateInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, Iterable<E> iterable) {
        return updateInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation updateInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m6546a(AsyncOperation.OperationType.UpdateInTxIterable, cls, iterable, i);
    }

    public AsyncOperation delete(Object obj) {
        return delete(obj, 0);
    }

    public AsyncOperation delete(Object obj, int i) {
        return m6548b(AsyncOperation.OperationType.Delete, obj, i);
    }

    public AsyncOperation deleteByKey(Object obj) {
        return deleteByKey(obj, 0);
    }

    public AsyncOperation deleteByKey(Object obj, int i) {
        return m6548b(AsyncOperation.OperationType.DeleteByKey, obj, i);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, E... eArr) {
        return deleteInTx(cls, 0, eArr);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, int i, E... eArr) {
        return m6546a(AsyncOperation.OperationType.DeleteInTxArray, cls, eArr, i);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, Iterable<E> iterable) {
        return deleteInTx(cls, iterable, 0);
    }

    public <E> AsyncOperation deleteInTx(Class<E> cls, Iterable<E> iterable, int i) {
        return m6546a(AsyncOperation.OperationType.DeleteInTxIterable, cls, iterable, i);
    }

    public <E> AsyncOperation deleteAll(Class<E> cls) {
        return deleteAll(cls, 0);
    }

    public <E> AsyncOperation deleteAll(Class<E> cls, int i) {
        return m6546a(AsyncOperation.OperationType.DeleteAll, cls, (Object) null, i);
    }

    public AsyncOperation runInTx(Runnable runnable) {
        return runInTx(runnable, 0);
    }

    public AsyncOperation runInTx(Runnable runnable, int i) {
        return m6547a(AsyncOperation.OperationType.TransactionRunnable, runnable, i);
    }

    public AsyncOperation callInTx(Callable<?> callable) {
        return callInTx(callable, 0);
    }

    public AsyncOperation callInTx(Callable<?> callable, int i) {
        return m6547a(AsyncOperation.OperationType.TransactionCallable, callable, i);
    }

    public AsyncOperation queryList(Query<?> query) {
        return queryList(query, 0);
    }

    public AsyncOperation queryList(Query<?> query, int i) {
        return m6547a(AsyncOperation.OperationType.QueryList, query, i);
    }

    public AsyncOperation queryUnique(Query<?> query) {
        return queryUnique(query, 0);
    }

    public AsyncOperation queryUnique(Query<?> query, int i) {
        return m6547a(AsyncOperation.OperationType.QueryUnique, query, i);
    }

    public AsyncOperation load(Class<?> cls, Object obj) {
        return load(cls, obj, 0);
    }

    public AsyncOperation load(Class<?> cls, Object obj, int i) {
        return m6546a(AsyncOperation.OperationType.Load, cls, obj, i);
    }

    public AsyncOperation loadAll(Class<?> cls) {
        return loadAll(cls, 0);
    }

    public AsyncOperation loadAll(Class<?> cls, int i) {
        return m6546a(AsyncOperation.OperationType.LoadAll, cls, (Object) null, i);
    }

    public AsyncOperation count(Class<?> cls) {
        return count(cls, 0);
    }

    public AsyncOperation count(Class<?> cls, int i) {
        return m6546a(AsyncOperation.OperationType.Count, cls, (Object) null, i);
    }

    public AsyncOperation refresh(Object obj) {
        return refresh(obj, 0);
    }

    public AsyncOperation refresh(Object obj, int i) {
        return m6548b(AsyncOperation.OperationType.Refresh, obj, i);
    }

    /* renamed from: a */
    private AsyncOperation m6547a(AsyncOperation.OperationType operationType, Object obj, int i) {
        AsyncOperation asyncOperation = new AsyncOperation(operationType, (AbstractDao<?, ?>) null, this.f9675a.getDatabase(), obj, i | this.f9677c);
        this.f9676b.mo43575a(asyncOperation);
        return asyncOperation;
    }

    /* renamed from: b */
    private AsyncOperation m6548b(AsyncOperation.OperationType operationType, Object obj, int i) {
        return m6546a(operationType, obj.getClass(), obj, i);
    }

    /* renamed from: a */
    private <E> AsyncOperation m6546a(AsyncOperation.OperationType operationType, Class<E> cls, Object obj, int i) {
        AsyncOperation asyncOperation = new AsyncOperation(operationType, this.f9675a.getDao(cls), (Database) null, obj, i | this.f9677c);
        this.f9676b.mo43575a(asyncOperation);
        return asyncOperation;
    }

    public int getSessionFlags() {
        return this.f9677c;
    }

    public void setSessionFlags(int i) {
        this.f9677c = i;
    }
}
