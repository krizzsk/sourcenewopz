package com.didi.safetoolkit.business.emergency.model;

import com.didi.safetoolkit.model.SfBaseObject;
import com.google.gson.annotations.SerializedName;

public class SfGetEmergencyInfo extends SfBaseObject {
    @SerializedName("data")
    public Data data;

    public static class Data {
        @SerializedName("car_info")
        public CarInfo carInfo;
        @SerializedName("tips")
        public Tips tips;

        public static class CarInfo {
            @SerializedName("brand_desc")
            public String brandDesc;
            public String color;
            @SerializedName("plate_no")
            public String plateNo;
            @SerializedName("title")
            public String title;
        }

        public static class Tips {
            @SerializedName("car_info_title")
            public String carInfoTitle;
            @SerializedName("desc")
            public String desc;
            @SerializedName("location_current")
            public String locationCurrent;
            @SerializedName("location_loading")
            public String locationLoading;
            @SerializedName("location_previous")
            public String locationPrevious;
            @SerializedName("location_updating")
            public String locationUpdating;
            @SerializedName("title")
            public String title;
            @SerializedName("title_bar")
            public String titleBar;
        }
    }
}
