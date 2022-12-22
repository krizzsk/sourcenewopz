package com.didi.unifylogin.utils;

import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.raven.config.RavenKey;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import global.didi.pay.omega.GlobalPayOmegaConstant;
import java.util.HashMap;

public class OmegaUtils {
    public static void ibt_gd_brchangephone_verify_sw() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "acess");
        hashMap.put("pretab", "enter_new_phone");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_verification");
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_verify_sw", "", hashMap);
    }

    public static void ibt_gd_time_brchangephone_verify_sw(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put("pretab", "enter_new_phone");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_verification");
        hashMap.put(RavenKey.VERSION, "staytime");
        hashMap.put("time", Long.valueOf(j));
        OmegaSDKAdapter.trackEvent("ibt_gd_time_brchangephone_verify_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_verify_status_popup_sw(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put("pretab", "enter_verification");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_new_phone");
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put(RavenKey.VERSION, Const.POPUP);
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_verify_status_popup_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_newphone_popup_sw() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put("pretab", "enter_new_phone");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "new_phone_popup");
        hashMap.put(RavenKey.VERSION, Const.POPUP);
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_newphone_popup_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_newphone_confirm_popup_ck(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put("pretab", "enter_cpf");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_new_phone");
        hashMap.put(RavenKey.VERSION, "next");
        hashMap.put("type", Integer.valueOf(i));
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_newphone_confirm_popup_ck", "", hashMap);
    }

    public static void ibt_gd_time_brchangephone_newphone_ck() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put("pretab", "enter_cpf");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_new_phone");
        hashMap.put(RavenKey.VERSION, "next");
        OmegaSDKAdapter.trackEvent("ibt_gd_time_brchangephone_newphone_ck", "", hashMap);
    }

    public static void ibt_gd_brchangephone_cfp_popup_sw() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put("pretab", "enter_cpf");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "no_associate_cpf_popup");
        hashMap.put(RavenKey.VERSION, Const.POPUP);
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_cfp_popup_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_cfp_ck() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put("pretab", "login");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_cpf");
        hashMap.put(RavenKey.VERSION, "next");
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_cfp_ck", "", hashMap);
    }

    public static void ibt_gd_time_brchangephone_cfp_sw(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put("pretab", "login");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_cpf");
        hashMap.put(RavenKey.VERSION, "staytime");
        hashMap.put("time", Long.valueOf(j));
        OmegaSDKAdapter.trackEvent("ibt_gd_time_brchangephone_cfp_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_cfp_sw() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put("pretab", "login");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_cpf");
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_cfp_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_popup_ck(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put("pretab", "login");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "change_phone_banner");
        hashMap.put("type", Integer.valueOf(i));
        hashMap.put(RavenKey.VERSION, "next");
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_popup_ck", "", hashMap);
    }

    public static void ibt_gd_brchangephone_login_sw() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "login");
        hashMap.put(RavenKey.VERSION, "change_phone");
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_login_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_newphone_sw() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "access");
        hashMap.put("pretab", "enter_cpf");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_new_phone");
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_newphone_sw", "", hashMap);
    }

    public static void ibt_gd_time_brchangephone_newphone_sw(long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put("pretab", "enter_cpf");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "enter_new_phone");
        hashMap.put("time", Long.valueOf(j));
        hashMap.put(RavenKey.VERSION, "staytime");
        OmegaSDKAdapter.trackEvent("ibt_gd_time_brchangephone_newphone_sw", "", hashMap);
    }

    public static void ibt_gd_brchangephone_login_ck() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "click");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "login");
        hashMap.put(RavenKey.VERSION, "click");
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_login_ck", "", hashMap);
    }

    public static void ibt_gd_brchangephone_popup_sw() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "show");
        hashMap.put("pretab", "login");
        hashMap.put(GlobalPayOmegaConstant.EventKey.TAB, "change_phone_banner");
        hashMap.put(RavenKey.VERSION, Const.POPUP);
        OmegaSDKAdapter.trackEvent("ibt_gd_brchangephone_popup_sw", "", hashMap);
    }
}
