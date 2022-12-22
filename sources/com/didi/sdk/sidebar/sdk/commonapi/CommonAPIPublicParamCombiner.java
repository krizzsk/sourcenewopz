package com.didi.sdk.sidebar.sdk.commonapi;

import android.content.Context;
import android.os.Build;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.component.express.ExpressShareStore;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.Constant;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.MixFlagUtil;
import com.didi.sdk.util.SUUIDHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.Utils;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.Map;

public class CommonAPIPublicParamCombiner {
    public static void combineSystemInfo(Map<String, Object> map, Context context) {
        map.put("vcode", String.valueOf(SystemUtil.getVersionCode()));
        map.put("dviceid", SecurityUtil.getDeviceId());
        map.put("deviceid", SecurityUtil.getDeviceId());
        map.put("appversion", Utils.getCurrentVersion(context));
        map.put("model", Utils.getModel());
        map.put("os", Build.VERSION.RELEASE);
        map.put("imei", SystemUtil.getIMEI());
        map.put("suuid", SecurityUtil.getSUUID());
        map.put("channel", SystemUtil.getChannelId());
        map.put("datatype", "1");
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        sb.append(MD5.toMD5(SecurityUtil.getSUUID() + "*&didi@").toLowerCase());
        map.put("cancel", sb.toString());
        map.put("maptype", "soso");
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (didiLocation != null) {
            map.put("lng", String.valueOf(didiLocation.getLongitude()));
            map.put("lat", String.valueOf(didiLocation.getLatitude()));
        }
        if (map.get("city_id") == null || "-1".equals(map.get("city_id"))) {
            map.put("city_id", String.valueOf(ReverseLocationStore.getsInstance().getCityId()));
        }
        map.put("pixels", Constant.SCREEN_PIXELS);
        map.put("mac", SystemUtil.getMacSerialno());
        map.put("cpu", SystemUtil.getCPUSerialno());
        map.put("android_id", SecurityUtil.getAndroidID());
        map.put("networkType", SystemUtil.getNetworkType());
        map.put("uuid", SecurityUtil.getUUID());
        if (map.get("lang") == null) {
            map.put("lang", MultiLocaleStore.getInstance().getLocaleCode());
        }
    }

    public static void combineUserInfo(Map<String, Object> map) {
        map.put("token", NationTypeUtil.getNationComponentData().getLoginInfo().getToken());
    }

    public static Map<String, Object> combinePublicParams(Map<String, Object> map, Context context) {
        int i;
        NationComponentData nationComponentData = NationTypeUtil.getNationComponentData();
        DIDILocation lastKnownLocation = LocationPerformer.getInstance().getLastKnownLocation(context);
        if (nationComponentData != null) {
            map.put("origin_id", nationComponentData.getOriginID());
            map.put("map_type", nationComponentData.getMapTypeString());
            map.put("maptype", nationComponentData.getMapTypeString());
            if (nationComponentData.getLoginInfo() != null) {
                map.put("token", nationComponentData.getLoginInfo().getToken());
            }
            map.put("lang", nationComponentData.getGLang());
        }
        map.put("app_version", Utils.getCurrentVersion(context));
        map.put("client_type", 1);
        map.put("channel", SystemUtil.getChannelId());
        if (lastKnownLocation != null) {
            map.put("lat", Double.valueOf(lastKnownLocation.getLatitude()));
            map.put("lng", Double.valueOf(lastKnownLocation.getLongitude()));
        }
        map.put("imei", SystemUtil.getIMEI());
        map.put("suuid", SecurityUtil.getSUUID());
        map.put("model", SystemUtil.getModel());
        map.put("os", Build.VERSION.RELEASE);
        map.put("brand", Build.BRAND);
        map.put("wifi_mac", "");
        map.put("pixels", Constant.SCREEN_PIXELS);
        map.put("android_id", SecurityUtil.getAndroidID());
        map.put("networkType", SystemUtil.getNetworkType());
        map.put("vcode", Integer.valueOf(SystemUtil.getVersionCode()));
        map.put("dviceid", SecurityUtil.getDeviceId());
        Address fromAddress = ExpressShareStore.getInstance().getFromAddress();
        if (fromAddress == null || fromAddress.getCityId() == -1) {
            i = ReverseLocationStore.getsInstance().getCityId();
        } else {
            i = fromAddress.getCityId();
        }
        map.put("city_id", Integer.valueOf(i));
        map.put("appversion", Utils.getCurrentVersion(context));
        map.put("datatype", 1);
        map.put("data_type", "android");
        if (lastKnownLocation != null) {
            map.put("userlat", Double.valueOf(lastKnownLocation.getLatitude()));
            map.put("userlng", Double.valueOf(lastKnownLocation.getLongitude()));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("test");
        sb.append(MD5.toMD5(SUUIDHelper.getDiDiSUUID() + Constant.SIGN_KEY).toLowerCase());
        map.put("cancel", sb.toString());
        map.put("sig", SecurityUtil.generateSignature(map));
        map.put("uuid", SecurityUtil.getUUID());
        map.put("mix_flag", Integer.valueOf(MixFlagUtil.getMixFlag(context)));
        return map;
    }
}
