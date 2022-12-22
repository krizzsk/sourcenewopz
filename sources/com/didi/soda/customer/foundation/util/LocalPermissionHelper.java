package com.didi.soda.customer.foundation.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.didi.soda.customer.foundation.tracker.LaunchAppTracker;
import com.didi.soda.customer.foundation.tracker.performance.PerformanceOmegaHelper;
import com.didichuxing.sofa.permission.PermissionHelper;
import com.yanzhenjie.permission.runtime.Permission;

public final class LocalPermissionHelper {
    public static final String[] INIT_REQUIRED_PERMISSIONS = {Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION, Permission.READ_PHONE_STATE};
    public static final String[] LOCATION_PERMISSIONS = {Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION};
    public static final String[] READ_PHONE_STATE_PERMISSIONS = {Permission.READ_PHONE_STATE};

    private LocalPermissionHelper() {
    }

    public static void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        PermissionHelper.onRequestPermissionsResult(activity, i, strArr, iArr);
    }

    public static void requestPermission(Activity activity, String[] strArr) {
        PermissionHelper.requestPermission(activity, strArr);
    }

    public static void afterDenyPermission(Activity activity, String[] strArr) {
        if (m29210a(activity, strArr)) {
            openPermissionSetting(activity);
        }
    }

    public static boolean checkoutPermission(Activity activity, String[] strArr) {
        return PermissionHelper.isPermissionsGranted(activity, strArr);
    }

    public static void openPermissionSetting(Activity activity) {
        LaunchAppTracker.Companion.clear();
        PerformanceOmegaHelper.getInstance().reset();
        String deviceBrand = CustomerSystemUtil.getDeviceBrand();
        if (!TextUtils.isEmpty(deviceBrand)) {
            deviceBrand = deviceBrand.toLowerCase();
        }
        if ("xiaomi".equals(deviceBrand)) {
            m29211b(activity);
        } else {
            m29209a(activity);
        }
    }

    /* renamed from: a */
    private static boolean m29210a(Activity activity, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        for (String shouldShowRequestPermissionRationale : strArr) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, shouldShowRequestPermissionRationale)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static void m29209a(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        activity.startActivity(intent);
    }

    /* renamed from: b */
    private static void m29211b(Activity activity) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity"));
        intent.putExtra("extra_pkgname", activity.getPackageName());
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            m29209a(activity);
        }
    }
}
