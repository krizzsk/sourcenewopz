package com.didichuxing.publicservice.p196db.model;

import android.provider.BaseColumns;
import com.didi.security.uuid.share.ShareDBHelper;
import com.didichuxing.publicservice.p196db.base.BaseModel;

/* renamed from: com.didichuxing.publicservice.db.model.ScreenAdModel */
public class ScreenAdModel extends BaseModel {

    /* renamed from: com.didichuxing.publicservice.db.model.ScreenAdModel$ScreenAdColumn */
    public static class ScreenAdColumn implements BaseColumns {
        public static final String AD_URL = "ad_url";
        public static final String BEGIN_TIME = "begin_time";
        public static final String CLICK_CONTENT = "clickContent";
        public static final String CONTENT_ID = "content_id";
        public static final String END_TIME = "end_time";
        public static final String IS_AD = "isAd";
        public static final String LAST_SHOW_TIME = "last_show_time";
        public static final String LOCAL_PATH = "local_path";
        public static final String URL = "url";
    }

    private ScreenAdModel(String str) {
        this.tableName = str;
    }

    /* renamed from: com.didichuxing.publicservice.db.model.ScreenAdModel$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ScreenAdModel INSTANCE = new ScreenAdModel("screen_ad");

        private SingletonHolder() {
        }
    }

    public static ScreenAdModel getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public String getCreateSql() {
        return "CREATE TABLE IF NOT EXISTS " + this.tableName + "(" + ShareDBHelper.ID_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT," + ScreenAdColumn.CONTENT_ID + " INTEGER UNIQUE ON CONFLICT REPLACE," + "url" + " TEXT," + ScreenAdColumn.BEGIN_TIME + " INTEGER," + "end_time" + " INTEGER," + "last_show_time" + " INTEGER," + ScreenAdColumn.LOCAL_PATH + " TEXT," + ScreenAdColumn.AD_URL + " TEXT," + "clickContent" + " TEXT," + ScreenAdColumn.IS_AD + " INTEGER);";
    }
}
