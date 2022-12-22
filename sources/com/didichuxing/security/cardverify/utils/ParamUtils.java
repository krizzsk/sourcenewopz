package com.didichuxing.security.cardverify.utils;

import android.text.TextUtils;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import java.util.HashMap;

public class ParamUtils {
    public static void addCommonParam(DiCardVerifyParam diCardVerifyParam, HashMap<String, Object> hashMap) {
        hashMap.put("uid", diCardVerifyParam.getUid());
        hashMap.put("location_country", diCardVerifyParam.getCountry());
        hashMap.put("ostype", diCardVerifyParam.getOstype());
        hashMap.put("terminal_id", diCardVerifyParam.getTerminalId());
        hashMap.put("product_id", diCardVerifyParam.getProductId());
        hashMap.put("card_index", diCardVerifyParam.getCardIndex());
        hashMap.put("lang", diCardVerifyParam.getLanguage());
        hashMap.put("os", diCardVerifyParam.getOs());
        hashMap.put("sence", diCardVerifyParam.getSence());
        hashMap.put("appversion", diCardVerifyParam.getAppVersion());
        hashMap.put("sdkver", diCardVerifyParam.getSdkVersion());
        if (!TextUtils.isEmpty(diCardVerifyParam.getIp())) {
            hashMap.put("ip", diCardVerifyParam.getIp());
        }
        if (!TextUtils.isEmpty(diCardVerifyParam.getLongitude())) {
            hashMap.put("lng", diCardVerifyParam.getLongitude());
        }
        if (!TextUtils.isEmpty(diCardVerifyParam.getLatitude())) {
            hashMap.put("lat", diCardVerifyParam.getLatitude());
        }
        hashMap.put("token", diCardVerifyParam.getToken());
    }
}
