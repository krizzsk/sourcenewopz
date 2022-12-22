package com.didi.sdk.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Base64;
import android.view.TouchDelegate;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.log.Logger;
import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Utils {

    /* renamed from: a */
    private static final String f37705a = "TD_CHANNEL_ID";

    /* renamed from: b */
    private static long f37706b = 0;

    /* renamed from: c */
    private static long f37707c = 400;

    public static byte[] base64Encode(byte[] bArr) {
        return Base64.encode(bArr, 0);
    }

    public static byte[] base64Decode(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    public static boolean isRunningForeground(Context context) {
        String packageName = context.getPackageName();
        String topActivityPackegeName = getTopActivityPackegeName(context);
        if (!TextUtil.isEmpty(packageName) && !TextUtil.isEmpty(topActivityPackegeName)) {
            return topActivityPackegeName.equals(packageName);
        }
        return false;
    }

    public static String getTopActivityPackegeName(Context context) {
        ComponentName componentName;
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || runningTasks.isEmpty() || (componentName = runningTasks.get(0).topActivity) == null) {
            return null;
        }
        return componentName.getPackageName();
    }

    public static boolean getTopActivity(Activity activity, Class cls) {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) activity.getSystemService("activity")).getRunningTasks(1);
        if (runningTasks == null || !runningTasks.get(0).topActivity.getClassName().equals(cls.getName())) {
            return false;
        }
        return true;
    }

    public static boolean isActivityInRunningList(Context context, Class cls) {
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(Integer.MAX_VALUE)) {
            if (runningTaskInfo.topActivity.getClassName().equals(cls.getName())) {
                return true;
            }
        }
        return false;
    }

    public static String getModel() {
        String str = Build.MODEL;
        return TextUtil.isEmpty(str) ? "" : str;
    }

    public static String getCurrentVersion(Context context) {
        return SystemUtil.getVersionName(context);
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager);
            if (activeNetworkInfo == null) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo == null || wifiManager == null) {
                    return false;
                }
                NetworkInfo.State state = networkInfo.getState();
                if (!wifiManager.isWifiEnabled() || !NetworkInfo.State.CONNECTED.equals(state)) {
                    return false;
                }
                return true;
            } else if (activeNetworkInfo.isConnected() || activeNetworkInfo.isAvailable()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Logger.m25809e(e.toString(), new Object[0]);
            return false;
        }
    }

    public static String[] getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo;
        String[] strArr = new String[2];
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (!(connectivityManager == null || (activeNetworkInfo = SystemUtils.getActiveNetworkInfo(connectivityManager)) == null)) {
            if (activeNetworkInfo.getType() == 0) {
                strArr[0] = activeNetworkInfo.getExtraInfo();
                strArr[1] = activeNetworkInfo.getSubtypeName();
            } else if (activeNetworkInfo.getType() == 1) {
                strArr[0] = null;
                strArr[1] = activeNetworkInfo.getTypeName();
            }
        }
        return strArr;
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - f37706b;
        if (0 < j && j < f37707c) {
            return true;
        }
        f37706b = currentTimeMillis;
        return false;
    }

    public static void enlargeHitRect(final View view, final int i) {
        if (view != null) {
            final View view2 = View.class.isInstance(view.getParent()) ? (View) view.getParent() : null;
            if (view != null && view2 != null && i > 0) {
                view.post(new Runnable() {
                    public void run() {
                        Rect rect = new Rect();
                        view.getHitRect(rect);
                        int round = Math.round((((float) Math.abs(rect.left - rect.right)) * ((float) i)) / 100.0f) / 2;
                        int round2 = Math.round((((float) Math.abs(rect.bottom - rect.top)) * ((float) i)) / 100.0f) / 2;
                        rect.left -= round;
                        rect.right += round;
                        rect.top -= round2;
                        rect.bottom += round2;
                        view2.setTouchDelegate(new TouchDelegate(rect, view));
                    }
                });
            }
        }
    }

    public static String getFileName(String str) {
        if (TextUtil.isEmpty(str)) {
            return "";
        }
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static void installApk(Context context, String str) {
        Uri fromFile = Uri.fromFile(new File(str));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    public static Class getGenericType(Object obj, int i) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        if (i >= actualTypeArguments.length || i < 0) {
            throw new RuntimeException("Index outof bounds");
        } else if (!(actualTypeArguments[i] instanceof Class)) {
            return Object.class;
        } else {
            return (Class) actualTypeArguments[i];
        }
    }

    public static void makePhoneCallNoDial(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }

    public static void makePhoneCall(Context context, String str) {
        context.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)));
    }

    public static String getTDChannel(Context context) {
        try {
            return String.valueOf(SystemUtils.getApplicationInfo(context.getPackageManager(), context.getPackageName(), 128).metaData.get(f37705a));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSign(Context context, String str) {
        Signature[] a = m26730a(context, str);
        if (!(a == null || a.length == 0)) {
            int length = a.length;
            int i = 0;
            while (i < length) {
                try {
                    return MD5.toMD5(a[i].toByteArray());
                } catch (Exception e) {
                    e.printStackTrace();
                    i++;
                }
            }
        }
        return null;
    }

    public static boolean isDebug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static Signature[] m26730a(Context context, String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                PackageInfo packageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), str, 64);
                if (packageInfo == null) {
                    return null;
                }
                return packageInfo.signatures;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }
}
