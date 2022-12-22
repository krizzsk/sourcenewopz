package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class CarOperationModel implements BffGsonStruct {
    public static final String ANYCAR_CARPOOL = "0";
    public static final String COMPANY = "3";
    public static final String DISPATCH_FEE = "1";
    public static final String ESTIMATE_PASS = "5";
    public static final String EXTRA_OPTION = "2";
    public static final String MEMBERPOINT = "4";
    public static final String TWO_PRICE = "0";
    public static final String XML = "6";
    @SerializedName("car_operation_cache")
    public int carOperationCache;
    @SerializedName("dup_select_default")
    public boolean dupselectdefault = false;
    @SerializedName("is_show_checkbox")
    public int isShowCheckBox = 1;
    @SerializedName("data")
    public CarOperationDataModel operationData;
    @SerializedName("type")
    public String operationType;
    @SerializedName("pass_package_id")
    public long passPackageId;
    @SerializedName("toast")
    public String toast;
    @SerializedName("xml_data")
    public JsonObject xmlData;
}
