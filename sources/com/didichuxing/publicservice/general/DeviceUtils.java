package com.didichuxing.publicservice.general;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.didi.sdk.apm.SystemUtils;

public class DeviceUtils {
    private static DisplayMetrics mDisplayMetrics;
    private static PackageInfo mPackageInfo;
    private static TelephonyManager mTelephonyManager;

    public static String getOSType() {
        return "android";
    }

    public static String getSDKVersion() {
        return "";
    }

    public static int getResolutionHight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT < 13) {
            return windowManager.getDefaultDisplay().getHeight();
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static int getResolutionWidth(Context context) {
        if (mDisplayMetrics == null) {
            mDisplayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        }
        return mDisplayMetrics.widthPixels;
    }

    public static String getPhoneType() {
        return Build.BOARD;
    }

    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static int getPPI(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().densityDpi;
    }

    public static float getDensity(Context context) {
        if (context == null) {
            return 0.0f;
        }
        if (mDisplayMetrics == null) {
            mDisplayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        }
        return mDisplayMetrics.density;
    }

    public static PackageInfo getPackageInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (mPackageInfo == null) {
                mPackageInfo = SystemUtils.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return mPackageInfo;
    }

    public static String getAppVersion(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo == null) {
            return "";
        }
        return packageInfo.versionName;
    }

    public static int getAppVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo == null) {
            return -1;
        }
        return packageInfo.versionCode;
    }

    public static String getMake() {
        return Build.MANUFACTURER;
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getCarrier(Context context) {
        if (mTelephonyManager == null) {
            mTelephonyManager = (TelephonyManager) context.getSystemService("phone");
        }
        return mTelephonyManager.getSimOperator();
    }

    public static String getConnnectiontype(Context context) {
        if (context == null) {
            return "";
        }
        NetworkInfo activeNetworkInfo = SystemUtils.getActiveNetworkInfo((ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return "3G";
                        }
                        return subtypeName;
                }
            }
        }
        return "null";
    }
}
