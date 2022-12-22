package com.didi.entrega.home.component.city.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.home.component.city.entity.HomeServiceCityEntity;

public class HomeCityItemRvModel implements RecyclerModel {
    public int mCityId;
    public int mCityIndexInAllCountries;
    public String mCityName;
    public String mCountryCode;
    public String mCountryId;
    public String mCountryName;
    public long mCountyGroupId;
    public long mCountyId;
    public boolean mIsOpen;
    public double mLat;
    public double mLng;
    public String mName;
    public String mPoiId;
    public boolean mShowDivider;

    public HomeCityItemRvModel(int i, HomeServiceCityEntity homeServiceCityEntity, boolean z) {
        if (homeServiceCityEntity != null) {
            this.mCityIndexInAllCountries = i;
            this.mCityName = homeServiceCityEntity.cityName;
            this.mCityId = homeServiceCityEntity.cityId;
            if (homeServiceCityEntity.hotPoi != null) {
                this.mLat = homeServiceCityEntity.hotPoi.lat;
                this.mLng = homeServiceCityEntity.hotPoi.lng;
                this.mName = homeServiceCityEntity.hotPoi.name;
                this.mPoiId = homeServiceCityEntity.hotPoi.poiId;
            }
            this.mIsOpen = homeServiceCityEntity.isOpened > 0;
            this.mShowDivider = z;
        }
    }

    public HomeCityItemRvModel(AddressEntity addressEntity) {
        if (addressEntity != null && addressEntity.poi != null) {
            this.mCountryName = addressEntity.poi.city;
            this.mName = addressEntity.poi.displayName;
            this.mCityId = addressEntity.poi.cityId;
            this.mLat = addressEntity.poi.lat;
            this.mLng = addressEntity.poi.lng;
            this.mPoiId = addressEntity.poi.poiId;
            this.mCountryId = String.valueOf(addressEntity.poi.countryId);
            this.mCountryCode = addressEntity.poi.countryCode;
            this.mCountyId = addressEntity.poi.countyId;
            this.mCountyGroupId = addressEntity.poi.countyGroupId;
        }
    }
}
