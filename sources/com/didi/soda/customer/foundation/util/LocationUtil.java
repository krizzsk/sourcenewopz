package com.didi.soda.customer.foundation.util;

import android.app.Activity;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.foundation.sdk.location.LocationService;
import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.debug.CustomerToolBoxUtil;
import com.didi.soda.customer.debug.PoiUtil;
import com.didi.soda.customer.foundation.location.LocationWrapper;
import com.didi.soda.customer.foundation.map.location.AddressModel;
import com.didi.soda.customer.foundation.map.location.LocationRepo;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public final class LocationUtil {
    public static final String CITY_NAME_DEFAULT = "";
    public static final int ID_DEFAULT = 0;

    /* renamed from: a */
    private static ErrInfo f41245a;

    public interface LocationCallback {
        void onLocationError();

        void onLocationSuccess(LatLng latLng);
    }

    private LocationUtil() {
    }

    public static void tryEnableMockLocation() {
        if (CustomerApolloUtil.isOpenMockLocation()) {
            LocationService.getInstance().enableMock(true);
        } else {
            CustomerToolBoxUtil.openMockLocation();
        }
    }

    public static ErrInfo getErrorInfo() {
        return f41245a;
    }

    public static void setErrorInfo(ErrInfo errInfo) {
        f41245a = errInfo;
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

    public static boolean hasValidPoi() {
        return AddressUtil.checkAddressValid(((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress());
    }

    public static boolean hasValidLocation() {
        return (getCurrentLng() == 0.0d || getCurrentLat() == 0.0d) ? false : true;
    }

    public static boolean hasLocationPermission(Activity activity) {
        return LocalPermissionHelper.checkoutPermission(activity, LocalPermissionHelper.LOCATION_PERMISSIONS) && CustomerSystemUtil.isGpsEnabled(activity);
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
        m29215a(locationCallback, !GlobalContext.isEmbed(), i);
    }

    /* renamed from: a */
    private static void m29215a(LocationCallback locationCallback, boolean z, int i) {
        LatLng currentLatLng = getCurrentLatLng();
        if (currentLatLng == null || locationCallback == null || z) {
            new LocationWrapper(locationCallback, i).startLocation();
        } else {
            locationCallback.onLocationSuccess(currentLatLng);
        }
    }
}
