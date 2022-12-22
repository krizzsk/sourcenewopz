package com.didi.entrega.customer.foundation.util;

import android.text.TextUtils;
import com.didi.entrega.customer.app.constant.AppConst;
import com.didi.entrega.customer.downgrade.DowngradeConfig;
import com.didi.entrega.customer.downgrade.LimitVisitEntity;
import com.didi.foundation.sdk.utils.FoundationApolloUtil;
import com.didi.global.globalgenerickit.utils.JsonUtil;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.net.RequestParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class CustomerApolloUtil {
    public static final String CUSTOMER_LONG_CONNECTION = "GJHWM_C";
    public static final String CUSTOMER_NET_DETECT_MONITOR = "sailing_net_detect_monitor_experiments";

    /* renamed from: a */
    private static final String f20081a = "CustomerApolloUtil";

    /* renamed from: b */
    private static final String f20082b = "global_C_web_url_append_params_hosts";

    /* renamed from: c */
    private static final String f20083c = "global_C_web_intercept_url_key";

    /* renamed from: d */
    private static final String f20084d = "global_entrega_order_im_switch";

    /* renamed from: e */
    private static final String f20085e = "global_entrega_law_dialog_switch";

    /* renamed from: f */
    private static final String f20086f = "soda_web_locale_exchange_host";

    /* renamed from: g */
    private static final String f20087g = "global_customer_im_merchant_voice_input_disable_config";

    /* renamed from: h */
    private static final String f20088h = "soda_order_polling_driver_duration";

    /* renamed from: i */
    private static final String f20089i = "soda_order_polling_bd_distance";

    /* renamed from: j */
    private static final String f20090j = "global_C_Android_map_lazyload";

    /* renamed from: k */
    private static final String f20091k = "global_C_Android_webview_omega";

    /* renamed from: l */
    private static final String f20092l = "global_C_Android_dependency_downgrade";

    /* renamed from: m */
    private static final String f20093m = "global_customer_ios_webpage_appendquery_toggle";

    /* renamed from: n */
    private static final String f20094n = "sailing_c_im_map_max_distance";

    /* renamed from: o */
    private static final String f20095o = "global_customer_addr_gps_timeout";

    /* renamed from: p */
    private static final String f20096p = "whitelist";

    /* renamed from: q */
    private static final String f20097q = "experiment";

    /* renamed from: r */
    private static final String f20098r = "params";

    /* renamed from: s */
    private static final String f20099s = "message";

    /* renamed from: t */
    private static final String f20100t = "global_C_customer_limit_visit";

    /* renamed from: u */
    private static final String f20101u = "global_customer_addr_back_time";

    /* renamed from: v */
    private static final String f20102v = "global_entrega_hidden_package_page";

    /* renamed from: w */
    private static final String f20103w = "global_entrega_map_hidden_countdown_bubbleview";

    /* renamed from: x */
    private static final String f20104x = "global_C_Android_get_fragment_way";

    /* renamed from: y */
    private static final String f20105y = "entrega_law_style_switch_02";

    /* renamed from: z */
    private static int f20106z;

    private CustomerApolloUtil() {
    }

    public static void addParameters() {
        Apollo.setRequestHandler(new RequestHandler() {
            public void handleRequestParams(RequestParams requestParams) {
                requestParams.addParam("rlab_location_country", LocationUtil.getCountryCode());
                requestParams.addParam("rlab_county_id", String.valueOf(LocationUtil.getCountyId()));
                requestParams.addParam("rlab_county_group_id", String.valueOf(LocationUtil.getCountyGroupId()));
                requestParams.addParam("rlab_business_id", AppConst.BUSINESS_ID);
            }
        });
    }

    public static List<String> getAppendParameterList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f20082b);
        if (jsonToggle != null) {
            return m14823a(jsonToggle, f20096p);
        }
        return null;
    }

    public static List<String> getBlackList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f20083c);
        if (jsonToggle != null) {
            return m14823a(jsonToggle, "blocklist");
        }
        return null;
    }

    public static List<String> getReplaceLocaleList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f20086f);
        if (jsonToggle != null) {
            return m14823a(jsonToggle, f20096p);
        }
        return null;
    }

    public static int getBackGorundRefreshShortTime() {
        return m14822a(1, f20101u, "short");
    }

    public static int getBackGorundRefreshLongTime() {
        return m14822a(15, f20101u, "long");
    }

    public static boolean isOpenWebAppendParam() {
        try {
            IToggle toggle = Apollo.getToggle(f20093m, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int lawStyle() {
        IToggle toggle = Apollo.getToggle(f20105y);
        if (toggle.allow()) {
            f20106z = ((Integer) toggle.getExperiment().getParam("style", 0)).intValue();
        }
        return f20106z;
    }

    public static boolean isOpenLawDialogSwitch() {
        try {
            IToggle toggle = Apollo.getToggle(f20085e, true);
            if (toggle != null) {
                return toggle.allow();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean packageInfoSwitch() {
        try {
            IToggle toggle = Apollo.getToggle(f20102v, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isRequestFacebookUserPostsPermission() {
        try {
            IToggle toggle = Apollo.getToggle("facebook_verification_permissions", false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static DowngradeConfig getDownGradeConfig() {
        try {
            IToggle toggle = Apollo.getToggle(f20092l, false);
            if (toggle != null && toggle.allow()) {
                DowngradeConfig downgradeConfig = new DowngradeConfig();
                IExperiment experiment = toggle.getExperiment();
                downgradeConfig.mToggle = 1;
                downgradeConfig.mDowngradeMap = ((Integer) experiment.getParam("dg_map", 0)).intValue();
                downgradeConfig.mDowngradeIM = ((Integer) experiment.getParam("dg_im", 0)).intValue();
                downgradeConfig.mDowngradeShare = ((Integer) experiment.getParam("dg_share", 0)).intValue();
                downgradeConfig.mDowngradeFacebookLogin = ((Integer) experiment.getParam("dg_third_login_facebook", 0)).intValue();
                downgradeConfig.mDowngradeGoogleLogin = ((Integer) experiment.getParam("dg_third_login_google", 0)).intValue();
                return downgradeConfig;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DowngradeConfig();
    }

    public static String getIMQuickMessages() {
        return FoundationApolloUtil.getIMQuickMessages("sailing_rlab_entrega_founding_configuration");
    }

    public static int getPollingDuration() {
        return m14821a(10, f20088h);
    }

    public static int getPollingBDDistance() {
        return m14821a(100, f20089i);
    }

    public static int getImMapMaxDistance() {
        return m14821a(1500, f20094n);
    }

    public static int getStartGpsTimeout() {
        return m14822a(4000, f20095o, "androidStart");
    }

    public static boolean isMapLazyLoadOn() {
        try {
            IToggle toggle = Apollo.getToggle(f20090j, true);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static LimitVisitEntity getLimitVisitConfig() {
        LimitVisitEntity limitVisitEntity = new LimitVisitEntity();
        try {
            IToggle toggle = Apollo.getToggle(f20100t, false);
            if (toggle != null && toggle.allow()) {
                IExperiment experiment = toggle.getExperiment();
                limitVisitEntity.isOpen = true;
                limitVisitEntity.limitTime = ((Integer) experiment.getParam("limit_time", 0)).intValue();
                limitVisitEntity.limitRandomTime = ((Integer) experiment.getParam("limit_random_plus_time", 0)).intValue();
                String str = (String) experiment.getParam("whiteAPIList", "");
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(",");
                    if (split.length > 0) {
                        limitVisitEntity.blackList = new ArrayList<>();
                        for (String trim : split) {
                            limitVisitEntity.blackList.add(trim.trim());
                        }
                    }
                }
                return limitVisitEntity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return limitVisitEntity;
    }

    public static boolean isWebViewOmegaOn() {
        try {
            IToggle toggle = Apollo.getToggle(f20091k, true);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isNetDetectEnable() {
        try {
            IToggle toggle = Apollo.getToggle("sailing_net_detect_monitor_experiments", false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    private static int m14821a(int i, String str) {
        return m14822a(i, str, "interval");
    }

    /* renamed from: a */
    private static int m14822a(int i, String str, String str2) {
        JSONObject jsonToggle = Apollo.getJsonToggle(str);
        if (jsonToggle != null) {
            try {
                JSONObject jSONObject = jsonToggle.getJSONObject(f20097q);
                JSONObject jSONObject2 = null;
                if (jSONObject != null) {
                    jSONObject2 = jSONObject.getJSONObject("params");
                }
                return jSONObject2 != null ? jSONObject2.optInt(str2, i) : i;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    public static boolean isImEnterAvild() {
        try {
            IToggle toggle = Apollo.getToggle(f20084d, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMapBubbleHiddenEnable() {
        try {
            IToggle toggle = Apollo.getToggle(f20103w, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    private static List<String> m14823a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(f20097q);
                JSONObject jSONObject3 = jSONObject2 != null ? jSONObject2.getJSONObject("params") : null;
                String optString = jSONObject3 != null ? jSONObject3.optString(str) : null;
                if (!TextUtil.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    if (split.length > 0) {
                        return new ArrayList(Arrays.asList(split));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Map<String, Object> m14824b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(f20097q);
                JSONObject jSONObject3 = jSONObject2 != null ? jSONObject2.getJSONObject("params") : null;
                return JsonUtil.jsonToMap(jSONObject3 != null ? jSONObject3.optString(str) : null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean createFragmentAllowNull() {
        try {
            if (((Integer) Apollo.getToggle(f20104x).getExperiment().getParam("is_open", 1)).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
