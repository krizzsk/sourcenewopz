package com.didi.travel.psnger.p170v2.host;

import android.text.TextUtils;
import com.didi.travel.psnger.IHostConfig;

/* renamed from: com.didi.travel.psnger.v2.host.HostManager */
public class HostManager {
    public static final String DEFAULT_BIZ_HOST = "https://api.didiglobal.com/";
    public static final String DEFAULT_CAR_SLIDING_HOST = "https://common.didiglobal.com/";
    public static final String DEFAULT_ENTERPRISE_PAY_HOST = "https://esapi.didiglobal.com/";
    public static final String DEFAULT_RESOURCES_HOST = "https://api.didiglobal.com/";
    public static final String DEFAULT_ROUTE_TRACK_HOST = "https://common.didiglobal.com/";
    public static final String HOST_KEY_BIZ = "host_key_biz";
    public static final String HOST_KEY_CAR_SLIDING = "host_key_car_sliding";
    public static final String HOST_KEY_ENTERPRISE_PAY = "host_key_enterprise_pay";
    public static final String HOST_KEY_RESOURCES = "host_key_resources";
    public static final String HOST_KEY_ROUTE = "host_key_route";
    public static final String SHARE_PATH_BIZ_V1 = "gulfstream/api/v1/";
    public static final String SHARE_PATH_BIZ_V2 = "gulfstream/passenger/v2/";
    public static final String SHARE_PATH_ENTERPRISE_PAY = "crius/";
    public static final String SHARE_PATH_EVALUATE = "gulfstream/";

    /* renamed from: a */
    private static String f44252a = "https://api.didiglobal.com/";

    /* renamed from: b */
    private static String f44253b = null;

    /* renamed from: c */
    private static String f44254c = "https://common.didiglobal.com/";

    /* renamed from: d */
    private static String f44255d = "https://api.didiglobal.com/";

    /* renamed from: e */
    private static String f44256e = "https://api.didiglobal.com/";

    /* renamed from: f */
    private static String f44257f = "https://esapi.didiglobal.com/";

    public static void setHostConfig(IHostConfig iHostConfig) {
        if (iHostConfig != null) {
            if (!TextUtils.isEmpty(iHostConfig.businessHost())) {
                f44252a = iHostConfig.businessHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.evaluateHost())) {
                f44253b = iHostConfig.evaluateHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.carSlidingHost())) {
                f44254c = iHostConfig.carSlidingHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.activityHost())) {
                f44255d = iHostConfig.activityHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.routeTrackHost())) {
                f44256e = iHostConfig.routeTrackHost();
            }
            if (!TextUtils.isEmpty(iHostConfig.enterprisePayHost())) {
                f44257f = iHostConfig.enterprisePayHost();
            }
        }
    }

    public static String getBizHost() {
        return f44252a;
    }

    public static String getCarSlidingHost() {
        return f44254c;
    }

    public static String getResourcesHost() {
        return f44255d;
    }

    public static String getRouteHost() {
        return f44256e;
    }

    public static String getEnterprisePayHost() {
        return f44257f;
    }
}
