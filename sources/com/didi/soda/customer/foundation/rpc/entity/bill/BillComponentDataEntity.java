package com.didi.soda.customer.foundation.rpc.entity.bill;

import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.CetaEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryRulesEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.BottomTipInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RemarkInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TyingItems;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 {2\u00020\u0001:\u0001{B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R.\u0010'\u001a\u0016\u0012\u0004\u0012\u00020)\u0018\u00010(j\n\u0012\u0004\u0012\u00020)\u0018\u0001`*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0010\n\u0002\u0010A\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001c\u0010Z\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\f\"\u0004\b\\\u0010\u000eR\u001c\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001c\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001c\u0010i\u001a\u0004\u0018\u00010jX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010o\u001a\u0004\u0018\u00010pX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001c\u0010u\u001a\u0004\u0018\u00010vX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010z¨\u0006|"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "abnormalItemInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemInfoEntity;", "getAbnormalItemInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemInfoEntity;", "setAbnormalItemInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/AbnormalItemInfoEntity;)V", "address", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "getAddress", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "setAddress", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;)V", "bottomTipInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/BottomTipInfoEntity;", "getBottomTipInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/BottomTipInfoEntity;", "setBottomTipInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/BottomTipInfoEntity;)V", "cetaInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/address/CetaEntity;", "getCetaInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/CetaEntity;", "setCetaInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/CetaEntity;)V", "couponInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity;", "getCouponInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity;", "setCouponInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity;)V", "cutlery", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/CutleryEntity;", "getCutlery", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/CutleryEntity;", "setCutlery", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/CutleryEntity;)V", "deliveryMethods", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "Lkotlin/collections/ArrayList;", "getDeliveryMethods", "()Ljava/util/ArrayList;", "setDeliveryMethods", "(Ljava/util/ArrayList;)V", "deliveryRules", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryRulesEntity;", "getDeliveryRules", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryRulesEntity;", "setDeliveryRules", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryRulesEntity;)V", "followingInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "getFollowingInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "setFollowingInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;)V", "hasAdsorb", "", "getHasAdsorb", "()Ljava/lang/Boolean;", "setHasAdsorb", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "itemsInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillCartItemsInfo;", "getItemsInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillCartItemsInfo;", "setItemsInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillCartItemsInfo;)V", "lineInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillLineInfoEntity;", "getLineInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillLineInfoEntity;", "setLineInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillLineInfoEntity;)V", "payChannel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "getPayChannel", "()Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "setPayChannel", "(Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;)V", "priceInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/PriceInfo;", "getPriceInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/PriceInfo;", "setPriceInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/PriceInfo;)V", "recAddress", "getRecAddress", "setRecAddress", "remarkInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/RemarkInfoEntity;", "getRemarkInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/RemarkInfoEntity;", "setRemarkInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/RemarkInfoEntity;)V", "reminderInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ReminderInfo;", "getReminderInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/ReminderInfo;", "setReminderInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/ReminderInfo;)V", "tipFeeInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity;", "getTipFeeInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity;", "setTipFeeInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity;)V", "titleInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/TitleInfoEntity;", "getTitleInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/TitleInfoEntity;", "setTitleInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/TitleInfoEntity;)V", "tyingItems", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/TyingItems;", "getTyingItems", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/TyingItems;", "setTyingItems", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/TyingItems;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillComponentDataEntity.kt */
public final class BillComponentDataEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 2751991366056425960L;
    private AbnormalItemInfoEntity abnormalItemInfo;
    private AddressEntity address;
    private BottomTipInfoEntity bottomTipInfo;
    private CetaEntity cetaInfo;
    private CouponInfoEntity couponInfo;
    private CutleryEntity cutlery;
    private ArrayList<DeliveryMethodEntity> deliveryMethods;
    private DeliveryRulesEntity deliveryRules;
    private FollowingInfoEntity followingInfo;
    private Boolean hasAdsorb;
    private BillCartItemsInfo itemsInfo;
    private BillLineInfoEntity lineInfo;
    private PayChannelEntity payChannel;
    private PriceInfo priceInfo;
    private AddressEntity recAddress;
    private RemarkInfoEntity remarkInfo;
    private ReminderInfo reminderInfo;
    private TipFeeInfoEntity tipFeeInfo;
    private TitleInfoEntity titleInfo;
    private TyingItems tyingItems;

    public final ReminderInfo getReminderInfo() {
        return this.reminderInfo;
    }

    public final void setReminderInfo(ReminderInfo reminderInfo2) {
        this.reminderInfo = reminderInfo2;
    }

    public final AddressEntity getAddress() {
        return this.address;
    }

    public final void setAddress(AddressEntity addressEntity) {
        this.address = addressEntity;
    }

    public final Boolean getHasAdsorb() {
        return this.hasAdsorb;
    }

    public final void setHasAdsorb(Boolean bool) {
        this.hasAdsorb = bool;
    }

    public final AddressEntity getRecAddress() {
        return this.recAddress;
    }

    public final void setRecAddress(AddressEntity addressEntity) {
        this.recAddress = addressEntity;
    }

    public final ArrayList<DeliveryMethodEntity> getDeliveryMethods() {
        return this.deliveryMethods;
    }

    public final void setDeliveryMethods(ArrayList<DeliveryMethodEntity> arrayList) {
        this.deliveryMethods = arrayList;
    }

    public final PayChannelEntity getPayChannel() {
        return this.payChannel;
    }

    public final void setPayChannel(PayChannelEntity payChannelEntity) {
        this.payChannel = payChannelEntity;
    }

    public final PriceInfo getPriceInfo() {
        return this.priceInfo;
    }

    public final void setPriceInfo(PriceInfo priceInfo2) {
        this.priceInfo = priceInfo2;
    }

    public final BillCartItemsInfo getItemsInfo() {
        return this.itemsInfo;
    }

    public final void setItemsInfo(BillCartItemsInfo billCartItemsInfo) {
        this.itemsInfo = billCartItemsInfo;
    }

    public final FollowingInfoEntity getFollowingInfo() {
        return this.followingInfo;
    }

    public final void setFollowingInfo(FollowingInfoEntity followingInfoEntity) {
        this.followingInfo = followingInfoEntity;
    }

    public final TipFeeInfoEntity getTipFeeInfo() {
        return this.tipFeeInfo;
    }

    public final void setTipFeeInfo(TipFeeInfoEntity tipFeeInfoEntity) {
        this.tipFeeInfo = tipFeeInfoEntity;
    }

    public final CouponInfoEntity getCouponInfo() {
        return this.couponInfo;
    }

    public final void setCouponInfo(CouponInfoEntity couponInfoEntity) {
        this.couponInfo = couponInfoEntity;
    }

    public final RemarkInfoEntity getRemarkInfo() {
        return this.remarkInfo;
    }

    public final void setRemarkInfo(RemarkInfoEntity remarkInfoEntity) {
        this.remarkInfo = remarkInfoEntity;
    }

    public final AbnormalItemInfoEntity getAbnormalItemInfo() {
        return this.abnormalItemInfo;
    }

    public final void setAbnormalItemInfo(AbnormalItemInfoEntity abnormalItemInfoEntity) {
        this.abnormalItemInfo = abnormalItemInfoEntity;
    }

    public final BottomTipInfoEntity getBottomTipInfo() {
        return this.bottomTipInfo;
    }

    public final void setBottomTipInfo(BottomTipInfoEntity bottomTipInfoEntity) {
        this.bottomTipInfo = bottomTipInfoEntity;
    }

    public final DeliveryRulesEntity getDeliveryRules() {
        return this.deliveryRules;
    }

    public final void setDeliveryRules(DeliveryRulesEntity deliveryRulesEntity) {
        this.deliveryRules = deliveryRulesEntity;
    }

    public final CetaEntity getCetaInfo() {
        return this.cetaInfo;
    }

    public final void setCetaInfo(CetaEntity cetaEntity) {
        this.cetaInfo = cetaEntity;
    }

    public final CutleryEntity getCutlery() {
        return this.cutlery;
    }

    public final void setCutlery(CutleryEntity cutleryEntity) {
        this.cutlery = cutleryEntity;
    }

    public final TyingItems getTyingItems() {
        return this.tyingItems;
    }

    public final void setTyingItems(TyingItems tyingItems2) {
        this.tyingItems = tyingItems2;
    }

    public final BillLineInfoEntity getLineInfo() {
        return this.lineInfo;
    }

    public final void setLineInfo(BillLineInfoEntity billLineInfoEntity) {
        this.lineInfo = billLineInfoEntity;
    }

    public final TitleInfoEntity getTitleInfo() {
        return this.titleInfo;
    }

    public final void setTitleInfo(TitleInfoEntity titleInfoEntity) {
        this.titleInfo = titleInfoEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillComponentDataEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
