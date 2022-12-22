package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.Property;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.Join */
public class Join<SRC, DST> {

    /* renamed from: a */
    final String f9720a;

    /* renamed from: b */
    final AbstractDao<DST, ?> f9721b;

    /* renamed from: c */
    final Property f9722c;

    /* renamed from: d */
    final Property f9723d;

    /* renamed from: e */
    final String f9724e;

    /* renamed from: f */
    final C4233d<DST> f9725f;

    public Join(String str, Property property, AbstractDao<DST, ?> abstractDao, Property property2, String str2) {
        this.f9720a = str;
        this.f9722c = property;
        this.f9721b = abstractDao;
        this.f9723d = property2;
        this.f9724e = str2;
        this.f9725f = new C4233d<>(abstractDao, str2);
    }

    public Join<SRC, DST> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.f9725f.mo43805a(whereCondition, whereConditionArr);
        return this;
    }

    public Join<SRC, DST> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.f9725f.mo43805a(mo43718or(whereCondition, whereCondition2, whereConditionArr), new WhereCondition[0]);
        return this;
    }

    /* renamed from: or */
    public WhereCondition mo43718or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f9725f.mo43802a(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f9725f.mo43802a(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }
}
