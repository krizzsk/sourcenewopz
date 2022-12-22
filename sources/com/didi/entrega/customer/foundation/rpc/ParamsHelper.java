package com.didi.entrega.customer.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.AppConst;
import com.didi.entrega.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.entrega.customer.foundation.util.CipherUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.omega.sdk.Omega;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class ParamsHelper {

    /* renamed from: A */
    private static final String f19953A = "poiName";

    /* renamed from: B */
    private static final String f19954B = "poiCityId";

    /* renamed from: C */
    private static final String f19955C = "poiCountyId";

    /* renamed from: D */
    private static final String f19956D = "poiCountyGroupId";
    public static final String DATA_TYPE = "dataType";

    /* renamed from: E */
    private static final String f19957E = "enterChannel";

    /* renamed from: F */
    private static final String f19958F = "extActivityId";
    public static final String FLUTTER_APP_PLATFORM = "appPlatform";
    public static final String FLUTTER_APP_VERSION = "appVersion";
    public static final String FLUTTER_BRAND_NAME = "brandName";
    public static final String FLUTTER_BUILD_TYPE = "buildType";
    public static final String FLUTTER_CALLING_CODE = "callingCode";
    public static final String FLUTTER_COUNTRY = "country";
    public static final String FLUTTER_DEVICE_TOKEN = "deviceToken";
    public static final String FLUTTER_IMMERSIVE_STATUSBAR_HEIGHT = "immersiveStatusbarHeight";
    public static final String FLUTTER_IS_EMBED = "isEmbed";
    public static final String FLUTTER_KF_PAGE_SOURCE = "kfPageSource";
    public static final String FLUTTER_LANG = "lang";
    public static final String FLUTTER_LOCALE = "locale";
    public static final String FLUTTER_MANUFACTURER = "manufacturer";
    public static final String FLUTTER_MODEL = "model";
    public static final String FLUTTER_OS_VERSION = "osVersion";
    public static final String FLUTTER_SODA_TYPE = "sodaType";
    public static final String FLUTTER_STATUS_BAR_HEIGHT = "statusbarHeight";
    public static final String FLUTTER_TIME_OFFSET = "timeOffset";
    public static final String FLUTTER_TOKEN = "token";
    public static final String FLUTTER_UID = "uid";
    public static final String FLUTTER_UTC_OFFSET = "utcOffset";

    /* renamed from: G */
    private static final String f19959G = "firstActivityId";

    /* renamed from: H */
    private static final String f19960H = "firstChannelId";

    /* renamed from: I */
    private static final String f19961I = "locale";

    /* renamed from: J */
    private static final String f19962J = "lang";

    /* renamed from: K */
    private static final String f19963K = "terminalId";

    /* renamed from: L */
    private static final String f19964L = "mapType";

    /* renamed from: M */
    private static final String f19965M = "imei";

    /* renamed from: N */
    private static final String f19966N = "ip";

    /* renamed from: O */
    private static final String f19967O = "locationType";

    /* renamed from: P */
    private static final String f19968P = "linuxKernel";

    /* renamed from: Q */
    private static final String f19969Q = "wifiName";

    /* renamed from: R */
    private static final String f19970R = "requestId";

    /* renamed from: S */
    private static final String f19971S = "soda_from";

    /* renamed from: T */
    private static final String f19972T = "businessType";

    /* renamed from: U */
    private static final String f19973U = "brand";

    /* renamed from: V */
    private static final String f19974V = "terminalType";

    /* renamed from: W */
    private static final String f19975W = "sailingBizLine";

    /* renamed from: X */
    private static final String f19976X = "poiCountryCode";

    /* renamed from: Y */
    private static final String f19977Y = "countryCode";

    /* renamed from: Z */
    private static final String f19978Z = "oid";

    /* renamed from: a */
    private static final String f19979a = "|";

    /* renamed from: aa */
    private static final String f19980aa = "product_id";

    /* renamed from: ab */
    private static final String f19981ab = "utc_offset";

    /* renamed from: ac */
    private static final String f19982ac = "city_id";

    /* renamed from: ad */
    private static final String f19983ad = "os_type";

    /* renamed from: ae */
    private static Calendar f19984ae = null;

    /* renamed from: b */
    private static final int f19985b = 2;

    /* renamed from: c */
    private static final String f19986c = "16";

    /* renamed from: d */
    private static final String f19987d = "token";

    /* renamed from: e */
    private static final String f19988e = "appVersion";

    /* renamed from: f */
    private static final String f19989f = "versionCode";

    /* renamed from: g */
    private static final String f19990g = "osType";

    /* renamed from: h */
    private static final String f19991h = "osVersion";

    /* renamed from: i */
    private static final String f19992i = "suuid";

    /* renamed from: j */
    private static final String f19993j = "uuid";

    /* renamed from: k */
    private static final String f19994k = "deviceId";

    /* renamed from: l */
    private static final String f19995l = "clientType";

    /* renamed from: m */
    private static final String f19996m = "lat";

    /* renamed from: n */
    private static final String f19997n = "lng";

    /* renamed from: o */
    private static final String f19998o = "bizId";

    /* renamed from: p */
    private static final String f19999p = "deviceType";

    /* renamed from: q */
    private static final String f20000q = "cityId";

    /* renamed from: r */
    private static final String f20001r = "countyId";

    /* renamed from: s */
    private static final String f20002s = "countyGroupId";

    /* renamed from: t */
    private static final String f20003t = "networkType";

    /* renamed from: u */
    private static final String f20004u = "poiId";

    /* renamed from: v */
    private static final String f20005v = "poiLat";

    /* renamed from: w */
    private static final String f20006w = "poiLng";

    /* renamed from: x */
    private static final String f20007x = "channel";

    /* renamed from: y */
    private static final String f20008y = "timestamp";

    /* renamed from: z */
    private static final String f20009z = "deviceBrand";

    public static int getClientType() {
        return 2;
    }

    private ParamsHelper() {
    }

    public static Map<String, Object> getCommonParams() {
        HashMap hashMap = new HashMap();
        Context context = GlobalContext.getContext();
        String token = LoginUtil.getToken();
        if (!TextUtil.isEmpty(token)) {
            hashMap.put("token", token);
        }
        hashMap.put(f19998o, AppConst.BUSINESS_ID);
        hashMap.put("appVersion", SystemUtil.getVersionName(context));
        hashMap.put("versionCode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("osType", 2);
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put(f19999p, SystemUtil.getModel());
        hashMap.put(f20009z, CustomerSystemUtil.getDeviceBrand());
        hashMap.put(f19995l, 9);
        hashMap.put("businessType", 2);
        hashMap.put("brand", 3);
        hashMap.put(f19974V, 2);
        hashMap.put("networkType", NetWorkUtils.getNetworkType(context));
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("uuid", SecurityUtil.getUUID());
        hashMap.put(f19994k, CustomerSystemUtil.getDeviceId());
        hashMap.put("lat", Double.valueOf(LocationUtil.getCurrentLat()));
        hashMap.put("lng", Double.valueOf(LocationUtil.getCurrentLng()));
        hashMap.put("cityId", Integer.valueOf(LocationUtil.getCityId()));
        hashMap.put("countyId", Long.valueOf(LocationUtil.getCountyId()));
        hashMap.put("countyGroupId", Long.valueOf(LocationUtil.getCountyGroupId()));
        hashMap.put("poiId", LocationUtil.getPoiId());
        hashMap.put(f20005v, Double.valueOf(LocationUtil.getPoiLat()));
        hashMap.put(f20006w, Double.valueOf(LocationUtil.getPoiLng()));
        hashMap.put(f19954B, Integer.valueOf(LocationUtil.getPoiCityId()));
        hashMap.put(f19955C, Long.valueOf(LocationUtil.getPoiCountyId()));
        hashMap.put(f19956D, Long.valueOf(LocationUtil.getPoiCountyGroupId()));
        hashMap.put(f19953A, LocationUtil.getPoiDisplayName());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("timestamp", Long.valueOf(Clock.timeAtSeconds()));
        hashMap.put(f19957E, OmegaCommonParamHelper.getChannelId());
        hashMap.put(f19958F, OmegaCommonParamHelper.getActivityId());
        hashMap.put(f19959G, OmegaCommonParamHelper.getFirstActivityId());
        hashMap.put(f19960H, OmegaCommonParamHelper.getFirstChannelId());
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("ip", CustomerSystemUtil.getLocalIpAddress(context));
        hashMap.put(f19968P, CustomerSystemUtil.getKernelVersion());
        hashMap.put(f19964L, CustomerSystemUtil.getMapType());
        hashMap.put(f19967O, Integer.valueOf(CustomerSystemUtil.getLocationType()));
        hashMap.put(f19969Q, CustomerSystemUtil.getSsId(context));
        hashMap.put(f19970R, m14775a());
        hashMap.put("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hashMap.put(DATA_TYPE, "16");
        hashMap.put("terminalId", 300106);
        hashMap.put(f19976X, LocationUtil.getPoiCountryCode());
        hashMap.put("countryCode", LocationUtil.getCountryCode());
        hashMap.put("oid", Omega.getOmegaIdSafety());
        hashMap.put(f19975W, 2);
        return hashMap;
    }

    public static Map<String, String> getFlutterRouterCommonParam() {
        HashMap hashMap = new HashMap();
        Context context = GlobalContext.getContext();
        hashMap.put("brandName", "99");
        hashMap.put("country", LocationUtil.getCountryCode());
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hashMap.put("isEmbed", GlobalContext.isEmbed() ? "1" : "0");
        hashMap.put("utcOffset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        hashMap.put("timeOffset", String.valueOf(Clock.timeAtSeconds()));
        String token = LoginUtil.getToken();
        if (!TextUtil.isEmpty(token)) {
            hashMap.put("token", token);
        }
        hashMap.put("appVersion", SystemUtil.getVersionName(context));
        hashMap.put("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        hashMap.put("sodaType", "c");
        hashMap.put("appPlatform", "3");
        hashMap.put(FLUTTER_KF_PAGE_SOURCE, "sodaEntrega");
        return hashMap;
    }

    public static String addCommonParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : getCommonParams().entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), "" + next.getValue());
        }
        return buildUpon.build().toString();
    }

    public static String addH5CommonParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("poiId", LocationUtil.getPoiId());
        buildUpon.appendQueryParameter(f20005v, String.valueOf(LocationUtil.getPoiLat()));
        buildUpon.appendQueryParameter(f20006w, String.valueOf(LocationUtil.getPoiLng()));
        buildUpon.appendQueryParameter(f19954B, String.valueOf(LocationUtil.getPoiCityId()));
        buildUpon.appendQueryParameter(f19955C, String.valueOf(LocationUtil.getPoiCountyId()));
        buildUpon.appendQueryParameter(f19956D, String.valueOf(LocationUtil.getPoiCountyGroupId()));
        buildUpon.appendQueryParameter(f19971S, "1");
        buildUpon.appendQueryParameter(f19976X, LocationUtil.getPoiCountryCode());
        buildUpon.appendQueryParameter("countryCode", LocationUtil.getCountryCode());
        buildUpon.appendQueryParameter("terminalId", String.valueOf(300106));
        buildUpon.appendQueryParameter("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        buildUpon.appendQueryParameter("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    private static String m14775a() {
        return CipherUtil.md5(CustomerSystemUtil.getDeviceId() + "_" + Clock.timeAtSeconds());
    }
}
