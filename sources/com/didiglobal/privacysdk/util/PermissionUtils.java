package com.didiglobal.privacysdk.util;

import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import com.yanzhenjie.permission.runtime.Permission;

public class PermissionUtils {
    public static boolean hasPermission(Context context, String str) {
        return Build.VERSION.SDK_INT < 23 || ActivityCompat.checkSelfPermission(context, str) == 0;
    }

    public static boolean hasLocationPermission(Context context) {
        return hasPermission(context, Permission.ACCESS_FINE_LOCATION);
    }

    public static boolean hasCameraPermission(Context context) {
        return hasPermission(context, Permission.CAMERA);
    }

    public static boolean hasAlbumPermission(Context context) {
        return hasPermission(context, Permission.WRITE_EXTERNAL_STORAGE);
    }

    public static boolean hasContractsPermission(Context context) {
        return hasPermission(context, Permission.READ_CONTACTS);
    }

    public static boolean hasMicrophonePermission(Context context) {
        return hasPermission(context, Permission.RECORD_AUDIO);
    }
}
