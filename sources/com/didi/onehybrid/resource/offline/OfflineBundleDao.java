package com.didi.onehybrid.resource.offline;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.didi.onehybrid.resource.offline.FusionContract;
import com.didi.onehybrid.resource.offline.OfflineBundle;
import java.util.List;

public class OfflineBundleDao {
    private DatabaseManager mDatabaseManager;
    private FusionDbHelperA mFusionDbHelper;

    public OfflineBundleDao(Context context) {
        FusionDbHelperA instance = FusionDbHelperA.getInstance(context);
        this.mFusionDbHelper = instance;
        this.mDatabaseManager = DatabaseManager.getInstance(instance);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ed A[SYNTHETIC, Splitter:B:28:0x00ed] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.didi.onehybrid.resource.offline.OfflineBundle> loadAllBundleInfos() {
        /*
            r21 = this;
            r1 = r21
            monitor-enter(r21)
            com.didi.onehybrid.resource.offline.DatabaseManager r0 = r1.mDatabaseManager     // Catch:{ all -> 0x0117 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0117 }
            r0.beginTransaction()     // Catch:{ all -> 0x0117 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0117 }
            r10.<init>()     // Catch:{ all -> 0x0117 }
            java.lang.String r2 = "_id"
            java.lang.String r3 = "bundle_name"
            java.lang.String r4 = "version"
            java.lang.String r5 = "state"
            java.lang.String r6 = "md5"
            java.lang.String[] r4 = new java.lang.String[]{r2, r3, r4, r5, r6}     // Catch:{ all -> 0x0117 }
            java.lang.String r2 = "_id"
            java.lang.String r3 = "bundle_name"
            java.lang.String r5 = "resource_name"
            java.lang.String r6 = "resource_url"
            java.lang.String r7 = "md5"
            java.lang.String[] r11 = new java.lang.String[]{r2, r3, r5, r6, r7}     // Catch:{ all -> 0x0117 }
            java.lang.String r3 = "offlinebundles"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0117 }
            r2 = 0
            if (r12 == 0) goto L_0x00fc
            int r3 = r12.getCount()     // Catch:{ all -> 0x00ea }
            if (r3 <= 0) goto L_0x00fc
            r13 = r2
        L_0x0043:
            boolean r2 = r12.moveToNext()     // Catch:{ all -> 0x00e7 }
            if (r2 == 0) goto L_0x00e5
            com.didi.onehybrid.resource.offline.OfflineBundle r14 = new com.didi.onehybrid.resource.offline.OfflineBundle     // Catch:{ all -> 0x00e7 }
            r14.<init>()     // Catch:{ all -> 0x00e7 }
            r15 = 1
            java.lang.String r2 = r12.getString(r15)     // Catch:{ all -> 0x00e7 }
            r14.setName(r2)     // Catch:{ all -> 0x00e7 }
            r9 = 2
            java.lang.String r2 = r12.getString(r9)     // Catch:{ all -> 0x00e7 }
            r14.setVersion(r2)     // Catch:{ all -> 0x00e7 }
            r8 = 3
            int r2 = r12.getInt(r8)     // Catch:{ all -> 0x00e7 }
            r14.setState(r2)     // Catch:{ all -> 0x00e7 }
            r7 = 4
            java.lang.String r2 = r12.getString(r7)     // Catch:{ all -> 0x00e7 }
            r14.setMd5(r2)     // Catch:{ all -> 0x00e7 }
            java.util.concurrent.CopyOnWriteArrayList r6 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x00e7 }
            r6.<init>()     // Catch:{ all -> 0x00e7 }
            java.lang.String r5 = "bundle_name= ?"
            java.lang.String[] r4 = new java.lang.String[r15]     // Catch:{ all -> 0x00e7 }
            r2 = 0
            java.lang.String r3 = r12.getString(r15)     // Catch:{ all -> 0x00e7 }
            r4[r2] = r3     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = "offlinebundleresource"
            r16 = 0
            r17 = 0
            r18 = 0
            r2 = r0
            r19 = r4
            r4 = r11
            r20 = r6
            r6 = r19
            r7 = r16
            r8 = r17
            r9 = r18
            android.database.Cursor r13 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00e7 }
            if (r13 == 0) goto L_0x00db
            int r2 = r13.getCount()     // Catch:{ all -> 0x00e7 }
            if (r2 <= 0) goto L_0x00d5
        L_0x00a0:
            boolean r2 = r13.moveToNext()     // Catch:{ all -> 0x00e7 }
            if (r2 == 0) goto L_0x00d5
            com.didi.onehybrid.resource.offline.OfflineBundle$ResourceInfo r2 = new com.didi.onehybrid.resource.offline.OfflineBundle$ResourceInfo     // Catch:{ all -> 0x00e7 }
            r14.getClass()     // Catch:{ all -> 0x00e7 }
            r2.<init>()     // Catch:{ all -> 0x00e7 }
            java.lang.String r3 = r13.getString(r15)     // Catch:{ all -> 0x00e7 }
            r2.setBundleName(r3)     // Catch:{ all -> 0x00e7 }
            r3 = 2
            java.lang.String r4 = r13.getString(r3)     // Catch:{ all -> 0x00e7 }
            r2.setFile(r4)     // Catch:{ all -> 0x00e7 }
            r4 = 3
            java.lang.String r5 = r13.getString(r4)     // Catch:{ all -> 0x00e7 }
            r2.setUrl(r5)     // Catch:{ all -> 0x00e7 }
            r5 = 4
            java.lang.String r6 = r13.getString(r5)     // Catch:{ all -> 0x00e7 }
            r2.setMd5(r6)     // Catch:{ all -> 0x00e7 }
            r6 = r20
            r6.add(r2)     // Catch:{ all -> 0x00e7 }
            r20 = r6
            goto L_0x00a0
        L_0x00d5:
            r6 = r20
            r13.close()     // Catch:{ all -> 0x00e7 }
            goto L_0x00dd
        L_0x00db:
            r6 = r20
        L_0x00dd:
            r14.setResource(r6)     // Catch:{ all -> 0x00e7 }
            r10.add(r14)     // Catch:{ all -> 0x00e7 }
            goto L_0x0043
        L_0x00e5:
            r2 = r13
            goto L_0x00fc
        L_0x00e7:
            r0 = move-exception
            r2 = r13
            goto L_0x00eb
        L_0x00ea:
            r0 = move-exception
        L_0x00eb:
            if (r12 == 0) goto L_0x00f0
            r12.close()     // Catch:{ all -> 0x0117 }
        L_0x00f0:
            if (r2 == 0) goto L_0x00fb
            boolean r3 = r2.isClosed()     // Catch:{ all -> 0x0117 }
            if (r3 != 0) goto L_0x00fb
            r2.close()     // Catch:{ all -> 0x0117 }
        L_0x00fb:
            throw r0     // Catch:{ all -> 0x0117 }
        L_0x00fc:
            if (r12 == 0) goto L_0x0101
            r12.close()     // Catch:{ all -> 0x0117 }
        L_0x0101:
            if (r2 == 0) goto L_0x010c
            boolean r3 = r2.isClosed()     // Catch:{ all -> 0x0117 }
            if (r3 != 0) goto L_0x010c
            r2.close()     // Catch:{ all -> 0x0117 }
        L_0x010c:
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0117 }
            r0.endTransaction()     // Catch:{ all -> 0x0117 }
            r21.destroy()     // Catch:{ all -> 0x0117 }
            monitor-exit(r21)
            return r10
        L_0x0117:
            r0 = move-exception
            monitor-exit(r21)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.onehybrid.resource.offline.OfflineBundleDao.loadAllBundleInfos():java.util.List");
    }

    public synchronized void addBundleInfo(OfflineBundle offlineBundle) {
        if (offlineBundle != null) {
            SQLiteDatabase writableDatabase = this.mDatabaseManager.getWritableDatabase();
            writableDatabase.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_name", offlineBundle.getName());
            contentValues.put("version", offlineBundle.getVersion());
            contentValues.put("state", Integer.valueOf(offlineBundle.getState()));
            contentValues.put("md5", offlineBundle.getMD5());
            writableDatabase.insertWithOnConflict(FusionContract.OfflineBundle.TABLE_NAME, (String) null, contentValues, 5);
            List<OfflineBundle.ResourceInfo> resouceInfoList = offlineBundle.getResouceInfoList();
            if (resouceInfoList != null && !resouceInfoList.isEmpty()) {
                for (OfflineBundle.ResourceInfo next : resouceInfoList) {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("bundle_name", offlineBundle.getName());
                    contentValues2.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_URL, next.getUrl());
                    contentValues2.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_NAME, next.getFile());
                    contentValues2.put("md5", next.getMd5());
                    writableDatabase.insertWithOnConflict(FusionContract.OfflineBundle.TABLE_RESOURCE_NAME, (String) null, contentValues2, 5);
                }
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            this.mDatabaseManager.closeDatabase();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0135, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void updateBundleInfo(java.util.List<com.didi.onehybrid.resource.offline.OfflineBundle> r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            if (r13 == 0) goto L_0x0134
            int r0 = r13.size()     // Catch:{ all -> 0x0131 }
            if (r0 != 0) goto L_0x000b
            goto L_0x0134
        L_0x000b:
            com.didi.onehybrid.resource.offline.DatabaseManager r0 = r12.mDatabaseManager     // Catch:{ all -> 0x0131 }
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch:{ all -> 0x0131 }
            r0.beginTransaction()     // Catch:{ all -> 0x0131 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0131 }
        L_0x0018:
            boolean r1 = r13.hasNext()     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x0124
            java.lang.Object r1 = r13.next()     // Catch:{ all -> 0x0131 }
            com.didi.onehybrid.resource.offline.OfflineBundle r1 = (com.didi.onehybrid.resource.offline.OfflineBundle) r1     // Catch:{ all -> 0x0131 }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ all -> 0x0131 }
            r2.<init>()     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "bundle_name"
            java.lang.String r4 = r1.getName()     // Catch:{ all -> 0x0131 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "version"
            java.lang.String r4 = r1.getVersion()     // Catch:{ all -> 0x0131 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "state"
            int r4 = r1.getState()     // Catch:{ all -> 0x0131 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0131 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "md5"
            java.lang.String r4 = r1.getMD5()     // Catch:{ all -> 0x0131 }
            r2.put(r3, r4)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "bundle_name= ?"
            r4 = 1
            java.lang.String[] r5 = new java.lang.String[r4]     // Catch:{ all -> 0x0131 }
            r6 = 0
            java.lang.String r7 = r1.getName()     // Catch:{ all -> 0x0131 }
            r5[r6] = r7     // Catch:{ all -> 0x0131 }
            int r6 = r1.getDbOperation()     // Catch:{ all -> 0x0131 }
            r7 = 5
            r8 = 0
            if (r6 == r4) goto L_0x00d4
            r9 = 2
            if (r6 == r9) goto L_0x006c
            r1 = 3
            if (r6 == r1) goto L_0x00c8
            goto L_0x0018
        L_0x006c:
            java.lang.String r6 = "offlinebundles"
            r0.update(r6, r2, r3, r5)     // Catch:{ all -> 0x0131 }
            java.util.List r2 = r1.getResouceInfoList()     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x00c8
            boolean r6 = r2.isEmpty()     // Catch:{ all -> 0x0131 }
            if (r6 != 0) goto L_0x00c8
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0131 }
        L_0x0081:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0131 }
            if (r6 == 0) goto L_0x00c8
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0131 }
            com.didi.onehybrid.resource.offline.OfflineBundle$ResourceInfo r6 = (com.didi.onehybrid.resource.offline.OfflineBundle.ResourceInfo) r6     // Catch:{ all -> 0x0131 }
            int r9 = r6.getAction()     // Catch:{ all -> 0x0131 }
            if (r9 != r4) goto L_0x00c2
            android.content.ContentValues r9 = new android.content.ContentValues     // Catch:{ all -> 0x0131 }
            r9.<init>()     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = "bundle_name"
            java.lang.String r11 = r1.getName()     // Catch:{ all -> 0x0131 }
            r9.put(r10, r11)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = "resource_url"
            java.lang.String r11 = r6.getUrl()     // Catch:{ all -> 0x0131 }
            r9.put(r10, r11)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = "resource_name"
            java.lang.String r11 = r6.getFile()     // Catch:{ all -> 0x0131 }
            r9.put(r10, r11)     // Catch:{ all -> 0x0131 }
            java.lang.String r10 = "md5"
            java.lang.String r6 = r6.getMd5()     // Catch:{ all -> 0x0131 }
            r9.put(r10, r6)     // Catch:{ all -> 0x0131 }
            java.lang.String r6 = "offlinebundleresource"
            r0.insertWithOnConflict(r6, r8, r9, r7)     // Catch:{ all -> 0x0131 }
            goto L_0x0081
        L_0x00c2:
            java.lang.String r6 = "offlinebundleresource"
            r0.delete(r6, r3, r5)     // Catch:{ all -> 0x0131 }
            goto L_0x0081
        L_0x00c8:
            java.lang.String r1 = "offlinebundles"
            r0.delete(r1, r3, r5)     // Catch:{ all -> 0x0131 }
            java.lang.String r1 = "offlinebundleresource"
            r0.delete(r1, r3, r5)     // Catch:{ all -> 0x0131 }
            goto L_0x0018
        L_0x00d4:
            java.lang.String r3 = "offlinebundles"
            r0.insertWithOnConflict(r3, r8, r2, r7)     // Catch:{ all -> 0x0131 }
            java.util.List r2 = r1.getResouceInfoList()     // Catch:{ all -> 0x0131 }
            if (r2 == 0) goto L_0x0018
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0131 }
            if (r3 != 0) goto L_0x0018
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0131 }
        L_0x00e9:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0131 }
            if (r3 == 0) goto L_0x0018
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0131 }
            com.didi.onehybrid.resource.offline.OfflineBundle$ResourceInfo r3 = (com.didi.onehybrid.resource.offline.OfflineBundle.ResourceInfo) r3     // Catch:{ all -> 0x0131 }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ all -> 0x0131 }
            r4.<init>()     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = "bundle_name"
            java.lang.String r6 = r1.getName()     // Catch:{ all -> 0x0131 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = "resource_url"
            java.lang.String r6 = r3.getUrl()     // Catch:{ all -> 0x0131 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = "resource_name"
            java.lang.String r6 = r3.getFile()     // Catch:{ all -> 0x0131 }
            r4.put(r5, r6)     // Catch:{ all -> 0x0131 }
            java.lang.String r5 = "md5"
            java.lang.String r3 = r3.getMd5()     // Catch:{ all -> 0x0131 }
            r4.put(r5, r3)     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "offlinebundleresource"
            r0.insertWithOnConflict(r3, r8, r4, r7)     // Catch:{ all -> 0x0131 }
            goto L_0x00e9
        L_0x0124:
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x0131 }
            r0.endTransaction()     // Catch:{ all -> 0x0131 }
            com.didi.onehybrid.resource.offline.DatabaseManager r13 = r12.mDatabaseManager     // Catch:{ all -> 0x0131 }
            r13.closeDatabase()     // Catch:{ all -> 0x0131 }
            monitor-exit(r12)
            return
        L_0x0131:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        L_0x0134:
            monitor-exit(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.onehybrid.resource.offline.OfflineBundleDao.updateBundleInfo(java.util.List):void");
    }

    public synchronized void updateBundleInfo(OfflineBundle offlineBundle) {
        SQLiteDatabase writableDatabase = this.mDatabaseManager.getWritableDatabase();
        writableDatabase.beginTransaction();
        String[] strArr = {offlineBundle.getName()};
        ContentValues contentValues = new ContentValues();
        contentValues.put("bundle_name", offlineBundle.getName());
        contentValues.put("version", offlineBundle.getVersion());
        contentValues.put("state", Integer.valueOf(offlineBundle.getState()));
        contentValues.put("md5", offlineBundle.getMD5());
        writableDatabase.update(FusionContract.OfflineBundle.TABLE_NAME, contentValues, "bundle_name= ?", strArr);
        List<OfflineBundle.ResourceInfo> resouceInfoList = offlineBundle.getResouceInfoList();
        if (resouceInfoList != null && !resouceInfoList.isEmpty()) {
            for (OfflineBundle.ResourceInfo next : resouceInfoList) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("bundle_name", offlineBundle.getName());
                contentValues2.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_URL, next.getUrl());
                contentValues2.put(FusionContract.OfflineBundle.COLUMN_NAME_RESOURCE_NAME, next.getFile());
                contentValues2.put("md5", next.getMd5());
                writableDatabase.insertWithOnConflict(FusionContract.OfflineBundle.TABLE_RESOURCE_NAME, (String) null, contentValues2, 5);
            }
        }
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        this.mDatabaseManager.closeDatabase();
    }

    public void deleteBundleInfo(OfflineBundle offlineBundle) {
        SQLiteDatabase writableDatabase = this.mDatabaseManager.getWritableDatabase();
        writableDatabase.beginTransaction();
        String[] strArr = {offlineBundle.getName()};
        writableDatabase.delete(FusionContract.OfflineBundle.TABLE_NAME, "bundle_name= ?", strArr);
        writableDatabase.delete(FusionContract.OfflineBundle.TABLE_RESOURCE_NAME, "bundle_name= ?", strArr);
        writableDatabase.setTransactionSuccessful();
        writableDatabase.endTransaction();
        this.mDatabaseManager.closeDatabase();
    }

    public void destroy() {
        this.mDatabaseManager.closeDatabase();
    }
}
