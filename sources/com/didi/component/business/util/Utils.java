package com.didi.component.business.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    /* renamed from: a */
    private static String f11403a;

    public static String second2Min(int i) {
        if (i < 60) {
            String format = String.format("%1$02d", new Object[]{Integer.valueOf(i)});
            return "00:" + format;
        }
        int i2 = i / 60;
        int i3 = i % 60;
        if (i2 >= 1) {
            String format2 = String.format("%1$02d", new Object[]{Integer.valueOf(i2)});
            String format3 = String.format("%1$02d", new Object[]{Integer.valueOf(i3)});
            return format2 + ":" + format3;
        }
        return i + "";
    }

    public static void closeInputMethod(View view) {
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public static void closeInputMethod(Fragment fragment) {
        if (fragment != null) {
            closeInputMethod(fragment.getView());
        }
    }

    public static boolean isAppFront() {
        return ActivityLifecycleManager.getInstance().isAppActive();
    }

    public static boolean isServiceRunning(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(30);
        if (runningServices == null || runningServices.size() <= 0) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static void hideInputMethod(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    public static String getPackageName(Context context) {
        return context.getApplicationContext().getPackageName();
    }

    public static void showInputMethod(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 1);
    }

    public static String getString(Context context, int i) {
        return ResourcesHelper.getString(context, i);
    }

    public static boolean isChina() {
        String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        if (!TextUtil.isEmpty(localeCode)) {
            return "zh-CN".equalsIgnoreCase(localeCode);
        }
        return true;
    }

    public static String getSimSerialNumber(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getSDCardId() {
        if (!TextUtils.isEmpty(f11403a)) {
            return f11403a;
        }
        String str = "/sys/block/mmcblk%s/device/" + "type";
        String str2 = "/sys/block/mmcblk%s/device/" + "cid";
        int i = 0;
        while (true) {
            if (i >= 5) {
                break;
            }
            String a = m7728a(String.format(str, new Object[]{Integer.valueOf(i)}));
            if (!TextUtils.isEmpty(a) && (a.equalsIgnoreCase("mmc") || !a.equalsIgnoreCase("sd"))) {
                String a2 = m7728a(String.format(str2, new Object[]{Integer.valueOf(i)}));
                if (!TextUtils.isEmpty(a2)) {
                    f11403a = a2;
                    break;
                }
            }
            i++;
        }
        return f11403a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0040 A[SYNTHETIC, Splitter:B:22:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x004d A[SYNTHETIC, Splitter:B:30:0x004d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m7728a(java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            r1 = 0
            if (r3 == 0) goto L_0x0056
            boolean r3 = r0.isFile()
            if (r3 == 0) goto L_0x0056
            boolean r3 = r0.canRead()
            if (r3 != 0) goto L_0x0019
            goto L_0x0056
        L_0x0019:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0035 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0035 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0035 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0035 }
            java.lang.String r0 = r0.readLine()     // Catch:{ IOException -> 0x0035 }
            r3.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0034:
            return r0
        L_0x0035:
            r0 = move-exception
            goto L_0x003b
        L_0x0037:
            r0 = move-exception
            goto L_0x004b
        L_0x0039:
            r0 = move-exception
            r3 = r1
        L_0x003b:
            r0.printStackTrace()     // Catch:{ all -> 0x0049 }
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0048:
            return r1
        L_0x0049:
            r0 = move-exception
            r1 = r3
        L_0x004b:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0055:
            throw r0
        L_0x0056:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.util.Utils.m7728a(java.lang.String):java.lang.String");
    }

    public static List<String> getRoundBracketData(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(?<=\\().*(?=\\))").matcher(str);
        while (matcher.find()) {
            if (!TextUtils.isEmpty(matcher.group())) {
                arrayList.add(matcher.group());
            }
        }
        return arrayList;
    }

    public static List<String> getBracketsData(String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("(?<=\\{)(.+?)(?=\\})").matcher(str);
        while (matcher.find()) {
            if (!TextUtils.isEmpty(matcher.group())) {
                arrayList.add(matcher.group());
            }
        }
        return arrayList;
    }

    public static boolean isBrazilPackage(Context context) {
        return context != null && "com.taxis99".equals(context.getPackageName());
    }

    public static void launchGooglePlayStoreAppDetail(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Activity currentActivity = ActivityLifecycleManager.getInstance().getCurrentActivity();
                if (currentActivity == null) {
                    return;
                }
                if (!currentActivity.isFinishing()) {
                    Uri parse = Uri.parse("market://details?id=" + str);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(parse);
                    currentActivity.startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isAppInstalled(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            SystemUtils.getPackageInfo(context.getPackageManager(), str, 16384);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDestroy(Context context) {
        if (context == null) {
            return true;
        }
        if (!(context instanceof Activity)) {
            return false;
        }
        Activity activity = (Activity) context;
        if (activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
            return true;
        }
        return false;
    }
}
