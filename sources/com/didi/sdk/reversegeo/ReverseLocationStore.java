package com.didi.sdk.reversegeo;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.common.map.Map;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.BusinessParamsUtil;
import com.didi.sdk.util.SingletonHolder;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.PoiInfoParam;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import java.io.IOException;
import java.util.Collection;

public class ReverseLocationStore extends BaseStore {
    public static final String ACTION_REVERSE_ADDRESS_SUCCESS = "action_reverse_address_success";

    /* renamed from: a */
    private static final String f37124a = "reverse-debug";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Logger f37125b = LoggerFactory.getLogger("ReverseLocationStore");

    /* renamed from: c */
    private static final String f37126c = "city_data";

    /* renamed from: d */
    private static final String f37127d = "city_name";

    /* renamed from: e */
    private static final String f37128e = "city_id";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Address f37129f;

    /* renamed from: g */
    private int f37130g = -1;

    /* renamed from: h */
    private String f37131h;

    /* renamed from: i */
    private double f37132i;

    /* renamed from: j */
    private double f37133j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f37134k;

    /* renamed from: l */
    private int f37135l;

    /* renamed from: m */
    private Map f37136m;

    /* renamed from: n */
    private SharedPreferences f37137n;

    public static ReverseLocationStore getsInstance() {
        return (ReverseLocationStore) SingletonHolder.getInstance(ReverseLocationStore.class);
    }

    private ReverseLocationStore() {
        super("framework-ReverseLocationStore");
    }

    public void setMap(Map map) {
        this.f37136m = map;
    }

    public void reverseLocAddress(Context context, ILocation iLocation, int i) {
        ILocation iLocation2 = iLocation;
        if (iLocation2 != null) {
            DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
            if (lastLocation != null) {
                f37125b.infoEvent(f37124a, f37124a, "ReverseLocationStore get reverse address from server");
                reverseCurLocation(context, i, lastLocation.getLatitude(), lastLocation.getLongitude(), lastLocation.getAccuracy(), lastLocation.getProvider(), (FetchCallback<Address>) null);
                return;
            }
            f37125b.infoEvent(f37124a, f37124a, "ReverseLocationStore tencentLocation is null addLocationListener ");
            LocationPerformer.getInstance().addLocationListener(new LocationListener(context, this, iLocation2, i));
        }
    }

    public synchronized Address getCurAddress() {
        return this.f37129f;
    }

    public void save(String str, String str2, Context context) {
        SharedPreferences.Editor edit = m26317a(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public void save(String str, int i, Context context) {
        SharedPreferences.Editor edit = m26317a(context).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public synchronized int getCityId() {
        return this.f37130g;
    }

    public void setCityId(int i) {
        this.f37130g = i;
    }

    public synchronized String getCityName() {
        return this.f37131h;
    }

    public String getCachedCityName(Context context) {
        return m26317a(context).getString("city_name", "");
    }

    public int getCachedCityId(Context context) {
        int i = this.f37130g;
        if (i != -1) {
            return i;
        }
        return m26317a(context).getInt("city_id", -1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Address m26322a(RpcPoi rpcPoi, Context context) {
        if (rpcPoi == null) {
            f37125b.infoEvent(f37124a, f37124a, "ReverseLocationStore reverseLocToAddress has no data");
            return null;
        }
        Address b = m26328b(rpcPoi);
        synchronized (this) {
            this.f37130g = b.cityId;
            this.f37131h = b.cityName;
        }
        save("city_id", this.f37130g, context);
        save("city_name", this.f37131h, context);
        return b;
    }

    public void reverseCurLocation(Context context, int i, double d, double d2, float f, String str, FetchCallback<Address> fetchCallback) {
        final Context context2 = context;
        if (context2 != null) {
            Logger logger = f37125b;
            StringBuilder sb = new StringBuilder();
            sb.append("ReverseLocationStore reverseCurLocation bizId =  ");
            sb.append(i);
            sb.append(" lat = ");
            sb.append(d);
            sb.append(" lng = ");
            double d3 = d2;
            sb.append(d3);
            logger.infoEvent(f37124a, f37124a, sb.toString());
            if (!m26326a(d, d3, fetchCallback)) {
                f37125b.infoEvent(f37124a, f37124a, "reverseCurLocation no need update ");
                return;
            }
            final FetchCallback<Address> fetchCallback2 = fetchCallback;
            m26324a(context, i, d, d2, f, str, new IHttpListener<ReverseStationsInfo>() {
                public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                    if (reverseStationsInfo == null || reverseStationsInfo.errno != 0 || CollectionUtil.isEmpty((Collection<?>) reverseStationsInfo.result)) {
                        ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore reverseCurLocation is null or has error");
                        FetchCallback fetchCallback = fetchCallback2;
                        if (fetchCallback != null) {
                            fetchCallback.onFail(-1);
                            return;
                        }
                        return;
                    }
                    RpcPoi rpcPoi = reverseStationsInfo.result.get(0);
                    synchronized (ReverseLocationStore.this) {
                        Address unused = ReverseLocationStore.this.f37129f = ReverseLocationStore.this.m26322a(rpcPoi, context2);
                        if (ReverseLocationStore.this.f37129f != null && !ReverseLocationStore.this.f37134k) {
                            ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore reverseCurLocation dispatch event: ACTION_REVERSE_ADDRESS_SUCCESS");
                            ReverseLocationStore.this.dispatchEvent(new DefaultEvent(ReverseLocationStore.ACTION_REVERSE_ADDRESS_SUCCESS));
                            boolean unused2 = ReverseLocationStore.this.f37134k = true;
                        }
                    }
                    FetchCallback fetchCallback2 = fetchCallback2;
                    if (fetchCallback2 != null) {
                        fetchCallback2.onSuccess(ReverseLocationStore.this.f37129f);
                    }
                }

                public void onFail(IOException iOException) {
                    ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore reverseCurLocation onFail");
                    FetchCallback fetchCallback = fetchCallback2;
                    if (fetchCallback != null) {
                        fetchCallback.onFail(-1);
                    }
                }
            });
        }
    }

    public void fetchReverseLocation(Context context, int i, double d, double d2, float f, String str, FetchCallback<Address> fetchCallback) {
        if (context != null) {
            Logger logger = f37125b;
            StringBuilder sb = new StringBuilder();
            sb.append("ReverseLocationStore fetchReverseLocation bizId =  ");
            int i2 = i;
            sb.append(i);
            sb.append(" lat = ");
            sb.append(d);
            sb.append(" lng = ");
            sb.append(d2);
            logger.infoEvent(f37124a, f37124a, sb.toString());
            final FetchCallback<Address> fetchCallback2 = fetchCallback;
            m26324a(context, i, d, d2, f, str, new IHttpListener<ReverseStationsInfo>() {
                public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                    if (reverseStationsInfo == null || reverseStationsInfo.errno != 0 || CollectionUtil.isEmpty((Collection<?>) reverseStationsInfo.result)) {
                        ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore ReverseLocation is null or has error");
                        FetchCallback fetchCallback = fetchCallback2;
                        if (fetchCallback != null) {
                            fetchCallback.onFail(-1);
                            return;
                        }
                        return;
                    }
                    Address a = ReverseLocationStore.m26328b(reverseStationsInfo.result.get(0));
                    FetchCallback fetchCallback2 = fetchCallback2;
                    if (fetchCallback2 != null) {
                        fetchCallback2.onSuccess(a);
                    }
                }

                public void onFail(IOException iOException) {
                    ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore fetchReverseLocation onFail");
                    FetchCallback fetchCallback = fetchCallback2;
                    if (fetchCallback != null) {
                        fetchCallback.onFail(-1);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m26324a(Context context, int i, double d, double d2, float f, String str, final IHttpListener<ReverseStationsInfo> iHttpListener) {
        f37125b.infoEvent(f37124a, f37124a, "ReverseLocationStore reverseLocation from net ");
        PoiInfoParam poiInfoParam = new PoiInfoParam();
        poiInfoParam.productId = String.valueOf(BusinessParamsUtil.getProductId(ConfProxy.getInstance().getSelectedType()));
        poiInfoParam.select_lng = d2;
        poiInfoParam.select_lat = d;
        poiInfoParam.user_loc_lng = d2;
        poiInfoParam.user_loc_lat = d;
        poiInfoParam.isFence = true;
        poiInfoParam.accuracy = f;
        poiInfoParam.provider = str;
        poiInfoParam.lang = NationTypeUtil.getNationComponentData().getGLang();
        Map map = this.f37136m;
        if (map != null) {
            poiInfoParam.mapType = map.getMapVendor().toString();
        }
        NationComponentData.LoginInfo loginInfo = NationTypeUtil.getNationComponentData().getLoginInfo();
        if (!TextUtil.isEmpty(loginInfo.getPhone())) {
            poiInfoParam.phone = loginInfo.getPhone();
        }
        if (!TextUtil.isEmpty(loginInfo.getUid())) {
            poiInfoParam.uid = loginInfo.getUid();
        }
        poiInfoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        poiInfoParam.cityId = PaxEnvironment.getInstance().getCityId();
        poiInfoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        poiInfoParam.token = PaxEnvironment.getInstance().getToken();
        poiInfoParam.callFrom = CallFrom.SAFETOOLKIT;
        PoiBaseApiFactory.createDidiApi(context).fetchPoiInfo(poiInfoParam, new IHttpListener<ReverseStationsInfo>() {
            public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                IHttpListener iHttpListener = iHttpListener;
                if (iHttpListener != null) {
                    iHttpListener.onSuccess(reverseStationsInfo);
                }
            }

            public void onFail(IOException iOException) {
                ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore fetchReverseLocation onFail");
                IHttpListener iHttpListener = iHttpListener;
                if (iHttpListener != null) {
                    iHttpListener.onFail(iOException);
                }
            }
        });
    }

    public void fetchReverseLocation(Context context, int i, double d, double d2, FetchCallback<Address> fetchCallback) {
        if (context != null) {
            f37125b.infoEvent(f37124a, f37124a, "ReverseLocationStore fetchReverseLocation : use  old api version!  Use new api instead!");
            fetchReverseLocation(context, i, d, d2, 0.0f, "", fetchCallback);
        }
    }

    /* renamed from: a */
    private boolean m26326a(double d, double d2, FetchCallback<Address> fetchCallback) {
        if (Math.floor(this.f37132i * 1000000.0d) != Math.floor(d * 1000000.0d) || Math.floor(this.f37133j * 1000000.0d) != Math.floor(1000000.0d * d2) || this.f37129f == null || fetchCallback == null) {
            this.f37132i = d;
            this.f37133j = d2;
            return true;
        }
        f37125b.infoEvent(f37124a, f37124a, "ReverseLocationStore location is the same to last location ");
        fetchCallback.onSuccess(this.f37129f);
        return false;
    }

    private static class LocationListener implements ILocation.ILocationChangedListener {
        private int bizId;
        private Context mContext;
        private ILocation mLocation;
        private ReverseLocationStore mStore;

        LocationListener(Context context, ReverseLocationStore reverseLocationStore, ILocation iLocation, int i) {
            this.mStore = reverseLocationStore;
            this.mLocation = iLocation;
            this.mContext = context;
            this.bizId = i;
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore onLocationChanged onLocationChanged------------- ");
            if (dIDILocation == null) {
                ReverseLocationStore.f37125b.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore onLocationChanged is null ------------- ");
                return;
            }
            Logger a = ReverseLocationStore.f37125b;
            a.infoEvent(ReverseLocationStore.f37124a, ReverseLocationStore.f37124a, "ReverseLocationStore onLocationChanged lat= " + dIDILocation.getLatitude() + " lng = " + dIDILocation.getLongitude() + " ------------- ");
            this.mStore.reverseCurLocation(this.mContext, this.bizId, dIDILocation.getLatitude(), dIDILocation.getLongitude(), dIDILocation.getAccuracy(), dIDILocation.getProvider(), (FetchCallback<Address>) null);
            LocationPerformer.getInstance().removeLocationListener(this);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static Address m26328b(RpcPoi rpcPoi) {
        Address address = new Address();
        try {
            address.latitude = Double.valueOf(rpcPoi.base_info.lat).doubleValue();
            address.longitude = Double.valueOf(rpcPoi.base_info.lng).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rpcPoi.base_info != null) {
            address.address = rpcPoi.base_info.address;
            address.displayName = rpcPoi.base_info.displayname;
            address.fullName = rpcPoi.base_info.fullname;
            address.srcTag = rpcPoi.base_info.srctag;
            address.uid = rpcPoi.base_info.poi_id;
            address.weight = rpcPoi.base_info.weight;
            address.cityId = rpcPoi.base_info.city_id;
            address.cityName = rpcPoi.base_info.city_name;
        }
        address.geofence = rpcPoi.geofence;
        if (rpcPoi.extend_info != null) {
            address.business_district = rpcPoi.extend_info.business_district;
            address.count = rpcPoi.extend_info.count;
        }
        return address;
    }

    /* renamed from: a */
    private SharedPreferences m26317a(Context context) {
        if (this.f37137n == null) {
            this.f37137n = SystemUtils.getSharedPreferences(context, f37126c, 0);
        }
        return this.f37137n;
    }
}
