package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class HomeServiceCityEntity implements IEntity {
    private static final long serialVersionUID = 26438691687821949L;
    public String cityId;
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
