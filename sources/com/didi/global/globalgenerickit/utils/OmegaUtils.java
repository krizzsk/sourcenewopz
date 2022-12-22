package com.didi.global.globalgenerickit.utils;

import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globalgenerickit.model.ComponentConfigModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.Map;

public class OmegaUtils {
    public static void trackComponentConfigDialogSW(ComponentConfigModel componentConfigModel) {
        if (componentConfigModel != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", componentConfigModel.f22193id);
            if (componentConfigModel.logMap != null) {
                hashMap.putAll(componentConfigModel.logMap);
            }
            OmegaSDKAdapter.trackEvent("ibt_gp_popup_view_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void trackComponentConfigDialogCK(ComponentConfigModel componentConfigModel, String str) {
        if (componentConfigModel != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("id", componentConfigModel.f22193id);
            hashMap.put(Const.BUTTON_ID, str);
            if (componentConfigModel.logMap != null) {
                hashMap.putAll(componentConfigModel.logMap);
            }
            OmegaSDKAdapter.trackEvent("ibt_gp_popup_btn_ck", (Map<String, Object>) hashMap);
        }
    }

    public static void configShowTrack(String str, String str2) {
        configShowTrack(str, str2, (Map<String, Object>) null);
    }

    public static void configShowTrack(String str, String str2, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str2);
        hashMap.put("id", str);
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_commonmodule_sw", (Map<String, Object>) hashMap);
    }

    public static void configButtonClickTrack(String str, String str2, String str3) {
        configButtonClickTrack(str, str2, str3, (Map<String, Object>) null);
    }

    public static void configButtonClickTrack(String str, String str2, String str3, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str3);
        hashMap.put("id", str);
        hashMap.put(Const.BUTTON_ID, str2);
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_commonmodule_btn_ck", (Map<String, Object>) hashMap);
    }

    public static void trackComponentConfigBannerSW(ComponentConfigModel componentConfigModel) {
        if (componentConfigModel != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", Const.BUBBLE);
            hashMap.put("id", componentConfigModel.f22193id);
            if (componentConfigModel.logMap != null) {
                hashMap.putAll(componentConfigModel.logMap);
            }
            OmegaSDKAdapter.trackEvent("ibt_gp_commonmodule_sw", (Map<String, Object>) hashMap);
        }
    }

    public static void trackComponentConfigBannerCK(ComponentConfigModel componentConfigModel, String str) {
        if (componentConfigModel != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", Const.BUBBLE);
            hashMap.put("id", componentConfigModel.f22193id);
            hashMap.put(Const.BUTTON_ID, str);
            if (componentConfigModel.logMap != null) {
                hashMap.putAll(componentConfigModel.logMap);
            }
            OmegaSDKAdapter.trackEvent("ibt_gp_commonmodule_btn_ck", (Map<String, Object>) hashMap);
        }
    }
}
