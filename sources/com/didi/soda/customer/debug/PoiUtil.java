package com.didi.soda.customer.debug;

import com.didi.common.map.model.LatLng;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;

public final class PoiUtil {
    private PoiUtil() {
    }

    public static int getCityId() {
        int i = ((AppConfigStorage) SingletonFactory.get(AppConfigStorage.class)).getData().mCityId;
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public static long getCountyId() {
        long j = ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().countyId;
        if (j > 0) {
            return j;
        }
        return 0;
    }

    public static long getCountyGroupId() {
        long j = ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().countyGroupId;
        if (j > 0) {
            return j;
        }
        return 0;
    }

    public static LatLng getCurrentLatLng() {
        DIDILocation lastKnownLocation = LocationService.getInstance().getLastKnownLocation();
        if (lastKnownLocation != null) {
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        }
        return null;
    }

    public static double getLat() {
        LatLng currentLatLng = getCurrentLatLng();
        if (currentLatLng != null) {
            return currentLatLng.latitude;
        }
        return 0.0d;
    }

    public static double getLng() {
        LatLng currentLatLng = getCurrentLatLng();
        if (currentLatLng != null) {
            return currentLatLng.longitude;
        }
        return 0.0d;
    }

    public static int getPoiCityId() {
        AddressEntity a = m29046a();
        if (hasValidPoi(a)) {
            return a.poi.cityId;
        }
        return 0;
    }

    public static long getPoiCountyId() {
        AddressEntity a = m29046a();
        if (hasValidPoi(a)) {
            return a.poi.countyId;
        }
        return 0;
    }

    public static long getPoiCountyGroupId() {
        AddressEntity a = m29046a();
        if (hasValidPoi(a)) {
            return a.poi.countyGroupId;
        }
        return 0;
    }

    public static double getPoiLat() {
        AddressEntity a = m29046a();
        if (hasValidPoi(a)) {
            return a.poi.lat;
        }
        return 0.0d;
    }

    public static double getPoiLng() {
        AddressEntity a = m29046a();
        if (hasValidPoi(a)) {
            return a.poi.lng;
        }
        return 0.0d;
    }

    public static String getPoiCountryCode() {
        AddressEntity a = m29046a();
        return hasValidPoi(a) ? a.poi.countryCode : "";
    }

    public static String getPoiDisplayName() {
        AddressEntity a = m29046a();
        return hasValidPoi(a) ? a.poi.displayName : "";
    }

    public static String getPoiId() {
        AddressEntity a = m29046a();
        return hasValidPoi(a) ? a.poi.poiId : "";
    }

    public static boolean hasValidPoi(AddressEntity addressEntity) {
        return AddressUtil.checkAddressValid(addressEntity);
    }

    /* renamed from: a */
    private static AddressEntity m29046a() {
        try {
            return ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
        } catch (Exception unused) {
            return null;
        }
    }
}
