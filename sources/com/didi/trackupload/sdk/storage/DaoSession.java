package com.didi.trackupload.sdk.storage;

import java.util.Map;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

public class DaoSession extends AbstractDaoSession {
    private final BizNodeEntityDao bizNodeEntityDao = new BizNodeEntityDao(this.bizNodeEntityDaoConfig, this);
    private final DaoConfig bizNodeEntityDaoConfig;
    private final TrackNodeEntityDao trackNodeEntityDao = new TrackNodeEntityDao(this.trackNodeEntityDaoConfig, this);
    private final DaoConfig trackNodeEntityDaoConfig;

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> map) {
        super(database);
        DaoConfig clone = map.get(TrackNodeEntityDao.class).clone();
        this.trackNodeEntityDaoConfig = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(BizNodeEntityDao.class).clone();
        this.bizNodeEntityDaoConfig = clone2;
        clone2.initIdentityScope(identityScopeType);
        registerDao(TrackNodeEntity.class, this.trackNodeEntityDao);
        registerDao(BizNodeEntity.class, this.bizNodeEntityDao);
    }

    public void clear() {
        this.trackNodeEntityDaoConfig.clearIdentityScope();
        this.bizNodeEntityDaoConfig.clearIdentityScope();
    }

    public TrackNodeEntityDao getTrackNodeEntityDao() {
        return this.trackNodeEntityDao;
    }

    public BizNodeEntityDao getBizNodeEntityDao() {
        return this.bizNodeEntityDao;
    }
}
