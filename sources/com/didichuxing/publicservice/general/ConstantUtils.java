package com.didichuxing.publicservice.general;

import android.text.TextUtils;
import android.util.SparseArray;
import com.didi.sdk.publicservice.PublicServiceUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale;
import com.didichuxing.publicservice.resourcecontrol.utils.RoamingManager;

public class ConstantUtils {
    public static final int ACTOR_SRC_CUSTOMER = 2002;
    public static final int ACTOR_SRC_DRIVER = 2001;
    public static final String BRAZIL_RESOURCE_NAME = "pas_notice";
    public static final int DEFAULT_CODE = 1000;
    public static String EXTRA_RESOURCE_ID = "resourceId";
    public static String EXTRA_RESOURCE_STR = "resourcestr";
    public static String EXTRA_RESOURCE_TYPE = "resourceType";
    public static String EXTRA_WEBVIEW_TITLE = "resourcettitle";
    public static String EXTRA_WEBVIEW_URL = "resource";
    public static final String GLOBAL_RESOURCE_NAME = "gpas_notice";
    public static final int HTTP_FAIL_SIGNATURE_FAILED = 108;
    public static final int HTTP_FAIL_TO_GET_CALL_RECORD = 105;
    public static final int HTTP_FAIL_TO_GET_NOT_SUPPORT_THIS_CITY = 106;
    public static final int HTTP_FAIL_TO_OPERATOR_CALL_FAIL = 107;
    public static final int HTTP_FREQUENT_CALL = 103;
    public static final int HTTP_INVALID_TOKEN = 101;
    public static final int HTTP_NONE_EXIST_RECEIVER = 104;
    public static final int HTTP_OK = 0;
    public static final int HTTP_ORDER_FINISHED = 102;
    public static final int HTTP_RC_NEITHER_SHOW_BOTH = 2;
    public static final int HTTP_RC_ONLY_BELL_BUTTON = 1;
    public static final int HTTP_RUNTIME_EXCEPTION = 998;
    public static String IMAGE_FILE_URL = "didiImg";
    public static String IMAGE_SPLASH_URL = "didiSplash";
    public static final int LISTVIEW_IMGE_WIDTH = 710;
    public static final int LISTVIEW_IMG_HEIGHT = 264;
    public static final int LIST_FRAGMENT_CODE = 1001;
    public static String NOTICE_RESOURCE = "noticeresource";
    public static final String PASSAGER_NOTICE_RESOURCE_NAME_V2 = "pas_notice_v2";
    public static final String PASSAGER_RESOURCE_NAME = "pas_start_page";
    public static final int PERSONAL_CENTER_IMG_HEIGHT = 250;
    public static final int PERSONAL_CENTER_IMG_WIDTH = 935;
    public static final int POPWINDOW_IMG_HEIGHT = 905;
    public static final int POPWINDOW_IMG_WIDTH = 680;
    public static String POPWINDOW_RESOURCE = "popwindowresouce";
    public static final int POPWINDW_FRAGMENT_CODE = 1003;
    public static final int POPWINDW_FRAGMENT_CODE_NEW = 1006;
    public static final int POPWINDW_FRAGMENT_CODE_UBER = 1005;
    public static final String POP_RES_BUSINESS_ABILITY_ID = "passenger/pResGetRuledTag";
    public static final String POP_RES_PUBLIC_ABILITY_ID = "passenger/pResGetRuledGlobal";
    public static final int RC_EVENT_LOG_CLICK = 2;
    public static final int RC_EVENT_LOG_RING = 3;
    public static final int RC_EVENT_LOG_SHOW = 1;
    public static String SHAREDPRERENCE_KEY = "sharedprferencekey";
    public static String SHAREDPRERENCE_URL = "localsharedprference";
    public static final String SHARED_PRERENCE_NAME = "number_protect";
    public static final int SPLASHVIEW_FRAGMENT_CODE = 1002;
    public static String SPLASH_RESOURCE = "splashresource";
    public static final String SPREFERENCE_KEY_CONFIG = "key_config";
    public static final String TASK_PLAY_AUDIO_HINT = "play_audio_hint";
    public static URLEnvironment URL_ENVIRONMENT = null;
    public static String URL_RC_COMBINED_ESOURCE = "/getCombinationResource";
    public static String URL_RC_EVNETLOG = "/eventLog";
    public static String URL_RC_GET_CONFIG = "/getInitConfig";
    public static String URL_RC_HISTORY_NOTICE_RESOURCE = "/getHistoryResource";
    public static String URL_RC_NOTICE_RESOURCE = "/getAllValidResource";
    public static String URL_RC_ONE_RESOURCE = "/getPasMultiNotices";
    public static String URL_RC_ONE_RESOURCE_BR = "/getRuled";
    public static String URL_RC_ONE_RESOURCE_GLOBAL = "/getRuled";
    public static String URL_RC_PRELOAD_SPLASH_RESOURCE = "/getPreloaded";
    public static String URL_RC_PROLOAD_OTHER_RESOURCE = "/getPreLoadingAnotherResource";
    public static String URL_RC_REDIRECT = "/contentRedirect";
    public static String URL_RC_RED_DOT_STATUS = "/getRedPointStatus";
    public static String URL_RC_SERVER = "https://ctv3.didiglobal.com/resapi/activity";
    public static String URL_RC_SERVER_BR = "https://ctv3.didiglobal.com/resapi/activity";
    public static String URL_RC_SERVER_DEBUG = "";
    public static String URL_RC_SERVER_GLOBAL = "https://ctv3.didiglobal.com/resapi/activity";
    public static final int WAITING_IMG_HEIGHT = 160;
    public static final int WAITING_IMG_WIDTH = 690;
    public static final int WEBVIEW_FRAGMENT_CODE = 1004;
    public static String WEBVIEW_RESOURCE = "webviewresouce";

    public enum URLEnvironment {
        ONLINE,
        OFFLINE
    }

    public static String getRCServerUrl() {
        String debugHost = getDebugHost();
        if (!TextUtils.isEmpty(debugHost)) {
            AppUtils.log("getRCServerUrl, debugHost=" + debugHost);
            return debugHost;
        } else if (ResourceLocale.isResourceLocaleIsPt()) {
            return URL_RC_SERVER_BR;
        } else {
            if (ResourceLocale.isResourceLocaleIsGl()) {
                return URL_RC_SERVER_GLOBAL;
            }
            if (RoamingManager.isRoaming()) {
                return URL_RC_SERVER_GLOBAL;
            }
            return URL_RC_SERVER_GLOBAL;
        }
    }

    private static String getDebugHost() {
        try {
            IToggle toggle = Apollo.getToggle("global_publicservice_debug_on");
            if (toggle.allow()) {
                return (String) toggle.getExperiment().getParam("host", "");
            }
        } catch (Exception e) {
            AppUtils.log("getDebugHost, msg:" + e.getMessage());
        }
        return "";
    }

    public static String getRcOneResource() {
        if (ResourceLocale.isResourceLocaleIsPt()) {
            return URL_RC_ONE_RESOURCE_BR;
        }
        if (ResourceLocale.isResourceLocaleIsGl()) {
            return URL_RC_ONE_RESOURCE_GLOBAL;
        }
        if (RoamingManager.isRoaming()) {
            return URL_RC_ONE_RESOURCE_GLOBAL;
        }
        return URL_RC_ONE_RESOURCE;
    }

    public enum AppId {
        DIDI_PASSENGER(1),
        DIDI_DRIVER(2),
        KUAIDI_PASENGER(3),
        KUAIDI_DRIVER(4),
        YIHAO_PASSENGER(5),
        YIHAO_DRIVER(6),
        ECHO_PASSENGER(8);
        

        /* renamed from: id */
        private int f48488id;

        private AppId(int i) {
            this.f48488id = i;
        }

        public String toString() {
            return String.valueOf(this.f48488id);
        }
    }

    public enum BusinessId {
        DIDI_PASSENGER(256, PublicServiceUtil.DIDI_PSG_APP_KEY),
        ECHO_PASSENGER_V1(281, "echo-passager"),
        ECHO_PASSENGER_V2(280, "echo-passager");
        
        private String appKey;

        /* renamed from: id */
        private int f48489id;

        private BusinessId(int i, String str) {
            this.f48489id = i;
            this.appKey = str;
        }

        public int getId() {
            return this.f48489id;
        }

        public String getAppKey() {
            return this.appKey;
        }
    }

    public enum ResourceType {
        SPLASH(1),
        NOTICE(2),
        USERCENTER_BANNER(3),
        WAIT_BANNER(4),
        MSG_STREAM(5);
        
        private int type;

        private ResourceType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    public static class ResourceId {
        public static final ResourceId DIDI_ZHUANCHE_DRIVER_MSG_STREAM = getResource(47);
        public static final ResourceId DIDI_ZHUANCHE_DRIVER_SPLASH = getResource(46);
        public static final ResourceId GLOBAL_JAPAN_FLASH = getResource(68);
        public static final ResourceId HAILANG = getResource(50);
        public static final ResourceId NOTICE_99TAXI = getResource(63);
        public static final ResourceId NOTICE_BUS = getResource(14);
        public static final ResourceId NOTICE_CARE_PREMIUM = getResource(67);
        public static final ResourceId NOTICE_CARPOOL = getResource(66);
        public static final ResourceId NOTICE_DAIJIA = getResource(13);
        public static final ResourceId NOTICE_ECHO_V1 = getResource(55);
        public static final ResourceId NOTICE_ECHO_V2 = getResource(54);
        public static final ResourceId NOTICE_ELDER = getResource(61);
        public static final ResourceId NOTICE_FIRSTCAR = getResource(59);
        public static final ResourceId NOTICE_GONGJIAO = getResource(57);
        public static final ResourceId NOTICE_GUARANA = getResource(62);
        public static final ResourceId NOTICE_KUAICHE = getResource(11);
        public static final ResourceId NOTICE_OFO = getResource(60);
        public static final ResourceId NOTICE_POP = getResource(64);
        public static final ResourceId NOTICE_PUBLIC = getResource(15);
        public static final ResourceId NOTICE_SHUNFENGCHE = getResource(12);
        public static final ResourceId NOTICE_TAXI = getResource(9);
        public static final ResourceId NOTICE_UBER_ENJOIN = getResource(65);
        public static final ResourceId NOTICE_UNTAXI = getResource(58);
        public static final ResourceId NOTICE_YIHAO_V1 = getResource(56);
        public static final ResourceId NOTICE_ZHUANCHE = getResource(10);
        public static final ResourceId PACIFIC_OCEAN = getResource(52);
        public static final ResourceId SHICHENG_SHIJIA = getResource(49);
        public static final ResourceId SOFA = getResource(53);
        public static final ResourceId SPLASH = getResource(1);
        public static final ResourceId TRAVELLING_BANNER_BUS = getResource(45);
        public static final ResourceId TRAVELLING_BANNER_KUAICHE = getResource(42);
        public static final ResourceId TRAVELLING_BANNER_SHUNFENGCHE = getResource(43);
        public static final ResourceId TRAVELLING_BANNER_TAXI = getResource(40);
        public static final ResourceId TRAVELLING_BANNER_ZHUANCHE = getResource(41);
        public static final ResourceId TRAVELLING_BANNE_DAIJIAR = getResource(44);
        public static final ResourceId TRAVELLING_DISCOVER_BUS = getResource(39);
        public static final ResourceId TRAVELLING_DISCOVER_DAIJIAR = getResource(38);
        public static final ResourceId TRAVELLING_DISCOVER_KUAICHE = getResource(36);
        public static final ResourceId TRAVELLING_DISCOVER_SHUNFENGCHE = getResource(37);
        public static final ResourceId TRAVELLING_DISCOVER_TAXI = getResource(34);
        public static final ResourceId TRAVELLING_DISCOVER_ZHUANCHE = getResource(35);
        public static final ResourceId TRAVELLING_GAME_BUS = getResource(33);
        public static final ResourceId TRAVELLING_GAME_DAIJIAR = getResource(32);
        public static final ResourceId TRAVELLING_GAME_KUAICHE = getResource(30);
        public static final ResourceId TRAVELLING_GAME_SHUNFENGCHE = getResource(31);
        public static final ResourceId TRAVELLING_GAME_TAXI = getResource(28);
        public static final ResourceId TRAVELLING_GAME_ZHUANCHE = getResource(29);
        public static final ResourceId USERCENTER_BANNER = getResource(2);
        public static final ResourceId WAIT_BANNER_BUS = getResource(8);
        public static final ResourceId WAIT_BANNER_KUAICHE = getResource(5);
        public static final ResourceId WAIT_BANNER_SHUNFENGCHE = getResource(6);
        public static final ResourceId WAIT_BANNER_TAXI = getResource(3);
        public static final ResourceId WAIT_BANNER_ZHUANCHE = getResource(4);
        public static final ResourceId WAIT_BANNE_DAIJIAR = getResource(7);
        public static final ResourceId WAIT_DISCOVER_BUS = getResource(27);
        public static final ResourceId WAIT_DISCOVER_DAIJIAR = getResource(26);
        public static final ResourceId WAIT_DISCOVER_KUAICHE = getResource(24);
        public static final ResourceId WAIT_DISCOVER_SHUNFENGCHE = getResource(25);
        public static final ResourceId WAIT_DISCOVER_TAXI = getResource(22);
        public static final ResourceId WAIT_DISCOVER_ZHUANCHE = getResource(23);
        public static final ResourceId WAIT_GAME_BUS = getResource(21);
        public static final ResourceId WAIT_GAME_DAIJIAR = getResource(20);
        public static final ResourceId WAIT_GAME_KUAICHE = getResource(18);
        public static final ResourceId WAIT_GAME_SHUNFENGCHE = getResource(19);
        public static final ResourceId WAIT_GAME_TAXI = getResource(16);
        public static final ResourceId WAIT_GAME_ZHUANCHE = getResource(17);
        public static final ResourceId X_BUTTON = getResource(51);
        public static final ResourceId YIHAO_ZHUANCHE_USERCENTER_BANNER = getResource(48);
        private static SparseArray<ResourceId> resourceIdList = new SparseArray<>();

        /* renamed from: id */
        private int f48490id;

        private ResourceId(int i) {
            this.f48490id = i;
        }

        public static ResourceId getResource(int i) {
            if (resourceIdList == null) {
                resourceIdList = new SparseArray<>();
            }
            synchronized (resourceIdList) {
                if (resourceIdList.indexOfKey(i) >= 0) {
                    ResourceId resourceId = resourceIdList.get(i);
                    return resourceId;
                }
                ResourceId resourceId2 = new ResourceId(i);
                resourceIdList.put(i, resourceId2);
                return resourceId2;
            }
        }

        public int getId() {
            return this.f48490id;
        }

        public SparseArray<ResourceId> values() {
            return resourceIdList;
        }
    }

    public enum AppKey {
        BR_APPKEY(PublicServiceUtil.DIDI_PSG_APP_KEY),
        ZH_APPKEY(PublicServiceUtil.DIDI_PSG_APP_KEY);
        
        String appkey;

        private AppKey(String str) {
            this.appkey = str;
        }

        public String getAppkey() {
            return this.appkey;
        }
    }
}
