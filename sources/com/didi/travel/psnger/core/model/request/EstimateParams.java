package com.didi.travel.psnger.core.model.request;

import android.text.TextUtils;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.TEBridge;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.utils.LogUtil;
import com.didi.travel.psnger.utils.TextUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class EstimateParams extends BaseEstimateParams {
    public static final int NEW_UI_HORIZONTAL = 0;
    public static final int NEW_UI_VERTICAL = 1;

    /* renamed from: A */
    private long f44092A;

    /* renamed from: B */
    private String f44093B;

    /* renamed from: C */
    private String f44094C;

    /* renamed from: D */
    private int f44095D = 1;

    /* renamed from: E */
    private int f44096E = 0;

    /* renamed from: F */
    private int f44097F;

    /* renamed from: G */
    private int f44098G;

    /* renamed from: H */
    private long f44099H = 0;

    /* renamed from: I */
    private long f44100I = 0;

    /* renamed from: J */
    private String f44101J;

    /* renamed from: K */
    private Map<String, Object> f44102K;

    /* renamed from: L */
    private List<JSONObject> f44103L;

    /* renamed from: M */
    private int f44104M;

    /* renamed from: N */
    private int f44105N = 0;

    /* renamed from: O */
    private int f44106O = 0;

    /* renamed from: P */
    private int f44107P = 0;

    /* renamed from: Q */
    private boolean f44108Q = false;

    /* renamed from: R */
    private String f44109R;

    /* renamed from: S */
    private String f44110S;

    /* renamed from: a */
    private Address f44111a;

    /* renamed from: b */
    private Address f44112b;

    /* renamed from: c */
    private long f44113c;
    public String curCompanyId;

    /* renamed from: d */
    private int f44114d;

    /* renamed from: e */
    private int f44115e;
    public int enterpriseFlag;
    public String estimateSceneType;
    public String estimateSort;

    /* renamed from: f */
    private String f44116f;
    public boolean fixedPrice;

    /* renamed from: g */
    private String f44117g;

    /* renamed from: h */
    private String f44118h;

    /* renamed from: i */
    private boolean f44119i;

    /* renamed from: j */
    private boolean f44120j;

    /* renamed from: k */
    private String f44121k;

    /* renamed from: l */
    private String f44122l;

    /* renamed from: m */
    private int f44123m = 1;

    /* renamed from: n */
    private String f44124n;

    /* renamed from: o */
    private String f44125o;

    /* renamed from: p */
    private String f44126p;

    /* renamed from: q */
    private String f44127q;

    /* renamed from: r */
    private String f44128r;
    public String regionalDepartureTime;
    public String routeList;

    /* renamed from: s */
    private String f44129s;

    /* renamed from: t */
    private String f44130t;

    /* renamed from: u */
    private String f44131u;

    /* renamed from: v */
    private String f44132v;

    /* renamed from: w */
    private String f44133w;

    /* renamed from: x */
    private String f44134x;

    /* renamed from: y */
    private String f44135y;

    /* renamed from: z */
    private String f44136z;

    public String getGroupType() {
        return this.f44101J;
    }

    public void setGroupType(String str) {
        this.f44101J = str;
    }

    public int getRequestSource() {
        return this.f44096E;
    }

    public void setRequestSource(int i) {
        this.f44096E = i;
    }

    public int getProductId() {
        return this.f44105N;
    }

    public void setProductId(int i) {
        this.f44105N = i;
    }

    public int getRequireLevel() {
        return this.f44106O;
    }

    public void setRequireLevel(int i) {
        this.f44106O = i;
    }

    public int getComboType() {
        return this.f44107P;
    }

    public void setComboType(int i) {
        this.f44107P = i;
    }

    public boolean isFormOpenRide() {
        return this.f44108Q;
    }

    public void setFormOpenRide(boolean z) {
        this.f44108Q = z;
    }

    public String getUser_input_price() {
        return this.f44110S;
    }

    public void setUser_input_price(String str) {
        this.f44110S = str;
    }

    public Map<String, Object> convertBean2Map() {
        HashMap hashMap = new HashMap();
        put(hashMap, "token", TEBridge.clientConfig().token());
        Address address = this.f44111a;
        if (address != null) {
            put(hashMap, "from_lng", Double.valueOf(address.getLongitude()));
            put(hashMap, "from_lat", Double.valueOf(this.f44111a.getLatitude()));
            put(hashMap, "from_name", this.f44111a.getDisplayName());
            put(hashMap, "from_address", this.f44111a.getAddress());
            put(hashMap, ParamKeys.PARAM_FROM_AREA, Integer.valueOf(this.f44111a.getCityId()));
            put(hashMap, "from_poi_id", this.f44111a.getUid());
            put(hashMap, ParamKeys.PARAM_START_TYPE_V2, this.f44111a.getSrcTag());
        }
        Address address2 = this.f44112b;
        if (address2 != null) {
            put(hashMap, "to_lng", Double.valueOf(address2.getLongitude()));
            put(hashMap, "to_lat", Double.valueOf(this.f44112b.getLatitude()));
            put(hashMap, "to_name", this.f44112b.getDisplayName());
            put(hashMap, "to_address", this.f44112b.getAddress());
            put(hashMap, ParamKeys.PARAM_TO_POI_UID, this.f44112b.getUid());
            put(hashMap, ParamKeys.PARAM_TO_POI_TYPE, this.f44112b.getSrcTag());
            put(hashMap, ParamKeys.PARAM_TO_AREA, Integer.valueOf(this.f44112b.getCityId()));
        }
        int i = this.f44113c > 0 ? 1 : 0;
        put(hashMap, "order_type", Integer.valueOf(i));
        if (!TextUtils.isEmpty(this.f44094C)) {
            put(hashMap, ParamKeys.PARAM_WAY_POINTS, this.f44094C);
        }
        put(hashMap, ParamKeys.PARAM_CAR_WILL_WAIT, Integer.valueOf(this.f44119i ? 1 : 0));
        LogUtil.m31426d("CarReqest getEstimatePriceCoupon select seat  seatNum" + this.f44123m);
        put(hashMap, ParamKeys.PARAM_POOL_SEAT_V2, Integer.valueOf(this.f44123m));
        if (i == 1) {
            put(hashMap, "departure_time", Long.valueOf(this.f44113c / 1000));
        }
        put(hashMap, "user_type", Integer.valueOf(this.f44114d));
        put(hashMap, "scene_type", Integer.valueOf(this.f44115e));
        if (!TextUtils.isEmpty(this.f44117g)) {
            put(hashMap, ParamKeys.PARAM_PAYMENTS_TYPE, this.f44117g);
        }
        if (!TextUtils.isEmpty(this.f44118h)) {
            put(hashMap, "card_index", this.f44118h);
        }
        put(hashMap, "require_level", this.f44116f);
        if (!TextUtil.isEmpty(this.f44132v)) {
            put(hashMap, ParamKeys.PARAM_DESIGNATED_DRIVER, this.f44132v);
        }
        if (TextUtils.isEmpty(this.f44122l) || this.f44122l.equals(TEBridge.clientConfig().phone())) {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE_V2, 0);
        } else {
            put(hashMap, ParamKeys.PARAM_CALLER_TYPE_V2, 1);
            put(hashMap, ParamKeys.PARAM_CALLER_PHONE_V2, this.f44122l);
        }
        if (!TextUtil.isEmpty(this.f44121k)) {
            put(hashMap, ParamKeys.PARAM_GUIDE_TYPE, this.f44121k);
        }
        if (!TextUtils.isEmpty(this.f44130t)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_TRANSPARENT_DATA, this.f44130t);
        }
        if (this.f44120j) {
            put(hashMap, ParamKeys.PARAM_POOL_STATION, 1);
        }
        if (!TextUtils.isEmpty(this.f44124n)) {
            put(hashMap, ParamKeys.PARAM_COMBO_ID, this.f44124n);
        }
        if (!TextUtils.isEmpty(this.f44125o)) {
            put(hashMap, "activity_id", this.f44125o);
        }
        if (!TextUtils.isEmpty(this.f44128r)) {
            put(hashMap, ParamKeys.PARAM_GUIDE_API_INFO, this.f44128r);
        }
        if (!TextUtil.isEmpty(this.f44126p)) {
            put(hashMap, ParamKeys.PARAM_CURRENT_STATION_ID, this.f44126p);
            put(hashMap, ParamKeys.PARAM_CARPOOL_REQUIRE_TRACE_ID, this.f44127q);
        }
        if (!TextUtils.isEmpty(this.f44129s)) {
            put(hashMap, ParamKeys.PARAM_CUSTOM_FEATURE, this.f44129s);
        }
        if (!TextUtils.isEmpty(this.f44131u)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_ATHENA_PARAMS, this.f44131u);
        }
        if (!TextUtils.isEmpty(this.regionalDepartureTime)) {
            put(hashMap, ParamKeys.PARAM_REGIONAL_DEPARTURE_TIME, this.regionalDepartureTime);
        }
        if (!TextUtils.isEmpty(this.f44133w)) {
            put(hashMap, ParamKeys.PARAM_ONE_CONF, this.f44133w);
        }
        if (!TextUtil.isEmpty(this.f44134x)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_DEP_CODE, this.f44134x);
        }
        if (!TextUtil.isEmpty(this.f44135y)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_DEP_TERMINAL, this.f44135y);
        }
        if (!TextUtil.isEmpty(this.f44136z)) {
            put(hashMap, "airport_id", this.f44136z);
        }
        if (!TextUtil.isEmpty(this.f44093B)) {
            put(hashMap, ParamKeys.PARAM_MENU_ID, this.f44093B);
        }
        put(hashMap, ParamKeys.PARAM_ESTIMATE_FIXEDPRICE, Integer.valueOf(this.fixedPrice ? 1 : 0));
        if (!TextUtil.isEmpty(this.curCompanyId)) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(this.curCompanyId);
            put(hashMap, ParamKeys.PARAM_ESTIMATE_COMPANY_ID, jSONArray.toString());
            put(hashMap, ParamKeys.PARAM_ESTIMATE_ROUTE_LIST, this.routeList);
        }
        if (!TextUtil.isEmpty(this.estimateSceneType)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_SCENE_TYPE, this.estimateSceneType);
        }
        put(hashMap, ParamKeys.PARAM_ESTIMATE_SHIFT_TIME, Long.valueOf(this.f44092A));
        put(hashMap, ParamKeys.PARAM_ENTERPRISE_FLAG, Integer.valueOf(this.enterpriseFlag));
        if (!TextUtil.isEmpty(this.estimateSort)) {
            put(hashMap, ParamKeys.PARAM_ESTIMATE_SORT, this.estimateSort);
        }
        put(hashMap, ParamKeys.PARAM_NEW_UI_TYPE, Integer.valueOf(this.f44095D));
        if (this.f44108Q || this.f44096E == 1) {
            put(hashMap, "product_id", Integer.valueOf(this.f44105N));
            put(hashMap, "combo_type", Integer.valueOf(this.f44107P));
            put(hashMap, "require_level", Integer.valueOf(this.f44106O));
        }
        put(hashMap, ParamKeys.PARAM_NEW_UI_REQUEST_SOURCE, Integer.valueOf(this.f44096E));
        if (!TextUtils.isEmpty(this.f44109R)) {
            put(hashMap, "req_id", this.f44109R);
        }
        put(hashMap, "group_type", this.f44101J);
        Map<String, Object> map = this.f44102K;
        if (map != null) {
            hashMap.put(ParamKeys.POST_BACK_PARAMS, map);
        }
        if (!TextUtils.isEmpty(this.f44110S)) {
            hashMap.put("user_input_price", this.f44110S);
        }
        if (!CollectionUtil.isEmpty((Collection<?>) this.f44103L)) {
            hashMap.put(ParamKeys.PARAM_ANYCAR_PRODUCTS_SELECTED, this.f44103L);
        }
        hashMap.put(ParamKeys.PARAM_ANYCAR_PREFERENCE, Integer.valueOf(this.f44104M));
        HashMap hashMap2 = new HashMap();
        hashMap2.put("select", Long.valueOf(this.f44099H));
        hashMap2.put("default", Long.valueOf(this.f44100I));
        hashMap.put(ParamKeys.PARAM_MULTI_ROUTE_ID_MAP, hashMap2);
        if (this.f44097F > 0) {
            ArrayList arrayList = new ArrayList();
            if (this.f44098G > 0) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("product_id", Integer.valueOf(this.f44098G));
                hashMap3.put("combo_type", Integer.valueOf(this.f44107P));
                hashMap3.put(ParamKeys.PARAM_PASS_BUY_CHOOSE, Integer.valueOf(this.f44097F));
                arrayList.add(hashMap3);
            }
            addParam(ParamKeys.PARAM_PRODUCT_INFO, arrayList);
        }
        return hashMap;
    }

    public String getReqId() {
        return this.f44109R;
    }

    public void setReqId(String str) {
        this.f44109R = str;
    }

    public int getUserType() {
        return this.f44114d;
    }

    public void setUserType(int i) {
        this.f44114d = i;
    }

    public long getDepartureTime() {
        return this.f44113c;
    }

    public void setDepartureTime(long j) {
        this.f44113c = j;
    }

    public Address getStartAddress() {
        return this.f44111a;
    }

    public void setStartAddress(Address address) {
        this.f44111a = address;
    }

    public Address getEndAddress() {
        return this.f44112b;
    }

    public void setEndAddress(Address address) {
        this.f44112b = address;
    }

    public String getCarLevelId() {
        return this.f44116f;
    }

    public void setCarLevelId(String str) {
        this.f44116f = str;
    }

    public String getPaymentsType() {
        return this.f44117g;
    }

    public void setPaymentsType(String str) {
        this.f44117g = str;
    }

    public String getCardIndex() {
        return this.f44118h;
    }

    public void setCardIndex(String str) {
        this.f44118h = str;
    }

    public String getPassengerPhone() {
        return this.f44122l;
    }

    public void setPassengerPhone(String str) {
        this.f44122l = str;
    }

    public int getSceneType() {
        return this.f44115e;
    }

    public void setSceneType(int i) {
        this.f44115e = i;
    }

    public String getGuideType() {
        return this.f44121k;
    }

    public void setGuideType(String str) {
        this.f44121k = str;
    }

    public boolean isWillWait() {
        return this.f44119i;
    }

    public void setWillWait(boolean z) {
        this.f44119i = z;
    }

    public int getSeatNumber() {
        return this.f44123m;
    }

    public void setSeatNumber(int i) {
        this.f44123m = i;
    }

    public boolean isOpenStation() {
        return this.f44120j;
    }

    public void setOpenStation(boolean z) {
        this.f44120j = z;
    }

    public String getTransparentData() {
        return this.f44130t;
    }

    public void setTransparentData(String str) {
        this.f44130t = str;
    }

    public String getComboId() {
        return this.f44124n;
    }

    public void setComboId(String str) {
        this.f44124n = str;
    }

    public String getActivityId() {
        return this.f44125o;
    }

    public void setActivityId(String str) {
        this.f44125o = str;
    }

    public String getGuideApiInfo() {
        return this.f44128r;
    }

    public void setGuideApiInfo(String str) {
        this.f44128r = str;
    }

    public String getCustomFeature() {
        return this.f44129s;
    }

    public void setCustomFeature(String str) {
        this.f44129s = str;
    }

    public String getStationId() {
        return this.f44126p;
    }

    public void setStationId(String str) {
        this.f44126p = str;
    }

    public String getStationTraceId() {
        return this.f44127q;
    }

    public void setStationTraceId(String str) {
        this.f44127q = str;
    }

    public String getAthenaParams() {
        return this.f44131u;
    }

    public void setAthenaParams(String str) {
        this.f44131u = str;
    }

    public void setRegionalDepartureTime(String str) {
        this.regionalDepartureTime = str;
    }

    public String getRegionalDepartureTime() {
        return this.regionalDepartureTime;
    }

    public String getDesignatedDriver() {
        return this.f44132v;
    }

    public void setDesignatedDriver(String str) {
        this.f44132v = str;
    }

    public String getBccInfo() {
        return this.f44133w;
    }

    public void setBccInfo(String str) {
        this.f44133w = str;
    }

    public String getDepatureCode() {
        return this.f44134x;
    }

    public void setDepatureCode(String str) {
        this.f44134x = str;
    }

    public String getDepatureTerminal() {
        return this.f44135y;
    }

    public void setDepatureTerminal(String str) {
        this.f44135y = str;
    }

    public String getAirportId() {
        return this.f44136z;
    }

    public void setAirportId(String str) {
        this.f44136z = str;
    }

    public long getFlightTime() {
        return this.f44092A;
    }

    public void setFlightTime(long j) {
        this.f44092A = j;
    }

    public String getMenuId() {
        return this.f44093B;
    }

    public void setMenuId(String str) {
        this.f44093B = str;
    }

    public String getWayPointAddressList() {
        return this.f44094C;
    }

    public void setWayPointAddressList(String str) {
        this.f44094C = str;
    }

    public void setEnterpriseFlag(int i) {
        this.enterpriseFlag = i;
    }

    public void setNewUIType(int i) {
        this.f44095D = i;
    }

    public void setPassBuyChoose(int i) {
        this.f44097F = i;
    }

    public int getPassBuyChoose() {
        return this.f44097F;
    }

    public void setPassProductId(int i) {
        this.f44098G = i;
    }

    public int getPassProductId() {
        return this.f44098G;
    }

    public long getMultiRouteId() {
        return this.f44099H;
    }

    public void setMultiRouteId(long j) {
        this.f44099H = j;
    }

    public long getDefaultRouteId() {
        return this.f44100I;
    }

    public void setDefaultRouteId(long j) {
        this.f44100I = j;
    }

    public void addPostBackParam(String str, Object obj) {
        if (this.f44102K == null) {
            this.f44102K = new HashMap();
        }
        this.f44102K.put(str, obj);
    }

    public void setSelectProducts(List<JSONObject> list) {
        this.f44103L = list;
    }

    public void setAnyCarPreference(int i) {
        this.f44104M = i;
    }
}
