package com.didi.travel.psnger.model.response;

import android.text.TextUtils;
import com.didi.address.model.WayPoint;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.log.Logger;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.core.model.response.DTSDKAirportPanelData;
import com.didi.travel.psnger.core.model.response.DTSDKCarModel;
import com.didi.travel.psnger.core.model.response.DTSDKCompanyTags;
import com.didi.travel.psnger.core.model.response.DTSDKCurrency;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import com.didi.travel.psnger.core.model.response.DTSDKEvaluateModel;
import com.didi.travel.psnger.core.model.response.DTSDKLabelInfo;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.core.model.response.DTSDKStriveInfo;
import com.didi.travel.psnger.core.model.response.DTSDKUpgradeModel;
import com.didi.travel.psnger.core.model.response.ICarOrder;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.CommonPopUp;
import com.didi.travel.psnger.model.FlierFeature;
import com.didi.travel.psnger.model.RGCommonPopUp;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.TextUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CarOrder extends BaseObject implements ICarOrder {
    public static final int CHARTERED_CLOSE = 0;
    public static final int CHARTERED_OPEN = 1;
    public static final int COUNT_PRICE_TYPE_JP_FIXED = 101;
    public static final int COUNT_PRICE_TYPE_JP_OP_ACTIVITY = 102;
    public static final int JOIN_MODEL_SUBAME = 100;
    public JSONObject ConfigJson;
    public String GGKJson;
    public DTSDKAirportPanelData airportPanelData;
    public long arriveTime;
    public ReAssignDriverResult assignResult;
    public long assignedTime;
    public String authData;
    public String auth_h5_url;
    public String banGlobalId;
    public OrderBanPopInfo banPopInfo;
    public int banStatus;
    public CarUnderServiceBannerTopInfo bannerTopInfo;
    public int bizCode;
    public BookingAssignInfo bookingAssignInfo;
    public int bookingMode;
    public long buttonControl;
    public String callBackUrl;
    public DTSDKOrderDetail.DTSDKCancelInfo cancelInfo;
    public String capPrice;
    public String capPriceDisplay;
    public CarCancelTrip carCancelTrip;
    public DTSDKDriverModel carDriver;
    public DTSDKCarModel carInfo;
    public String carLevel;
    public String carPoolOrderScene;
    public String cardArray;
    public DTSDKOrderDetail.CardInfo cardInfo;
    public String cardSuffix;
    public int carpoolStatus = 0;
    public CashUnPayInterceptInfo cashUnPayInterceptInfo;
    public float chargePrice;
    public int checkIsSplitFare;
    public String checkSplitFareMsg;
    public int checkSplitStatus;
    public CharteredComboInfo comboInfo;
    public int comboType;
    public NextCommonPushMsg commonPushMessage;
    public DTSDKCompanyTags companyTags;
    public int consultTime;
    public int countPriceType;
    public String countryCode;
    public DTSDKOrderDetail.CouponInfo couponInfo;
    public String cpf_auth_h5_url;
    public long createTime;
    public DTSDKCurrency currency;
    public long departureTime;
    public String disTrict = "";
    public DonateInfo donateInfo;
    public Address endAddress;
    public int enterpriseFlag;
    public DTSDKEvaluateModel evaluateModel;
    public DTSDKOrderDetail.ExpensiveCompensationInfo expensiveCompensationInfo;
    public int faceBizcode;
    public String faceSessionId;
    public NextTotalFeeDetail feeDetail;
    public int feeObjection;
    public long finishTime;
    public FlierFeature flierFeature = new FlierFeature();
    public String flightNumber;
    public long holdTime = -1;
    public int imBusinessId;
    public DTSDKOrderDetail.InvoiceInfo invoiceInfo;
    public boolean isCallCar;
    public int isCapPrice;
    public boolean isCarpoolCommute;
    public int isChartered;
    public boolean isDetailPriceClosed;
    public int isNearbyWait;
    private boolean isNewVersion = false;
    public int isPay;
    public boolean isSerialOrder;
    public int joinModel;
    public String keeper_id;
    public DTSDKLabelInfo labelInfo;
    public String lastOrderId;
    public List<String> loopMsg;
    public JSONObject mExtendResult;
    public OperationModel mOperationModel;
    public int mOrderTag;
    public CommonPopUp mPopUp;
    public RGCommonPopUp mRGCommonPopUp;
    public OrderRealtimePriceCount mRealtimePriceCount;
    public DTSDKOrderDetail.DTSDKMapData mapData;
    public String mapType;
    public String oid;
    public DTSDKOpActivityInfo opActivityInfo;
    public int orderSource = 0;
    public DTSDKOrderStatus orderState;
    public String orderTraceId;
    public int orderType;
    public String overdraftOid;
    public int passengerCount;
    public DTSDKOrderDetail.PaymentsWayInfo payInfo;
    public NextPayResult payResult;
    public int payType;
    public CommonPopUpModel popup;
    public DTSDKOrderDetail.DTSDKPostOrderRecInfo postOrderRecInfo;
    public DTSDKOrderDetail.DTSDKPushInfo prepareSCModel;
    public String prepayTraceId;
    public int productid = 1;
    public String servicePhone;
    public CarPayShare share;
    public boolean showQuestion;
    public boolean showTips;
    public boolean showUpdatePickUpPop;
    public boolean showWalletFloat;
    public DTSDKSplitFareInfo splitFareInfo;
    public Address startAddress;
    public long startChargeTime;
    public String stationGuideName;
    public String stationWalkGuideLink;
    public volatile int status;
    public boolean statusMD5Changed;
    public DTSDKStriveInfo striveInfo;
    public volatile int substatus = 0;
    public Object[] timeSegment;
    public boolean timeout;
    public int tip;
    public String toastContent;
    public String toastData;
    public String toastTitle;
    public long transportTime;
    public String travelid;
    public String tripCountry;
    public UnevaluatedViewModel unevaluatedViewModel;
    public OrderDetailUpdateDest updateDest;
    public OrderDetailUpdateWayPoint updateWayPoint;
    public DTSDKUpgradeModel upgradeInfo;
    public int verifyMode;
    public long waitTime;
    public List<WayPoint> wayPointList;
    public String wayPointsVersion;
    public String xActivityId;

    public void setIsNewVersion(boolean z) {
        this.isNewVersion = z;
    }

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        boolean z = false;
        Logger.m25808d("carorder is : " + jSONObject, new Object[0]);
        if (this.isNewVersion && jSONObject.has("data")) {
            jSONObject = jSONObject.optJSONObject("data");
        }
        this.oid = jSONObject.optString("oid");
        if (!configIntercept(jSONObject) && !GgkIntercept(this.errno, jSONObject)) {
            JSONObject optJSONObject3 = jSONObject.optJSONObject("data");
            if (!(optJSONObject3 == null || (optJSONObject2 = optJSONObject3.optJSONObject(Const.POPUP)) == null)) {
                CommonPopUpModel commonPopUpModel = new CommonPopUpModel();
                this.popup = commonPopUpModel;
                commonPopUpModel.parse(optJSONObject2);
            }
            this.status = jSONObject.optInt("status");
            try {
                this.productid = Integer.valueOf(jSONObject.optString("business_id")).intValue();
            } catch (Exception unused) {
                LogUtil.m31432fi("productId parse error: " + jSONObject);
            }
            this.createTime = jSONObject.optLong("createTime") * 1000;
            this.overdraftOid = jSONObject.optString("overdraftOid");
            this.toastTitle = jSONObject.optString("toast_title");
            this.toastContent = jSONObject.optString("toast_content");
            this.authData = jSONObject.optString("auth_data");
            this.prepayTraceId = jSONObject.optString("out_trade_id");
            this.orderTraceId = jSONObject.optString("pneworder_trace_id");
            this.callBackUrl = jSONObject.optString("callback_url");
            this.cardSuffix = jSONObject.optString("card_suffix");
            this.isNearbyWait = jSONObject.optInt("is_nearby_wait");
            if (jSONObject.optJSONObject("act_ensure") != null) {
                JSONObject optJSONObject4 = jSONObject.optJSONObject("act_ensure");
                OperationModel operationModel = new OperationModel();
                this.mOperationModel = operationModel;
                operationModel.parse(optJSONObject4);
            } else if (jSONObject.optJSONObject("special_ensure") != null) {
                JSONObject optJSONObject5 = jSONObject.optJSONObject("special_ensure");
                OperationModel operationModel2 = new OperationModel();
                this.mOperationModel = operationModel2;
                operationModel2.parse(optJSONObject5);
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("like_wait_info");
            if (optJSONObject6 != null) {
                WillWaitInfo willWaitInfo = new WillWaitInfo();
                willWaitInfo.parse(optJSONObject6);
                if (this.flierFeature == null) {
                    this.flierFeature = new FlierFeature();
                }
                this.flierFeature.willWaitInfo = willWaitInfo;
            }
            FlierFeature flierFeature2 = this.flierFeature;
            if (flierFeature2 != null) {
                flierFeature2.seatNum = jSONObject.optInt(ParamKeys.PARAM_PASSENGER_COUNT);
                this.flierFeature.carPrice = jSONObject.optString("cap_price");
            }
            if (jSONObject.optJSONObject("driver") != null) {
                if (jSONObject.optJSONObject("driver").optInt("show_question") == 1) {
                    z = true;
                }
                this.showQuestion = z;
            }
            JSONObject optJSONObject7 = jSONObject.optJSONObject("data");
            if (!(optJSONObject7 == null || (optJSONObject = optJSONObject7.optJSONObject(Const.POPUP)) == null)) {
                CommonPopUp commonPopUp = new CommonPopUp();
                this.mPopUp = commonPopUp;
                commonPopUp.parse(optJSONObject);
            }
            this.mExtendResult = jSONObject.optJSONObject("extend_result");
            this.auth_h5_url = jSONObject.optString("auth_h5_url");
            JSONObject optJSONObject8 = jSONObject.optJSONObject("data");
            if (optJSONObject8 != null) {
                JSONObject optJSONObject9 = optJSONObject8.optJSONObject(Const.POPUP);
                this.keeper_id = optJSONObject8.optString("keeper_id");
                this.cardArray = optJSONObject8.optString("card_array");
                this.bizCode = optJSONObject8.optInt("biz_code");
                this.cpf_auth_h5_url = optJSONObject8.optString("cpf_auth_h5_url");
                if (optJSONObject9 != null) {
                    RGCommonPopUp rGCommonPopUp = new RGCommonPopUp();
                    this.mRGCommonPopUp = rGCommonPopUp;
                    rGCommonPopUp.parse(optJSONObject9);
                }
            }
            this.chargePrice = ((float) jSONObject.optInt("pre_payment")) / 100.0f;
            this.payType = jSONObject.optInt("payType");
            this.verifyMode = jSONObject.optInt(ParamKeys.PARAM_RISK_VERIFY_MODE);
            this.bookingMode = jSONObject.optInt("booking_mode");
            if (jSONObject.has("split_fare_info")) {
                DTSDKSplitFareInfo dTSDKSplitFareInfo = new DTSDKSplitFareInfo();
                this.splitFareInfo = dTSDKSplitFareInfo;
                dTSDKSplitFareInfo.parse(jSONObject.optJSONObject("split_fare_info"));
            }
            this.faceSessionId = jSONObject.optString("face_session_id");
            this.faceBizcode = jSONObject.optInt("face_bizcode");
            this.checkIsSplitFare = jSONObject.optInt("is_split_fare");
            this.checkSplitFareMsg = jSONObject.optString("split_fare_msg");
            this.checkSplitStatus = jSONObject.optInt("split_status");
            this.enterpriseFlag = jSONObject.optInt(ParamKeys.PARAM_ENTERPRISE_FLAG);
            this.banStatus = jSONObject.optInt("ban_status");
            this.banGlobalId = jSONObject.optString("global_id");
            JSONObject optJSONObject10 = jSONObject.optJSONObject("ban_pop_info");
            if (optJSONObject10 != null) {
                OrderBanPopInfo orderBanPopInfo = new OrderBanPopInfo();
                this.banPopInfo = orderBanPopInfo;
                orderBanPopInfo.parse(optJSONObject10);
            }
            parseServiceControl(jSONObject);
        }
    }

    private boolean GgkIntercept(int i, JSONObject jSONObject) {
        if (i != 10001) {
            return false;
        }
        try {
            this.GGKJson = jSONObject.getJSONObject("data").getJSONObject("generic_component").toString();
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean configIntercept(JSONObject jSONObject) {
        if (this.errno == 100003) {
            this.ConfigJson = jSONObject;
            return true;
        }
        this.ConfigJson = null;
        return false;
    }

    private void parseServiceControl(JSONObject jSONObject) {
        if (jSONObject.optJSONObject("cash_unpay_intercept_info") != null) {
            CashUnPayInterceptInfo cashUnPayInterceptInfo2 = new CashUnPayInterceptInfo();
            this.cashUnPayInterceptInfo = cashUnPayInterceptInfo2;
            cashUnPayInterceptInfo2.parse(jSONObject.optJSONObject("cash_unpay_intercept_info").optJSONObject("data"));
        } else if (jSONObject.optJSONObject("themis_info") != null) {
            CashUnPayInterceptInfo cashUnPayInterceptInfo3 = new CashUnPayInterceptInfo();
            this.cashUnPayInterceptInfo = cashUnPayInterceptInfo3;
            cashUnPayInterceptInfo3.parse(jSONObject.optJSONObject("themis_info").optJSONObject("data"));
        } else if (jSONObject.optJSONObject("toll_unpay_intercept_info") != null) {
            CashUnPayInterceptInfo cashUnPayInterceptInfo4 = new CashUnPayInterceptInfo();
            this.cashUnPayInterceptInfo = cashUnPayInterceptInfo4;
            cashUnPayInterceptInfo4.parse(jSONObject.optJSONObject("toll_unpay_intercept_info").optJSONObject("data"));
        }
    }

    public boolean isBooking() {
        return this.orderType == 1;
    }

    public boolean isBookingDelayAssign() {
        return this.bookingMode == 1;
    }

    public boolean isBookingAssign() {
        return this.substatus == 7003;
    }

    public int comboType2OType() {
        int i = this.comboType;
        if (i == 2) {
            return 3;
        }
        return i == 3 ? 4 : 0;
    }

    public synchronized String getOid() {
        return this.oid;
    }

    public Address getStartAddress() {
        return this.startAddress;
    }

    public IOrderStatus getOrderStatus() {
        return this.orderState;
    }

    public void setOrderStatus(IOrderStatus iOrderStatus) {
        DTSDKOrderStatus dTSDKOrderStatus = (DTSDKOrderStatus) iOrderStatus;
        DTSDKOrderStatus dTSDKOrderStatus2 = this.orderState;
        if (dTSDKOrderStatus2 == null || dTSDKOrderStatus == null) {
            this.statusMD5Changed = false;
        } else if (!TextUtils.isEmpty(dTSDKOrderStatus2.md5)) {
            this.statusMD5Changed = !this.orderState.md5.equals(dTSDKOrderStatus.md5);
        } else if (!TextUtils.isEmpty(dTSDKOrderStatus.md5)) {
            this.statusMD5Changed = !dTSDKOrderStatus.md5.equals(this.orderState.md5);
        } else {
            this.statusMD5Changed = false;
        }
        this.orderState = dTSDKOrderStatus;
    }

    public int getStatus() {
        return this.status;
    }

    public int getSubStatus() {
        return this.substatus;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getXTag() {
        return this.xActivityId;
    }

    public OrderRealtimePriceCount getRealtimePriceCount() {
        return this.mRealtimePriceCount;
    }

    public void setRealtimePriceCount(OrderRealtimePriceCount orderRealtimePriceCount) {
        this.mRealtimePriceCount = orderRealtimePriceCount;
    }

    public void setPayResult(NextPayResult nextPayResult) {
        if (nextPayResult != null && TextUtil.isEmpty(nextPayResult.actual_deduction) && !TextUtil.isEmpty(nextPayResult.payInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(nextPayResult.payInfo);
                nextPayResult.actual_deduction = jSONObject.optString("coupon_fee");
                nextPayResult.actual_deduction_display = jSONObject.optString("coupon_fee_display_string");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        this.payResult = nextPayResult;
    }

    public boolean isDirty() {
        DTSDKOrderStatus dTSDKOrderStatus = this.orderState;
        if (dTSDKOrderStatus != null && dTSDKOrderStatus.code == 700013) {
            return false;
        }
        if (this.statusMD5Changed) {
            return true;
        }
        DTSDKOrderStatus dTSDKOrderStatus2 = this.orderState;
        boolean z = (dTSDKOrderStatus2 == null || dTSDKOrderStatus2.subStatus() == this.substatus) ? false : true;
        DTSDKOrderStatus dTSDKOrderStatus3 = this.orderState;
        boolean z2 = (dTSDKOrderStatus3 == null || dTSDKOrderStatus3.status() <= 0 || this.orderState.status() == this.status) ? false : true;
        DTSDKOrderStatus dTSDKOrderStatus4 = this.orderState;
        boolean z3 = (dTSDKOrderStatus4 == null || dTSDKOrderStatus4.carpoolStatus == this.carpoolStatus) ? false : true;
        if (z || z2 || z3) {
            return true;
        }
        return false;
    }

    public int getProductId() {
        return this.productid;
    }

    public long getDepartureCountDownLeftTime() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.departureTime;
        long j2 = (j - currentTimeMillis) / 1000;
        long max = Math.max((j - this.assignedTime) / 1000, 0);
        return j2 > max ? max : j2;
    }

    public boolean isSplitFareOwner() {
        DTSDKSplitFareInfo dTSDKSplitFareInfo = this.splitFareInfo;
        return dTSDKSplitFareInfo != null && dTSDKSplitFareInfo.split_fare_role == 1;
    }

    public boolean isSplitFareUser() {
        DTSDKSplitFareInfo dTSDKSplitFareInfo = this.splitFareInfo;
        return dTSDKSplitFareInfo != null && dTSDKSplitFareInfo.split_fare_role == 0;
    }

    public boolean isSplitFareOrder() {
        DTSDKSplitFareInfo dTSDKSplitFareInfo = this.splitFareInfo;
        return (dTSDKSplitFareInfo == null || dTSDKSplitFareInfo.split_user_list == null || this.splitFareInfo.split_user_list.size() <= 0) ? false : true;
    }

    public boolean isShowSplitFare() {
        DTSDKSplitFareInfo dTSDKSplitFareInfo = this.splitFareInfo;
        return dTSDKSplitFareInfo != null && dTSDKSplitFareInfo.is_visible == 1;
    }

    public boolean isCanSplitFare() {
        DTSDKSplitFareInfo dTSDKSplitFareInfo = this.splitFareInfo;
        return dTSDKSplitFareInfo != null && dTSDKSplitFareInfo.is_available == 1;
    }

    public boolean isShowCancelSplitFare() {
        DTSDKSplitFareInfo dTSDKSplitFareInfo = this.splitFareInfo;
        return (dTSDKSplitFareInfo == null || dTSDKSplitFareInfo.split_user_list == null || this.splitFareInfo.split_user_list.size() <= 0) ? false : true;
    }

    public boolean isJPFixPrice() {
        return this.countPriceType == 101;
    }

    public boolean isEnterprise() {
        return this.enterpriseFlag == 3;
    }

    public boolean isJPOPActivityPrice() {
        return this.countPriceType == 102;
    }

    public boolean isTwoPriceScene() {
        return "1".equals(this.carPoolOrderScene);
    }

    public boolean isMatchToGo() {
        return "2".equals(this.carPoolOrderScene);
    }

    public boolean isCarpoolNotMatch() {
        return "3".equals(this.carPoolOrderScene);
    }

    public boolean isTraditionalCarPool() {
        return "0".equals(this.carPoolOrderScene);
    }

    public Map<String, Object> getExtendResult() {
        if (this.mExtendResult == null) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(this.mExtendResult.toString(), new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
