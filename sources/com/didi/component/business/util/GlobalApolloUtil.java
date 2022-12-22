package com.didi.component.business.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.PhoneYearClass;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.ApolloCache;
import com.didi.sdk.util.AppUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.p165h5.CustomerWebActivity;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.didiglobal.travel.util.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalApolloUtil {
    public static String AB_KEY_ROUTE_EDITOR = "AddStops_Test";
    public static String KEY_NEW_UI_TRIP = "APP_Revision_Phase_3_final";

    /* renamed from: a */
    private static final String f11377a = "global_home_page_vouchers_perception";

    /* renamed from: b */
    private static boolean f11378b = false;

    /* renamed from: c */
    private static boolean f11379c = true;

    public static boolean isRequestFacebookUserPostsPermission() {
        return false;
    }

    public static boolean isShowCarpoolTravelDetail() {
        return true;
    }

    public static boolean isJPRecommendationOpen() {
        if (!getStatus("Japan_eyeball_tag_guide_app", true) || ((Integer) getParam("Japan_eyeball_tag_guide_app", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isNearbyCarMsgHintEnable() {
        if (!getStatus("global_nearcar_config", true) || ((Integer) getParam("global_nearcar_config", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() == 0) {
            return false;
        }
        return true;
    }

    public static int getNoCarCount() {
        return ((Integer) getParam("global_nearcar_config", "nocar_threshold", 0)).intValue();
    }

    public static int getFewCarCount() {
        return ((Integer) getParam("global_nearcar_config", "fewcar_threshold", 2)).intValue();
    }

    public static boolean isRouteEditorEnable() {
        int intValue = ((Integer) getParam(AB_KEY_ROUTE_EDITOR, "pattern", 0)).intValue();
        return intValue == 1 || intValue == 2;
    }

    public static boolean isShowRouteInEstimate() {
        return ((Integer) getParam("global_bubble_waypoint_route_display", "pattern", 0)).intValue() == 1;
    }

    public static boolean isShowRouteWithoutWayPoint() {
        return ((Integer) getParam("global_bubble_route_display", "pattern", 0)).intValue() == 1;
    }

    public static int getSctxSimulateCarMoveTipsPattern() {
        return ((Integer) getParam("global_simulate_abnormal_toggle_all", "pattern", 0)).intValue();
    }

    public static boolean needMapFlowPhoneCounrtryPrefix() {
        return getStatus("global_map_flow_param_phone_with_prefix_toggle", false);
    }

    public static boolean needMapFlowShowRecommendName() {
        return getStatus("gp_confirm_show_recommend_address_name", false);
    }

    public static boolean getTimePickerToogle() {
        return getStatus("global_time_picker_toggle_v2", false);
    }

    public static int getTimePickerEarilyMinute() {
        return ((Integer) getParam("global_time_picker_toggle_v2", "min_advance_min", 60)).intValue();
    }

    public static int getTimePickerMaxDay() {
        return ((Integer) getParam("global_time_picker_toggle_v2", "max_apoint_day", 3)).intValue();
    }

    public static int getTimePickerStartHour() {
        return ((Integer) getParam("global_time_picker_toggle_v2", "time_hour_span_from", 9)).intValue();
    }

    public static int getTimePickerEndHour() {
        return ((Integer) getParam("global_time_picker_toggle_v2", "time_hour_span_to", 21)).intValue();
    }

    public static boolean isBookOpen4CurrBiz(int i) {
        String[] split = ((String) getParam("GR_DatePicker_CarLevel", "carLevel", "")).split(",");
        if (split == null || split.length <= 0) {
            return true;
        }
        for (String equals : split) {
            if (equals.equals(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInMockLocationWhiteList() {
        return getStatus("global_mock_location_in_release", false);
    }

    public static String getMexServicePhoneNumber() {
        return (String) m7701a("global_customer_serivce_phone_mex", "number", (Object) null);
    }

    public static boolean isTrackCarSlidingEvent() {
        return getStatus("order_car_loc_request_analystics", false);
    }

    public static boolean isBffStageNewFifth() {
        return getStatus("global_bff_passenger_newFifth_period_toggle", false);
    }

    public static boolean isHomeEngine() {
        if (f11379c) {
            f11378b = getStatus("ibt_passenger_home_engine_enable", false);
            f11379c = false;
        }
        return f11378b;
    }

    public static boolean isBff101Repair() {
        return ((Integer) m7702a("error101_Repair_v1", "type", 1, true)).intValue() == 1;
    }

    public static int flutterPassportSwitchStatus() {
        return ((Integer) m7702a("login_sdk_control", "style", 0, false)).intValue();
    }

    public static long getWaitForArrivalNewSctxRequestInterval() {
        int i = 5;
        int intValue = ((Integer) getParam("sctx_passenger_interval_params", "pickup_interval", 5)).intValue();
        if (intValue > 0) {
            i = intValue;
        }
        return (long) (i * 1000);
    }

    public static long getOnServiceNewSctxRequestInterval() {
        int i = 15;
        int intValue = ((Integer) getParam("sctx_passenger_interval_params", "ontrip_interval", 15)).intValue();
        if (intValue > 0) {
            i = intValue;
        }
        return (long) (i * 1000);
    }

    public static boolean isJpnPhoneEntranceEnable() {
        return ((Integer) m7701a("japan_protectphone_rider", "is_hidden", 1)).intValue() == 0;
    }

    public static boolean isCardBindGuideDlgEnable() {
        return ((Integer) m7701a("bubble_page_dig", "group_type", 0)).intValue() == 1;
    }

    public static boolean isSmoothForceHttp() {
        return getStatus("smooth_move_force_http", false);
    }

    public static int getGlobalCarPoolWaitRspCancelDialogFlag() {
        return AppUtils.isGlobalApp(DIDIBaseApplication.getAppContext()) ? ((Integer) m7701a("mx_global_carpool_waitrsp_cancel_dialog_ab", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() : ((Integer) m7701a("global_carpool_waitrsp_cancel_dialog_ab", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue();
    }

    public static Pair<Integer, Integer> getEstimateLoopServiceParams() {
        return new Pair<>(Integer.valueOf(((Integer) m7701a("global_estimate_loop_service", "is_loop", 0)).intValue()), Integer.valueOf(((Integer) m7701a("global_estimate_loop_service", "loop_interval", -1)).intValue()));
    }

    public static Pair<Integer, Integer> getCarPoolOnServiceLoopServiceParams() {
        return new Pair<>(Integer.valueOf(((Integer) m7701a("global_carpool_onservice_loop_service", "is_loop", 0)).intValue()), Integer.valueOf(((Integer) m7701a("global_carpool_onservice_loop_service", "loop_interval", -1)).intValue()));
    }

    public static boolean isGoToHelpCenter() {
        return ((Integer) getParam("show_help_center_driver_card_im_phone_after_trip", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static String getHelpCenterUrl() {
        return (String) getParam("global_help_center_url", "url", "");
    }

    /* renamed from: a */
    private static <T> T m7701a(String str, String str2, T t) {
        return m7702a(str, str2, t, false);
    }

    /* renamed from: a */
    private static <T> T m7702a(String str, String str2, T t, boolean z) {
        if (z) {
            T valueFromCache = ApolloCache.getValueFromCache(str, str2);
            if (valueFromCache != null) {
                return valueFromCache;
            }
            if (getStatus(str)) {
                T param = getParam(str, str2, t);
                ApolloCache.putValueToCache(str, str2, param);
                return param;
            }
            ApolloCache.putValueToCache(str, str2, t);
        } else if (getStatus(str)) {
            return getParam(str, str2, t);
        }
        return t;
    }

    public static boolean getStatus(String str) {
        return getStatus(str, false);
    }

    public static boolean getStatus(String str, boolean z) {
        try {
            IToggle toggle = Apollo.getToggle(str, z);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            GLog.m7967e(e.getMessage());
        }
        return z;
    }

    public static void addToTotalSample(String str) {
        try {
            Apollo.getToggle(str, false);
        } catch (Exception e) {
            GLog.m7967e(e.getMessage());
        }
    }

    public static <T> T getParam(String str, String str2, T t) {
        try {
            return Apollo.getToggle(str).getExperiment().getParam(str2, t);
        } catch (Exception e) {
            GLog.m7967e(e.getMessage());
            return t;
        }
    }

    public static <T> T getAvailableParams(String str, String str2, T t) {
        Preconditions.require(!TextUtils.isEmpty(str), "Require valid toggle-key.");
        Preconditions.require(!TextUtils.isEmpty(str2), "Require valid param-key.");
        try {
            IToggle toggle = Apollo.getToggle(str);
            if (toggle.allow()) {
                IExperiment experiment = toggle.getExperiment();
                if (Preconditions.nonNull(experiment)) {
                    return experiment.getParam(str2, t);
                }
            }
        } catch (Exception e) {
            GLog.m7967e(e.getMessage());
        }
        return t;
    }

    public static boolean getOrderStatusFcmEnable() {
        return getStatus("global_outside_push_order_status_from_apnsfcm");
    }

    public static boolean usingCustomerServiceCardOnCancelOrder() {
        return ((Integer) m7701a("cancelorder-servicecard", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isDriverAllowContact() {
        return ((Integer) m7701a("end_service_page_allow_contect_driver_in_2hours", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static String getBffRequestsAbnormal() {
        return (String) m7701a("global_psg_bff_android_config", "interfaces", "");
    }

    public static int getBffServiceMaximumWaitingTime() {
        return ((Integer) m7701a("global_psg_bff_android_config", "service_maximum_waiting_time", 1000)).intValue();
    }

    public static boolean getBffIsRequestConcurrentForm() {
        return ((Integer) m7701a("global_psg_bff_android_config", "is_open_request_concurrent_form", 0)).intValue() == 1;
    }

    public static boolean isChooseCarByEstimate() {
        return ((Integer) m7701a("New_Estimate_bubble_strategy_ab", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 0;
    }

    public static boolean isRxTrackEnable() {
        return getStatus("rx_event_tracker_enable", false);
    }

    /* renamed from: a */
    private static boolean m7703a() {
        return ((Integer) m7701a("passenger_pre_cancel", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    /* renamed from: b */
    private static boolean m7704b() {
        return ((Integer) m7701a("brazil_passenger_pre_cancel", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    /* renamed from: c */
    private static boolean m7705c() {
        return ((Integer) m7701a("mexico_passenger_pre_cancel", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    /* renamed from: d */
    private static boolean m7706d() {
        return getStatus("passenger_native_cancel_gated", false) || ((Integer) m7701a("passenger_native_cancel_ab", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isHitNewVersionPassengerPreCancel(Context context) {
        if (m7706d()) {
            return true;
        }
        if (OneConfStore.getInstance().getCountryId() == 52) {
            return m7705c();
        }
        return AppUtils.isBrazilApp(context) ? m7704b() : m7703a();
    }

    public static boolean isRiderSafetyToolkitIcon() {
        return ((Integer) m7701a("ab_rider_safety_toolkit_icon_enlarge", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isRiderSafetyToolkitShare() {
        return ((Integer) m7701a("ab_rider_safety_toolkit_share_via_social", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isCompanySelectEnable() {
        return getStatus("global_company_select_toggle", false);
    }

    public static boolean isCompanySelectRealtimeEnable() {
        return getStatus("global_company_select_realtime_toggle", false);
    }

    public static boolean isCompanySelectEnableWithBid(int i) {
        try {
            JSONArray jSONArray = new JSONArray((String) getParam("global_company_select_config", ParamKeys.PARAM_ONE_CONF, ""));
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.optInt(i2) == i) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int howLongCanRecreateOrderAfterCancelled() {
        if (getStatus("global_passager_cancel_trip_reasion_show_alert")) {
            return ((Integer) m7701a("global_passager_cancel_trip_reasion_show_alert", "recreate_time", 0)).intValue();
        }
        return ((Integer) m7701a("ab_global_order_cancel_recreate_order", "recreate_time", 0)).intValue();
    }

    public static boolean canRecreateOrderAfterCancelled() {
        return ((Integer) m7701a("ab_cancel_back_to_estimate", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 0;
    }

    public static boolean canJumpPageByCancelIntercept() {
        return ((Integer) m7701a("cancel_intercept_jump_ab", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 0;
    }

    public static int getUploadFrequencyThreshold() {
        return ((Integer) m7701a("global_tracking_upload_frequency", "threshold", 0)).intValue() * 1000;
    }

    public static int getUploadFrequencyInterval() {
        return ((Integer) m7701a("global_tracking_upload_frequency", "interval", 0)).intValue();
    }

    public static boolean canJumpPageByCancelInterceptAssignment() {
        return canJumpPageByCancelIntercept() && ((Integer) m7701a("cancel_intercept_jump_ab", "reassign_flag", 0)).intValue() == 0;
    }

    public static boolean isUseNewPriceDetail() {
        return ((Integer) m7701a("price_estimate_native", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static String getEventWhiteList() {
        return (String) m7701a("global_pop_event_whitelist", "eventwhitelist", "");
    }

    public static boolean isJpPickupFeeOpen() {
        return getStatus("japan_free_pickup_fee_native", false);
    }

    public static boolean isH5CovertToNative() {
        return ((Integer) m7701a("global_open_feedetail_native", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isSupportServiceCardOnService() {
        return ((Integer) m7701a("selfhelp_card_during_trip", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static int getInterlinkOrderPerceptionGroupNo() {
        return ((Integer) getParam("interlink_order_pax_perception_optm", "group_no", 0)).intValue();
    }

    public static boolean isHasWhatsapp() {
        return ((Integer) m7701a("register_whatsapp_code", "hasWhatsapp", 0)).intValue() == 1;
    }

    public static boolean isExpectationManageEnabled() {
        if (((Integer) getParam("passenger_expectation_manage_three", "useNew", 0)).intValue() == 1 || ((Integer) getParam("passenger_expectation_manage_minor", "useNew", 0)).intValue() == 1 || ((Integer) getParam("passenger_duse_status_global", "useNew", 0)).intValue() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isExpectationManageEnabledRU() {
        return ((Integer) getParam("pax_expectation_management_ru_new", "useNew", 0)).intValue() == 1;
    }

    public static List<Integer> getProductIdsFromExpectationManagement() {
        String str = (String) getParam("global_estimate_waiting_4_response", "product_id", "");
        if (str == null) {
            return new ArrayList();
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("product_id");
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isExpectationManageEnableJP(int r6) {
        /*
            java.lang.String r0 = "passenger_expectation_manage_JP"
            java.lang.String r1 = "one_conf"
            java.lang.String r2 = ""
            java.lang.Object r0 = getParam(r0, r1, r2)
            java.lang.String r0 = (java.lang.String) r0
            r1 = 0
            r2 = 1
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x0027 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x0027 }
            r0 = 0
            r4 = 0
        L_0x0015:
            int r5 = r3.length()     // Catch:{ Exception -> 0x0025 }
            if (r0 >= r5) goto L_0x002c
            int r5 = r3.optInt(r0)     // Catch:{ Exception -> 0x0025 }
            if (r5 != r6) goto L_0x0022
            r4 = 1
        L_0x0022:
            int r0 = r0 + 1
            goto L_0x0015
        L_0x0025:
            r6 = move-exception
            goto L_0x0029
        L_0x0027:
            r6 = move-exception
            r4 = 0
        L_0x0029:
            r6.printStackTrace()
        L_0x002c:
            if (r4 != 0) goto L_0x002f
            return r1
        L_0x002f:
            java.lang.String r6 = "japan_passenger_expection"
            boolean r0 = getStatus(r6)
            if (r0 != 0) goto L_0x0038
            return r2
        L_0x0038:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "group_id"
            java.lang.Object r6 = getParam(r6, r3, r0)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r6 != 0) goto L_0x004b
            return r1
        L_0x004b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.business.util.GlobalApolloUtil.isExpectationManageEnableJP(int):boolean");
    }

    public static boolean use3DCar(Context context) {
        try {
            if (PhoneYearClass.get(context) >= Integer.parseInt((String) m7701a("global_3d_car", "year_level", "2100"))) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isXPanelUseBff() {
        return ((Integer) getParam("global_xpanel_sort_bff", "useBFF", 0)).intValue() == 1;
    }

    public static long getInvitePageTrackNumber() {
        return ((Long) getParam("sidemenu_inviteFriends_pageNum", "pageNum", 20L)).longValue();
    }

    public static boolean isConfirmBroadingViewHasEdit() {
        return ((Integer) m7701a("confirm_start_point_edit", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isNewEvaluate() {
        return ((Integer) getParam("Passenger_Rating_Optimize_Gray", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isNewEstimateDynamic() {
        return ((Integer) m7701a("Modify_destination1", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isNewUpdatePickUp() {
        return ((Integer) getParam("editpickup_copy", "params", 0)).intValue() == 1;
    }

    public static boolean isReportByFireBase() {
        return ((Integer) m7701a("global_firebase_report_toggle", "is_report", 1)).intValue() == 1;
    }

    public static boolean isNewDriverBarJP() {
        return ((Integer) m7701a("passenger_drivercard_JP_copy", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() == 1;
    }

    public static boolean shouldShowSaveAddress() {
        return ((Integer) m7701a("enable_travel_common_address", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isUseNewBubbleJP() {
        return ((Integer) m7701a("Japan_eyeball_pullupframwork", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() == 1;
    }

    public static String getLocationServiceDisabledCP(Context context) {
        return (String) m7702a("global_pax_location_disable_tips", MultiLocaleStore.getInstance().getLocaleCode(), ResourcesHelper.getString(context, R.string.global_location_services_is_disabled), true);
    }

    public static boolean isSendOrderParamsErrorBackup() {
        return getStatus("send_order_params_deficient_backup", false);
    }

    public static boolean shouldHideFareRule(String str) {
        return ((String) m7701a("global_feedetail_farerules_hidden", "hidden_list", "")).contains(str);
    }

    public static int getTripRecordSegment() {
        return ((Integer) m7701a("global_in_trip_recording_config", "audio_segment_duration", 300)).intValue();
    }

    public static int getTripRecordExpired() {
        return ((Integer) m7701a("global_in_trip_recording_config", "audio_expired_duration", 1209600)).intValue();
    }

    public static boolean allowUseRemoteConfig() {
        return ((Integer) m7701a("enable_firebase_remoteconfig_func", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 1)).intValue() == 1;
    }

    public static String getStopServiceConfirmText(Context context) {
        return (String) m7702a("RiderApp_Out_of_service_wordings", MultiLocaleStore.getInstance().getLocaleCode(), ResourcesHelper.getString(context, R.string.global_unenbale_city_stop_service_default), true);
    }

    public static Set<String> getWhiteListDomain(Context context) {
        HashSet hashSet = new HashSet();
        for (String add : ((String) m7702a("GRChangeDomainSuffix", "domain", "{colombia.didiglobal.com/costarica.didiglobal.com/panama.didiglobal.com/argentina.didiglobal.com/mexico.didiglobal.com/russia.didiglobal.com/chile.didiglobal.com/mex.didiglobal.com/newzealand.didiglobal.com/australia.didiglobal.com/peru.didiglobal.com/coronavirus.didiglobal.com/dynamicmodule.didiglobal.com/static.didiglobal.com/img0.didiglobal.com/img0-ru1.didiglobal.com/m.didiglobal.com/latam.didiglobal.com/saiba.didiglobal.com/r.didiglobal.com/costarica.didiglobal.com/darkstore.onelink.me/d-ru.didiglobal.com/manhattan-app.didiglobal.com/q.didiglobal.com/privacycenter.didiglobal.com/gift-de01-cdn.didiglobal.com/ecuador.didiglobal.com/dimina.didiglobal.com/pkg-dimina.didiglobal.com/dimina-pre.intra.didiglobal.com/pkg-dimina-pre.intra.didiglobal.com/s3-us01.didiglobal.com/kaleido.didiglobal.com}", false)).replace(Const.joLeft, "").replace("}", "").split("\\/")) {
            hashSet.add(add);
        }
        return hashSet;
    }

    public static int estimateRefresInterval() {
        int intValue = ((Integer) m7702a("ibt_passenger_estimate_refresh_interval", "interval", 0, true)).intValue();
        if (intValue <= 0) {
            return 0;
        }
        return intValue;
    }

    public static boolean isFontSupport() {
        return ((Integer) m7701a("fontupdate_2022_final", "type", 0)).intValue() == 1;
    }

    public static boolean isFontSupport(String str) {
        String str2 = (String) m7702a("ibt_passenger_custom_font_toggle", "surpport_language", "", true);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str2).optJSONArray("surpport_language");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (str.startsWith(optJSONArray.optString(i))) {
                        return true;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getFontWeight() {
        return (String) m7702a("ibt_passenger_custom_font_toggle", "font_weight_rule", "", true);
    }

    public static boolean isFontH5Support() {
        return getStatus("ibt_passenger_h5_custom_font_toggle");
    }

    public static boolean getFontH5BlackListConfig(String str) {
        String str2 = (String) m7702a("ibt_passenger_h5_custom_font_toggle", "blacklist", "", true);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str2).optJSONArray("blacklist");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        if (str.contains(optJSONArray.optString(i))) {
                            return true;
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static String getFontH5CssConfig() {
        return (String) m7702a("ibt_passenger_h5_custom_font_toggle", "android_css_js_string", "", true);
    }

    public static boolean isFontFlutterSupport() {
        return getStatus("ibt_passenger_flutter_custom_font_toggle");
    }

    public static boolean isDynamicDomainAbAllow() {
        return getStatus("global_passenger_switch_domain", false);
    }

    public static boolean isOpenFareDoubtEntryOnCancelOrder() {
        return ((Integer) m7701a("Fare_Detail_Page_FAQ_list_Entrance_Cancel_0730", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static boolean isOpenFareDoubtEntryOnFinishOrder() {
        return ((Integer) m7701a("Fare_Detail_Page_FAQ_list_Entrance_Complete_0730", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue() == 1;
    }

    public static int maxUploadContactsNum() {
        return ((Integer) getParam("invite_friends_max_contacts_uploadNum", "contactsNum", 0)).intValue();
    }

    public static boolean isNewWaitRspPushContent() {
        return ((Integer) m7701a("native_new_push_msg", "wait_rsp", 0)).intValue() == 1;
    }

    public static boolean isNewEvaluatePushContent() {
        return ((Integer) m7701a("native_new_push_msg", ComponentType.EVALUATE, 0)).intValue() == 1;
    }

    public static boolean isShowCompanyTags() {
        return ((Integer) m7701a("Driver_saftymeasure_japan", FirebaseAnalytics.Param.GROUP_ID, 0)).intValue() == 1;
    }

    public static boolean enableDynamicString() {
        return getStatus("global_passenger_dynamic_string_enable", false);
    }

    public static int getTwoPriceLayoutFlag() {
        return ((Integer) m7701a("DUP_layout_AB_testing_new_0916", CustomerWebActivity.WEB_SINGLE_ACTIVITY_FLAG_KEY, 0)).intValue();
    }

    public static boolean isShowNotify() {
        return getStatus("passenger_pick_recommend_push_toggle");
    }

    public static boolean isGodAllowInitInApplication() {
        return getStatus("global_safety_god_init", true);
    }

    public static int getTrackReportingFrequencyFor(String str) {
        return ((Integer) m7702a("global_track_optimization_ab", str, -1, false)).intValue();
    }

    public static boolean isDDMirrorUiCheckerEnable() {
        return getStatus("ibt_passenger_uicheck_rule_android", false);
    }

    public static String getDDMirrorUiCheckerConfig() {
        return (String) m7702a("ibt_passenger_uicheck_rule_android", BlocksConst.WIDGET_PARAMS_VIEW_RULES, "", false);
    }

    public static boolean isDDMirrorNetCheckEnable() {
        return getStatus("ibt_passenger_netcheck_rule_android", false);
    }

    public static String getDDMirrorNetCheckerConfig() {
        return (String) m7702a("ibt_passenger_netcheck_rule_android", BlocksConst.WIDGET_PARAMS_VIEW_RULES, "", false);
    }

    public static boolean isBffMaptypeParamFix() {
        return ((Integer) m7702a("common_online_bugfix_toggle", "bff_param_maptype", 0, true)).intValue() == 0;
    }

    public static boolean rule1Upload(String str) {
        return isEventContained(str, (String) m7702a("global_omega_upload_rules", "rule1_report_event", "", true));
    }

    public static boolean rule2OrderOnce(String str) {
        return isEventContained(str, (String) m7702a("global_omega_upload_rules", "rule2_order_once", "", false));
    }

    public static boolean rule3LifecycleOnce(String str) {
        return isEventContained(str, (String) m7702a("global_omega_upload_rules", "rule3_lifecycle_once", "", false));
    }

    public static boolean rule4NotReport(String str) {
        return isEventContained(str, (String) m7702a("global_omega_upload_rules", "rule0_not_report_event", "", false));
    }

    public static boolean isEventContained(String str, String str2) {
        String[] split;
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",")) != null && split.length > 0) {
            for (String equals : split) {
                if (str.equals(equals)) {
                    return true;
                }
            }
        }
        return false;
    }
}
