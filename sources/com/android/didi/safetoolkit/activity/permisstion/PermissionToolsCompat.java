package com.android.didi.safetoolkit.activity.permisstion;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.app.ActivityCompat;
import com.android.didi.safetoolkit.activity.permisstion.callback.IPermissionRequest;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.android.didi.safetoolkit.activity.permisstion.utils.ManufacturerUtils;
import com.didi.dimina.container.secondparty.trace.TraceActionServiceImpl;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermissionToolsCompat {
    /* access modifiers changed from: private */
    public Activity mActivity;
    /* access modifiers changed from: private */
    public final SparseArray<PermissionCallback> mCallbackArray = new SparseArray<>();
    /* access modifiers changed from: private */
    public final SparseArray<Map<String, AuthorizationInfo>> mInfoArray = new SparseArray<>();
    /* access modifiers changed from: private */
    public volatile int mRequestCode = 9999;
    /* access modifiers changed from: private */
    public SharedPreferences mSp;

    static /* synthetic */ int access$208(PermissionToolsCompat permissionToolsCompat) {
        int i = permissionToolsCompat.mRequestCode;
        permissionToolsCompat.mRequestCode = i + 1;
        return i;
    }

    public PermissionToolsCompat(Activity activity) {
        this.mActivity = activity;
        this.mSp = SystemUtils.getSharedPreferences(activity, "permission_toools_sp", 0);
    }

    public void requestPermission(final PermissionCallback permissionCallback, final String... strArr) {
        if (strArr != null && strArr.length != 0) {
            final Map<String, AuthorizationInfo> authorizationInfoList = getAuthorizationInfoList(strArr);
            List<AuthorizationInfo> defaultInfoList = getDefaultInfoList(authorizationInfoList);
            if (Build.VERSION.SDK_INT < 23) {
                if (permissionCallback != null) {
                    permissionCallback.onGranted(defaultInfoList);
                }
            } else if (!checkPermissionsIsGranted(strArr)) {
                for (String str : strArr) {
                    authorizationInfoList.get(str).setShouldShowAlert(ActivityCompat.shouldShowRequestPermissionRationale(this.mActivity, str));
                }
                C15741 r1 = new IPermissionRequest() {
                    public void proceed() {
                        for (String str : authorizationInfoList.keySet()) {
                            int i = PermissionToolsCompat.this.mSp.getInt(str, 0) + 1;
                            PermissionToolsCompat.this.mSp.edit().putInt(str, i).commit();
                            ((AuthorizationInfo) authorizationInfoList.get(str)).setRequestTimes(i);
                        }
                        synchronized (PermissionToolsCompat.this.mCallbackArray) {
                            PermissionToolsCompat.this.mCallbackArray.put(PermissionToolsCompat.this.mRequestCode, permissionCallback);
                            PermissionToolsCompat.this.mInfoArray.put(PermissionToolsCompat.this.mRequestCode, authorizationInfoList);
                        }
                        ActivityCompat.requestPermissions(PermissionToolsCompat.this.mActivity, strArr, PermissionToolsCompat.this.mRequestCode);
                        PermissionToolsCompat.access$208(PermissionToolsCompat.this);
                    }
                };
                if (permissionCallback != null) {
                    permissionCallback.onBeforeGranted(turnToInfoList(authorizationInfoList), r1);
                } else {
                    r1.proceed();
                }
            } else if (permissionCallback != null) {
                permissionCallback.onGranted(defaultInfoList);
            }
        }
    }

    private List<AuthorizationInfo> turnToInfoList(Map<String, AuthorizationInfo> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            arrayList.add(map.get(str));
        }
        return arrayList;
    }

    private List<AuthorizationInfo> getDefaultInfoList(Map<String, AuthorizationInfo> map) {
        ArrayList arrayList = new ArrayList();
        for (String str : map.keySet()) {
            AuthorizationInfo authorizationInfo = map.get(str);
            authorizationInfo.setDoNotAskAgain(false);
            authorizationInfo.setShouldShowAlert(false);
            authorizationInfo.setAuthorization(true);
            arrayList.add(authorizationInfo);
        }
        return arrayList;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionCallback permissionCallback = this.mCallbackArray.get(i);
        if (permissionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Map map = this.mInfoArray.get(i);
            int i2 = 0;
            while (i2 < iArr.length && i2 < strArr.length) {
                int i3 = iArr[i2];
                String str = strArr[i2];
                AuthorizationInfo authorizationInfo = (AuthorizationInfo) map.get(str);
                if (i3 == 0) {
                    authorizationInfo.setAuthorization(true);
                    authorizationInfo.setDoNotAskAgain(false);
                    arrayList.add(authorizationInfo);
                } else {
                    boolean shouldShowRequestPermissionRationale = ActivityCompat.shouldShowRequestPermissionRationale(this.mActivity, str);
                    authorizationInfo.setAuthorization(false);
                    if (authorizationInfo.getRequestTimes() == 1) {
                        authorizationInfo.setDoNotAskAgain(false);
                    } else if (!shouldShowRequestPermissionRationale) {
                        authorizationInfo.setDoNotAskAgain(true);
                        authorizationInfo.setShouldShowAlert(false);
                    } else {
                        authorizationInfo.setDoNotAskAgain(false);
                    }
                    arrayList2.add(authorizationInfo);
                }
                i2++;
            }
            if (!arrayList.isEmpty()) {
                permissionCallback.onGranted(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                permissionCallback.onRefuse(arrayList2);
            }
        }
        synchronized (this.mCallbackArray) {
            this.mCallbackArray.remove(i);
            this.mInfoArray.remove(i);
        }
    }

    private Map<String, AuthorizationInfo> getAuthorizationInfoList(String[] strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            AuthorizationInfo authorizationInfo = new AuthorizationInfo();
            authorizationInfo.setRequestPermission(str);
            authorizationInfo.setRequestTimes(this.mSp.getInt(str, 0));
            hashMap.put(str, authorizationInfo);
        }
        return hashMap;
    }

    public boolean checkPermissionsIsGranted(String... strArr) {
        if (strArr == null) {
            return true;
        }
        for (String checkSelfPermission : strArr) {
            if (ActivityCompat.checkSelfPermission(this.mActivity, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    public void launchPermissionSettingPageOnThePhone(Context context) {
        Intent intent = new Intent();
        if (ManufacturerUtils.isSamsung()) {
            goSamsung(context, intent);
        } else if (ManufacturerUtils.isMotorola()) {
            goMotorola(context, intent);
        } else if (ManufacturerUtils.isHuawei()) {
            goHuawei(context, intent);
        } else if (ManufacturerUtils.isLG()) {
            goLG(context, intent);
        } else if (ManufacturerUtils.isMIUI()) {
            goXiaomi(context, intent);
        } else if (ManufacturerUtils.isSony()) {
            goSony(context, intent);
        } else if (ManufacturerUtils.isFlyme()) {
            goMeizu(context, intent);
        } else {
            goSetting(context);
        }
    }

    private void goSamsung(Context context, Intent intent) {
        goInstalledAppDetail(context, intent);
    }

    private void goMotorola(Context context, Intent intent) {
        goInstalledAppDetail(context, intent);
    }

    private void goLG(Context context, Intent intent) {
        try {
            intent.setAction(context.getPackageName());
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$AccessLockSummaryActivity"));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            goInstalledAppDetail(context, new Intent());
        }
    }

    private void goHuawei(Context context, Intent intent) {
        goInstalledAppDetail(context, intent);
    }

    private void goMeizu(Context context, Intent intent) {
        try {
            intent.setAction("com.meizu.safe.security.SHOW_APPSEC");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("packageName", context.getPackageName());
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            goInstalledAppDetail(context, new Intent());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047 A[SYNTHETIC, Splitter:B:17:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054 A[SYNTHETIC, Splitter:B:25:0x0054] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getMiuiVersion() {
        /*
            r5 = this;
            java.lang.String r0 = "ro.miui.ui.version.name"
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            r3.<init>()     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.lang.String r4 = "getprop "
            r3.append(r4)     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            r3.append(r0)     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.lang.String r0 = r3.toString()     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.lang.Process r0 = r2.exec(r0)     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.io.InputStream r0 = r0.getInputStream()     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            r0 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r0)     // Catch:{ IOException -> 0x0040, all -> 0x003e }
            java.lang.String r0 = r2.readLine()     // Catch:{ IOException -> 0x003c }
            r2.close()     // Catch:{ IOException -> 0x003c }
            r2.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003b:
            return r0
        L_0x003c:
            r0 = move-exception
            goto L_0x0042
        L_0x003e:
            r0 = move-exception
            goto L_0x0052
        L_0x0040:
            r0 = move-exception
            r2 = r1
        L_0x0042:
            r0.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x004f
            r2.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x004f:
            return r1
        L_0x0050:
            r0 = move-exception
            r1 = r2
        L_0x0052:
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.didi.safetoolkit.activity.permisstion.PermissionToolsCompat.getMiuiVersion():java.lang.String");
    }

    private void goXiaomi(Context context, Intent intent) {
        String miuiVersion = getMiuiVersion();
        if ("V6".equals(miuiVersion) || "V7".equals(miuiVersion)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            intent.setFlags(268435456);
            context.startActivity(intent);
        } else if ("V8".equals(miuiVersion)) {
            intent.setAction("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            intent.setFlags(268435456);
            context.startActivity(intent);
        } else {
            goInstalledAppDetail(context, intent);
        }
    }

    private void goSony(Context context, Intent intent) {
        try {
            intent.setAction(context.getPackageName());
            intent.setComponent(new ComponentName("com.sonymobile.cta", "com.sonymobile.cta.SomcCTAMainActivity"));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            goInstalledAppDetail(context, new Intent());
        }
    }

    private void goInstalledAppDetail(Context context, Intent intent) {
        try {
            int i = Build.VERSION.SDK_INT;
            if (i >= 9) {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
            } else {
                String str = i == 8 ? TraceActionServiceImpl.PKG : "com.android.settings.ApplicationPkgName";
                intent.setAction("android.intent.action.VIEW");
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra(str, context.getPackageName());
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            goSetting(context);
        }
    }

    private void goSetting(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.SETTINGS").addFlags(268435456);
        context.startActivity(intent);
    }
}
