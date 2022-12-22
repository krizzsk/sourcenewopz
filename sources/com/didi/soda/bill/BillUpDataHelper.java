package com.didi.soda.bill;

import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.AbnormalItemOptEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillAddTyingEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillDelItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillUpdateParams;
import com.didi.soda.customer.foundation.rpc.entity.bill.CutleryEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RemarkEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/BillUpDataHelper;", "", "()V", "BillUpDataModel", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillUpDataHelper.kt */
public final class BillUpDataHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001c\u0010H\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0012\"\u0004\bJ\u0010\u0014R\u001c\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006Q"}, mo175978d2 = {"Lcom/didi/soda/bill/BillUpDataHelper$BillUpDataModel;", "", "()V", "abnormalItemOpt", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AbnormalItemOptEntity;", "getAbnormalItemOpt", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AbnormalItemOptEntity;", "setAbnormalItemOpt", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AbnormalItemOptEntity;)V", "addTyingEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillAddTyingEntity;", "getAddTyingEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillAddTyingEntity;", "setAddTyingEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillAddTyingEntity;)V", "couponInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity;", "getCouponInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity;", "setCouponInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/CouponInfoEntity;)V", "cutleryEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/CutleryEntity;", "getCutleryEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/CutleryEntity;", "setCutleryEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/CutleryEntity;)V", "delItem", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillDelItemEntity;", "getDelItem", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillDelItemEntity;", "setDelItem", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillDelItemEntity;)V", "deliveryMethod", "Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "getDeliveryMethod", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;", "setDeliveryMethod", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/DeliveryMethodEntity;)V", "followingInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "getFollowingInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;", "setFollowingInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/FollowingInfoEntity;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "itemsInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillUpdateParams;", "getItemsInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillUpdateParams;", "setItemsInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillUpdateParams;)V", "payChannel", "Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "getPayChannel", "()Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;", "setPayChannel", "(Lcom/didi/soda/customer/foundation/rpc/entity/PayChannelEntity;)V", "rCouponInfo", "getRCouponInfo", "setRCouponInfo", "remark", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/RemarkEntity;", "getRemark", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/RemarkEntity;", "setRemark", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/RemarkEntity;)V", "shopCouponInfo", "getShopCouponInfo", "setShopCouponInfo", "tipFeeInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity;", "getTipFeeInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity;", "setTipFeeInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/cart/TipFeeInfoEntity;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillUpDataHelper.kt */
    public static final class BillUpDataModel {
        private AbnormalItemOptEntity abnormalItemOpt;
        private BillAddTyingEntity addTyingEntity;
        private CouponInfoEntity couponInfo;
        private CutleryEntity cutleryEntity;
        private BillDelItemEntity delItem;
        private DeliveryMethodEntity deliveryMethod;
        private FollowingInfoEntity followingInfo;
        private int index;
        private BillUpdateParams itemsInfo;
        private PayChannelEntity payChannel;
        private CouponInfoEntity rCouponInfo;
        private RemarkEntity remark;
        private CouponInfoEntity shopCouponInfo;
        private TipFeeInfoEntity tipFeeInfo;

        public final int getIndex() {
            return this.index;
        }

        public final void setIndex(int i) {
            this.index = i;
        }

        public final DeliveryMethodEntity getDeliveryMethod() {
            return this.deliveryMethod;
        }

        public final void setDeliveryMethod(DeliveryMethodEntity deliveryMethodEntity) {
            this.deliveryMethod = deliveryMethodEntity;
        }

        public final PayChannelEntity getPayChannel() {
            return this.payChannel;
        }

        public final void setPayChannel(PayChannelEntity payChannelEntity) {
            this.payChannel = payChannelEntity;
        }

        public final RemarkEntity getRemark() {
            return this.remark;
        }

        public final void setRemark(RemarkEntity remarkEntity) {
            this.remark = remarkEntity;
        }

        public final BillUpdateParams getItemsInfo() {
            return this.itemsInfo;
        }

        public final void setItemsInfo(BillUpdateParams billUpdateParams) {
            this.itemsInfo = billUpdateParams;
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

        public final CouponInfoEntity getShopCouponInfo() {
            return this.shopCouponInfo;
        }

        public final void setShopCouponInfo(CouponInfoEntity couponInfoEntity) {
            this.shopCouponInfo = couponInfoEntity;
        }

        public final CouponInfoEntity getCouponInfo() {
            return this.couponInfo;
        }

        public final void setCouponInfo(CouponInfoEntity couponInfoEntity) {
            this.couponInfo = couponInfoEntity;
        }

        public final CouponInfoEntity getRCouponInfo() {
            return this.rCouponInfo;
        }

        public final void setRCouponInfo(CouponInfoEntity couponInfoEntity) {
            this.rCouponInfo = couponInfoEntity;
        }

        public final BillDelItemEntity getDelItem() {
            return this.delItem;
        }

        public final void setDelItem(BillDelItemEntity billDelItemEntity) {
            this.delItem = billDelItemEntity;
        }

        public final AbnormalItemOptEntity getAbnormalItemOpt() {
            return this.abnormalItemOpt;
        }

        public final void setAbnormalItemOpt(AbnormalItemOptEntity abnormalItemOptEntity) {
            this.abnormalItemOpt = abnormalItemOptEntity;
        }

        public final CutleryEntity getCutleryEntity() {
            return this.cutleryEntity;
        }

        public final void setCutleryEntity(CutleryEntity cutleryEntity2) {
            this.cutleryEntity = cutleryEntity2;
        }

        public final BillAddTyingEntity getAddTyingEntity() {
            return this.addTyingEntity;
        }

        public final void setAddTyingEntity(BillAddTyingEntity billAddTyingEntity) {
            this.addTyingEntity = billAddTyingEntity;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/bill/BillUpDataHelper$Companion;", "", "()V", "getUpDataEntity", "Lcom/didi/soda/bill/BillUpDataHelper$BillUpDataModel;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillUpDataHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BillUpDataModel getUpDataEntity(IEntity iEntity) {
            Intrinsics.checkNotNullParameter(iEntity, "entity");
            BillUpDataModel billUpDataModel = new BillUpDataModel();
            if (iEntity instanceof DeliveryMethodEntity) {
                billUpDataModel.setIndex(1);
                billUpDataModel.setDeliveryMethod((DeliveryMethodEntity) iEntity);
            } else if (iEntity instanceof PayChannelEntity) {
                billUpDataModel.setIndex(2);
                billUpDataModel.setPayChannel((PayChannelEntity) iEntity);
            } else if (iEntity instanceof BillUpdateParams) {
                billUpDataModel.setIndex(3);
                billUpDataModel.setItemsInfo((BillUpdateParams) iEntity);
            } else if (iEntity instanceof BillDelItemEntity) {
                billUpDataModel.setIndex(4);
                billUpDataModel.setDelItem((BillDelItemEntity) iEntity);
            } else if (iEntity instanceof TipFeeInfoEntity) {
                billUpDataModel.setIndex(5);
                billUpDataModel.setTipFeeInfo((TipFeeInfoEntity) iEntity);
            } else if (iEntity instanceof RemarkEntity) {
                billUpDataModel.setIndex(6);
                billUpDataModel.setRemark((RemarkEntity) iEntity);
            } else if (iEntity instanceof CouponInfoEntity) {
                CouponInfoEntity couponInfoEntity = (CouponInfoEntity) iEntity;
                int billCouponType = couponInfoEntity.getBillCouponType();
                if (billCouponType == 1) {
                    billUpDataModel.setShopCouponInfo(couponInfoEntity);
                    billUpDataModel.setIndex(7);
                } else if (billCouponType != 101) {
                    billUpDataModel.setIndex(8);
                    billUpDataModel.setCouponInfo(couponInfoEntity);
                } else {
                    billUpDataModel.setRCouponInfo(couponInfoEntity);
                    billUpDataModel.setIndex(11);
                }
            } else if (iEntity instanceof FollowingInfoEntity) {
                billUpDataModel.setIndex(9);
                billUpDataModel.setFollowingInfo((FollowingInfoEntity) iEntity);
            } else if (iEntity instanceof AbnormalItemOptEntity) {
                billUpDataModel.setIndex(10);
                billUpDataModel.setAbnormalItemOpt((AbnormalItemOptEntity) iEntity);
            } else if (iEntity instanceof CutleryEntity) {
                billUpDataModel.setIndex(17);
                billUpDataModel.setCutleryEntity((CutleryEntity) iEntity);
            } else if (!(iEntity instanceof BillAddTyingEntity)) {
                return null;
            } else {
                billUpDataModel.setIndex(18);
                billUpDataModel.setAddTyingEntity((BillAddTyingEntity) iEntity);
            }
            return billUpDataModel;
        }
    }
}
