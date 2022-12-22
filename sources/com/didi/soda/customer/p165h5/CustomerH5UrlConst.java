package com.didi.soda.customer.p165h5;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.BuildConfig;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.didi.soda.customer.h5.CustomerH5UrlConst */
public final class CustomerH5UrlConst {
    public static final String ACT_HTTP_HOST = "https://food-act.99app.com/${locale}/";
    public static final String APP_CONTACT_US = "https://food-c-h5.99app.com/${locale}/about/contact";
    public static final String APP_SERVICE = "https://help.didiglobal.com/passenger-index-new.html";
    public static final String CART_TIP = "https://food-c-h5.99app.com/${locale}/cart/tip";
    public static final String CPF = "https://food-c-h5.99app.com/${locale}/cart/cpf-check";
    public static final String CURP = "https://page.didiglobal.com/global/passenger/apps/verify/curp/index.html?platform_type=2";
    public static final String DELIVERY_DETAIL = "https://food-c-h5.99app.com/${locale}/delivery";
    public static final String HTTP_HOST = "https://food-c-h5.99app.com/${locale}/";
    public static final String LADING_PAGE = "https://food-act.99app.com/${locale}/c/landingPage";
    public static final String ORDER_CANCEL_URL = "https://food-c-h5.99app.com/${locale}/order/cancel-order";
    public static final String ORDER_SERVICE = "https://help.didiglobal.com/processing-passenger-new.html";
    public static final String RELEASE_CART_SELECT_COUPON_URL = "https://food-c-h5.99app.com/${locale}/cart/coupon";
    public static final String RELEASE_CART_SELECT_R_COUPON_URL = "https://food-c-h5.99app.com/${locale}/cart/r/coupon";
    public static final String SERVICE_HOST = "https://help.didiglobal.com/";
    public static final String SIDEBAR_COUPON = "https://food-c-h5.99app.com/${locale}/sidebar/coupon";
    public static final String STORE_EVENTS = "https://food-c-h5.99app.com/${locale}/cart/reduction";

    /* renamed from: a */
    static String m29227a() {
        return "https://food-c-h5.99app.com/${locale}/cart/coupon";
    }

    private CustomerH5UrlConst() {
    }

    public static String getSideServiceUrl(String str) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            str = APP_SERVICE;
        }
        sb.append(str);
        sb.append("?");
        sb.append("utc_offset=");
        sb.append(String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        sb.append("&appversion=");
        sb.append(SystemUtil.getVersionName(GlobalContext.getContext()));
        sb.append("&token=");
        sb.append(LoginUtil.getToken());
        sb.append("&lat=");
        sb.append(LocationUtil.getPoiLat());
        sb.append("&lng=");
        sb.append(LocationUtil.getPoiLng());
        sb.append("&city_id=");
        sb.append(LocationUtil.getPoiCityId());
        sb.append("&lang=");
        sb.append(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        sb.append("&source=soda_global_c_home");
        sb.append("&soda_type=c");
        sb.append("&app_platform=3");
        return sb.toString();
    }

    public static boolean isPassengerServiceUrl(String str) {
        return str != null && str.contains(APP_SERVICE);
    }

    public static String getHelperServiceUrl(String str) {
        if (str == null) {
            return null;
        }
        Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
        if (queryParameterNames == null) {
            return str;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("utc_offset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        hashMap.put("appversion", SystemUtil.getVersionName(GlobalContext.getContext()));
        hashMap.put("token", LoginUtil.getToken());
        hashMap.put("lat", String.valueOf(LocationUtil.getPoiLat()));
        hashMap.put("lng", String.valueOf(LocationUtil.getPoiLng()));
        hashMap.put("city_id", String.valueOf(LocationUtil.getPoiCityId()));
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hashMap.put("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        hashMap.put("soda_type", "c");
        hashMap.put("source", "soda_global_c_home");
        if (!GlobalContext.isEmbed()) {
            hashMap.put("app_platform", "3");
        }
        Set<Map.Entry> entrySet = hashMap.entrySet();
        StringBuilder sb = new StringBuilder(str);
        boolean isEmpty = queryParameterNames.isEmpty();
        for (Map.Entry entry : entrySet) {
            if (!queryParameterNames.contains(entry.getKey())) {
                if (isEmpty) {
                    isEmpty = false;
                    sb.append("?");
                } else {
                    sb.append(ParamKeys.SIGN_AND);
                }
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
        }
        return sb.toString();
    }

    public static String getLawUrl() {
        String poiCountryCode = LocationUtil.getPoiCountryCode();
        String langTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
        return BuildConfig.C_LAW_URL + "?" + "location_country=" + poiCountryCode + "&lang=" + langTag;
    }
}
