package com.didi.beatles.p099im.thirty.greenrobot.dao;

import com.didi.beatles.p099im.thirty.greenrobot.dao.async.AsyncSession;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.QueryBuilder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.AbstractDaoSession */
public class AbstractDaoSession {

    /* renamed from: a */
    private final Database f9657a;

    /* renamed from: b */
    private final Map<Class<?>, AbstractDao<?, ?>> f9658b = new HashMap();

    public AbstractDaoSession(Database database) {
        this.f9657a = database;
    }

    /* access modifiers changed from: protected */
    public <T> void registerDao(Class<T> cls, AbstractDao<T, ?> abstractDao) {
        this.f9658b.put(cls, abstractDao);
    }

    public <T> long insert(T t) {
        return getDao(t.getClass()).insert(t);
    }

    public <T> long insertOrReplace(T t) {
        return getDao(t.getClass()).insertOrReplace(t);
    }

    public <T> void refresh(T t) {
        getDao(t.getClass()).refresh(t);
    }

    public <T> void update(T t) {
        getDao(t.getClass()).update(t);
    }

    public <T> void delete(T t) {
        getDao(t.getClass()).delete(t);
    }

    public <T> void deleteAll(Class<T> cls) {
        getDao(cls).deleteAll();
    }

    public <T, K> T load(Class<T> cls, K k) {
        return getDao(cls).load(k);
    }

    public <T, K> List<T> loadAll(Class<T> cls) {
        return getDao(cls).loadAll();
    }

    public <T, K> List<T> queryRaw(Class<T> cls, String str, String... strArr) {
        return getDao(cls).queryRaw(str, strArr);
    }

    public <T> QueryBuilder<T> queryBuilder(Class<T> cls) {
        return getDao(cls).queryBuilder();
    }

    public AbstractDao<?, ?> getDao(Class<? extends Object> cls) {
        AbstractDao<?, ?> abstractDao = this.f9658b.get(cls);
        if (abstractDao != null) {
            return abstractDao;
        }
        throw new DaoException("No DAO registered for " + cls);
    }

    public void runInTx(Runnable runnable) {
        this.f9657a.beginTransaction();
        try {
            runnable.run();
            this.f9657a.setTransactionSuccessful();
        } finally {
            this.f9657a.endTransaction();
        }
    }

    public <V> V callInTx(Callable<V> callable) throws Exception {
        this.f9657a.beginTransaction();
        try {
            V call = callable.call();
            this.f9657a.setTransactionSuccessful();
            return call;
        } finally {
            this.f9657a.endTransaction();
        }
    }

    public <V> V callInTxNoException(Callable<V> callable) {
        this.f9657a.beginTransaction();
        try {
            V call = callable.call();
            this.f9657a.setTransactionSuccessful();
            this.f9657a.endTransaction();
            return call;
        } catch (Exception e) {
            throw new DaoException("Callable failed", e);
        } catch (Throwable th) {
            this.f9657a.endTransaction();
            throw th;
        }
    }

    public Database getDatabase() {
        return this.f9657a;
    }

    public Collection<AbstractDao<?, ?>> getAllDaos() {
        return Collections.unmodifiableCollection(this.f9658b.values());
    }

    public AsyncSession startAsyncSession() {
        return new AsyncSession(this);
    }
}
