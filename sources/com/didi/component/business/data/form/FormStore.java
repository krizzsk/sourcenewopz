package com.didi.component.business.data.form;

import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPoint;
import com.didi.address.util.SugWayPointsUtils;
import com.didi.addressold.util.AddressTrack;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.IComponent;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.component.express.ExpressShareStore;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.travel.psnger.model.response.CarConfig;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.DispatchFeeConfig;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.MapLineInfo;
import com.didi.travel.psnger.model.response.MarkerInfo;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.PinCodeInfoResult;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.estimate.CarConfigModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.MapInfoModel;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didi.travel.psnger.model.response.estimate.daijiao.FriendItem;
import com.didi.travel.psnger.model.response.estimate.daijiao.SubstituteCallModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class FormStore {
    public static final int CARPOOL_ORDER_NOT_CARPOOL = -1;
    public static final String KEY_PAY_ENTERPRISE = "store_key_pay_enterprise";
    public static final String KEY_RECALL_ORDER = "store_recall_order";
    public static final int TYPE_CHANGE_ADDRESS_END_ESTIMATE_SUG = 8;
    public static final int TYPE_CHANGE_ADDRESS_START_ESTIMATE_SUG = 4;
    public static final int TYPE_CHANGE_ADDRESS_START_GET_ON_DRAG = 1;
    public static final int TYPE_CHANGE_ADDRESS_START_GET_ON_SUG = 2;

    /* renamed from: A */
    private Map<String, Object> f11200A = new HashMap();

    /* renamed from: B */
    private int f11201B = 0;
    public int Bid;

    /* renamed from: C */
    private boolean f11202C;

    /* renamed from: D */
    private long f11203D = 0;

    /* renamed from: E */
    private List<PayWayModel.PayWayItem> f11204E = new ArrayList();

    /* renamed from: F */
    private String f11205F;

    /* renamed from: G */
    private String f11206G;

    /* renamed from: H */
    private CarInfo f11207H;

    /* renamed from: I */
    private CarInfo f11208I;

    /* renamed from: J */
    private DepartureAddress f11209J;

    /* renamed from: K */
    private int f11210K = 1;

    /* renamed from: L */
    private int[] f11211L;

    /* renamed from: M */
    private String[] f11212M;

    /* renamed from: N */
    private int f11213N = 0;

    /* renamed from: O */
    private int f11214O;

    /* renamed from: P */
    private int f11215P;

    /* renamed from: Q */
    private boolean f11216Q = false;

    /* renamed from: R */
    private CarOrder f11217R;

    /* renamed from: S */
    private boolean f11218S;
    public String Sid;

    /* renamed from: T */
    private boolean f11219T;

    /* renamed from: U */
    private int f11220U;

    /* renamed from: V */
    private List<WayPoint> f11221V = new ArrayList();

    /* renamed from: W */
    private String f11222W;

    /* renamed from: X */
    private TaxiCompanyListModel.CompanyModel f11223X;

    /* renamed from: Y */
    private Map<String, String> f11224Y = new HashMap();

    /* renamed from: Z */
    private boolean f11225Z;

    /* renamed from: a */
    private JSONObject f11226a;

    /* renamed from: aA */
    private String f11227aA;

    /* renamed from: aB */
    private Map<String, Boolean> f11228aB = new HashMap();

    /* renamed from: aC */
    private String f11229aC = "";

    /* renamed from: aD */
    private String f11230aD;

    /* renamed from: aE */
    private EstimateItemModel f11231aE;

    /* renamed from: aF */
    private String f11232aF = "";

    /* renamed from: aG */
    private HashMap<Integer, IComponent> f11233aG = new HashMap<>();

    /* renamed from: aa */
    private int f11234aa = 1;

    /* renamed from: ab */
    private String f11235ab;

    /* renamed from: ac */
    private String f11236ac = "";

    /* renamed from: ad */
    private boolean f11237ad = false;

    /* renamed from: ae */
    private boolean f11238ae = false;

    /* renamed from: af */
    private boolean f11239af = false;

    /* renamed from: ag */
    private Map<String, Object> f11240ag;

    /* renamed from: ah */
    private boolean f11241ah = false;

    /* renamed from: ai */
    private boolean f11242ai = false;

    /* renamed from: aj */
    private long f11243aj;

    /* renamed from: ak */
    private boolean f11244ak = false;

    /* renamed from: al */
    private boolean f11245al = false;

    /* renamed from: am */
    private SugParams.MapSelectOper f11246am = SugParams.MapSelectOper.OTHER;

    /* renamed from: an */
    private boolean f11247an;

    /* renamed from: ao */
    private boolean f11248ao;

    /* renamed from: ap */
    private boolean f11249ap;

    /* renamed from: aq */
    private boolean f11250aq;

    /* renamed from: ar */
    private boolean f11251ar;

    /* renamed from: as */
    private BusinessContext f11252as;

    /* renamed from: at */
    private String f11253at;

    /* renamed from: au */
    private boolean f11254au;

    /* renamed from: av */
    private String f11255av;

    /* renamed from: aw */
    private String f11256aw;

    /* renamed from: ax */
    private String f11257ax;

    /* renamed from: ay */
    private String f11258ay;

    /* renamed from: az */
    private boolean f11259az;

    /* renamed from: b */
    private Address f11260b;

    /* renamed from: c */
    private Address f11261c;

    /* renamed from: d */
    private Address f11262d;

    /* renamed from: e */
    private boolean f11263e = true;

    /* renamed from: f */
    private AddressSrcType f11264f = AddressSrcType.LOC_REVER;

    /* renamed from: g */
    private Address f11265g;

    /* renamed from: h */
    private boolean f11266h;

    /* renamed from: i */
    private boolean f11267i;

    /* renamed from: j */
    private long f11268j;

    /* renamed from: k */
    private int f11269k;

    /* renamed from: l */
    private int f11270l = -1;

    /* renamed from: m */
    private EstimateItem f11271m;
    public SparseBooleanArray mDynamicTipShown = new SparseBooleanArray();

    /* renamed from: n */
    private String f11272n;

    /* renamed from: o */
    private SubstituteCallModel f11273o;

    /* renamed from: p */
    private FriendItem f11274p;

    /* renamed from: q */
    private String f11275q;

    /* renamed from: r */
    private String f11276r;

    /* renamed from: s */
    private boolean f11277s = false;

    /* renamed from: t */
    private boolean f11278t = false;

    /* renamed from: u */
    private boolean f11279u = false;

    /* renamed from: v */
    private int f11280v = 0;

    /* renamed from: w */
    private PinCodeInfoResult f11281w;

    /* renamed from: x */
    private boolean f11282x;

    /* renamed from: y */
    private String f11283y;

    /* renamed from: z */
    private boolean f11284z = false;

    /* renamed from: a */
    private boolean m7615a(Object obj) {
        return true;
    }

    public String getStartParkingProperty() {
        return this.f11235ab;
    }

    public void setStartParkingProperty(String str) {
        this.f11235ab = str;
    }

    public boolean isShowInterceptorPop() {
        return this.f11266h;
    }

    public void setIsShowInterceptorPop(boolean z) {
        this.f11266h = z;
    }

    public boolean isShowRealPicInXpanel() {
        return this.f11267i;
    }

    public void setShowRealPicInXpanel(boolean z) {
        this.f11267i = z;
    }

    public String getPassengerSheetKey() {
        return this.f11236ac;
    }

    public void setPassengerSheetKey(String str) {
        this.f11236ac = str;
    }

    public boolean ismGroupFormViewChanged() {
        return this.f11247an;
    }

    public void setmGroupFormViewChanged(boolean z) {
        this.f11247an = z;
    }

    public String getSubstituteCallIcon() {
        return this.f11255av;
    }

    public void setSubstituteCallIcon(String str) {
        this.f11255av = str;
    }

    public String getSubstituteCallText() {
        return this.f11256aw;
    }

    public void setSubstituteCallText(String str) {
        this.f11256aw = str;
    }

    public SubstituteCallModel getSubstituteCallModel() {
        return this.f11273o;
    }

    public void setSubstituteCallModel(SubstituteCallModel substituteCallModel) {
        this.f11273o = substituteCallModel;
    }

    public boolean isHasSubstituteCall() {
        return this.f11251ar;
    }

    public void setHasSubstituteCall(boolean z) {
        this.f11251ar = z;
    }

    public FriendItem getSelectedFriend() {
        return this.f11274p;
    }

    public void setSelectedFriend(FriendItem friendItem) {
        this.f11274p = friendItem;
    }

    public enum AddressSrcType {
        LOC_REVER(0),
        MAP_DRAG(1),
        SUG_SEARCH(2),
        SUG_RECOMMEND(3),
        HOME(4),
        COMPANY(5),
        FAVORITE(6),
        QUICK_REQ(7),
        BY_USER(8),
        BY_USER_AT_ERROR(9),
        HOME_RECOMMEND(10),
        OTHER_APP(11),
        UNKOWN(99);
        
        private int type;

        private AddressSrcType(int i) {
            this.type = i;
        }

        public int getType() {
            return this.type;
        }
    }

    public Map<String, Object> getSelectValueParams() {
        return this.f11240ag;
    }

    public void setSelectValueParams(Map<String, Object> map) {
        this.f11240ag = map;
    }

    public boolean isInMiniBus() {
        return this.f11250aq;
    }

    public void setIsInMiniBus(boolean z) {
        this.f11250aq = z;
    }

    public void setIsClickGuessDestination(boolean z) {
        this.f11254au = z;
    }

    public boolean getIsClickGuessDestination() {
        return this.f11254au;
    }

    public void setDisplayName(String str) {
        this.f11253at = str;
    }

    public String getDisplayName() {
        return this.f11253at;
    }

    public String getFlex_recommend_price() {
        return this.f11227aA;
    }

    public void setFlex_recommend_price(String str) {
        this.f11227aA = str;
    }

    public String getInputOfferPrice() {
        return this.f11257ax;
    }

    public void setInputOfferPrice(String str) {
        this.f11257ax = str;
    }

    public String getFlex_order_params() {
        return this.f11258ay;
    }

    public void setFlex_order_params(String str) {
        this.f11258ay = str;
    }

    public boolean isFlexOfferPrice() {
        return this.f11259az;
    }

    public void setFlexOfferPrice(boolean z) {
        this.f11259az = z;
    }

    public boolean getIsSeatConfirmDialogShowed(String str) {
        Boolean bool = this.f11228aB.get(str);
        return bool != null && bool.booleanValue();
    }

    public void setIsSeatConfirmDialogShowed(String str, Boolean bool) {
        this.f11228aB.put(str, bool);
    }

    public String getBubbleId() {
        return this.f11229aC;
    }

    public void setBubbleId(String str) {
        this.f11229aC = str;
    }

    public void setMapSelectOper(SugParams.MapSelectOper mapSelectOper) {
        this.f11246am = mapSelectOper;
    }

    public SugParams.MapSelectOper getMapSelectOper() {
        return this.f11246am;
    }

    private static class FormStoreHolder {
        /* access modifiers changed from: private */
        public static final FormStore INSTANCE = new FormStore();

        private FormStoreHolder() {
        }
    }

    public static final FormStore getInstance() {
        return FormStoreHolder.INSTANCE;
    }

    public void initData(String str, int i, int i2) {
        this.Sid = str;
        setBid(i);
        setCurrentComboType(i2);
        m7613a();
    }

    public List<WayPoint> getWayPoints() {
        Address startAddress = getStartAddress();
        Address endAddress = getEndAddress();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WayPoint(1, startAddress));
        for (WayPoint address : this.f11221V) {
            arrayList.add(new WayPoint(2, address.getAddress()));
        }
        arrayList.add(new WayPoint(3, endAddress));
        return arrayList;
    }

    public boolean hasStopPoints() {
        return !this.f11221V.isEmpty();
    }

    public void saveWayPoint(List<WayPoint> list) {
        if (list != null) {
            for (WayPoint next : list) {
                if (next.getWayPointType() == 1) {
                    setStartAddress(next.getAddress());
                } else if (next.getWayPointType() == 3) {
                    setEndAddress(next.getAddress());
                } else if (next.getWayPointType() == 2) {
                    m7614a(next);
                }
            }
        }
    }

    public void clearStopPoints() {
        this.f11221V.clear();
    }

    /* renamed from: a */
    private void m7614a(WayPoint wayPoint) {
        if (wayPoint != null) {
            this.f11221V.add(wayPoint);
        }
    }

    public void setData(String str, Object obj) {
        setData("", str, obj);
    }

    public <T> T getData(String str) throws Exception {
        return getData("", str);
    }

    public void setData(String str, String str2, Object obj) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str + "_";
        }
        if (m7615a(obj)) {
            this.f11200A.put(this.Sid + "_" + str3 + str2, obj);
            return;
        }
        throw new IllegalArgumentException("obj param must be base data type");
    }

    public <T> T getData(String str, String str2) throws Exception {
        String str3;
        if (TextUtils.isEmpty(str)) {
            str3 = "";
        } else {
            str3 = str + "_";
        }
        T t = this.f11200A.get(this.Sid + "_" + str3 + str2);
        if (t != null) {
            return t;
        }
        return null;
    }

    public <T> T getDataSilence(String str) {
        try {
            return getData(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public <T> T getDataSilence(String str, String str2) {
        try {
            return getData(str, str2);
        } catch (Exception unused) {
            return null;
        }
    }

    public int getIntData(String str, int i) {
        return getIntData("", str, i);
    }

    public int getIntData(String str, String str2, int i) {
        Integer num = (Integer) getDataSilence(str, str2);
        if (num == null) {
            return i;
        }
        return num.intValue();
    }

    public boolean getBooleanData(String str, boolean z) {
        return getBooleanData("", str, z);
    }

    public boolean getBooleanData(String str, String str2, boolean z) {
        Boolean bool = (Boolean) getDataSilence(str, str2);
        if (bool == null) {
            return z;
        }
        return bool.booleanValue();
    }

    public Address getGetOnStartAddress() {
        return this.f11262d;
    }

    public void setGetOnStartAddress(Address address) {
        this.f11262d = address;
    }

    public Address getStartAddress() {
        return this.f11260b;
    }

    public void setStartAddress(Address address) {
        setStartAddress(address, this.f11264f, true);
    }

    public void setStartAddressSrcType(AddressSrcType addressSrcType) {
        this.f11264f = addressSrcType;
    }

    public void setStartAddress(Address address, boolean z) {
        setStartAddress(address, this.f11264f, z);
    }

    public void setStartAddress(Address address, AddressSrcType addressSrcType) {
        setStartAddress(address, addressSrcType, true);
    }

    public void setStartAddress(Address address, AddressSrcType addressSrcType, boolean z) {
        this.f11264f = addressSrcType;
        this.f11260b = address;
        this.f11263e = z;
        ExpressShareStore.getInstance().setFromAddress(address);
    }

    @Deprecated
    public CarInfo getLastSelectCarInfo() {
        return this.f11207H;
    }

    @Deprecated
    public void setLastSelectCarInfo(CarInfo carInfo) {
        this.f11207H = carInfo;
    }

    @Deprecated
    public CarInfo getCurrentCarInfo() {
        return this.f11208I;
    }

    @Deprecated
    public void setCurrentCarInfo(CarInfo carInfo) {
        this.f11208I = carInfo;
    }

    public void setDepartureAddress(Address address) {
        this.f11265g = address;
    }

    public Address getDepartureAddress() {
        return this.f11265g;
    }

    public Address getEndAddress() {
        return this.f11261c;
    }

    public void setEndAddress(Address address) {
        this.f11261c = address;
        ExpressShareStore.getInstance().setToAddress(address);
    }

    public AddressSrcType getStartAddressSrcType() {
        return this.f11264f;
    }

    public int getSeatCount() {
        int i = this.f11210K;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public void setSeatCount(int i) {
        this.f11210K = i;
    }

    public int[] getSeatCountArray() {
        return this.f11211L;
    }

    public void setSeatCountArray(int[] iArr) {
        this.f11211L = iArr;
    }

    public String[] getSeatFeeArray() {
        return this.f11212M;
    }

    public void setSeatFeeArray(String[] strArr) {
        this.f11212M = strArr;
    }

    public long getTransportTime() {
        return this.f11268j;
    }

    public String getOrderType() {
        if (getInstance().isQuotaInCurEstimateItem()) {
            return "AirportFixed";
        }
        return getInstance().getTransportTime() > 0 ? "Reservation" : "Realtime";
    }

    public boolean isAddressValid() {
        return (this.f11260b == null || this.f11261c == null) ? false : true;
    }

    public void setTransportTime(long j) {
        this.f11268j = j;
        ExpressShareStore.getInstance().setDepartureTime(j);
    }

    public int getCarLevel() {
        return this.f11269k;
    }

    public void setCarLevel(int i) {
        if (this.f11269k != i) {
            this.f11269k = i;
        }
    }

    public int getCarpoolOrderScene() {
        return this.f11270l;
    }

    public void setCarpoolOrderScene(int i) {
        this.f11270l = i;
    }

    public void setBid(int i) {
        GLog.m7965d("FormStore", "setBid:" + i);
        this.Bid = i;
    }

    public void setCarTypeInfo(int i, int i2, int i3, int i4) {
        if (this.Bid != i || i2 != this.f11213N || i3 != this.f11269k || i4 != this.f11270l) {
            this.f11269k = i3;
            setBid(i);
            setCarpoolOrderScene(i4);
            setCurrentComboType(i2);
        }
    }

    public void setCarTypeInfo(int i, int i2, int i3) {
        if (this.Bid != i || i2 != this.f11213N || i3 != this.f11269k) {
            this.f11269k = i3;
            setBid(i);
            setCurrentComboType(i2);
        }
    }

    public boolean isMatchToGo() {
        return this.f11270l == 2;
    }

    public boolean isNotMatchDiscount() {
        return this.f11270l == 3;
    }

    public EstimateItem getEstimateItem() {
        return this.f11271m;
    }

    public void setEstimateItem(EstimateItem estimateItem) {
        if (this.f11271m != estimateItem) {
            this.f11271m = estimateItem;
        }
    }

    public void setSelectedSeat(String str) {
        this.f11272n = str;
    }

    public String getSelectedSeat() {
        return this.f11272n;
    }

    public CarConfig.ConfirmActionInfo getConfirmActionInfo() {
        EstimateItemModel newEstimateItem = getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carBreakModel == null || newEstimateItem.carBreakModel.carBreakDelivery == null || newEstimateItem.carConfig == null)) {
            try {
                JSONObject jSONObject = new JSONObject(newEstimateItem.carBreakModel.carBreakDelivery.toString());
                return new CarConfig.ConfirmActionInfo(newEstimateItem.carConfig.carProductId + "", jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setPayWay(String str) {
        this.f11275q = str;
    }

    public String getPayWay() {
        return this.f11275q;
    }

    public String getPayWayMsg() {
        return this.f11276r;
    }

    public void setPayWayMsg(String str) {
        this.f11276r = str;
    }

    public List<PayWayModel.PayWayItem> getPayWaySelectedItem() {
        return this.f11204E;
    }

    public void setPayWaySelectedItem(List<PayWayModel.PayWayItem> list) {
        if (list != null && !list.isEmpty()) {
            this.f11204E = list;
            for (PayWayModel.PayWayItem next : list) {
                if (next != null) {
                    this.f11205F = next.cardIndex;
                    this.f11206G = next.cardPrefix;
                }
            }
        }
    }

    public String getCardIndex() {
        String str = this.f11205F;
        return str == null ? "" : str;
    }

    public String getCardPrefix() {
        String str = this.f11206G;
        return str == null ? "" : str;
    }

    public void setCardIndex(String str) {
        this.f11205F = str;
    }

    /* renamed from: a */
    private void m7613a() {
        setStartAddress(new Address(), this.f11264f, true);
        setEndAddress(new Address());
        setTransportTime(ExpressShareStore.getInstance().getDepartureTime());
    }

    public void clear() {
        setEndAddress((Address) null);
        this.f11269k = 0;
        this.f11271m = null;
        this.f11275q = null;
        this.f11200A.clear();
        this.f11284z = false;
        clearChangeAddressTypes();
        this.f11262d = null;
        this.f11202C = false;
        this.f11204E.clear();
        this.f11280v = 0;
        this.f11281w = null;
        this.f11277s = false;
        this.f11278t = false;
        this.f11279u = false;
        this.f11213N = 0;
        this.f11264f = AddressSrcType.LOC_REVER;
        this.f11219T = false;
        this.f11220U = 0;
        this.f11216Q = false;
        this.f11221V.clear();
        this.f11214O = 0;
        this.f11222W = null;
        this.f11223X = null;
        this.f11208I = null;
        this.f11224Y.clear();
        this.f11234aa = 1;
        this.f11266h = false;
        this.f11267i = false;
        this.f11237ad = false;
        this.f11238ae = false;
        this.f11239af = false;
        this.f11226a = null;
        this.f11230aD = null;
        this.f11231aE = null;
        this.f11209J = null;
        this.f11236ac = "";
        this.f11229aC = "";
        this.f11228aB.clear();
        this.f11241ah = false;
        this.f11242ai = false;
        this.f11243aj = 0;
        this.f11244ak = false;
        this.f11245al = false;
        this.f11254au = false;
        this.f11255av = null;
        this.f11256aw = null;
        this.f11273o = null;
        this.f11274p = null;
        this.f11257ax = null;
        this.f11258ay = null;
        this.f11259az = false;
    }

    public void clearAllTypeData(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str + "_";
        }
        String str3 = this.Sid + "_" + str2;
        Iterator<String> it = this.f11200A.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                String next = it.next();
                if (next.startsWith(str3)) {
                    it.remove();
                    this.f11200A.remove(next);
                }
            }
        }
    }

    public boolean isNeedNearRoad() {
        return this.f11263e;
    }

    public void setNeedNearRoad(boolean z) {
        this.f11263e = z;
    }

    public void setShowPayWayAfterEstimate(boolean z) {
        this.f11284z = z;
    }

    public boolean isShowPayWayAfterEstimate() {
        return this.f11284z;
    }

    public void addChangeAddressTypes(int i) {
        this.f11201B = i | this.f11201B;
    }

    public void removeChangeAddressTypes(int i) {
        this.f11201B = (~i) & this.f11201B;
    }

    public void clearChangeAddressTypes() {
        this.f11201B = 0;
    }

    public boolean hasChangeAddressType(int i) {
        return (i & this.f11201B) != 0;
    }

    public boolean isAccessibleCar() {
        return this.f11202C;
    }

    public void setAccessibleCar(boolean z) {
        this.f11202C = z;
    }

    public void setEstimateTime(long j) {
        this.f11203D = j;
    }

    public long getEstimateTime() {
        return this.f11203D;
    }

    public DepartureAddress getAirPotAddress() {
        return this.f11209J;
    }

    public void setAirPotAddress(DepartureAddress departureAddress) {
        this.f11209J = departureAddress;
    }

    public int getCurrentComboType() {
        return this.f11213N;
    }

    public void setCurrentComboType(int i) {
        this.f11213N = i;
        GlobalOmegaUtils.putGlobal("g_ComboType", Integer.valueOf(i));
    }

    public CarOrder getCreateFailOrder() {
        return this.f11217R;
    }

    public void setCreateFailOrder(CarOrder carOrder) {
        this.f11217R = carOrder;
    }

    public int getCarpoolRadius() {
        return this.f11215P;
    }

    public void setCarpoolRadius(int i) {
        this.f11215P = i;
    }

    public boolean isCarpoolShow() {
        return this.f11216Q;
    }

    public void setCarpoolShow(boolean z) {
        this.f11216Q = z;
        GlobalOmegaUtils.trackEvent("pas_confirm_allcar_sw", z ? "1" : "0");
    }

    public boolean isSkipEstimateGet() {
        return this.f11218S;
    }

    public void setSkipEstimateGet(boolean z) {
        this.f11218S = z;
    }

    public void setIsFromOpenRide(boolean z) {
        this.f11277s = z;
    }

    public boolean isFromOpenRide() {
        return this.f11277s || BusinessDataUtil.isOpenRideOrder(CarOrderHelper.getOrder());
    }

    public void setIsOpenRideFromDeepLink(boolean z) {
        this.f11278t = z;
    }

    public boolean isOpenRideFromDeepLink() {
        return this.f11278t;
    }

    public void setIsOpenRideFromDeepLinkBindCardSuc(boolean z) {
        this.f11279u = z;
    }

    public boolean isOpenRideFromDeepLinkBindCardSuc() {
        return this.f11279u;
    }

    public void setDriverCode(int i) {
        this.f11280v = i;
    }

    public int getDriverCode() {
        return this.f11280v;
    }

    public PinCodeInfoResult getDriverInfo() {
        return this.f11281w;
    }

    public void setDriverInfo(PinCodeInfoResult pinCodeInfoResult) {
        this.f11281w = pinCodeInfoResult;
    }

    public void setOpenRideHasOnlinePayAbility(boolean z) {
        this.f11282x = z;
    }

    public boolean getOpenRideHasOnlinePayAbility() {
        return this.f11282x;
    }

    public void setOpenRideBrand(String str) {
        this.f11283y = str;
    }

    public String getOpenRideBrand() {
        return this.f11283y;
    }

    public boolean isCarPoolLineBeforeHaveOrder() {
        return getCurrentComboType() == 4;
    }

    public boolean isQuotaInCurEstimateItem() {
        EstimateItemModel newEstimateItem = getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.countPriceType != 100) {
            return false;
        }
        return true;
    }

    public boolean isCountPriceTypeFixed() {
        EstimateItemModel newEstimateItem = getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.countPriceType != 2) {
            return false;
        }
        return true;
    }

    public void updateStartAddressSrcTypeBySug() {
        switch (AddressTrack.getAddressSrcByType(1)) {
            case 1:
                setStartAddressSrcType(AddressSrcType.MAP_DRAG);
                return;
            case 2:
                setStartAddressSrcType(AddressSrcType.SUG_RECOMMEND);
                return;
            case 3:
                setStartAddressSrcType(AddressSrcType.SUG_SEARCH);
                return;
            case 4:
                setStartAddressSrcType(AddressSrcType.HOME);
                return;
            case 5:
                setStartAddressSrcType(AddressSrcType.COMPANY);
                return;
            case 6:
                setStartAddressSrcType(AddressSrcType.FAVORITE);
                return;
            default:
                return;
        }
    }

    public void setNearbyCarNum(int i) {
        this.f11220U = i;
    }

    public int getNearbyCarNum() {
        return this.f11220U;
    }

    public void setShowNearCarMsg(boolean z) {
        this.f11219T = z;
    }

    public boolean isShowNearCarMsg() {
        return this.f11219T;
    }

    public void setWayPointAddressList(String str) {
        this.f11221V = SugWayPointsUtils.getWayPointListFromJson(str);
    }

    public String getWayPointAddressListJsonArray() {
        return SugWayPointsUtils.getJsonStrFromWayPoints(this.f11221V);
    }

    public List<WayPoint> getWayPointAddressList() {
        return this.f11221V;
    }

    public int getEta() {
        return this.f11214O;
    }

    public void setEta(int i) {
        this.f11214O = i;
    }

    public String getFlightNum() {
        return this.f11222W;
    }

    public void setFlightNum(String str) {
        this.f11222W = str;
    }

    public void setCurCompany(TaxiCompanyListModel.CompanyModel companyModel) {
        this.f11223X = companyModel;
    }

    public TaxiCompanyListModel.CompanyModel getCurCompany() {
        return this.f11223X;
    }

    public boolean isShowingPopupCompoent() {
        return this.f11225Z;
    }

    public void setShowingPopupCompoent(boolean z) {
        this.f11225Z = z;
    }

    public Map<String, String> getPayedWay() {
        return this.f11224Y;
    }

    public void setPayedWay(Map<String, String> map) {
        this.f11224Y = map;
    }

    public int getEnterpriseFlag() {
        return this.f11234aa;
    }

    public void setEnterpriseFlag(int i) {
        this.f11234aa = i;
    }

    public boolean isTwoPriceBiz() {
        return this.f11237ad;
    }

    public void setTwoPriceBiz(boolean z) {
        this.f11237ad = z;
    }

    public boolean isTwoPriceSeatConfirm() {
        return this.f11238ae;
    }

    public void setTwoPriceSeatConfirm(boolean z) {
        this.f11238ae = z;
    }

    public boolean isShiftSelected() {
        return this.f11239af;
    }

    public void setShiftSelected(boolean z) {
        this.f11239af = z;
    }

    public boolean isOrderBan() {
        return this.f11248ao;
    }

    public void setOrderBan(boolean z) {
        this.f11248ao = z;
    }

    public boolean isSafetyTrain() {
        return this.f11249ap;
    }

    public void setSafetyTrain(boolean z) {
        this.f11249ap = z;
    }

    public JSONObject getDeliveryInfo() {
        return this.f11226a;
    }

    public void setDeliveryInfo(JSONObject jSONObject) {
        this.f11226a = jSONObject;
    }

    public void setEstimatePassConfirm(boolean z) {
        this.f11241ah = z;
    }

    public boolean isEstimatePassConfirm() {
        return this.f11241ah;
    }

    public void setIsHasEstimatePassData(boolean z) {
        this.f11242ai = z;
    }

    public boolean isHasEstimatePassData() {
        return this.f11242ai;
    }

    public void setIsPassShowDialog(boolean z) {
        this.f11244ak = z;
    }

    public boolean getIsPassShowDialog() {
        return this.f11244ak;
    }

    public void setIsDialogPassConfirm(boolean z) {
        this.f11245al = z;
    }

    public boolean getIsDialogPassConfirm() {
        return this.f11245al;
    }

    public long getPassPackageId() {
        return this.f11243aj;
    }

    public void setPassPackageId(long j) {
        this.f11243aj = j;
    }

    public HashMap<Integer, IComponent> getCarOprationComponet() {
        return this.f11233aG;
    }

    public void setEstimateModelTraceId(String str) {
        this.f11230aD = str;
    }

    public String getEstimateModelTraceId() {
        return this.f11230aD;
    }

    public void setNewEstimateItem(EstimateItemModel estimateItemModel) {
        this.f11231aE = estimateItemModel;
        if (estimateItemModel != null) {
            if (estimateItemModel.carConfig != null) {
                CarConfigModel carConfigModel = estimateItemModel.carConfig;
                setCarLevel(carConfigModel.carLevel);
                setCarpoolRadius(carConfigModel.carCircleRadius);
                setCurrentComboType(carConfigModel.carComboType);
                setCarTypeInfo(carConfigModel.carBussinessId, carConfigModel.carComboType, carConfigModel.carLevel);
                setCarpoolOrderScene(-1);
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration = estimateItemModel.twoPriceChoice;
            if (newEstimateChoosedOpration == null || newEstimateChoosedOpration.selectedValue == null || newEstimateChoosedOpration.selectedValue.isEmpty() || newEstimateChoosedOpration.selectedValue.equals("0")) {
                setTwoPriceBiz(false);
            } else {
                setTwoPriceBiz(true);
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration2 = estimateItemModel.dispatchFeeChoice;
            if (!(newEstimateChoosedOpration2 == null || newEstimateChoosedOpration2.selectedValue == null || newEstimateChoosedOpration2.selectedValue.isEmpty())) {
                DispatchFeeConfig.DispatchFee dispatchFee = new DispatchFeeConfig.DispatchFee();
                try {
                    dispatchFee.value = new BigDecimal(newEstimateChoosedOpration2.selectedValue);
                    dispatchFee.name = newEstimateChoosedOpration2.selectedText.getContent();
                    dispatchFee.selectedName = newEstimateChoosedOpration2.selectedText.getContent();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration3 = estimateItemModel.extraChoice;
            if (newEstimateChoosedOpration3 == null || newEstimateChoosedOpration3.selectedValue == null || newEstimateChoosedOpration3.selectedValue.isEmpty() || newEstimateChoosedOpration3.selectedValue.equals("0")) {
                setAccessibleCar(false);
            } else {
                setAccessibleCar(true);
            }
            NewEstimateChoosedOpration newEstimateChoosedOpration4 = estimateItemModel.estimatePass;
            if (newEstimateChoosedOpration4 == null || newEstimateChoosedOpration4.selectedValue == null || newEstimateChoosedOpration4.selectedValue.isEmpty() || newEstimateChoosedOpration4.selectedValue.equals("0")) {
                setEstimatePassConfirm(false);
            } else {
                setEstimatePassConfirm(true);
            }
            setEstimateItem(estimateItemModel.oldEstimateItem);
        }
    }

    public EstimateItemModel getNewEstimateItem() {
        return this.f11231aE;
    }

    public BusinessContext getBusinessContext() {
        return this.f11252as;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f11252as = businessContext;
    }

    public String getInfoList() {
        return this.f11232aF;
    }

    public void setInfoList(String str) {
        this.f11232aF = str;
    }

    public boolean isBubbleShowCarpoolStyle() {
        return m7616b() != null && m7616b().routeType == 2;
    }

    public boolean isBubbleEnablePassingPoint() {
        MapInfoModel b = m7616b();
        return b != null && b.isEnablePassingPoint();
    }

    public String getConfirmPickupSubTitle() {
        MapInfoModel b = m7616b();
        return (b == null || TextUtils.isEmpty(b.confirmPickupSubText)) ? "" : b.confirmPickupSubText;
    }

    public int getBubbleRouteType() {
        MapInfoModel b = m7616b();
        if (b != null) {
            return b.routeType;
        }
        return 0;
    }

    public List<MapLineInfo> getLineInfo() {
        MapInfoModel b = m7616b();
        if (b == null) {
            return null;
        }
        return b.lineInfo;
    }

    public List<MarkerInfo> getMarkerInfo() {
        MapInfoModel b = m7616b();
        if (b == null) {
            return null;
        }
        return b.markerInfo;
    }

    /* renamed from: b */
    private MapInfoModel m7616b() {
        EstimateItemModel newEstimateItem = getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.mapInfoModel == null) {
            return null;
        }
        return newEstimateItem.mapInfoModel;
    }
}
