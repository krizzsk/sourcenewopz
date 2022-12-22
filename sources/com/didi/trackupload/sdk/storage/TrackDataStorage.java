package com.didi.trackupload.sdk.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.didi.trackupload.sdk.Constants;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.storage.DaoMaster;
import com.didi.trackupload.sdk.storage.TrackNodeEntityDao;
import com.didi.trackupload.sdk.utils.LocUtils;
import com.didi.trackupload.sdk.utils.OmegaUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greenrobot.greendao.query.QueryBuilder;

public class TrackDataStorage {
    private static final String DB_NAME = "track_upload_sdk.db";
    private BizNodeEntityDao mBizNodeEntityDao;
    private TrackNodeEntityDao mTrackNodeDao;

    private TrackDataStorage() {
    }

    private static class SingletonHolder {
        static TrackDataStorage INSTANCE = new TrackDataStorage();

        private SingletonHolder() {
        }
    }

    public static TrackDataStorage getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        try {
            DaoSession newSession = new DaoMaster(new DaoMaster.DevOpenHelper(context, DB_NAME, (SQLiteDatabase.CursorFactory) null).getWritableDb()).newSession();
            this.mTrackNodeDao = newSession.getTrackNodeEntityDao();
            this.mBizNodeEntityDao = newSession.getBizNodeEntityDao();
            QueryBuilder.LOG_SQL = Constants.DEBUG;
            QueryBuilder.LOG_VALUES = Constants.DEBUG;
        } catch (Exception e) {
            OmegaUtils.trackDBError(101, e);
        }
    }

    public void saveTrackNodeEntity(TrackNodeEntity trackNodeEntity) {
        TrackNodeEntityDao trackNodeEntityDao = this.mTrackNodeDao;
        if (trackNodeEntityDao != null) {
            try {
                trackNodeEntityDao.insert(trackNodeEntity);
            } catch (Exception e) {
                OmegaUtils.trackDBError(102, e);
            }
        }
    }

    public void saveTrackNodeEntities(List<TrackNodeEntity> list) {
        TrackNodeEntityDao trackNodeEntityDao = this.mTrackNodeDao;
        if (trackNodeEntityDao != null) {
            try {
                trackNodeEntityDao.insertInTx(list);
            } catch (Exception e) {
                OmegaUtils.trackDBError(103, e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didi.trackupload.sdk.storage.TrackNodeEntity> getTrackNodeEntities(int r2) {
        /*
            r1 = this;
            com.didi.trackupload.sdk.storage.TrackNodeEntityDao r0 = r1.mTrackNodeDao
            if (r0 == 0) goto L_0x0017
            org.greenrobot.greendao.query.QueryBuilder r0 = r0.queryBuilder()     // Catch:{ Exception -> 0x0011 }
            org.greenrobot.greendao.query.QueryBuilder r2 = r0.limit(r2)     // Catch:{ Exception -> 0x0011 }
            java.util.List r2 = r2.list()     // Catch:{ Exception -> 0x0011 }
            goto L_0x0018
        L_0x0011:
            r2 = move-exception
            r0 = 104(0x68, float:1.46E-43)
            com.didi.trackupload.sdk.utils.OmegaUtils.trackDBError(r0, r2)
        L_0x0017:
            r2 = 0
        L_0x0018:
            if (r2 == 0) goto L_0x001b
            goto L_0x0020
        L_0x001b:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x0020:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.storage.TrackDataStorage.getTrackNodeEntities(int):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didi.trackupload.sdk.storage.TrackNodeEntity> getAllTrackNodeEntities() {
        /*
            r2 = this;
            com.didi.trackupload.sdk.storage.TrackNodeEntityDao r0 = r2.mTrackNodeDao
            if (r0 == 0) goto L_0x000f
            java.util.List r0 = r0.loadAll()     // Catch:{ Exception -> 0x0009 }
            goto L_0x0010
        L_0x0009:
            r0 = move-exception
            r1 = 105(0x69, float:1.47E-43)
            com.didi.trackupload.sdk.utils.OmegaUtils.trackDBError(r1, r0)
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0013
            goto L_0x0018
        L_0x0013:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.storage.TrackDataStorage.getAllTrackNodeEntities():java.util.List");
    }

    public void removeTrackNodeEntities(List<TrackNodeEntity> list) {
        TrackNodeEntityDao trackNodeEntityDao = this.mTrackNodeDao;
        if (trackNodeEntityDao != null) {
            try {
                trackNodeEntityDao.deleteInTx(list);
            } catch (Exception e) {
                OmegaUtils.trackDBError(106, e);
            }
        }
    }

    public long getTrackNodeEntitySize() {
        TrackNodeEntityDao trackNodeEntityDao = this.mTrackNodeDao;
        if (trackNodeEntityDao == null) {
            return 0;
        }
        try {
            return trackNodeEntityDao.queryBuilder().count();
        } catch (Exception e) {
            OmegaUtils.trackDBError(107, e);
            return 0;
        }
    }

    public void saveBizNodeEntity(BizNodeEntity bizNodeEntity) {
        BizNodeEntityDao bizNodeEntityDao = this.mBizNodeEntityDao;
        if (bizNodeEntityDao != null) {
            try {
                bizNodeEntityDao.insertOrReplace(bizNodeEntity);
            } catch (Exception e) {
                OmegaUtils.trackDBError(108, e);
            }
        }
    }

    public void saveBizNodeEntities(List<BizNodeEntity> list) {
        BizNodeEntityDao bizNodeEntityDao = this.mBizNodeEntityDao;
        if (bizNodeEntityDao != null) {
            try {
                bizNodeEntityDao.insertOrReplaceInTx(list);
            } catch (Exception e) {
                OmegaUtils.trackDBError(109, e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.didi.trackupload.sdk.storage.BizNodeEntity> getAllBizNodeEntities() {
        /*
            r2 = this;
            com.didi.trackupload.sdk.storage.BizNodeEntityDao r0 = r2.mBizNodeEntityDao
            if (r0 == 0) goto L_0x000f
            java.util.List r0 = r0.loadAll()     // Catch:{ Exception -> 0x0009 }
            goto L_0x0010
        L_0x0009:
            r0 = move-exception
            r1 = 110(0x6e, float:1.54E-43)
            com.didi.trackupload.sdk.utils.OmegaUtils.trackDBError(r1, r0)
        L_0x000f:
            r0 = 0
        L_0x0010:
            if (r0 == 0) goto L_0x0013
            goto L_0x0018
        L_0x0013:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.trackupload.sdk.storage.TrackDataStorage.getAllBizNodeEntities():java.util.List");
    }

    public void removeBizNodeEntities(List<BizNodeEntity> list) {
        BizNodeEntityDao bizNodeEntityDao = this.mBizNodeEntityDao;
        if (bizNodeEntityDao != null) {
            try {
                bizNodeEntityDao.deleteInTx(list);
            } catch (Exception e) {
                OmegaUtils.trackDBError(111, e);
            }
        }
    }

    public void removeAllBizNodeEntities() {
        BizNodeEntityDao bizNodeEntityDao = this.mBizNodeEntityDao;
        if (bizNodeEntityDao != null) {
            try {
                bizNodeEntityDao.deleteAll();
            } catch (Exception e) {
                OmegaUtils.trackDBError(112, e);
            }
        }
    }

    public TrackLocationInfo getLastEffectiveLoc() {
        TrackLocationInfo locationInfo;
        TrackNodeEntityDao trackNodeEntityDao = this.mTrackNodeDao;
        if (trackNodeEntityDao == null) {
            return null;
        }
        try {
            List list = trackNodeEntityDao.queryBuilder().orderDesc(TrackNodeEntityDao.Properties.f44004Id).limit(1).list();
            if (list == null || list.size() <= 0 || (locationInfo = ((TrackNodeEntity) list.get(0)).getLocationInfo()) == null || !LocUtils.isLocEffective((long) (locationInfo.timestamp_mobile.intValue() * 1000))) {
                return null;
            }
            return locationInfo;
        } catch (Exception e) {
            OmegaUtils.trackDBError(113, e);
            return null;
        }
    }

    public List<TrackLocationInfo> getRecentLocations(int i) {
        ArrayList arrayList = new ArrayList();
        TrackNodeEntityDao trackNodeEntityDao = this.mTrackNodeDao;
        if (trackNodeEntityDao != null) {
            try {
                List<TrackNodeEntity> list = trackNodeEntityDao.queryBuilder().orderDesc(TrackNodeEntityDao.Properties.f44004Id).limit(i).list();
                if (list != null && list.size() > 0) {
                    for (TrackNodeEntity locationInfo : list) {
                        TrackLocationInfo locationInfo2 = locationInfo.getLocationInfo();
                        if (locationInfo2 != null) {
                            arrayList.add(locationInfo2);
                        }
                    }
                }
            } catch (Exception e) {
                OmegaUtils.trackDBError(114, e);
            }
        }
        if (arrayList.size() > 1) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }
}
