package com.didi.remotereslibrary.utils;

import androidx.core.app.NotificationCompat;
import com.didi.remotereslibrary.RemoteResourceManager;
import com.didi.sdk.util.SidConverter;

public class Constants {
    public static final String BUSINESS_ACTIVITYX = "activityX";
    public static final String BUSINESS_BUS = "bus";
    public static final String BUSINESS_CARMATE = "carmate";
    public static final String BUSINESS_DACHE = "dache";
    public static final String BUSINESS_DRIVERSERVICE = "driverservice";
    public static final String BUSINESS_ELDER = "elder";
    public static final String BUSINESS_EXTENDED = "extended";
    public static final String BUSINESS_FIRSTCLASS = "firstclass";
    public static final String BUSINESS_FLASH = "flash";
    public static final String BUSINESS_GONGJIAO = "gongjiao";
    public static final String[] BUSINESS_IDS = {"framework", "Sidebar", SidConverter.SID_OPERATION, "warmup", "upgrade", NotificationCompat.CATEGORY_ALARM, "carmate", "flash", "dache", "premium", "driverservice", "bus", "trydrive", "pacific", "smarttravel", "sofa", "rentcar", "gongjiao", "activityX", "elder", "firstclass", "extended", "unitaxi", "ofo"};
    public static final String BUSINESS_OFO = "ofo";
    public static final String BUSINESS_PACIFIC = "pacific";
    public static final String BUSINESS_PREMIUM = "premium";
    public static final String BUSINESS_RENTCAR = "rentcar";
    public static final String BUSINESS_SMART = "smarttravel";
    public static final String BUSINESS_SOFA = "sofa";
    public static final String BUSINESS_TRYDRIVE = "trydrive";
    public static final String BUSINESS_UNITAXI = "unitaxi";
    public static final String DIRECTORY_DOWNLOADS_SUBPATH = "remoteresource/";

    public static String getRemoteResourceUrl() {
        String domainUrl = RemoteResourceManager.getInstance().getDomainParam() != null ? RemoteResourceManager.getInstance().getDomainParam().getDomainUrl() : "";
        return domainUrl + "/remoteres/reslist";
    }
}
