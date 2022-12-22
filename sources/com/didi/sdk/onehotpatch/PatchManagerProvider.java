package com.didi.sdk.onehotpatch;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import com.didi.sdk.onehotpatch.commonstatic.PatchManager;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import java.io.File;
import java.util.Set;

public class PatchManagerProvider extends ContentProvider {
    private SharedPreferencesWrapper mSp;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
    }

    public boolean onCreate() {
        try {
            this.mSp = SharedPreferencesWrapper.m14516of(getContext(), PatchManager.SP_HOTPATCH_PATCH_INFO, 0);
            File file = new File(getContext().getFilesDir(), "patch_info.properties");
            if (!file.exists()) {
                return true;
            }
            file.delete();
            return true;
        } catch (Throwable th) {
            Logger.warn(th);
            return true;
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!(this.mSp == null || strArr == null || strArr.length == 0)) {
            try {
                MatrixCursor matrixCursor = new MatrixCursor(strArr);
                String[] strArr3 = new String[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    strArr3[i] = this.mSp.getString(strArr[i], (String) null);
                }
                matrixCursor.addRow(strArr3);
                return matrixCursor;
            } catch (Throwable th) {
                Logger.warn(th);
            }
        }
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        if (this.mSp == null) {
            return null;
        }
        try {
            Set<String> keySet = contentValues.keySet();
            SharedPreferencesWrapper.Editor edit = this.mSp.edit();
            for (String next : keySet) {
                edit.putString(next, contentValues.getAsString(next));
            }
            edit.commitNow();
        } catch (Throwable th) {
            Logger.warn(th);
        }
        return null;
    }
}
