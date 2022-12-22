package com.didi.drouter.store;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.didi.drouter.utils.RouterLogger;
import com.didi.drouter.utils.SystemUtil;
import com.didi.sdk.apm.SystemUtils;

public class LoadProvider extends ContentProvider {
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
        SystemUtils.log(3, RouterLogger.NAME, "[LoadProvider] onCreate and DRouter set application | " + getContext(), (Throwable) null, "com.didi.drouter.store.LoadProvider", 23);
        SystemUtil.setApplication((Application) getContext());
        new Thread("drouter-init-thread") {
            public void run() {
                SystemUtils.log(3, RouterLogger.NAME, "[LoadProvider] DRouter start load router table in drouter-init-thread", (Throwable) null, "com.didi.drouter.store.LoadProvider$1", 28);
                RouterStore.load("host");
            }
        }.start();
        return false;
    }
}
