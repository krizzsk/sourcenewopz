package com.didi.sdk.logging;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.didi.sdk.logging.upload.UploadTaskManager;

public final class InitProvider extends ContentProvider {

    /* renamed from: a */
    private static final String f36478a = "LogInitProvider";

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public boolean onCreate() {
        try {
            Context context = getContext();
            LoggerContext.getDefault().init(context);
            UploadTaskManager.getInstance().init(context);
            return false;
        } catch (Exception e) {
            Log.e(f36478a, "Failed to auto initialize InitProvider", e);
            return false;
        }
    }
}
