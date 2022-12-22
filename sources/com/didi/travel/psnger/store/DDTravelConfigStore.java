package com.didi.travel.psnger.store;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.AppUtils;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.store.StoreKey;
import com.didi.unifylogin.utils.ApolloSwitch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DDTravelConfigStore {
    public static final String DEFAULT_CPF_H5_URL = "https://page.99taxis.mobi/pay_intl_passenger/cpf_info/cpf_info.html";
    public static final String DEFAULT_CURP_H5_URL = "https://page.didiglobal.com/passenger-page/to-verify/index.html";

    /* renamed from: a */
    private static volatile DDTravelConfigStore f44228a;

    /* renamed from: b */
    private SharedPreferences f44229b;

    /* renamed from: c */
    private SharedPreferences.Editor f44230c;

    private DDTravelConfigStore() {
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static synchronized com.didi.travel.psnger.store.DDTravelConfigStore getInstance() {
        /*
            java.lang.Class<com.didi.travel.psnger.store.DDTravelConfigStore> r0 = com.didi.travel.psnger.store.DDTravelConfigStore.class
            monitor-enter(r0)
            com.didi.travel.psnger.store.DDTravelConfigStore r1 = f44228a     // Catch:{ all -> 0x001c }
            if (r1 != 0) goto L_0x0018
            monitor-enter(r0)     // Catch:{ all -> 0x001c }
            com.didi.travel.psnger.store.DDTravelConfigStore r1 = f44228a     // Catch:{ all -> 0x0015 }
            if (r1 != 0) goto L_0x0013
            com.didi.travel.psnger.store.DDTravelConfigStore r1 = new com.didi.travel.psnger.store.DDTravelConfigStore     // Catch:{ all -> 0x0015 }
            r1.<init>()     // Catch:{ all -> 0x0015 }
            f44228a = r1     // Catch:{ all -> 0x0015 }
        L_0x0013:
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x001c }
        L_0x0018:
            com.didi.travel.psnger.store.DDTravelConfigStore r1 = f44228a     // Catch:{ all -> 0x001c }
            monitor-exit(r0)
            return r1
        L_0x001c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.store.DDTravelConfigStore.getInstance():com.didi.travel.psnger.store.DDTravelConfigStore");
    }

    public void init(Context context) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, StoreKey.Config.KEY_CONFIG_NAME, 0);
        this.f44229b = sharedPreferences;
        this.f44230c = sharedPreferences.edit();
    }

    public void clear(Context context) {
        if (context != null) {
            if (this.f44229b == null) {
                SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, StoreKey.Config.KEY_CONFIG_NAME, 0);
                this.f44229b = sharedPreferences;
                this.f44230c = sharedPreferences.edit();
            }
            SharedPreferences.Editor editor = this.f44230c;
            if (editor != null) {
                editor.clear();
                this.f44230c.commit();
            }
        }
    }

    public void setIntValue(String str, int i) {
        this.f44230c.putInt(str, i);
        this.f44230c.apply();
    }

    public int getIntValue(String str) {
        return this.f44229b.getInt(str, -1);
    }

    public int getIntValue(String str, int i) {
        return this.f44229b.getInt(str, i);
    }

    public void setStringValue(String str, String str2) {
        this.f44230c.putString(str, str2);
        this.f44230c.apply();
    }

    public void putInt(String str, int i) {
        this.f44230c.putInt(str, i);
    }

    public void putString(String str, String str2) {
        this.f44230c.putString(str, str2);
    }

    public void putBoolean(String str, Boolean bool) {
        this.f44230c.putBoolean(str, bool.booleanValue());
    }

    public String getStrValue(String str) {
        return this.f44229b.getString(str, "");
    }

    public String getStrValue(String str, String str2) {
        return this.f44229b.getString(str, str2);
    }

    public void setCarConfigVersion(int i) {
        this.f44230c.putInt("car_config_version_int", i);
        this.f44230c.apply();
    }

    public int getCarConfigVersion() {
        return this.f44229b.getInt("car_config_version_int", 0);
    }

    public void setLastAppVersionName(String str) {
        this.f44230c.putString("car_app_last_version_name", str);
        this.f44230c.apply();
    }

    public String getLastAppVersionName() {
        return this.f44229b.getString("car_app_last_version_name", "");
    }

    public void setCarpoolNewerGuideShowFromAPI(boolean z) {
        this.f44230c.putBoolean("isCarpoolNewerShownFromAPI", z);
        this.f44230c.apply();
    }

    public boolean getCarpoolNewerGuideShowFromAPI() {
        return this.f44229b.getBoolean("isCarpoolNewerShownFromAPI", false);
    }

    public void setCarpoolNewerGuideShow(boolean z) {
        this.f44230c.putBoolean("isCarpoolNewerShown", z);
        this.f44230c.apply();
    }

    public boolean getCarpoolNewerGuideShow() {
        return this.f44229b.getBoolean("isCarpoolNewerShown", false);
    }

    public void setCarPoolLawUrl(String str) {
        this.f44230c.putString("carpool_law_h5_url", str);
        this.f44230c.apply();
    }

    public String getCarPoolLawUrl() {
        return this.f44229b.getString("carpool_law_h5_url", "");
    }

    public void setCarPoolGuideTitle1(String str) {
        this.f44230c.putString("carpool_guide_optimize_title1", str);
        this.f44230c.apply();
    }

    public String getCarPoolGuideTitle1() {
        return this.f44229b.getString("carpool_guide_optimize_title1", "");
    }

    public void setCarPoolGuideTitle2(String str) {
        this.f44230c.putString("carpool_guide_optimize_title2", str);
        this.f44230c.apply();
    }

    public String getCarPoolGuideTitle2() {
        return this.f44229b.getString("carpool_guide_optimize_title2", "");
    }

    public void setCarPoolGuideDescription(String str) {
        this.f44230c.putString("carpool_guide_optimize_description", str);
        this.f44230c.apply();
    }

    public String getCarPoolGuideDescription() {
        return this.f44229b.getString("carpool_guide_optimize_description", "");
    }

    public void setCarPoolGuideImgUrl(String str) {
        this.f44230c.putString("carpool_guide_optimize_imgurl", str);
        this.f44230c.apply();
    }

    public String getCarPoolGuideImgUrl() {
        return this.f44229b.getString("carpool_guide_optimize_imgurl", "");
    }

    public void setCarPoolGuideTips(String str) {
        this.f44230c.putString("carpool_guide_optimize_tips", str);
        this.f44230c.apply();
    }

    public String getCarPoolGuideTips() {
        return this.f44229b.getString("carpool_guide_optimize_tips", "");
    }

    public void setCarPoolGuideButtonStr(String str) {
        this.f44230c.putString("carpool_guide_optimize_btn", str);
        this.f44230c.apply();
    }

    public String getCarPoolGuideButtonStr() {
        return this.f44229b.getString("carpool_guide_optimize_btn", "");
    }

    public void setCancelTripURL(String str) {
        this.f44230c.putString("car_cancel_trip_url", str);
        this.f44230c.apply();
    }

    public String getCancelTripURL() {
        return this.f44229b.getString("car_cancel_trip_url", (String) null);
    }

    public void setMisOperationArea(int i) {
        this.f44230c.putInt("business_db_area", i);
        this.f44230c.apply();
    }

    public int getMisOperationArea() {
        return this.f44229b.getInt("business_db_area", 0);
    }

    public void setMisOperationDBVersion(String str) {
        this.f44230c.putString("business_db_version", str);
        this.f44230c.apply();
    }

    public String getMisOperationDBVersion() {
        return this.f44229b.getString("business_db_version", "0");
    }

    public void setCancelTripReasonURL(String str) {
        this.f44230c.putString("car_cancel_trip_reason_url", str);
        this.f44230c.apply();
    }

    public String getCancelTripReasonURL() {
        return this.f44229b.getString("car_cancel_trip_reason_url", "");
    }

    public void setCancelTripRuleURL(String str) {
        this.f44230c.putString("cancel_rule_h5_url", str);
        this.f44230c.apply();
    }

    public String getCancelTripRuleURL() {
        return this.f44229b.getString("cancel_rule_h5_url", "");
    }

    public void setFeeDoubtURL(String str) {
        this.f44230c.putString("car_fee_doubt_h5", str);
        this.f44230c.apply();
    }

    public String getFeeDoubtURL() {
        return this.f44229b.getString("car_fee_doubt_h5", "");
    }

    public void setOrderStatusIntervalTime(int i) {
        this.f44230c.putInt("p_order_get_req", i);
        this.f44230c.apply();
    }

    public int getOrderStatusIntervalTime() {
        int i = this.f44229b.getInt("p_order_get_req", 5);
        if (i <= 0) {
            return 5;
        }
        return i;
    }

    public void setDynamicPriceConfirmMark(boolean z) {
        this.f44230c.putBoolean("dynamic_price_confirm_mark", z);
        this.f44230c.apply();
    }

    public boolean getDynamicPriceConfirmMark() {
        return this.f44229b.getBoolean("dynamic_price_confirm_mark", false);
    }

    public void remove(String str) {
        this.f44230c.remove(str);
        this.f44230c.apply();
    }

    public SharedPreferences getSharedPreferences() {
        return this.f44229b;
    }

    public void saveAirportCityListVersion(int i) {
        this.f44230c.putInt("city_list_version", i);
        this.f44230c.apply();
    }

    public int getAirportCityListVersion() {
        return this.f44229b.getInt("city_list_version", 0);
    }

    public String getFlightHeaderImage() {
        return this.f44229b.getString("flight_header_image", "");
    }

    public void setOtherPassengerOpen(boolean z) {
        this.f44230c.putBoolean("otherpassenger_open", z);
        this.f44230c.apply();
    }

    public boolean getOtherPassengerOpen() {
        return this.f44229b.getBoolean("otherpassenger_open", false);
    }

    public void setFlightHeaderAirplaneAndColor(String str) {
        this.f44230c.putString("flight_header_airplane", str);
        this.f44230c.apply();
    }

    public String getFlightHeaderAirplaneAndColor() {
        return this.f44229b.getString("flight_header_airplane", "");
    }

    public void setPoolstationTipsCount(int i) {
        this.f44230c.putInt("key_pool_station_tips_count", i);
        this.f44230c.apply();
    }

    public boolean isShowPoolstationTips() {
        return this.f44229b.getInt("key_pool_station_tips_count", 0) <= 0;
    }

    public void setFlightPickupTopic(String str) {
        this.f44230c.putString("flight_topic_pickup_text", str);
        this.f44230c.apply();
    }

    public String getFlightPickupTopic() {
        return this.f44229b.getString("flight_topic_pickup_text", "");
    }

    public void setFlightPickupTopicUrl(String str) {
        this.f44230c.putString("flight_topic_pickup_url", str);
        this.f44230c.apply();
    }

    public String getFlightPickupTopicUrl() {
        return this.f44229b.getString("flight_topic_pickup_url", "");
    }

    public void setFlightSendTopic(String str) {
        this.f44230c.putString("flight_topic_send_text", str);
        this.f44230c.apply();
    }

    public String getFlightSendTopic() {
        return this.f44229b.getString("flight_topic_send_text", "");
    }

    public void setFlightSendTopicUrl(String str) {
        this.f44230c.putString("flight_topic_send_url", str);
        this.f44230c.apply();
    }

    public String getFlightSendTopicUrl() {
        return this.f44229b.getString("flight_topic_send_url", "");
    }

    public void setSendFlightNumberOpen(boolean z) {
        this.f44230c.putBoolean("send_flightnumber_open", z);
        this.f44230c.apply();
    }

    public boolean getSendFlightNumberOpen() {
        return this.f44229b.getBoolean("send_flightnumber_open", false);
    }

    public void setDefaultCityData(String str) {
        this.f44230c.putString("car_flight_default_city_data", str);
        this.f44230c.apply();
    }

    public String getDefaultCityData() {
        return this.f44229b.getString("car_flight_default_city_data", "");
    }

    public void setFlightInsuranceCancelTimes(int i) {
        this.f44230c.putInt("flight_insurance_times", i);
        this.f44230c.apply();
    }

    public int getFlightInsuranceCancelTimes() {
        return this.f44229b.getInt("flight_insurance_times", 0);
    }

    public void setEstimatePriceUrl(String str) {
        this.f44230c.putString("estimate_price_url", str);
        this.f44230c.apply();
    }

    public String getEstimatePriceUrl() {
        return this.f44229b.getString("estimate_price_url", "");
    }

    public void setPriceRuleUrl(String str) {
        this.f44230c.putString("price_rule_url", str);
        this.f44230c.apply();
    }

    public String getPriceRuleUrl() {
        return this.f44229b.getString("price_rule_url", "");
    }

    public String getRedPackageH5() {
        return this.f44229b.getString("reward_h5", "");
    }

    public void setRedPackageH5(String str) {
        this.f44230c.putString("reward_h5", str);
        this.f44230c.apply();
    }

    public void setComplaintUrl(String str) {
        this.f44230c.putString("p_complaint_url", str);
        this.f44230c.apply();
    }

    public String getComplaintUrl() {
        return this.f44229b.getString("p_complaint_url", "");
    }

    public void saveDriverInfoh5url(String str) {
        this.f44230c.putString("comment_h5_url", str);
        this.f44230c.apply();
    }

    public String getDriverInfoh5url() {
        return this.f44229b.getString("comment_h5_url", (String) null);
    }

    public void setFirstclassDriverInfoH5(String str) {
        this.f44230c.putString("comment_haohua_h5_url", str);
        this.f44230c.apply();
    }

    public String getFirstclassDriverInfoH5() {
        return this.f44229b.getString("comment_haohua_h5_url", (String) null);
    }

    public void setCouponDetailTips(String str) {
        this.f44230c.putString("car_coupon_detail_tips", str);
        this.f44230c.apply();
    }

    public String getCouponDetailTips() {
        return this.f44229b.getString("car_coupon_detail_tips", "");
    }

    public void setCarMapLevel(String str, int i) {
        SharedPreferences.Editor editor = this.f44230c;
        editor.putInt("car_level_map_" + str, i);
        this.f44230c.apply();
    }

    public int getCarMapLevel(String str) {
        SharedPreferences sharedPreferences = this.f44229b;
        return sharedPreferences.getInt("car_level_map_" + str, 0);
    }

    public void setFlightLaunchReport(boolean z) {
        this.f44230c.putBoolean("flight_launch_report", z);
        this.f44230c.apply();
    }

    public boolean getFlightLaunchReport() {
        return this.f44229b.getBoolean("flight_launch_report", false);
    }

    public void setSeatNotifyNeedShown(boolean z) {
        this.f44230c.putBoolean("flier_seat_change_nofity_show", z);
        this.f44230c.apply();
    }

    public boolean isSeatNotifyNeedShown() {
        return this.f44229b.getBoolean("flier_seat_change_nofity_show", false);
    }

    public void setSeatChangeOrderId(String str) {
        this.f44230c.putString("flier_seat_change_orid", str);
        this.f44230c.apply();
    }

    public String getSeatChangeOrderId() {
        return this.f44229b.getString("flier_seat_change_orid", "");
    }

    public void setSeatChangeNum(int i) {
        this.f44230c.putInt("flier_seat_change_num", i);
        this.f44230c.apply();
    }

    public int getSeatChangeNum() {
        return this.f44229b.getInt("flier_seat_change_num", 0);
    }

    public void setSeatPrice(String str) {
        this.f44230c.putString("flier_seat_change_price", str);
        this.f44230c.apply();
    }

    public String getSeatPrice() {
        return this.f44229b.getString("flier_seat_change_price", "");
    }

    public void resetChangeSeatData() {
        setSeatChangeNum(0);
        setSeatPrice("");
        setSeatNotifyNeedShown(false);
    }

    public void setIDFA(String str) {
        this.f44230c.putString("idfa_data_brazil", str);
        this.f44230c.apply();
    }

    public String getIDFA() {
        return this.f44229b.getString("idfa_data_brazil", "");
    }

    public void setWillwaitTipShowed() {
        this.f44230c.putBoolean("will_wait_tip_showed", true);
        this.f44230c.apply();
    }

    public boolean isWillwaitTipShowed() {
        return this.f44229b.getBoolean("will_wait_tip_showed", false);
    }

    public void setStationTipsShowed() {
        this.f44230c.putBoolean("timer_pool_station_tips_showed", true);
        this.f44230c.apply();
    }

    public boolean isStationTipsShowed() {
        return this.f44229b.getBoolean("timer_pool_station_tips_showed", false);
    }

    public void setFirstTipFlag(boolean z) {
        this.f44230c.putBoolean("set_first_tip_flag", true);
        this.f44230c.apply();
    }

    public boolean getFirstTipFlag() {
        return this.f44229b.getBoolean("set_first_tip_flag", false);
    }

    public void setTimingStationGuideTimes(int i) {
        this.f44230c.putInt("timing_station_guide_times", i);
        this.f44230c.apply();
    }

    public int getTimingStationGuideTimes() {
        return this.f44229b.getInt("timing_station_guide_times", 3);
    }

    public void setStationStatusInterval(int i) {
        this.f44230c.putInt("get_station_status_interval", i);
        this.f44230c.apply();
    }

    public int getStationStatusInterval() {
        return this.f44229b.getInt("get_station_status_interval", 30);
    }

    public void setTimingStationWebGuideCount(int i) {
        this.f44230c.putInt("timing_station_guide_count", i);
        this.f44230c.apply();
    }

    public int getTimingStationWebGuideCount() {
        return this.f44229b.getInt("timing_station_guide_count", 0);
    }

    public void setTimingStationGuideURL(String str) {
        this.f44230c.putString("timing_station_guide_url", str);
        this.f44230c.apply();
    }

    public String getTimingStationGuideURL() {
        return this.f44229b.getString("timing_station_guide_url", "");
    }

    public void setCarpoolRouteTipURL(String str) {
        this.f44230c.putString("carpool_route_tips_h5_url", str);
        this.f44230c.apply();
    }

    public String getCarpoolRouteTipURL() {
        return this.f44229b.getString("carpool_route_tips_h5_url", "");
    }

    public void setFeeDetailURL(String str) {
        this.f44230c.putString("fee_detail_h5", str);
        this.f44230c.apply();
    }

    public String getFeeDetailURL() {
        return this.f44229b.getString("fee_detail_h5", "");
    }

    public void setCarpoolConfirmShowNum(int i) {
        this.f44230c.putInt("carpool_confirm_show_num", i);
        this.f44230c.apply();
    }

    public int getCarpoolConfirmShowNum() {
        return this.f44229b.getInt("carpool_confirm_show_num", 1);
    }

    public void setCarpoolConfirmShowCount() {
        this.f44230c.putInt("carpool_confirm_show_count", getCarpoolConfirmShowCount() + 1);
        this.f44230c.apply();
    }

    public int getCarpoolConfirmShowCount() {
        return this.f44229b.getInt("carpool_confirm_show_count", 0);
    }

    public void setAirportRecommendTitle(String str) {
        this.f44230c.putString("airport_recommend_poi_title", str);
        this.f44230c.apply();
    }

    public String getAirportRecommendTitle() {
        return this.f44229b.getString("airport_recommend_poi_title", "");
    }

    public void setAirportRecommendSubTitle(String str) {
        this.f44230c.putString("airport_recommend_poi_subtitle", str);
        this.f44230c.apply();
    }

    public String getAirportRecommendSubTitle() {
        return this.f44229b.getString("airport_recommend_poi_subtitle", "");
    }

    @Deprecated
    public void setVoiceTipsShow() {
        this.f44230c.putBoolean("voice_tips_show", true);
        this.f44230c.apply();
    }

    @Deprecated
    public boolean isVoiceTipsShow() {
        return this.f44229b.getBoolean("voice_tips_show", false);
    }

    public void setUniTaxiExtraInfo(int i, String str) {
        SharedPreferences.Editor editor = this.f44230c;
        editor.putString("unitaxi_extra_info" + i, str);
        this.f44230c.apply();
    }

    public void setUniTaxiExtraInfo(int i, int i2, String str) {
        SharedPreferences.Editor editor = this.f44230c;
        editor.putString(i + "unitaxi_extra_info" + i2, str);
        this.f44230c.apply();
    }

    public String[] getUniTaxiExtraInfo(int i, int i2) {
        SharedPreferences sharedPreferences = this.f44229b;
        String string = sharedPreferences.getString(i + "unitaxi_extra_info" + i2, "");
        if (TextUtils.isEmpty(string) && i == 307) {
            SharedPreferences sharedPreferences2 = this.f44229b;
            string = sharedPreferences2.getString("unitaxi_extra_info" + i2, "");
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split(",");
    }

    public String[] getUniTaxiExtraInfo(int i) {
        SharedPreferences sharedPreferences = this.f44229b;
        String string = sharedPreferences.getString("unitaxi_extra_info" + i, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split(",");
    }

    public void setAirportFormTips(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            this.f44230c.putString(str, (String) null);
            this.f44230c.apply();
            return;
        }
        String str2 = "";
        for (int i = 0; i < strArr.length; i++) {
            str2 = str2 + ";" + strArr[i];
        }
        if (str2.length() > 1) {
            str2 = str2.substring(1);
        }
        this.f44230c.putString(str, str2);
        this.f44230c.apply();
    }

    public String[] getAirportFormTips(String str) {
        String string = this.f44229b.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string.split(";");
    }

    public int getBookingSuccessTipDialogTime() {
        return this.f44229b.getInt("booking_success_tip_dialog_time", 0);
    }

    public void setBookingSuccessTipDialogTime(int i) {
        this.f44230c.putInt("booking_success_tip_dialog_time", i);
        this.f44230c.apply();
    }

    public boolean isShowFirstClassHomeH5() {
        return this.f44229b.getBoolean("firstclass_home_h5_showed", false);
    }

    public void setShowFirstClassHomeH5() {
        this.f44230c.putBoolean("firstclass_home_h5_showed", true);
        this.f44230c.apply();
    }

    public void setLockScreenDistance(String str) {
        this.f44230c.putString("lock_screen_distance", str);
        this.f44230c.apply();
    }

    public void setLockScreenTime(String str) {
        this.f44230c.putString("lock_screen_minute", str);
        this.f44230c.apply();
    }

    public String getLockScreenDistance() {
        return this.f44229b.getString("lock_screen_distance", "--");
    }

    public String getLockScreenTime() {
        return this.f44229b.getString("lock_screen_minute", "--");
    }

    public void clearLockScreenData() {
        this.f44230c.remove("lock_screen_distance");
        this.f44230c.remove("lock_screen_minute");
        this.f44230c.apply();
    }

    public String getFlierPoolStationDriverLateInfoWindowMsg() {
        return this.f44229b.getString("driver_late_bubble_msg", "");
    }

    public void setFlierPoolStationDriverLateInfoWindowMsg(String str) {
        this.f44229b.edit().putString("driver_late_bubble_msg", str).apply();
    }

    public void setProductIntroduceTips(String str) {
        this.f44230c.putString("produce_introduce_tips", str);
        this.f44230c.apply();
    }

    public String getProductIntroduceTips() {
        return this.f44229b.getString("produce_introduce_tips", "");
    }

    public void setProductIntroduceUrl(String str) {
        this.f44230c.putString("produce_introduce_url", str);
        this.f44230c.apply();
    }

    public String getProductIntroduceUrl() {
        return this.f44229b.getString("produce_introduce_url", "");
    }

    public void setOnServicePriceDetailUrl(String str) {
        this.f44230c.putString("onservice_price_detail_url", str);
        this.f44230c.apply();
    }

    public String getOnServicePriceDetailUrl() {
        return this.f44229b.getString("onservice_price_detail_url", "");
    }

    public void setCpfAuthH5Url(String str) {
        this.f44230c.putString("cpf_auth_h5_url", str);
        this.f44230c.apply();
    }

    public String getCpfAuthH5Url() {
        return this.f44229b.getString("cpf_auth_h5_url", "");
    }

    public String getCpfAuthH5UrlWithSource(int i) {
        String string = this.f44229b.getString("cpf_auth_h5_url", "");
        return string + "?CPFClientFromType=" + i;
    }

    public String getCpfAuthH5UrlWithSourceAdded(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("&token=");
        sb.append(str);
        sb.append("&loginSDKUIVersion=");
        sb.append(ApolloSwitch.getInstance().isLoginSDKUIV2(AppUtils.isGlobalApp(DIDIApplication.getAppContext())) ? 2 : 1);
        String sb2 = sb.toString();
        if (str == null) {
            sb2 = "";
        }
        if (AppUtils.isGlobalApp(DIDIApplication.getAppContext())) {
            return "https://page.didiglobal.com/passenger-page/to-verify/index.html?CPFClientFromType=" + i + sb2;
        }
        String cpfAuthH5Url = TextUtils.isEmpty(getCpfAuthH5Url()) ? DEFAULT_CPF_H5_URL : getCpfAuthH5Url();
        return cpfAuthH5Url + "?CPFClientFromType=" + i + sb2;
    }

    public String getAuthH5UrlWithSourceAdded(int i, String str) {
        return str + "?CPFClientFromType=" + i;
    }

    public String getCpfAuthH5UrlWithSourceAddedRg(int i, String str, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("&token=");
        sb.append(str);
        sb.append("&loginSDKUIVersion=");
        sb.append(ApolloSwitch.getInstance().isLoginSDKUIV2(AppUtils.isGlobalApp(DIDIApplication.getAppContext())) ? 2 : 1);
        String sb2 = sb.toString();
        if (str == null) {
            sb2 = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        return str3 + "?CPFClientFromType=" + i + sb2 + "&keeperId=" + str2 + "&distinguish=" + i2;
    }

    public String getCpfAuthH5UrlWithSourceAdded(int i) {
        return getCpfAuthH5UrlWithSourceAdded(i, (String) null);
    }

    public String getCpfAuthH5UrlWithSourceAddedRg(int i, String str, int i2, String str2) {
        return getCpfAuthH5UrlWithSourceAddedRg(i, (String) null, str, i2, str2);
    }

    public void setPriceChangeReminderTimeout(String str) {
        this.f44230c.putString("price_change_reminder_timeout", str);
        this.f44230c.apply();
    }

    public String getPriceChangeReminderTimeout(String str) {
        return this.f44229b.getString("price_change_reminder_timeout", str);
    }

    public void setPriceChangeReminderChangePickup(String str) {
        this.f44230c.putString("price_change_reminder_change_pickup", str);
        this.f44230c.apply();
    }

    public String getPriceChangeReminderChangePickup(String str) {
        return this.f44229b.getString("price_change_reminder_change_pickup", str);
    }

    public void setPriceChangeReminderConfirmPrice(String str) {
        this.f44230c.putString("price_change_reminder_confirm_price", str);
        this.f44230c.apply();
    }

    public String getPriceChangeReminderConfirmPrice(String str) {
        return this.f44229b.getString("price_change_reminder_confirm_price", str);
    }

    public void setPriceChangeReminderConfirmNoPrice(String str) {
        this.f44230c.putString("price_change_reminder_confirm_no_price", str);
        this.f44230c.apply();
    }

    public String getPriceChangeReminderConfirmNoPrice(String str) {
        return this.f44229b.getString("price_change_reminder_confirm_no_price", str);
    }

    public void setPriceChangeReminderConfirmFailure(String str) {
        this.f44230c.putString("price_change_reminder_confirm_failure", str);
        this.f44230c.apply();
    }

    public String getPriceChangeReminderConfirmFailure(String str) {
        return this.f44229b.getString("price_change_reminder_confirm_failure", str);
    }

    public void setFixedPriceCommunicationImageUrl(String str) {
        this.f44230c.putString("fixed_price_communication_image_url", str);
        this.f44230c.apply();
    }

    public String getFixedPriceCommunicationImageUrl(String str) {
        return this.f44229b.getString("fixed_price_communication_image_url", str);
    }

    public void setFixedPriceCommunicationTitle(String str) {
        this.f44230c.putString("fixed_price_communication_title", str);
        this.f44230c.apply();
    }

    public String getFixedPriceCommunicationTitle(String str) {
        return this.f44229b.getString("fixed_price_communication_title", str);
    }

    public void setFixedPriceCommunicationContent(String str) {
        this.f44230c.putString("fixed_price_communication_content", str);
        this.f44230c.apply();
    }

    public String getFixedPriceCommunicationContent(String str) {
        return this.f44229b.getString("fixed_price_communication_content", str);
    }

    public void setFixedPriceCommunicationButton(String str) {
        this.f44230c.putString("fixed_price_communication_button", str);
        this.f44230c.apply();
    }

    public String getFixedPriceCommunicationButton(String str) {
        return this.f44229b.getString("fixed_price_communication_button", str);
    }

    public String getCarpoolPassengerSeatTitle(String str) {
        return this.f44229b.getString("carpool_passenger_seat_title", str);
    }

    public String getCarpoolPassengerSeatSubTitle(String str) {
        return this.f44229b.getString("carpool_passenger_seat_subtitle", str);
    }

    public String getCarpoolPassengerSeatUnmatchSubTitle(String str) {
        return this.f44229b.getString("carpool_passenger_seat_unmatch_subtitle", str);
    }

    public String getCarpoolPassengerEducationTitle(String str) {
        return this.f44229b.getString("carpool_passenger_education_title", str);
    }

    public JSONObject getPolicePhone(JSONObject jSONObject) {
        String string = this.f44229b.getString("carpool_passenger_police_phone", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public List<String> getCarpoolPassengerEducationOptions(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f44229b.getString("carpool_passenger_education_options", str));
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public String getBetterServiceCarPassengerEducationTitleBR(String str) {
        return this.f44229b.getString("better_service_car_passenger_education_title_br", str);
    }

    public String getBetterServiceCarPassengerEducationTitleAUS(String str) {
        return this.f44229b.getString("better_service_car_passenger_education_title_aus", str);
    }

    public List<String> getBetterServiceCarPassengerEducationOptionsBR(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f44229b.getString("better_service_car_passenger_education_options_br", str));
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public List<String> getBetterServiceCarPassengerEducationOptionsAUS(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.f44229b.getString("better_service_car_passenger_education_options_aus", str));
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.optString(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public String getBetterServiceCarPassengerEducationBannerPicBR() {
        return this.f44229b.getString("better_service_car_passenger_education_banner_pic_br", "");
    }

    public String getBetterServiceCarPassengerEducationBannerPicAUS() {
        return this.f44229b.getString("better_service_car_passenger_education_banner_pic_aus", "");
    }

    public void saveCarConfig(CarConfig carConfig) {
        int i;
        if (carConfig.car_level_map != null && !carConfig.car_level_map.isEmpty()) {
            for (Map.Entry next : carConfig.car_level_map.entrySet()) {
                if (next != null) {
                    ArrayList arrayList = (ArrayList) next.getValue();
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        i = 0;
                        while (it.hasNext()) {
                            CarConfig.CarLevel carLevel = (CarConfig.CarLevel) it.next();
                            if (carLevel != null) {
                                putInt("car_level_" + carLevel.level_id, carLevel.level_type);
                                i |= carLevel.level_type;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    putInt("car_level_map_" + ((String) next.getKey()), i);
                }
            }
        }
        if (carConfig.product_introduce != null) {
            putString("produce_introduce_tips", carConfig.product_introduce.tips);
            putString("produce_introduce_url", carConfig.product_introduce.url_links);
        }
        if (carConfig.price_change_reminder != null) {
            putString("price_change_reminder_timeout", carConfig.price_change_reminder.timeout);
            putString("price_change_reminder_change_pickup", carConfig.price_change_reminder.change_pickup);
            putString("price_change_reminder_confirm_price", carConfig.price_change_reminder.confirm_price);
            putString("price_change_reminder_confirm_no_price", carConfig.price_change_reminder.confirm_no_price);
            putString("price_change_reminder_confirm_failure", carConfig.price_change_reminder.failure);
        }
        if (carConfig.product_introduce != null) {
            putString("fixed_price_communication_image_url", carConfig.fixed_price_communication.image_url);
            putString("fixed_price_communication_title", carConfig.fixed_price_communication.title);
            putString("fixed_price_communication_content", carConfig.fixed_price_communication.content);
            putString("fixed_price_communication_button", carConfig.fixed_price_communication.button);
        }
        if (carConfig.passenger_education != null) {
            putString("carpool_passenger_education_title", carConfig.passenger_education.title);
            if (carConfig.passenger_education.option != null) {
                putString("carpool_passenger_education_options", new JSONArray(carConfig.passenger_education.option).toString());
            }
        }
        if (carConfig.passenger_seat != null) {
            putString("carpool_passenger_seat_title", carConfig.passenger_seat.title);
            putString("carpool_passenger_seat_subtitle", carConfig.passenger_seat.subtitle);
            putString("carpool_passenger_seat_unmatch_subtitle", carConfig.passenger_seat.unmatchSubTitle);
        }
        if (carConfig.extraInfo != null && !carConfig.extraInfo.isEmpty()) {
            Iterator<CarConfig.ExtraInfo> it2 = carConfig.extraInfo.iterator();
            while (it2.hasNext()) {
                CarConfig.ExtraInfo next2 = it2.next();
                if (next2 != null) {
                    StringBuilder sb = new StringBuilder("");
                    if (next2.data != null && !next2.data.isEmpty()) {
                        int size = next2.data.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            String str = next2.data.get(i2);
                            if (!TextUtils.isEmpty(str)) {
                                sb.append(str);
                                if (i2 != size - 1) {
                                    sb.append(",");
                                }
                            }
                        }
                    }
                    putString(next2.product + "unitaxi_extra_info" + next2.type, sb.toString());
                }
            }
        }
        if (carConfig.passenger_education_select_br != null) {
            putString("better_service_car_passenger_education_title_br", carConfig.passenger_education_select_br.title);
            putString("better_service_car_passenger_education_banner_pic_br", carConfig.passenger_education_select_br.banner_pic);
            if (carConfig.passenger_education_select_br.option != null) {
                putString("better_service_car_passenger_education_options_br", new JSONArray(carConfig.passenger_education_select_br.option).toString());
            }
        }
        if (carConfig.passenger_education_select_aus != null) {
            putString("better_service_car_passenger_education_title_aus", carConfig.passenger_education_select_aus.title);
            putString("better_service_car_passenger_education_banner_pic_aus", carConfig.passenger_education_select_aus.banner_pic);
            if (carConfig.passenger_education_select_aus.option != null) {
                putString("better_service_car_passenger_education_options_aus", new JSONArray(carConfig.passenger_education_select_aus.option).toString());
            }
        }
        putInt("car_config_version_int", carConfig.version);
        this.f44230c.apply();
    }

    public CarConfig.ConfirmActionInfo getConfirmActionInfo(String str) {
        String strValue = getStrValue("confirm_action_info");
        if (TextUtils.isEmpty(strValue)) {
            return null;
        }
        try {
            JSONObject optJSONObject = new JSONObject(strValue).optJSONObject(str);
            if (optJSONObject != null) {
                return new CarConfig.ConfirmActionInfo(str, optJSONObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveConfirmActionInfo(String str) {
        putString("confirm_action_info", str);
        this.f44230c.apply();
    }
}
