package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.yanzhenjie.permission.runtime.Permission;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzabb {
    private final Context context;

    public zzabb(Context context2) {
        Preconditions.checkNotNull(context2, "Context can not be null");
        this.context = context2;
    }

    public final boolean zzsd() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public final boolean zzse() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return zza(intent);
    }

    public final boolean zzsf() {
        return ((Boolean) zzbr.zza(this.context, new zzaba())).booleanValue() && Wrappers.packageManager(this.context).checkCallingOrSelfPermission(Permission.WRITE_EXTERNAL_STORAGE) == 0;
    }

    public final boolean zzsg() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    private final boolean zza(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        if (!this.context.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            return true;
        }
        return false;
    }
}
