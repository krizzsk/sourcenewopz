package com.didi.entrega.customer.foundation.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.location.LocationManagerCompat;
import androidx.exifinterface.media.ExifInterface;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.commoninterfacelib.statuslightning.impl.NoneLightningCompatImpl;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.alarm.AlarmManagerFactory;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public final class CustomerSystemUtil {

    /* renamed from: a */
    private static final String f20128a = "status_bar_height";

    public static String getMapType() {
        return "gmap";
    }

    private CustomerSystemUtil() {
    }

    public static void doCall(Context context, String str) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("tel:")) {
                uri = Uri.parse(str);
            } else {
                uri = Uri.parse("tel:" + str);
            }
            Intent intent = new Intent("android.intent.action.DIAL", uri);
            intent.setFlags(268435456);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return;
            }
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.create(ErrorConst.ErrorName.SALING_C_12_DO_CALL_ERROR).addModuleName("order").addErrorType("os_12_call_error").addErrorMsg(TextUtils.isEmpty(e.getMessage()) ? "no msg" : e.getMessage()).build().trackError();
            }
        }
    }

    public static void sendMessage(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SENDTO");
            intent.setData(Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        }
    }

    public static void playNotificationRingtone(Context context) {
        RingtoneManager.getRingtone(context, RingtoneManager.getDefaultUri(2)).play();
    }

    public static void openLocationSettingActivity(Context context) {
        try {
            context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (ActivityNotFoundException unused) {
            LogUtil.m14763e("openLocationSettingActivity", "ActivityNotFoundException");
        }
    }

    public static boolean isGpsEnabled(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        boolean z2 = !TextUtils.isEmpty(Settings.System.getString(context.getContentResolver(), "location_providers_allowed"));
        if (z2) {
            return z2;
        }
        try {
            LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
            if (locationManager != null && LocationManagerCompat.isLocationEnabled(locationManager)) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return z2;
        }
    }

    public static String getDeviceBrand() {
        String str = Build.BRAND;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static int getScreenWidth(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getRealScreenHeight(Context context) {
        if (!(context instanceof Activity)) {
            return -1;
        }
        WindowManager windowManager = ((Activity) context).getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(f20128a).get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getImmersiveStatusBarHeight(Context context) {
        int identifier;
        if (Build.VERSION.SDK_INT < 21 || ((StatusBarLightingCompat.getImpl() != null && (StatusBarLightingCompat.getImpl() instanceof NoneLightningCompatImpl)) || (identifier = context.getResources().getIdentifier(f20128a, "dimen", "android")) <= 0)) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static String getAllInstallAppNames(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            PackageManager packageManager = context.getPackageManager();
            int i = 0;
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                int size = queryIntentActivities.size();
                for (ResolveInfo loadLabel : queryIntentActivities) {
                    sb.append(loadLabel.loadLabel(packageManager));
                    if (i != size - 1) {
                        sb.append(",");
                    }
                    i++;
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return sb.toString();
        }
    }

    public static String getLocalIpAddress(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return m14826a();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean checkPermission(Context context, String str) {
        return checkPermission(context, str, false);
    }

    public static boolean checkPermission(Context context, String str, boolean z) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception unused) {
            return z;
        }
    }

    public static String getKernelVersion() {
        try {
            File file = new File("/proc/version");
            if (!file.canRead()) {
                return "";
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 8192);
            String str = "";
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        str = str + readLine;
                    } else {
                        try {
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                    bufferedReader.close();
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            fileInputStream.close();
            try {
                if (!"".equals(str)) {
                    return "";
                }
                String substring = str.substring(str.indexOf("version ") + 8);
                return substring.substring(0, substring.indexOf(" "));
            } catch (IndexOutOfBoundsException e4) {
                e4.printStackTrace();
                return "";
            }
        } catch (FileNotFoundException e5) {
            e5.printStackTrace();
            return "";
        }
    }

    public static String getSsId(Context context) {
        if (context == null || !checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            return "";
        }
        try {
            return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getSSID();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getLoginPhoneNum() {
        return LoginUtil.getPhone();
    }

    public static String getPhoneNum(Context context) {
        if (context == null || !checkPermission(context, Permission.READ_PHONE_STATE)) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getLine1Number();
    }

    public static int getLocationType() {
        int access$000 = LocType.UNKNOW.mValue;
        DIDILocation currentLocation = LocationUtil.getCurrentLocation();
        if (currentLocation == null) {
            return access$000;
        }
        String provider = currentLocation.getProvider();
        if ("gps".equals(provider)) {
            return LocType.GPS.mValue;
        }
        if (DIDILocation.WIFI_PROVIDER.equals(provider)) {
            return LocType.WIFI.mValue;
        }
        if (DIDILocation.CELL_PROVIDER.equals(provider)) {
            return LocType.CELL.mValue;
        }
        return LocType.UNKNOW.mValue;
    }

    public static String getCompleteVersionName(Context context) {
        if (context == null) {
            return "";
        }
        return ExifInterface.GPS_MEASUREMENT_INTERRUPTED + SystemUtil.getVersionName(context) + "_" + SystemUtil.getVersionCode();
    }

    public static String getDeviceId() {
        return SecurityUtil.getDeviceId();
    }

    public static int getTimeZoneUtcOffset() {
        TimeZone timeZone = TimeZone.getDefault();
        if (timeZone == null) {
            return -1;
        }
        int rawOffset = timeZone.getRawOffset() / 60000;
        return timeZone.inDaylightTime(new Date()) ? rawOffset + 60 : rawOffset;
    }

    public static void restartApp() {
        Intent launchIntentForPackage = GlobalContext.getContext().getPackageManager().getLaunchIntentForPackage(GlobalContext.getContext().getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(32768);
            launchIntentForPackage.addFlags(268435456);
            AlarmManagerFactory.getAdapter().setRct(GlobalContext.getContext(), 1000, PendingIntent.getActivity(GlobalContext.getContext(), 0, launchIntentForPackage, 16));
            ((Activity) GlobalContext.getContext()).finish();
        }
    }

    public static void setStatusBarBgLightning(boolean z) {
        setStatusBarBgLightning((Activity) GlobalContext.getContext(), z);
    }

    public static void setStatusBarBgLightning(Activity activity, boolean z) {
        CustomerStatusBarHelper.getHelper().setStatusBarBgLightning(activity, z);
    }

    public static boolean getCurrentBarStatus() {
        return CustomerStatusBarHelper.getHelper().getCurrentStatus().booleanValue();
    }

    public static void gotoGooglePlay(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + context.getPackageName()));
        intent.setPackage("com.android.vending");
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
            return;
        }
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName()));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        } else {
            ToastUtil.makeText(context.getResources().getString(R.string.FoodC_home1_Please_install_XKUn));
        }
    }

    public static boolean areNotificationsEnabled(Context context) {
        if (context == null) {
            return true;
        }
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public static void goNotificationSetting(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 26) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
            } else if (Build.VERSION.SDK_INT >= 21) {
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            } else {
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.putExtra("package", context.getPackageName());
            }
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static void virate(Context context) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(15);
        }
    }

    /* renamed from: a */
    private static String m14826a() {
        try {
            Iterator<T> it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator<T> it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (true) {
                    if (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException unused) {
            return null;
        }
    }

    enum LocType {
        UNKNOW(-1, "unknown"),
        GPS(1, "gps"),
        WIFI(2, "wifi"),
        CELL(3, "cell");
        
        private String mName;
        /* access modifiers changed from: private */
        public int mValue;

        private LocType(int i, String str) {
            this.mValue = i;
            this.mName = str;
        }

        public int getId() {
            return this.mValue;
        }

        public String getName() {
            return this.mName;
        }
    }
}
