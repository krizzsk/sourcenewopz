package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.component.business.bizconfig.store.BizConfigModel;
import com.didi.component.common.net.CarServerParam;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import com.didi.travel.psnger.store.StoreKey;
import com.facebook.login.LoginLogger;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class CarConfig extends BaseObject {
    public static final String CANCELTIP_OPTION_REMARK_DELIMITER = "|";
    public static final long serialVersionUID = 2302876588969022299L;
    public HashMap<String, ArrayList<CarLevel>> car_level_map;
    public String confirm_action_info;
    public int errno = -1;
    public ArrayList<ExtraInfo> extraInfo;
    public FixedPriceCommunication fixed_price_communication;
    public PassengerEducation passenger_education;
    public PassengerEducationSelect passenger_education_select_aus;
    public PassengerEducationSelect passenger_education_select_br;
    public PassengerSeat passenger_seat;
    public PriceChangeReminder price_change_reminder;
    public ProductIntroduce product_introduce;
    public int version;

    public static class CarLevel implements Serializable {
        public int level_id;
        public int level_type;
    }

    public static class ExtraInfo implements Serializable {
        public ArrayList<String> data;
        public int product;
        public int type;
    }

    public static class FixedPriceCommunication implements Serializable {
        public String button;
        public String content;
        public String image_url;
        public String title;
    }

    public static class PassengerEducation implements Serializable {
        public ArrayList<String> option;
        public String title;
    }

    public static class PassengerEducationSelect implements Serializable {
        public String banner_pic;
        public ArrayList<String> option;
        public String title;
    }

    public static class PassengerSeat implements Serializable {
        public String subtitle;
        public String title;
        public String unmatchSubTitle;
    }

    public static class PriceChangeReminder implements Serializable {
        public String change_pickup;
        public String confirm_no_price;
        public String confirm_price;
        public String failure;
        public String timeout;
    }

    public static class ProductIntroduce implements Serializable {
        public String tips;
        public String url_links;
    }

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.parse(jSONObject);
        boolean z = true;
        if (!jSONObject.has("errno") || jSONObject.optInt("errno") == 0) {
            int optInt = jSONObject.optInt("version");
            this.version = optInt;
            if (optInt == DDTravelConfigStore.getInstance().getCarConfigVersion()) {
                if (jSONObject.has("airport_number_switch") && jSONObject.optInt("airport_number_switch") == 1 && !DDTravelConfigStore.getInstance().getSendFlightNumberOpen()) {
                    DDTravelConfigStore.getInstance().setSendFlightNumberOpen(true);
                } else if (jSONObject.has("airport_number_switch") && jSONObject.optInt("airport_number_switch") == 0 && DDTravelConfigStore.getInstance().getSendFlightNumberOpen()) {
                    DDTravelConfigStore.getInstance().setSendFlightNumberOpen(false);
                }
                String optString = jSONObject.optString("confirm_action_info");
                this.confirm_action_info = optString;
                if (!TextUtils.isEmpty(optString)) {
                    DDTravelConfigStore.getInstance().saveConfirmActionInfo(this.confirm_action_info);
                    return;
                }
                return;
            }
            if (jSONObject.has("cancel_trip_url")) {
                DDTravelConfigStore.getInstance().putString("car_cancel_trip_url", jSONObject.optString("cancel_trip_url"));
            }
            if (jSONObject.has("passenger_cancel_trip_reason_page")) {
                DDTravelConfigStore.getInstance().putString("car_cancel_trip_reason_url", jSONObject.optString("passenger_cancel_trip_reason_page"));
            }
            if (jSONObject.has("cancel_rule_h5_url")) {
                DDTravelConfigStore.getInstance().putString("cancel_rule_h5_url", jSONObject.optString("cancel_rule_h5_url"));
            }
            if (jSONObject.has("fee_doubt_h5")) {
                DDTravelConfigStore.getInstance().putString("car_fee_doubt_h5", jSONObject.optString("fee_doubt_h5"));
            }
            if (jSONObject.has("timing_station_guide_times")) {
                DDTravelConfigStore.getInstance().putInt("timing_station_guide_times", jSONObject.optInt("timing_station_guide_times"));
            }
            if (jSONObject.has("get_station_status_interval")) {
                DDTravelConfigStore.getInstance().putInt("get_station_status_interval", jSONObject.optInt("get_station_status_interval"));
            }
            if (jSONObject.has("timing_station_guide_url")) {
                DDTravelConfigStore.getInstance().putString("timing_station_guide_url", jSONObject.optString("timing_station_guide_url"));
            }
            if (jSONObject.has(StoreKey.Config.KEY_INTERCITY_CARPOOL_GUIDE_URL)) {
                DDTravelConfigStore.getInstance().putString(StoreKey.Config.KEY_INTERCITY_CARPOOL_GUIDE_URL, jSONObject.optString(StoreKey.Config.KEY_INTERCITY_CARPOOL_GUIDE_URL));
            }
            if (jSONObject.has("carpool_route_tips_h5_url")) {
                DDTravelConfigStore.getInstance().putString("carpool_route_tips_h5_url", jSONObject.optString("carpool_route_tips_h5_url"));
            }
            if (jSONObject.has("fee_detail_h5")) {
                DDTravelConfigStore.getInstance().putString("fee_detail_h5", jSONObject.optString("fee_detail_h5"));
            }
            if (jSONObject.has("carpool_confirm_show_num")) {
                DDTravelConfigStore.getInstance().putInt("carpool_confirm_show_num", jSONObject.optInt("carpool_confirm_show_num"));
            }
            if (jSONObject.has(BizConfigModel.KEY_SERVICE_PHONE)) {
                DDTravelConfigStore.getInstance().putString(StoreKey.Config.kEY_SERVICE_PHONE, jSONObject.optString(BizConfigModel.KEY_SERVICE_PHONE));
            }
            if (jSONObject.has("p_order_get_req")) {
                DDTravelConfigStore.getInstance().putInt("p_order_get_req", jSONObject.optInt("p_order_get_req"));
            }
            if (jSONObject.has("carpool_buff")) {
                DDTravelConfigStore.getInstance().putInt(StoreKey.Config.KEY_CARPOOL_BUFFER_TIME, jSONObject.optInt("carpool_buff"));
            }
            if (jSONObject.has("p_complaint_url")) {
                DDTravelConfigStore.getInstance().putString("p_complaint_url", jSONObject.optString("p_complaint_url"));
            }
            if (jSONObject.has("coupon_detail_tips")) {
                DDTravelConfigStore.getInstance().putString("car_coupon_detail_tips", jSONObject.optString("coupon_detail_tips"));
            }
            if (jSONObject.has("estimate_detail_url")) {
                DDTravelConfigStore.getInstance().putString("estimate_price_url", jSONObject.optString("estimate_detail_url"));
            }
            if (jSONObject.has("price_rule_url_v2")) {
                DDTravelConfigStore.getInstance().putString("price_rule_url", jSONObject.optString("price_rule_url_v2"));
            }
            if (jSONObject.has("real_time_fee_detail_url")) {
                DDTravelConfigStore.getInstance().putString("onservice_price_detail_url", jSONObject.optString("real_time_fee_detail_url"));
            }
            if (jSONObject.has("reward_h5")) {
                DDTravelConfigStore.getInstance().putString("reward_h5", jSONObject.optString("reward_h5"));
            }
            if (jSONObject.has("comment_h5_url")) {
                DDTravelConfigStore.getInstance().putString("comment_h5_url", jSONObject.optString("comment_h5_url"));
            }
            if (jSONObject.has("cpf_auth_h5_url")) {
                DDTravelConfigStore.getInstance().putString("cpf_auth_h5_url", jSONObject.optString("cpf_auth_h5_url"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("car_level_map");
            if (optJSONObject2 != null) {
                parseCarLevelMap(optJSONObject2);
            }
            if (jSONObject.has("airport_enter_click_report")) {
                DDTravelConfigStore.getInstance().putBoolean("flight_launch_report", Boolean.valueOf(jSONObject.optInt("airport_enter_click_report") == 1));
            }
            if (jSONObject.has("airport_number_switch")) {
                DDTravelConfigStore.getInstance().putBoolean("send_flightnumber_open", Boolean.valueOf(jSONObject.optInt("airport_number_switch") == 1));
            }
            if (jSONObject.has("callcar_open")) {
                int optInt2 = jSONObject.optInt("callcar_open");
                DDTravelConfigStore instance = DDTravelConfigStore.getInstance();
                if (optInt2 != 1) {
                    z = false;
                }
                instance.putBoolean("otherpassenger_open", Boolean.valueOf(z));
            }
            if (jSONObject.has("airport_recommend_poi_title")) {
                DDTravelConfigStore.getInstance().putString("airport_recommend_poi_title", jSONObject.optString("airport_recommend_poi_title"));
            }
            if (jSONObject.has("airport_recommend_poi_subtitle")) {
                DDTravelConfigStore.getInstance().putString("airport_recommend_poi_subtitle", jSONObject.optString("airport_recommend_poi_subtitle"));
            }
            if (jSONObject.has("comment_haohua_h5_url")) {
                DDTravelConfigStore.getInstance().putString("comment_haohua_h5_url", jSONObject.optString("comment_haohua_h5_url"));
            }
            parseUnitaxiExtraInfo(jSONObject);
            if (jSONObject.has("driver_late_bubble_msg")) {
                DDTravelConfigStore.getInstance().putString("driver_late_bubble_msg", jSONObject.optString("driver_late_bubble_msg"));
            }
            if (jSONObject.has("product_introduce")) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("product_introduce");
                ProductIntroduce productIntroduce = new ProductIntroduce();
                this.product_introduce = productIntroduce;
                productIntroduce.tips = optJSONObject3.optString("tips");
                this.product_introduce.url_links = optJSONObject3.optString("url_links");
            }
            if (jSONObject.has("fixed_price_conf")) {
                parseFixedPriceConf(jSONObject.optJSONObject("fixed_price_conf"));
            }
            if (jSONObject.has("passenger_education")) {
                parseCarPoolPassengerEducation(jSONObject.optJSONObject("passenger_education"));
            }
            if (jSONObject.has("passenger_seat")) {
                parseCarPoolPassengerSeat(jSONObject.optJSONObject("passenger_seat"));
            }
            if (jSONObject.has("passenger_education_select_BR")) {
                PassengerEducationSelect passengerEducationSelect = new PassengerEducationSelect();
                this.passenger_education_select_br = passengerEducationSelect;
                parseBetterServiceCarPassengerEducation(passengerEducationSelect, jSONObject.optJSONObject("passenger_education_select_BR"));
            }
            if (jSONObject.has("passenger_education_select_US")) {
                PassengerEducationSelect passengerEducationSelect2 = new PassengerEducationSelect();
                this.passenger_education_select_aus = passengerEducationSelect2;
                parseBetterServiceCarPassengerEducation(passengerEducationSelect2, jSONObject.optJSONObject("passenger_education_select_US"));
            }
            if (jSONObject.has("police_phone") && (optJSONObject = jSONObject.optJSONObject("police_phone")) != null) {
                DDTravelConfigStore.getInstance().putString("carpool_passenger_police_phone", optJSONObject.toString());
            }
            if (jSONObject.has("confirm_action_info")) {
                jSONObject.optString("confirm_action_info");
            }
            DDTravelConfigStore.getInstance().saveCarConfig(this);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("source", 1);
        GlobalOmegaUtils.trackEvent("tech_gpfile_cache_read", hashMap);
    }

    private void parseCarPoolPassengerSeat(JSONObject jSONObject) {
        if (jSONObject != null) {
            PassengerSeat passengerSeat = new PassengerSeat();
            this.passenger_seat = passengerSeat;
            passengerSeat.title = jSONObject.optString("title");
            this.passenger_seat.subtitle = jSONObject.optString("subtitle");
            this.passenger_seat.unmatchSubTitle = jSONObject.optString("unmatched_subtitle");
        }
    }

    private void parseCarPoolPassengerEducation(JSONObject jSONObject) {
        if (jSONObject != null) {
            PassengerEducation passengerEducation = new PassengerEducation();
            this.passenger_education = passengerEducation;
            passengerEducation.title = jSONObject.optString("title");
            JSONArray optJSONArray = jSONObject.optJSONArray("option");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.passenger_education.option = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.passenger_education.option.add(optJSONArray.optString(i));
                }
            }
        }
    }

    private void parseBetterServiceCarPassengerEducation(PassengerEducationSelect passengerEducationSelect, JSONObject jSONObject) {
        if (jSONObject != null && passengerEducationSelect != null) {
            passengerEducationSelect.title = jSONObject.optString("title");
            passengerEducationSelect.banner_pic = jSONObject.optString("banner_pic");
            JSONArray optJSONArray = jSONObject.optJSONArray("option");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                passengerEducationSelect.option = new ArrayList<>();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    passengerEducationSelect.option.add(optJSONArray.optString(i));
                }
            }
        }
    }

    private ArrayList<CarLevel> parseCarLevel(JSONArray jSONArray) {
        ArrayList<CarLevel> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && optJSONObject.has("level_id")) {
                CarLevel carLevel = new CarLevel();
                carLevel.level_id = optJSONObject.optInt("level_id");
                carLevel.level_type = optJSONObject.optInt("level_type");
                arrayList.add(carLevel);
            }
        }
        return arrayList;
    }

    private void parseCarLevelMap(JSONObject jSONObject) {
        this.car_level_map = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            JSONArray optJSONArray = jSONObject.optJSONArray(next);
            if (optJSONArray != null) {
                this.car_level_map.put(next, parseCarLevel(optJSONArray));
            }
        }
    }

    private void parseUnitaxiExtraInfo(JSONObject jSONObject) {
        if (jSONObject.has("extraInfo")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("extraInfo");
            this.extraInfo = new ArrayList<>();
            for (int i = 0; i < optJSONArray.length(); i++) {
                ExtraInfo extraInfo2 = new ExtraInfo();
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    extraInfo2.type = optJSONObject.optInt("type");
                    extraInfo2.product = optJSONObject.optInt("product");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("data");
                    if (optJSONArray2 != null) {
                        extraInfo2.data = new ArrayList<>();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            extraInfo2.data.add(optJSONArray2.optString(i2));
                        }
                    }
                    this.extraInfo.add(extraInfo2);
                }
            }
        }
    }

    private void parseFixedPriceConf(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.has("price_change_reminder")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("price_change_reminder");
                PriceChangeReminder priceChangeReminder = new PriceChangeReminder();
                this.price_change_reminder = priceChangeReminder;
                priceChangeReminder.timeout = optJSONObject.optString("timeout");
                this.price_change_reminder.change_pickup = optJSONObject.optString("change_pickup");
                this.price_change_reminder.confirm_price = optJSONObject.optString("confirm_price");
                this.price_change_reminder.confirm_no_price = optJSONObject.optString("confirm_no_price");
                this.price_change_reminder.failure = optJSONObject.optString(LoginLogger.EVENT_EXTRAS_FAILURE);
            }
            if (jSONObject.has("fixed_price_communication")) {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("fixed_price_communication");
                FixedPriceCommunication fixedPriceCommunication = new FixedPriceCommunication();
                this.fixed_price_communication = fixedPriceCommunication;
                fixedPriceCommunication.image_url = optJSONObject2.optString(BlocksConst.WIDGET_PARAMS_IMAGE_URL);
                this.fixed_price_communication.title = optJSONObject2.optString("title");
                this.fixed_price_communication.content = optJSONObject2.optString("content");
                this.fixed_price_communication.button = optJSONObject2.optString(CarServerParam.PARAM_BUTTON);
            }
        }
    }

    public static class ConfirmActionInfo implements Serializable {
        public String confirm_action;
        public JSONObject params;
        public String product_id;

        public ConfirmActionInfo(String str, JSONObject jSONObject) {
            this.product_id = str;
            this.confirm_action = jSONObject.optString("confirm_action");
            this.params = jSONObject.optJSONObject("params");
        }

        public boolean validated() {
            return (this.product_id == null || TextUtils.isEmpty(this.confirm_action) || this.params == null) ? false : true;
        }

        public String getActionDeepLink() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.confirm_action);
            sb.append("?");
            Iterator<String> keys = this.params.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    sb.append(next);
                    sb.append("=");
                    sb.append(URLEncoder.encode(this.params.optString(next, ""), "UTF-8"));
                    sb.append(ParamKeys.SIGN_AND);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }
    }
}
