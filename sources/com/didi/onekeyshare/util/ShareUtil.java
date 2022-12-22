package com.didi.onekeyshare.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sdk.apm.SystemUtils;

public class ShareUtil {
    public static String getApplicationName(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            try {
                applicationInfo = SystemUtils.getApplicationInfo(packageManager, context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static boolean isAlipayShare(SharePlatform sharePlatform) {
        return sharePlatform == SharePlatform.ALIPAY_FRIEND_PLAFORM || sharePlatform == SharePlatform.ALIPAY_CIRCLE_PLAFORM;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap scale(android.graphics.Bitmap r8, float r9, float r10, android.widget.ImageView.ScaleType r11, boolean r12) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0054
            boolean r1 = r8.isRecycled()
            if (r1 == 0) goto L_0x000a
            goto L_0x0054
        L_0x000a:
            int r1 = r8.getWidth()
            float r1 = (float) r1
            int r2 = r8.getHeight()
            float r2 = (float) r2
            float r3 = r1 / r2
            float r4 = r9 / r10
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_CROP
            if (r11 != r5) goto L_0x0025
            int r11 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r11 <= 0) goto L_0x0022
        L_0x0020:
            float r10 = r10 / r2
            goto L_0x002c
        L_0x0022:
            float r10 = r9 / r1
            goto L_0x002c
        L_0x0025:
            int r11 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r11 >= 0) goto L_0x002a
            goto L_0x0020
        L_0x002a:
            float r9 = r9 / r1
            r10 = r9
        L_0x002c:
            r9 = 1065353216(0x3f800000, float:1.0)
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 != 0) goto L_0x0033
            return r8
        L_0x0033:
            android.graphics.Matrix r6 = new android.graphics.Matrix
            r6.<init>()
            r6.setScale(r10, r10)
            r2 = 0
            r3 = 0
            int r4 = r8.getWidth()     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004c }
            int r5 = r8.getHeight()     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004c }
            r7 = 1
            r1 = r8
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ IllegalArgumentException | OutOfMemoryError -> 0x004c }
            goto L_0x004d
        L_0x004c:
        L_0x004d:
            if (r12 == 0) goto L_0x0054
            if (r8 == r0) goto L_0x0054
            clear(r8)
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.onekeyshare.util.ShareUtil.scale(android.graphics.Bitmap, float, float, android.widget.ImageView$ScaleType, boolean):android.graphics.Bitmap");
    }

    public static void clear(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 14) {
            bitmap.recycle();
        }
    }

    public static SharePlatform getPlatform(String str) {
        return SharePlatform.valueName(str);
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
