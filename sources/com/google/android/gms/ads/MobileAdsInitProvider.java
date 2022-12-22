package com.google.android.gms.ads;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.google.android.gms.internal.ads.zzzx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
public class MobileAdsInitProvider extends ContentProvider {
    private final zzzx zzadu = new zzzx();

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.zzadu.attachInfo(context, providerInfo);
    }

    public boolean onCreate() {
        return this.zzadu.onCreate();
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return this.zzadu.query(uri, strArr, str, strArr2, str2);
    }

    public String getType(Uri uri) {
        return this.zzadu.getType(uri);
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return this.zzadu.insert(uri, contentValues);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return this.zzadu.delete(uri, str, strArr);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return this.zzadu.update(uri, contentValues, str, strArr);
    }
}
