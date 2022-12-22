package com.didi.sdk.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.onehybrid.util.MD5Util;
import com.didi.sdk.nation.MapType;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.security.SecurityUtil;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.log.LogUtils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonParamsUtil {

    public static class CommonParams {
        public static final String PARAM_ANDROID_ID = "android_id";
        public static final String PARAM_APP_VERSION = "appversion";
        public static final String PARAM_CANCEL = "cancel";
        public static final String PARAM_CHANNEL = "channel";
        public static final String PARAM_CITY_ID = "city_id";
        public static final String PARAM_CPU = "cpu";
        public static final String PARAM_DATA_TYPE = "datatype";
        public static final String PARAM_DEVICE_ID = "dviceid";
        public static final String PARAM_DEVICE_ID_NEW = "deviceid";
        public static final String PARAM_IMEI = "imei";
        public static final String PARAM_LATITUDE = "lat";
        public static final String PARAM_LONGITUDE = "lng";
        public static final String PARAM_MAC = "mac";
        public static final String PARAM_MAP_TYPE = "maptype";
        public static final String PARAM_MODEL = "model";
        public static final String PARAM_NET_WORK_TYPE = "networkType";
        public static final String PARAM_OS = "os";
        public static final String PARAM_SCREEN_PIXELS = "pixels";
        public static final String PARAM_SIGNATURE = "sig";
        public static final String PARAM_SUUID = "suuid";
        public static final String PARAM_TIME = "time";
        public static final String PARAM_TOKEN = "token";
        public static final String PARAM_UUID = "uuid";
        public static final String PARAM_VCODE = "vcode";
    }

    public static HashMap<String, Object> addCommonParam(HashMap<String, Object> hashMap, Context context) {
        double d;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        hashMap.put("vcode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("dviceid", SecurityUtil.getDeviceId());
        hashMap.put("appversion", SystemUtil.getVersionName());
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("channel", ChannelUtil.m26672a(context));
        hashMap.put("datatype", 1);
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        sb.append(MD5Util.md5(SUUIDHelper.getDiDiSUUID() + Constant.SIGN_KEY).toLowerCase());
        hashMap.put("cancel", sb.toString());
        hashMap.put("mix_flag", Integer.valueOf(MixFlagUtil.getMixFlag(context)));
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (hashMap.get("maptype") == null || "".equals(String.valueOf(hashMap.get("maptype")))) {
            String mapTypeString = NationTypeUtil.getNationComponentData().getMapTypeString();
            if (MapType.MAPTYPE_WGS84.getMapTypeString().equals(mapTypeString) || MapType.MATYPE_GMAP.getMapTypeString().equals(mapTypeString)) {
                hashMap.put("maptype", "wgs84");
            } else {
                hashMap.put("maptype", "soso");
            }
        }
        hashMap.put("sig", SecurityUtil.generateSignature(hashMap));
        hashMap.put("pixels", Constant.SCREEN_PIXELS);
        hashMap.put("mac", SystemUtil.getMacSerialno());
        String a = m26681a(SystemUtil.getCPUSerialno());
        if (!TextUtils.isEmpty(a)) {
            hashMap.put("cpu", a);
        }
        hashMap.put("android_id", SystemUtil.getAndroidID());
        hashMap.put("networkType", SystemUtil.getNetworkType());
        hashMap.put("uuid", SecurityUtil.getUUID());
        hashMap.put("time", System.currentTimeMillis() + "");
        String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        if (hashMap.get("token") == null || "".equals(String.valueOf(hashMap.get("token")))) {
            if (TextUtils.isEmpty(token)) {
                hashMap.put("token", "0");
            } else {
                hashMap.put("token", token);
            }
        }
        double d2 = 0.0d;
        if (hashMap.get("lat") == null) {
            if (didiLocation == null) {
                d = 0.0d;
            } else {
                d = didiLocation.getLatitude();
            }
            hashMap.put("lat", Double.valueOf(d));
        }
        if (hashMap.get("lng") == null) {
            if (didiLocation != null) {
                d2 = didiLocation.getLongitude();
            }
            hashMap.put("lng", Double.valueOf(d2));
        }
        if (Integer.valueOf(NationTypeUtil.getNationComponentData().getCityId()).intValue() != -1) {
            hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
        }
        hashMap.put("lang", NationTypeUtil.getNationComponentData().getGLang());
        return hashMap;
    }

    public static String createCommonParamString(Context context) {
        if (context == null) {
            return "";
        }
        Set<Map.Entry<String, Object>> entrySet = addCommonParam(new HashMap(), context).entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : entrySet) {
            String obj = next.getValue().toString();
            sb.append(((String) next.getKey()) + "=" + obj + ParamKeys.SIGN_AND);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* renamed from: a */
    private static String m26681a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[charArray.length];
        int i = 0;
        for (int i2 = 0; i2 < charArray.length; i2++) {
            if (charArray[i2] > 31 && charArray[i2] < 127) {
                cArr[i] = charArray[i2];
                i++;
            }
        }
        return new String(cArr, 0, i);
    }

    public static String createCommonParamJson(Context context) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("datatype", 1);
            jSONObject.put("imei", SystemUtil.getIMEI());
            jSONObject.put("suuid", SecurityUtil.getSUUID());
            jSONObject.put("device_id", SecurityUtil.getDeviceId());
            jSONObject.put("mac", SystemUtil.getMacSerialno());
            jSONObject.put("appversion", SystemUtil.getVersionName());
            jSONObject.put("channel", ChannelUtil.m26672a(context));
            jSONObject.put("android_id", SystemUtil.getAndroidID());
            jSONObject.put("model", SystemUtil.getModel());
            jSONObject.put("networkType", SystemUtil.getNetworkType());
            jSONObject.put("pixels", Constant.SCREEN_PIXELS);
            jSONObject.put("mix_flag", MixFlagUtil.getMixFlag(context));
            DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
            jSONObject.put("maptype", "soso");
            if (didiLocation != null) {
                if (didiLocation.getCoordinateType() == 0) {
                    jSONObject.put("maptype", "wgs84");
                } else if (didiLocation.getCoordinateType() == 1) {
                    jSONObject.put("maptype", "soso");
                }
            }
            jSONObject.put("time", System.currentTimeMillis() + "");
            String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
            Object obj2 = "0";
            if (TextUtils.isEmpty(token)) {
                jSONObject.put("token", obj2);
            } else {
                jSONObject.put("token", token);
            }
            if (didiLocation == null) {
                obj = obj2;
            } else {
                obj = Double.valueOf(didiLocation.getLatitude());
            }
            jSONObject.put("lat", obj);
            if (didiLocation != null) {
                obj2 = Double.valueOf(didiLocation.getLongitude());
            }
            jSONObject.put("lng", obj2);
            int intValue = Integer.valueOf(NationTypeUtil.getNationComponentData().getCityId()).intValue();
            if (intValue != -1) {
                jSONObject.put("city_id", intValue);
            }
            jSONObject.put("lang", NationTypeUtil.getNationComponentData().getLocaleCode());
        } catch (JSONException e) {
            LogUtils.m32692e(e.toString());
        } catch (Exception e2) {
            LogUtils.m32692e(e2.toString());
        }
        return jSONObject.toString();
    }
}
