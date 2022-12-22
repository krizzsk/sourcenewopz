package com.didi.entrega.customer.debug;

import com.didi.common.map.model.LatLng;
import com.didi.entrega.customer.foundation.storage.AppConfigStorage;
import com.didi.entrega.customer.foundation.storage.ServerConfigStorage;
import com.didi.entrega.customer.foundation.util.SingletonFactory;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.home.component.city.model.HomeCityItemRvModel;
import com.didi.entrega.home.manager.SelectedCityInfoRepo;
import com.didi.foundation.sdk.location.LocationService;
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
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        if (homeCityItemRvModel != null) {
            return homeCityItemRvModel.mCityId;
        }
        return 0;
    }

    public static long getPoiCountyId() {
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        if (homeCityItemRvModel != null) {
            return homeCityItemRvModel.mCountyId;
        }
        return 0;
    }

    public static long getPoiCountyGroupId() {
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        if (homeCityItemRvModel != null) {
            return homeCityItemRvModel.mCountyGroupId;
        }
        return 0;
    }

    public static double getPoiLat() {
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        if (homeCityItemRvModel != null) {
            return homeCityItemRvModel.mLat;
        }
        return 0.0d;
    }

    public static double getPoiLng() {
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        if (homeCityItemRvModel != null) {
            return homeCityItemRvModel.mLng;
        }
        return 0.0d;
    }

    public static String getPoiCountryCode() {
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        return homeCityItemRvModel != null ? homeCityItemRvModel.mCountryCode : "";
    }

    public static String getPoiDisplayName() {
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        return homeCityItemRvModel != null ? homeCityItemRvModel.mName : "";
    }

    public static String getPoiId() {
        HomeCityItemRvModel homeCityItemRvModel = (HomeCityItemRvModel) ((SelectedCityInfoRepo) RepoFactory.getRepo(SelectedCityInfoRepo.class)).getValue();
        return homeCityItemRvModel != null ? homeCityItemRvModel.mPoiId : "";
    }
}
