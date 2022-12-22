package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import java.util.Date;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.c */
/* compiled from: AbstractQueryWithLimit */
abstract class C4232c<T> extends C4230a<T> {
    protected final int limitPosition;
    protected final int offsetPosition;

    protected C4232c(AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i, int i2) {
        super(abstractDao, str, strArr);
        this.limitPosition = i;
        this.offsetPosition = i2;
    }

    public void setParameter(int i, Object obj) {
        if (i < 0 || !(i == this.limitPosition || i == this.offsetPosition)) {
            super.setParameter(i, obj);
            return;
        }
        throw new IllegalArgumentException("Illegal parameter index: " + i);
    }

    public void setParameter(int i, Date date) {
        setParameter(i, (Object) date != null ? Long.valueOf(date.getTime()) : null);
    }

    public void setParameter(int i, Boolean bool) {
        setParameter(i, (Object) bool != null ? Integer.valueOf(bool.booleanValue() ? 1 : 0) : null);
    }

    public void setLimit(int i) {
        checkThread();
        if (this.limitPosition != -1) {
            this.parameters[this.limitPosition] = Integer.toString(i);
            return;
        }
        throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
    }

    public void setOffset(int i) {
        checkThread();
        if (this.offsetPosition != -1) {
            this.parameters[this.offsetPosition] = Integer.toString(i);
            return;
        }
        throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
    }
}
