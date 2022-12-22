package com.didichuxing.publicservice.p196db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.didichuxing.publicservice.p196db.base.AdDbHelper;
import com.didichuxing.publicservice.p196db.model.ScreenAdModel;
import com.didichuxing.publicservice.resourcecontrol.pojo.Resource;
import java.io.File;
import java.util.ArrayList;

@Deprecated
/* renamed from: com.didichuxing.publicservice.db.dao.ScreenAdDao */
public class ScreenAdDao implements Dao {
    private String[] allColumns = {ScreenAdModel.ScreenAdColumn.CONTENT_ID, "url", ScreenAdModel.ScreenAdColumn.BEGIN_TIME, "end_time", "last_show_time", ScreenAdModel.ScreenAdColumn.LOCAL_PATH, ScreenAdModel.ScreenAdColumn.AD_URL, "clickContent", ScreenAdModel.ScreenAdColumn.IS_AD};
    private ScreenAdModel model = ScreenAdModel.getInstance();

    private ContentValues fillValues(Resource.SingleResource singleResource) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ScreenAdModel.ScreenAdColumn.CONTENT_ID, Integer.valueOf(singleResource.contentId));
        contentValues.put("url", singleResource.image);
        contentValues.put(ScreenAdModel.ScreenAdColumn.BEGIN_TIME, Long.valueOf(singleResource.beginTime));
        contentValues.put("end_time", Long.valueOf(singleResource.endTime));
        contentValues.put("last_show_time", Long.valueOf(singleResource.lastShowTime));
        contentValues.put(ScreenAdModel.ScreenAdColumn.LOCAL_PATH, singleResource.localPath);
        contentValues.put(ScreenAdModel.ScreenAdColumn.AD_URL, singleResource.url);
        contentValues.put("clickContent", singleResource.clickContent);
        contentValues.put(ScreenAdModel.ScreenAdColumn.IS_AD, Integer.valueOf(singleResource.isAd));
        return contentValues;
    }

    public long insertSingleResource(Context context, Resource.SingleResource singleResource) {
        return this.model.insert(fillValues(singleResource), AdDbHelper.getInstance(context));
    }

    public boolean deleteSingleResource(Context context, long j) {
        boolean z = false;
        String[] strArr = {j + ""};
        Cursor query = this.model.query(new String[]{ScreenAdModel.ScreenAdColumn.LOCAL_PATH}, "content_id = ?", strArr, (String) null, AdDbHelper.getInstance(context));
        if (query != null) {
            try {
                if (query.getCount() == 1) {
                    query.moveToNext();
                    this.model.delete("content_id = ?", strArr, AdDbHelper.getInstance(context));
                    z = new File(query.getString(query.getColumnIndex(ScreenAdModel.ScreenAdColumn.LOCAL_PATH))).delete();
                }
            } finally {
                query.close();
            }
        }
        return z;
    }

    public void deleteSingleResource(Context context, long j, String str) {
        String[] strArr = {j + ""};
        new File(str).delete();
        this.model.delete("content_id = ?", strArr, AdDbHelper.getInstance(context));
    }

    public int updateLastShowTime(Context context, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_show_time", Long.valueOf(System.currentTimeMillis()));
        return this.model.update(contentValues, "content_id = ?", new String[]{j + ""}, AdDbHelper.getInstance(context));
    }

    public Resource getAllResource(Context context) {
        Cursor query = this.model.query(this.allColumns, (String) null, (String[]) null, "last_show_time ASC", AdDbHelper.getInstance(context));
        Resource resource = null;
        if (query != null) {
            try {
                if (query.getCount() > 0) {
                    resource = new Resource();
                    resource.list = new ArrayList();
                    while (query.moveToNext()) {
                        resource.list.add(getSingleResource(query));
                    }
                }
            } finally {
                query.close();
            }
        }
        return resource;
    }

    /* JADX INFO: finally extract failed */
    public boolean isSingleResourceExists(Context context, long j) {
        boolean z = true;
        Cursor query = this.model.query(this.allColumns, "content_id = ?", new String[]{j + ""}, (String) null, AdDbHelper.getInstance(context));
        if (query == null) {
            return false;
        }
        try {
            if (query.getCount() == 1) {
                query.moveToNext();
                String string = query.getString(query.getColumnIndex(ScreenAdModel.ScreenAdColumn.LOCAL_PATH));
                if (new File(string).exists()) {
                    query.close();
                    return z;
                }
                deleteSingleResource(context, j, string);
            }
            z = false;
            query.close();
            return z;
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    private Resource.SingleResource getSingleResource(Cursor cursor) {
        Resource.SingleResource singleResource = new Resource.SingleResource();
        singleResource.contentId = cursor.getInt(cursor.getColumnIndex(ScreenAdModel.ScreenAdColumn.CONTENT_ID));
        singleResource.image = cursor.getString(cursor.getColumnIndex("url"));
        singleResource.beginTime = cursor.getLong(cursor.getColumnIndex(ScreenAdModel.ScreenAdColumn.BEGIN_TIME));
        singleResource.endTime = cursor.getLong(cursor.getColumnIndex("end_time"));
        singleResource.lastShowTime = cursor.getLong(cursor.getColumnIndex("last_show_time"));
        singleResource.localPath = cursor.getString(cursor.getColumnIndex(ScreenAdModel.ScreenAdColumn.LOCAL_PATH));
        singleResource.url = cursor.getString(cursor.getColumnIndex(ScreenAdModel.ScreenAdColumn.AD_URL));
        singleResource.clickContent = cursor.getString(cursor.getColumnIndex("clickContent"));
        singleResource.isAd = cursor.getInt(cursor.getColumnIndex(ScreenAdModel.ScreenAdColumn.IS_AD));
        return singleResource;
    }
}
