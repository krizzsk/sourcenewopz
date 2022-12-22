package com.didi.component.business.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.component.common.util.GLog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.SPUtils;
import java.util.HashSet;
import java.util.Set;

public class GlobalSPUtil {
    public static final String FILE_NAME = "share_data";

    public static boolean isCardBindGuideShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_cardbind_guide_shown", false)).booleanValue();
    }

    public static void setCarBindGuideShown(Context context, boolean z) {
        m7708a(context, "sp_key_cardbind_guide_shown", Boolean.valueOf(z));
    }

    public static String getNearbyCarInfo(Context context) {
        return (String) m7709b(context, "sp_key_nearby_car_info", "");
    }

    public static void setNearbyCarInfo(Context context, String str) {
        m7708a(context, "sp_key_nearby_car_info", str);
    }

    public static boolean isQuotaDetailGuideShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_quota_detail_guide_shown", false)).booleanValue();
    }

    public static void setQuotaDetailGuideShown(Context context) {
        m7708a(context, "sp_key_quota_detail_guide_shown", true);
    }

    public static boolean isEstimatePullableHintShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_jp_estimate_pull_hint_shown", false)).booleanValue();
    }

    public static void setEstimatePullableHintShown(Context context) {
        m7708a(context, "sp_key_jp_estimate_pull_hint_shown", true);
    }

    public static boolean isOutRecommendDepartureGuideShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_departure_guide_out_recommend_shown", false)).booleanValue();
    }

    public static boolean setOutRecommendDepartureGuideShown(Context context) {
        return m7708a(context, "sp_key_departure_guide_out_recommend_shown", true);
    }

    public static boolean isNoRecommendDepartureGuideShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_departure_guide_no_recommend_shown", false)).booleanValue();
    }

    public static boolean setNoRecommendDepartureGuideShown(Context context) {
        return m7708a(context, "sp_key_departure_guide_no_recommend_shown", true);
    }

    public static boolean isPhoneSecurityDialogShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_phone_security_shown", false)).booleanValue();
    }

    public static boolean setPhoneSecurityDialogShown(Context context) {
        return m7708a(context, "sp_key_phone_security_shown", true);
    }

    public static boolean setNewServiceExpiredDialogShown(Context context) {
        return m7708a(context, "sp_key_new_service_expired_dialog_shown", true);
    }

    public static boolean isNewServiceExpiredDialogShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_new_service_expired_dialog_shown", false)).booleanValue();
    }

    public static boolean setWhereToGoTips(Context context, boolean z) {
        return m7708a(context, "sp_key_is_show_where_tips", Boolean.valueOf(z));
    }

    public static boolean isWhereToGoTipsShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_is_show_where_tips", false)).booleanValue();
    }

    public static boolean setHow2PayTips(Context context, boolean z) {
        return m7708a(context, "sp_key_is_show_how_2_pay_tips", Boolean.valueOf(z));
    }

    public static boolean isShownHow2PayTips(Context context) {
        return ((Boolean) m7709b(context, "sp_key_is_show_how_2_pay_tips", false)).booleanValue();
    }

    public static boolean setRedPacketOid(Context context, String str) {
        return m7708a(context, "sp_key_redpacket_oid", str);
    }

    public static String getRedPacketOid(Context context) {
        return (String) m7709b(context, "sp_key_redpacket_oid", "");
    }

    public static boolean setCarPoolAvailableStatusLastTime(Context context, boolean z) {
        return m7708a(context, "sp_key_car_pool_available_last_time", Boolean.valueOf(z));
    }

    public static boolean getCarPoolAvailableStatusLastTime(Context context) {
        return ((Boolean) m7709b(context, "sp_key_car_pool_available_last_time", false)).booleanValue();
    }

    public static boolean setTimePickerHintFlag(Context context, boolean z) {
        return m7708a(context, "sp_key_time_picker_hint", Boolean.valueOf(z));
    }

    public static boolean getTimePickerHintFlag(Context context, boolean z) {
        return ((Boolean) m7709b(context, "sp_key_time_picker_hint", Boolean.valueOf(z))).booleanValue();
    }

    public static void setNewTimePickerHintFlag(Context context, boolean z) {
        m7708a(context, "sp_key_new_time_picker_hint", Boolean.valueOf(z));
    }

    public static boolean getNewTimePickerHintFlag(Context context, boolean z) {
        return ((Boolean) m7709b(context, "sp_key_new_time_picker_hint", Boolean.valueOf(z))).booleanValue();
    }

    public static boolean setCarTypeHintFlag(Context context, boolean z) {
        return m7708a(context, "sp_key_car_type_hint", Boolean.valueOf(z));
    }

    public static boolean getCarTypeHintFlag(Context context) {
        return ((Boolean) m7709b(context, "sp_key_car_type_hint", true)).booleanValue();
    }

    public static boolean setNeedShowComboTips(Context context, boolean z) {
        return m7708a(context, "sp_key_need_show_combo_tips", Boolean.valueOf(z));
    }

    public static boolean getNeedShowComboTips(Context context) {
        return ((Boolean) m7709b(context, "sp_key_need_show_combo_tips", true)).booleanValue();
    }

    public static boolean setLastCreatedOrderBid(Context context, int i) {
        return m7708a(context, "sp_key_last_created_order_bid", Integer.valueOf(i));
    }

    public static int getLastCreatedOrderBid(Context context) {
        return ((Integer) m7709b(context, "sp_key_last_created_order_bid", -1)).intValue();
    }

    public static boolean setLastCreatedOrderCarLevel(Context context, int i) {
        return m7708a(context, "sp_key_last_created_order_car_level", Integer.valueOf(i));
    }

    public static int getLastCreatedOrderCarLevel(Context context) {
        return ((Integer) m7709b(context, "sp_key_last_created_order_car_level", -1)).intValue();
    }

    public static boolean setLastCreatedOrderDefaultBid(Context context, int i) {
        return m7708a(context, "sp_key_last_created_order_default_bid", Integer.valueOf(i));
    }

    public static int getLastCreatedOrderDefaultBid(Context context) {
        return ((Integer) m7709b(context, "sp_key_last_created_order_default_bid", -1)).intValue();
    }

    public static boolean setLastCreatedOrderDefaultCarLevel(Context context, int i) {
        return m7708a(context, "sp_key_last_created_order_default_car_level", Integer.valueOf(i));
    }

    public static int getLastCreatedOrderDefaultCarLevel(Context context) {
        return ((Integer) m7709b(context, "sp_key_last_created_order_default_car_level", -1)).intValue();
    }

    public static boolean setLastCreatedOrderComboType(Context context, int i) {
        return m7708a(context, "sp_key_last_created_order_car_combotype", Integer.valueOf(i));
    }

    public static int getLastCreatedOrderComboType(Context context) {
        return ((Integer) m7709b(context, "sp_key_last_created_order_car_combotype", 0)).intValue();
    }

    public static boolean setLastCreatedOrderCarpoolOrderScene(Context context, int i) {
        return m7708a(context, "sp_key_last_created_order_carpool_order_secene", Integer.valueOf(i));
    }

    public static int getLastCreatedOrderCarpoolOrderScene(Context context) {
        return ((Integer) m7709b(context, "sp_key_last_created_order_carpool_order_secene", -1)).intValue();
    }

    public static boolean isFirstInstall(Context context) {
        return ((Boolean) m7709b(context, "sp_key_is_first_launch", true)).booleanValue();
    }

    public static boolean setFirstInstall(Context context) {
        return m7708a(context, "sp_key_is_first_launch", false);
    }

    public static boolean isFirstInstalled(Context context) {
        return ((Boolean) m7709b(context, "sp_key_is_first_installed", true)).booleanValue();
    }

    public static boolean setFirstInstalled(Context context) {
        return m7708a(context, "sp_key_is_first_installed", false);
    }

    public static boolean setRegularTaxiGuideHasShow(Context context, boolean z) {
        return m7708a(context, "set_regular_taxi_guide_has_show", Boolean.valueOf(z));
    }

    public static boolean getRegularTaxiGuideHasShow(Context context) {
        return ((Boolean) m7709b(context, "set_regular_taxi_guide_has_show", false)).booleanValue();
    }

    public static boolean setPinOperationTipsHasShow(Context context, boolean z) {
        return m7708a(context, "set_pin_operation_tips_has_show", Boolean.valueOf(z));
    }

    public static boolean getPinOperationTipsHasShow(Context context) {
        return ((Boolean) m7709b(context, "set_pin_operation_tips_has_show", false)).booleanValue();
    }

    public static boolean setLastFaceSessionId(Context context, String str) {
        return m7708a(context, "last_face_session_id_key", str);
    }

    public static String getLastFaceSessionId(Context context) {
        return (String) m7709b(context, "last_face_session_id_key", "");
    }

    public static boolean setLastFacePassed(Context context, boolean z) {
        return m7708a(context, "last_face_passed_key", Boolean.valueOf(z));
    }

    public static boolean getLastFacePassed(Context context) {
        return ((Boolean) m7709b(context, "last_face_passed_key", false)).booleanValue();
    }

    public static void saveLastCreatedOrderCarInfo(Context context, int i, int i2, int i3, int i4, int i5, int i6) {
        setLastCreatedOrderBid(context, i);
        setLastCreatedOrderCarLevel(context, i2);
        setLastCreatedOrderDefaultBid(context, i3);
        setLastCreatedOrderDefaultCarLevel(context, i4);
        setLastCreatedOrderComboType(context, i5);
        setLastCreatedOrderCarpoolOrderScene(context, i6);
    }

    public static int getGooglePlayDialogShowTimes(Context context) {
        return ((Integer) m7709b(context, "googlePlayDialogShowTimes", 0)).intValue();
    }

    public static int getGoodLevelTimes(Context context, int i) {
        return ((Integer) m7709b(context, "goodLevelTimes", Integer.valueOf(i))).intValue();
    }

    public static void setGooglePlayDialogShowTimes(Context context, int i) {
        m7708a(context, "googlePlayDialogShowTimes", Integer.valueOf(i));
    }

    public static void setGoodLevelTimes(Context context, int i) {
        m7708a(context, "goodLevelTimes", Integer.valueOf(i));
    }

    public static void setLocationChangeRequestOnce(Context context, boolean z) {
        m7708a(context, "location_change_request_once", Boolean.valueOf(z));
    }

    public static boolean getLocationChangeRequestOnce(Context context) {
        return ((Boolean) m7709b(context, "location_change_request_once", false)).booleanValue();
    }

    public static boolean isShowedFixedPriceTipsDialog(Context context) {
        return ((Boolean) m7709b(context, "show_fixed_price_tips_dialog", false)).booleanValue();
    }

    public static void setShowedFixedPriceTipsDialog(Context context, boolean z) {
        m7708a(context, "show_fixed_price_tips_dialog", Boolean.valueOf(z));
    }

    public static boolean isShowedDynamicPriceInEstimatePage(Context context) {
        return ((Boolean) m7709b(context, "show_dynamic_price_in_estimate_page", false)).booleanValue();
    }

    public static void setShowedDynamicPriceInEstimatePage(Context context, boolean z) {
        m7708a(context, "show_dynamic_price_in_estimate_page", Boolean.valueOf(z));
    }

    public static String getA3TokenEncrypt(Context context) {
        return (String) m7709b(context, "a3_data_encrypt_new", "");
    }

    public static void setA3TokenEncrypt(Context context, String str) {
        m7708a(context, "a3_data_encrypt_new", str);
    }

    public static boolean getUpdateDestFirst(Context context) {
        return ((Boolean) m7709b(context, "update_dest_is_first", true)).booleanValue();
    }

    public static void setUpdateDestFirst(Context context, boolean z) {
        m7708a(context, "update_dest_is_first", Boolean.valueOf(z));
    }

    public static boolean getUpdateWayPointsFirst(Context context) {
        return ((Boolean) m7709b(context, "update_way_points_is_first", true)).booleanValue();
    }

    public static void setUpdateWayPointsFirst(Context context, boolean z) {
        m7708a(context, "update_way_points_is_first", Boolean.valueOf(z));
    }

    public static boolean isShowRealPriceNewbieGuideByUser(Context context) {
        return ((Boolean) m7709b(context, "sp_key_show_realprice_newbie_guide_" + NationComponentDataUtil.getLoginInfo().getUid(), false)).booleanValue();
    }

    public static boolean setShowRealPriceNewbieGuideByUser(Context context, boolean z) {
        return m7708a(context, "sp_key_show_realprice_newbie_guide_" + NationComponentDataUtil.getLoginInfo().getUid(), Boolean.valueOf(z));
    }

    public static boolean setFixedPriceGuildeShownTimeByUser(Context context, int i) {
        return m7708a(context, "sp_key_show_fixed_price_guide_times", Integer.valueOf(i));
    }

    public static int getFixedPriceGuildeShownTimeByUser(Context context) {
        return ((Integer) m7709b(context, "sp_key_show_fixed_price_guide_times", 0)).intValue();
    }

    public static int getDriverBarIMHintShowTimes(Context context) {
        return ((Integer) m7709b(context, "sp_key_show_driver_bar_im_hint_times_jp", 0)).intValue();
    }

    public static void setDriverBarIMHintShowTimes(Context context, int i) {
        m7708a(context, "sp_key_show_driver_bar_im_hint_times_jp", Integer.valueOf(i));
    }

    public static void setPaywayHintShownTimes(Context context, int i) {
        m7708a(context, "sp_payway_hint_shown_times_new", Integer.valueOf(i));
    }

    public static int getPaywayHintShownTimes(Context context) {
        return ((Integer) m7709b(context, "sp_payway_hint_shown_times_new", 0)).intValue();
    }

    public static void setPhoneHintFlag(Context context, boolean z) {
        m7708a(context, "sp_driver_bar_phone_hint_flag", Boolean.valueOf(z));
    }

    public static boolean getPhoneHintFlag(Context context) {
        return ((Boolean) m7709b(context, "sp_driver_bar_phone_hint_flag", true)).booleanValue();
    }

    public static void setHasNewbeeCoupon(Context context, boolean z) {
        m7708a(context, "sp_has_newbee_coupon", Boolean.valueOf(z));
    }

    public static boolean getHasNewbeeCoupon(Context context) {
        return ((Boolean) m7709b(context, "sp_has_newbee_coupon", false)).booleanValue();
    }

    public static boolean setSFIsReportingPolice(Context context, boolean z) {
        return m7708a(context, "is_reporting_police", Boolean.valueOf(z));
    }

    public static boolean setSFHavePassedOrderRecent(Context context, boolean z) {
        return m7708a(context, "have_passed_order_recent", Boolean.valueOf(z));
    }

    public static boolean setSFHaveRidingOrderSwitch(Context context, boolean z) {
        return m7708a(context, "have_riding_order_switch", Boolean.valueOf(z));
    }

    public static boolean getSFIsReportingPolice(Context context) {
        return ((Boolean) m7709b(context, "is_reporting_police", false)).booleanValue();
    }

    public static boolean getSFHavePassedOrderRecent(Context context) {
        return ((Boolean) m7709b(context, "have_passed_order_recent", false)).booleanValue();
    }

    public static boolean getSFHaveRidingOrderSwitch(Context context) {
        return ((Boolean) m7709b(context, "have_riding_order_switch", false)).booleanValue();
    }

    public static boolean setSFWelcomeBubbleShowTimes(Context context, int i) {
        return m7708a(context, "safety_toolkit_welcome_bubble_show_times", Integer.valueOf(i));
    }

    public static int getSFWelcomeBubbleShowTimes(Context context) {
        return ((Integer) m7709b(context, "safety_toolkit_welcome_bubble_show_times", 0)).intValue();
    }

    public static boolean setSFLeadAddPeopleBubbleShowTimes(Context context, int i) {
        return m7708a(context, "safety_toolkit_lead_add_people_bubble_show_times", Integer.valueOf(i));
    }

    public static int getSFLeadAddPeopleBubbleShowTimes(Context context) {
        return ((Integer) m7709b(context, "safety_toolkit_lead_add_people_bubble_show_times", 0)).intValue();
    }

    public static boolean setOneKeyPublishGuideShowed(Context context) {
        return m7708a(context, "one_key_publish_guide", false);
    }

    public static boolean getIsShowOneKeyPublishGuide(Context context) {
        return ((Boolean) m7709b(context, "one_key_publish_guide", true)).booleanValue();
    }

    public static boolean isUpdatePickUpTipsShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_update_pick_up_tips_shown", false)).booleanValue();
    }

    public static boolean setUpdatePickUpTipsShown(Context context) {
        return m7708a(context, "sp_key_update_pick_up_tips_shown", true);
    }

    public static boolean isTrackCpuBits(Context context) {
        return ((Boolean) m7709b(context, "sp_key_track_cpu_bits", false)).booleanValue();
    }

    public static boolean setTrackCpuBits(Context context) {
        return m7708a(context, "sp_key_track_cpu_bits", true);
    }

    public static boolean isClickedOpenRide(Context context) {
        return ((Boolean) m7709b(context, "sp_key_clicked_open_ride", false)).booleanValue();
    }

    public static boolean setClickedOpenRide(Context context) {
        return m7708a(context, "sp_key_clicked_open_ride", true);
    }

    public static boolean setClickedOpenRideTipCloseTimes(Context context, int i) {
        return m7708a(context, "sp_key_clicked_open_ride_tip_close", Integer.valueOf(i));
    }

    public static int getClickedOpenRideTipCloseTimes(Context context) {
        return ((Integer) m7709b(context, "sp_key_clicked_open_ride_tip_close", 0)).intValue();
    }

    public static boolean isOpenRideAvailable(Context context) {
        return ((Boolean) m7709b(context, "sp_key_open_ride_open", false)).booleanValue();
    }

    public static boolean setOpenRideAvailable(Context context, boolean z) {
        return m7708a(context, "sp_key_open_ride_open", Boolean.valueOf(z));
    }

    public static String getShowNotSupportWayPointDialogOrderId(Context context) {
        return (String) m7709b(context, "sp_key_not_support_way_point_dialog_oid", "");
    }

    public static boolean setShowNotSupportWayPointDialogOrderId(Context context, String str) {
        return m7708a(context, "sp_key_not_support_way_point_dialog_oid", str);
    }

    @Deprecated
    public static boolean isShownCarpoolNewbieGuideDialogByUser(Context context) {
        return ((Boolean) m7709b(context, "sp_key_carpool_newbie_guide_dialog_show_" + NationComponentDataUtil.getLoginInfo().getUid(), false)).booleanValue();
    }

    @Deprecated
    public static boolean setShownCarpoolNewbieGuideDialogByUser(Context context) {
        return m7708a(context, "sp_key_carpool_newbie_guide_dialog_show_" + NationComponentDataUtil.getLoginInfo().getUid(), true);
    }

    @Deprecated
    public static boolean isShownBetterServiceCarNewbieGuideDialogByUser(Context context) {
        return ((Boolean) m7709b(context, "sp_key_better_service_car_newbie_guide_dialog_show_" + NationComponentDataUtil.getLoginInfo().getUid(), false)).booleanValue();
    }

    @Deprecated
    public static boolean setShownBetterServiceCarNewbieGuideDialogByUser(Context context) {
        return m7708a(context, "sp_key_better_service_car_newbie_guide_dialog_show_" + NationComponentDataUtil.getLoginInfo().getUid(), true);
    }

    public static boolean isShownTaxisDispatchFeeDialogByUser(Context context) {
        return ((Boolean) m7709b(context, "sp_key_taxis_dispatch_fee_newbie_guide_dialog_show_", false)).booleanValue();
    }

    public static boolean setShownTaxisDispatchFeeDialogByUser(Context context) {
        return m7708a(context, "sp_key_taxis_dispatch_fee_newbie_guide_dialog_show_", true);
    }

    public static boolean isShowNewGuideDialogFlag(Context context, String str) {
        return ((Boolean) m7709b(context, str, true)).booleanValue();
    }

    public static boolean setShowNewGuideDialogFlag(Context context, String str) {
        return m7708a(context, str, false);
    }

    public static boolean setDynamicConfig(Context context, String str) {
        return m7708a(context, "sp_key_dynamic_config", str);
    }

    public static String getDynamicConfig(Context context) {
        return (String) m7709b(context, "sp_key_dynamic_config", "");
    }

    public static boolean isShowBubblePullGuide(Context context) {
        return ((Integer) m7709b(context, "sp_key_show_bubble_pull_guide", 0)).intValue() <= 3;
    }

    public static void hasShowedBubblePullGuide(Context context) {
        m7708a(context, "sp_key_show_bubble_pull_guide", Integer.valueOf(((Integer) m7709b(context, "sp_key_show_bubble_pull_guide", 0)).intValue() + 1));
    }

    public static void hashShowWayPointDragGuide(Context context) {
        m7708a(context, "sp_key_way_point_drag_guide", false);
    }

    public static boolean isShowWayPointDragGuide(Context context) {
        return ((Boolean) m7709b(context, "sp_key_way_point_drag_guide", true)).booleanValue();
    }

    public static boolean setSplitFaretOid(Context context, String str) {
        return m7708a(context, "sp_split_fare_oid", str);
    }

    public static String getSplitFaretOid(Context context) {
        return (String) m7709b(context, "sp_split_fare_oid", "");
    }

    /* renamed from: a */
    private static boolean m7708a(Context context, String str, Object obj) {
        return SPUtils.put(context, str, obj);
    }

    /* renamed from: b */
    private static <T> T m7709b(Context context, String str, T t) {
        T t2 = SPUtils.get(context, str, t);
        if (t2 != null) {
            return t2;
        }
        GLog.m7968e("GlobalSPUtil", "get(" + str + ") null");
        return t;
    }

    public static Set<String> getStringSet(Context context, String str) {
        return SystemUtils.getSharedPreferences(context, "share_data", 0).getStringSet(str, new HashSet());
    }

    public static void putStringSet(Context context, String str, Set<String> set) {
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(context, "share_data", 0).edit();
        edit.putStringSet(str, set);
        edit.apply();
    }

    public static boolean isFirstOpenInvitePage(Context context) {
        return ((Boolean) m7709b(context, "sp_first_open_invitation", true)).booleanValue();
    }

    public static void setFirstOpenInvitePage(Context context, boolean z) {
        m7708a(context, "sp_first_open_invitation", Boolean.valueOf(z));
    }

    public static void setOnServiceEvaluateOid(Context context, String str) {
        m7708a(context, "sp_on_service_evaluate_oid", str);
    }

    public static String getOnServiceEvaluateOid(Context context) {
        return (String) m7709b(context, "sp_on_service_evaluate_oid", "");
    }

    public static boolean isHasShowTwoPriceTip(Context context) {
        return ((Boolean) m7709b(context, "two_price_estimate_entry_tip", false)).booleanValue();
    }

    public static void setHasShowTwoPriceTip(Context context) {
        m7708a(context, "two_price_estimate_entry_tip", true);
    }

    public static int getCompChooseTipsDisplayCount(Context context) {
        return ((Integer) m7709b(context, "company_choose_tips_display_marker", 0)).intValue();
    }

    public static boolean setCompChooseTipsDisplayCount(Context context, int i) {
        return m7708a(context, "company_choose_tips_display_marker", Integer.valueOf(i));
    }

    public static String get99PayTopupDisplayCond(Context context) {
        return (String) m7709b(context, "sendorder_99pay_topup_intercept_info", "{}");
    }

    public static boolean set99payTopupChoiceOpera(Context context, String str) {
        return m7708a(context, "sendorder_99pay_topup_intercept_info", str);
    }

    public static boolean setNewBubbleHow2PayTips(Context context, boolean z) {
        return m7708a(context, "sp_key_is_new_bubble_show_how_2_pay_tips", Boolean.valueOf(z));
    }

    public static boolean isNewBubbleShownHow2PayTips(Context context) {
        return ((Boolean) m7709b(context, "sp_key_is_new_bubble_show_how_2_pay_tips", false)).booleanValue();
    }

    public static void setNewBubblePaywayHintShownTimes(Context context, int i) {
        m7708a(context, "sp_new_bubble_payway_hint_shown_times_new", Integer.valueOf(i));
    }

    public static int getNewBubblePaywayHintShownTimes(Context context) {
        return ((Integer) m7709b(context, "sp_new_bubble_payway_hint_shown_times_new", 0)).intValue();
    }

    public static boolean isShowChangePaywayBubble(Context context, String str) {
        return !((String) m7709b(context, "sp_new_bubble_change_payway_bubbleId", "")).equals(str);
    }

    public static void setChangePaywayBubbleID(Context context, String str) {
        m7708a(context, "sp_new_bubble_change_payway_bubbleId", str);
    }

    public static boolean getChangePaywayGuideShown(Context context) {
        return !TextUtils.isEmpty((CharSequence) m7709b(context, "sp_new_bubble_change_payway_bubbleId", ""));
    }

    public static boolean setBlueMeetGuideShown(Context context, boolean z) {
        return m7708a(context, "sp_key_is_bluetooth_meet_guide_shown", Boolean.valueOf(z));
    }

    public static boolean isBluetoothMeetGuideShown(Context context) {
        return ((Boolean) m7709b(context, "sp_key_is_bluetooth_meet_guide_shown", false)).booleanValue();
    }

    public static void savePaywayGuideShown(Context context) {
        m7708a(context, "select_payway_guide", true);
    }

    public static boolean isShowPaywayGuide(Context context) {
        return !((Boolean) m7709b(context, "select_payway_guide", false)).booleanValue();
    }
}
