package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;
import java.util.Date;
import java.util.List;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.Query */
public class Query<T> extends C4232c<T> {

    /* renamed from: a */
    private final QueryData<T> f9732a;

    public /* bridge */ /* synthetic */ void setLimit(int i) {
        super.setLimit(i);
    }

    public /* bridge */ /* synthetic */ void setOffset(int i) {
        super.setOffset(i);
    }

    public /* bridge */ /* synthetic */ void setParameter(int i, Boolean bool) {
        super.setParameter(i, bool);
    }

    public /* bridge */ /* synthetic */ void setParameter(int i, Object obj) {
        super.setParameter(i, obj);
    }

    public /* bridge */ /* synthetic */ void setParameter(int i, Date date) {
        super.setParameter(i, date);
    }

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.Query$QueryData */
    private static final class QueryData<T2> extends C4231b<T2, Query<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr, int i, int i2) {
            super(abstractDao, str, strArr);
            this.limitPosition = i;
            this.offsetPosition = i2;
        }

        /* access modifiers changed from: protected */
        public Query<T2> createQuery() {
            return new Query(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> Query<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return m6573a(abstractDao, str, objArr, -1, -1);
    }

    /* renamed from: a */
    static <T2> Query<T2> m6573a(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i, int i2) {
        return (Query) new QueryData(abstractDao, str, toStringArray(objArr), i, i2).forCurrentThread();
    }

    private Query(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr, i, i2);
        this.f9732a = queryData;
    }

    public Query<T> forCurrentThread() {
        return (Query) this.f9732a.forCurrentThread(this);
    }

    public List<T> list() {
        checkThread();
        return this.daoAccess.loadAllAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public LazyList<T> listLazy() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), true);
    }

    public LazyList<T> listLazyUncached() {
        checkThread();
        return new LazyList<>(this.daoAccess, this.dao.getDatabase().rawQuery(this.sql, this.parameters), false);
    }

    public CloseableListIterator<T> listIterator() {
        return listLazyUncached().listIteratorAutoClose();
    }

    public T unique() {
        checkThread();
        return this.daoAccess.loadUniqueAndCloseCursor(this.dao.getDatabase().rawQuery(this.sql, this.parameters));
    }

    public T uniqueOrThrow() {
        T unique = unique();
        if (unique != null) {
            return unique;
        }
        throw new DaoException("No entity found for query");
    }
}
