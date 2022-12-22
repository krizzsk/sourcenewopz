package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BusinessEntity implements IEntity {
    private static final long serialVersionUID = 6287130018649448344L;
    public BusinessAlertInfoEntity alertInfo;
    public BusinessAttentionInfoEntity attentionInfo;
    public BusinessBuyMoreEntity buyMoreInfo;
    public List<BusinessCateEntity> cateInfo;
    public int itemDetailAB;
    @SerializedName("templates")
    public List<JsonObject> mTemplates;
    public String recId;
    public ShopHeaderEntity shopHeader;
    public BusinessInfoEntity shopInfo;
}
