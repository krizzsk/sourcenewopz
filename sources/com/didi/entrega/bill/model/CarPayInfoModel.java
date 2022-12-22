package com.didi.entrega.bill.model;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CarPayInfoModel implements IEntity {
    private static final long serialVersionUID = -7066718500398845822L;
    @SerializedName("card_prefix")
    public String cardPrefix;
    @SerializedName("is_hit_99pay_combination_experiment")
    public int isHit99payCombination;
    @SerializedName("is_priority_use")
    public String isPriorityUse;
    @SerializedName("balanceMsg")
    public String payBalanceMsg;
    @SerializedName("business_const_set")
    public int payBussConstSet;
    @SerializedName("business_url")
    public String payBussUrl;
    @SerializedName("card_index")
    public String payCarIndex;
    @SerializedName("card")
    public String payCard;
    @SerializedName("card_org")
    public String payCardOrg;
    @SerializedName("company_carpool_open")
    public int payCarpoolOpen = 0;
    @SerializedName("channelID")
    public int payChannelId;
    @SerializedName("can_combination_pay_type")
    public List<Integer> payCombineType;
    @SerializedName("company_pay_msg")
    public String payCompanyMsg;
    @SerializedName("disabled")
    public int payDisable;
    @SerializedName("discount_msg")
    public String payDiscountMessage;
    @SerializedName("expired")
    public int payExpired;
    @SerializedName("expired_desc")
    public String payExpiredDesc;
    @SerializedName("extraInfo")
    public String payExtraInfo;
    @SerializedName("extraInfoList")
    public List<CarPayExtraItemInfo> payExtraItemInfos;
    @SerializedName("has_coupon")
    public int payHasCoupon;
    @SerializedName("icon_url")
    public String payIconUrl;
    @SerializedName("isOffline")
    public int payIsOffline = 0;
    @SerializedName("is_promotion")
    public int payIsPromotion;
    @SerializedName("isSelected")
    public int payIsSelected;
    @SerializedName("isSigned")
    public int payIsSigned;
    @SerializedName("is_sufficient")
    public int payIsSufficient;
    @SerializedName("msg")
    public String payMessage;
    @SerializedName("payment_select_name")
    public String payMessageInSelectPage;
    @SerializedName("recommendSignPayType")
    public int payRecommendSignPayType;
    @SerializedName("show_msg")
    public String payShowMessage;
    @SerializedName("tag")
    public int payTag;
    @SerializedName("text")
    public String payText;
    @SerializedName("tips")
    public String payTips;
    @SerializedName("total_discount")
    public String payTotalDiscount;
    @SerializedName("can_use_coupon")
    public int payUseCoupon;
    @SerializedName("user_reward")
    public int payUseReward;
    @SerializedName("priority_show")
    public int priorityShow;
    @SerializedName("to_add_card_info")
    public String toAddCardInfo;
}
