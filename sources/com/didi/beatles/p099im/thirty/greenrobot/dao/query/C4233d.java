package com.didi.beatles.p099im.thirty.greenrobot.dao.query;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p099im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p099im.thirty.greenrobot.dao.query.WhereCondition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.query.d */
/* compiled from: WhereCollector */
class C4233d<T> {

    /* renamed from: a */
    private final AbstractDao<T, ?> f9742a;

    /* renamed from: b */
    private final List<WhereCondition> f9743b = new ArrayList();

    /* renamed from: c */
    private final String f9744c;

    C4233d(AbstractDao<T, ?> abstractDao, String str) {
        this.f9742a = abstractDao;
        this.f9744c = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43805a(WhereCondition whereCondition, WhereCondition... whereConditionArr) {
        mo43804a(whereCondition);
        this.f9743b.add(whereCondition);
        for (WhereCondition whereCondition2 : whereConditionArr) {
            mo43804a(whereCondition2);
            this.f9743b.add(whereCondition2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public WhereCondition mo43802a(String str, WhereCondition whereCondition, WhereCondition whereCondition2, WhereCondition... whereConditionArr) {
        StringBuilder sb = new StringBuilder("(");
        ArrayList arrayList = new ArrayList();
        mo43807a(sb, (List<Object>) arrayList, whereCondition);
        sb.append(str);
        mo43807a(sb, (List<Object>) arrayList, whereCondition2);
        for (WhereCondition a : whereConditionArr) {
            sb.append(str);
            mo43807a(sb, (List<Object>) arrayList, a);
        }
        sb.append(VersionRange.RIGHT_OPEN);
        return new WhereCondition.StringCondition(sb.toString(), arrayList.toArray());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43807a(StringBuilder sb, List<Object> list, WhereCondition whereCondition) {
        mo43804a(whereCondition);
        whereCondition.appendTo(sb, this.f9744c);
        whereCondition.appendValuesTo(list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43804a(WhereCondition whereCondition) {
        if (whereCondition instanceof WhereCondition.PropertyCondition) {
            mo43803a(((WhereCondition.PropertyCondition) whereCondition).property);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43803a(Property property) {
        AbstractDao<T, ?> abstractDao = this.f9742a;
        if (abstractDao != null) {
            Property[] properties = abstractDao.getProperties();
            int length = properties.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (property == properties[i]) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                throw new DaoException("Property '" + property.name + "' is not part of " + this.f9742a);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43806a(StringBuilder sb, String str, List<Object> list) {
        ListIterator<WhereCondition> listIterator = this.f9743b.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious()) {
                sb.append(" AND ");
            }
            WhereCondition next = listIterator.next();
            next.appendTo(sb, str);
            next.appendValuesTo(list);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo43808a() {
        return this.f9743b.isEmpty();
    }
}
