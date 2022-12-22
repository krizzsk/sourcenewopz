package com.didi.soda.customer.foundation.util;

import android.text.TextUtils;
import com.didi.foundation.sdk.utils.FoundationApolloUtil;
import com.didi.global.globalgenerickit.utils.JsonUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.blocks.optimize.BlocksOptimizeModel;
import com.didi.soda.customer.app.FixInfo;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.biz.popdialog.ApolloModel;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.coordshop.ApolloCoordConfig;
import com.didi.soda.customer.downgrade.DowngradeConfig;
import com.didi.soda.customer.downgrade.LimitVisitEntity;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.map.model.CustomerMapStyle;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.topgun.manager.HomeStartUpRepo;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.net.RequestParams;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class CustomerApolloUtil {

    /* renamed from: A */
    private static final String f41143A = "global_C_Android_open_start_up";

    /* renamed from: B */
    private static final String f41144B = "address_homepage_uid";

    /* renamed from: C */
    private static final String f41145C = "global_soda_im_map_has_max_distance";
    public static final String CUSTOMER_LONG_CONNECTION = "GJHWM_C";
    public static final String CUSTOMER_NET_DETECT_MONITOR = "sailing_net_detect_monitor_experiments";

    /* renamed from: D */
    private static final String f41146D = "global_customer_appsflyer_destory_control";

    /* renamed from: E */
    private static final String f41147E = "global_C_Android_get_fragment_way";

    /* renamed from: F */
    private static final String f41148F = "global_customer_feedback_pannel_config";

    /* renamed from: G */
    private static final String f41149G = "global_C_Android_map_new_render";

    /* renamed from: H */
    private static final String f41150H = "global_customer_flutter_semantics_off";
    public static final String HTTPDNS_NAMESPACE = "httpdns_android_waimai";

    /* renamed from: I */
    private static final String f41151I = "sa_promotion_method_ab_test";

    /* renamed from: J */
    private static final String f41152J = "global_C_open_preload_h5";

    /* renamed from: K */
    private static final String f41153K = "global_C_open_mock_location";

    /* renamed from: L */
    private static final String f41154L = "global_C_open_fix_bad_parcelable";

    /* renamed from: M */
    private static final String f41155M = "global_customer_recshop_config";

    /* renamed from: N */
    private static final String f41156N = "whitelist";

    /* renamed from: O */
    private static final String f41157O = "experiment";

    /* renamed from: P */
    private static final String f41158P = "params";

    /* renamed from: Q */
    private static final String f41159Q = "message";

    /* renamed from: R */
    private static final String f41160R = "global_customer_show_NA_pop_new";

    /* renamed from: S */
    private static final String f41161S = "global_C_customer_limit_visit";

    /* renamed from: T */
    private static final String f41162T = "global_C_negative_comment_select_reason";

    /* renamed from: U */
    private static final String f41163U = "C_User_preference";

    /* renamed from: V */
    private static final String f41164V = "Envelope_promocode_experiment";

    /* renamed from: W */
    private static int f41165W = -1;

    /* renamed from: X */
    private static boolean f41166X = false;

    /* renamed from: Y */
    private static boolean f41167Y = false;

    /* renamed from: Z */
    private static final String f41168Z = "citymap";

    /* renamed from: a */
    private static final String f41169a = "CustomerApolloUtil";

    /* renamed from: aa */
    private static final String f41170aa = "global_customer_disable_tabbar_imageview_placeholder";

    /* renamed from: ab */
    private static final String f41171ab = "ShopDesign_all";

    /* renamed from: ac */
    private static final String f41172ac = "customer_ab_test_name_map";

    /* renamed from: ad */
    private static final String f41173ad = "global_C_aether_Android_optimize";

    /* renamed from: b */
    private static final String f41174b = "global_customer_addr_gps_timeout";

    /* renamed from: c */
    private static final String f41175c = "global_customer_random_balance_verify";

    /* renamed from: d */
    private static final String f41176d = "global_C_web_url_append_params_hosts";

    /* renamed from: e */
    private static final String f41177e = "global_C_web_intercept_url_key";

    /* renamed from: f */
    private static final String f41178f = "soda_web_locale_exchange_host";

    /* renamed from: g */
    private static final String f41179g = "global_order_im_switch";

    /* renamed from: h */
    private static final String f41180h = "global_customer_im_merchant_voice_input_disable_config";

    /* renamed from: i */
    private static final String f41181i = "soda_order_polling_driver_duration";

    /* renamed from: j */
    private static final String f41182j = "soda_rate_dialog_duration";

    /* renamed from: k */
    private static final String f41183k = "global_C_Android_google_play_checker";

    /* renamed from: l */
    private static final String f41184l = "soda_order_polling_bd_distance";

    /* renamed from: m */
    private static final String f41185m = "global_C_Android_map_lazyload";

    /* renamed from: n */
    private static final String f41186n = "global_C_Android_webview_omega";

    /* renamed from: o */
    private static final String f41187o = "global_customer_addr_back_time";

    /* renamed from: p */
    private static final String f41188p = "global_C_place_order_tip_dialog";

    /* renamed from: q */
    private static final String f41189q = "global_customer_android_kotlin_on";

    /* renamed from: r */
    private static final String f41190r = "global_customer_add_cart_queue_strategy_params";

    /* renamed from: s */
    private static final String f41191s = "global_C_bill_price_anim";

    /* renamed from: t */
    private static final String f41192t = "android_customer_googlemap_style";

    /* renamed from: u */
    private static final String f41193u = "global_customer_android_in_app_review";

    /* renamed from: v */
    private static final String f41194v = "global_C_Android_dependency_downgrade";

    /* renamed from: w */
    private static final String f41195w = "global_C_appsflyer_omega_switch";

    /* renamed from: x */
    private static final String f41196x = "global_C_RLink_organic_city2url_map";

    /* renamed from: y */
    private static final String f41197y = "global_customer_ios_webpage_appendquery_toggle";

    /* renamed from: z */
    private static final String f41198z = "sailing_c_im_map_max_distance";

    public static boolean isFlutterSemanticsOff() {
        return true;
    }

    private CustomerApolloUtil() {
    }

    public static void addParameters() {
        Apollo.setRequestHandler(new RequestHandler() {
            public void handleRequestParams(RequestParams requestParams) {
                String countryCode = LocationUtil.getCountryCode();
                if (countryCode == null) {
                    countryCode = "";
                }
                requestParams.addParam("location_country", countryCode);
                requestParams.addParam("rlab_location_country", countryCode);
                requestParams.addParam("rlab_county_id", String.valueOf(LocationUtil.getCountyId()));
                requestParams.addParam("rlab_county_group_id", String.valueOf(LocationUtil.getCountyGroupId()));
                requestParams.addParam("rlab_business_id", AppConst.BUSINESS_ID);
            }
        });
    }

    public static List<String> getKotlinOnPageList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f41189q);
        if (jsonToggle != null) {
            return m29194a(jsonToggle, "message");
        }
        return null;
    }

    public static boolean getSALandingShowAddr() {
        try {
            IToggle toggle = Apollo.getToggle(f41151I, false);
            if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("group", 0)).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isOpenPreloadH5() {
        try {
            IToggle toggle = Apollo.getToggle(f41152J, true);
            if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("is_open", 1)).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isOpenMockLocation() {
        try {
            return Apollo.getToggle(f41153K, false).allow();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static FixInfo isFixBadParcel() {
        try {
            IToggle toggle = Apollo.getToggle(f41154L, false);
            if (toggle.allow()) {
                return FixInfo.Companion.create(true, (String) toggle.getExperiment().getParam("phone_model", ""), ((Integer) toggle.getExperiment().getParam("with_brand", 0)).intValue() == 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FixInfo.Companion.create(false, "", false);
    }

    public static ApolloCoordConfig getCoordShopConfig() {
        try {
            IToggle toggle = Apollo.getToggle(f41155M, true);
            if (toggle.allow()) {
                return ApolloCoordConfig.Companion.create((String) toggle.getExperiment().getParam("shop_minvisible_json", ""), ((Integer) toggle.getExperiment().getParam("home_maxvisible", 0)).intValue());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, Object> getOrganicCityMap() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f41196x);
        if (jsonToggle != null) {
            return m29195b(jsonToggle, f41168Z);
        }
        return null;
    }

    public static boolean isValidateCardEnable() {
        try {
            IToggle toggle = Apollo.getToggle(f41175c, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> getAppendParameterList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f41176d);
        if (jsonToggle != null) {
            return m29194a(jsonToggle, f41156N);
        }
        return null;
    }

    public static List<String> getBlackList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f41177e);
        if (jsonToggle != null) {
            return m29194a(jsonToggle, "blocklist");
        }
        return null;
    }

    public static List<String> getReplaceLocaleList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f41178f);
        if (jsonToggle != null) {
            return m29194a(jsonToggle, f41156N);
        }
        return null;
    }

    public static boolean isOpenWebAppendParam() {
        try {
            IToggle toggle = Apollo.getToggle(f41197y, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSkipPromoCode() {
        try {
            IToggle toggle = Apollo.getToggle(f41164V, false);
            if (toggle != null) {
                return toggle.allow();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static FallbackController.FallbackModel getFallbackToggleModel() {
        try {
            FallbackController.FallbackModel fallbackModel = new FallbackController.FallbackModel();
            boolean z = false;
            IToggle toggle = Apollo.getToggle(f41143A, false);
            if (toggle == null || !toggle.allow()) {
                return fallbackModel;
            }
            IExperiment experiment = toggle.getExperiment();
            fallbackModel.isOpen = true;
            fallbackModel.isOpenLazyComponent = ((Integer) experiment.getParam("open_lazy_comp", 0)).intValue() == 1;
            fallbackModel.isOpenDelayFlutter = ((Integer) experiment.getParam("open_delay_flutter", 0)).intValue() == 1;
            fallbackModel.isOpenPreLoc = ((Integer) experiment.getParam("open_pre_loc", 0)).intValue() == 1;
            fallbackModel.isCloseSplashPost = ((Integer) experiment.getParam("close_splash_post", 0)).intValue() == 1;
            fallbackModel.isOpenAsyncLayout = ((Integer) experiment.getParam("open_async_layout", 0)).intValue() == 1;
            fallbackModel.isOpenPreFeed = ((Integer) experiment.getParam("open_pre_feed", 0)).intValue() == 1;
            if (((Integer) experiment.getParam("remove_set_view", 0)).intValue() == 1) {
                z = true;
            }
            fallbackModel.isRemoveSetView = z;
            return fallbackModel;
        } catch (Exception e) {
            e.printStackTrace();
            return new FallbackController.FallbackModel();
        }
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

    public static boolean isSelectReason() {
        try {
            IToggle toggle = Apollo.getToggle(f41162T, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isImEnterAvild() {
        try {
            IToggle toggle = Apollo.getToggle(f41179g, false);
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
            IToggle toggle = Apollo.getToggle(f41194v, false);
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

    public static int naPopDialogInterval() {
        int i = f41165W;
        if (i > 0) {
            return i;
        }
        return m29192a(30, f41160R);
    }

    public static String getIMQuickMessages() {
        return FoundationApolloUtil.getIMQuickMessages("sailing_rlab_founding_configuration");
    }

    public static boolean isConfigMerchantComment() {
        try {
            String iMQuickMessages = getIMQuickMessages();
            if (TextUtils.isEmpty(iMQuickMessages) || new JSONObject(iMQuickMessages).optJSONObject("merchant") == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getAudioInputEnableIMMessage() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f41180h);
        if (jsonToggle != null) {
            try {
                JSONObject jSONObject = jsonToggle.getJSONObject(f41157O);
                JSONObject jSONObject2 = jSONObject != null ? jSONObject.getJSONObject("params") : null;
                String optString = jSONObject2 != null ? jSONObject2.optString("message") : null;
                LogUtil.m29104i(f41169a, "IM Common words from ab: " + optString);
                return optString;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getPollingDuration() {
        return m29192a(10, f41181i);
    }

    public static int getPollingBDDistance() {
        return m29192a(100, f41184l);
    }

    public static int getImMapMaxDistance() {
        return m29192a(1500, f41198z);
    }

    public static int getRateDialogShowInterval() {
        return m29192a(0, f41182j);
    }

    public static boolean isGoogleInAppReviewMode() {
        try {
            IToggle toggle = Apollo.getToggle(f41193u, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isOmegaTrack() {
        try {
            IToggle toggle = Apollo.getToggle(f41195w, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getBackGorundRefreshShortTime() {
        return m29193a(1, f41187o, "short");
    }

    public static int getBackGorundRefreshLongTime() {
        return m29193a(15, f41187o, "long");
    }

    public static boolean isGooglePlayCheckerOn() {
        try {
            IToggle toggle = Apollo.getToggle(f41183k, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMapLazyLoadOn() {
        try {
            IToggle toggle = Apollo.getToggle(f41185m, true);
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
            IToggle toggle = Apollo.getToggle(f41161S, false);
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
            IToggle toggle = Apollo.getToggle(f41186n, true);
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

    public static int getStartGpsTimeout() {
        return m29193a(4000, f41174b, "androidStart");
    }

    public static int getBackGpsTimeout() {
        return m29193a(4000, f41174b, "androidBack");
    }

    public static int getAddCartMaxNum() {
        return m29193a(15, f41190r, "cartCapacity");
    }

    public static int getAddCartDelayTime() {
        return m29193a(200, f41190r, "taskCommitInterval");
    }

    public static boolean hasMapMaxDistance() {
        return m29193a(0, f41145C, "noMaxDistance") == 0;
    }

    public static boolean isPlaceOrderTipDialog() {
        if (f41166X) {
            return f41167Y;
        }
        f41166X = true;
        try {
            IToggle toggle = Apollo.getToggle(f41188p, false);
            if (toggle != null) {
                boolean allow = toggle.allow();
                f41167Y = allow;
                return allow;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f41167Y = false;
        return false;
    }

    public static String getHomeFeedbackBtnConfig() {
        try {
            return (String) Apollo.getToggle(f41148F).getExperiment().getParam("btnList", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isBillPriceAnimOn() {
        try {
            return Apollo.getToggle(f41191s).allow();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void go2EfoOrNot(ActInfoEntity actInfoEntity, String str, int i) {
        try {
            IToggle toggle = Apollo.getToggle(f41163U);
            IExperiment experiment = toggle.getExperiment();
            String str2 = (String) experiment.getParam("url", "");
            String json = GsonUtil.toJson(actInfoEntity);
            UrlBuilder create = UrlBuilder.create(str2);
            String build = create.appendParam("scene", i + "").appendParam(Const.PageParams.COMPONENT_ID, str).appendParam(Const.PageParams.ACT_INFO, json).build();
            AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
            AppConfig data = appConfigStorage.getData();
            if (toggle.allow() && experiment != null && !TextUtils.isEmpty(str2) && ((Boolean) ((HomeStartUpRepo) RepoFactory.getRepo(HomeStartUpRepo.class)).getValue()).booleanValue() && Math.abs(System.currentTimeMillis() - data.landEFO) >= GlobalBubbleShowHelper.ONE_WEEK) {
                data.landEFO = System.currentTimeMillis();
                appConfigStorage.setData(data);
                ((HomeStartUpRepo) RepoFactory.getRepo(HomeStartUpRepo.class)).setValue(false);
                SchemeHelper.dispatchMsg(build);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CustomerMapStyle getCustomerGoogleMapStyle() {
        try {
            IExperiment experiment = Apollo.getToggle(f41192t).getExperiment();
            CustomerMapStyle customerMapStyle = new CustomerMapStyle();
            customerMapStyle.styleJson = (String) experiment.getParam("style_jsonString", "");
            boolean z = false;
            if (((Integer) experiment.getParam("building_enable", 0)).intValue() == 1) {
                z = true;
            }
            customerMapStyle.buildingEnable = z;
            return customerMapStyle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ApolloModel getAFDestroySwitch() {
        ApolloModel apolloModel = new ApolloModel(true, 5000);
        try {
            IToggle toggle = Apollo.getToggle(f41146D, true);
            if (toggle != null) {
                apolloModel.setOpen(toggle.allow());
                if (toggle.allow()) {
                    apolloModel.setTimeout(((Integer) toggle.getExperiment().getParam("unregister_time_out", 5000)).intValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apolloModel;
    }

    public static boolean createFragmentAllowNull() {
        try {
            if (((Integer) Apollo.getToggle(f41147E).getExperiment().getParam("is_open", 1)).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static int m29192a(int i, String str) {
        return m29193a(i, str, "interval");
    }

    /* renamed from: a */
    private static int m29193a(int i, String str, String str2) {
        JSONObject jsonToggle = Apollo.getJsonToggle(str);
        if (jsonToggle != null) {
            try {
                JSONObject jSONObject = jsonToggle.getJSONObject(f41157O);
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

    /* renamed from: a */
    private static List<String> m29194a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(f41157O);
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
    private static Map<String, Object> m29195b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(f41157O);
                JSONObject jSONObject3 = jSONObject2 != null ? jSONObject2.getJSONObject("params") : null;
                return JsonUtil.jsonToMap(jSONObject3 != null ? jSONObject3.optString(str) : null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getLocationSettingShownInterval() {
        IToggle toggle = Apollo.getToggle(f41144B);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("hour", 0)).intValue();
        }
        return 0;
    }

    public static boolean tabBarPlaceHolderSwitch() {
        try {
            IToggle toggle = Apollo.getToggle(f41170aa, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMapNewRender() {
        try {
            IToggle toggle = Apollo.getToggle(f41149G, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isShowNewBusiness() {
        try {
            String str = (String) Apollo.getToggle(f41171ab).getExperiment().getParam("page_config", "");
            if (!TextUtils.isEmpty(str) && new JSONObject(str).optJSONObject(RoutePath.BUSINESS_HOME).optInt("self") == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getNewBusinessFeedType() {
        int optInt;
        if (!isShowNewBusiness()) {
            return 0;
        }
        String customerAbName = getCustomerAbName();
        if (TextUtils.isEmpty(customerAbName)) {
            return 1;
        }
        IToggle toggle = Apollo.getToggle(customerAbName);
        if (toggle.allow()) {
            String str = (String) toggle.getExperiment().getParam("page_config", "");
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = null;
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jSONObject == null || jSONObject.optJSONObject(RoutePath.BUSINESS_HOME) == null || (optInt = jSONObject.optJSONObject(RoutePath.BUSINESS_HOME).optInt("feedType")) == 0) {
                    return 1;
                }
                return optInt;
            }
        }
        return 1;
    }

    public static String getCustomerAbName() {
        IToggle toggle = Apollo.getToggle(f41172ac);
        if (toggle.allow()) {
            return toggle.getExperiment().getStringParam("shopRedsign", "");
        }
        return null;
    }

    public static BlocksOptimizeModel getBlocksOptimizeToggleModel() {
        try {
            BlocksOptimizeModel blocksOptimizeModel = new BlocksOptimizeModel();
            boolean z = false;
            IToggle toggle = Apollo.getToggle(f41173ad, false);
            if (toggle == null || !toggle.allow()) {
                return blocksOptimizeModel;
            }
            IExperiment experiment = toggle.getExperiment();
            blocksOptimizeModel.setOpen(true);
            blocksOptimizeModel.setOpenResultCache(((Integer) experiment.getParam("open_result_cache", 0)).intValue() == 1);
            if (((Integer) experiment.getParam("open_regular_replace", 0)).intValue() == 1) {
                z = true;
            }
            blocksOptimizeModel.setOpenRegularReplace(z);
            return blocksOptimizeModel;
        } catch (Exception e) {
            e.printStackTrace();
            return new BlocksOptimizeModel();
        }
    }
}
