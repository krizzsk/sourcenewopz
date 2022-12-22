package com.didi.sdk.webview.image;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.MixFlagUtil;
import com.didi.sdk.util.SystemUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadParams {
    public static final String P_APP_KEY = "appKey";
    public static final String P_APP_VERSION = "appversion";
    public static final String P_CHANEL = "channel";
    public static final String P_CITY_ID = "city_id";
    public static final String P_COVER_LAT = "lat";
    public static final String P_COVER_LNG = "lng";
    public static final String P_DATA_TYPE = "datatype";
    public static final String P_DEVICE_ID = "deviceid";
    public static final String P_EXT = "ext";
    public static final String P_FILE = "file";
    public static final String P_IMEI = "imei";
    public static final String P_MAP_TYPE = "maptype";
    public static final String P_MODEL = "model";
    public static final String P_OS = "os";
    public static final String P_PHONE = "phone";
    public static final String P_SUUID = "suuid";
    public static final String P_TOKEN = "token";
    public static final String P_VCODE = "vcode";

    public static HashMap<String, Object> createParams(Context context, File file, String str) {
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("vcode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("deviceid", SecurityUtil.getDeviceId());
        hashMap.put("appversion", SystemUtil.getVersionName());
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("datatype", "1");
        hashMap.put("maptype", "soso");
        hashMap.put("phone", loginInfo.getPhone());
        hashMap.put("mix_flag", String.valueOf(MixFlagUtil.getMixFlag(context)));
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (didiLocation != null) {
            hashMap.put("lng", Double.valueOf(didiLocation.getLongitude()));
            hashMap.put("lat", Double.valueOf(didiLocation.getLatitude()));
        }
        hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
        hashMap.put("appKey", "taxiPassengerAndroid");
        hashMap.put("token", loginInfo.getToken());
        if (file != null) {
            hashMap.put("file", file);
            hashMap.put("ext", m27269a(file.getName()));
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject optJSONObject = new JSONObject(str).optJSONObject("data");
                if (optJSONObject != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.optString(next));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static HashMap<String, String> createQueryParams(Context context) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("vcode", SystemUtil.getVersionCode() + "");
        hashMap.put("deviceid", SecurityUtil.getDeviceId());
        hashMap.put("appversion", SystemUtil.getVersionName());
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("datatype", "1");
        hashMap.put("maptype", "soso");
        hashMap.put("phone", NationTypeUtil.getNationComponentData().getLoginInfo().getPhone());
        hashMap.put("mix_flag", String.valueOf(MixFlagUtil.getMixFlag(context)));
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (didiLocation != null) {
            hashMap.put("lng", didiLocation.getLongitude() + "");
            hashMap.put("lat", didiLocation.getLatitude() + "");
        }
        hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
        hashMap.put("appKey", "taxiPassengerAndroid");
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m27269a(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x001f
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x001f
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 <= r1) goto L_0x001f
            int r1 = r2.length()
            int r1 = r1 + -1
            if (r0 >= r1) goto L_0x001f
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.webview.image.UploadParams.m27269a(java.lang.String):java.lang.String");
    }
}
