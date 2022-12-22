package com.didi.soda.customer.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.SccManager;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.util.CipherUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didichuxing.omega.sdk.Omega;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class ParamsHelper {

    /* renamed from: A */
    private static final String f40975A = "poiName";

    /* renamed from: B */
    private static final String f40976B = "poiCityId";

    /* renamed from: C */
    private static final String f40977C = "poiCountyId";

    /* renamed from: D */
    private static final String f40978D = "poiCountyGroupId";

    /* renamed from: E */
    private static final String f40979E = "enterChannel";

    /* renamed from: F */
    private static final String f40980F = "extActivityId";
    public static final String FLUTTER_APP_PLATFORM = "appPlatform";
    public static final String FLUTTER_APP_VERSION = "appVersion";
    public static final String FLUTTER_BRAND_NAME = "brandName";
    public static final String FLUTTER_BUILD_TYPE = "buildType";
    public static final String FLUTTER_CALLING_CODE = "callingCode";
    public static final String FLUTTER_COUNTRY = "country";
    public static final String FLUTTER_HAS_STATUS_BAR_DRAWABLE = "hasStatusbarDrawable";
    public static final String FLUTTER_IMMERSIVE_STATUSBAR_HEIGHT = "immersiveStatusbarHeight";
    public static final String FLUTTER_IS_EMBED = "isEmbed";
    public static final String FLUTTER_LANG = "lang";
    public static final String FLUTTER_LOCALE = "locale";
    public static final String FLUTTER_MANUFACTURER = "manufacturer";
    public static final String FLUTTER_MODEL = "model";
    public static final String FLUTTER_OS_VERSION = "osVersion";
    public static final String FLUTTER_SEMANTICS_ENABLE = "semanticsTurnOff";
    public static final String FLUTTER_SODA_TYPE = "sodaType";
    public static final String FLUTTER_STATUS_BAR_HEIGHT = "statusbarHeight";
    public static final String FLUTTER_TIME_OFFSET = "timeOffset";
    public static final String FLUTTER_TOKEN = "token";
    public static final String FLUTTER_UTC_OFFSET = "utcOffset";

    /* renamed from: G */
    private static final String f40981G = "firstActivityId";

    /* renamed from: H */
    private static final String f40982H = "firstChannelId";
    public static final String H5_BRIDGE_STATUS_BAR_HEIGHT = "statusBarHeight";

    /* renamed from: I */
    private static final String f40983I = "locale";

    /* renamed from: J */
    private static final String f40984J = "lang";

    /* renamed from: K */
    private static final String f40985K = "dataType";

    /* renamed from: L */
    private static final String f40986L = "terminalId";

    /* renamed from: M */
    private static final String f40987M = "mapType";

    /* renamed from: N */
    private static final String f40988N = "imei";

    /* renamed from: O */
    private static final String f40989O = "ip";

    /* renamed from: P */
    private static final String f40990P = "locationType";

    /* renamed from: Q */
    private static final String f40991Q = "operatorName";

    /* renamed from: R */
    private static final String f40992R = "linuxKernel";

    /* renamed from: S */
    private static final String f40993S = "wifiName";

    /* renamed from: T */
    private static final String f40994T = "requestId";
    public static final String TEST_CONFIG = "testConfig";

    /* renamed from: U */
    private static final String f40995U = "soda_from";

    /* renamed from: V */
    private static final String f40996V = "scc";

    /* renamed from: W */
    private static final String f40997W = "scg";

    /* renamed from: X */
    private static final String f40998X = "sci";

    /* renamed from: Y */
    private static final String f40999Y = "businessType";

    /* renamed from: Z */
    private static final String f41000Z = "brand";

    /* renamed from: a */
    private static final String f41001a = "|";

    /* renamed from: aa */
    private static final String f41002aa = "terminalType";

    /* renamed from: ab */
    private static final String f41003ab = "poiCountryCode";

    /* renamed from: ac */
    private static final String f41004ac = "countryCode";

    /* renamed from: ad */
    private static final String f41005ad = "oid";

    /* renamed from: ae */
    private static final String f41006ae = "product_id";

    /* renamed from: af */
    private static final String f41007af = "utc_offset";

    /* renamed from: ag */
    private static final String f41008ag = "city_id";

    /* renamed from: ah */
    private static final String f41009ah = "os_type";

    /* renamed from: ai */
    private static final String f41010ai = "didi_pass_app_type";

    /* renamed from: aj */
    private static Calendar f41011aj = null;

    /* renamed from: b */
    private static final int f41012b = 2;

    /* renamed from: c */
    private static final String f41013c = "16";

    /* renamed from: d */
    private static final String f41014d = "token";

    /* renamed from: e */
    private static final String f41015e = "appVersion";

    /* renamed from: f */
    private static final String f41016f = "versionCode";

    /* renamed from: g */
    private static final String f41017g = "osType";

    /* renamed from: h */
    private static final String f41018h = "osVersion";

    /* renamed from: i */
    private static final String f41019i = "suuid";

    /* renamed from: j */
    private static final String f41020j = "uuid";

    /* renamed from: k */
    private static final String f41021k = "deviceId";

    /* renamed from: l */
    private static final String f41022l = "clientType";

    /* renamed from: m */
    private static final String f41023m = "lat";

    /* renamed from: n */
    private static final String f41024n = "lng";

    /* renamed from: o */
    private static final String f41025o = "bizId";

    /* renamed from: p */
    private static final String f41026p = "deviceType";

    /* renamed from: q */
    private static final String f41027q = "cityId";

    /* renamed from: r */
    private static final String f41028r = "countyId";

    /* renamed from: s */
    private static final String f41029s = "countyGroupId";

    /* renamed from: t */
    private static final String f41030t = "networkType";

    /* renamed from: u */
    private static final String f41031u = "poiId";

    /* renamed from: v */
    private static final String f41032v = "poiLat";

    /* renamed from: w */
    private static final String f41033w = "poiLng";

    /* renamed from: x */
    private static final String f41034x = "channel";

    /* renamed from: y */
    private static final String f41035y = "timestamp";

    /* renamed from: z */
    private static final String f41036z = "deviceBrand";

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
        hashMap.put(f41025o, AppConst.BUSINESS_ID);
        hashMap.put("appVersion", SystemUtil.getVersionName(context));
        hashMap.put("versionCode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("osType", 2);
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put(f41026p, SystemUtil.getModel());
        hashMap.put(f41036z, CustomerSystemUtil.getDeviceBrand());
        hashMap.put(f41022l, 9);
        hashMap.put("businessType", 2);
        hashMap.put("brand", 3);
        hashMap.put(f41002aa, 2);
        hashMap.put("networkType", NetWorkUtils.getNetworkType(context));
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("uuid", SecurityUtil.getUUID());
        hashMap.put(f41021k, CustomerSystemUtil.getDeviceId());
        hashMap.put("lat", Double.valueOf(LocationUtil.getCurrentLat()));
        hashMap.put("lng", Double.valueOf(LocationUtil.getCurrentLng()));
        hashMap.put("cityId", Integer.valueOf(LocationUtil.getCityId()));
        hashMap.put("countyId", Long.valueOf(LocationUtil.getCountyId()));
        hashMap.put("countyGroupId", Long.valueOf(LocationUtil.getCountyGroupId()));
        hashMap.put("poiId", LocationUtil.getPoiId());
        hashMap.put(f41032v, Double.valueOf(LocationUtil.getPoiLat()));
        hashMap.put(f41033w, Double.valueOf(LocationUtil.getPoiLng()));
        hashMap.put(f40976B, Integer.valueOf(LocationUtil.getPoiCityId()));
        hashMap.put(f40977C, Long.valueOf(LocationUtil.getPoiCountyId()));
        hashMap.put(f40978D, Long.valueOf(LocationUtil.getPoiCountyGroupId()));
        hashMap.put(f40975A, LocationUtil.getPoiDisplayName());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("timestamp", Long.valueOf(Clock.timeAtSeconds()));
        hashMap.put(f40979E, OmegaCommonParamHelper.getChannelId());
        hashMap.put(f40980F, OmegaCommonParamHelper.getActivityId());
        hashMap.put(f40981G, OmegaCommonParamHelper.getFirstActivityId());
        hashMap.put(f40982H, OmegaCommonParamHelper.getFirstChannelId());
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("ip", CustomerSystemUtil.getLocalIpAddress(context));
        hashMap.put(f40992R, CustomerSystemUtil.getKernelVersion());
        hashMap.put(f40987M, CustomerSystemUtil.getMapType());
        hashMap.put(f40990P, Integer.valueOf(CustomerSystemUtil.getLocationType()));
        hashMap.put(f40993S, CustomerSystemUtil.getSsId(context));
        hashMap.put(f40994T, m29120c());
        hashMap.put("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hashMap.put("dataType", "16");
        hashMap.put("terminalId", 300106);
        hashMap.put(f41003ab, LocationUtil.getPoiCountryCode());
        hashMap.put("countryCode", LocationUtil.getCountryCode());
        hashMap.put("oid", Omega.getOmegaIdSafety());
        hashMap.put(TEST_CONFIG, ABConfigHelper.Companion.getAllConfig());
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
        buildUpon.appendQueryParameter(f41032v, String.valueOf(LocationUtil.getPoiLat()));
        buildUpon.appendQueryParameter(f41033w, String.valueOf(LocationUtil.getPoiLng()));
        buildUpon.appendQueryParameter(f40976B, String.valueOf(LocationUtil.getPoiCityId()));
        buildUpon.appendQueryParameter(f40977C, String.valueOf(LocationUtil.getPoiCountyId()));
        buildUpon.appendQueryParameter(f40978D, String.valueOf(LocationUtil.getPoiCountyGroupId()));
        buildUpon.appendQueryParameter(f40995U, "1");
        buildUpon.appendQueryParameter(f41003ab, LocationUtil.getPoiCountryCode());
        buildUpon.appendQueryParameter("countryCode", LocationUtil.getCountryCode());
        buildUpon.appendQueryParameter("terminalId", String.valueOf(300106));
        buildUpon.appendQueryParameter("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        buildUpon.appendQueryParameter("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        return buildUpon.build().toString();
    }

    public static String addDiDiPassParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        String token = LoginUtil.getToken();
        if (!TextUtil.isEmpty(token)) {
            buildUpon.appendQueryParameter("token", token);
        }
        buildUpon.appendQueryParameter("product_id", String.valueOf(601)).appendQueryParameter("utc_offset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset())).appendQueryParameter("city_id", String.valueOf(LocationUtil.getCityId())).appendQueryParameter("os_type", String.valueOf(getClientType())).appendQueryParameter(f41010ai, GlobalContext.isEmbed() ? "1" : "0");
        return buildUpon.build().toString();
    }

    public static String addGetCommonParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String scc = ((SccManager) SingletonFactory.get(SccManager.class)).getScc();
        UrlBuilder appendParam = UrlBuilder.create(str).appendParam(f40997W, m29118a()).appendParam(f40998X, m29119b());
        if (!TextUtils.isEmpty(scc)) {
            appendParam.appendParam(f40996V, scc);
        }
        return appendParam.build();
    }

    /* renamed from: a */
    private static String m29118a() {
        Calendar d = m29121d();
        d.setTimeInMillis(TimeUnit.SECONDS.toMillis(Clock.timeAtSeconds()));
        return CipherUtil.md5(String.format("%.2f", new Object[]{Double.valueOf(LocationUtil.getCurrentLat())}) + "|" + String.format("%.2f", new Object[]{Double.valueOf(LocationUtil.getCurrentLng())}) + "|" + d.get(11));
    }

    /* renamed from: b */
    private static String m29119b() {
        return CustomerSystemUtil.getDeviceId() + "|" + 2;
    }

    /* renamed from: c */
    private static String m29120c() {
        return CipherUtil.md5(CustomerSystemUtil.getDeviceId() + "_" + Clock.timeAtSeconds());
    }

    /* renamed from: d */
    private static Calendar m29121d() {
        if (f41011aj == null) {
            f41011aj = Calendar.getInstance();
        }
        return f41011aj;
    }
}
