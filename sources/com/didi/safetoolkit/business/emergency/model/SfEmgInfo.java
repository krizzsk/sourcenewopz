package com.didi.safetoolkit.business.emergency.model;

import com.didi.safetoolkit.model.SfBaseObject;
import com.google.gson.annotations.SerializedName;

public class SfEmgInfo extends SfBaseObject {
    @SerializedName("data")
    public Data data;

    public static class Data {
        @SerializedName("car_title")
        public String carBrand;
        @SerializedName("plate_no")
        public String carLicense;
        @SerializedName("more_url")
        public String moreUrl;
    }

    public static SfEmgInfo convertFrom(SfGetEmergencyInfo sfGetEmergencyInfo) {
        SfEmgInfo sfEmgInfo = new SfEmgInfo();
        Data data2 = new Data();
        sfEmgInfo.data = data2;
        data2.carLicense = sfGetEmergencyInfo.data.carInfo.plateNo;
        sfEmgInfo.data.carBrand = sfGetEmergencyInfo.data.carInfo.brandDesc;
        return sfEmgInfo;
    }
}
