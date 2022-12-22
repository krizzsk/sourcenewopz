package com.didi.soda.home.component.city.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeServiceCityEntity;

public class HomeCityItemRvModel implements RecyclerModel {
    public String mCityId;
    public String mCityName;
    public boolean mIsOpen;
    public double mLat;
    public double mLng;
    public boolean mShowDivider;

    public HomeCityItemRvModel(HomeServiceCityEntity homeServiceCityEntity, boolean z) {
        if (homeServiceCityEntity != null) {
            this.mCityName = homeServiceCityEntity.cityName;
            this.mCityId = homeServiceCityEntity.cityId;
            if (homeServiceCityEntity.hotPoi != null) {
                this.mLat = homeServiceCityEntity.hotPoi.lat;
                this.mLng = homeServiceCityEntity.hotPoi.lng;
            }
            this.mIsOpen = homeServiceCityEntity.isOpened > 0;
            this.mShowDivider = z;
        }
    }
}
