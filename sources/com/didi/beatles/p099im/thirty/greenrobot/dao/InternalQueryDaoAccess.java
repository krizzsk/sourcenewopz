package com.didi.beatles.p099im.thirty.greenrobot.dao;

import android.database.Cursor;
import com.didi.beatles.p099im.thirty.greenrobot.dao.internal.TableStatements;
import java.util.List;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.InternalQueryDaoAccess */
public final class InternalQueryDaoAccess<T> {

    /* renamed from: a */
    private final AbstractDao<T, ?> f9660a;

    public InternalQueryDaoAccess(AbstractDao<T, ?> abstractDao) {
        this.f9660a = abstractDao;
    }

    public T loadCurrent(Cursor cursor, int i, boolean z) {
        return this.f9660a.loadCurrent(cursor, i, z);
    }

    public List<T> loadAllAndCloseCursor(Cursor cursor) {
        return this.f9660a.loadAllAndCloseCursor(cursor);
    }

    public T loadUniqueAndCloseCursor(Cursor cursor) {
        return this.f9660a.loadUniqueAndCloseCursor(cursor);
    }

    public TableStatements getStatements() {
        return this.f9660a.getStatements();
    }

    public static <T2> TableStatements getStatements(AbstractDao<T2, ?> abstractDao) {
        return abstractDao.getStatements();
    }
}
