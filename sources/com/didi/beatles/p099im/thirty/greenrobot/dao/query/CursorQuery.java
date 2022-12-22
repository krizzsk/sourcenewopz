package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import android.database.Cursor;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import java.util.Date;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.CursorQuery */
public class CursorQuery<T> extends C4232c<T> {

    /* renamed from: a */
    private final QueryData<T> f9718a;

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

    /* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.CursorQuery$QueryData */
    private static final class QueryData<T2> extends C4231b<T2, CursorQuery<T2>> {
        private final int limitPosition;
        private final int offsetPosition;

        QueryData(AbstractDao abstractDao, String str, String[] strArr, int i, int i2) {
            super(abstractDao, str, strArr);
            this.limitPosition = i;
            this.offsetPosition = i2;
        }

        /* access modifiers changed from: protected */
        public CursorQuery<T2> createQuery() {
            return new CursorQuery(this, this.dao, this.sql, (String[]) this.initialValues.clone(), this.limitPosition, this.offsetPosition);
        }
    }

    public static <T2> CursorQuery<T2> internalCreate(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr) {
        return m6569a(abstractDao, str, objArr, -1, -1);
    }

    /* renamed from: a */
    static <T2> CursorQuery<T2> m6569a(AbstractDao<T2, ?> abstractDao, String str, Object[] objArr, int i, int i2) {
        return (CursorQuery) new QueryData(abstractDao, str, toStringArray(objArr), i, i2).forCurrentThread();
    }

    private CursorQuery(QueryData<T> queryData, AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr, i, i2);
        this.f9718a = queryData;
    }

    public CursorQuery forCurrentThread() {
        return (CursorQuery) this.f9718a.forCurrentThread(this);
    }

    public Cursor query() {
        checkThread();
        return this.dao.getDatabase().rawQuery(this.sql, this.parameters);
    }
}
