package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import android.database.Cursor;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.CountQuery */
public class CountQuery<T> extends C4230a<T> {

    /* renamed from: a */
    private final QueryData<T> f9717a;

    public /* bridge */ /* synthetic */ void setParameter(int i, Object obj) {
        super.setParameter(i, obj);
    }

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.CountQuery$QueryData */
    private static final class QueryData<T2> extends C4231b<T2, CountQuery<T2>> {
        private QueryData(AbstractDao<T2, ?> abstractDao, String str, String[] strArr) {
            super(abstractDao, str, strArr);
        }

        /* access modifiers changed from: protected */
        public CountQuery<T2> createQuery() {
            return new CountQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone());
        }
    }

    /* renamed from: a */
    static <T2> CountQuery<T2> m6568a(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return (CountQuery) new QueryData(abstractDao, str, toStringArray(objArr)).forCurrentThread();
    }

    private CountQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr) {
        super(abstractDao, str, strArr);
        this.f9717a = queryData;
    }

    public CountQuery<T> forCurrentThread() {
        return (CountQuery) this.f9717a.forCurrentThread(this);
    }

    public long count() {
        checkThread();
        Cursor rawQuery = this.dao.getDatabase().rawQuery(this.sql, this.parameters);
        try {
            if (!rawQuery.moveToNext()) {
                throw new DaoException("No result for count");
            } else if (!rawQuery.isLast()) {
                throw new DaoException("Unexpected row count: " + rawQuery.getCount());
            } else if (rawQuery.getColumnCount() == 1) {
                return rawQuery.getLong(0);
            } else {
                throw new DaoException("Unexpected column count: " + rawQuery.getColumnCount());
            }
        } finally {
            rawQuery.close();
        }
    }
}
