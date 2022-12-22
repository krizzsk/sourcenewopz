package com.didi.travel.psnger.core.model.request;

import android.text.TextUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.response.PayEnterpriseInfo;
import com.didi.travel.psnger.utils.LogUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class OrderParams extends BaseOrderParams {

    /* renamed from: A */
    private DTSdkOrderXActivityParam f44137A;

    /* renamed from: B */
    private PayEnterpriseInfo f44138B;

    /* renamed from: C */
    private String f44139C;

    /* renamed from: D */
    private String f44140D;

    /* renamed from: E */
    private String f44141E;

    /* renamed from: F */
    private DTSDKOrder412Param f44142F;

    /* renamed from: G */
    private String f44143G;

    /* renamed from: H */
    private String f44144H;

    /* renamed from: I */
    private long f44145I;

    /* renamed from: J */
    private String f44146J;

    /* renamed from: a */
    private int f44147a;

    /* renamed from: b */
    private DIDILocation f44148b;

    /* renamed from: c */
    private boolean f44149c = true;

    /* renamed from: d */
    private Address f44150d;

    /* renamed from: e */
    private Address f44151e;
    public int enterpriseFlag;

    /* renamed from: f */
    private int f44152f;

    /* renamed from: g */
    private long f44153g;

    /* renamed from: h */
    private String f44154h;

    /* renamed from: i */
    private int f44155i;

    /* renamed from: j */
    private String f44156j;

    /* renamed from: k */
    private String f44157k;

    /* renamed from: l */
    private int f44158l = -1;

    /* renamed from: m */
    private String f44159m;

    /* renamed from: n */
    private float f44160n = -1.0f;

    /* renamed from: o */
    private DTSdkOrderFlierParam f44161o;

    /* renamed from: p */
    private String f44162p;

    /* renamed from: q */
    private String f44163q;

    /* renamed from: r */
    private String f44164r;

    /* renamed from: s */
    private String f44165s;

    /* renamed from: t */
    private DTSdkOrderPassengerParam f44166t;

    /* renamed from: u */
    private DTSdkOrderGuideParam f44167u;

    /* renamed from: v */
    private DTSdkSpecialPoiParam f44168v;

    /* renamed from: w */
    private String f44169w;

    /* renamed from: x */
    private DTSdkOrderFlightParam f44170x;

    /* renamed from: y */
    private String f44171y;

    /* renamed from: z */
    private DTSdkOrderComboParam f44172z;

    public static final class DTSDKOrder412Param {
        public String cfExisted = "0";
        public String defaultFSearchId = "";
        public String defaultFSrcTag = "";
        public String defaultFUid = "";
        public String mapDraged = "0";
    }

    public static final class DTSdkOrderComboParam {
        public String comboId;
        public int comboType;
        public int mealMode;
        public String rentedInfo;
    }

    public static final class DTSdkOrderFlierParam {
        public int isCarPool = -1;
        public int isCarPoolShowed = -1;
        public int isSameWay = -1;
        public int isWillWait = -1;
        public String regionalDepartureTime;
        public int seatNumber;
        public DTSdkOrderFlierPoolStationParam stationCarPoolParam;
    }

    public static final class DTSdkOrderFlierPoolStationParam {
        public String stationAddress;
        public float stationLat;
        public float stationLng;
        public String stationName;
        public String stationPoiId;
    }

    public static final class DTSdkOrderFlightParam {
        public static final int PARAM_FLIGHT_PICKUP = 1;
        public static final int PARAM_FLIGHT_SEND = 2;
        public int flightType;
        public DTSdkOrderFlightPickupParam pickupParam;
        public DTSdkOrderSendParam sendParam;
    }

    public static final class DTSdkOrderFlightPickupParam {
        public String arrAirportId;
        public String arrCode;
        public int delayTime;
        public String depCode;
        public String depPlanTime;
        public String flightNumber;
        public int isGuide;
        public DTSdkSpecialPoiParam specialPoiParam;
    }

    public static final class DTSdkOrderGuideParam {
        public String guideApiInfo;
        public int guideScene = -1;
        public int sourceProduct = -1;
        public int sourceScene = -1;
    }

    public static final class DTSdkOrderPassengerParam {
        public String callcarName;
        public String callcarPhone;
    }

    public static final class DTSdkOrderSendParam {
        public int isCip;
        public String sendAirportId;
    }

    public static final class DTSdkOrderXActivityParam {
        public String xActivityId;
        public String xActivityType;
    }

    public static final class DTSdkSpecialPoiParam {
        public String specialPoiName;
        public int specialPoiSceneType;
        public String specialPoiid;
    }

    public Map<String, Object> convertBean2Map() {
        DTSdkOrderFlierParam dTSdkOrderFlierParam;
        HashMap hashMap = new HashMap();
        put(hashMap, "business_id", Integer.valueOf(getBusinessId()));
        put(hashMap, ParamKeys.PARAM_APP_TIME, System.currentTimeMillis() + "");
        if (!TextUtils.isEmpty(this.f44139C)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_ID, this.f44139C);
        }
        if (!TextUtils.isEmpty(this.f44140D)) {
            put(hashMap, ParamKeys.PARAM_UNMATCHED_ESTIMATE_ID, this.f44140D);
        }
        put(hashMap, "flier", Integer.valueOf(this.f44147a));
        Address address = this.f44150d;
        if (address != null) {
            put(hashMap, "flat", Double.valueOf(address.getLatitude()));
            put(hashMap, "flng", Double.valueOf(this.f44150d.getLongitude()));
            put(hashMap, "area", Integer.valueOf(this.f44150d.getCityId()));
            put(hashMap, ParamKeys.PARAM_FROM_NAME, this.f44150d.getDisplayName());
            put(hashMap, "fromAddress", this.f44150d.getAddress());
            put(hashMap, ParamKeys.PARAM_STARTING_POI_ID, this.f44150d.getUid());
            put(hashMap, ParamKeys.PARAM_SPECIAL_HISTORY, Integer.valueOf(this.f44150d.getIsHistory()));
        }
        if (!TextUtils.isEmpty(this.f44146J)) {
            put(hashMap, "passenger_sheet", "{\"" + this.f44146J + "\":{\"is_confirm\":1}}");
        }
        LogUtil.m31426d("departure: PARAM_412_CHOOSE_F_SRCTAG =" + this.f44150d.getSrcTag());
        Address address2 = this.f44150d;
        if (address2 != null) {
            put(hashMap, "choose_f_srctag", address2.getSrcTag());
            put(hashMap, "choose_f_uid", this.f44150d.getUid());
            put(hashMap, "choose_f_searchid", this.f44150d.getSearchId());
        } else {
            put(hashMap, "choose_f_srctag", "");
            put(hashMap, "choose_f_uid", "");
            put(hashMap, "choose_f_searchid", "");
        }
        DTSDKOrder412Param dTSDKOrder412Param = this.f44142F;
        if (dTSDKOrder412Param != null) {
            put(hashMap, "default_f_searchid", dTSDKOrder412Param.defaultFSearchId);
            put(hashMap, "default_f_uid", this.f44142F.defaultFUid);
            put(hashMap, "default_f_srctag", this.f44142F.defaultFSrcTag);
        } else {
            put(hashMap, "default_f_searchid", "");
            put(hashMap, "default_f_uid", "");
            put(hashMap, "default_f_srctag", "");
        }
        DIDILocation dIDILocation = this.f44148b;
        if (dIDILocation != null) {
            put(hashMap, "lat", Double.valueOf(dIDILocation.getLatitude()));
            put(hashMap, "lng", Double.valueOf(this.f44148b.getLongitude()));
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(ParamKeys.PARAM_LOC_PROVIDER, this.f44148b.getProvider());
                jSONObject.put(ParamKeys.PARAM_LOC_ACCURACY, (double) this.f44148b.getAccuracy());
                put(hashMap, ParamKeys.PARAM_PASSTHROUGH_DATA, jSONObject.toString());
            } catch (Exception unused) {
            }
        }
        Address address3 = this.f44151e;
        if (address3 != null) {
            put(hashMap, "toName", address3.getDisplayName());
            put(hashMap, "toAddress", this.f44151e.getAddress());
            put(hashMap, "tlat", Double.valueOf(this.f44151e.getLatitude()));
            put(hashMap, "tlng", Double.valueOf(this.f44151e.getLongitude()));
            put(hashMap, ParamKeys.PARAM_TO_AREA, Integer.valueOf(this.f44151e.getCityId()));
            put(hashMap, ParamKeys.PARAM_DEST_POI_ID, this.f44151e.getUid());
        }
        if (this.f44151e != null) {
            LogUtil.m31434i("createneworder: set srctag uid searchid params.");
            put(hashMap, "choose_t_srctag", this.f44151e.getSrcTag());
            put(hashMap, "choose_t_uid", this.f44151e.getUid());
            put(hashMap, "choose_t_searchid", this.f44151e.getSearchId());
        } else {
            put(hashMap, "choose_t_srctag", "");
            put(hashMap, "choose_t_uid", "");
            put(hashMap, "choose_t_searchid", "");
        }
        Address address4 = this.f44151e;
        if (address4 == null || !address4.isRecommendTag()) {
            put(hashMap, "default_t_searchid", "");
            put(hashMap, "default_t_uid", "");
            put(hashMap, "default_t_srctag", "");
        } else {
            put(hashMap, "default_t_searchid", this.f44151e.getSearchId());
            put(hashMap, "default_t_uid", this.f44151e.getUid());
            put(hashMap, "default_t_srctag", this.f44151e.getSrcTag());
        }
        put(hashMap, "type", Integer.valueOf(this.f44152f));
        if (this.f44152f == 1) {
            put(hashMap, "time", this.f44154h);
            put(hashMap, ParamKeys.PARAM_BOOKINGTIME, Long.valueOf(this.f44153g));
        }
        int i = this.f44155i;
        if (i < 0) {
            i = 0;
        }
        put(hashMap, "tip", Integer.valueOf(i));
        if (!TextUtils.isEmpty(this.f44156j)) {
            put(hashMap, "require_level", this.f44156j);
        }
        if (!TextUtils.isEmpty(this.f44141E)) {
            put(hashMap, ParamKeys.PARAM_DESIGNATED_DRIVER, this.f44141E);
        }
        if (!TextUtils.isEmpty(this.f44157k)) {
            put(hashMap, "estimate_trace_id", this.f44157k);
        }
        int i2 = this.f44158l;
        if (i2 != -1) {
            put(hashMap, "scene_type", Integer.valueOf(i2));
        }
        if (!TextUtils.isEmpty(this.f44159m)) {
            put(hashMap, ParamKeys.PARAM_COMBO_ID, this.f44159m);
        }
        float f = this.f44160n;
        if (f != -1.0f) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_PRICE, Float.valueOf(f));
        }
        if (260 == getBusinessId() && (dTSdkOrderFlierParam = this.f44161o) != null) {
            if (dTSdkOrderFlierParam.isCarPool != -1) {
                put(hashMap, "car_pool", Integer.valueOf(this.f44161o.isCarPool));
            }
            if (this.f44161o.isCarPoolShowed != -1) {
                put(hashMap, ParamKeys.PARAM_CARPOOL_SHOW, Integer.valueOf(this.f44161o.isCarPoolShowed));
            }
            if (!TextUtils.isEmpty(this.f44161o.regionalDepartureTime)) {
                put(hashMap, ParamKeys.PARAM_REGIONAL_DEPARTURE_TIME, this.f44161o.regionalDepartureTime);
            }
            if (this.f44161o.isCarPool == 1) {
                if (this.f44161o.isWillWait != -1) {
                    put(hashMap, "like_wait", Integer.valueOf(this.f44161o.isWillWait));
                }
                if (this.f44161o.seatNumber > 0) {
                    put(hashMap, ParamKeys.PARAM_POOL_SEAT, Integer.valueOf(this.f44161o.seatNumber));
                }
                if (this.f44161o.stationCarPoolParam != null && !TextUtils.isEmpty(this.f44161o.stationCarPoolParam.stationName)) {
                    put(hashMap, ParamKeys.PARAM_IS_POOL_STATION, 1);
                    put(hashMap, "flat", Float.valueOf(this.f44161o.stationCarPoolParam.stationLat));
                    put(hashMap, "flng", Float.valueOf(this.f44161o.stationCarPoolParam.stationLng));
                    put(hashMap, ParamKeys.PARAM_FROM_NAME, this.f44161o.stationCarPoolParam.stationName);
                    put(hashMap, "fromAddress", this.f44161o.stationCarPoolParam.stationAddress);
                    put(hashMap, ParamKeys.PARAM_STATION_ID, this.f44161o.stationCarPoolParam.stationPoiId);
                }
            } else if (this.f44161o.isSameWay != -1) {
                put(hashMap, ParamKeys.PARAM_SAME_WAY, Integer.valueOf(this.f44161o.isSameWay));
            }
        }
        put(hashMap, "openid", this.f44162p);
        DTSDKOrder412Param dTSDKOrder412Param2 = this.f44142F;
        if (dTSDKOrder412Param2 != null) {
            put(hashMap, "if_move", dTSDKOrder412Param2.mapDraged);
            put(hashMap, "if_cf", this.f44142F.cfExisted);
        } else {
            put(hashMap, "if_move", "0");
            put(hashMap, "if_cf", "0");
        }
        if (!TextUtils.isEmpty(this.f44163q)) {
            put(hashMap, ParamKeys.PARAM_USER_PAY_INFO, this.f44163q);
        }
        PayEnterpriseInfo payEnterpriseInfo = this.f44138B;
        if (payEnterpriseInfo != null) {
            put(hashMap, "business_submit", payEnterpriseInfo.toString());
        }
        if (!TextUtils.isEmpty(this.f44164r)) {
            put(hashMap, "business_submit", this.f44164r);
        }
        put(hashMap, "nettype", this.f44165s);
        put(hashMap, ParamKeys.PARAM_VERSION_ID, ParamKeys.PARAM_VERSION_VALUE);
        put(hashMap, ParamKeys.PARAM_PROTECT_STATUS, 0);
        put(hashMap, "input", 1);
        put(hashMap, ParamKeys.PARAM_DEFAULT_VOUCHER, 1);
        put(hashMap, ParamKeys.PARAM_IS_MULTICAR, 1);
        put(hashMap, "activity_id", 201503);
        DTSdkOrderPassengerParam dTSdkOrderPassengerParam = this.f44166t;
        if (dTSdkOrderPassengerParam == null || TextUtils.isEmpty(dTSdkOrderPassengerParam.callcarPhone) || this.f44166t.callcarPhone.equals(TEBridge.clientConfig().phone())) {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE, 0);
        } else {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE, 1);
            put(hashMap, ParamKeys.PARAM_CALLER_PHONE, this.f44166t.callcarPhone);
            put(hashMap, ParamKeys.PARAM_CALLER_NAME, this.f44166t.callcarName);
        }
        DTSdkOrderGuideParam dTSdkOrderGuideParam = this.f44167u;
        if (dTSdkOrderGuideParam != null) {
            put(hashMap, ParamKeys.PARAM_GUIDE_API_INFO, dTSdkOrderGuideParam.guideApiInfo);
            if (this.f44167u.guideScene != -1) {
                put(hashMap, ParamKeys.PARAM_DIVERSION_GUIDE_SCENE, Integer.valueOf(this.f44167u.guideScene));
            }
            if (this.f44167u.sourceProduct != -1) {
                put(hashMap, ParamKeys.PARAM_DIVERSION_SOURCE_PRODUCT, Integer.valueOf(this.f44167u.sourceProduct));
            }
            if (this.f44167u.sourceScene != -1) {
                put(hashMap, ParamKeys.PARAM_DIVERSION_SOURCE_SCENE, Integer.valueOf(this.f44167u.sourceScene));
            }
        }
        DTSdkSpecialPoiParam dTSdkSpecialPoiParam = this.f44168v;
        if (dTSdkSpecialPoiParam != null) {
            put(hashMap, ParamKeys.PARAM_SPECIAL_POIID, dTSdkSpecialPoiParam.specialPoiid);
            put(hashMap, ParamKeys.PARAM_SPECIAL_POINAME, this.f44168v.specialPoiName);
            put(hashMap, ParamKeys.PARAM_SPECIAL_POISCENE_TYPE, Integer.valueOf(this.f44168v.specialPoiSceneType));
        }
        if (!TextUtils.isEmpty(this.f44169w)) {
            put(hashMap, "extraInfo", this.f44169w);
        }
        DTSdkOrderFlightParam dTSdkOrderFlightParam = this.f44170x;
        if (dTSdkOrderFlightParam != null) {
            if (dTSdkOrderFlightParam.flightType == 1 && this.f44170x.pickupParam != null) {
                put(hashMap, ParamKeys.PARAM_OTYPE, 3);
                put(hashMap, "traffic_number", this.f44170x.pickupParam.flightNumber);
                put(hashMap, ParamKeys.PARAM_TRAFFIC_DEP_TIME, this.f44170x.pickupParam.depPlanTime);
                put(hashMap, ParamKeys.PARAM_FLIGHTDEPCODE, this.f44170x.pickupParam.depCode);
                put(hashMap, ParamKeys.PARAM_FLIGHTARRCODE, this.f44170x.pickupParam.arrCode);
                put(hashMap, "airport_id", this.f44170x.pickupParam.arrAirportId);
                put(hashMap, ParamKeys.PARAM_DEPART_DELAY_TIME, Integer.valueOf(this.f44170x.pickupParam.delayTime));
                put(hashMap, ParamKeys.PARAM_SELECTED_GUIDE, Integer.valueOf(this.f44170x.pickupParam.isGuide));
                if (this.f44170x.pickupParam.specialPoiParam != null) {
                    put(hashMap, ParamKeys.PARAM_SPECIAL_POISCENE_TYPE, Integer.valueOf(this.f44170x.pickupParam.specialPoiParam.specialPoiSceneType));
                    put(hashMap, ParamKeys.PARAM_SPECIAL_POIID, this.f44170x.pickupParam.specialPoiParam.specialPoiid);
                    put(hashMap, ParamKeys.PARAM_SPECIAL_POINAME, this.f44170x.pickupParam.specialPoiParam.specialPoiName);
                }
            } else if (this.f44170x.flightType == 2 && this.f44170x.sendParam != null) {
                put(hashMap, ParamKeys.PARAM_OTYPE, 4);
                put(hashMap, "airport_id", this.f44170x.sendParam.sendAirportId);
                put(hashMap, ParamKeys.PARAM_DEPART_SELECTED_CIP, Integer.valueOf(this.f44170x.sendParam.isCip));
            }
        }
        if (!TextUtils.isEmpty(this.f44171y)) {
            put(hashMap, ParamKeys.PARAM_CUSTOM_FEATURE, this.f44171y);
        }
        DTSdkOrderComboParam dTSdkOrderComboParam = this.f44172z;
        if (dTSdkOrderComboParam != null) {
            put(hashMap, "combo_type", Integer.valueOf(dTSdkOrderComboParam.comboType));
            put(hashMap, ParamKeys.PARAM_COMBO_ID, this.f44172z.comboId);
            put(hashMap, ParamKeys.PARAM_MEAL_MODE, Integer.valueOf(this.f44172z.mealMode));
            if (!TextUtils.isEmpty(this.f44172z.rentedInfo)) {
                put(hashMap, ParamKeys.RENTED_INFO, this.f44172z.rentedInfo);
            }
        }
        DTSdkOrderXActivityParam dTSdkOrderXActivityParam = this.f44137A;
        if (dTSdkOrderXActivityParam != null) {
            put(hashMap, ParamKeys.PARAM_XACTIVITY_ID, dTSdkOrderXActivityParam.xActivityId);
            put(hashMap, ParamKeys.PARAM_XACTIVITY_TYPE, this.f44137A.xActivityType);
        }
        if (!TextUtil.isEmpty(this.f44144H)) {
            put(hashMap, "traffic_number", this.f44144H);
        }
        put(hashMap, ParamKeys.PARAM_ENTERPRISE_FLAG, Integer.valueOf(this.enterpriseFlag));
        return hashMap;
    }

    public void setEnterpriseFlag(int i) {
        this.enterpriseFlag = i;
    }

    public void setEstimateId(String str) {
        this.f44139C = str;
    }

    public void setUnmatchedEstimateId(String str) {
        this.f44140D = str;
    }

    public void setIsFlier(int i) {
        this.f44147a = i;
    }

    public void setLastKnownLocation(DIDILocation dIDILocation) {
        this.f44148b = dIDILocation;
    }

    public void setStartAddress(Address address) {
        this.f44150d = address;
    }

    public void setEndAddress(Address address) {
        this.f44151e = address;
    }

    public void setBookingType(int i) {
        this.f44152f = i;
    }

    public void setDepartureTime(long j) {
        this.f44153g = j;
    }

    public void setFormatTime(String str) {
        this.f44154h = str;
    }

    public void setTipPrice(int i) {
        this.f44155i = i;
    }

    public void setCarLevelId(String str) {
        this.f44156j = str;
    }

    public void setEstimateTraceId(String str) {
        this.f44157k = str;
    }

    public void setSceneType(int i) {
        this.f44158l = i;
    }

    public void setComboId(String str) {
        this.f44159m = str;
    }

    public void setEstimatePrice(float f) {
        this.f44160n = f;
    }

    public void setFlierParam(DTSdkOrderFlierParam dTSdkOrderFlierParam) {
        this.f44161o = dTSdkOrderFlierParam;
    }

    public void setWxPayOpenId(String str) {
        this.f44162p = str;
    }

    public void setPayType(String str) {
        this.f44163q = str;
    }

    public void setPaySubmitInfo(String str) {
        this.f44164r = str;
    }

    public void setNetType(String str) {
        this.f44165s = str;
    }

    public void setOtherCallCarParam(DTSdkOrderPassengerParam dTSdkOrderPassengerParam) {
        this.f44166t = dTSdkOrderPassengerParam;
    }

    public void setGuideParam(DTSdkOrderGuideParam dTSdkOrderGuideParam) {
        this.f44167u = dTSdkOrderGuideParam;
    }

    public void setSpecialPoiParam(DTSdkSpecialPoiParam dTSdkSpecialPoiParam) {
        this.f44168v = dTSdkSpecialPoiParam;
    }

    public void setUniTaxiRemark(String str) {
        this.f44169w = str;
    }

    public void setAirportParam(DTSdkOrderFlightParam dTSdkOrderFlightParam) {
        this.f44170x = dTSdkOrderFlightParam;
    }

    public void setCustomFeatures(String str) {
        this.f44171y = str;
    }

    public void setComboParam(DTSdkOrderComboParam dTSdkOrderComboParam) {
        this.f44172z = dTSdkOrderComboParam;
    }

    public DTSdkOrderComboParam getComboParam() {
        return this.f44172z;
    }

    public void setxActivityParam(DTSdkOrderXActivityParam dTSdkOrderXActivityParam) {
        this.f44137A = dTSdkOrderXActivityParam;
    }

    public PayEnterpriseInfo getPayEnterpriseInfo() {
        return this.f44138B;
    }

    public void setPayEnterpriseInfo(PayEnterpriseInfo payEnterpriseInfo) {
        this.f44138B = payEnterpriseInfo;
    }

    public String getDesignatedDriver() {
        return this.f44141E;
    }

    public void setDesignatedDriver(String str) {
        this.f44141E = str;
    }

    public DTSDKOrder412Param getOrder412Param() {
        return this.f44142F;
    }

    public void setOrder412Param(DTSDKOrder412Param dTSDKOrder412Param) {
        this.f44142F = dTSDKOrder412Param;
    }

    public String getSubPayAccountId() {
        return this.f44143G;
    }

    public void setSubPayAccountId(String str) {
        this.f44143G = str;
    }

    public void setFlightNum(String str) {
        this.f44144H = str;
    }

    public void setFixedPriceRouteId(long j) {
        this.f44145I = j;
    }

    public String getPassengerSheetKey() {
        return this.f44146J;
    }

    public void setPassengerSheetKey(String str) {
        this.f44146J = str;
    }

    public boolean isEstimateInfoMatch() {
        return this.f44149c;
    }

    public void setEstimateInfoMatch(boolean z) {
        this.f44149c = z;
    }
}
