package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoLog;
import com.didi.beatles.p099im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p099im.thirty.greenrobot.dao.internal.SqlUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.Typography;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.QueryBuilder */
public class QueryBuilder<T> {
    public static boolean LOG_SQL;
    public static boolean LOG_VALUES;

    /* renamed from: a */
    private final C4233d<T> f9733a;

    /* renamed from: b */
    private StringBuilder f9734b;

    /* renamed from: c */
    private final List<Object> f9735c;

    /* renamed from: d */
    private final List<Join<T, ?>> f9736d;

    /* renamed from: e */
    private final AbstractDao<T, ?> f9737e;

    /* renamed from: f */
    private final String f9738f;

    /* renamed from: g */
    private Integer f9739g;

    /* renamed from: h */
    private Integer f9740h;

    public static <T2> QueryBuilder<T2> internalCreate(AbstractDao<T2, ?> abstractDao) {
        return new QueryBuilder<>(abstractDao);
    }

    protected QueryBuilder(AbstractDao<T, ?> abstractDao) {
        this(abstractDao, "T");
    }

    protected QueryBuilder(AbstractDao<T, ?> abstractDao, String str) {
        this.f9737e = abstractDao;
        this.f9738f = str;
        this.f9735c = new ArrayList();
        this.f9736d = new ArrayList();
        this.f9733a = new C4233d<>(abstractDao, str);
    }

    /* renamed from: a */
    private void m6576a() {
        StringBuilder sb = this.f9734b;
        if (sb == null) {
            this.f9734b = new StringBuilder();
        } else if (sb.length() > 0) {
            this.f9734b.append(",");
        }
    }

    public QueryBuilder<T> where(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        this.f9733a.mo43805a(whereCondition, whereConditionArr);
        return this;
    }

    public QueryBuilder<T> whereOr(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        this.f9733a.mo43805a(mo43787or(whereCondition, whereCondition2, whereConditionArr), new WhereCondition[0]);
        return this;
    }

    /* renamed from: or */
    public WhereCondition mo43787or(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f9733a.mo43802a(" OR ", whereCondition, whereCondition2, whereConditionArr);
    }

    public WhereCondition and(WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        return this.f9733a.mo43802a(" AND ", whereCondition, whereCondition2, whereConditionArr);
    }

    public <J> Join<T, J> join(Class<J> cls, Property property) {
        return join(this.f9737e.getPkProperty(), cls, property);
    }

    public <J> Join<T, J> join(Property property, Class<J> cls) {
        AbstractDao<?, ?> dao = this.f9737e.getSession().getDao(cls);
        return m6575a(this.f9738f, property, dao, dao.getPkProperty());
    }

    public <J> Join<T, J> join(Property property, Class<J> cls, Property property2) {
        return m6575a(this.f9738f, property, this.f9737e.getSession().getDao(cls), property2);
    }

    public <J> Join<T, J> join(Join<?, T> join, Property property, Class<J> cls, Property property2) {
        return m6575a(join.f9724e, property, this.f9737e.getSession().getDao(cls), property2);
    }

    /* renamed from: a */
    private <J> Join<T, J> m6575a(String str, Property property, AbstractDao<J, ?> abstractDao, Property property2) {
        Join join = new Join(str, property, abstractDao, property2, "J" + (this.f9736d.size() + 1));
        this.f9736d.add(join);
        return join;
    }

    public QueryBuilder<T> orderAsc(Property... propertyArr) {
        m6578a(" ASC", propertyArr);
        return this;
    }

    public QueryBuilder<T> orderDesc(Property... propertyArr) {
        m6578a(" DESC", propertyArr);
        return this;
    }

    /* renamed from: a */
    private void m6578a(String str, Property... propertyArr) {
        for (Property property : propertyArr) {
            m6576a();
            append(this.f9734b, property);
            if (String.class.equals(property.type)) {
                this.f9734b.append(" COLLATE LOCALIZED");
            }
            this.f9734b.append(str);
        }
    }

    public QueryBuilder<T> orderCustom(Property property, String str) {
        m6576a();
        append(this.f9734b, property).append(' ');
        this.f9734b.append(str);
        return this;
    }

    public QueryBuilder<T> orderRaw(String str) {
        m6576a();
        this.f9734b.append(str);
        return this;
    }

    /* access modifiers changed from: protected */
    public StringBuilder append(StringBuilder sb, Property property) {
        this.f9733a.mo43803a(property);
        sb.append(this.f9738f);
        sb.append('.');
        sb.append('\'');
        sb.append(property.columnName);
        sb.append('\'');
        return sb;
    }

    public QueryBuilder<T> limit(int i) {
        this.f9739g = Integer.valueOf(i);
        return this;
    }

    public QueryBuilder<T> offset(int i) {
        this.f9740h = Integer.valueOf(i);
        return this;
    }

    public Query<T> build() {
        StringBuilder b = m6581b();
        int a = m6574a(b);
        int b2 = m6580b(b);
        String sb = b.toString();
        m6577a(sb);
        return Query.m6573a(this.f9737e, sb, this.f9735c.toArray(), a, b2);
    }

    public CursorQuery buildCursor() {
        StringBuilder b = m6581b();
        int a = m6574a(b);
        int b2 = m6580b(b);
        String sb = b.toString();
        m6577a(sb);
        return CursorQuery.m6569a(this.f9737e, sb, this.f9735c.toArray(), a, b2);
    }

    /* renamed from: b */
    private StringBuilder m6581b() {
        StringBuilder sb = new StringBuilder(SqlUtils.createSqlSelect(this.f9737e.getTablename(), this.f9738f, this.f9737e.getAllColumns()));
        m6579a(sb, this.f9738f);
        StringBuilder sb2 = this.f9734b;
        if (sb2 != null && sb2.length() > 0) {
            sb.append(" ORDER BY ");
            sb.append(this.f9734b);
        }
        return sb;
    }

    /* renamed from: a */
    private int m6574a(StringBuilder sb) {
        if (this.f9739g == null) {
            return -1;
        }
        sb.append(" LIMIT ?");
        this.f9735c.add(this.f9739g);
        return this.f9735c.size() - 1;
    }

    /* renamed from: b */
    private int m6580b(StringBuilder sb) {
        if (this.f9740h == null) {
            return -1;
        }
        if (this.f9739g != null) {
            sb.append(" OFFSET ?");
            this.f9735c.add(this.f9740h);
            return this.f9735c.size() - 1;
        }
        throw new IllegalStateException("Offset cannot be set without limit");
    }

    public DeleteQuery<T> buildDelete() {
        if (this.f9736d.isEmpty()) {
            String tablename = this.f9737e.getTablename();
            StringBuilder sb = new StringBuilder(SqlUtils.createSqlDelete(tablename, (String[]) null));
            m6579a(sb, this.f9738f);
            String replace = sb.toString().replace(this.f9738f + ".\"", Typography.quote + tablename + "\".\"");
            m6577a(replace);
            return DeleteQuery.m6570a(this.f9737e, replace, this.f9735c.toArray());
        }
        throw new DaoException("JOINs are not supported for DELETE queries");
    }

    public CountQuery<T> buildCount() {
        StringBuilder sb = new StringBuilder(SqlUtils.createSqlSelectCountStar(this.f9737e.getTablename(), this.f9738f));
        m6579a(sb, this.f9738f);
        String sb2 = sb.toString();
        m6577a(sb2);
        return CountQuery.m6568a(this.f9737e, sb2, this.f9735c.toArray());
    }

    /* renamed from: a */
    private void m6577a(String str) {
        if (LOG_SQL) {
            DaoLog.m6524d("Built SQL for query: " + str);
        }
        if (LOG_VALUES) {
            DaoLog.m6524d("Values for query: " + this.f9735c);
        }
    }

    /* renamed from: a */
    private void m6579a(StringBuilder sb, String str) {
        this.f9735c.clear();
        for (Join next : this.f9736d) {
            sb.append(" JOIN ");
            sb.append(next.f9721b.getTablename());
            sb.append(' ');
            sb.append(next.f9724e);
            sb.append(" ON ");
            SqlUtils.appendProperty(sb, next.f9720a, next.f9722c).append('=');
            SqlUtils.appendProperty(sb, next.f9724e, next.f9723d);
        }
        boolean z = !this.f9733a.mo43808a();
        if (z) {
            sb.append(" WHERE ");
            this.f9733a.mo43806a(sb, str, this.f9735c);
        }
        for (Join next2 : this.f9736d) {
            if (!next2.f9725f.mo43808a()) {
                if (!z) {
                    sb.append(" WHERE ");
                    z = true;
                } else {
                    sb.append(" AND ");
                }
                next2.f9725f.mo43806a(sb, next2.f9724e, this.f9735c);
            }
        }
    }

    public List<T> list() {
        return build().list();
    }

    public LazyList<T> listLazy() {
        return build().listLazy();
    }

    public LazyList<T> listLazyUncached() {
        return build().listLazyUncached();
    }

    public CloseableListIterator<T> listIterator() {
        return build().listIterator();
    }

    public T unique() {
        return build().unique();
    }

    public T uniqueOrThrow() {
        return build().uniqueOrThrow();
    }

    public long count() {
        return buildCount().count();
    }
}
