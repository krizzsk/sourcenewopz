package com.didi.sharesdk;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;

public class ShareEnvValidate {
    private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
    private static final String QZONE_PACKAGE_NAME = "com.qzone";
    private static final String SINA_WEIBO_PACKAGE_NAME = "com.sina.weibo";
    private static final String WEXIN_PACKAGE_NAME = "com.tencent.mm";

    /* JADX WARNING: Removed duplicated region for block: B:26:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isValidCheckWx(android.content.Context r7) {
        /*
            r0 = 0
            if (r7 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.pm.PackageManager r1 = r7.getPackageManager()
            r2 = 0
            r3 = 2131958057(0x7f131929, float:1.9552715E38)
            java.lang.String r4 = "com.tencent.mm"
            r5 = 4
            android.content.pm.PackageInfo r1 = com.didi.sdk.apm.SystemUtils.getPackageInfo(r1, r4, r5)     // Catch:{ Exception -> 0x0025, all -> 0x0020 }
            if (r1 == 0) goto L_0x001a
            java.lang.String r2 = r1.versionName     // Catch:{ Exception -> 0x0018 }
            goto L_0x001a
        L_0x0018:
            r4 = move-exception
            goto L_0x0027
        L_0x001a:
            if (r1 != 0) goto L_0x0030
            com.didi.sdk.util.ToastHelper.showLongError((android.content.Context) r7, (int) r3)
            return r0
        L_0x0020:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0048
        L_0x0025:
            r4 = move-exception
            r1 = r2
        L_0x0027:
            r4.printStackTrace()     // Catch:{ all -> 0x0047 }
            if (r1 != 0) goto L_0x0030
            com.didi.sdk.util.ToastHelper.showLongError((android.content.Context) r7, (int) r3)
            return r0
        L_0x0030:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x0045
            java.lang.String r1 = "5.3"
            int r1 = r2.compareTo(r1)
            if (r1 >= 0) goto L_0x0045
            r1 = 2131958056(0x7f131928, float:1.9552713E38)
            com.didi.sdk.util.ToastHelper.showLongCompleted((android.content.Context) r7, (int) r1)
            return r0
        L_0x0045:
            r7 = 1
            return r7
        L_0x0047:
            r2 = move-exception
        L_0x0048:
            if (r1 != 0) goto L_0x004e
            com.didi.sdk.util.ToastHelper.showLongError((android.content.Context) r7, (int) r3)
            return r0
        L_0x004e:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sharesdk.ShareEnvValidate.isValidCheckWx(android.content.Context):boolean");
    }

    public static boolean isValidCheckSinaWb(Context context) {
        return isValid(context, SINA_WEIBO_PACKAGE_NAME);
    }

    public static boolean isValidCheckQQ(Context context) {
        return isValid(context, QQ_PACKAGE_NAME);
    }

    public static boolean isValid(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            SystemUtils.getPackageInfo(context.getPackageManager(), str, 4);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
