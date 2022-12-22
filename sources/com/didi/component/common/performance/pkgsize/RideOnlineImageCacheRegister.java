package com.didi.component.common.performance.pkgsize;

import android.content.Context;
import com.didi.sdk.performance.OnlineImageConstant;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.resource.warehouse.image.OnlineImageCacheManager;
import com.didi.sdk.resource.warehouse.image.PriorityType;

public class RideOnlineImageCacheRegister {
    public static final String URL_INVITE_CODE_BG_BRAZIL = "https://img0.didiglobal.com/static/quickbolt/Hye5BiQoRL2EEOIz.png";
    public static final String URL_INVITE_CODE_BG_GLOBAL = "https://img0.didiglobal.com/static/quickbolt/7diQZd9y0SGr37qU.webp";
    public static final String URL_WAIT_RSP_PAGE_WEBP_CAA = "https://img0.didiglobal.com/static/quickbolt/webp_caa.webp";
    public static final String URL_WAIT_RSP_PAGE_WEBP_CAB = "https://img0.didiglobal.com/static/quickbolt/webp_cab.webp";
    public static final String URL_XPANEL_CTC_BRAZIL = "https://img0.didiglobal.com/static/quickbolt/bbutCy2wPTAKkegC.png";
    public static final String URL_XPANEL_CTC_GLOBAL = "https://img0.didiglobal.com/static/quickbolt/Fwes3tRVMPp0Yk87.png";

    public static void register(Context context) {
        OnlineImageCacheManager instance = OnlineImageCacheManager.getInstance(context);
        instance.register(URL_XPANEL_CTC_BRAZIL, PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_GLIDE);
        instance.register(URL_XPANEL_CTC_GLOBAL, PriorityType.HIGH, ICacheProvider.PROVIDER_KEY_GLIDE);
        instance.register(OnlineImageConstant.URL_BIND_GUIDE_PAYPAY_BG, PriorityType.MEDIUM, ICacheProvider.PROVIDER_KEY_GLIDE);
        instance.register(URL_INVITE_CODE_BG_GLOBAL, PriorityType.MEDIUM, ICacheProvider.PROVIDER_KEY_GLIDE);
        instance.register(URL_INVITE_CODE_BG_BRAZIL, PriorityType.MEDIUM, ICacheProvider.PROVIDER_KEY_GLIDE);
    }
}
