package com.didi.travel.psnger.core.model.response;

import android.text.TextUtils;
import com.didi.component.business.bizconfig.store.BizConfigModel;
import com.didi.global.fintech.cashier.threeds.cvv.GlobalCashierCVVActivity;
import com.didi.payment.base.cons.PayParam;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.didi.travel.psnger.model.response.BookingAssignInfo;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarPayShare;
import com.didi.travel.psnger.model.response.CarPostOrderModel;
import com.didi.travel.psnger.model.response.CarUnderServiceBannerTopInfo;
import com.didi.travel.psnger.model.response.CharteredComboInfo;
import com.didi.travel.psnger.model.response.DTSDKOpActivityInfo;
import com.didi.travel.psnger.model.response.DepartureAddressesAbout;
import com.didi.travel.psnger.model.response.DonateInfo;
import com.didi.travel.psnger.model.response.FlierPoolStationModel;
import com.didi.travel.psnger.model.response.NextPayResult;
import com.didi.travel.psnger.model.response.OrderDetailUpdateDest;
import com.didi.travel.psnger.model.response.OrderDetailUpdateWayPoint;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.travel.psnger.utils.TextUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DTSDKOrderDetail extends BaseObject {
    public static final int ORDER_COMBO_TYPE_BAOCHE = 1;
    public static final int ORDER_COMBO_TYPE_DIRECT_TRAIN = 308;
    public static final int ORDER_COMBO_TYPE_FLIGHT_DROP = 3;
    public static final int ORDER_COMBO_TYPE_FLIGHT_PICK = 2;
    public static final int ORDER_COMBO_TYPE_KUACHENG_POOL = 302;
    public static final int ORDER_COMBO_TYPE_NORMAL = 0;
    public static final int ORDER_COMBO_TYPE_POOL = 4;
    public static final int ORDER_COMBO_TYPE_REGION_PRICE = 303;
    public static final int ORDER_PAY_TYPE_ALI = 30;
    public static final int ORDER_PAY_TYPE_ALI_DRIVER_CANCEL = 1;
    public static final int ORDER_PAY_TYPE_CMB = 60;
    public static final int ORDER_PAY_TYPE_ENTER_BALANCE = 21;
    public static final int ORDER_PAY_TYPE_ENTER_NO_CLAIM = 24;
    public static final int ORDER_PAY_TYPE_ENTER_PERSON = 22;
    public static final int ORDER_PAY_TYPE_ENTER_PERSON_CLAIM = 23;
    public static final int ORDER_PAY_TYPE_MIS_PAY = 40;
    public static final int ORDER_PAY_TYPE_PERSON = 20;
    public static final int ORDER_PAY_TYPE_SYSTEM_PAY = 41;
    public static final int ORDER_PAY_TYPE_WX = 10;
    public DTSDKAirportPanelData dtsdkAirportPanel;
    public DTSDKBasicData dtsdkBasicData;
    public DTSDKBizConfig dtsdkBizConfig;
    public DTSDKEntryData dtsdkEntryData;
    public DTSDKMapData dtsdkMapData;
    public DTSDKPushInfo dtsdkPushInfo;
    public DTSDKSceneData dtsdkSceneData;
    public List<String> pollMsg;
    public DTSDKStriveInfo striveInfo;
    public String toastData;

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject.optInt("code", 0) != 0) {
                this.errno = optJSONObject.optInt("code");
                this.errmsg = optJSONObject.optString("msg");
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("scene_data");
            DTSDKSceneData dTSDKSceneData = new DTSDKSceneData();
            this.dtsdkSceneData = dTSDKSceneData;
            if (optJSONObject2 != null) {
                dTSDKSceneData.parse(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("basic_data");
            DTSDKBasicData dTSDKBasicData = new DTSDKBasicData();
            this.dtsdkBasicData = dTSDKBasicData;
            if (optJSONObject3 != null) {
                dTSDKBasicData.parse(optJSONObject3);
            }
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("entry_data");
            DTSDKEntryData dTSDKEntryData = new DTSDKEntryData();
            this.dtsdkEntryData = dTSDKEntryData;
            if (optJSONObject4 != null) {
                dTSDKEntryData.parse(optJSONObject4);
            }
            JSONObject optJSONObject5 = optJSONObject.optJSONObject("push_info");
            DTSDKPushInfo dTSDKPushInfo = new DTSDKPushInfo();
            this.dtsdkPushInfo = dTSDKPushInfo;
            if (optJSONObject5 != null) {
                dTSDKPushInfo.parse(optJSONObject5);
            }
            JSONObject optJSONObject6 = optJSONObject.optJSONObject("strive_info");
            if (optJSONObject6 != null) {
                DTSDKStriveInfo dTSDKStriveInfo = new DTSDKStriveInfo();
                this.striveInfo = dTSDKStriveInfo;
                dTSDKStriveInfo.parse(optJSONObject6);
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("poll_info");
            if (optJSONArray != null) {
                this.pollMsg = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.pollMsg.add(optJSONArray.optString(i));
                }
            }
            JSONObject optJSONObject7 = optJSONObject.optJSONObject("airport_panel_data");
            if (optJSONObject7 != null) {
                DTSDKAirportPanelData dTSDKAirportPanelData = new DTSDKAirportPanelData();
                this.dtsdkAirportPanel = dTSDKAirportPanelData;
                dTSDKAirportPanelData.parse(optJSONObject7);
            }
            JSONObject optJSONObject8 = optJSONObject.optJSONObject("biz_config");
            if (optJSONObject8 != null) {
                DTSDKBizConfig dTSDKBizConfig = new DTSDKBizConfig();
                this.dtsdkBizConfig = dTSDKBizConfig;
                dTSDKBizConfig.parse(optJSONObject8);
            }
            JSONObject optJSONObject9 = optJSONObject.optJSONObject("ibt_map_data");
            if (optJSONObject9 != null) {
                DTSDKMapData dTSDKMapData = new DTSDKMapData();
                this.dtsdkMapData = dTSDKMapData;
                dTSDKMapData.parse(optJSONObject9);
            }
            this.toastData = optJSONObject.optString("toast_data");
        }
    }

    public static class DTSDKSceneData extends BaseObject {
        public CharteredComboInfo comboData;
        public DonateInfo donateInfo;
        public FlierPoolStationModel flierPoolStationModel;
        public boolean isCarpoolCommute;
        public Object[] timeArray;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                boolean z = true;
                if (jSONObject.optInt("is_carpool_commute") != 1) {
                    z = false;
                }
                this.isCarpoolCommute = z;
                JSONObject optJSONObject = jSONObject.optJSONObject("carpool_station_info");
                if (optJSONObject != null) {
                    FlierPoolStationModel flierPoolStationModel2 = new FlierPoolStationModel();
                    this.flierPoolStationModel = flierPoolStationModel2;
                    flierPoolStationModel2.parse(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject(ParamKeys.RENTED_INFO);
                if (optJSONObject2 != null) {
                    CharteredComboInfo charteredComboInfo = new CharteredComboInfo();
                    this.comboData = charteredComboInfo;
                    charteredComboInfo.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("donate_info");
                if (optJSONObject3 != null) {
                    DonateInfo donateInfo2 = new DonateInfo();
                    this.donateInfo = donateInfo2;
                    donateInfo2.parse(optJSONObject3);
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(ParamKeys.PARAM_REGIONAL_DEPARTURE_TIME);
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    this.timeArray = new Object[length];
                    for (int i = 0; i <= length; i++) {
                        Object opt = optJSONArray.opt(i);
                        if (opt != null) {
                            this.timeArray[i] = opt.toString();
                            SystemUtils.log(6, "lhm", "[index]=" + i + ", data=" + this.timeArray[i], (Throwable) null, "com.didi.travel.psnger.core.model.response.DTSDKOrderDetail$DTSDKSceneData", 239);
                        }
                    }
                }
            }
        }
    }

    public static class DTSDKBasicData extends BaseObject {
        public DTSDKBasicOrderData basicOrderData;
        public DTSDKCancelInfo cancelInfo;
        public DTSDKCarModel carModel;
        public CardInfo cardInfo;
        public DTSDKCompanyTags companyTags;
        public CouponInfo couponInfo;
        public DTSDKDriverModel driverModel;
        public ExpensiveCompensationInfo expensiveCompensationInfo;
        public DTSDKLabelInfo labelInfo;
        public InvoiceInfo mInvoiceInfo;
        public DTSDKOpActivityInfo opActivityInfo;
        public NextPayResult payResult;
        public DTSDKSplitFareInfo splitFareInfo;
        public DTSDKUpgradeModel upgradeModel;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("order_info");
                DTSDKBasicOrderData dTSDKBasicOrderData = new DTSDKBasicOrderData();
                this.basicOrderData = dTSDKBasicOrderData;
                if (optJSONObject != null) {
                    dTSDKBasicOrderData.parse(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("driver_info");
                if (optJSONObject2 != null) {
                    DTSDKDriverModel dTSDKDriverModel = new DTSDKDriverModel();
                    this.driverModel = dTSDKDriverModel;
                    dTSDKDriverModel.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("upgrade_data");
                if (optJSONObject3 != null) {
                    DTSDKUpgradeModel dTSDKUpgradeModel = new DTSDKUpgradeModel();
                    this.upgradeModel = dTSDKUpgradeModel;
                    dTSDKUpgradeModel.parse(optJSONObject3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("car_info");
                if (optJSONObject4 != null) {
                    DTSDKCarModel dTSDKCarModel = new DTSDKCarModel();
                    this.carModel = dTSDKCarModel;
                    dTSDKCarModel.parse(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("label_info");
                if (optJSONObject5 != null) {
                    DTSDKLabelInfo dTSDKLabelInfo = new DTSDKLabelInfo();
                    this.labelInfo = dTSDKLabelInfo;
                    dTSDKLabelInfo.parse(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("pay_result");
                if (optJSONObject6 != null) {
                    NextPayResult nextPayResult = new NextPayResult();
                    this.payResult = nextPayResult;
                    nextPayResult.isPay = optJSONObject6.optInt("pay_status");
                    this.payResult.total_fee = String.valueOf(optJSONObject6.optDouble("total_fee"));
                    this.payResult.actual_pay_money = String.valueOf(optJSONObject6.optDouble("actual_pay_money"));
                    this.payResult.actual_deduction = String.valueOf(optJSONObject6.optDouble("coupon_fee"));
                    this.payResult.total_fee_display = optJSONObject6.optString("total_fee_display_string");
                    this.payResult.actual_pay_money_display = optJSONObject6.optString("actual_pay_money_display_string");
                    this.payResult.actual_deduction_display = optJSONObject6.optString("coupon_fee_display_string");
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("notice_info");
                if (optJSONObject7 != null) {
                    CouponInfo couponInfo2 = new CouponInfo();
                    this.couponInfo = couponInfo2;
                    couponInfo2.parse(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject(GlobalCashierCVVActivity.ARGS_CARD_INFO);
                if (optJSONObject8 != null) {
                    CardInfo cardInfo2 = new CardInfo();
                    this.cardInfo = cardInfo2;
                    cardInfo2.parse(optJSONObject8);
                }
                JSONObject optJSONObject9 = jSONObject.optJSONObject("cancel_info");
                if (optJSONObject9 != null) {
                    DTSDKCancelInfo dTSDKCancelInfo = new DTSDKCancelInfo();
                    this.cancelInfo = dTSDKCancelInfo;
                    dTSDKCancelInfo.parse(optJSONObject9);
                }
                if (jSONObject.has("split_fare_info")) {
                    DTSDKSplitFareInfo dTSDKSplitFareInfo = new DTSDKSplitFareInfo();
                    this.splitFareInfo = dTSDKSplitFareInfo;
                    dTSDKSplitFareInfo.parse(jSONObject.optJSONObject("split_fare_info"));
                }
                if (jSONObject.has("panel_tips")) {
                    DTSDKOpActivityInfo dTSDKOpActivityInfo = new DTSDKOpActivityInfo();
                    this.opActivityInfo = dTSDKOpActivityInfo;
                    dTSDKOpActivityInfo.parse(jSONObject.optJSONObject("panel_tips"));
                }
                JSONObject optJSONObject10 = jSONObject.optJSONObject("invoice_info");
                if (optJSONObject10 != null) {
                    InvoiceInfo invoiceInfo = new InvoiceInfo();
                    this.mInvoiceInfo = invoiceInfo;
                    invoiceInfo.parse(optJSONObject10);
                }
                JSONObject optJSONObject11 = jSONObject.optJSONObject("company_tags");
                if (optJSONObject11 != null) {
                    DTSDKCompanyTags dTSDKCompanyTags = new DTSDKCompanyTags();
                    this.companyTags = dTSDKCompanyTags;
                    dTSDKCompanyTags.parse(optJSONObject11);
                }
                JSONObject optJSONObject12 = jSONObject.optJSONObject("expensive_compensation_info");
                if (optJSONObject12 != null) {
                    ExpensiveCompensationInfo expensiveCompensationInfo2 = new ExpensiveCompensationInfo();
                    this.expensiveCompensationInfo = expensiveCompensationInfo2;
                    expensiveCompensationInfo2.parse(optJSONObject12);
                }
            }
        }
    }

    public static class ExpensiveCompensationInfo extends BaseObject {
        public String expensiveCompensationStatus;
        public String h5Url;
        public int isShadow;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.isShadow = jSONObject.optInt("isShadow");
                this.h5Url = jSONObject.optString("h5_url");
                this.expensiveCompensationStatus = jSONObject.optString("expensive_compensation_status");
            }
        }
    }

    public static class InvoiceInfo extends BaseObject {
        public String invoicePageUrl;
        public int showButton;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.showButton = jSONObject.optInt("show_button");
                this.invoicePageUrl = jSONObject.optString("url");
            }
        }
    }

    public static class CouponInfo extends BaseObject {
        public String couponText;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.couponText = jSONObject.optString("text");
            }
        }
    }

    public static class CardInfo extends BaseObject {
        public int isShowRealTimePrice;
        public String msg;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.msg = jSONObject.optString("msg");
                this.isShowRealTimePrice = jSONObject.optInt("is_show_realtime_price", 0);
            }
        }
    }

    public static class DTSDKBasicOrderData extends BaseObject {
        public long arriveTime;
        public long assignedTime;
        public int businessId;
        public String capPrice;
        public String capPriceDisplay;
        public CarCancelTrip carCancelTrip;
        public String carPoolOrderScene;
        public int carpoolStatus;
        public int comboType;
        public int consultTime;
        public int countPriceType;
        public long createTime;
        public DTSDKCurrency currency;
        public DepartureAddressesAbout departureAddressesAbout;
        public long departureTime;
        public String disTrict = "";
        public long driverEndPriceTime;
        public Address endAddress;
        public int enterpriseFlag;
        public int feeObjection;
        public long holdTime = -1;
        public int imBusinessId;
        public boolean isCallCar;
        public int isCapPrice;
        public boolean isPoolStation = false;
        public int isSerialOrder;
        public boolean isTimeout = false;
        public String lastOrderId;
        public Address locationAddress;
        public String mapType;
        public String newOid;
        public String oid;
        public int orderType;
        public PaymentsWayInfo payInfo;
        public int payType;
        public String requireLevel;
        public Address startAddress;
        public long startChargeTime;
        public String stationGuideName;
        public String stationWalkGuideLink;
        public int status;
        public int subStatus = 0;
        public String timeOutMsg = "";
        public String tip;
        public String travelid;
        public String tripCountry;
        public long waitTime;
        public String walkGuidePhoto;
        public String wayPoints;
        public String wayPointsVersion;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.businessId = jSONObject.optInt("business_id");
                this.imBusinessId = jSONObject.optInt("im_business_id");
                this.newOid = jSONObject.optString("new_order_id");
                this.oid = jSONObject.optString("order_id");
                this.travelid = jSONObject.optString("travel_id");
                this.disTrict = jSONObject.optString(ParamKeys.PARAM_DISTRICT);
                this.stationGuideName = jSONObject.optString("station_guide_name");
                this.stationWalkGuideLink = jSONObject.optString("station_walk_guide_link");
                this.walkGuidePhoto = jSONObject.optString("walk_guide_photo");
                Address address = new Address();
                this.startAddress = address;
                address.setLatitude(NumberUtil.strToDouble(jSONObject.optString("from_lat")).doubleValue());
                this.startAddress.setLongitude(NumberUtil.strToDouble(jSONObject.optString("from_lng")).doubleValue());
                String optString = jSONObject.optString("from_name");
                String optString2 = jSONObject.optString("from_address");
                if (!TextUtil.isEmpty(optString)) {
                    this.startAddress.setDisplayName(optString);
                } else {
                    this.startAddress.setDisplayName(optString2);
                }
                this.startAddress.setAddress(optString2);
                this.startAddress.setName(optString2);
                this.startAddress.setCityId(jSONObject.optInt(ParamKeys.PARAM_FROM_AREA));
                this.startAddress.setCityName(jSONObject.optString(PayParam.CITY_NAME).replace("市", ""));
                this.startAddress.setUid(jSONObject.optString("from_poi_id"));
                Address address2 = new Address();
                this.endAddress = address2;
                address2.setLatitude(NumberUtil.strToDouble(jSONObject.optString("to_lat")).doubleValue());
                this.endAddress.setLongitude(NumberUtil.strToDouble(jSONObject.optString("to_lng")).doubleValue());
                this.endAddress.setCityId(jSONObject.optInt(ParamKeys.PARAM_TO_AREA));
                this.endAddress.setUid(jSONObject.optString(ParamKeys.PARAM_TO_POI_UID));
                String optString3 = jSONObject.optString("to_name");
                String optString4 = jSONObject.optString("to_address");
                if (!TextUtil.isEmpty(optString3)) {
                    this.endAddress.setDisplayName(optString3);
                } else {
                    this.endAddress.setDisplayName(optString4);
                }
                this.endAddress.setAddress(optString4);
                this.endAddress.setName(optString4);
                this.endAddress.setUid(jSONObject.optString(ParamKeys.PARAM_TO_POI_UID));
                Address address3 = new Address();
                this.locationAddress = address3;
                address3.setLatitude(NumberUtil.strToDouble(jSONObject.optString("lat")).doubleValue());
                this.locationAddress.setLongitude(NumberUtil.strToDouble(jSONObject.optString("lng")).doubleValue());
                this.requireLevel = jSONObject.optString("require_level");
                this.status = jSONObject.optInt("status");
                this.subStatus = jSONObject.optInt(ParamKeys.PARAM_SUB_STATUS);
                this.carpoolStatus = jSONObject.optInt("carpool_status");
                this.tip = jSONObject.optString("tip");
                this.orderType = jSONObject.optInt("order_type");
                this.departureTime = jSONObject.optLong("departure_time") * 1000;
                this.createTime = jSONObject.optLong("create_time") * 1000;
                this.startChargeTime = jSONObject.optLong("begin_charge_time") * 1000;
                this.driverEndPriceTime = jSONObject.optLong("finish_time") * 1000;
                this.arriveTime = jSONObject.optLong("arrive_time") * 1000;
                this.consultTime = jSONObject.optInt("consult_time");
                this.assignedTime = jSONObject.optLong("assigned_time") * 1000;
                this.comboType = jSONObject.optInt("combo_type");
                boolean z = true;
                this.isPoolStation = jSONObject.optInt("is_station_carpool", 0) == 1;
                this.payType = jSONObject.optInt(ParamKeys.PARAM_PAYMENTS_TYPE);
                JSONObject optJSONObject = jSONObject.optJSONObject("payments_text");
                PaymentsWayInfo paymentsWayInfo = new PaymentsWayInfo();
                this.payInfo = paymentsWayInfo;
                if (optJSONObject != null) {
                    paymentsWayInfo.parse(optJSONObject);
                }
                CarCancelTrip carCancelTrip2 = new CarCancelTrip();
                this.carCancelTrip = carCancelTrip2;
                carCancelTrip2.showTitle = jSONObject.optString(ParamKeys.PARAM_CANCEL_REASON);
                DepartureAddressesAbout departureAddressesAbout2 = new DepartureAddressesAbout();
                this.departureAddressesAbout = departureAddressesAbout2;
                departureAddressesAbout2.fsourceTag = jSONObject.optInt("from_tag");
                this.departureAddressesAbout.chooseFSrctag = jSONObject.optString("choose_from_tag");
                this.waitTime = jSONObject.optLong(ParamConst.PARAM_WAIT_TIME) * 1000;
                this.holdTime = jSONObject.optLong("hold_time") * 1000;
                this.isTimeout = jSONObject.optInt("is_timeout") == 1;
                this.timeOutMsg = jSONObject.optString("timeout_msg");
                if (jSONObject.optInt("call_car", 0) != 1) {
                    z = false;
                }
                this.isCallCar = z;
                this.isSerialOrder = jSONObject.optInt("is_serial_order", 0);
                this.lastOrderId = jSONObject.optString("last_order_id", "");
                this.mapType = jSONObject.optString("map_type", "");
                this.tripCountry = jSONObject.optString("country_iso_code", "");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("currency");
                if (optJSONObject2 != null) {
                    DTSDKCurrency dTSDKCurrency = new DTSDKCurrency();
                    this.currency = dTSDKCurrency;
                    dTSDKCurrency.parse(optJSONObject2);
                }
                this.isCapPrice = jSONObject.optInt("is_cap_price", 0);
                this.capPrice = jSONObject.optString("cap_price");
                this.capPriceDisplay = jSONObject.optString("cap_price_display_string");
                this.wayPoints = jSONObject.optString(ParamKeys.PARAM_WAY_POINTS);
                this.wayPointsVersion = jSONObject.optString(ParamKeys.PARAM_WAY_POINTS_VERSION);
                this.feeObjection = jSONObject.optInt("fee_objection");
                this.countPriceType = jSONObject.optInt(com.didi.global.globalgenerickit.net.ParamKeys.PARAM_COUNT_PRICE_TYPE, 0);
                this.enterpriseFlag = jSONObject.optInt(ParamKeys.PARAM_ENTERPRISE_FLAG);
                this.carPoolOrderScene = jSONObject.optString("carpool_order_scene");
            }
        }

        public String getLastOrderId() {
            if (this.isSerialOrder == 1) {
                return this.lastOrderId;
            }
            return null;
        }
    }

    public static class PaymentsWayInfo extends BaseObject {
        public boolean isOnlinePay;
        public String suffix;
        public String text;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.text = jSONObject.optString("card_text");
                String optString = jSONObject.optString("card_suffix");
                this.suffix = optString;
                boolean z = true;
                if (!TextUtils.isEmpty(optString)) {
                    Matcher matcher = Pattern.compile("^.*?(\\d{4})$").matcher(this.suffix);
                    if (matcher.find()) {
                        this.suffix = matcher.group(1);
                    }
                }
                if (jSONObject.optInt("is_online_pay") != 1) {
                    z = false;
                }
                this.isOnlinePay = z;
            }
        }
    }

    public static class DTSDKEntryData extends BaseObject {
        public BookingAssignInfo bookAssignInfo;
        public long buttonControl;
        public DTSDKEvaluateModel carEvaluateModel;
        public boolean isDetailPriceClosed;
        public DTSDKPostOrderRecInfo postOrderRecInfo;
        public CarPayShare share;
        public boolean showQuestion;
        public boolean showTips;
        public boolean showUpdatePickUpPop;
        public boolean showWalletFloat;
        public UnevaluatedViewModel unevaluatedViewModel;
        public OrderDetailUpdateDest updateDestModel;
        public OrderDetailUpdateWayPoint updateWayPoint;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("booking_assign_info");
                if (optJSONObject != null) {
                    BookingAssignInfo bookingAssignInfo = new BookingAssignInfo();
                    this.bookAssignInfo = bookingAssignInfo;
                    bookingAssignInfo.parse(optJSONObject);
                }
                boolean z = false;
                this.showQuestion = jSONObject.optInt("question_show") == 1;
                this.buttonControl = jSONObject.optLong("button_control");
                this.showTips = jSONObject.optInt("is_display_tips") == 1;
                this.showUpdatePickUpPop = jSONObject.optInt("is_pickup_change") == 1;
                this.isDetailPriceClosed = jSONObject.optInt("close_detail_price") == 1;
                if (jSONObject.optInt("is_display_wallet_float") == 1) {
                    z = true;
                }
                this.showWalletFloat = z;
                JSONObject optJSONObject2 = jSONObject.optJSONObject("share_info");
                if (optJSONObject2 != null) {
                    CarPayShare carPayShare = new CarPayShare();
                    this.share = carPayShare;
                    carPayShare.parse(optJSONObject2);
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("comment");
                if (optJSONObject3 != null) {
                    DTSDKEvaluateModel dTSDKEvaluateModel = new DTSDKEvaluateModel();
                    this.carEvaluateModel = dTSDKEvaluateModel;
                    dTSDKEvaluateModel.parse(optJSONObject3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("post_order_rec_info");
                if (optJSONObject4 != null) {
                    DTSDKPostOrderRecInfo dTSDKPostOrderRecInfo = new DTSDKPostOrderRecInfo();
                    this.postOrderRecInfo = dTSDKPostOrderRecInfo;
                    dTSDKPostOrderRecInfo.parse(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("update_destination_info");
                if (optJSONObject5 != null) {
                    OrderDetailUpdateDest orderDetailUpdateDest = new OrderDetailUpdateDest();
                    this.updateDestModel = orderDetailUpdateDest;
                    orderDetailUpdateDest.parse(optJSONObject5);
                }
                JSONObject optJSONObject6 = jSONObject.optJSONObject("update_waypoint_info");
                if (optJSONObject6 != null) {
                    OrderDetailUpdateWayPoint orderDetailUpdateWayPoint = new OrderDetailUpdateWayPoint();
                    this.updateWayPoint = orderDetailUpdateWayPoint;
                    orderDetailUpdateWayPoint.parse(optJSONObject6);
                }
                UnevaluatedViewModel unevaluatedViewModel2 = new UnevaluatedViewModel();
                this.unevaluatedViewModel = unevaluatedViewModel2;
                unevaluatedViewModel2.parse(jSONObject);
            }
        }
    }

    public static class DTSDKPostOrderRecInfo extends BaseObject {
        public CarPostOrderModel carPostOrderModel;
        public int isPostOrderRec;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.isPostOrderRec = jSONObject.optInt("is_post_order_rec");
                JSONObject optJSONObject = jSONObject.optJSONObject("post_order_rec");
                if (optJSONObject != null) {
                    CarPostOrderModel carPostOrderModel2 = new CarPostOrderModel();
                    this.carPostOrderModel = carPostOrderModel2;
                    carPostOrderModel2.parse(optJSONObject);
                }
            }
        }
    }

    public static class DTSDKPushInfo extends BaseObject {
        public static final int TAG_DRIVER_ARRIVED_EARLY = 1;
        public CarUnderServiceBannerTopInfo bannerTopInfo;
        public String extraIntensifyBackground;
        public int extraIntensifyIsClose;
        public int extraIntensifyType;
        public String extraIntensifyUrl;
        public String impSubTitle;
        public String impTitle;
        public int isArrivedEarly;
        public int isServiceControl;
        public int is_parking_violation;
        public String notifyArrivedImmediately;
        public String notifyLateMsg;
        public String notifyTips = "";
        public String parking_violation_icon;
        public String passengerDutyContent;
        public long passengerDutyTime;
        public long passengerLateTime;
        public String pushArrivedImmediately;
        public String pushTips = "";
        public String pushTipsBubble;
        public String pushTipsPassengerLate;
        public String pushTipsPassengerLateBubble;
        public int serviceControlWaitTime;
        public String shareUrl;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.impTitle = jSONObject.optString("title");
                this.impSubTitle = jSONObject.optString(BlocksConst.WIDGET_PARAMS_TYPE_SUB_TITLE);
                this.pushTipsBubble = jSONObject.optString("bubble_msg");
                this.isServiceControl = jSONObject.optInt("is_service_control");
                this.serviceControlWaitTime = jSONObject.optInt("passenger_late_time");
                try {
                    this.passengerLateTime = Long.valueOf(jSONObject.optString("passenger_late_time_point")).longValue() * 1000;
                } catch (NumberFormatException unused) {
                }
                this.pushTipsPassengerLate = jSONObject.optString("late_msg");
                this.pushTipsPassengerLateBubble = jSONObject.optString("late_bubble_msg");
                this.isArrivedEarly = jSONObject.optInt("not_arrived_right_pos");
                this.pushTips = jSONObject.optString("msg");
                this.passengerDutyTime = (long) jSONObject.optInt("passenger_duty_time");
                this.passengerDutyContent = jSONObject.optString("passenger_duty_content");
                this.shareUrl = jSONObject.optString("share_url");
                if (jSONObject.optJSONObject("tips_top") != null) {
                    CarUnderServiceBannerTopInfo carUnderServiceBannerTopInfo = new CarUnderServiceBannerTopInfo();
                    this.bannerTopInfo = carUnderServiceBannerTopInfo;
                    carUnderServiceBannerTopInfo.parse(jSONObject.optJSONObject("tips_top"));
                }
                this.notifyTips = jSONObject.optString("push_msg");
                this.pushArrivedImmediately = jSONObject.optString("msg_arrived_immediately");
                this.notifyArrivedImmediately = jSONObject.optString("push_arrived_immediately");
                this.notifyLateMsg = jSONObject.optString("push_msg_late");
                this.extraIntensifyUrl = jSONObject.optString("extra_intensify_url");
                this.extraIntensifyBackground = jSONObject.optString("extra_intensify_background");
                this.extraIntensifyType = jSONObject.optInt("extra_intensify_type");
                this.extraIntensifyIsClose = jSONObject.optInt("extra_intensify_is_close");
                this.parking_violation_icon = jSONObject.optString("parking_violation_icon");
                this.is_parking_violation = jSONObject.optInt("is_parking_violation", 0);
            }
        }

        public JSONObject buildOnRecommonMsg(JSONObject jSONObject, DTSDKPushInfo dTSDKPushInfo) {
            try {
                jSONObject.put("bubble_msg", dTSDKPushInfo.pushTipsBubble);
                jSONObject.put("is_service_control", dTSDKPushInfo.isServiceControl);
                jSONObject.put("passenger_late_time", dTSDKPushInfo.serviceControlWaitTime);
                jSONObject.put("late_msg", dTSDKPushInfo.pushTipsPassengerLate);
                jSONObject.put("late_bubble_msg", dTSDKPushInfo.pushTipsPassengerLateBubble);
                jSONObject.put("not_arrived_right_pos", dTSDKPushInfo.isArrivedEarly);
                jSONObject.put("msg", dTSDKPushInfo.pushTips);
                jSONObject.put("push_msg", dTSDKPushInfo.notifyTips);
                jSONObject.put("msg_arrived_immediately", dTSDKPushInfo.pushArrivedImmediately);
                jSONObject.put("push_arrived_immediately", dTSDKPushInfo.notifyArrivedImmediately);
                jSONObject.put("push_msg_late", dTSDKPushInfo.notifyLateMsg);
                jSONObject.put("extra_intensify_url", dTSDKPushInfo.extraIntensifyUrl);
                jSONObject.put("extra_intensify_background", dTSDKPushInfo.extraIntensifyBackground);
                jSONObject.put("extra_intensify_type", dTSDKPushInfo.extraIntensifyType);
                jSONObject.put("extra_intensify_is_close", dTSDKPushInfo.extraIntensifyIsClose);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static class DTSDKBizConfig extends BaseObject {
        public String service_phone;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.service_phone = jSONObject.optString(BizConfigModel.KEY_SERVICE_PHONE);
            }
        }
    }

    public static class DTSDKMapData extends BaseObject {
        public DTSDKMapRequestData requestData;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                DTSDKMapRequestData dTSDKMapRequestData = new DTSDKMapRequestData();
                this.requestData = dTSDKMapRequestData;
                dTSDKMapRequestData.parse(jSONObject);
            }
        }
    }

    public static class DTSDKMapRequestData extends BaseObject {
        public boolean isShowRealPicInXpanel;
        public boolean showInterceptView;
        public String specialPoiParkingProperty;
        public String stationGuideName;
        public String stationWalkGuideLink;
        public String walkGuidePhoto;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.specialPoiParkingProperty = jSONObject.optString("specialPoiParkingProperty");
                this.showInterceptView = jSONObject.optBoolean("showInterceptView");
                this.stationGuideName = jSONObject.optString("station_guide_name");
                this.stationWalkGuideLink = jSONObject.optString("station_walk_guide_link");
                this.walkGuidePhoto = jSONObject.optString("walk_guide_photo");
                this.isShowRealPicInXpanel = jSONObject.optBoolean("is_show_real_pic_in_xpanel");
            }
        }
    }

    public static class DTSDKCancelInfo extends BaseObject {
        public String cancelTitle;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            if (jSONObject != null) {
                this.cancelTitle = jSONObject.optString("cancelorder_title", "");
            }
        }
    }
}
