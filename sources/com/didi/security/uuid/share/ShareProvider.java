package com.didi.security.uuid.share;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Build;
import java.util.HashMap;

public class ShareProvider extends ContentProvider {

    /* renamed from: a */
    private SQLiteDatabase f38563a;

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        ShareManager.getInstance().init(getContext());
        this.f38563a = ShareManager.getInstance().getDB();
        return false;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("token");
        if (Build.VERSION.SDK_INT >= 14) {
            sQLiteQueryBuilder.setStrict(true);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ShareDBHelper.ID_NAME, ShareDBHelper.ID_NAME);
        hashMap.put("data", "data");
        sQLiteQueryBuilder.setProjectionMap(hashMap);
        return sQLiteQueryBuilder.query(this.f38563a, new String[]{ShareDBHelper.ID_NAME, "data"}, str, strArr2, (String) null, (String) null, str2, (String) null);
    }
}
