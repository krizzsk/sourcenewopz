package com.didichuxing.publicservice.p196db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.p196db.base.AdDbHelper;
import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import com.didichuxing.publicservice.resourcecontrol.pojo.DSplashResource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.didichuxing.publicservice.db.dao.ScreenAdNewDao */
public class ScreenAdNewDao implements Dao {
    public static final int FLAG_ALL_RESOURCE = 0;
    public static final int FLAG_AVAILABLE_RESOURCE = 1;
    public static final int FLAG_EXPIRED_RESOURCE = 2;
    private String[] allColumns = {"activity_id", ScreenAdNewModel.ScreenAdNewColumn.CDN, ScreenAdNewModel.ScreenAdNewColumn.XML_DATA, ScreenAdNewModel.ScreenAdNewColumn.XML_NODE_CACHE, ScreenAdNewModel.ScreenAdNewColumn.IS_AD, ScreenAdNewModel.ScreenAdNewColumn.USE_LOGO, ScreenAdNewModel.ScreenAdNewColumn.MUILT_SIZE, ScreenAdNewModel.ScreenAdNewColumn.IS_SINGLE, ScreenAdNewModel.ScreenAdNewColumn.IS_DEFAULT, "url", "clickContent", "image", ScreenAdNewModel.ScreenAdNewColumn.LOCAL_PATH, "last_show_time", ScreenAdNewModel.ScreenAdNewColumn.TIME_SEGS, ScreenAdNewModel.ScreenAdNewColumn.LOG_DATA};
    private ScreenAdNewModel model = ScreenAdNewModel.getInstance();

    public ScreenAdNewDao() {
    }

    private ContentValues fillValues(DSplashResource.DataBean dataBean) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("activity_id", Integer.valueOf(dataBean.activity_id));
        if (!TextUtils.isEmpty(dataBean.cdn)) {
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.CDN, dataBean.cdn);
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.XML_DATA, AppUtils.convertObjectToString(dataBean.data));
        } else {
            DSplashResource.DataDetail dataDetail = dataBean.getDataDetail();
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.IS_AD, Integer.valueOf(dataDetail.is_ad));
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.MUILT_SIZE, Integer.valueOf(dataDetail.muilt_size));
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.IS_SINGLE, Integer.valueOf(dataDetail.is_single));
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.IS_DEFAULT, Integer.valueOf(dataDetail.is_default));
            contentValues.put("url", dataDetail.url);
            contentValues.put("clickContent", dataDetail.clickContent);
            contentValues.put("image", dataDetail.image);
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.LOCAL_PATH, dataDetail.localPath);
            contentValues.put("last_show_time", Long.valueOf(dataDetail.lastShowTime));
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.USE_LOGO, Integer.valueOf(dataDetail.useLogo));
        }
        List<DSplashResource.TimesegsBean> list = dataBean.timesegs;
        if (list != null && list.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.setLength(0);
            for (DSplashResource.TimesegsBean next : list) {
                stringBuffer.append(next.start_time + "-" + next.end_time + ":");
            }
            contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.TIME_SEGS, stringBuffer.toString());
        }
        contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.LOG_DATA, dataBean.getLogData());
        return contentValues;
    }

    public long insertSingleResource(Context context, DSplashResource.DataBean dataBean) {
        return this.model.insert(fillValues(dataBean), AdDbHelper.getInstance(context));
    }

    public boolean deleteSingleResource(Context context, long j) {
        boolean z = false;
        String[] strArr = {j + ""};
        Cursor query = this.model.query(new String[]{ScreenAdNewModel.ScreenAdNewColumn.LOCAL_PATH}, "activity_id = ?", strArr, (String) null, AdDbHelper.getInstance(context));
        if (query != null) {
            try {
                if (query.getCount() == 1) {
                    query.moveToNext();
                    this.model.delete("activity_id = ?", strArr, AdDbHelper.getInstance(context));
                    z = new File(query.getString(query.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.LOCAL_PATH))).delete();
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
        this.model.delete("activity_id = ?", strArr, AdDbHelper.getInstance(context));
    }

    public int updateLastShowTime(Context context, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("last_show_time", Long.valueOf(System.currentTimeMillis()));
        return this.model.update(contentValues, "activity_id = ?", new String[]{j + ""}, AdDbHelper.getInstance(context));
    }

    public int updateLocalPath(Context context, long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.LOCAL_PATH, str);
        return this.model.update(contentValues, "activity_id = ?", new String[]{j + ""}, AdDbHelper.getInstance(context));
    }

    public int updateXMLNode(Context context, long j, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ScreenAdNewModel.ScreenAdNewColumn.XML_NODE_CACHE, str);
        return this.model.update(contentValues, "activity_id = ?", new String[]{j + ""}, AdDbHelper.getInstance(context));
    }

    public DSplashResource getResourceByResourceFlag(Context context, int i) {
        Cursor query = this.model.query(this.allColumns, (String) null, (String[]) null, "last_show_time ASC", AdDbHelper.getInstance(context));
        DSplashResource dSplashResource = null;
        if (query != null) {
            try {
                if (query.getCount() > 0) {
                    dSplashResource = new DSplashResource();
                    dSplashResource.data = new ArrayList();
                    while (query.moveToNext()) {
                        DSplashResource.DataBean singleResource = getSingleResource(query, i);
                        if (singleResource != null) {
                            dSplashResource.data.add(singleResource);
                        }
                    }
                }
            } finally {
                query.close();
            }
        }
        return dSplashResource;
    }

    private DSplashResource.DataBean getSingleResource(Cursor cursor, int i) {
        if (!isSplashResourceTimeAvailable(cursor.getString(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.TIME_SEGS)), i)) {
            return null;
        }
        DSplashResource.DataBean dataBean = new DSplashResource.DataBean();
        dataBean.activity_id = cursor.getInt(cursor.getColumnIndex("activity_id"));
        dataBean.cdn = cursor.getString(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.CDN));
        if (!TextUtils.isEmpty(dataBean.cdn)) {
            dataBean.data = AppUtils.parseJson(cursor.getString(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.XML_DATA)), Map.class);
        } else {
            DSplashResource.DataDetail dataDetail = new DSplashResource.DataDetail();
            dataDetail.is_ad = cursor.getInt(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.IS_AD));
            dataDetail.useLogo = cursor.getInt(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.USE_LOGO));
            dataDetail.muilt_size = cursor.getInt(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.MUILT_SIZE));
            dataDetail.is_single = cursor.getInt(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.IS_SINGLE));
            dataDetail.is_default = cursor.getInt(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.IS_DEFAULT));
            dataDetail.url = cursor.getString(cursor.getColumnIndex("url"));
            dataDetail.clickContent = cursor.getString(cursor.getColumnIndex("clickContent"));
            dataDetail.image = cursor.getString(cursor.getColumnIndex("image"));
            dataDetail.localPath = cursor.getString(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.LOCAL_PATH));
            dataDetail.lastShowTime = cursor.getLong(cursor.getColumnIndex("last_show_time"));
            dataBean.dataDetail = dataDetail;
            if (!Apollo.getToggle("didipas_splash_mp4control").allow() && !TextUtils.isEmpty(dataBean.dataDetail.image) && dataBean.dataDetail.image.endsWith("mp4")) {
                return null;
            }
        }
        dataBean.setLogData(cursor.getString(cursor.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.LOG_DATA)));
        return dataBean;
    }

    private boolean isSplashResourceTimeAvailable(String str, int i) {
        String[] split;
        String[] split2 = str.split(":");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (split2 == null || split2.length <= 0) {
            return false;
        }
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2) && str2.contains("-") && (split = str2.split("-")) != null && split.length > 0 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                long parseLong = Long.parseLong(split[0]);
                long parseLong2 = Long.parseLong(split[1]);
                if (i == 1) {
                    if (currentTimeMillis >= parseLong && currentTimeMillis <= parseLong2) {
                    }
                } else if (i == 2) {
                    if (currentTimeMillis >= parseLong && currentTimeMillis <= parseLong2) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private List<DSplashResource.TimesegsBean> spiltStringTimesegs2List(String str, int i) {
        String[] split;
        String[] split2 = str.split(":");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (split2 == null || split2.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2) && str2.contains("-") && (split = str2.split("-")) != null && split.length > 0 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                DSplashResource.TimesegsBean timesegsBean = new DSplashResource.TimesegsBean();
                timesegsBean.start_time = Long.parseLong(split[0]);
                timesegsBean.end_time = Long.parseLong(split[1]);
                if (i == 0) {
                    arrayList.add(timesegsBean);
                } else if (i != 1) {
                    if (i == 2 && currentTimeMillis >= timesegsBean.start_time && currentTimeMillis <= timesegsBean.end_time && !isExistResourceInList(timesegsBean, arrayList)) {
                        arrayList.add(timesegsBean);
                    }
                } else if (currentTimeMillis >= timesegsBean.start_time && currentTimeMillis <= timesegsBean.end_time && !isExistResourceInList(timesegsBean, arrayList)) {
                    arrayList.add(timesegsBean);
                }
            }
        }
        return arrayList;
    }

    private boolean isExistResourceInList(DSplashResource.TimesegsBean timesegsBean, List<DSplashResource.TimesegsBean> list) {
        if (isEmpty(list)) {
            return false;
        }
        return list.contains(timesegsBean);
    }

    /* JADX INFO: finally extract failed */
    public boolean isSingleResourceExists(Context context, long j) {
        boolean z = true;
        Cursor query = this.model.query(this.allColumns, "activity_id = ?", new String[]{j + ""}, (String) null, AdDbHelper.getInstance(context));
        if (query == null) {
            return false;
        }
        try {
            if (query.getCount() == 1) {
                query.moveToNext();
                String string = query.getString(query.getColumnIndex(ScreenAdNewModel.ScreenAdNewColumn.LOCAL_PATH));
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

    private boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }
}
