package com.didi.component.comp_homecard.model;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.component.homedestination.model.HomeCardListResponse;
import com.google.gson.JsonObject;

public class HomeAddressModel implements BffGsonStruct {
    public int address_forbid;
    public JsonObject coupon_info;
    public HomeCardListResponse recommend_info;
}
