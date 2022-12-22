package com.didichuxing.publicservice.p196db.dao;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didichuxing.publicservice.db.dao.DaoFactory */
public class DaoFactory {
    private Map<DaoType, Dao> daoMap;

    /* renamed from: com.didichuxing.publicservice.db.dao.DaoFactory$DaoType */
    public enum DaoType {
        SCREEN_AD,
        SCREEN_AD_NEW
    }

    private DaoFactory() {
        this.daoMap = new HashMap();
        registerDao();
    }

    /* renamed from: com.didichuxing.publicservice.db.dao.DaoFactory$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final DaoFactory INSTANCE = new DaoFactory();

        private SingletonHolder() {
        }
    }

    public static DaoFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private void registerDao() {
        this.daoMap.put(DaoType.SCREEN_AD, new ScreenAdDao());
        this.daoMap.put(DaoType.SCREEN_AD_NEW, new ScreenAdNewDao());
    }

    public Dao getDao(DaoType daoType) {
        Dao dao = this.daoMap.get(daoType);
        if (dao != null) {
            return dao;
        }
        throw new DaoNotFoundException(daoType);
    }
}
