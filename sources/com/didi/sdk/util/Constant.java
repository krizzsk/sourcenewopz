package com.didi.sdk.util;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.didi.sdk.pay.base.PayConstants;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String ACCKEY = "8JCJZ-39FIU-8Q7EI-1M1U1-P4KB3-AVM1R";
    public static final String AUTH_FAILED_KEY = "auth_failed_key";
    public static final String BUSINESS_ACTIVITYX = "activityX";
    public static final String BUSINESS_BR_99TAXI = "99taxi";
    public static final String BUSINESS_BR_TOP = "top";
    public static final String BUSINESS_BUS = "bus";
    public static final String BUSINESS_CARMATE = "carmate";
    public static final String BUSINESS_DACHE = "dache";
    public static final String BUSINESS_DIDIMAP = "didimap";
    public static final String BUSINESS_DRIVERSERVICE = "driverservice";
    public static final String BUSINESS_ELDER = "elder";
    public static final String BUSINESS_EXTENDED = "extended";
    public static final String BUSINESS_FIRSTCLASS = "firstclass";
    public static final String BUSINESS_FLASH = "flash";
    public static final String BUSINESS_GONGJIAO = "gongjiao";
    public static final String BUSINESS_GUARANA = "guarana";
    public static final String[] BUSINESS_IDS = {"framework", "Sidebar", SidConverter.SID_OPERATION, "warmup", "upgrade", "renrenche", NotificationCompat.CATEGORY_ALARM, "didimap", "guarana", "carmate", "flash", "dache", "premium", "driverservice", "bus", "pacific", "smarttravel", "sofa", "rentcar", "gongjiao", "activityX", "elder", "firstclass", "extended", "unitaxi", "99taxi", "top", "ofo", "intercity"};
    public static final String BUSINESS_INTERCITY = "intercity";
    public static final String BUSINESS_OFO = "ofo";
    public static final String BUSINESS_PACIFIC = "pacific";
    public static final String BUSINESS_PREMIUM = "premium";
    public static final String BUSINESS_RENTCAR = "rentcar";
    public static final String BUSINESS_SMART = "smarttravel";
    public static final String BUSINESS_SOFA = "sofa";
    public static final String BUSINESS_TRYDRIVE = "trydrive";
    public static final String BUSINESS_UNITAXI = "unitaxi";
    public static String CONFIG_NAME = "server_config.properties";
    public static String CONFIG_NAME_OLD = "config.properties";
    public static final String DEBUG_LOG = "debugLog.log";
    public static final String DEBUG_LOG_DIR = ("didi" + File.separator + "debugLog");
    public static final Map<String, String> ENCODED_BUSINESS_ID_MAP;
    public static final String IS_PUSH = "is_push";
    public static final String LOGOUT_KEY = "logout_key";
    public static final String LOGOUT_REASON_SWITCH_SUFFIX_KEY = "logout_reason_switch_suffix_key";
    public static final String NET_LOG = "netlog.log";
    public static final String NET_LOG_DIR = ("didi" + File.separator + "netlog");
    public static final String PARAM_APP_KEY = "appKey";
    public static final String PARAM_APP_VERSION = "appversion";
    public static final String PARAM_CHANNEL = "channel";
    public static final String PARAM_CITY_ID = "city_id";
    public static final String PARAM_COVER_LAT = "lat";
    public static final String PARAM_COVER_LNG = "lng";
    public static final String PARAM_DATA_TYPE = "datatype";
    public static final String PARAM_DEVICE_ID = "dviceid";
    public static final String PARAM_DEVICE_ID_NEW = "deviceid";
    public static final String PARAM_IMEI = "imei";
    public static final String PARAM_MAP_TYPE = "maptype";
    public static final String PARAM_MODEL = "model";
    public static final String PARAM_NET_TYPE = "net_type";
    public static final String PARAM_OS = "os";
    public static final String PARAM_OS_TYPE = "ostype";
    public static final String PARAM_PHONE = "phone";
    public static final String PARAM_SUSIGN = "susig";
    public static final String PARAM_SUUID = "suuid";
    public static final String PARAM_TICKET = "ticket";
    public static final String PARAM_TOKEN = "token";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_USER_TYPE = "usertype";
    public static final String PARAM_UUID = "uuid";
    public static final String PARAM_VCODE = "vcode";
    public static final String PUSH_CONTENT = "push_content";
    public static final String PUSH_DATA = "push_data";
    public static final String PUSH_JSON = "push_json";
    public static final String PUSH_REDIRECT = "push_redirectjsonobject";
    public static final String PUSH_TITLE = "push_title";
    public static String SCREEN_PIXELS = "0*0";
    public static final String SDCARD_FILE_DIR = "didi";
    public static final String SDCARD_LOCATE_DIR = "didilocate";
    public static String SIGN_KEY = "*&didi@";
    public static final String TRACE_LOG = "traceLog.log";
    public static final String TRACE_LOG_DIR = ("didi" + File.separator + "traceLog");
    public static final int VOUCHER_RED_POINT_NO = 2;
    public static final int VOUCHER_RED_POINT_YES = 1;
    public static String WEIXIN_CAR_APP_ID = PayConstants.AppId.WEIXIN_CAR_APP_ID;
    public static String WEIXIN_TOUSER_NAME = "gh_fb617b8e284b";

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("TXc9PQ==", "carmate");
        hashMap.put("TkE9PQ==", "flash");
        hashMap.put("4", "flash");
        hashMap.put("TVE9PQ==", "dache");
        hashMap.put("TWc9PQ==", "premium");
        hashMap.put("2", "premium");
        hashMap.put("TlE9PQ==", "driverservice");
        hashMap.put("Tmc9PQ==", "gongjiao");
        hashMap.put("TWpZNQ==", "pacific");
        hashMap.put("TWpjeg==", "sofa");
        hashMap.put("sofa", "sofa");
        hashMap.put("TWpjdw==", "rentcar");
        hashMap.put("TWpjMg==", "firstclass");
        hashMap.put("TXpBMw==", "unitaxi");
        hashMap.put("TXpBNQ==", "ofo");
        hashMap.put("TXpFMg==", "guarana");
        hashMap.put("TXpJMw==", "99taxi");
        hashMap.put("TXpJMg==", "top");
        ENCODED_BUSINESS_ID_MAP = Collections.unmodifiableMap(hashMap);
    }

    public static String getBusinessIdByProductType(String str) {
        return ENCODED_BUSINESS_ID_MAP.get(str);
    }

    public static void initScreenPixes(Context context) {
        DisplayMetrics displayMetrics;
        if (context != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
            SCREEN_PIXELS = displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        }
    }
}
