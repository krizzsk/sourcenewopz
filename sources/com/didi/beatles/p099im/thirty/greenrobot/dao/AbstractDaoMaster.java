package com.didi.beatles.p099im.thirty.greenrobot.dao;

import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope.IdentityScopeType;
import com.didi.beatles.p099im.thirty.greenrobot.dao.internal.DaoConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.AbstractDaoMaster */
public abstract class AbstractDaoMaster {
    protected final Map<String, DaoConfig> daoConfigMap = new HashMap();

    /* renamed from: db */
    protected final Database f9656db;
    protected final int schemaVersion;

    public abstract AbstractDaoSession newSession();

    public abstract AbstractDaoSession newSession(IdentityScopeType identityScopeType);

    public AbstractDaoMaster(Database database, int i) {
        this.f9656db = database;
        this.schemaVersion = i;
    }

    /* access modifiers changed from: protected */
    public void registerDaoClass(Class<? extends AbstractDao<?, ?>> cls, String str) {
        this.daoConfigMap.put(str, new DaoConfig(this.f9656db, cls, str));
    }

    public int getSchemaVersion() {
        return this.schemaVersion;
    }

    public Database getDatabase() {
        return this.f9656db;
    }
}
