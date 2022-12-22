package com.didi.entrega.customer.foundation.util;

import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.debug.CustomerToolBoxUtil;
import com.didi.entrega.customer.debug.PoiUtil;
import com.didi.entrega.customer.foundation.location.LocationWrapper;
import com.didi.entrega.customer.foundation.map.location.AddressModel;
import com.didi.entrega.customer.foundation.map.location.LocationRepo;
import com.didi.entrega.customer.foundation.storage.AppConfigStorage;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.foundation.sdk.location.LocationService;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public final class LocationUtil {
    public static final String CITY_NAME_DEFAULT = "";
    public static final int ID_DEFAULT = 0;

    public interface LocationCallback {
        void onLocationError();

        void onLocationSuccess(LatLng latLng);
    }

    public static boolean hasValidPoi() {
        return true;
    }

    private LocationUtil() {
    }

    public static String getPoiCountryCode() {
        return PoiUtil.getPoiCountryCode();
    }

    public static String getPoiDisplayName() {
        return PoiUtil.getPoiDisplayName();
    }

    public static int getPoiCityId() {
        return CustomerToolBoxUtil.getPoiCityId();
    }

    public static long getPoiCountyId() {
        return CustomerToolBoxUtil.getPoiCountyId();
    }

    public static long getPoiCountyGroupId() {
        return CustomerToolBoxUtil.getPoiCountyGroupId();
    }

    public static String getPoiId() {
        return PoiUtil.getPoiId();
    }

    public static double getPoiLng() {
        return CustomerToolBoxUtil.getPoiLng();
    }

    public static double getPoiLat() {
        return CustomerToolBoxUtil.getPoiLat();
    }

    public static boolean hasValidLocation() {
        return (getCurrentLng() == 0.0d || getCurrentLat() == 0.0d) ? false : true;
    }

    public static double distance(double d, double d2, double d3, double d4) {
        double d5 = (d2 * 3.141592653589793d) / 180.0d;
        double d6 = (d4 * 3.141592653589793d) / 180.0d;
        double sin = Math.sin((d5 - d6) / 2.0d);
        double sin2 = Math.sin((((d - d3) * 3.141592653589793d) / 180.0d) / 2.0d);
        return 1.2756274E7d * Math.asin(Math.sqrt((sin * sin) + (Math.cos(d5) * Math.cos(d6) * sin2 * sin2)));
    }

    public static LatLng getCurrentLatLng() {
        return CustomerToolBoxUtil.getCurrentLatLng();
    }

    public static DIDILocation getCurrentLocation() {
        return LocationService.getInstance().getLastKnownLocation();
    }

    public static int getCityId() {
        return CustomerToolBoxUtil.getCityId();
    }

    public static long getCountyId() {
        return CustomerToolBoxUtil.getCountyId();
    }

    public static long getCountyGroupId() {
        return CustomerToolBoxUtil.getCountyGroupId();
    }

    public static String getCityName() {
        AddressModel addressModel = (AddressModel) ((LocationRepo) RepoFactory.getRepo(LocationRepo.class)).getValue();
        String str = addressModel != null ? addressModel.city : null;
        if (TextUtils.isEmpty(str)) {
            str = ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mCityName;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static double getCurrentLat() {
        return CustomerToolBoxUtil.getLat();
    }

    public static double getCurrentLng() {
        return CustomerToolBoxUtil.getLng();
    }

    public static String getCountryCode() {
        AddressModel addressModel = (AddressModel) ((LocationRepo) RepoFactory.getRepo(LocationRepo.class)).getValue();
        String str = addressModel != null ? addressModel.canonicalCountryCode : null;
        return TextUtils.isEmpty(str) ? ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mLocationCountry : str;
    }

    public static void getCurrentLocationOnce(LocationCallback locationCallback) {
        getCurrentLocationOnce(locationCallback, 4000);
    }

    public static void getCurrentLocationOnce(LocationCallback locationCallback, int i) {
        m14839a(locationCallback, !GlobalContext.isEmbed(), i);
    }

    /* renamed from: a */
    private static void m14839a(LocationCallback locationCallback, boolean z, int i) {
        LatLng currentLatLng = getCurrentLatLng();
        if (currentLatLng == null || locationCallback == null || z) {
            new LocationWrapper(locationCallback, i).startLocation();
        } else {
            locationCallback.onLocationSuccess(currentLatLng);
        }
    }
}
