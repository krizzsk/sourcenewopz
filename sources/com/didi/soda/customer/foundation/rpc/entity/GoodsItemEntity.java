package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.rpc.entity.bill.ToastEntity;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class GoodsItemEntity implements IEntity {
    private static final String TAG = "GoodsItemEntity";
    private static final long serialVersionUID = -8216535487389363987L;
    public ActDesc actDesc;
    public ActInfoEntity actInfo;
    public String actLabel;
    public List<ActTagEntity> actTag;
    public GoodsActivityInfoEntity activityInfo;
    public int activityType;
    public int additionalType;
    public boolean allowOverAmount = true;
    public String bizTimeDesc;
    public ButtonInfoEntity btnInfo;
    public String buttonUrl;
    public int cHasWine;
    public List<GoodsContentEntity> contentList;
    public String currency;
    @SerializedName("data")
    public JsonObject data;
    public int deliveryPriceAct;
    public int deliveryPriceOri;
    public long deliveryTime;
    public List<PromptEntity> fulfillment;
    public String headImg;
    public ImageBottomTagEntity imgBottomTag;
    public String itemId;
    public String itemImg;
    public String itemName;
    public String itemStatusDesc;
    public String itemUniqKey = "";
    public LimitLabel limitLabel;
    public String logo;
    public String logoImg;
    @SerializedName("componentV2")
    public TemplateTagEntity mComponentV2;
    public int maxLevel;
    public int maxOrderSale = -1;
    public int maxSale;
    public int needOfflineCal;
    public int needReloadDetail;
    public ItemNodeEntity node;
    public boolean notNeedClientCal;
    public int orderWay;
    public String origPriceDesc;
    public int position;
    public int price;
    public String priceDesc;
    public String priceDisplay;
    public List<PromptEntity> priceInfo;
    public List<PromptEntity> rating;
    public List<PromptEntity> recInfoList;
    public String remark;
    public String shopId;
    public String shopName;
    public String shortDesc;
    public String soldDesc;
    public int soldStatus;
    public String soldTimeDesc;
    public int specialPrice;
    public String specialPriceDisplay;
    public int status;
    public String statusDesc;
    public List<PromptEntity> tags;
    public List<PromptEntity> tips;
    public ToastEntity toast;
    public String url;
    public int wineConfirm;
    public String wineConfirmDesc;

    public static class ActDesc implements IEntity {
        private static final long serialVersionUID = 8617091108905887499L;
        public String buttonText;
        public String content;
        public String title;
    }

    public static class LimitLabel implements IEntity {
        private static final long serialVersionUID = 7929727896743442931L;
        public String limitLabelStr;
        public int limitLabelType;
    }
}
