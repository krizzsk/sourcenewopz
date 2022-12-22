package com.didi.security.uuid.share;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.didi.hawaii.basic.HWSupportedAppVersion;
import com.didi.safetoolkit.util.SfAppUtils;
import java.util.ArrayList;

public class ShareManager {

    /* renamed from: a */
    private SQLiteDatabase f38559a;

    /* renamed from: b */
    private Context f38560b;

    /* renamed from: c */
    private ArrayList<String> f38561c;

    /* renamed from: d */
    private String f38562d;

    private static class SingletonInstance {
        /* access modifiers changed from: private */
        public static final ShareManager INSTANCE = new ShareManager();

        private SingletonInstance() {
        }
    }

    public static ShareManager getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public void init(Context context) {
        this.f38560b = context;
        try {
            this.f38559a = new ShareDBHelper(this.f38560b.getApplicationContext()).getWritableDatabase();
        } catch (Throwable unused) {
        }
        this.f38562d = this.f38560b.getPackageName();
        m27317a();
    }

    public SQLiteDatabase getDB() {
        return this.f38559a;
    }

    public void setToken(String str) {
        if (this.f38559a != null) {
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(ShareDBHelper.ID_NAME, 1);
                contentValues.put("data", str);
                this.f38559a.insertWithOnConflict("token", (String) null, contentValues, 5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m27317a() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.f38561c = arrayList;
        arrayList.add("com.didiglobal.fleet");
        this.f38561c.add("com.didiglobal.driver");
        this.f38561c.add(SfAppUtils.BRZ_DRIVER_PACKAGE_NAME);
        this.f38561c.add("com.didiglobal.driver.au");
        this.f38561c.add("com.didiglobal.passenger");
        this.f38561c.add("com.taxis99");
        this.f38561c.add(HWSupportedAppVersion.DRIVER_HK_PACKAGE_NAME);
        this.f38561c.add("com.sdu.didi.gsui.tw");
        this.f38561c.add("com.sdu.didi.gsui.jp");
        this.f38561c.add("com.xiaojukeji.didi.global.customer");
        this.f38561c.add("com.xiaojukeji.didi.global.merchant");
        this.f38561c.add("com.didi.global.rider");
        this.f38561c.add("com.xiaojukeji.didi.global.bd");
        this.f38561c.add("com.didi.brazil.rider");
        this.f38561c.add("com.xiaojukeji.didi.brazil.customer");
        this.f38561c.add("com.xiaojukeji.didi.brazil.merchant");
    }

    public String getToken() {
        for (int i = 0; i < this.f38561c.size(); i++) {
            String str = this.f38561c.get(i);
            if (!str.equals(this.f38562d)) {
                try {
                    Cursor query = this.f38560b.getContentResolver().query(Uri.parse("content://" + str + ".share/"), (String[]) null, (String) null, (String[]) null, (String) null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            int i2 = query.getInt(query.getColumnIndex(ShareDBHelper.ID_NAME));
                            String string = query.getString(query.getColumnIndex("data"));
                            if (i2 == 1) {
                                query.close();
                                return string;
                            }
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
