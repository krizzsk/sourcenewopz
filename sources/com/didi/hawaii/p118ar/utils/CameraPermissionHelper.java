package com.didi.hawaii.p118ar.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

/* renamed from: com.didi.hawaii.ar.utils.CameraPermissionHelper */
public final class CameraPermissionHelper {

    /* renamed from: a */
    private static final int f23307a = 0;

    /* renamed from: b */
    private static final String f23308b = "android.permission.CAMERA";

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
