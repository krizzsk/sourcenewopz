package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;

public class NativePageInfoEntity implements IEntity {
    private static final long serialVersionUID = -4260493274417535577L;
    public ButtonInfoEntity availableCity;
    public ButtonInfoEntity availableCountry;
    public ButtonInfoEntity centralDistrict;
    public String image;
    public ButtonInfoEntity otherLocation;
    public String subTitle;
    public ButtonInfoEntity subscribeNotification;
    public String title;

    public static class ButtonInfoEntity implements IEntity {
        public static final int TYPE_SHOW = 1;
        private static final long serialVersionUID = -6063585374401289882L;
        public String callingCode;
        public int countryId;
        public int display;
        public HomeServiceCityEntity poiInfo;
        public int style;
    }
}
