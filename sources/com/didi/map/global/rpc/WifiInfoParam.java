package com.didi.map.global.rpc;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.MD5;
import com.didichuxing.apollo.sdk.Apollo;
import com.google.common.base.Ascii;
import java.io.Serializable;
import java.util.Random;

public class WifiInfoParam implements Serializable {
    private static final String TAG = WifiInfoParam.class.getCanonicalName();
    private static LocationManager mLocationManager;
    private static WifiManager mWifiManager;
    public int connect;
    public int gps_open_not;
    public String mac_addr;
    public String signal_strength;
    public String ssid;
    public long time;
    public int wifi_open_not;

    public WifiInfoParam(Object obj, boolean z, boolean z2) {
        this.wifi_open_not = z ? 1 : 0;
        this.gps_open_not = z2 ? 1 : 0;
    }

    private static boolean isWifiInfoToggleEnabled() {
        return Apollo.getToggle("android_passenger_global_base_lib_wifi_info_toggle").allow();
    }

    public static String getWifiInfo(Context context) {
        if (!isWifiInfoToggleEnabled()) {
            SystemUtils.log(6, TAG, "isWifiInfoToggleEnabled = false", (Throwable) null, "com.didi.map.global.rpc.WifiInfoParam", 55);
            return null;
        } else if (context != null) {
            return null;
        } else {
            SystemUtils.log(6, TAG, "context == null", (Throwable) null, "com.didi.map.global.rpc.WifiInfoParam", 60);
            return "";
        }
    }

    private static WifiManager getWifiManager(Context context) {
        if (mWifiManager == null) {
            mWifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        }
        return mWifiManager;
    }

    private static boolean isWifiOpened(Context context) {
        return getWifiManager(context).isWifiEnabled();
    }

    private static LocationManager getLocationManager(Context context) {
        if (mLocationManager == null) {
            mLocationManager = (LocationManager) context.getApplicationContext().getSystemService("location");
        }
        return mLocationManager;
    }

    private static boolean isGpsOpened(Context context) {
        LocationManager locationManager = getLocationManager(context);
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    private static String bytes2HexString(byte[] bArr) {
        int length;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (bArr == null || (length = bArr.length) <= 0) {
            return "";
        }
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] >> 4) & 15];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & Ascii.f53593SI];
        }
        return new String(cArr2);
    }

    private static String toMD5(byte[] bArr) {
        return bytes2HexString(new MD5().getMD5(bArr));
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        int nextInt = new Random().nextInt(64);
        char charAt = "GHI9+JKLxyz012MNOPYbcRSTUVW8/ABCw3DEZaFXefghijklm7=nopqrsdQtuv456".charAt(nextInt);
        String md5 = toMD5((str2 + charAt).getBytes());
        String encodeToString = Base64.encodeToString(str.getBytes(), 2);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < encodeToString.length(); i2++) {
            if (i == md5.length()) {
                i = 0;
            }
            sb.append("GHI9+JKLxyz012MNOPYbcRSTUVW8/ABCw3DEZaFXefghijklm7=nopqrsdQtuv456".charAt((("GHI9+JKLxyz012MNOPYbcRSTUVW8/ABCw3DEZaFXefghijklm7=nopqrsdQtuv456".indexOf(encodeToString.charAt(i2)) + nextInt) + md5.charAt(i)) % 65));
            i++;
        }
        sb.append(charAt);
        return sb.toString();
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        int length = str.length() - 1;
        char charAt = str.charAt(length);
        int indexOf = "GHI9+JKLxyz012MNOPYbcRSTUVW8/ABCw3DEZaFXefghijklm7=nopqrsdQtuv456".indexOf(charAt);
        String md5 = toMD5((str2 + charAt).getBytes());
        String substring = str.substring(0, length);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < substring.length(); i2++) {
            if (i == md5.length()) {
                i = 0;
            }
            int indexOf2 = ("GHI9+JKLxyz012MNOPYbcRSTUVW8/ABCw3DEZaFXefghijklm7=nopqrsdQtuv456".indexOf(substring.charAt(i2)) - indexOf) - md5.charAt(i);
            while (indexOf2 < 0) {
                indexOf2 += 65;
            }
            sb.append("GHI9+JKLxyz012MNOPYbcRSTUVW8/ABCw3DEZaFXefghijklm7=nopqrsdQtuv456".charAt(indexOf2));
            i++;
        }
        return new String(Base64.decode(sb.toString(), 2));
    }
}
