package com.didi.map.global.component.departure.canoe.reverse;

import android.content.Context;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class ReverseTask {

    /* renamed from: a */
    private Context f24975a;

    /* renamed from: b */
    private int f24976b;

    /* renamed from: c */
    private ReverseTaskParam f24977c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ReverseTaskCallback f24978d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f24979e;

    public ReverseTask(Context context, ReverseTaskParam reverseTaskParam) {
        this.f24975a = context;
        this.f24977c = reverseTaskParam;
        if (reverseTaskParam != null) {
            this.f24976b = reverseTaskParam.getId();
            this.f24978d = reverseTaskParam.getTaskCallback();
        }
    }

    public int getId() {
        return this.f24976b;
    }

    public void start() {
        ReverseTaskCallback reverseTaskCallback;
        if (this.f24975a != null && this.f24977c != null && (reverseTaskCallback = this.f24978d) != null) {
            this.f24979e = true;
            if (reverseTaskCallback != null) {
                reverseTaskCallback.onDataStart();
            }
            m17848a();
        }
    }

    public void stop() {
        this.f24979e = false;
    }

    public void destroy() {
        this.f24979e = false;
        this.f24978d = null;
        this.f24977c = null;
        this.f24975a = null;
    }

    /* renamed from: a */
    private void m17848a() {
        if (this.f24977c.getLocationInfo() != null) {
            DepartureLocationInfo locationInfo = this.f24977c.getLocationInfo();
            ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
            reverseGeoParam.mapType = this.f24977c.getMapType();
            reverseGeoParam.select_lng = locationInfo.latLng.longitude;
            reverseGeoParam.select_lat = locationInfo.latLng.latitude;
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f24975a).getLastKnownLocation();
            if (lastKnownLocation != null) {
                reverseGeoParam.user_loc_lat = lastKnownLocation.getLatitude();
                reverseGeoParam.user_loc_lng = lastKnownLocation.getLongitude();
                reverseGeoParam.accuracy = lastKnownLocation.getAccuracy();
                reverseGeoParam.provider = lastKnownLocation.getProvider();
            }
            reverseGeoParam.callFrom = this.f24977c.getReqCallerId() == null ? CallFrom.UNKNOWN : this.f24977c.getReqCallerId();
            reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
            reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
            reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
            reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
            reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
            reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
            reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
            reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
            DLog.m7384d("canoe", "reverseGeo params = " + reverseGeoParam, new Object[0]);
            PoiBaseApiFactory.createDidiApi(this.f24975a).reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
                public void onSuccess(ReverseGeoResult reverseGeoResult) {
                    if (ReverseTask.this.f24978d != null && ReverseTask.this.f24979e) {
                        ReverseStationsInfo a = ReverseTask.this.m17847a(reverseGeoResult);
                        ReverseTask.this.m17850a(a);
                        if (a != null) {
                            DLog.m7384d("canoe", "reverseGeo  onSuccess info = " + a.toString(), new Object[0]);
                            if (a.errno != 0) {
                                ReverseTask.this.f24978d.onDataFailed(a.errno);
                            } else if (!CollectionUtil.isEmpty((Collection<?>) a.getRecStartPoints()) || !CollectionUtil.isEmpty((Collection<?>) a.getList())) {
                                ReverseTask.this.f24978d.onDataSuccess(a);
                            } else {
                                ReverseTask.this.f24978d.onDataFailed(-1);
                            }
                        } else {
                            ReverseTask.this.f24978d.onDataFailed(-1);
                        }
                    }
                }

                public void onFail(IOException iOException) {
                    if (ReverseTask.this.f24978d != null && ReverseTask.this.f24979e) {
                        DLog.m7384d("canoe", " reverseGeo onFail " + iOException.toString(), new Object[0]);
                        ReverseTask.this.f24978d.onDataFailed(-1);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m17850a(ReverseStationsInfo reverseStationsInfo) {
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
    public ReverseStationsInfo m17847a(ReverseGeoResult reverseGeoResult) {
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
