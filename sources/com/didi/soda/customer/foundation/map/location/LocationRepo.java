package com.didi.soda.customer.foundation.map.location;

import android.content.Context;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.common.map.model.LatLng;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.PoiBizType;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import java.io.IOException;

public class LocationRepo extends Repo<AddressModel> {
    public static final String POI_COORDINATE_TYPE = "wgs84";
    public static final String POI_MAPSDK_TYPE = "gmap";
    public static final String POI_REQUESTER_TYPE = "soda.customer.android";

    public void reverseLocation(Context context, LatLng latLng, LocationCallback<AddressModel> locationCallback) {
        if (latLng != null) {
            ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
            reverseGeoParam.productId = String.valueOf(601);
            reverseGeoParam.select_lat = latLng.latitude;
            reverseGeoParam.select_lng = latLng.longitude;
            reverseGeoParam.user_loc_lat = latLng.latitude;
            reverseGeoParam.user_loc_lng = latLng.longitude;
            reverseGeoParam.coordinate_type = "wgs84";
            reverseGeoParam.mapType = "gmap";
            reverseGeoParam.appVersion = SystemUtil.getVersionName(context);
            reverseGeoParam.countryId = String.valueOf(LoginUtil.getCountryId());
            reverseGeoParam.cityId = LocationUtil.getCityId();
            reverseGeoParam.lang = ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag();
            reverseGeoParam.phone = LoginUtil.getPhone();
            reverseGeoParam.token = LoginUtil.getToken();
            m29108a(context, reverseGeoParam, locationCallback);
        }
    }

    public void reverseLocation(Context context, LatLng latLng) {
        reverseLocation(context, latLng, (LocationCallback<AddressModel>) null);
    }

    /* renamed from: a */
    private void m29108a(Context context, ReverseGeoParam reverseGeoParam, final LocationCallback<AddressModel> locationCallback) {
        PoiBaseApiFactory.createDidiApi(context, PoiBizType.TYPE_GLOBAL).reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onFail(IOException iOException) {
                LocationCallback locationCallback = locationCallback;
                if (locationCallback != null) {
                    locationCallback.onFail(iOException);
                }
                OmegaTracker.Builder.create(ErrorConst.ErrorName.SAILING_C_SERVICE_RGEO_ERROR).addEventParam("error_type", ErrorTracker.getErrorType(iOException)).addEventParam("error_msg", ErrorTracker.getExceptionMsg(iOException)).build().track();
            }

            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                LocationRepo locationRepo = LocationRepo.this;
                locationRepo.setValue(locationRepo.m29110b(reverseGeoResult));
                LocationRepo.this.m29109a(reverseGeoResult);
                LocationCallback locationCallback = locationCallback;
                if (locationCallback != null) {
                    locationCallback.onSuccess(LocationRepo.this.m29110b(reverseGeoResult));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29109a(ReverseGeoResult reverseGeoResult) {
        AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
        if (reverseGeoResult != null) {
            AppConfig data = appConfigStorage.getData();
            data.mCityId = reverseGeoResult.cityId;
            data.mCityName = reverseGeoResult.city;
            data.mLocationCountry = reverseGeoResult.canonicalCountryCode;
            appConfigStorage.setData(data);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public AddressModel m29110b(ReverseGeoResult reverseGeoResult) {
        if (reverseGeoResult == null || CollectionsUtil.isEmpty(reverseGeoResult.result)) {
            return null;
        }
        RpcPoi rpcPoi = reverseGeoResult.result.get(0);
        AddressModel addressModel = new AddressModel();
        addressModel.countryCode = reverseGeoResult.countryCode;
        addressModel.canonicalCountryCode = reverseGeoResult.canonicalCountryCode;
        addressModel.city = reverseGeoResult.city;
        if (rpcPoi == null) {
            return addressModel;
        }
        addressModel.geofence = rpcPoi.geofence;
        addressModel.latitude = rpcPoi.base_info.lat;
        addressModel.longitude = rpcPoi.base_info.lng;
        addressModel.address = rpcPoi.base_info.address;
        addressModel.displayName = rpcPoi.base_info.displayname;
        addressModel.poi_id = rpcPoi.base_info.poi_id;
        addressModel.cityId = rpcPoi.base_info.city_id;
        return addressModel;
    }
}
