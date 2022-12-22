package com.didi.map.global.component.dropoff.data;

import android.content.Context;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.dropoff.data.IDropOffDataTask;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didi.soda.customer.app.constant.Const;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.destpoi.DestPoiInfoParam;
import com.sdk.poibase.model.destpoi.DestPoiReverseInfo;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class DropOffDataTask implements IDropOffDataTask {

    /* renamed from: a */
    private Context f25504a;

    /* renamed from: b */
    private int f25505b;

    /* renamed from: c */
    private DropOffDataTaskParam f25506c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IDropOffDataTask.TaskCallback f25507d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f25508e;

    public DropOffDataTask(Context context, DropOffDataTaskParam dropOffDataTaskParam) {
        this.f25504a = context;
        this.f25506c = dropOffDataTaskParam;
        if (dropOffDataTaskParam != null) {
            this.f25505b = dropOffDataTaskParam.getId();
            this.f25507d = dropOffDataTaskParam.getTaskCallback();
        }
    }

    public int getId() {
        return this.f25505b;
    }

    public void start() {
        if (this.f25504a != null && this.f25506c != null && this.f25507d != null) {
            DropOffUtils.LOGD(" data task id = " + this.f25505b);
            this.f25508e = true;
            IDropOffDataTask.TaskCallback taskCallback = this.f25507d;
            if (taskCallback != null) {
                taskCallback.onDataStart();
            }
            m18236a();
        }
    }

    public void stop() {
        this.f25508e = false;
    }

    public void destroy() {
        this.f25508e = false;
        this.f25507d = null;
        this.f25506c = null;
        this.f25504a = null;
    }

    /* renamed from: a */
    private void m18236a() {
        if (this.f25506c.getLocationInfo() != null && this.f25506c.getLocationInfo().sugPoi != null) {
            DropOffLocationInfo locationInfo = this.f25506c.getLocationInfo();
            DestPoiInfoParam destPoiInfoParam = new DestPoiInfoParam();
            destPoiInfoParam.mapType = this.f25506c.getMapType();
            destPoiInfoParam.select_lat = locationInfo.latLng.latitude;
            destPoiInfoParam.select_lng = locationInfo.latLng.longitude;
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f25504a).getLastKnownLocation();
            if (lastKnownLocation != null) {
                destPoiInfoParam.user_loc_lat = lastKnownLocation.getLatitude();
                destPoiInfoParam.user_loc_lng = lastKnownLocation.getLongitude();
                destPoiInfoParam.accuracy = lastKnownLocation.getAccuracy();
                destPoiInfoParam.provider = lastKnownLocation.getProvider();
            }
            if (this.f25506c.getReqCallerId() != null) {
                destPoiInfoParam.callFrom = this.f25506c.getReqCallerId();
            }
            destPoiInfoParam.userOperationType = this.f25506c.getUserOperationType();
            destPoiInfoParam.chooseDestPoiInfo = m18235a(locationInfo.sugPoi);
            destPoiInfoParam.uid = PaxEnvironment.getInstance().getUid();
            destPoiInfoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
            destPoiInfoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
            destPoiInfoParam.productId = PaxEnvironment.getInstance().getProductId();
            destPoiInfoParam.token = PaxEnvironment.getInstance().getToken();
            destPoiInfoParam.cityId = PaxEnvironment.getInstance().getCityId();
            destPoiInfoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
            destPoiInfoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
            DropOffUtils.LOGD("fetchDestPoiInfo params = " + destPoiInfoParam);
            PoiBaseApiFactory.createDidiApi(this.f25504a).fetchDestPoiInfo(destPoiInfoParam, new IHttpListener<DestPoiReverseInfo>() {
                public void onSuccess(DestPoiReverseInfo destPoiReverseInfo) {
                    if (DropOffDataTask.this.f25507d != null && DropOffDataTask.this.f25508e) {
                        if (destPoiReverseInfo != null) {
                            DropOffUtils.LOGD("result = " + destPoiReverseInfo.toString());
                            if (destPoiReverseInfo.errno == 0) {
                                DropOffDataTask.this.f25507d.onDataSuccess(destPoiReverseInfo);
                            } else {
                                DropOffDataTask.this.f25507d.onDataFailed();
                            }
                        } else {
                            DropOffDataTask.this.f25507d.onDataFailed();
                        }
                    }
                }

                public void onFail(IOException iOException) {
                    if (DropOffDataTask.this.f25507d != null && DropOffDataTask.this.f25508e) {
                        DropOffUtils.LOGD(" request fail " + iOException.toString());
                        DropOffDataTask.this.f25507d.onDataFailed();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private String m18235a(Address address) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("poi_id", address.poiId);
            jSONObject.put("displayname", address.displayName);
            jSONObject.put("address", address.address);
            jSONObject.put(Const.H5Params.ADDRESSALL, address.fullName);
            jSONObject.put("lat", address.latitude);
            jSONObject.put("lng", address.longitude);
            jSONObject.put(DepartureConstants.SRCTAG, address.srcTag);
            jSONObject.put("coordinate_type", address.coordinate_type);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
