package com.didi.entrega.customer.p113h5;

import com.didi.entrega.customer.BuildConfig;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;

/* renamed from: com.didi.entrega.customer.h5.CustomerH5UrlConst */
public final class CustomerH5UrlConst {
    public static final String CPF = "https://food-c-h5.99app.com/${locale}/cart/cpf-check";
    public static final String CURP = "https://page.didiglobal.com/global/passenger/apps/verify/curp/index.html?platform_type=2";
    public static final String HTTP_HOST = "https://food-c-h5.99app.com/${locale}/";
    public static final String RELEASE_CART_SELECT_COUPON_URL = "https://food-c-h5.99app.com/${locale}/cart/coupon";
    public static final String SERVICE_HOST = "https://help.didiglobal.com/";

    private CustomerH5UrlConst() {
    }

    public static String getLawUrl() {
        String poiCountryCode = LocationUtil.getPoiCountryCode();
        String langTag = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag();
        return BuildConfig.C_LAW_URL + "?" + "location_country=" + poiCountryCode + "&lang=" + langTag;
    }
}
