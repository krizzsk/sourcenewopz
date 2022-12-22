package com.didi.map.setting.common;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface MapSettingNavConstant {
    public static final String AMAP = "com.autonavi.minimap";
    public static final String AMAP_NAVI = "com.autonavi.xmgd.navigator";
    public static final String BD_MAP = "com.baidu.BaiduMap";
    public static final String BD_NAVI = "com.baidu.navi";
    public static final String BROAD_CAST_TAG = "android.intent.action.SettingWindowBroadcastReceiver";
    public static final String BROAD_SELECTED_NAV_TAG = "android.intent.action.SettingSelectedNavReceiver";
    public static final String BROAD_SELECTED_OUT_NAV_TAG = "android.intent.action.SettingSelectedOutNavReceiver";
    public static final String GOOGLE_NAV = "com.google.android.apps.maps";
    public static final String JP_YAHOO = "jp.co.yahoo.android.apps.navi";
    public static final String LOCAL_GOOGLE_NAVI = "local_google";
    public static final String LOCAL_NAVI = "local";
    public static final String MAP_COUNTRY_CODE_AUSTRALIA = "AU";
    public static final String MAP_COUNTRY_CODE_BRAZIL = "BR";
    public static final String MAP_COUNTRY_CODE_JAPAN = "JP";
    public static final String MAP_COUNTRY_CODE_KAZAKHSTAN = "KZ";
    public static final String MAP_COUNTRY_CODE_MEXICO = "MX";
    public static final String MAP_COUNTRY_CODE_RUSSIA = "RU";
    public static final int MAP_NAVIGATION_DIRECTION_FOLLOW = 2;
    public static final int MAP_NAVIGATION_DIRECTION_NORTH = 1;
    public static final String NAVI_TIME = "com.navitime.local.carnavitime";
    public static final String RU_2GIS = "ru.dublgis.dgismobile";
    public static final String SETTING_NAV_SELECTED_KEY = "nav_selected_key";
    public static final int TYPE_BUSINESS_HIGH_CAR = 102;
    public static final int TYPE_BUSINESS_LOW_CAR = 101;
    public static final String WAZE = "com.waze";
    public static final String YAHOO = "jp.co.yahoo.android.apps.map";
    public static final String YANDEX_MAP = "ru.yandex.yandexmaps";
    public static final String YANDEX_NAV = "ru.yandex.yandexnavi";

    @Retention(RetentionPolicy.SOURCE)
    public @interface BusinessType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MapNavigationDirectionType {
    }
}
