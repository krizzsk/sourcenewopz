package com.didi.addressold.util;

public class AddressParamCheckInfo {
    public static final int INFO_CURRENT_ADDRESS_CITY_NAME_IS_NULL = 7;
    public static final int INFO_CURRENT_ADDRESS_IS_NULL = 5;
    public static final int INFO_CURRENT_ADDRESS_LAT_OR_LNG_ILLEGAL = 6;
    public static final int INFO_MAP_TYPE_ILLEGAL = 4;
    public static final int INFO_OK = 1;
    public static final int INFO_PARAM_IS_NULL = 2;
    public static final int INFO_SDK_MAP_TYPE_ILLEGAL = 3;
    public static final int INFO_TARGET_ADDRESS_CITY_NAME_IS_NULL = 10;
    public static final int INFO_TARGET_ADDRESS_IS_NULL = 8;
    public static final int INFO_TARGET_ADDRESS_LAT_OR_LNG_ILLEGAL = 9;

    /* renamed from: a */
    private int f7776a = 1;

    public AddressParamCheckInfo(int i) {
        this.f7776a = i;
    }

    public int errCode() {
        return this.f7776a;
    }

    public String errMessage() {
        switch (this.f7776a) {
            case 1:
                return "AddressParam check OK!";
            case 2:
                return "AddressParam is null";
            case 3:
                return "AddressParam.sdkMapType illegal";
            case 4:
                return "AddressParam.mapType illegal";
            case 5:
                return "AddressParam.currentAddress is null";
            case 6:
                return "AddressParam.currentAddress Latitude or Longitude illegal";
            case 7:
                return "AddressParam.currentAddress.cityName is null";
            case 8:
                return "AddressParam.targetAddress is null";
            case 9:
                return "AddressParam.targetAddress Latitude or Longitude illegal";
            case 10:
                return "AddressParam.targetAddress.cityName is null";
            default:
                return "";
        }
    }
}
