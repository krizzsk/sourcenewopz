package com.didi.onehybrid.resource.offline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.didi.onehybrid.resource.offline.FusionContract;
import com.didi.security.uuid.share.ShareDBHelper;
import java.util.ArrayList;
import java.util.List;

public class BundleInfoDao {
    private FusionDbHelper mFusionDbHelper;

    public BundleInfoDao(Context context) {
        this.mFusionDbHelper = new FusionDbHelper(context);
    }

    public List<OfflineBundleInfo> loadAllBundleInfos() {
        ArrayList arrayList = new ArrayList();
        Cursor query = this.mFusionDbHelper.getReadableDatabase().query(FusionContract.OfflineBundle.TABLE_NAME, new String[]{ShareDBHelper.ID_NAME, "bundle_name", "download_url", "version", "md5", "state", "download_mode"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        if (query != null) {
            try {
                if (query.getCount() > 0) {
                    while (query.moveToNext()) {
                        OfflineBundleInfo offlineBundleInfo = new OfflineBundleInfo();
                        offlineBundleInfo.setBundleName(query.getString(1));
                        offlineBundleInfo.setOriginUrl(query.getString(2));
                        offlineBundleInfo.setDownloadUrl(query.getString(3));
                        offlineBundleInfo.setBundleVersion(query.getString(4));
                        offlineBundleInfo.setMd5(query.getString(5));
                        offlineBundleInfo.setState(query.getInt(6));
                        offlineBundleInfo.setDownloadMode(query.getInt(7));
                        arrayList.add(offlineBundleInfo);
                    }
                }
            } catch (Throwable th) {
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }
        if (query != null) {
            query.close();
        }
        return arrayList;
    }

    public void addBundleInfo(OfflineBundleInfo offlineBundleInfo) {
        if (offlineBundleInfo != null) {
            SQLiteDatabase writableDatabase = this.mFusionDbHelper.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_name", offlineBundleInfo.getBundleName());
            contentValues.put("download_url", offlineBundleInfo.getDownloadUrl());
            contentValues.put("version", offlineBundleInfo.getBundleVersion());
            contentValues.put("md5", offlineBundleInfo.getMd5());
            contentValues.put("state", Integer.valueOf(offlineBundleInfo.getState()));
            contentValues.put("download_mode", Integer.valueOf(offlineBundleInfo.getDownloadMode()));
            writableDatabase.insertWithOnConflict(FusionContract.OfflineBundle.TABLE_NAME, (String) null, contentValues, 5);
        }
    }

    public void updateBundleInfo(OfflineBundleInfo offlineBundleInfo) {
        SQLiteDatabase writableDatabase = this.mFusionDbHelper.getWritableDatabase();
        String[] strArr = {offlineBundleInfo.getBundleName()};
        ContentValues contentValues = new ContentValues();
        contentValues.put("download_url", offlineBundleInfo.getDownloadUrl());
        contentValues.put("version", offlineBundleInfo.getBundleVersion());
        contentValues.put("md5", offlineBundleInfo.getMd5());
        contentValues.put("state", Integer.valueOf(offlineBundleInfo.getState()));
        contentValues.put("download_mode", Integer.valueOf(offlineBundleInfo.getDownloadMode()));
        writableDatabase.update(FusionContract.OfflineBundle.TABLE_NAME, contentValues, "bundle_name= ?", strArr);
    }

    public void deleteBundleInfo(OfflineBundleInfo offlineBundleInfo) {
        this.mFusionDbHelper.getWritableDatabase().delete(FusionContract.OfflineBundle.TABLE_NAME, "bundle_name= ?", new String[]{offlineBundleInfo.getBundleName()});
    }

    public void destroy() {
        this.mFusionDbHelper.close();
    }
}
