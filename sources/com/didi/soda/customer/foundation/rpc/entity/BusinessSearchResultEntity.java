package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class BusinessSearchResultEntity implements IEntity {
    private static final long serialVersionUID = -4989853583649829332L;
    public List<GoodsItemAndCatEntity> data;
    @SerializedName("templates")
    public List<JsonObject> mTemplates;
    public String recId;
    public int type;

    public static class GoodsItemAndCatEntity implements IEntity {
        private static final long serialVersionUID = 5212432257749877871L;
        public BusinessCateEntity category;
        public GoodsItemEntity item;
        @SerializedName("comp")
        public JsonObject mJsonComp;
    }
}
