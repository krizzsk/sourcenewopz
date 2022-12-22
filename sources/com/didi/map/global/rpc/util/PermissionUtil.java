package com.didi.map.global.rpc.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.didi.sdk.util.collection.CollectionUtil;
import com.yanzhenjie.permission.runtime.Permission;

public class PermissionUtil {
    public static final String[] PERMISSIONS_EXTERNAL_STORAGE = {Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};
    public static final String[] PERMISSIONS_LOCATION = {Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION};

    private PermissionUtil() {
    }

    public static boolean checkPermissionsGranted(Context context, String[] strArr) {
        if (!CollectionUtil.isEmpty((Object[]) strArr)) {
            for (String checkPermissionGranted : strArr) {
                if (!checkPermissionGranted(context, checkPermissionGranted)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("CollectionUtil.isEmpty(permissions)");
    }

    public static boolean checkPermissionGranted(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        }
        throw new IllegalArgumentException("TextUtils.isEmpty(permission)");
    }

    public static boolean isLocationPermissionsGranted(Context context) {
        return checkPermissionsGranted(context, PERMISSIONS_LOCATION);
    }

    public static boolean isExternalStoragePermissionsGranted(Context context) {
        return checkPermissionsGranted(context, PERMISSIONS_EXTERNAL_STORAGE);
    }
}
