package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.bill.dialog.entity.CommonConfirmationDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.RuleDescEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RiskControlEntity;
import java.util.List;

public class OrderInfoEntity implements IEntity {
    private static final long serialVersionUID = 5156034224981621565L;
    public AbnormalItemsInfoEntity abnormalItemsInfo;
    public AddressEntity addressInfo;
    public CommonConfirmationDialogEntity adultConfirmation;
    public int afterFavPrice;
    public String afterFavPriceDisplay;
    public List<OrderTipsEntity> alerts;
    public OrderHelpEntity appeal;
    public BannerEntity banner;
    public String cardOrg;
    public String cardSuffix;
    public int cityId;
    public int clientPayType;
    public int completeTime;
    public int couponDeduction;
    public String couponDeductionDisplay;
    public List<CouponInfoEntity> couponInfo;
    public long createTime;
    public String createTimeDisplay;
    public String currency;
    public DebtInfoEntity debtInfo;
    public String deliveryId;
    public DeliveryInfoEntity deliveryInfo;
    public DeliveryMethodEntity deliveryMethod;
    public long deliveryPrice;
    public String deliveryPriceDetail;
    public String deliveryPriceDisplay;
    public int deliveryType;
    public long finalPayPrice;
    public String finalPayPriceDesc;
    public String finalPayPriceDisplay;
    public CurrencyDisplayEntity finalPayPriceSplit;
    public int firstTipMoney;
    public String firstTipMoneyDisplay;
    public FollowingInfoEntity followingInfo;
    public String imSecret;
    public String intlSubDesc;
    public int isArrears;
    public int isAutoPay;
    public String isDebtOrder;
    public int isGuideCashPayment = 0;
    public int isShowComment;
    public int isShowConfirmMealBtn;
    public int isShowReminderBtn;
    public int isShowShopContact;
    public int isShowTipPay;
    public int isUseCoupon;
    public List<CartItemEntity> items;
    public CommonConfirmationDialogEntity noCapacityConfirm;
    public String orderId;
    public int orderIndex;
    public long orderPrice;
    public List<OrderStatusFlowEntity> orderStatusFlow;
    public int payStatus;
    public long payTime;
    public int payType;
    public int payWay;
    public String preOrderId;
    public String progressingOrderId;
    public long realPrice;
    public OrderReceiptEntity receiptInfo;
    public String remark;
    public RiskControlEntity riskControl;
    public List<RuleDescEntity> ruleDescList;
    public long saveMoney;
    public int scene;
    public int servicePrice;
    public String servicePriceDisplay;
    public int shopAcceptCountDown;
    public int shopActSaveMoney;
    public String shopActSaveMoneyDisplay;
    public List<CouponInfoEntity> shopCouponInfo;
    public String shopId;
    public BusinessInfoEntity shopInfo;
    public String signedUrl;
    public int smallOrderPrice;
    public String smallOrderPriceDisplay;
    public int status;
    public String statusDesc;
    public String statusShortDesc;
    public String statusSubDesc;
    public String statusSubShortDesc;
    public String statusTimeDesc;
    public String statusTimeDescRich;
    public int stopPayTime;
    public List<OrderTipsEntity> tips;
    public int totalTipMoney;
    public String totalTipMoneyDisplay;
    public String transId;
    public String uid;
    public String unfinishOrderIds;
    public int userTakeCountDown;

    public boolean isForClientPay() {
        return this.status == 0 && this.clientPayType != 0;
    }
}
