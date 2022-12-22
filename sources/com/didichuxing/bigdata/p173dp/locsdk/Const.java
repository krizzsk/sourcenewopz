package com.didichuxing.bigdata.p173dp.locsdk;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.Const */
public class Const {
    public static final String APOLLO_ALLOW_BAMAI_LOG = "allow_loc_sdk_bamai_log";
    public static final String APOLLO_ALLOW_LOW_POWER_GPS_MODE = "locsdk_allow_low_power_gps_mode";
    public static final String APOLLO_NLP_REQUEST_CONFIGURE = "locsdk_nlp_request_configure";
    public static final String APOLLO_NLP_REQUEST_CONFIGURE_PARAM_FUSION_INTERVAL = "fusion_interval";
    public static final String APOLLO_NLP_REQUEST_CONFIGURE_PARAM_NORMAL_INTERVAL = "normal_interval";
    public static final String APOLLO_REDUCE_INNER_FREQUECY = "locsdk_reduce_inner_frequecy";
    public static final String APOLLO_REFRESH_WIFI = "locsdk_refresh_wifi";
    public static final String APOLLO_REFRESH_WIFI_PARAM_RECEIVE_TIME_EXPIRED_INTERVAL = "receive_time_expired_interval";
    public static final String APOLLO_REFRESH_WIFI_PARAM_SCAN_INTERVAL = "scan_interval";
    public static final String APOLLO_REFRESH_WIFI_PARAM_SCAN_RESULT_TIME_EXPIRED_INTERVAL = "scan_result_time_expired_interval";
    public static final String APOLLO_SWITCH_NET_TRANSFORM_HTTPS2HTTP = "net_transform_https2http";
    public static final String APOLLO_SWITCH_REDUCE_LACK_OF_TRACE = "loc_sdk_reduce_lack_of_trace";
    public static final String APOLLO_SWITCH_USE_TENCNET = "loc_sdk_use_tencent";
    public static final String APOLLO_USE_DIDI_NLP_TAIWAN = "locsdk_use_didi_nlp_taiwan";
    public static final long CALLBACK_GPS_OLD_THRESHOLD = 3000;
    public static final String CALL_FROM_DEPARTURE_PAGE = "pickup_page";
    public static final String CALL_FROM_SUG_PAGE = "sug_packing_prompt";
    public static final long DEF_GPS_FLP_MONITOR_INTERVAL = 1000;
    public static final long DEF_GPS_FLP_MONITOR_INTERVAL_VIECHLE_MOUNT = 200;
    public static final long DELAY_TIME4LAST_GPS_TASK = 4000;
    public static final long GPS_2LAST_SPEED_INVALID = 200;
    public static final float GPS_ACCURACY_LIMIT_FOR_GOOGLE_FLP = 30.0f;
    public static final long GPS_CHECK_INTERVAL_MS = 120000;
    public static final long GPS_TIME_DIFF_INVALID = 1800000;
    public static final long INVALIDATE_TIME_4_GPS_EVENT = 5000;
    public static final byte[] KEY = "0123456789abcdef".getBytes();
    public static final long LOCATION_EFFECTIVE_TIME = 30000;
    public static final int LOCATION_LEVEL_BATTERY_SAVING = 2;
    public static final int LOCATION_LEVEL_HIGH_ACCURACY = 3;
    public static final int LOCATION_LEVEL_OFF = 0;
    public static final int LOCATION_LEVEL_SENSORS_ONLY = 1;
    public static final boolean LOC_NECESSARY_TRACK_CLOSE = true;
    public static final int LOG_NUM = 10;
    public static final int MESSAGE_WHAT_ERRINFO = -587202543;
    public static final int MESSAGE_WHAT_LACATION = -587202544;
    public static final long MIN_GPS_EVENT_GAP = 950;
    public static final long MIN_INTERVAL_BAMAI_GPS_NLP_LOCATION = 15000;
    public static final long MIN_LOG_GPS_EVENT_GAP = 10000;
    public static final int NLP_CHECK_LOOPER_INTERVAL_MS = 20000;
    public static final String PACKAGE_NAME_CHINA_DRIVER = "com.sdu.didi.gsui";
    public static final String PACKAGE_NAME_CHINA_PASSENGER = "com.sdu.didi.psnger";
    public static final String PREFS_KEY_COORDINATE_TYPE = "prefs_key_coordinate_type";
    public static final String PREFS_NAME_APPVERSION = "prefs_name_appversion";
    public static final String PREFS_NAME_PHONE = "prefs_name_phone";
    public static final String PREFS_SETTING = "prefs_setting";
    public static long RETRIEVE_TIME_SERVICE_DELAY = 70;
    public static final int RETRIEVE_TIME_SERVICE_TRY_TIMES = 8;
    public static final String SDK_TAG = "DIDI_LOC_SDK";
    public static final int START2LOCATION_INTERVAL_MILLIS = 15000;
    public static final long UPLOAD_TRACE_INTERVAL = 1800000;
    public static final long VALIDATE_INTERVAL_GOOGLE_FLP_LOCATION = 20000;
    public static final int VALIDATE_INTERVAL_NLP_LOCATION = 20000;
    public static final long VALIDATE_INTERVAL_TENCENT_LOCATION = 30000;
    public static final long VALIDATE_TIME_TENCENT_LOCATION = 30000;
    public static final long WORKER_LOOPER_CHECK_INTERVAl_MS = 600000;
    public static final double cdmaLocCoef = 14400.0d;
    public static final long cellDataExpiredMillis = 3600000;
    public static final int confiprobDots = 3;
    public static final long defaultNLPRequestFusionInterval = 10;
    public static final long defaultNLPRequestNormalInterval = 20;
    public static final String globalServerUrl = "https://map-loc.didiglobal.com/global/map/loc";
    public static final double googleFlpLocConfi = 1.0d;
    public static final double gpsLocConfi = 2.0d;
    public static final long gpsLocTimeIntevalMillis = 30000;
    public static final long gpsLocValidTimeMillis = 30000;
    public static final float gpsUpdatesMindistMeter = 0.0f;
    public static final int gpslocAccuracyConf = 25;
    public static final double gpslocConfiExtra = 0.5d;
    public static final int iDefCgiSig = -113;
    public static final int iSim2Def = 0;
    public static final int iSim2Mtk = 2;
    public static final int iSim2QualComm = 1;
    public static final boolean isDebug = false;
    public static final String jaLeft = "[";
    public static final String jaRight = "]";
    public static final String joLeft = "{";
    public static final String joRight = "}";
    public static final String jsAssi = ":";
    public static final String jsQuote = "\"";
    public static final String jsSepr = ",";
    public static final String js_req_acy = "\"acy\"";
    public static final String js_req_app_version = "\"app_version\"";
    public static final String js_req_call_from = "\"call_from\"";
    public static final String js_req_cell = "\"cell\"";
    public static final String js_req_cell_cellid_bsid = "\"cellid_bsid\"";
    public static final String js_req_cell_lac_nid = "\"lac_nid\"";
    public static final String js_req_cell_lat_cdma = "\"lat_cdma\"";
    public static final String js_req_cell_lon_cdma = "\"lon_cdma\"";
    public static final String js_req_cell_mcc = "\"mcc\"";
    public static final String js_req_cell_mnc_sid = "\"mnc_sid\"";
    public static final String js_req_cell_neigh_cid = "\"cid\"";
    public static final String js_req_cell_neigh_lac = "\"lac\"";
    public static final String js_req_cell_neigh_rssi = "\"rssi\"";
    public static final String js_req_cell_neighcells = "\"neighcells\"";
    public static final String js_req_cell_precell = "\"pre_cell\"";
    public static final String js_req_cell_precell_dt = "\"dt\"";
    public static final String js_req_cell_rssi = "\"rssi\"";
    public static final String js_req_cell_type = "\"type\"";
    public static final String js_req_conf = "\"conf\"";
    public static final String js_req_dir = "\"dir\"";
    public static final String js_req_dt = "\"dt\"";
    public static final String js_req_gps = "\"gps\"";
    public static final String js_req_gps_acy = "\"acy\"";
    public static final String js_req_gps_dir = "\"dir\"";
    public static final String js_req_gps_lat = "\"lat\"";
    public static final String js_req_gps_lon = "\"lon\"";
    public static final String js_req_gps_spd = "\"spd\"";
    public static final String js_req_gps_ts = "\"ts\"";
    public static final String js_req_lat = "\"lat\"";
    public static final String js_req_listeners_info = "\"listeners_info\"";
    public static final String js_req_lon = "\"lon\"";
    public static final String js_req_pre_gps = "\"pre_gps\"";
    public static final String js_req_pre_gps_acy = "\"acy\"";
    public static final String js_req_pre_gps_dir = "\"dir\"";
    public static final String js_req_pre_gps_dt = "\"dt\"";
    public static final String js_req_pre_gps_lat = "\"lat\"";
    public static final String js_req_pre_gps_lon = "\"lon\"";
    public static final String js_req_pre_gps_spd = "\"spd\"";
    public static final String js_req_pre_locations = "\"pre_locations\"";
    public static final String js_req_pre_nlp = "\"pre_nlp\"";
    public static final String js_req_sdk_version = "\"sdk_version\"";
    public static final String js_req_sensor_air_press = "\"air_press\"";
    public static final String js_req_sensor_gps_inter = "\"gps_inter\"";
    public static final String js_req_sensor_gps_open_not = "\"gps_open_not\"";
    public static final String js_req_sensor_light_value = "\"light_value\"";
    public static final String js_req_sensor_location_permission = "\"location_permission\"";
    public static final String js_req_sensor_location_switch_level = "\"location_switch_level\"";
    public static final String js_req_sensor_timestamp = "\"timestamp\"";
    public static final String js_req_sensor_wifi_connect_not = "\"connect_type\"";
    public static final String js_req_sensor_wifi_open_not = "\"wifi_open_not\"";
    public static final String js_req_sensor_wifi_scan_available = "\"wifi_scan_available\"";
    public static final String js_req_spd = "\"spd\"";
    public static final String js_req_src = "\"src\"";
    public static final String js_req_sys_nlp = "\"sys_nlp\"";
    public static final String js_req_tencent_loc = "\"tencent_loc\"";
    public static final String js_req_time_diff = "\"time_diff\"";
    public static final String js_req_trace_id = "\"trace_id\"";
    public static final String js_req_ts = "\"ts\"";
    public static final String js_req_type = "\"type\"";
    public static final String js_req_user_app_id = "\"app_id\"";
    public static final String js_req_user_didi_uid = "\"didi_uid\"";
    public static final String js_req_user_imei = "\"imei\"";
    public static final String js_req_user_info = "\"user_info\"";
    public static final String js_req_user_modellevel = "\"modellevel\"";
    public static final String js_req_user_phone = "\"phone\"";
    public static final String js_req_user_sensors_info = "\"user_sensors_info\"";
    public static final String js_req_user_timestamp = "\"timestamp\"";
    public static final String js_req_user_user_id = "\"user_id\"";
    public static final String js_req_valid_flag = "\"valid_flag\"";
    public static final String js_req_version = "\"version\"";
    public static final String js_req_wifi_connect = "\"connect\"";
    public static final String js_req_wifi_frequency = "\"frequency\"";
    public static final String js_req_wifi_level = "\"level\"";
    public static final String js_req_wifi_mac = "\"mac\"";
    public static final String js_req_wifi_ssid = "\"ssid\"";
    public static final String js_req_wifis = "\"wifis\"";
    public static final String js_rsp_coord_system = "\"coord_system\"";
    public static final String js_rsp_loc_accuracy = "\"accuracy\"";
    public static final String js_rsp_loc_confidence = "\"confidence\"";
    public static final String js_rsp_loc_lat_gcj = "\"lat_gcj\"";
    public static final String js_rsp_loc_lon_gcj = "\"lon_gcj\"";
    public static final String js_rsp_locations = "\"locations\"";
    public static final String js_rsp_ret_code = "\"ret_code\"";
    public static final String js_rsp_ret_msg = "\"ret_msg\"";
    public static final String js_rsp_timestamp = "\"timestamp\"";
    public static final long lDefCgiUpdate = 10000;
    public static final long lMinCgiUpdate = 10000;
    public static final String logFileName = "log.txt";
    public static final String logLRCF = "\n";
    public static final int lonlatDots = 6;
    public static final long minQpsIntervalMillis = 8000;
    public static final double nlpLocConfi = 0.8d;
    public static final long noReceive2StopScanIntervalMillis = 120000;
    public static final String paramCharset = "UTF-8";
    public static final long regulReqIntervalTurboMillis = 1000;
    public static final int serciceDefMsg = 0;
    public static final int serviceCmdNone = -587202560;
    public static final int serviceCmdStart = -587202559;
    public static final int serviceCmdStartLocOnce = -587202557;
    public static final int serviceCmdStop = -587202558;
    public static final String serviceTag = "LocCenter";
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
    public static final SimpleDateFormat simpleDateFormatExt1 = new SimpleDateFormat("HH:mm:ss.SSS");
    public static final SimpleDateFormat simpleDateFormatExt2 = new SimpleDateFormat("yyyyMMdd");
    public static final String strSim2Def = "phone2";
    public static final String strSim2Mtk = "phone2";
    public static final String strSim2QualComm = "phone_msim";
    public static final long tencentLocTimeIntevalMillis = 10000;
    public static final double transprobLowThreshold = 0.02d;
    public static final String userDefException = "UserDevException";
    public static final int wifiMaxCount = 30;
    public static final long wifiReceiveTimeExpiredMillis = 120000;
    public static final long wifiScanCheckMillis = 8000;
    public static final long wifiScanExpiredMillis = 60000;
    public static final long wifiScanIntervalMillis = 15000;
    public static final long wifiScanResultTimeExpiredMillis = 0;
    public static final long wifiValidDeadlineMillis = 120000;

    public static String formatDouble(double d, int i) {
        try {
            Locale locale = Locale.ENGLISH;
            return String.format(locale, "%." + i + "f", new Object[]{Double.valueOf(d)});
        } catch (Exception unused) {
            return String.valueOf(d);
        }
    }

    public static String formatFloat(float f, int i) {
        try {
            Locale locale = Locale.ENGLISH;
            return String.format(locale, "%." + i + "f", new Object[]{Float.valueOf(f)});
        } catch (Exception unused) {
            return String.valueOf(f);
        }
    }

    public static String formatString(String str) {
        if (str == null) {
            return "\"\"";
        }
        return jsQuote + str.replace(",", "").replace(joLeft, "").replace("}", "").replace(jaLeft, "").replace(jaRight, "") + jsQuote;
    }

    public static String getJsonObject(String str, String str2) {
        int indexOf = str.indexOf(str2) + str2.length() + 1;
        int findJsonObjEnd = findJsonObjEnd(str, indexOf);
        return (indexOf == str2.length() || findJsonObjEnd == -1) ? "" : str.substring(indexOf, findJsonObjEnd).trim();
    }

    public static String getJsonObjectString(String str, String str2) {
        int indexOf = str.indexOf(str2) + str2.length() + 1;
        int findJsonObjEnd = findJsonObjEnd(str, indexOf);
        return (indexOf == str2.length() || findJsonObjEnd == -1) ? "" : str.substring(indexOf + 1, findJsonObjEnd - 1);
    }

    public static ArrayList<String> getJsonArrayObjects(String str) {
        if (str == null || str.length() <= 1 || str.equals("null")) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        int i = 1;
        while (i < str.length() - 1) {
            int findJsonArrayEnd = findJsonArrayEnd(str, i);
            if (!(i == -1 || findJsonArrayEnd == -1)) {
                arrayList.add(str.substring(i, findJsonArrayEnd));
            }
            i = findJsonArrayEnd + 1;
        }
        return arrayList;
    }

    public static int findJsonObjEnd(String str, int i) {
        if (i == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == joLeft.charAt(0)) {
                i2++;
            } else if (charAt == jaLeft.charAt(0)) {
                i3++;
            } else {
                if (charAt == "}".charAt(0)) {
                    i2--;
                }
                if (charAt == jaRight.charAt(0)) {
                    i3--;
                }
                if ((charAt == ",".charAt(0) || charAt == "}".charAt(0)) && i2 <= 0 && i3 <= 0) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static int findJsonArrayEnd(String str, int i) {
        if (i == -1) {
            return -1;
        }
        int i2 = 0;
        int i3 = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt == joLeft.charAt(0)) {
                i2++;
            } else if (charAt == jaLeft.charAt(0)) {
                i3++;
            } else {
                if (charAt == "}".charAt(0)) {
                    i2--;
                }
                if (charAt == jaRight.charAt(0)) {
                    i3--;
                }
                if ((charAt == ",".charAt(0) || charAt == jaRight.charAt(0)) && i2 <= 0 && i3 <= 0) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }

    public static byte[] getGZipCompressed(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = byteArrayInputStream.read(bArr2);
                    if (read > 0) {
                        gZIPOutputStream.write(bArr2, 0, read);
                    } else {
                        gZIPOutputStream.finish();
                        gZIPOutputStream.close();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                        return byteArray;
                    }
                }
            } catch (Exception e) {
                DLog.m32737d(e.toString());
            }
        }
        return null;
    }

    public static byte[] encrypt(byte[] bArr, boolean z) {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        for (int i = 0; i < 8; i++) {
            int random = ((int) (Math.random() * 100000.0d)) % 65536;
            if (random > 32767) {
                random -= 65536;
            }
            int i2 = i * 2;
            bArr3[i2] = (byte) random;
            bArr3[i2 + 1] = (byte) (random >> 8);
        }
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, new SecretKeySpec(KEY, "AES"), new IvParameterSpec(bArr3));
            bArr2 = instance.doFinal(bArr);
        } catch (Exception e) {
            DLog.m32737d(e.toString());
            bArr2 = null;
        }
        if (bArr2 == null || bArr2.length == 0) {
            return bArr2;
        }
        if (z) {
            byte[] bArr4 = new byte[(bArr2.length + 16)];
            System.arraycopy(bArr3, 0, bArr4, 0, 16);
            System.arraycopy(bArr2, 0, bArr4, 16, bArr2.length);
            return bArr4;
        }
        byte[] bArr5 = new byte[(bArr2.length + 16 + 1)];
        System.arraycopy(bArr3, 0, bArr5, 0, 16);
        bArr5[16] = (byte) (bArr2.length - bArr.length);
        System.arraycopy(bArr2, 0, bArr5, 17, bArr2.length);
        return bArr5;
    }

    public static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null) {
            return sb.toString();
        }
        for (byte hexString : bArr) {
            sb.append(Integer.toHexString(hexString));
        }
        return sb.toString();
    }
}
