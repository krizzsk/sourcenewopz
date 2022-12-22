package com.didi.hawaii.p118ar.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.yanzhenjie.permission.runtime.Permission;

/* renamed from: com.didi.hawaii.ar.utils.PermissionHelper */
public class PermissionHelper {
    public static final int CAMERA_PERMISSION_CODE = 0;
    public static final int REQUEST_EXTERNAL_STORAGE = 1;

    /* renamed from: a */
    private static boolean f23326a = false;

    /* renamed from: b */
    private static boolean f23327b = false;

    /* renamed from: c */
    private static String[] f23328c = {Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};

    /* renamed from: d */
    private static final String f23329d = "android.permission.CAMERA";

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (androidx.core.app.ActivityCompat.checkSelfPermission(r4, com.yanzhenjie.permission.runtime.Permission.ACCESS_COARSE_LOCATION) != 0) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean requestStoragePermissions(android.app.Activity r4) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            r1 = 1
            boolean r2 = f23326a     // Catch:{ Exception -> 0x002e }
            if (r2 == 0) goto L_0x0009
            r4 = 0
            return r4
        L_0x0009:
            f23326a = r1     // Catch:{ Exception -> 0x002e }
            java.lang.String r2 = "android.permission.WRITE_EXTERNAL_STORAGE"
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r2)     // Catch:{ Exception -> 0x002e }
            if (r2 == 0) goto L_0x0018
            java.lang.String[] r2 = f23328c     // Catch:{ Exception -> 0x002e }
            androidx.core.app.ActivityCompat.requestPermissions(r4, r2, r1)     // Catch:{ Exception -> 0x002e }
        L_0x0018:
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r0)     // Catch:{ Exception -> 0x002e }
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            if (r2 != 0) goto L_0x0026
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r3)     // Catch:{ Exception -> 0x002e }
            if (r2 == 0) goto L_0x0032
        L_0x0026:
            java.lang.String[] r0 = new java.lang.String[]{r0, r3}     // Catch:{ Exception -> 0x002e }
            androidx.core.app.ActivityCompat.requestPermissions(r4, r0, r1)     // Catch:{ Exception -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.PermissionHelper.requestStoragePermissions(android.app.Activity):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (androidx.core.app.ActivityCompat.checkSelfPermission(r4, com.yanzhenjie.permission.runtime.Permission.ACCESS_COARSE_LOCATION) != 0) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean requestLocationPermissions(android.app.Activity r4) {
        /*
            java.lang.String r0 = "android.permission.ACCESS_FINE_LOCATION"
            r1 = 1
            boolean r2 = f23327b     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0009
            r4 = 0
            return r4
        L_0x0009:
            f23327b = r1     // Catch:{ Exception -> 0x0021 }
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r0)     // Catch:{ Exception -> 0x0021 }
            java.lang.String r3 = "android.permission.ACCESS_COARSE_LOCATION"
            if (r2 != 0) goto L_0x0019
            int r2 = androidx.core.app.ActivityCompat.checkSelfPermission(r4, r3)     // Catch:{ Exception -> 0x0021 }
            if (r2 == 0) goto L_0x0025
        L_0x0019:
            java.lang.String[] r0 = new java.lang.String[]{r0, r3}     // Catch:{ Exception -> 0x0021 }
            androidx.core.app.ActivityCompat.requestPermissions(r4, r0, r1)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.utils.PermissionHelper.requestLocationPermissions(android.app.Activity):boolean");
    }

    public static boolean hasStoragePerssion(Activity activity) {
        return ActivityCompat.checkSelfPermission(activity, Permission.WRITE_EXTERNAL_STORAGE) == 0;
    }

    public static boolean hasLocationPerssion(Activity activity) {
        return ActivityCompat.checkSelfPermission(activity, Permission.ACCESS_FINE_LOCATION) == 0 && ActivityCompat.checkSelfPermission(activity, Permission.ACCESS_COARSE_LOCATION) == 0;
    }

    public static boolean hasCameraPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, "android.permission.CAMERA") == 0;
    }

    public static void requestCameraPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.CAMERA"}, 0);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.CAMERA");
    }

    public static void launchPermissionSettings(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivity(intent);
    }
}
