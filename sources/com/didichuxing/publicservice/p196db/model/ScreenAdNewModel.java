package com.didichuxing.publicservice.p196db.model;

import android.provider.BaseColumns;
import com.didi.security.uuid.share.ShareDBHelper;
import com.didichuxing.publicservice.p196db.base.BaseModel;

/* renamed from: com.didichuxing.publicservice.db.model.ScreenAdNewModel */
public class ScreenAdNewModel extends BaseModel {

    /* renamed from: com.didichuxing.publicservice.db.model.ScreenAdNewModel$ScreenAdNewColumn */
    public static class ScreenAdNewColumn implements BaseColumns {
        public static final String ACTIVITY_ID = "activity_id";
        public static final String CDN = "cdn";
        public static final String CLICK_CONTENT = "clickContent";
        public static final String IMAGE = "image";
        public static final String IS_AD = "is_ad";
        public static final String IS_DEFAULT = "is_default";
        public static final String IS_SINGLE = "is_single";
        public static final String LAST_SHOW_TIME = "last_show_time";
        public static final String LOCAL_PATH = "localPath";
        public static final String LOG_DATA = "logo_data";
        public static final String MUILT_SIZE = "muilt_size";
        public static final String TIME_SEGS = "timesegs";
        public static final String URL = "url";
        public static final String USE_LOGO = "use_logo";
        public static final String XML_DATA = "xml_data";
        public static final String XML_NODE_CACHE = "xml_node_cache";
    }

    private ScreenAdNewModel(String str) {
        this.tableName = str;
    }

    /* renamed from: com.didichuxing.publicservice.db.model.ScreenAdNewModel$SingletonHolder */
    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static final ScreenAdNewModel instance = new ScreenAdNewModel("screen_ad_new");

        private SingletonHolder() {
        }
    }

    public static ScreenAdNewModel getInstance() {
        return SingletonHolder.instance;
    }

    public String getCreateSql() {
        return "CREATE TABLE IF NOT EXISTS " + this.tableName + "(" + ShareDBHelper.ID_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT," + "activity_id" + " INTEGER UNIQUE ON CONFLICT REPLACE," + ScreenAdNewColumn.CDN + " TEXT," + ScreenAdNewColumn.XML_DATA + " TEXT," + ScreenAdNewColumn.XML_NODE_CACHE + " TEXT," + ScreenAdNewColumn.IS_AD + " INTEGER," + ScreenAdNewColumn.USE_LOGO + " INTEGER," + ScreenAdNewColumn.MUILT_SIZE + " INTEGER," + ScreenAdNewColumn.IS_SINGLE + " INTEGER," + ScreenAdNewColumn.IS_DEFAULT + " INTEGER," + "url" + " TEXT," + "clickContent" + " TEXT," + "image" + " TEXT," + ScreenAdNewColumn.LOCAL_PATH + " TEXT," + "last_show_time" + " TEXT," + ScreenAdNewColumn.LOG_DATA + " TEXT," + ScreenAdNewColumn.TIME_SEGS + " TEXT);";
    }
}
