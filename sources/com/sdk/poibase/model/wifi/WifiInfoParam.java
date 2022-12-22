package com.sdk.poibase.model.wifi;

import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Base64;
import com.didi.common.map.util.DLog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p173dp.locsdk.LocDataDef;
import com.google.common.base.Ascii;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
    public long time_diff;
    public int wifi_open_not;

    public WifiInfoParam(LocDataDef.LocWifiInfo locWifiInfo, boolean z, boolean z2) {
        this.ssid = locWifiInfo.ssid;
        this.mac_addr = locWifiInfo.mac;
        this.connect = locWifiInfo.connect ? 1 : 0;
        this.signal_strength = "" + locWifiInfo.level;
        this.time = System.currentTimeMillis() - locWifiInfo.time_diff;
        this.time_diff = locWifiInfo.time_diff;
        this.wifi_open_not = z ? 1 : 0;
        this.gps_open_not = z2 ? 1 : 0;
    }

    public static String getWifiParam(Context context) {
        LocDataDef.LocWifiInfo locWifiInfo;
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (context == null) {
                SystemUtils.log(6, "getWifiInfo", "context == null", (Throwable) null, "com.sdk.poibase.model.wifi.WifiInfoParam", 59);
                return str;
            }
            List<LocDataDef.LocWifiInfo> currentWifiList = DIDILocBusinessHelper.getInstance().getCurrentWifiList();
            if (CollectionUtil.isEmpty((Collection<?>) currentWifiList)) {
                SystemUtils.log(3, "getWifiInfo", "CollectionUtil.isEmpty(wifiInfos)", (Throwable) null, "com.sdk.poibase.model.wifi.WifiInfoParam", 65);
                return str;
            }
            boolean isWifiOpened = isWifiOpened(context);
            boolean isGpsOpened = isGpsOpened(context);
            JsonArray jsonArray = new JsonArray();
            for (int i = 0; i < 10; i++) {
                if (i < currentWifiList.size() && (locWifiInfo = currentWifiList.get(i)) != null) {
                    jsonArray.add((JsonElement) getWifiParamJson(locWifiInfo, isWifiOpened, isGpsOpened));
                }
            }
            String jsonArray2 = jsonArray.toString();
            if (jsonArray2 == null) {
                return str;
            }
            try {
                DLog.m7384d("getWifiInfo", jsonArray2, new Object[0]);
                DLog.m7384d("getWifiInfo", str + (System.currentTimeMillis() - currentTimeMillis), new Object[0]);
                return encrypt(jsonArray2, "didimapglobal");
            } catch (Exception unused) {
                str = jsonArray2;
                DLog.m7384d("getWifiInfo", "打包wifi 信息出现异常", new Object[0]);
                return str;
            }
        } catch (Exception unused2) {
            DLog.m7384d("getWifiInfo", "打包wifi 信息出现异常", new Object[0]);
            return str;
        }
    }

    private static JsonObject getWifiParamJson(LocDataDef.LocWifiInfo locWifiInfo, boolean z, boolean z2) {
        JsonObject jsonObject = new JsonObject();
        if (locWifiInfo != null) {
            jsonObject.addProperty("ssid", locWifiInfo.ssid);
            jsonObject.addProperty("mac_addr", locWifiInfo.mac);
            jsonObject.addProperty("connect", (Number) Integer.valueOf(locWifiInfo.connect ? 1 : 0));
            jsonObject.addProperty("signal_strength", (Number) Long.valueOf(locWifiInfo.level));
            jsonObject.addProperty("time", (Number) Long.valueOf(System.currentTimeMillis() - locWifiInfo.time_diff));
            jsonObject.addProperty("time_diff", (Number) Long.valueOf(locWifiInfo.time_diff));
        }
        jsonObject.addProperty("wifi_open_not", (Number) Integer.valueOf(z ? 1 : 0));
        jsonObject.addProperty("gps_open_not", (Number) Integer.valueOf(z2 ? 1 : 0));
        return jsonObject;
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
