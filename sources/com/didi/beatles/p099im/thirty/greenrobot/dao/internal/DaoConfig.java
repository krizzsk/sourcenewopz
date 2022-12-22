package com.didi.beatles.p099im.thirty.greenrobot.dao.internal;

import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.DaoException;
import com.didi.beatles.p099im.thirty.greenrobot.dao.Property;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope.IdentityScope;
import com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope.IdentityScopeLong;
import com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope.IdentityScopeObject;
import com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope.IdentityScopeType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.internal.DaoConfig */
public final class DaoConfig implements Cloneable {

    /* renamed from: a */
    private IdentityScope<?, ?> f9695a;
    public final String[] allColumns;

    /* renamed from: db */
    public final Database f9696db;
    public final boolean keyIsNumeric;
    public final String[] nonPkColumns;
    public final String[] pkColumns;
    public final Property pkProperty;
    public final Property[] properties;
    public final TableStatements statements;
    public final String tablename;

    public DaoConfig(Database database, Class<? extends AbstractDao<?, ?>> cls, String str) {
        this.f9696db = database;
        try {
            this.tablename = str;
            Property[] a = m6567a(cls);
            this.properties = a;
            this.allColumns = new String[a.length];
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Property property = null;
            boolean z = false;
            Property property2 = null;
            for (int i = 0; i < a.length; i++) {
                Property property3 = a[i];
                String str2 = property3.columnName;
                this.allColumns[i] = str2;
                if (property3.primaryKey) {
                    arrayList.add(str2);
                    property2 = property3;
                } else {
                    arrayList2.add(str2);
                }
            }
            this.nonPkColumns = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            this.pkColumns = strArr;
            this.pkProperty = strArr.length == 1 ? property2 : property;
            this.statements = new TableStatements(database, str, this.allColumns, this.pkColumns);
            if (this.pkProperty != null) {
                Class<?> cls2 = this.pkProperty.type;
                this.keyIsNumeric = (cls2.equals(Long.TYPE) || cls2.equals(Long.class) || cls2.equals(Integer.TYPE) || cls2.equals(Integer.class) || cls2.equals(Short.TYPE) || cls2.equals(Short.class) || cls2.equals(Byte.TYPE) || cls2.equals(Byte.class)) ? true : z;
                return;
            }
            this.keyIsNumeric = false;
        } catch (Exception e) {
            throw new DaoException("Could not init DAOConfig", e);
        }
    }

    /* renamed from: a */
    private static Property[] m6567a(Class<? extends AbstractDao<?, ?>> cls) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException {
        Field[] declaredFields = Class.forName(cls.getName() + "$Properties").getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if ((field.getModifiers() & 9) == 9) {
                Object obj = field.get((Object) null);
                if (obj instanceof Property) {
                    arrayList.add((Property) obj);
                }
            }
        }
        Property[] propertyArr = new Property[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Property property = (Property) it.next();
            if (propertyArr[property.ordinal] == null) {
                propertyArr[property.ordinal] = property;
            } else {
                throw new DaoException("Duplicate property ordinals");
            }
        }
        return propertyArr;
    }

    public DaoConfig(DaoConfig daoConfig) {
        this.f9696db = daoConfig.f9696db;
        this.tablename = daoConfig.tablename;
        this.properties = daoConfig.properties;
        this.allColumns = daoConfig.allColumns;
        this.pkColumns = daoConfig.pkColumns;
        this.nonPkColumns = daoConfig.nonPkColumns;
        this.pkProperty = daoConfig.pkProperty;
        this.statements = daoConfig.statements;
        this.keyIsNumeric = daoConfig.keyIsNumeric;
    }

    public DaoConfig clone() {
        return new DaoConfig(this);
    }

    public IdentityScope<?, ?> getIdentityScope() {
        return this.f9695a;
    }

    public void setIdentityScope(IdentityScope<?, ?> identityScope) {
        this.f9695a = identityScope;
    }

    public void initIdentityScope(IdentityScopeType identityScopeType) {
        if (identityScopeType == IdentityScopeType.None) {
            this.f9695a = null;
        } else if (identityScopeType != IdentityScopeType.Session) {
            throw new IllegalArgumentException("Unsupported type: " + identityScopeType);
        } else if (this.keyIsNumeric) {
            this.f9695a = new IdentityScopeLong();
        } else {
            this.f9695a = new IdentityScopeObject();
        }
    }
}
