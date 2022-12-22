package com.didi.entrega.home.component.city.entity;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;

public class HomeServiceCityEntity implements IEntity {
    private static final long serialVersionUID = 26438691687821949L;
    public int cityId;
    public String cityName;
    public HotPoiEntity hotPoi;
    public int isOpened;

    public static class HotPoiEntity implements IEntity {
        private static final long serialVersionUID = -387458482327507235L;
        public double lat;
        public double lng;
        public String name;
        public String poiId;
    }
}
