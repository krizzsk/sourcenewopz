package com.didi.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import com.didichuxing.foundation.util.ProcessUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u001a\u0018\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010\u001a\u001f\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0001¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, mo175978d2 = {"getLockScreenNotShow", "", "context", "Landroid/content/Context;", "hasLockScreenMap", "", "hasOverlayPermission", "requestAppSetting", "", "activity", "requestAppSettingForResult", "Landroid/app/Activity;", "requestCode", "", "setLockScreenMap", "boolean", "(Landroid/content/Context;Z)Lkotlin/Unit;", "setLockScreenNotShow", "oid", "(Landroid/content/Context;Ljava/lang/String;)Lkotlin/Unit;", "TheOneSDKGlobal_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LockScreenUtil.kt */
public final class LockScreenUtilKt {
    public static final boolean hasLockScreenMap(Context context) {
        if (context == null) {
            return true;
        }
        return CommonSharedPreferences.getInstance(context).isLockScreenMapShow();
    }

    public static final Unit setLockScreenMap(Context context, boolean z) {
        if (context == null) {
            return null;
        }
        CommonSharedPreferences.getInstance(context).setLockScreenMapShow(z);
        return Unit.INSTANCE;
    }

    public static final boolean hasOverlayPermission(Context context) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return Settings.canDrawOverlays(context);
        }
        return true;
    }

    public static final Unit setLockScreenNotShow(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "oid");
        if (context == null) {
            return null;
        }
        CommonSharedPreferences.getInstance(context).setLockScreenNotShow(str);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r1 = com.didi.sdk.util.CommonSharedPreferences.getInstance(r1).getLockScreenNotShow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getLockScreenNotShow(android.content.Context r1) {
        /*
            java.lang.String r0 = ""
            if (r1 != 0) goto L_0x0005
            goto L_0x0011
        L_0x0005:
            com.didi.sdk.util.CommonSharedPreferences r1 = com.didi.sdk.util.CommonSharedPreferences.getInstance(r1)
            java.lang.String r1 = r1.getLockScreenNotShow()
            if (r1 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.util.LockScreenUtilKt.getLockScreenNotShow(android.content.Context):java.lang.String");
    }

    public static final void requestAppSetting(Context context) {
        if (!hasOverlayPermission(context)) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(Intrinsics.stringPlus("package:", ProcessUtil.getPackageName())));
            intent.setFlags(268435456);
            if (context != null) {
                if (!(intent.resolveActivity(context.getPackageManager()) != null)) {
                    context = null;
                }
                if (context != null) {
                    context.startActivity(intent);
                }
            }
        }
    }

    public static final void requestAppSettingForResult(Activity activity, int i) {
        if (!hasOverlayPermission(activity)) {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(Intrinsics.stringPlus("package:", ProcessUtil.getPackageName())));
            if (activity != null) {
                if (!(intent.resolveActivity(activity.getPackageManager()) != null)) {
                    activity = null;
                }
                if (activity != null) {
                    activity.startActivityForResult(intent, i);
                }
            }
        }
    }
}
