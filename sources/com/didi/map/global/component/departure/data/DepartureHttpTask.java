package com.didi.map.global.component.departure.data;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.Map;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.departure.data.store.DepartureDataStore;
import com.didi.map.global.component.departure.model.ApiType;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.store.FetchCallback;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.google.gson.JsonObject;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.IPoiBaseApi;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.PoiInfoParam;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public final class DepartureHttpTask implements IDepartureHttpTask {

    /* renamed from: a */
    private static final String f25046a = "DepartureHttpTask";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public DepartureHttpTaskParam f25047b;

    /* renamed from: c */
    private Context f25048c;

    /* renamed from: d */
    private Map f25049d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f25050e = false;

    /* renamed from: f */
    private Handler f25051f = new Handler(Looper.getMainLooper());

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f25048c = context;
        this.f25049d = map;
    }

    public void destroy() {
        this.f25047b = null;
        this.f25049d = null;
        this.f25048c = null;
        Handler handler = this.f25051f;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f25051f = null;
        }
    }

    public void setConfigParam(DepartureHttpTaskParam departureHttpTaskParam) {
        this.f25047b = departureHttpTaskParam;
    }

    public void start() {
        ReverseStationsInfo findSameAddr;
        DepartureHttpTaskParam departureHttpTaskParam = this.f25047b;
        if (departureHttpTaskParam != null && departureHttpTaskParam.locationInfo != null && !this.f25050e) {
            this.f25050e = true;
            DepartureDataStore.getInstance().setPinLocation(this.f25047b.locationInfo.latLng);
            if (!this.f25047b.isNeedCache || (findSameAddr = DepartureDataStore.getInstance().findSameAddr(this.f25049d, this.f25047b.locationInfo.latLng)) == null) {
                DepartureHttpTaskParam departureHttpTaskParam2 = this.f25047b;
                if (!(departureHttpTaskParam2 == null || departureHttpTaskParam2.listener == null)) {
                    this.f25047b.listener.onPrepare(this.f25047b.locationInfo.latLng, this.f25047b.taskID);
                }
                m17894a();
                return;
            }
            DLog.m7384d(f25046a, "find address in store ,  result  : " + findSameAddr, new Object[0]);
            DepartureHttpTaskParam departureHttpTaskParam3 = this.f25047b;
            if (departureHttpTaskParam3 != null && departureHttpTaskParam3.listener != null) {
                this.f25051f.postDelayed(new Runnable(findSameAddr) {
                    public final /* synthetic */ ReverseStationsInfo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        DepartureHttpTask.this.m17903c(this.f$1);
                    }
                }, 150);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m17903c(ReverseStationsInfo reverseStationsInfo) {
        this.f25047b.listener.onSuccess(reverseStationsInfo, this.f25047b.taskID);
    }

    public void stop() {
        this.f25050e = false;
    }

    /* renamed from: a */
    private void m17894a() {
        m17896a((FetchCallback<ReverseStationsInfo>) new FetchCallback<ReverseStationsInfo>() {
            public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                DepartureHttpTask.this.m17897a(reverseStationsInfo);
                if (!(DepartureHttpTask.this.f25047b == null || DepartureHttpTask.this.f25047b.locationInfo == null)) {
                    DepartureDataStore.getInstance().setReverseResult(reverseStationsInfo, DepartureHttpTask.this.f25047b.locationInfo.latLng);
                }
                if (DepartureHttpTask.this.f25047b != null && DepartureHttpTask.this.f25047b.listener != null && DepartureHttpTask.this.f25050e) {
                    DepartureHttpTask.this.f25047b.listener.onSuccess(reverseStationsInfo, DepartureHttpTask.this.f25047b.taskID);
                }
            }

            public void onFail(int i) {
                if (DepartureHttpTask.this.f25047b != null && DepartureHttpTask.this.f25047b.listener != null && DepartureHttpTask.this.f25050e) {
                    DepartureHttpTask.this.f25047b.listener.onFail(i, DepartureHttpTask.this.f25047b.taskID);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17897a(ReverseStationsInfo reverseStationsInfo) {
        if (!CollectionUtil.isEmpty((Collection<?>) reverseStationsInfo.recStartPoints) && reverseStationsInfo.recStartPoints.get(0).base_info != null) {
            RpcPoi rpcPoi = reverseStationsInfo.recStartPoints.get(0);
            RpcPoi rpcPoi2 = new RpcPoi();
            rpcPoi2.base_info = rpcPoi.base_info.clone();
            rpcPoi2.base_info.is_recommend_absorb = 0;
            rpcPoi2.base_info.lat = rpcPoi.base_info.lat + 1.0E-6d;
            reverseStationsInfo.recStartPoints.add(rpcPoi2);
        }
    }

    /* renamed from: a */
    private void m17896a(FetchCallback<ReverseStationsInfo> fetchCallback) {
        DepartureHttpTaskParam departureHttpTaskParam = this.f25047b;
        if (departureHttpTaskParam != null && departureHttpTaskParam.locationInfo != null) {
            if (this.f25047b.apiType == ApiType.DEPARTURE_POI_INFO) {
                m17902c(fetchCallback);
            } else {
                m17899b(fetchCallback);
            }
        }
    }

    /* renamed from: b */
    private void m17899b(final FetchCallback<ReverseStationsInfo> fetchCallback) {
        IPoiBaseApi createDidiApi = PoiBaseApiFactory.createDidiApi(this.f25048c);
        final ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
        Map map = this.f25049d;
        reverseGeoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
        reverseGeoParam.select_lng = this.f25047b.locationInfo.latLng.longitude;
        reverseGeoParam.select_lat = this.f25047b.locationInfo.latLng.latitude;
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f25048c).getLastKnownLocation();
        if (lastKnownLocation != null) {
            reverseGeoParam.user_loc_lat = lastKnownLocation.getLatitude();
            reverseGeoParam.user_loc_lng = lastKnownLocation.getLongitude();
            reverseGeoParam.accuracy = lastKnownLocation.getAccuracy();
            reverseGeoParam.provider = lastKnownLocation.getProvider();
        }
        reverseGeoParam.callFrom = this.f25047b.reqCallerId == null ? CallFrom.UNKNOWN : this.f25047b.reqCallerId;
        reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
        reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
        reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
        reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
        reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        DLog.m7384d(f25046a, "reverseGeo params = " + reverseGeoParam, new Object[0]);
        createDidiApi.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                ReverseStationsInfo a = DepartureHttpTask.this.m17892a(reverseGeoResult);
                DepartureHttpTask.this.m17900b(a);
                if (!(reverseGeoParam == null || a == null)) {
                    DLog.m7384d(DepartureHttpTask.f25046a, "reverseGeo response, index " + Integer.toHexString(reverseGeoParam.hashCode()) + "; result  : " + a.toString(), new Object[0]);
                }
                FetchCallback fetchCallback = fetchCallback;
                if (fetchCallback == null) {
                    return;
                }
                if (a == null) {
                    fetchCallback.onFail(-1);
                } else if (a.errno != 0) {
                    fetchCallback.onFail(a.errno);
                } else if (!CollectionUtil.isEmpty((Collection<?>) a.getRecStartPoints()) || !CollectionUtil.isEmpty((Collection<?>) a.getList())) {
                    fetchCallback.onSuccess(a);
                } else {
                    fetchCallback.onFail(-1);
                }
            }

            public void onFail(IOException iOException) {
                if (iOException == null || !"Canceled".equals(iOException.getMessage())) {
                    FetchCallback fetchCallback = fetchCallback;
                    if (fetchCallback != null) {
                        fetchCallback.onFail(-1);
                        return;
                    }
                    return;
                }
                DLog.m7384d(DepartureHttpTask.f25046a, "取消了请求", new Object[0]);
            }
        });
    }

    /* renamed from: c */
    private void m17902c(final FetchCallback<ReverseStationsInfo> fetchCallback) {
        final PoiInfoParam poiInfoParam = new PoiInfoParam();
        poiInfoParam.select_lng = this.f25047b.locationInfo.latLng.longitude;
        poiInfoParam.select_lat = this.f25047b.locationInfo.latLng.latitude;
        poiInfoParam.userOperationType = this.f25047b.operationType;
        poiInfoParam.poiInfo = m17893a(this.f25047b.locationInfo);
        poiInfoParam.callFrom = this.f25047b.reqCallerId == null ? CallFrom.UNKNOWN : this.f25047b.reqCallerId;
        poiInfoParam.isFirstLaunch = DepartureDataStore.getInstance().isFirstLaunch();
        poiInfoParam.isFence = this.f25047b.isNeedFence;
        poiInfoParam.isNeedNLP = this.f25047b.isNeedNLP();
        poiInfoParam.timeOut = this.f25047b.getTimeOut();
        poiInfoParam.departureTime = this.f25047b.departureTime;
        Map map = this.f25049d;
        poiInfoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
        poiInfoParam.localTime = System.currentTimeMillis();
        poiInfoParam.appAutoCall = this.f25047b.IsAutoCall;
        poiInfoParam.destInfo = this.f25047b.getDestInfo();
        poiInfoParam.entrance = PaxEnvironment.getInstance().getEntrance().toString();
        poiInfoParam.uid = PaxEnvironment.getInstance().getUid();
        poiInfoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        poiInfoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
        poiInfoParam.productId = PaxEnvironment.getInstance().getProductId();
        poiInfoParam.token = PaxEnvironment.getInstance().getToken();
        poiInfoParam.cityId = PaxEnvironment.getInstance().getCityId();
        poiInfoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        poiInfoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f25048c);
        if (lastKnownLocation != null) {
            poiInfoParam.user_loc_lng = lastKnownLocation.getLongitude();
            poiInfoParam.user_loc_lat = lastKnownLocation.getLatitude();
            poiInfoParam.source = lastKnownLocation.getSource();
            poiInfoParam.accuracy = lastKnownLocation.getAccuracy();
            poiInfoParam.provider = lastKnownLocation.getProvider();
            if (lastKnownLocation.getExtra() != null) {
                poiInfoParam.locStrategy = String.valueOf(lastKnownLocation.getExtra().getLong(DIDILocation.EXTRA_KEY_STRATEGY_FLAGS));
            }
        }
        PoiBaseApiFactory.createDidiApi(this.f25048c).fetchPoiInfo(poiInfoParam, new IHttpListener<ReverseStationsInfo>() {
            public void onSuccess(ReverseStationsInfo reverseStationsInfo) {
                DepartureHttpTask.this.m17900b(reverseStationsInfo);
                DLog.m7384d(DepartureHttpTask.f25046a, "poiInfo response, index " + Integer.toHexString(poiInfoParam.hashCode()) + "; result  : " + reverseStationsInfo, new Object[0]);
                FetchCallback fetchCallback = fetchCallback;
                if (fetchCallback == null) {
                    return;
                }
                if (reverseStationsInfo == null) {
                    fetchCallback.onFail(-1);
                } else if (reverseStationsInfo.errno == 0) {
                    RpcPoi rpcPoi = null;
                    if (reverseStationsInfo.result != null && !reverseStationsInfo.result.isEmpty()) {
                        rpcPoi = reverseStationsInfo.result.get(0);
                    }
                    if (!(DepartureHttpTask.this.f25047b == null || DepartureHttpTask.this.f25047b.locationInfo == null || DepartureHttpTask.this.f25047b.locationInfo.sugPoi == null || rpcPoi == null || rpcPoi.base_info == null || rpcPoi.base_info.poi_id == null || !rpcPoi.base_info.poi_id.equalsIgnoreCase(DepartureHttpTask.this.f25047b.locationInfo.sugPoi.poiId))) {
                        rpcPoi.base_info.displayname = DepartureHttpTask.this.f25047b.locationInfo.sugPoi.displayName;
                    }
                    fetchCallback.onSuccess(reverseStationsInfo);
                } else {
                    fetchCallback.onFail(reverseStationsInfo.errno);
                }
            }

            public void onFail(IOException iOException) {
                StringBuilder sb = new StringBuilder();
                sb.append("poiInfo request failed: ");
                sb.append(iOException != null ? iOException.getMessage() : "");
                DLog.m7384d(DepartureHttpTask.f25046a, sb.toString(), new Object[0]);
                if (iOException == null || !"Canceled".equals(iOException.getMessage())) {
                    FetchCallback fetchCallback = fetchCallback;
                    if (fetchCallback != null) {
                        fetchCallback.onFail(-1);
                        return;
                    }
                    return;
                }
                DLog.m7384d(DepartureHttpTask.f25046a, "取消了请求", new Object[0]);
            }
        });
    }

    /* renamed from: a */
    private String m17893a(DepartureLocationInfo departureLocationInfo) {
        if (departureLocationInfo == null || departureLocationInfo.sugPoi == null) {
            return "";
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("poi_id", departureLocationInfo.sugPoi.poiId);
        jsonObject.addProperty("displayname", departureLocationInfo.sugPoi.displayName);
        jsonObject.addProperty("address", departureLocationInfo.sugPoi.address);
        jsonObject.addProperty(Const.H5Params.ADDRESSALL, departureLocationInfo.sugPoi.fullName);
        jsonObject.addProperty("lat", (Number) Double.valueOf(departureLocationInfo.sugPoi.latitude));
        jsonObject.addProperty("lng", (Number) Double.valueOf(departureLocationInfo.sugPoi.longitude));
        jsonObject.addProperty(DepartureConstants.SRCTAG, departureLocationInfo.sugPoi.srcTag);
        jsonObject.addProperty("coordinate_type", departureLocationInfo.sugPoi.coordinate_type);
        return jsonObject.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m17900b(ReverseStationsInfo reverseStationsInfo) {
        if (reverseStationsInfo != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (reverseStationsInfo.getList() != null) {
                Iterator<RpcPoi> it = reverseStationsInfo.getList().iterator();
                while (it.hasNext()) {
                    it.next().curTimeMills = currentTimeMillis;
                }
            }
            if (reverseStationsInfo.getRecStartPoints() != null) {
                Iterator<RpcPoi> it2 = reverseStationsInfo.getRecStartPoints().iterator();
                while (it2.hasNext()) {
                    it2.next().curTimeMills = currentTimeMillis;
                }
            }
            if (reverseStationsInfo.recDestination != null) {
                Iterator<RpcPoi> it3 = reverseStationsInfo.recDestination.iterator();
                while (it3.hasNext()) {
                    it3.next().curTimeMills = currentTimeMillis;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public ReverseStationsInfo m17892a(ReverseGeoResult reverseGeoResult) {
        if (reverseGeoResult == null) {
            return null;
        }
        ReverseStationsInfo reverseStationsInfo = new ReverseStationsInfo();
        reverseStationsInfo.city = reverseGeoResult.city;
        reverseStationsInfo.cityId = reverseGeoResult.cityId;
        reverseStationsInfo.countryId = reverseGeoResult.countryId;
        reverseStationsInfo.countryCode = reverseGeoResult.countryCode;
        reverseStationsInfo.canonicalCountryCode = reverseGeoResult.canonicalCountryCode;
        reverseStationsInfo.result = reverseGeoResult.result;
        return reverseStationsInfo;
    }
}
